package net.trevorskullcrafter.trevorssentinels.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.BetaItems;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.item.ModEffectItems;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(ModBlocks.CAUTION_STEEL_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACK_AGILITY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLUE_AGILITY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_AGILITY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STAINLESS_STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUSTED_STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_FAN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_CHAMBER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DARK_CHAMBER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HOLOBARRIER);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IRON_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COPPER_IRON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAX_INFUSED_COPPER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DARKENED_STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DARKSTEEL_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_END_STONE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GALINITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SNOWSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GALINITE_BLOCK);

        registerWoodType(blockStateModelGenerator, ModBlocks.BANANA_LOG, ModBlocks.BANANA_WOOD, ModBlocks.STRIPPED_BANANA_LOG,
                ModBlocks.STRIPPED_BANANA_WOOD, ModBlocks.BANANA_LEAVES, ModBlocks.BANANA_SAPLING, ModBlocks.POTTED_BANANA_SAPLING, ModBlocks.BANANA_PLANKS,
                ModBlocks.BANANA_HANGING_SIGN, ModBlocks.BANANA_WALL_HANGING_SIGN, ModBlocks.BANANA_PRESSURE_PLATE, ModBlocks.BANANA_DOOR,
                ModBlocks.BANANA_TRAPDOOR);

        registerWoodType(blockStateModelGenerator, ModBlocks.CERULII_LOG, ModBlocks.CERULII_WOOD, ModBlocks.STRIPPED_CERULII_LOG,
                ModBlocks.STRIPPED_CERULII_WOOD, ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SAPLING, ModBlocks.POTTED_CERULII_SAPLING, ModBlocks.CERULII_PLANKS,
                ModBlocks.CERULII_HANGING_SIGN, ModBlocks.CERULII_WALL_HANGING_SIGN, ModBlocks.CERULII_PRESSURE_PLATE, ModBlocks.CERULII_DOOR,
                ModBlocks.CERULII_TRAPDOOR);

        registerWoodType(blockStateModelGenerator, ModBlocks.CHARRED_OAK_LOG, ModBlocks.CHARRED_OAK_WOOD, ModBlocks.STRIPPED_CHARRED_OAK_LOG,
                ModBlocks.STRIPPED_CHARRED_OAK_WOOD, null, null, null, ModBlocks.CHARRED_OAK_PLANKS,
                ModBlocks.CHARRED_OAK_HANGING_SIGN, ModBlocks.CHARRED_OAK_WALL_HANGING_SIGN, ModBlocks.CHARRED_OAK_PRESSURE_PLATE, ModBlocks.CHARRED_OAK_DOOR,
                ModBlocks.CHARRED_OAK_TRAPDOOR);

        registerWoodType(blockStateModelGenerator, ModBlocks.MIDAS_LOG, ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_LOG,
                ModBlocks.STRIPPED_MIDAS_WOOD, ModBlocks.MIDAS_LEAVES, ModBlocks.MIDAS_SAPLING, ModBlocks.POTTED_MIDAS_SAPLING, ModBlocks.MIDAS_PLANKS,
                ModBlocks.MIDAS_HANGING_SIGN, ModBlocks.MIDAS_WALL_HANGING_SIGN, ModBlocks.MIDAS_PRESSURE_PLATE, ModBlocks.MIDAS_DOOR,
                ModBlocks.MIDAS_TRAPDOOR);

        registerWoodType(blockStateModelGenerator, ModBlocks.YGGDRASIL_LOG, ModBlocks.YGGDRASIL_WOOD, ModBlocks.STRIPPED_YGGDRASIL_LOG,
                ModBlocks.STRIPPED_YGGDRASIL_WOOD, null, ModBlocks.YGGDRASIL_SAPLING, ModBlocks.POTTED_YGGDRASIL_SAPLING, ModBlocks.YGGDRASIL_PLANKS,
                ModBlocks.YGGDRASIL_HANGING_SIGN, ModBlocks.YGGDRASIL_WALL_HANGING_SIGN, ModBlocks.YGGDRASIL_PRESSURE_PLATE, ModBlocks.YGGDRASIL_DOOR,
                ModBlocks.YGGDRASIL_TRAPDOOR);
    }

    @Override public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.FLIMSY_GALINITE_HELMET, ModArmory.FLIMSY_GALINITE_CHESTPLATE, ModArmory.FLIMSY_GALINITE_LEGGINGS,
                ModArmory.FLIMSY_GALINITE_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.FLIMSY_GALINITE_SWORD, ModArmory.FLIMSY_GALINITE_DAGGER, ModArmory.FLIMSY_GALINITE_PICKAXE,
                ModArmory.FLIMSY_GALINITE_AXE, ModArmory.FLIMSY_GALINITE_SHOVEL, ModArmory.FLIMSY_GALINITE_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.GALINITE_HELMET, ModArmory.GALINITE_CHESTPLATE, ModArmory.GALINITE_LEGGINGS,
                ModArmory.GALINITE_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.GALINITE_SWORD, ModArmory.GALINITE_DAGGER, ModArmory.GALINITE_PICKAXE,
                ModArmory.GALINITE_CHAINSAW, ModArmory.GALINITE_SHOVEL, ModArmory.GALINITE_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.ROSE_GOLD_HELMET, ModArmory.ROSE_GOLD_CHESTPLATE, ModArmory.ROSE_GOLD_LEGGINGS,
                ModArmory.ROSE_GOLD_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.ROSE_GOLD_SWORD, ModArmory.ROSE_GOLD_DAGGER, ModArmory.ROSE_GOLD_PICKAXE,
                ModArmory.ROSE_GOLD_AXE, ModArmory.ROSE_GOLD_SHOVEL, ModArmory.ROSE_GOLD_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.TRIMETAL_HELMET, ModArmory.TRIMETAL_CHESTPLATE, ModArmory.TRIMETAL_LEGGINGS,
                ModArmory.TRIMETAL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.TRIMETAL_SWORD, ModArmory.TRIMETAL_DAGGER, ModArmory.TRIMETAL_PICKAXE,
                ModArmory.TRIMETAL_AXE, ModArmory.TRIMETAL_SHOVEL, ModArmory.TRIMETAL_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.TRANSITITE_HELMET, ModArmory.TRANSITITE_CHESTPLATE, ModArmory.TRANSITITE_LEGGINGS,
                ModArmory.TRANSITITE_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.TRANSITITE_SWORD, ModArmory.TRANSITITE_DAGGER, ModArmory.TRANSITITE_PICKAXE,
                ModArmory.TRANSITITE_AXE, ModArmory.TRANSITITE_SHOVEL, ModArmory.TRANSITITE_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.DARKSTEEL_HELMET, ModArmory.DARKSTEEL_CHESTPLATE, ModArmory.DARKSTEEL_LEGGINGS,
                ModArmory.DARKSTEEL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.DARKSTEEL_SWORD, ModArmory.DARKSTEEL_DAGGER, ModArmory.DARKSTEEL_PICKAXE,
                ModArmory.DARKSTEEL_AXE, ModArmory.DARKSTEEL_SHOVEL, ModArmory.DARKSTEEL_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.NUCLEAR_HELMET, ModArmory.NUCLEAR_CHESTPLATE, ModArmory.NUCLEAR_LEGGINGS,
                ModArmory.NUCLEAR_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.NUCLEAR_SWORD, ModArmory.NUCLEAR_DAGGER, ModArmory.NUCLEAR_PICKAXE,
                ModArmory.NUCLEAR_AXE, ModArmory.NUCLEAR_SHOVEL, ModArmory.NUCLEAR_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.NANOTECH_HELMET, ModArmory.NANOTECH_CHESTPLATE, ModArmory.NANOTECH_LEGGINGS,
                ModArmory.NANOTECH_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.NANOTECH_SWORD, ModArmory.NANOTECH_DAGGER, ModArmory.NANOTECH_PICKAXE,
                ModArmory.NANOTECH_AXE, ModArmory.NANOTECH_SHOVEL, ModArmory.NANOTECH_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.THANATU_SKULL, ModArmory.THANATU_SHOULDERPADS);

        registerItems(itemModelGenerator, Models.GENERATED, BetaItems.BLACKSMITHS_WELDING_MASK, BetaItems.MAD_SCIENTISTS_LAB_COAT, ModArmory.ZENITHIUM_CHESTPLATE,
                ModArmory.ZENITHIUM_LEGGINGS, ModArmory.SKYHOPPERS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.ZENITHIUM_SWORD, ModArmory.ZENITHIUM_DAGGER, ModArmory.ZENITHIUM_PICKAXE,
                ModArmory.ZENITHIUM_AXE, ModArmory.ZENITHIUM_SHOVEL, ModArmory.ZENITHIUM_HOE, ModArmory.MASTER_SWORD);

        //food
        registerItems(itemModelGenerator, Models.GENERATED, ModItems.ANTIMILK, ModItems.ASH, ModItems.PEARFRUIT, ModItems.MIDAS_FRUIT, ModItems.BANANA,
                ModItems.RED_BANANA, ModItems.BLUE_JAVA_BANANA, ModItems.BANANA_BREAD, ModItems.RED_BANANA_BREAD, ModItems.BLUE_JAVA_BANANA_BREAD, ModItems.BROWNIE,
                ModItems.RICE, ModItems.RICE_CAKE, ModItems.GOLDEN_RICE, ModItems.GOLDEN_RICE_CAKE, ModItems.TORTILLA, ModItems.BURRITO, ModItems.CHORUS_COBBLER,
                ModItems.COLA_CYAN, ModItems.COLA_GREEN, ModItems.COLA_ORANGE, ModItems.MILK_CAN, ModItems.BEETROOT_SOUP_CAN, ModItems.MUSHROOM_STEW_CAN,
                ModItems.RABBIT_STEW_CAN, ModItems.SANDFISH, ModItems.COOKED_SANDFISH, ModItems.DUNE_EEL, ModItems.SMOKED_FISH, ModItems.DUBIOUS_BACON,
                ModItems.FRIED_EGG, ModItems.SUSHI_ROLL);

        //progression materials
        registerItems(itemModelGenerator, Models.GENERATED, ModItems.GALINITE_SHARD, ModItems.GALINITE_INGOT, ModItems.COPPER_IRON_INGOT,
                ModItems.ROSE_GOLD_INGOT, ModItems.IRON_GOLD_INGOT, ModItems.GUNMETAL_INGOT, ModItems.STEEL_INGOT, ModItems.REDSTONE_CRYSTAL, ModItems.BLOOD_DIAMOND,
                ModItems.DARKSTEEL_INGOT, ModItems.TORBERNITE_CUBE, ModItems.FERRAURIUM_DARKSTEEL_INGOT, ModItems.ZENITHIUM_CLUSTER);

        //misc
        registerItems(itemModelGenerator, Models.GENERATED, ModItems.EMPTY_CAN, ModItems.RUINOUS_GAZE, ModItems.ENERGY_CELL, ModItems.NUCLEAR_DETONATOR,
                ModItems.NUCLEAR_ROCKET, BetaItems.JETPACK, ModItems.MUSIC_DISC_ASSASSINATION_UPLOAD, ModItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT,
                ModItems.MUSIC_DISC_ODE_TO_TRANQUILITY, ModItems.MUSIC_DISC_RECITAL);

        itemModelGenerator.register(ModItems.VENDOR_TOKEN, Models.GENERATED);

        //effect items
        registerItems(itemModelGenerator, Models.GENERATED, ModEffectItems.GALINITE_STOMACH, ModEffectItems.ONE_PENCE);
    }

    public void registerWoodType(BlockStateModelGenerator generator, Block LOG, Block WOOD, Block STRIPPED_LOG, Block STRIPPED_WOOD, Block LEAVES, Block SAPLING,
                                 Block POTTED_SAPLING, Block PLANKS, Block HANGING_SIGN, Block WALL_HANGING_SIGN, Block PRESSURE_PLATE, Block DOOR, Block TRAPDOOR){
        if (LOG != null && WOOD != null) generator.registerLog(LOG).log(LOG).wood(WOOD);
        if (STRIPPED_LOG != null && STRIPPED_WOOD != null) generator.registerLog(STRIPPED_LOG).log(STRIPPED_LOG).wood(STRIPPED_WOOD);
        if (SAPLING != null && POTTED_SAPLING != null) generator.registerFlowerPotPlant(SAPLING, POTTED_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        if(STRIPPED_LOG != null && HANGING_SIGN != null && WALL_HANGING_SIGN != null) generator.registerHangingSign(STRIPPED_LOG, HANGING_SIGN, WALL_HANGING_SIGN);
        if(PLANKS != null) generator.registerSimpleCubeAll(PLANKS);
        if(LEAVES != null) generator.registerSingleton(LEAVES, TexturedModel.LEAVES);
        //if(PLANKS != null && PRESSURE_PLATE != null) generator.registerPressurePlate(PRESSURE_PLATE, PLANKS);
        if(DOOR != null) generator.registerDoor(DOOR);
        if(TRAPDOOR != null) generator.registerTrapdoor(TRAPDOOR);
    }

    public void registerItems(ItemModelGenerator itemModelGenerator, Model model, Item... items){
        for (Item item:items) { itemModelGenerator.register(item, model); }
    }
}