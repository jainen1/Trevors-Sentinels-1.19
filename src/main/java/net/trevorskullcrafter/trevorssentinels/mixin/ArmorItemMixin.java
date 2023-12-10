package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.item.ModArmorMaterials;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;
import java.util.List;
import java.util.Objects;

@Mixin(ArmorItem.class)
public abstract class ArmorItemMixin extends NamedItemMixin{
    @Unique private PlayerEntity playerEntity;

    @Unique public void galinite_set_bonus(ItemStack stack, World world, PlayerEntity player){
        giveEffect(player, StatusEffects.NIGHT_VISION, 1, 0, false);
    }
    @Unique public void iron_set_bonus(ItemStack stack, World world, PlayerEntity player){
        giveEffect(player, StatusEffects.RESISTANCE, 1, 0, false);
    }
    @Unique public void transitite_set_bonus(ItemStack stack, World world, PlayerEntity player){
        giveEffect(player, StatusEffects.STRENGTH, 1, 1, false);
    }
    @Unique public void diamond_set_bonus(ItemStack stack, World world, PlayerEntity player){
        giveEffect(player, StatusEffects.LUCK, 1, 0, false);
    }
    @Unique public void netherite_set_bonus(ItemStack stack, World world, PlayerEntity player){
        if(player.isInLava()){
            giveEffect(player, StatusEffects.FIRE_RESISTANCE, 20, 0, false);
            player.addExhaustion(0.1f);
        }
    }
    @Unique public void nuclear_set_bonus(ItemStack stack, World world, PlayerEntity player){
        if(world.getTime() % 20 == 0){ if(player.isSprinting()) giveEffect(player, StatusEffects.SPEED, 40, 2, false);
            else if(player.isSneaking()){
                if(player.hasStatusEffect(StatusEffects.JUMP_BOOST) && Objects.requireNonNull(player.getStatusEffect(StatusEffects.JUMP_BOOST)).getAmplifier() < 5) {
                    giveEffect(player, StatusEffects.JUMP_BOOST, 40,
                            Objects.requireNonNull(player.getStatusEffect(StatusEffects.JUMP_BOOST)).getAmplifier()+1, false);
                }
            }
        }
        if(player.isSprinting()) giveEffect(player, StatusEffects.SPEED, 5, 0, true);
        if(player.isSneaking()){
            giveEffect(player, StatusEffects.JUMP_BOOST, 5, 1, true);
            giveEffect(player, StatusEffects.SPEED, 5, 3, true);
        }
    }
    @Unique public void nanotech_set_bonus(ItemStack stack, World world, PlayerEntity player){
        if(world.getTime() % 5 == 0 && player.getAbsorptionAmount() < 10) {
            if (world.getTime() % 100 == 0) {
                if(!world.isClient()) player.setAbsorptionAmount(player.getAbsorptionAmount() + 1);
                else player.playSound(ModSounds.NOTCH_UP, 0.5f, (player.getAbsorptionAmount() / 10));
            } world.playSoundFromEntity(null, player, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.MASTER,
                    (player.getAbsorptionAmount() / 20) + 0.05f, (player.getAbsorptionAmount() / 10) + 1);
        }
    }

    @Unique public void giveEffect(PlayerEntity player, StatusEffect effect, int duration, int amplifier, boolean show){
        if(!player.hasStatusEffect(effect)) player.addStatusEffect(new StatusEffectInstance(effect, duration, amplifier, show, false, false));
    }

    @Override public void tickHandler(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
        if (entity instanceof PlayerEntity player){
            playerEntity = player;
            if(hasFullSuitOfArmorOn(player) && player.getInventory().getArmorStack(3).getItem() == stack.getItem()) {
                if (correctArmorSet(ModArmorMaterials.GUNMETAL, player) == 4) { galinite_set_bonus(stack, world, player); }
                if (correctArmorSet(ArmorMaterials.IRON, player) == 4) { iron_set_bonus(stack, world, player); }
                if (correctArmorSet(ModArmorMaterials.TRANSITITE, player) == 4) { transitite_set_bonus(stack, world, player); }
                if (correctArmorSet(ArmorMaterials.DIAMOND, player) == 4) { diamond_set_bonus(stack, world, player); }
                if (correctArmorSet(ArmorMaterials.NETHERITE, player) == 4) { netherite_set_bonus(stack, world, player); }
                if (correctArmorSet(ModArmorMaterials.NUCLEAR, player) == 4) { nuclear_set_bonus(stack, world, player); }
                if (correctArmorSet(ModArmorMaterials.JETBLACK, player) == 4) { nanotech_set_bonus(stack, world, player); }
            }
        }
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        ArmorMaterial material = ((ArmorItem) stack.getItem()).getMaterial();
        String tooltipColor = "color.material."+ trevorssentinels.MOD_ID+"."+material.getName();
        String tooltipString = "tooltip.material." + trevorssentinels.MOD_ID + "." + material.getName();
        Color setBonusColor = TextUtil.translationDiffersFromKey(tooltipColor) != null ? Color.decode(Text.translatable(tooltipColor).getString()) : null;
        if(TextUtil.translationDiffersFromKey(tooltipString) != null) {
            if (correctArmorSet(material, playerEntity) == 4) { tooltip.add(TextUtil.coloredText(tooltipString, setBonusColor)); }
            else { tooltip.add(Text.literal("Set bonus inactive!").append(Text.literal(" (" + correctArmorSet(material, playerEntity) + "/4)"))
                    .formatted(Formatting.DARK_GRAY)); }
        } super.appendTooltip(stack, world, tooltip, context, ci);
    }

    //Armor checks. Boots = 0, Leggings = 1, Chestplate = 2, Helmet = 3.
    @Unique public boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        for(int i = 0; i <= 3; i++) if(player.getInventory().getArmorStack(i).isEmpty()) { return false; } return true;
    }

    @Unique public int correctArmorSet(ArmorMaterial material, PlayerEntity player) {
        int num = 0; for(int i = 0; i <= 3; i++) { if (player != null && player.getInventory().getArmorStack(i).getItem() instanceof ArmorItem armorItem
                && armorItem.getMaterial() == material) { num++; }}
        return num;
    }
}