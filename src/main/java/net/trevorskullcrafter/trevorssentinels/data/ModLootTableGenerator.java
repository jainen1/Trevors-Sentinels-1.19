package net.trevorskullcrafter.trevorssentinels.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) { super(dataOutput); }

    @Override
    public void generate() {
        addDrop(ModBlocks.DIRT_SLAB);
        addDrop(ModBlocks.DIRT_STAIRS);
        addDrop(ModBlocks.COARSE_DIRT_SLAB);
        addDrop(ModBlocks.COARSE_DIRT_STAIRS);
        addDrop(ModBlocks.MOSS_SLAB);
        addDrop(ModBlocks.MOSS_STAIRS);
        addDrop(ModBlocks.COPPER_IRON_BLOCK);
        addDrop(ModBlocks.ROSE_GOLD_BLOCK);
        addDrop(ModBlocks.IRON_GOLD_BLOCK);
        addDrop(ModBlocks.LIGHT_CHAMBER_BLOCK);
        addDrop(ModBlocks.DARK_CHAMBER_BLOCK);

        addDrop(ModBlocks.BATTERY);
        addDrop(ModBlocks.FUSEBOX);
        addDrop(ModBlocks.NUCLEAR_CHARGE);
        addDrop(ModBlocks.URANIUM_BLOCK);
        addDrop(ModBlocks.RED_BUTTON);
        addDrop(ModBlocks.RED_PLATE);
        addDrop(ModBlocks.BLACK_AGILITY_BLOCK);
        addDrop(ModBlocks.BLUE_AGILITY_BLOCK);
        addDrop(ModBlocks.CAUTION_STEEL_BLOCK);
        addDrop(ModBlocks.CHISELED_END_STONE_BRICKS);
        addDrop(ModBlocks.CRACKED_END_STONE_BRICKS);
        addDrop(ModBlocks.END_STONE_BRICK_COLUMN);
        addDrop(ModBlocks.GALINITE_BLOCK);
        addDrop(ModBlocks.GALINITE_PILLAR);
        addDrop(ModBlocks.CHISELED_GALINITE_BLOCK);
        addDrop(ModBlocks.SNOWSTONE);
        addDrop(ModBlocks.SNOWSTONE_SLAB);
        addDrop(ModBlocks.SNOWSTONE_STAIRS);
        addDrop(ModBlocks.SMOOTH_SNOWSTONE);
        addDrop(ModBlocks.SMOOTH_SNOWSTONE_SLAB);
        addDrop(ModBlocks.SMOOTH_SNOWSTONE_STAIRS);
        addDrop(ModBlocks.CHISELED_SNOWSTONE);
        addDrop(ModBlocks.SNOWSTONE_WALL);
        addDrop(ModBlocks.CUT_SNOWSTONE);
        addDrop(ModBlocks.CUT_SNOWSTONE_SLAB);
        addDrop(ModBlocks.ORANGE_AGILITY_BLOCK);
        addDrop(ModBlocks.DARKSTEEL_BLOCK);
        addDrop(ModBlocks.DARKENED_STEEL_BLOCK);
        addDrop(ModBlocks.DATA_BLOCK);
        addDrop(ModBlocks.STEEL_BLOCK);
        addDrop(ModBlocks.STAINLESS_STEEL_BLOCK);
        addDrop(ModBlocks.RUSTED_STEEL_BLOCK);
        addDrop(ModBlocks.WAX_INFUSED_COPPER_BLOCK);
        addDrop(ModBlocks.STEEL_FAN);
        addDrop(ModBlocks.STEEL_LADDER);
        addDrop(ModBlocks.STEEL_LAMP_BLOCK);
        addDrop(ModBlocks.FORGE);
        addDrop(ModBlocks.SUPERFORGE);
        addDrop(ModBlocks.TRANQUIL_ROSE);
        addPottedPlantDrops(ModBlocks.POTTED_TRANQUIL_ROSE);
        addDrop(ModBlocks.SKULLWEED);
        addPottedPlantDrops(ModBlocks.POTTED_SKULLWEED);
        addDrop(ModBlocks.STEEL_SIGN_BLOCK, ModItems.STEEL_SIGN);
        addDrop(ModBlocks.STEEL_WALL_SIGN_BLOCK, ModItems.STEEL_SIGN);
        addDrop(ModBlocks.HOLOGRAPHIC_SIGN_BLOCK, ModItems.HOLOGRAPHIC_SIGN);
        addDrop(ModBlocks.HOLOGRAPHIC_WALL_SIGN_BLOCK, ModItems.HOLOGRAPHIC_SIGN);

        addDrop(ModBlocks.FLESH_BLOCK);
        addDrop(ModBlocks.FLESHY_EYE, silkDrop(ModBlocks.FLESHY_EYE, ModItems.RUINOUS_GAZE));

        addDrop(ModBlocks.BANANA_BUTTON);
        addDrop(ModBlocks.BANANA_DOOR);
        addDrop(ModBlocks.BANANA_FENCE);
        addDrop(ModBlocks.BANANA_FENCE_GATE);
        addDrop(ModBlocks.BANANA_LOG);
        addDrop(ModBlocks.BANANA_PLANKS);
        addDrop(ModBlocks.BANANA_PRESSURE_PLATE);
        addDrop(ModBlocks.BANANA_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_BANANA_SAPLING);
        addDrop(ModBlocks.BANANA_SIGN_BLOCK, ModItems.BANANA_SIGN);
        addDrop(ModBlocks.BANANA_SLAB);
        addDrop(ModBlocks.BANANA_STAIRS);
        addDrop(ModBlocks.BANANA_TRAPDOOR);
        addDrop(ModBlocks.BANANA_WALL_SIGN_BLOCK, ModItems.BANANA_SIGN);
        addDrop(ModBlocks.BANANA_HANGING_SIGN, ModItems.BANANA_HANGING_SIGN);
        addDrop(ModBlocks.BANANA_WALL_HANGING_SIGN, ModItems.BANANA_HANGING_SIGN);
        addDrop(ModBlocks.BANANA_WOOD);
        addDrop(ModBlocks.STRIPPED_BANANA_LOG);
        addDrop(ModBlocks.STRIPPED_BANANA_WOOD);

        addDrop(ModBlocks.CERULII_BUTTON);
        addDrop(ModBlocks.CERULII_DOOR);
        addDrop(ModBlocks.CERULII_FENCE);
        addDrop(ModBlocks.CERULII_FENCE_GATE);
        addDrop(ModBlocks.CERULII_LOG);
        addDrop(ModBlocks.CERULII_PLANKS);
        addDrop(ModBlocks.CERULII_PRESSURE_PLATE);
        addDrop(ModBlocks.CERULII_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_CERULII_SAPLING);
        addDrop(ModBlocks.CERULII_SIGN_BLOCK, ModItems.CERULII_SIGN);
        addDrop(ModBlocks.CERULII_SLAB);
        addDrop(ModBlocks.CERULII_STAIRS);
        addDrop(ModBlocks.CERULII_TRAPDOOR);
        addDrop(ModBlocks.CERULII_WALL_SIGN_BLOCK, ModItems.CERULII_SIGN);
        addDrop(ModBlocks.CERULII_HANGING_SIGN, ModItems.CERULII_HANGING_SIGN);
        addDrop(ModBlocks.CERULII_WALL_HANGING_SIGN, ModItems.CERULII_HANGING_SIGN);
        addDrop(ModBlocks.CERULII_WOOD);
        addDrop(ModBlocks.STRIPPED_CERULII_LOG);
        addDrop(ModBlocks.STRIPPED_CERULII_WOOD);

        addDrop(ModBlocks.CHARRED_OAK_BUTTON);
        addDrop(ModBlocks.CHARRED_OAK_DOOR);
        addDrop(ModBlocks.CHARRED_OAK_FENCE);
        addDrop(ModBlocks.CHARRED_OAK_FENCE_GATE);
        addDrop(ModBlocks.CHARRED_OAK_LOG);
        addDrop(ModBlocks.CHARRED_OAK_PLANKS);
        addDrop(ModBlocks.CHARRED_OAK_PRESSURE_PLATE);
        addDrop(ModBlocks.CHARRED_OAK_SIGN_BLOCK, ModItems.CHARRED_OAK_SIGN);
        addDrop(ModBlocks.CHARRED_OAK_SLAB);
        addDrop(ModBlocks.CHARRED_OAK_STAIRS);
        addDrop(ModBlocks.CHARRED_OAK_TRAPDOOR);
        addDrop(ModBlocks.CHARRED_OAK_WALL_SIGN_BLOCK, ModItems.CHARRED_OAK_SIGN);
        addDrop(ModBlocks.CHARRED_OAK_HANGING_SIGN, ModItems.CHARRED_OAK_HANGING_SIGN);
        addDrop(ModBlocks.CHARRED_OAK_WALL_HANGING_SIGN, ModItems.CHARRED_OAK_HANGING_SIGN);
        addDrop(ModBlocks.CHARRED_OAK_WOOD);
        addDrop(ModBlocks.STRIPPED_CHARRED_OAK_LOG);
        addDrop(ModBlocks.STRIPPED_CHARRED_OAK_WOOD);

        addDrop(ModBlocks.MIDAS_BUTTON);
        addDrop(ModBlocks.MIDAS_DOOR);
        addDrop(ModBlocks.MIDAS_FENCE);
        addDrop(ModBlocks.MIDAS_FENCE_GATE);
        addDrop(ModBlocks.MIDAS_LOG);
        addDrop(ModBlocks.MIDAS_PLANKS);
        addDrop(ModBlocks.MIDAS_PRESSURE_PLATE);
        addDrop(ModBlocks.MIDAS_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_MIDAS_SAPLING);
        addDrop(ModBlocks.MIDAS_SIGN_BLOCK, ModItems.MIDAS_SIGN);
        addDrop(ModBlocks.MIDAS_SLAB);
        addDrop(ModBlocks.MIDAS_STAIRS);
        addDrop(ModBlocks.MIDAS_TRAPDOOR);
        addDrop(ModBlocks.MIDAS_WALL_SIGN_BLOCK, ModItems.MIDAS_SIGN);
        addDrop(ModBlocks.MIDAS_HANGING_SIGN, ModItems.MIDAS_HANGING_SIGN);
        addDrop(ModBlocks.MIDAS_WALL_HANGING_SIGN, ModItems.MIDAS_HANGING_SIGN);
        addDrop(ModBlocks.MIDAS_WOOD);
        addDrop(ModBlocks.STRIPPED_MIDAS_LOG);
        addDrop(ModBlocks.STRIPPED_MIDAS_WOOD);

        addDrop(ModBlocks.YGGDRASIL_BUTTON);
        addDrop(ModBlocks.YGGDRASIL_DOOR);
        addDrop(ModBlocks.YGGDRASIL_FENCE);
        addDrop(ModBlocks.YGGDRASIL_FENCE_GATE);
        addDrop(ModBlocks.YGGDRASIL_LOG);
        addDrop(ModBlocks.YGGDRASIL_PLANKS);
        addDrop(ModBlocks.YGGDRASIL_PRESSURE_PLATE);
        addDrop(ModBlocks.YGGDRASIL_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_YGGDRASIL_SAPLING);
        addDrop(ModBlocks.YGGDRASIL_SIGN_BLOCK, ModItems.YGGDRASIL_SIGN);
        addDrop(ModBlocks.YGGDRASIL_SLAB);
        addDrop(ModBlocks.YGGDRASIL_STAIRS);
        addDrop(ModBlocks.YGGDRASIL_TRAPDOOR);
        addDrop(ModBlocks.YGGDRASIL_WALL_SIGN_BLOCK, ModItems.YGGDRASIL_SIGN);
        addDrop(ModBlocks.YGGDRASIL_HANGING_SIGN, ModItems.YGGDRASIL_HANGING_SIGN);
        addDrop(ModBlocks.YGGDRASIL_WALL_HANGING_SIGN, ModItems.YGGDRASIL_HANGING_SIGN);
        addDrop(ModBlocks.YGGDRASIL_WOOD);
        addDrop(ModBlocks.STRIPPED_YGGDRASIL_LOG);
        addDrop(ModBlocks.STRIPPED_YGGDRASIL_WOOD);

        addDrop(ModBlocks.URANIUM_ORE, oreDrops(ModBlocks.URANIUM_ORE, ModItems.TORBERNITE_CUBE));
    }

    public LootTable.Builder silkDrop(Block silk, Item noSilk){
        return dropsWithSilkTouch(silk, applyExplosionDecay(silk, ItemEntry.builder(noSilk)));
    }
}