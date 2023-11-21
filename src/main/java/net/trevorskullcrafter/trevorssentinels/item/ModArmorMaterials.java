package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SCRAP("scrap", 3, new int[]{1, 1, 2, 1}, 8, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.0f, () -> Ingredient.ofItems(ModItems.SCRAP_METAL_SHARD)),
    //LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.LEATHER)),
    ROSE_GOLD("rose_gold", 8, new int[]{2, 4, 6, 2}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(ModItems.ROSE_GOLD_INGOT)),
    //
    COPPER("copper", 24, new int[]{3, 5, 7, 2}, 4, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, 0.1f, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    GALLIUM("gallium", 3, new int[]{1, 1, 2, 1}, 8, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.0f, () -> Ingredient.ofItems(ModItems.GALLIUM_VIAL)),
    //IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    STEEL("steel", 24, new int[]{3, 5, 7, 2}, 4, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, 0.1f, () -> Ingredient.ofItems(ModItems.STEEL_INGOT)),
    TRANSITITE("transitite", 28, new int[]{3, 6, 8, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.5f, 0.0f, () -> Ingredient.ofItems(ModItems.TRANSITITE_SHARDS)),
    //DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, () -> Ingredient.ofItems(Items.DIAMOND)),
    ALLOY("alloy", 24, new int[]{3, 5, 7, 2}, 4, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, 0.1f, () -> Ingredient.ofItems(ModItems.IMPERIAL_ALLOY_INGOT)),
    GUNMETAL("gunmetal", 14, new int[]{2, 3, 5, 2}, 6, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.1f, () -> Ingredient.ofItems(ModItems.GUNMETAL_INGOT)),
    //NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0f, 0.1f, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));
    DARKSTEEL("darksteel", 39, new int[]{4, 8, 10, 4}, 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5f, 0.4f, () -> Ingredient.ofItems(ModItems.DARKSTEEL_INGOT)),
    NUCLEAR("nuclear", 39, new int[]{4, 8, 10, 4}, 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5f, 0.4f, () -> Ingredient.ofItems(ModItems.TORBERNITE_CUBE)),
    ARMADEI("armadei", 42, new int[]{5, 8, 12, 6}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5f, 0.4f, () -> Ingredient.EMPTY),
    JETBLACK("nanotech", 42, new int[]{5, 8, 12, 6}, 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5f, 0.4f, () -> Ingredient.ofItems(ModItems.TORBERNITE_CUBE)),
    ZENITHIUM("zenithium", 47, new int[]{5, 8, 12, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5f, 0.6f, () -> Ingredient.ofItems(ModItems.ZENITHIUM_CLUSTER));

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};
    private final String name;
    private final int dMulti;
    private final int[] protection;
    private final int enchant;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockRes;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int dMulti, int[] protection, int enchant, SoundEvent equipSound, float toughness, float knockRes, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.dMulti = dMulti;
        this.protection = protection;
        this.enchant = enchant;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockRes = knockRes;
        this.repairIngredient = repairIngredient;
    }

    @Override public int getDurability(ArmorItem.Type type) { return BASE_DURABILITY[type.ordinal()] * this.dMulti; }
    @Override public int getProtection(ArmorItem.Type type) { return protection[type.ordinal()]; }
    @Override public int getEnchantability() { return this.enchant; }
    @Override public SoundEvent getEquipSound() { return this.equipSound; }
    @Override public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
    @Override public String getName() { return trevorssentinels.MOD_ID + ":" + this.name; }
    @Override public float getToughness() { return this.toughness; }
    @Override public float getKnockbackResistance() { return this.knockRes; }
}