package net.trevorskullcrafter.trevorssentinels.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) { super(output); }

    @Override public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.TORBERNITE_CUBE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.URANIUM_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENERGY_CELL)
                .pattern("#  ").pattern(" $ ").pattern("  #")
                .input('#', ModItems.STEEL_INGOT).input('$', ModItems.TORBERNITE_CUBE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TORBERNITE_CUBE), FabricRecipeProvider.conditionsFromItem(ModItems.TORBERNITE_CUBE))
                .criterion(FabricRecipeProvider.hasItem(ModItems.STEEL_INGOT), FabricRecipeProvider.conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, new Identifier("energy_cell_from_torbernite"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WAX_INFUSED_COPPER_BLOCK)
                .pattern(" # ").pattern("#$#").pattern(" # ")
                .input('#', Items.HONEYCOMB).input('$', Blocks.COPPER_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(Items.HONEYCOMB), FabricRecipeProvider.conditionsFromItem(Items.HONEYCOMB))
                .criterion(FabricRecipeProvider.hasItem(Blocks.COPPER_BLOCK), FabricRecipeProvider.conditionsFromItem(Blocks.COPPER_BLOCK))
                .offerTo(exporter, new Identifier("wax_infused_copper_block"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DARKSTEEL_INGOT)
                .input(ModItems.TRANQUIL_DUST, 4).input(ModItems.ASH, 4).input(Items.IRON_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.TRANQUIL_DUST), FabricRecipeProvider.conditionsFromItem(ModItems.TRANQUIL_DUST))
                .criterion(FabricRecipeProvider.hasItem(ModItems.ASH), FabricRecipeProvider.conditionsFromItem(ModItems.ASH))
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT), FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier("darksteel_ingot"));
        SmithingRecipeJsonBuilder.create(Ingredient.ofItems(Items.COPPER_INGOT), Ingredient.ofItems(Items.IRON_INGOT), RecipeCategory.MISC, ModItems.COPPER_IRON_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT), FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier("copper_iron"));
        SmithingRecipeJsonBuilder.create(Ingredient.ofItems(Items.IRON_INGOT), Ingredient.ofItems(Items.COPPER_INGOT), RecipeCategory.MISC, ModItems.COPPER_IRON_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT), FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("iron_copper"));
        SmithingRecipeJsonBuilder.create(Ingredient.ofItems(Items.GOLD_INGOT), Ingredient.ofItems(Items.IRON_INGOT), RecipeCategory.MISC, ModItems.IRON_GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT), FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier("gold_iron"));
        SmithingRecipeJsonBuilder.create(Ingredient.ofItems(Items.IRON_INGOT), Ingredient.ofItems(Items.GOLD_INGOT), RecipeCategory.MISC, ModItems.IRON_GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT), FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier("iron_gold"));
        SmithingRecipeJsonBuilder.create(Ingredient.ofItems(Items.COPPER_INGOT), Ingredient.ofItems(Items.GOLD_INGOT), RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier("copper_gold"));
        SmithingRecipeJsonBuilder.create(Ingredient.ofItems(Items.GOLD_INGOT), Ingredient.ofItems(Items.COPPER_INGOT), RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier("gold_copper"));
    }
}