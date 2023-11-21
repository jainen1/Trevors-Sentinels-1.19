package net.trevorskullcrafter.trevorssentinels.recipe;

import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.item.custom.PaintPack;
import net.trevorskullcrafter.trevorssentinels.item.custom.ToolSkinnable;

public class ToolSkinRecipe extends SpecialCraftingRecipe {
    public ToolSkinRecipe(CraftingRecipeCategory category) { super(category); }

    @Override public boolean matches(RecipeInputInventory inventory, World world) {
        ItemStack tool = ItemStack.EMPTY; ItemStack skin = ItemStack.EMPTY;
        for(int i = 0; i < inventory.size(); ++i) {
            ItemStack test = inventory.getStack(i);
            if (!test.isEmpty()) {
                if (test.getItem() instanceof ToolSkinnable) {
                    if (!tool.isEmpty()) return false;
                    tool = test;
                } else {
                    if (!(test.getItem() instanceof PaintPack)) return false;
                    skin = test;
                }
            }
        } return !tool.isEmpty() && !skin.isEmpty();
    }

    @Override public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {
        ItemStack tool = ItemStack.EMPTY; ItemStack skin = ItemStack.EMPTY;
        for(int i = 0; i < inventory.size(); ++i) {
            ItemStack test = inventory.getStack(i);
            if (!test.isEmpty()) {
                if (test.getItem() instanceof ToolSkinnable) {
                    if (!tool.isEmpty()) return ItemStack.EMPTY;
                    tool = test;
                } else {
                    if (!(test.getItem() instanceof PaintPack)) return ItemStack.EMPTY;
                    skin = test;
                }
            }
        }
        if (!tool.isEmpty() && !skin.isEmpty()) return ToolSkinnable.newCustomModelStack(tool, ((PaintPack) skin.getItem()).getItemSkinData(tool.getItem()));
        else return ItemStack.EMPTY;
    }

    @Override public boolean fits(int width, int height) { return width * height >= 2; }

    @Override public RecipeSerializer<?> getSerializer() { return RecipeSerializer.ARMOR_DYE; }
}