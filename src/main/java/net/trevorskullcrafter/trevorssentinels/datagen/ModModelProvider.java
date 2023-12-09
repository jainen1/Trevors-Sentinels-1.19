package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.BetaItems;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.item.ModEffectItems;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override public void generateBlockStateModels(BlockStateModelGenerator blockStateGenerator) {
        blockStateGenerator.registerLog(ModBlocks.CAUTION_STEEL_BLOCK);

        blockStateGenerator.registerSimpleCubeAll(ModBlocks.NUCLEAR_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.NUCLEAR_ORE);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.BLACK_AGILITY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.BLUE_AGILITY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_AGILITY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.STAINLESS_STEEL_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.RUSTED_STEEL_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.STEEL_FAN);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_CHAMBER_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.DARK_CHAMBER_BLOCK);

        blockStateGenerator.registerSimpleCubeAll(ModBlocks.IRON_GOLD_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.COPPER_IRON_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.ROSE_GOLD_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.WAX_INFUSED_COPPER_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.DARKENED_STEEL_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.DARKSTEEL_BLOCK);

        blockStateGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_END_STONE_BRICKS);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GALINITE_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SNOWSTONE);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.GALINITE_BLOCK);

        BlockStateModelGenerator.BlockTexturePool steelPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.STEEL_BLOCK);
        steelPool.family(ModBlocks.STEEL_FAMILY);

        BlockStateModelGenerator.BlockTexturePool smooth_snowstonePool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_SNOWSTONE);
        smooth_snowstonePool.stairs(ModBlocks.SMOOTH_SNOWSTONE_STAIRS);
        smooth_snowstonePool.slab(ModBlocks.SMOOTH_SNOWSTONE_SLAB);
        smooth_snowstonePool.wall(ModBlocks.SMOOTH_SNOWSTONE_WALL);

        registerWoodType(blockStateGenerator, ModBlocks.VIRIDESCENT_LOG, ModBlocks.VIRIDESCENT_WOOD, ModBlocks.STRIPPED_VIRIDESCENT_LOG, ModBlocks.STRIPPED_VIRIDESCENT_WOOD,
                ModBlocks.VIRIDESCENT_LEAVES, ModBlocks.VIRIDESCENT_SAPLING, ModBlocks.POTTED_VIRIDESCENT_SAPLING);
        BlockStateModelGenerator.BlockTexturePool viridescentPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.VIRIDESCENT_PLANKS);
        viridescentPool.family(ModBlocks.VIRIDESCENT_FAMILY);

        registerWoodType(blockStateGenerator, ModBlocks.CERULII_LOG, ModBlocks.CERULII_WOOD, ModBlocks.STRIPPED_CERULII_LOG, ModBlocks.STRIPPED_CERULII_WOOD,
                ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SAPLING, ModBlocks.POTTED_CERULII_SAPLING);
        BlockStateModelGenerator.BlockTexturePool ceruliiPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.CERULII_PLANKS);
        ceruliiPool.family(ModBlocks.CERULII_FAMILY);

        registerWoodType(blockStateGenerator, ModBlocks.CHARRED_LOG, ModBlocks.CHARRED_WOOD, ModBlocks.STRIPPED_CHARRED_LOG, ModBlocks.STRIPPED_CHARRED_WOOD,
                null, null, null);
        BlockStateModelGenerator.BlockTexturePool charredPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.CHARRED_PLANKS);
        charredPool.family(ModBlocks.CHARRED_FAMILY);

        registerWoodType(blockStateGenerator, ModBlocks.MIDAS_LOG, ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_WOOD,
                ModBlocks.MIDAS_LEAVES, ModBlocks.MIDAS_SAPLING, ModBlocks.POTTED_MIDAS_SAPLING);
        BlockStateModelGenerator.BlockTexturePool midasPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.MIDAS_PLANKS);
        midasPool.family(ModBlocks.MIDAS_FAMILY);

        registerWoodType(blockStateGenerator, ModBlocks.YGGDRASIL_LOG, ModBlocks.YGGDRASIL_WOOD, ModBlocks.STRIPPED_YGGDRASIL_LOG, ModBlocks.STRIPPED_YGGDRASIL_WOOD,
                null, ModBlocks.YGGDRASIL_SAPLING, ModBlocks.POTTED_YGGDRASIL_SAPLING);
        BlockStateModelGenerator.BlockTexturePool yggdrasilPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.YGGDRASIL_PLANKS);
        yggdrasilPool.family(ModBlocks.YGGDRASIL_FAMILY);
    }

    private TextureMap hardLightTextureMap(Block block) {
        return (new TextureMap()).put(TextureKey.of("base"), new Identifier(trevorssentinels.MOD_ID, "hard_light_base"))
                .put(TextureKey.of("overlay"), new Identifier(trevorssentinels.MOD_ID, "hard_light_overlay"));
    }

    @Override public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.SCRAP_HELMET, ModArmory.SCRAP_CHESTPLATE, ModArmory.SCRAP_LEGGINGS,
                ModArmory.SCRAP_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.SCRAP_SWORD, ModArmory.SCRAP_DAGGER, ModArmory.SCRAP_PICKAXE,
                ModArmory.SCRAP_AXE, ModArmory.SCRAP_SHOVEL, ModArmory.SCRAP_HOE);

        //itemModelGenerator.registerArmor()
        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.GALLIUM_HELMET, ModArmory.GALLIUM_CHESTPLATE, ModArmory.GALLIUM_LEGGINGS,
                ModArmory.GALLIUM_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.GALLIUM_SWORD, ModArmory.GALLIUM_DAGGER, ModArmory.GALLIUM_PICKAXE,
                ModArmory.GALLIUM_AXE, ModArmory.GALLIUM_SHOVEL, ModArmory.GALLIUM_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.SPACEFARERS_HELMET, ModArmory.SPACEFARERS_CHESTPLATE, ModArmory.SPACEFARERS_LEGGINGS,
                ModArmory.SPACEFARERS_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.SPACEFARERS_SWORD, ModArmory.SPACEFARERS_DAGGER, ModArmory.SPACEFARERS_PICKAXE,
                ModArmory.GALLIUM_CHAINSAW, ModArmory.SPACEFARERS_SHOVEL, ModArmory.SPACEFARERS_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.ROSE_GOLD_HELMET, ModArmory.ROSE_GOLD_CHESTPLATE, ModArmory.ROSE_GOLD_LEGGINGS,
                ModArmory.ROSE_GOLD_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.ROSE_GOLD_SWORD, ModArmory.ROSE_GOLD_DAGGER, ModArmory.ROSE_GOLD_PICKAXE,
                ModArmory.ROSE_GOLD_AXE, ModArmory.ROSE_GOLD_SHOVEL, ModArmory.ROSE_GOLD_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.TRIMETAL_HELMET, ModArmory.TRIMETAL_CHESTPLATE, ModArmory.TRIMETAL_LEGGINGS,
                ModArmory.TRIMETAL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.TRIMETAL_SWORD, ModArmory.TRIMETAL_DAGGER, ModArmory.TRIMETAL_PICKAXE,
                ModArmory.TRIMETAL_AXE, ModArmory.TRIMETAL_SHOVEL, ModArmory.TRIMETAL_HOE);

        registerItems(itemModelGenerator, Models.GENERATED, ModArmory.IMPERIAL_HELMET, ModArmory.IMPERIAL_CHESTPLATE, ModArmory.IMPERIAL_LEGGINGS,
                ModArmory.IMPERIAL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.IMPERIAL_SWORD, ModArmory.IMPERIAL_DAGGER, ModArmory.IMPERIAL_PICKAXE,
                ModArmory.IMPERIAL_AXE, ModArmory.IMPERIAL_SHOVEL, ModArmory.IMPERIAL_HOE);

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
                ModArmory.ZENITHIUM_LEGGINGS, ModArmory.ZENITHIUM_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, ModArmory.ZENITHIUM_SWORD, ModArmory.ZENITHIUM_DAGGER, ModArmory.ZENITHIUM_PICKAXE,
                ModArmory.ZENITHIUM_AXE, ModArmory.ZENITHIUM_SHOVEL, ModArmory.ZENITHIUM_HOE, ModArmory.MASTER_SWORD);

        //food
        registerItems(itemModelGenerator, Models.GENERATED, ModItems.ANTIMILK, ModItems.ASH, ModItems.PEARFRUIT, ModItems.MIDAS_FRUIT, ModItems.BANANA,
                ModItems.RED_BANANA, ModItems.BLUE_JAVA_BANANA, ModItems.BANANA_BREAD, ModItems.RED_BANANA_BREAD, ModItems.BLUE_JAVA_BANANA_BREAD, ModItems.BROWNIE,
                ModItems.RICE_SEEDS, ModItems.RICE_CAKE, ModItems.GOLDEN_RICE_SEEDS, ModItems.GOLDEN_RICE_CAKE, ModItems.TORTILLA, ModItems.BURRITO, ModItems.CHORUS_COBBLER,
                ModItems.COLA_CYAN, ModItems.COLA_GREEN, ModItems.COLA_ORANGE, ModItems.MILK_CAN, ModItems.BEETROOT_SOUP_CAN, ModItems.MUSHROOM_STEW_CAN,
                ModItems.RABBIT_STEW_CAN, ModItems.SANDFISH, ModItems.COOKED_SANDFISH, ModItems.DUNE_EEL, ModItems.SMOKED_FISH, ModItems.DUBIOUS_BACON,
                ModItems.FRIED_EGG, ModItems.SUSHI_ROLL);

        //progression materials
        registerItems(itemModelGenerator, Models.GENERATED, ModItems.SCRAP_METAL_SHARD, ModItems.COPPER_IRON_INGOT, ModItems.ROSE_GOLD_INGOT, ModItems.IMPERIAL_ALLOY_INGOT,
                ModItems.GUNMETAL_INGOT, ModItems.GALLIUM_VIAL, ModItems.STEEL_INGOT, ModItems.REDSTONE_CRYSTAL, ModItems.BLOOD_DIAMOND, ModItems.DARKSTEEL_INGOT,
                ModItems.TORBERNITE_CUBE, ModItems.FERRAURIUM_DARKSTEEL_INGOT, ModItems.ZENITHIUM_CLUSTER);

        //misc
        registerItems(itemModelGenerator, Models.GENERATED, ModItems.EMPTY_CAN, ModItems.RUINOUS_GAZE, ModItems.ENERGY_CELL, ModItems.NUCLEAR_DETONATOR,
                ModItems.NUCLEAR_ROCKET, BetaItems.JETPACK, ModItems.MUSIC_DISC_ASSASSINATION_UPLOAD, ModItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT,
                ModItems.MUSIC_DISC_ODE_TO_TRANQUILITY, ModItems.MUSIC_DISC_RECITAL, ModItems.CAUTION_HARD_LIGHT_PROJECTOR, ModItems.SENTINEL_HARD_LIGHT_PROJECTOR);

        registerItems(itemModelGenerator, Models.HANDHELD, ModItems.HARD_LIGHT_PROJECTOR);

        itemModelGenerator.register(ModItems.VENDOR_TOKEN, Models.GENERATED);
        itemModelGenerator.register(BetaItems.DEMONIC_CORE, Models.GENERATED);

        //effect items
        registerItems(itemModelGenerator, Models.GENERATED, ModEffectItems.GALLIUM_STOMACH, ModEffectItems.ONE_PENCE);

        itemModelGenerator.register(ModItems.YGGDRASIL_HANGING_SIGN, Models.GENERATED);
    }

    public void registerWoodType(BlockStateModelGenerator generator, Block LOG, Block WOOD, Block STRIPPED_LOG, Block STRIPPED_WOOD, Block LEAVES, Block SAPLING, Block POTTED_SAPLING){
        if (LOG != null && WOOD != null) generator.registerLog(LOG).log(LOG).wood(WOOD);
        if (STRIPPED_LOG != null && STRIPPED_WOOD != null) generator.registerLog(STRIPPED_LOG).log(STRIPPED_LOG).wood(STRIPPED_WOOD);
        if (SAPLING != null && POTTED_SAPLING != null) generator.registerFlowerPotPlant(SAPLING, POTTED_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        if(LEAVES != null) generator.registerSimpleCubeAll(LEAVES);
    }

    public void registerItems(ItemModelGenerator itemModelGenerator, Model model, Item... items){
        for (Item item:items) { itemModelGenerator.register(item, model); }
    }
}