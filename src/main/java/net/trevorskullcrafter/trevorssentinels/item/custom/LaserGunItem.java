package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.data.EnglishLangGenerator;
import net.trevorskullcrafter.trevorssentinels.entity.custom.LaserEntity;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class LaserGunItem extends Item implements ToolSkinnable {
    Hand lastHand = Hand.OFF_HAND;

    String gunclass; int lasers; float laserSpeed; float laserDivergence; float dualPenalty; float recoil; int laserLifeTime; float laserDamage; int cooldownTime;
    int reloadCooldown; SoundEvent shootSound; SoundEvent reloadSound; int projectileType; StatusEffectInstance[] statusEffectList; int color;

    public LaserGunItem(Settings settings, int lasers, float laserSpeed, float laserDivergence, float dualPenalty, float recoil, int laserLifeTime, float laserDamage,
                        int cooldown, int reloadCooldown, SoundEvent shootSound, SoundEvent reloadSound, int projectileType, int color) {
        super(settings); this.color = color;
        this.lasers = lasers; this.laserSpeed = laserSpeed; this.laserDivergence = laserDivergence; this.dualPenalty = dualPenalty; this.recoil = recoil;
        this.laserLifeTime = laserLifeTime; this.laserDamage = laserDamage; this.cooldownTime = cooldown; this.reloadCooldown = reloadCooldown;
        this.shootSound = shootSound; this.reloadSound = reloadSound; this.projectileType = projectileType;
    }

    public LaserGunItem(Settings settings, int lasers, float laserSpeed, float laserDivergence, float dualPenalty, float recoil, int laserLifeTime, float laserDamage,
                        int cooldown, int reloadCooldown, SoundEvent shootSound, SoundEvent reloadSound, int projectileType, int color, StatusEffectInstance... statusEffectList) {
        super(settings); this.color = color;
        this.lasers = lasers; this.laserSpeed = laserSpeed; this.laserDivergence = laserDivergence; this.dualPenalty = dualPenalty; this.recoil = recoil;
        this.laserLifeTime = laserLifeTime; this.laserDamage = laserDamage; this.cooldownTime = cooldown; this.reloadCooldown = reloadCooldown;
        this.shootSound = shootSound; this.reloadSound = reloadSound; this.projectileType = projectileType; this.statusEffectList = statusEffectList;
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack1 = user.getStackInHand(Hand.MAIN_HAND); ItemStack itemStack2 = user.getStackInHand(Hand.OFF_HAND);
        if(Screen.hasAltDown()){ if(user.getStackInHand(hand) == itemStack1) {
            user.sendMessage(Text.empty().append("Automatic Reloading: ").append(getAutomaticReloading(itemStack1, true) ? Text.literal("ON")
                    .formatted(Formatting.GREEN, Formatting.BOLD) : Text.literal("OFF").formatted(Formatting.RED, Formatting.BOLD)), true);
            world.playSoundFromEntity(null, user, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.PLAYERS, 1.0f, 1.0f); }
        } else if(isDualWielding(user)){
            if(Screen.hasShiftDown()) { reloadGun(itemStack1, world, user); reloadGun(itemStack2, world, user); }
            else { if (lastHand == Hand.OFF_HAND) { shoot(itemStack1, world, user, hand); if(!world.isClient()) lastHand = Hand.MAIN_HAND; }
            else { shoot(itemStack2, world, user, hand); if(!world.isClient()) lastHand = Hand.OFF_HAND; }}
        } else if(hand == Hand.MAIN_HAND || (hand == Hand.OFF_HAND && !(user.getStackInHand(Hand.MAIN_HAND).getItem() instanceof LaserGunItem))){
            if(Screen.hasShiftDown()) reloadGun(user.getStackInHand(hand), world, user);
            else shoot(user.getStackInHand(hand), world, user, hand);
        } return super.use(world, user, hand);
    }

    private boolean isDualWielding(PlayerEntity user){ return user.getStackInHand(Hand.MAIN_HAND).getItem() == user.getStackInHand(Hand.OFF_HAND).getItem(); }

    public void shoot(ItemStack itemStack, World world, PlayerEntity user, Hand hand){
        if(itemStack.getDamage() < itemStack.getMaxDamage() - 1) {
            for (int i = 1; i <= lasers; i++) {
                LaserEntity laser = new LaserEntity(world, user, laserLifeTime, laserSpeed, laserDamage, projectileType, getItemBarColor(itemStack), statusEffectList);
                laser.setVelocity(user, user.getPitch(), user.getYaw(), user.getRoll(), laserSpeed, laserDivergence+(isDualWielding(user)? dualPenalty: 0.0f));
                user.addVelocity(laser.getVelocity().multiply(-recoil * (isDualWielding(user)? 1.5 : 1)));
                world.spawnEntity(laser);
            }
            if (user instanceof ServerPlayerEntity serverPlayerEntity) serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
            if (!world.isClient()) {
                user.fallDistance = (float) Math.abs(user.getVelocity().y) * 4;
                world.playSoundFromEntity(null, user, shootSound, SoundCategory.BLOCKS, Math.min(3.0F, 0.5F + (lasers * 0.5F)), 1.0F);
                itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
                int magazine = itemStack.getMaxDamage() - itemStack.getDamage() - 1;
                user.sendMessage(Text.empty().append(Text.literal(String.valueOf(magazine)).formatted(EnglishLangGenerator.numTooltipFormat(magazine,
                        itemStack.getMaxDamage() - 1))).append(Text.literal(" / " + (itemStack.getMaxDamage() - 1) + " ⚡")
                        .formatted(Formatting.GRAY)), true);
                user.getItemCooldownManager().set(this, cooldownTime);
            }
        }
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(cooldownTime < 3) cooldownTime = 3; getGunclass(); if((stack.getDamage() == stack.getMaxDamage() - 1)
                && getAutomaticReloading(stack, false) && entity instanceof PlayerEntity playerEntity) { reloadGun(stack, world, playerEntity); }}
    @Override public UseAction getUseAction(ItemStack stack) { return UseAction.CROSSBOW; }
    @Override public int getMaxUseTime(ItemStack stack) { return (cooldownTime+1)*(this.getMaxDamage()-1); }

    public void reloadGun(ItemStack itemStack, World world, PlayerEntity user) {
        if (!world.isClient()) {
            itemStack.setDamage(0);user.getItemCooldownManager().set(this, reloadCooldown + (getAutomaticReloading(itemStack, false) ? cooldownTime : 0));
            world.playSoundFromEntity(null, user, reloadSound, SoundCategory.BLOCKS, 3.0F, 0.0F);
        }
    }

    public boolean getAutomaticReloading(ItemStack stack, boolean r){
        if(stack.getSubNbt("trevorssentinels:autoReload") == null){
            NbtCompound nbtData = new NbtCompound(); nbtData.putBoolean("isOn", false); stack.setSubNbt("trevorssentinels:autoReload", nbtData);
        } if(r){
            NbtCompound nbtData = new NbtCompound(); nbtData.putBoolean("isOn", !Objects.requireNonNull(stack.getSubNbt("trevorssentinels:autoReload"))
                    .getBoolean("isOn")); stack.setSubNbt("trevorssentinels:autoReload", nbtData);
        } return Objects.requireNonNull(stack.getSubNbt("trevorssentinels:autoReload")).getBoolean("isOn");
    }

    @Override public boolean isItemBarVisible(ItemStack stack) { return true; }
    @Override public int getItemBarStep(ItemStack stack) { return Math.round(13.0F - (float)stack.getDamage() * 13.0F / (float)stack.getMaxDamage()-1); }
    @Override public int getItemBarColor(ItemStack stack) {
        return (stack.getMaxDamage() - stack.getDamage() -1 > 0)? (color < 0 ? super.getItemBarColor(stack) : color) : Color.BLACK.hashCode();
    }

    public String getGunclass(){
        if(gunclass == null) {
            if (laserDamage < 1) gunclass = "Support";
            else if (laserDamage >= 5 && getMaxDamage() <= 5 && lasers == 1 && laserSpeed >= 2) gunclass = "Sniper";
            else if (lasers >= 6) gunclass = "Shotgun";
            else if (cooldownTime + 1 <= 4) gunclass = "Automatic";
            else gunclass = "Pistol";
        } return gunclass; }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(itemStack, world, tooltip, context); int magazine = itemStack.getMaxDamage() - itemStack.getDamage() -1;
        //class + magazine
        tooltip.add(Text.literal("Class: "+ getGunclass()));
        tooltip.add(Text.empty().append(Text.literal(String.valueOf(magazine)).formatted(EnglishLangGenerator.numTooltipFormat(magazine,
                itemStack.getMaxDamage()-1))).append(Text.literal(" / " + (itemStack.getMaxDamage()-1)+" ⚡ ").formatted(Formatting.GRAY))
                .append(Text.literal("△").formatted(getAutomaticReloading(itemStack, false)? Formatting.GREEN : Formatting.RED, Formatting.BOLD)));
        //stats
        double firingRate = 20.0/(cooldownTime+1);
        Text secondParameter;
        DecimalFormat df = new DecimalFormat("#.##");
        if(firingRate <= 1) secondParameter = Text.literal(df.format(laserSpeed)+" →").formatted(EnglishLangGenerator.numTooltipFormat(laserSpeed, 4));
        else secondParameter = Text.literal(firingRate+" \uD83D\uDD25").formatted(EnglishLangGenerator.numTooltipFormat(firingRate, 5));
        tooltip.add(Text.empty().append(Text.literal(lasers+" ☄").formatted(EnglishLangGenerator.numTooltipFormat(lasers, 8)))
                .append(column()).append(secondParameter).append(column()).append(Text.literal(Math.abs(laserDamage)+(laserDamage < 1 ? " ✚" : " ☠"))
                        .formatted(EnglishLangGenerator.numTooltipFormat(Math.abs(laserDamage), 20))));
        //effect
        if(statusEffectList != null) { if(Screen.hasShiftDown()) for (StatusEffectInstance statusEffectInstance : statusEffectList) {
                    MutableText mutableText = Text.translatable(statusEffectInstance.getTranslationKey());
                    StatusEffectCategory statusEffectCategory = statusEffectInstance.getEffectType().getCategory();
                    if(statusEffectInstance.getAmplifier() > 0) mutableText = Text.translatable("potion.withAmplifier", mutableText,
                            Text.translatable("potion.potency." + statusEffectInstance.getAmplifier()));
                    if(statusEffectInstance.getDuration() > 20) mutableText = Text.translatable("potion.withDuration", mutableText,
                            StatusEffectUtil.durationToString(statusEffectInstance, 1.0f));
                    tooltip.add(Text.empty().append(statusEffectCategory == StatusEffectCategory.BENEFICIAL? "☀ " : statusEffectCategory ==
                                    StatusEffectCategory.NEUTRAL? "☯ " : "☠ ").append(mutableText)
                            .formatted(statusEffectCategory == StatusEffectCategory.BENEFICIAL? Formatting.GREEN : statusEffectCategory ==
                                    StatusEffectCategory.NEUTRAL? Formatting.YELLOW : Formatting.RED)); }
        else tooltip.add(Text.empty().append(Text.literal("SHIFT").formatted(Formatting.YELLOW)).append(Text.literal(" to show status effects.")
                    .formatted(Formatting.DARK_GRAY)));
        }
    }

    private Text column(){ return Text.literal(" | ").formatted(Formatting.DARK_GRAY); }
}