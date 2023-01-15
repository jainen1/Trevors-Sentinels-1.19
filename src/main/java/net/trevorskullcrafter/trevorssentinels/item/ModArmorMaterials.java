package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    FLIMSY_SENTINUM("flimsy_sentinum", 3, new int[]{1, 1, 2, 1}, 8,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.0f, () -> Ingredient.ofItems(ModItems.SENTINUM_SHARD)),
    //LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.LEATHER)),
    BONE("bone", 5, new int[]{1, 2, 3, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.BONE)),
    //CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    SENTINUM("sentinum", 14, new int[]{2, 3, 5, 2}, 6,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.1f, () -> Ingredient.ofItems(ModItems.SENTINUM_INGOT)),
    ROSE_GOLD("rose_gold", 8, new int[]{1, 4, 6, 2}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(ModItems.ROSE_GOLD_INGOT)),
    //IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    TRIMETAL("trimetal", 24, new int[]{2, 5, 7, 2}, 7,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, 0.1f, () -> Ingredient.ofItems(ModItems.STEEL_SHEET, ModItems.COPPER_IRON_INGOT)),
    //DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f, () -> Ingredient.ofItems(Items.DIAMOND)),
    DARKSTEEL("darksteel", 35, new int[]{3, 6, 8, 3}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.5f, 0.2f, () -> Ingredient.ofItems(ModItems.BLOOD_DIAMOND)),
    //NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0f, 0.1f, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));
    URANIUM("uranium", 42, new int[]{4, 7, 9, 3}, 0,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5f, 0.4f, () -> Ingredient.ofItems(ModItems.URANIUM_CRYSTAL)),
    ZENITHIUM("zenithite", 47, new int[]{5, 8, 12, 4}, 0,
    SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5f, 0.6f, () -> Ingredient.ofItems(ModItems.URANIUM_CRYSTAL));

    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }
}