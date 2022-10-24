package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial{
        FLIMSY_SENTINUM(0, 37, 1.5f, 0.0f, 8, () -> Ingredient.ofItems(ModItems.SENTINUM_SHARD)),
        SENTINUM(1, 131, 4.0f, 0.5f, 6, () -> Ingredient.ofItems(ModBlocks.SENTINUM_BLOCK)),
        ROSE_GOLD(1, 94, 14.0f, 0.0f, 25, () -> Ingredient.ofItems(ModItems.ROSE_GOLD_INGOT)),
        TRIMETAL(3, 532, 6.0f, 2.5f, 7, () -> Ingredient.ofItems(ModItems.STEEL_SHEET, ModItems.COPPER_IRON_INGOT)),
        DARKSTEEL(4, 1738, 9.0f, 5.0f, 12, () -> Ingredient.ofItems(ModItems.BLOOD_DIAMOND)),
        URANIUM(5, 2642, 11.0f, 6.5f, 0, () -> Ingredient.ofItems(ModItems.URANIUM_CRYSTAL)),
        ZENITHIUM(6, 3333, 13.0f, 8f, 0, () -> Ingredient.ofItems(ModItems.URANIUM_CRYSTAL));

        private final int miningLevel;
        private final int itemDurability;
        private final float miningSpeed;
        private final float attackDamage;
        private final int enchantability;
        private final Supplier<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

        @Override
        public int getDurability() {
        return this.itemDurability;
    }

        @Override
        public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

        @Override
        public float getAttackDamage() {
        return this.attackDamage;
    }

        @Override
        public int getMiningLevel() {
        return this.miningLevel;
    }

        @Override
        public int getEnchantability() {
        return this.enchantability;
    }

        @Override
        public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}