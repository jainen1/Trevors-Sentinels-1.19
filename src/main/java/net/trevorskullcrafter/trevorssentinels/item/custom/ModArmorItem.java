package net.trevorskullcrafter.trevorssentinels.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.trevorskullcrafter.trevorssentinels.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.util.ColoredTextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()).put(ModArmorMaterials.SENTINUM,
                    new StatusEffectInstance(StatusEffects.NIGHT_VISION, 50, 0, false, false, false)).build();
    public String tooltipText;
    public boolean doDashes;
    public Text tooltipDashes;
    boolean halfDash;
    public String dashes = "";
    public String color;
    public Text name;
    public ModArmorItem(String color, ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
        this.color = color;
        this.doDashes = false;
    }

    public ModArmorItem(String color, boolean doDashes, ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
        this.color = color;
        this.doDashes = doDashes;
    }

    @Override
    public Text getName(ItemStack stack) {
        if(name == null) name = ColoredTextUtil.getColoredText(getTranslationKey(stack), color);
        return name;
    }

    public Text getSecondaryText(ItemStack stack, String string){
        if(tooltipDashes == null) tooltipDashes = ColoredTextUtil.getColoredText(string, getName(stack).getStyle());
        return tooltipDashes;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (this.tooltipText == null) this.tooltipText = Util.createTranslationKey("tooltip.item", Registries.ITEM.getId(this));
        if(!tooltipText.equals(Text.translatable(tooltipText).getString()) || doDashes) {
            if(!tooltipText.equals(Text.translatable(tooltipText).getString())) tooltip.add(Text.translatable(tooltipText).formatted(Formatting.ITALIC));
            if(dashes.equals("")){
                for(int i = 0; i < getName(stack).getString().length(); i++){
                    if(getName(stack).getString().charAt(i) != ' '
                            && getName(stack).getString().charAt(i) != 'i'
                            && getName(stack).getString().charAt(i) != 't'){
                        dashes = dashes + "-";
                    }else{
                        if(!halfDash){
                            halfDash = true;
                        }else{
                            dashes = dashes + "-";
                            halfDash = false;
                        }
                    }
                }
            }
            tooltip.add(getSecondaryText(stack, dashes));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;

                if (hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));

            // if(new Random().nextFloat() > 0.6f) { // 40% of damaging the armor! Possibly!
            //     player.getInventory().damageArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
            // }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        if (player.getInventory().getArmorStack(2).getItem() != Items.ELYTRA) {
            ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
            ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
            ArmorItem breastplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
            ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

            return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                    leggings.getMaterial() == material && boots.getMaterial() == material;
        } else {
            return false;
        }
    }
}