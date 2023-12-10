package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.custom.BulletEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.GasEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.LaserEntity;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class GunItem extends Item implements ToolSkinnable {
    Hand lastHand = Hand.OFF_HAND;

    String gunclass; int lasers; float laserSpeed; float divergence; float dualPenalty; float recoil; int cooldownTime;
    int reloadCooldown; SoundEvent shootSound; SoundEvent reloadSound; int lifetime; float damage; int type; Color color; StatusEffectInstance[] effects;

    public GunItem(Settings settings, int lasers, float laserSpeed, float divergence, float dualPenalty, float recoil, int cooldown, int reloadCooldown, SoundEvent shootSound, SoundEvent reloadSound, int lifetime, float damage, int type, Color color, StatusEffectInstance... effects) {
        super(settings); this.lasers = lasers; this.laserSpeed = laserSpeed; this.divergence = divergence; this.dualPenalty = dualPenalty; this.recoil = recoil;
        this.cooldownTime = cooldown; this.reloadCooldown = reloadCooldown; this.shootSound = shootSound; this.reloadSound = reloadSound; this.lifetime = lifetime;
        this.damage = damage; this.type = type; this.color = color; this.effects = effects;
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        if(isDualWielding(user)) {
            if (lastHand == Hand.OFF_HAND) { shoot(user.getMainHandStack(), world, user, hand); if(!world.isClient()) lastHand = Hand.MAIN_HAND; }
            else { shoot(user.getOffHandStack(), world, user, hand); if(!world.isClient()) lastHand = Hand.OFF_HAND; }
        } else if(hand == Hand.MAIN_HAND || (hand == Hand.OFF_HAND && !(user.getStackInHand(Hand.MAIN_HAND).getItem() instanceof GunItem))){
            shoot(user.getStackInHand(hand), world, user, hand);
        } return super.use(world, user, hand);
    }

    public void shoot(ItemStack stack, World world, PlayerEntity user, Hand hand){
        if(stack.getDamage() < stack.getMaxDamage() - 1) {
            for (int i = 1; i <= lasers; i++) { launch(stack, world, user); }
            if (user instanceof ServerPlayerEntity serverPlayerEntity) { serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(stack.getItem())); }
            if (!world.isClient()) {
                user.fallDistance = (float) Math.abs(user.getVelocity().y) * 4;
                world.playSoundFromEntity(null, user, shootSound, SoundCategory.BLOCKS, Math.min(3.0F, 0.5F + (lasers * 0.5F)), 1.0F);
                stack.damage(1, user, p -> p.sendToolBreakStatus(hand));
                int magazine = stack.getMaxDamage() - stack.getDamage() - 1;
                user.sendMessage(Text.empty().append(Text.literal(String.valueOf(magazine)).formatted(TextUtil.quotientToolTipFormatting(magazine,
                        stack.getMaxDamage() - 1))).append(Text.literal(" / " + (stack.getMaxDamage() - 1) + " ⚡").formatted(Formatting.GRAY)), true);
                user.getItemCooldownManager().set(this, cooldownTime);
            }
        }
    }

    public void launch(ItemStack stack, World world, PlayerEntity user){
        LaserEntity laser;
        switch(type){
            case 2 -> laser = new GasEntity(ModEntities.GAS, world, user, lifetime, laserSpeed, damage, getItemBarColor(stack), effects);
            case 3 -> laser = new BulletEntity(ModEntities.BULLET, world, user, lifetime, laserSpeed, damage, getItemBarColor(stack), effects);
            default -> laser = new LaserEntity(ModEntities.LASER, world, user, lifetime, laserSpeed, damage, getItemBarColor(stack), effects);
        }
        laser.setVelocity(user, user.getPitch(), user.getYaw(), user.getRoll(), laserSpeed, divergence+(isDualWielding(user)? dualPenalty: 0.0f));
        user.addVelocity(laser.getVelocity().multiply(-recoil * (isDualWielding(user)? 1.3 : 1.1)));
        world.spawnEntity(laser);
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(cooldownTime < 3) { cooldownTime = 3; if((stack.getDamage() == stack.getMaxDamage() - 1)
                && getAutomaticReloading(stack, false) && entity instanceof PlayerEntity playerEntity) { reloadGun(stack, world, playerEntity); }}
    }

    public void reloadGun(ItemStack itemStack, World world, PlayerEntity user) {
        if (!world.isClient()) {
            itemStack.setDamage(0); user.getItemCooldownManager().set(this, reloadCooldown + (getAutomaticReloading(itemStack, false) ? cooldownTime : 0));
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

    public String getGunclass(){
        if(gunclass == null) {
            gunclass = switch(type){
                case 2 -> "Gas" + " ";
                case 3 -> "Slug" + " ";
                default -> "Laser" + " ";
            };

            if (damage < 1) { gunclass += "Support"; }
            else if (damage >= 5 && getMaxDamage() <= 5 && lasers == 1 && laserSpeed >= 2) { gunclass += "Sniper"; }
            else if (lasers >= 6) { gunclass += "Shotgun"; }
            else if (cooldownTime + 1 <= 4) { gunclass += "Rifle"; }
            else { gunclass += "Pistol"; }
        } return gunclass;
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        int magazine = itemStack.getMaxDamage() - itemStack.getDamage() -1;
        //class + magazine
        tooltip.add(Text.literal(getGunclass()));
        tooltip.add(Text.empty().append(Text.literal(String.valueOf(magazine)).formatted(TextUtil.quotientToolTipFormatting(magazine, itemStack.getMaxDamage()-1)))
                .append(Text.literal(" / " + (itemStack.getMaxDamage()-1)+" ⚡ ").formatted(Formatting.GRAY))
                .append(Text.literal("△").formatted(getAutomaticReloading(itemStack, false)? Formatting.GREEN : Formatting.RED, Formatting.BOLD)));
        //stats
        double firingRate = 20.0/(cooldownTime+1);
        Text secondParameter;
        DecimalFormat df = new DecimalFormat("#.##");
        if(firingRate <= 1) secondParameter = Text.literal(df.format(laserSpeed)+" →").formatted(TextUtil.quotientToolTipFormatting(laserSpeed, 4));
        else secondParameter = Text.literal(firingRate+" \uD83D\uDD25").formatted(TextUtil.quotientToolTipFormatting(firingRate, 5));
        tooltip.add(Text.empty().append(Text.literal(lasers+" ☄").formatted(TextUtil.quotientToolTipFormatting(lasers, 8)))
                .append(column()).append(secondParameter).append(column()).append(Text.literal(Math.abs(damage)+(damage < 1 ? " ✚" : " ☠"))
                        .formatted(TextUtil.quotientToolTipFormatting(Math.abs(damage), 20))));
        //effect
        if(effects.length > 0) { if(Screen.hasShiftDown()) {
            for (StatusEffectInstance statusEffectInstance : effects) {
                StatusEffectCategory statusEffectCategory = statusEffectInstance.getEffectType().getCategory();
                tooltip.add(Text.empty().append(statusEffectCategory == StatusEffectCategory.BENEFICIAL ? "☀ " :
                                statusEffectCategory == StatusEffectCategory.NEUTRAL ? "☯ " : "☠ ").append(TextUtil.potionText(statusEffectInstance, false))
                        .formatted(statusEffectCategory == StatusEffectCategory.BENEFICIAL ? Formatting.GREEN :
                                statusEffectCategory == StatusEffectCategory.NEUTRAL ? Formatting.YELLOW : Formatting.RED)); }
        } else { tooltip.add(Text.empty().append(Text.literal("SHIFT").formatted(Formatting.YELLOW)).append(Text.literal(" to show status effects.")
                .formatted(Formatting.DARK_GRAY))); }}
        super.appendTooltip(itemStack, world, tooltip, context);
    }

    public boolean isDualWielding(PlayerEntity user){ return user.getStackInHand(Hand.MAIN_HAND).getItem() == user.getStackInHand(Hand.OFF_HAND).getItem(); }
    private Text column(){ return Text.literal(" | ").formatted(Formatting.DARK_GRAY); }
    @Override public boolean isItemBarVisible(ItemStack stack) { return true; }
    @Override public int getItemBarStep(ItemStack stack) { return Math.round(13.0F - (float)stack.getDamage() * 13.0F / (float)stack.getMaxDamage()-1); }
    @Override public int getItemBarColor(ItemStack stack) { return ((stack.getMaxDamage() - stack.getDamage() -1 > 0)? color : Color.BLACK).getRGB(); }
    @Override public UseAction getUseAction(ItemStack stack) { return UseAction.CROSSBOW; }
    @Override public int getMaxUseTime(ItemStack stack) { return (cooldownTime+1)*(this.getMaxDamage()-1); }
}