package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial{
        FLIMSY_GALINITE(0, 37, 1.5f, 1.0f, 8, () -> Ingredient.ofItems(ModItems.GALINITE_SHARD)),
        GALINITE(1, 131, 4.0f, 1.0f, 6, () -> Ingredient.ofItems(ModItems.GALINITE_INGOT)),
        ROSE_GOLD(1, 94, 14.0f, 1.0f, 8, () -> Ingredient.ofItems(ModItems.ROSE_GOLD_INGOT)),
        TRIMETAL(2, 532, 6.0f, 2.5f, 4, () -> Ingredient.ofItems(ModItems.GUNMETAL_INGOT, ModItems.COPPER_IRON_INGOT)),
        TRANSITITE(2, 1028, 7.0f, 3.0f, 9, () -> Ingredient.ofItems(ModItems.TRANSITITE_SHARDS)),
        DARKSTEEL(5, 1738, 9.0f, 5.0f, 17, () -> Ingredient.ofItems(ModItems.DARKSTEEL_INGOT)),
        NUCLEAR(5, 2642, 11.0f, 6.5f, 0, () -> Ingredient.ofItems(ModItems.TORBERNITE_CUBE)),
        ARMADEI(5, 1738, 9.0f, 5.0f, 20, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
        NANOTECH(5, 2642, 11.0f, 6.5f, 0, () -> Ingredient.ofItems(ModItems.TORBERNITE_CUBE)),
        ZENITHIUM(6, 3333, 13.0f, 8f, 10, () -> Ingredient.ofItems(ModItems.ZENITHIUM_CLUSTER));

        private final int miningLevel;
        private final int itemDurability;
        private final float miningSpeed;
        private final float attackDamage;
        private final int enchantability;
        private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override public int getDurability() { return this.itemDurability; }
    @Override public float getMiningSpeedMultiplier() { return this.miningSpeed; }
    @Override public float getAttackDamage() { return this.attackDamage; }
    @Override public int getMiningLevel() { return this.miningLevel; }
    @Override public int getEnchantability() { return this.enchantability; }
    @Override public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}