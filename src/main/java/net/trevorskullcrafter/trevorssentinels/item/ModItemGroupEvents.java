package net.trevorskullcrafter.trevorssentinels.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModItemGroupEvents {
    public static void installBuildingBlocks(RegistryKey<ItemGroup> group){
        logInstall(group);

        addToGroupAfter(group, Blocks.WARPED_BUTTON, ModBlocks.YGGDRASIL_LOG, ModBlocks.YGGDRASIL_WOOD, ModBlocks.STRIPPED_YGGDRASIL_LOG,
                ModBlocks.STRIPPED_YGGDRASIL_WOOD, ModBlocks.YGGDRASIL_PLANKS, ModBlocks.YGGDRASIL_STAIRS, ModBlocks.YGGDRASIL_SLAB, ModBlocks.YGGDRASIL_FENCE,
                ModBlocks.YGGDRASIL_FENCE_GATE, ModBlocks.YGGDRASIL_DOOR, ModBlocks.YGGDRASIL_TRAPDOOR, ModBlocks.YGGDRASIL_PRESSURE_PLATE, ModBlocks.YGGDRASIL_BUTTON);
        addToGroupAfter(group, ModBlocks.YGGDRASIL_BUTTON, ModBlocks.CHARRED_LOG, ModBlocks.CHARRED_WOOD, ModBlocks.STRIPPED_CHARRED_LOG,
                ModBlocks.STRIPPED_CHARRED_WOOD, ModBlocks.CHARRED_PLANKS, ModBlocks.CHARRED_STAIRS, ModBlocks.CHARRED_SLAB, ModBlocks.CHARRED_FENCE,
                ModBlocks.CHARRED_FENCE_GATE, ModBlocks.CHARRED_DOOR, ModBlocks.CHARRED_TRAPDOOR, ModBlocks.CHARRED_PRESSURE_PLATE,
                ModBlocks.CHARRED_BUTTON);
        addToGroupAfter(group, ModBlocks.CHARRED_BUTTON, ModBlocks.MIDAS_LOG, ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_WOOD,
                ModBlocks.MIDAS_PLANKS, ModBlocks.MIDAS_STAIRS, ModBlocks.MIDAS_SLAB, ModBlocks.MIDAS_FENCE, ModBlocks.MIDAS_FENCE_GATE, ModBlocks.MIDAS_DOOR,
                ModBlocks.MIDAS_TRAPDOOR, ModBlocks.MIDAS_PRESSURE_PLATE, ModBlocks.MIDAS_BUTTON);
        addToGroupAfter(group, ModBlocks.MIDAS_BUTTON, ModBlocks.VIRIDESCENT_LOG, ModBlocks.VIRIDESCENT_WOOD, ModBlocks.STRIPPED_VIRIDESCENT_LOG, ModBlocks.STRIPPED_VIRIDESCENT_WOOD,
                ModBlocks.VIRIDESCENT_PLANKS, ModBlocks.VIRIDESCENT_STAIRS, ModBlocks.VIRIDESCENT_SLAB, ModBlocks.VIRIDESCENT_FENCE, ModBlocks.VIRIDESCENT_FENCE_GATE,
                ModBlocks.VIRIDESCENT_DOOR, ModBlocks.VIRIDESCENT_TRAPDOOR, ModBlocks.VIRIDESCENT_PRESSURE_PLATE, ModBlocks.VIRIDESCENT_BUTTON);
        addToGroupAfter(group, ModBlocks.VIRIDESCENT_BUTTON, ModBlocks.CERULII_LOG, ModBlocks.CERULII_WOOD, ModBlocks.STRIPPED_CERULII_LOG, ModBlocks.STRIPPED_CERULII_WOOD,
                ModBlocks.CERULII_PLANKS, ModBlocks.CERULII_STAIRS, ModBlocks.CERULII_SLAB, ModBlocks.CERULII_FENCE, ModBlocks.CERULII_FENCE_GATE, ModBlocks.CERULII_DOOR,
                ModBlocks.CERULII_TRAPDOOR, ModBlocks.CERULII_PRESSURE_PLATE, ModBlocks.CERULII_BUTTON);

        addToGroupAfter(group, Blocks.NETHERITE_BLOCK, ModBlocks.NUCLEAR_BLOCK);

        addToGroupAfter(group, Blocks.CUT_RED_SANDSTONE_SLAB, ModBlocks.SNOWSTONE, ModBlocks.SNOWSTONE_STAIRS, ModBlocks.SNOWSTONE_SLAB, ModBlocks.SNOWSTONE_WALL,
                ModBlocks.SMOOTH_SNOWSTONE, ModBlocks.SMOOTH_SNOWSTONE_STAIRS, ModBlocks.SMOOTH_SNOWSTONE_SLAB, ModBlocks.SMOOTH_SNOWSTONE_WALL,
                ModBlocks.CUT_SNOWSTONE, ModBlocks.CUT_SNOWSTONE_SLAB, ModBlocks.CHISELED_SNOWSTONE);

        addToGroupAfter(group, Blocks.END_STONE_BRICK_WALL, ModBlocks.CRACKED_END_STONE_BRICKS, ModBlocks.END_STONE_BRICK_COLUMN, ModBlocks.CHISELED_END_STONE_BRICKS);

        //steel
        addToGroupAfter(group, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB, ModBlocks.WAX_INFUSED_COPPER_BLOCK, ModBlocks.STEEL_BLOCK, ModBlocks.CAUTION_STEEL_BLOCK,
                ModBlocks.STAINLESS_STEEL_BLOCK, ModBlocks.RUSTED_STEEL_BLOCK, ModBlocks.STEEL_FAN, ModBlocks.STEEL_LAMP_BLOCK, ModBlocks.BATTERY, ModBlocks.FUSEBOX);
    }

    public static void installColoredBlocks(RegistryKey<ItemGroup> group){ logInstall(group); }

    public static void installNaturalBlocks(RegistryKey<ItemGroup> group){
        logInstall(group);
        addToGroupAfter(group, Blocks.ANCIENT_DEBRIS, ModBlocks.NUCLEAR_ORE);
        addToGroupAfter(group, Items.WHEAT_SEEDS, ModItems.RICE_SEEDS, ModItems.GOLDEN_RICE_SEEDS);

        addToGroupAfter(group, Blocks.WARPED_STEM, ModBlocks.YGGDRASIL_LOG, ModBlocks.CHARRED_LOG, ModBlocks.MIDAS_LOG, ModBlocks.VIRIDESCENT_LOG, ModBlocks.CERULII_LOG);

        addToGroupAfter(group, Blocks.FLOWERING_AZALEA_LEAVES, ModBlocks.YGGDRASIL_LEAVES, ModBlocks.MIDAS_LEAVES, ModBlocks.VIRIDESCENT_LEAVES, ModBlocks.CERULII_LEAVES);

        addToGroupBefore(group, Blocks.MOSS_BLOCK, ModBlocks.FLESH_BLOCK, ModBlocks.FLESH_VEINS, ModBlocks.FLESHY_EYE);
        addToGroupAfter(group, Blocks.WITHER_ROSE, ModBlocks.TRANQUIL_ROSE, ModBlocks.SKULLWEED, ModItems.FEATHERCORN);
    }

    public static void installFunctionalBlocks(RegistryKey<ItemGroup> group){
        logInstall(group);
        addToGroup(group, ModBlocks.VENDOR);
        addToGroupAfter(group, Blocks.SEA_LANTERN, ModBlocks.STEEL_LAMP_BLOCK);
        addToGroupAfter(group, Blocks.SCAFFOLDING, ModBlocks.BLUE_AGILITY_BLOCK, ModBlocks.ORANGE_AGILITY_BLOCK, ModBlocks.BLACK_AGILITY_BLOCK);
        addToGroupAfter(group, Blocks.LADDER, ModBlocks.STEEL_LADDER);
        addToGroupAfter(group, Items.WARPED_HANGING_SIGN, ModItems.YGGDRASIL_SIGN, ModItems.YGGDRASIL_HANGING_SIGN, ModItems.CHARRED_SIGN,
                ModItems.CHARRED_HANGING_SIGN, ModItems.MIDAS_SIGN, ModItems.MIDAS_HANGING_SIGN, ModItems.VIRIDESCENT_SIGN, ModItems.VIRIDESCENT_HANGING_SIGN,
                ModItems.CERULII_SIGN, ModItems.CERULII_HANGING_SIGN);
    }

    public static void installRedstoneBlocks(RegistryKey<ItemGroup> group){
        logInstall(group);
        addToGroupAfter(group, Blocks.TNT, ModBlocks.NUCLEAR_CHARGE);
    }

    public static void installTools(RegistryKey<ItemGroup> group){
        logInstall(group);
        addToGroupBefore(group, Items.WOODEN_SHOVEL, ModArmory.GALLIUM_SHOVEL, ModArmory.GALLIUM_PICKAXE, ModArmory.GALLIUM_AXE,
                ModArmory.GALLIUM_HOE);
        addToGroupAfter(group, Items.WOODEN_HOE, ModArmory.SPACEFARERS_SHOVEL, ModArmory.SPACEFARERS_PICKAXE, ModArmory.GALLIUM_CHAINSAW, ModArmory.SPACEFARERS_HOE);
        addToGroupAfter(group, Items.GOLDEN_HOE, ModArmory.ROSE_GOLD_SHOVEL, ModArmory.ROSE_GOLD_PICKAXE, ModArmory.ROSE_GOLD_AXE, ModArmory.ROSE_GOLD_HOE);
        addToGroupAfter(group, Items.IRON_HOE, ModArmory.TRIMETAL_SHOVEL, ModArmory.TRIMETAL_PICKAXE, ModArmory.TRIMETAL_AXE, ModArmory.TRIMETAL_HOE);
        addToGroupBefore(group, Items.DIAMOND_SHOVEL, ModArmory.TRANSITITE_SHOVEL, ModArmory.TRANSITITE_PICKAXE, ModArmory.TRANSITITE_AXE, ModArmory.TRANSITITE_HOE);
        addToGroupAfter(group, Items.NETHERITE_HOE, ModArmory.DARKSTEEL_SHOVEL, ModArmory.DARKSTEEL_PICKAXE, ModArmory.DARKSTEEL_AXE, ModArmory.DARKSTEEL_HOE);
        addToGroupAfter(group, ModArmory.DARKSTEEL_HOE, ModArmory.NUCLEAR_SHOVEL, ModArmory.NUCLEAR_PICKAXE, ModArmory.NUCLEAR_AXE, ModArmory.NUCLEAR_HOE);
        addToGroupAfter(group, ModArmory.NUCLEAR_HOE, ModArmory.NANOTECH_SHOVEL, ModArmory.NANOTECH_PICKAXE, ModArmory.NANOTECH_AXE, ModArmory.NANOTECH_HOE);
        addToGroupAfter(group, ModArmory.NANOTECH_HOE, ModArmory.ZENITHIUM_SHOVEL, ModArmory.ZENITHIUM_PICKAXE, ModArmory.ZENITHIUM_AXE, ModArmory.ZENITHIUM_HOE);

        addToGroupAfter(group, Items.MUSIC_DISC_PIGSTEP, ModItems.MUSIC_DISC_ASSASSINATION_UPLOAD, ModItems.MUSIC_DISC_ODE_TO_TRANQUILITY,
                ModItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT, ModItems.MUSIC_DISC_RECITAL);
    }

    public static void installCombat(RegistryKey<ItemGroup> group){
        logInstall(group);
        addToGroupBefore(group, Items.WOODEN_SWORD, ModArmory.GALLIUM_SWORD, ModArmory.GALLIUM_DAGGER);
        addToGroupAfter(group, Items.WOODEN_SWORD, ModArmory.SPACEFARERS_SWORD, ModArmory.SPACEFARERS_DAGGER);
        addToGroupAfter(group, Items.GOLDEN_SWORD, ModArmory.ROSE_GOLD_SWORD, ModArmory.ROSE_GOLD_DAGGER);
        addToGroupAfter(group, Items.IRON_SWORD, ModArmory.TRIMETAL_SWORD, ModArmory.TRIMETAL_DAGGER);
        addToGroupBefore(group, Items.DIAMOND_SWORD, ModArmory.TRANSITITE_SWORD, ModArmory.TRANSITITE_DAGGER);
        addToGroupAfter(group, Items.NETHERITE_SWORD, ModArmory.DARKSTEEL_SWORD, ModArmory.DARKSTEEL_DAGGER, ModArmory.NUCLEAR_SWORD, ModArmory.NUCLEAR_DAGGER,
                ModArmory.NANOTECH_SWORD, ModArmory.NANOTECH_DAGGER, ModArmory.ZENITHIUM_SWORD, ModArmory.ZENITHIUM_DAGGER);

        addToGroupAfter(group, Items.NETHERITE_AXE, ModArmory.DARKSTEEL_AXE, ModArmory.NUCLEAR_AXE, ModArmory.NANOTECH_AXE, ModArmory.ZENITHIUM_AXE);

        addToGroupAfter(group, Blocks.TNT, ModBlocks.NUCLEAR_CHARGE);
    }

    public static void installFoods(RegistryKey<ItemGroup> group){
        logInstall(group);
        addToGroupAfter(group, Items.GOLDEN_APPLE, ModItems.PEARFRUIT, ModItems.BANANA, ModItems.RED_BANANA, ModItems.BLUE_JAVA_BANANA, ModItems.MIDAS_FRUIT);
        addToGroupBefore(group, Items.CARROT, ModItems.RICE_SEEDS, ModItems.GOLDEN_RICE_SEEDS);
        addToGroupAfter(group, Items.BREAD, ModItems.RICE_CAKE, ModItems.GOLDEN_RICE_CAKE, ModItems.TORTILLA, ModItems.BURRITO, ModItems.BANANA_BREAD,
                ModItems.RED_BANANA_BREAD, ModItems.BLUE_JAVA_BANANA_BREAD);
        addToGroupAfter(group, Items.TROPICAL_FISH, ModItems.SMOKED_FISH);
        addToGroupAfter(group, Items.PUFFERFISH, ModItems.SANDFISH, ModItems.COOKED_SANDFISH, ModItems.DUNE_EEL, ModItems.DUBIOUS_BACON);
        addToGroupAfter(group, Items.COOKIE, ModItems.BROWNIE, ModItems.CHORUS_COBBLER);
        addToGroupAfter(group, Items.DRIED_KELP, ModItems.SUSHI_ROLL);
        addToGroupBefore(group, Items.BEEF, ModItems.FRIED_EGG);
        addToGroupAfter(group, Items.MUSHROOM_STEW, ModItems.MUSHROOM_STEW_CAN);
        addToGroupAfter(group, Items.BEETROOT_SOUP, ModItems.BEETROOT_SOUP_CAN);
        addToGroupAfter(group, Items.RABBIT_STEW, ModItems.RABBIT_STEW_CAN);

        addToGroupAfter(group, Items.SPIDER_EYE, ModItems.ASH, ModItems.TRANQUIL_DUST, ModItems.SALT);
        addToGroupAfter(group, Items.MILK_BUCKET, ModItems.MILK_CAN, ModItems.ANTIMILK);
        addToGroupBefore(group, Items.HONEY_BOTTLE, ModItems.COLA_ORANGE, ModItems.COLA_GREEN, ModItems.COLA_CYAN);
    }

    public static void installIngredients(RegistryKey<ItemGroup> group){
        logInstall(group);
        addToGroupBefore(group, Items.IRON_NUGGET, ModItems.SCRAP_METAL_SHARD);
        addToGroupAfter(group, Items.WHEAT, ModItems.RICE_SEEDS, ModItems.GOLDEN_RICE_SEEDS);
        addToGroup(group, ModItems.ZENITHIUM_CLUSTER);
    }

    public static void installSpawnEggs(RegistryKey<ItemGroup> group){
        logInstall(group);
        addToGroup(group, ModItems.SENTINEL_SPAWN_EGG, ModItems.ROOMBA_SPAWN_EGG, ModItems.FLORBUS_SPAWN_EGG);
    }

    public static void installSentinels(RegistryKey<ItemGroup> group){
        logInstall(group);
        //blocks
        addToGroup(group, ModBlocks.GALINITE_BLOCK, ModBlocks.CHISELED_GALINITE_BLOCK, ModBlocks.GALINITE_PILLAR);
        addToGroup(group, ModBlocks.TRANQUIL_ROSE, ModBlocks.SKULLWEED, ModItems.FEATHERCORN);
        addToGroup(group, ModBlocks.DATA_BLOCK);
        addToGroup(group, ModBlocks.STEEL_BLOCK, ModBlocks.CAUTION_STEEL_BLOCK, ModBlocks.STAINLESS_STEEL_BLOCK, ModBlocks.RUSTED_STEEL_BLOCK, ModBlocks.STEEL_LAMP_BLOCK,
                ModBlocks.STEEL_FAN, ModBlocks.BATTERY, ModBlocks.FUSEBOX, ModBlocks.STEEL_LADDER, ModBlocks.WAX_INFUSED_COPPER_BLOCK, ModBlocks.BLACK_AGILITY_BLOCK,
                ModBlocks.FANCY_COMPUTER, ModBlocks.VENDOR);
        addToGroup(group, ModBlocks.NUCLEAR_BLOCK, ModBlocks.NUCLEAR_ORE);
        addToGroup(group, ModBlocks.NUCLEAR_CHARGE);

        addToGroup(group, ModBlocks.CHISELED_END_STONE_BRICKS, ModBlocks.CRACKED_END_STONE_BRICKS, ModBlocks.END_STONE_BRICK_COLUMN);
        addToGroup(group, ModBlocks.CHISELED_SNOWSTONE, ModBlocks.CUT_SNOWSTONE, ModBlocks.SNOWSTONE, ModBlocks.SMOOTH_SNOWSTONE, ModBlocks.SNOWSTONE_SLAB,
                ModBlocks.CUT_SNOWSTONE_SLAB, ModBlocks.SNOWSTONE_STAIRS, ModBlocks.SNOWSTONE_WALL, ModBlocks.SMOOTH_SNOWSTONE_STAIRS, ModBlocks.SMOOTH_SNOWSTONE_SLAB);

        addToGroup(group, ModBlocks.DIRT_STAIRS, ModBlocks.DIRT_SLAB, ModBlocks.COARSE_DIRT_STAIRS, ModBlocks.COARSE_DIRT_SLAB, ModBlocks.OVERGROWN_GRASS_BLOCK,
                ModBlocks.GRASS_STAIRS, ModBlocks.GRASS_SLAB, ModBlocks.MOSS_STAIRS, ModBlocks.MOSS_SLAB);
        addToGroup(group, ModBlocks.RED_BUTTON, ModBlocks.RED_PLATE);

        addToGroup(group, ModBlocks.FLESH_BLOCK, ModBlocks.FLESH_VEINS, ModBlocks.FLESHY_EYE, ModItems.RUINOUS_GAZE, ModItems.DUBIOUS_BACON);

        addToGroup(group, ModBlocks.YGGDRASIL_PLANKS, ModBlocks.YGGDRASIL_LOG, ModBlocks.STRIPPED_YGGDRASIL_LOG, ModBlocks.YGGDRASIL_WOOD,
                ModBlocks.STRIPPED_YGGDRASIL_WOOD, ModBlocks.YGGDRASIL_LEAVES, ModBlocks.YGGDRASIL_SLAB, ModBlocks.YGGDRASIL_FENCE, ModBlocks.YGGDRASIL_STAIRS,
                ModBlocks.YGGDRASIL_BUTTON, ModBlocks.YGGDRASIL_PRESSURE_PLATE, ModBlocks.YGGDRASIL_DOOR, ModBlocks.YGGDRASIL_TRAPDOOR, ModBlocks.YGGDRASIL_FENCE_GATE,
                ModItems.YGGDRASIL_SIGN, ModItems.YGGDRASIL_HANGING_SIGN, ModBlocks.YGGDRASIL_SAPLING);

        addToGroup(group, ModBlocks.CHARRED_PLANKS, ModBlocks.CHARRED_LOG, ModBlocks.STRIPPED_CHARRED_LOG, ModBlocks.CHARRED_WOOD,
                ModBlocks.STRIPPED_CHARRED_WOOD, ModBlocks.CHARRED_SLAB, ModBlocks.CHARRED_FENCE, ModBlocks.CHARRED_STAIRS, ModBlocks.CHARRED_BUTTON,
                ModBlocks.CHARRED_PRESSURE_PLATE, ModBlocks.CHARRED_DOOR, ModBlocks.CHARRED_TRAPDOOR, ModBlocks.CHARRED_FENCE_GATE,
                ModItems.CHARRED_SIGN, ModItems.CHARRED_HANGING_SIGN);

        addToGroup(group, ModBlocks.MIDAS_PLANKS, ModBlocks.MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_LOG, ModBlocks.MIDAS_WOOD,
                ModBlocks.STRIPPED_MIDAS_WOOD, ModBlocks.MIDAS_LEAVES, ModBlocks.MIDAS_SLAB, ModBlocks.MIDAS_FENCE, ModBlocks.MIDAS_STAIRS,
                ModBlocks.MIDAS_BUTTON, ModBlocks.MIDAS_PRESSURE_PLATE, ModBlocks.MIDAS_DOOR, ModBlocks.MIDAS_TRAPDOOR, ModBlocks.MIDAS_FENCE_GATE,
                ModItems.MIDAS_SIGN, ModItems.MIDAS_HANGING_SIGN, ModBlocks.MIDAS_SAPLING);

        addToGroup(group, ModBlocks.VIRIDESCENT_PLANKS, ModBlocks.VIRIDESCENT_LOG, ModBlocks.STRIPPED_VIRIDESCENT_LOG, ModBlocks.VIRIDESCENT_WOOD,
                ModBlocks.STRIPPED_VIRIDESCENT_WOOD, ModBlocks.VIRIDESCENT_LEAVES, ModBlocks.VIRIDESCENT_SLAB, ModBlocks.VIRIDESCENT_FENCE, ModBlocks.VIRIDESCENT_STAIRS,
                ModBlocks.VIRIDESCENT_BUTTON, ModBlocks.VIRIDESCENT_PRESSURE_PLATE, ModBlocks.VIRIDESCENT_DOOR, ModBlocks.VIRIDESCENT_TRAPDOOR, ModBlocks.VIRIDESCENT_FENCE_GATE,
                ModItems.VIRIDESCENT_SIGN, ModItems.VIRIDESCENT_HANGING_SIGN, ModBlocks.VIRIDESCENT_SAPLING);

        addToGroup(group, ModBlocks.CERULII_PLANKS, ModBlocks.CERULII_LOG, ModBlocks.STRIPPED_CERULII_LOG, ModBlocks.CERULII_WOOD,
                ModBlocks.STRIPPED_CERULII_WOOD, ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SLAB, ModBlocks.CERULII_FENCE, ModBlocks.CERULII_STAIRS,
                ModBlocks.CERULII_BUTTON, ModBlocks.CERULII_PRESSURE_PLATE, ModBlocks.CERULII_DOOR, ModBlocks.CERULII_TRAPDOOR, ModBlocks.CERULII_FENCE_GATE,
                ModItems.CERULII_SIGN, ModItems.CERULII_HANGING_SIGN, ModBlocks.CERULII_SAPLING);

        addToGroup(group, ModBlocks.DARKSTEEL_BLOCK, ModBlocks.DARKENED_STEEL_BLOCK);
        addToGroup(group, ModBlocks.IRON_GOLD_BLOCK);
        addToGroup(group, ModBlocks.COPPER_IRON_BLOCK);
        addToGroup(group, ModBlocks.ROSE_GOLD_BLOCK);
        addToGroup(group, ModBlocks.DARK_CHAMBER_BLOCK, ModBlocks.LIGHT_CHAMBER_BLOCK, ModBlocks.BLUE_AGILITY_BLOCK, ModBlocks.ORANGE_AGILITY_BLOCK);
        addToGroup(group, ModBlocks.SUPERFORGE);

        //items
        addToGroup(group, ModItems.SCRAP_METAL_SHARD);
        addToGroup(group, ModItems.GALINITE_LENS);
        addToGroup(group, ModItems.HARD_LIGHT_PROJECTOR, ModBlocks.HARD_LIGHT_BARRIER,
                ModItems.CAUTION_HARD_LIGHT_PROJECTOR, ModBlocks.CAUTION_HARD_LIGHT_BARRIER,
                ModItems.SENTINEL_HARD_LIGHT_PROJECTOR, ModBlocks.SENTINEL_HARD_LIGHT_BARRIER);
        addToGroup(group, ModItems.ENERGY_CELL);

        addToGroup(group, ModItems.MUSIC_DISC_ASSASSINATION_UPLOAD, ModItems.MUSIC_DISC_ODE_TO_TRANQUILITY, ModItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT,
                ModItems.MUSIC_DISC_RECITAL);

        addToGroup(group, ModItems.GUNMETAL_INGOT);
        addToGroup(group, ModItems.STEEL_INGOT);
        addToGroup(group, ModItems.COPPER_IRON_INGOT);
        addToGroup(group, ModItems.ROSE_GOLD_INGOT);
        addToGroup(group, ModItems.IMPERIAL_ALLOY_INGOT);
        addToGroup(group, ModItems.TRANSITITE_SHARDS);
        addToGroup(group, ModItems.ASH);
        addToGroup(group, ModItems.TRANQUIL_DUST);
        addToGroup(group, ModItems.SALT);
        addToGroup(group, ModItems.DARKSTEEL_INGOT);
        addToGroup(group, ModItems.VIOLENT_CATALYST);
        addToGroup(group, ModItems.FERRAURIUM_DARKSTEEL_INGOT);
        addToGroup(group, ModItems.TORBERNITE_CUBE);
        addToGroup(group, ModItems.ZENITHIUM_CLUSTER);
        addToGroup(group, ModItems.STEEL_SIGN);
        addToGroup(group, ModItems.HOLOGRAPHIC_BLUE_SIGN);
        addToGroup(group, ModItems.SENTINEL_SPAWN_EGG, ModItems.ROOMBA_SPAWN_EGG, ModItems.FLORBUS_SPAWN_EGG);

        addToGroup(group, ModItems.YGGDRASIL_BOAT, ModItems.YGGDRASIL_CHEST_BOAT);
        addToGroup(group, ModItems.CHARRED_BOAT, ModItems.CHARRED_CHEST_BOAT);
        addToGroup(group, ModItems.MIDAS_BOAT, ModItems.MIDAS_CHEST_BOAT);
        addToGroup(group, ModItems.VIRIDESCENT_BOAT, ModItems.VIRIDESCENT_CHEST_BOAT);
        addToGroup(group, ModItems.CERULII_BOAT, ModItems.CERULII_CHEST_BOAT);
        addToGroup(group, ModItems.EMPTY_CAN);
        addToGroup(group, ModItems.VENDOR_TOKEN, ModItems.LEGENDARY_TOKEN);
        addToGroup(group, ModItems.NUCLEAR_ROCKET);
        addToGroup(group, ModItems.NUCLEAR_DETONATOR);

        //food
        addToGroup(group, ModItems.FRIED_EGG);
        addToGroup(group, ModItems.BANANA, ModItems.RED_BANANA, ModItems.BLUE_JAVA_BANANA);
        addToGroup(group, ModBlocks.RICE_BLOCK, ModItems.RICE_SEEDS, ModItems.RICE_CAKE);
        addToGroup(group, ModItems.SUSHI_ROLL);
        addToGroup(group, ModBlocks.GOLDEN_RICE_BLOCK, ModItems.GOLDEN_RICE_SEEDS, ModItems.GOLDEN_RICE_CAKE);
        addToGroup(group, ModItems.TORTILLA, ModItems.BURRITO);
        addToGroup(group, ModItems.PEARFRUIT);
        addToGroup(group, ModItems.BROWNIE);
        addToGroup(group, ModItems.SALT);
        //cured meat
        addToGroup(group, ModItems.SANDFISH, ModItems.COOKED_SANDFISH, ModItems.DUNE_EEL);
        addToGroup(group, ModItems.SMOKED_FISH);
        addToGroup(group, ModItems.ANTIMILK);
        addToGroup(group, ModItems.BEETROOT_SOUP_CAN, ModItems.MUSHROOM_STEW_CAN, ModItems.RABBIT_STEW_CAN, ModItems.MILK_CAN,
                ModItems.COLA_ORANGE, ModItems.COLA_GREEN, ModItems.COLA_CYAN);

        logInstall(group, "Armory");
        addToGroup(group, ModArmory.GALLIUM_SWORD, ModArmory.GALLIUM_DAGGER, ModArmory.GALLIUM_PICKAXE, ModArmory.GALLIUM_AXE,
                ModArmory.GALLIUM_SHOVEL, ModArmory.GALLIUM_HOE, ModArmory.GALLIUM_HELMET, ModArmory.GALLIUM_CHESTPLATE,
                ModArmory.GALLIUM_LEGGINGS, ModArmory.GALLIUM_BOOTS);
        addToGroup(group, ModArmory.SPACEFARERS_SWORD, ModArmory.SPACEFARERS_DAGGER, ModArmory.SPACEFARERS_PICKAXE, ModArmory.GALLIUM_CHAINSAW, ModArmory.SPACEFARERS_SHOVEL,
                ModArmory.SPACEFARERS_HOE, ModArmory.SPACEFARERS_HELMET, ModArmory.SPACEFARERS_CHESTPLATE, ModArmory.SPACEFARERS_LEGGINGS, ModArmory.SPACEFARERS_BOOTS);
        addToGroup(group, ModArmory.ROSE_GOLD_SWORD, ModArmory.ROSE_GOLD_DAGGER, ModArmory.ROSE_GOLD_PICKAXE, ModArmory.ROSE_GOLD_AXE, ModArmory.ROSE_GOLD_SHOVEL,
                ModArmory.ROSE_GOLD_HOE, ModArmory.ROSE_GOLD_HELMET, ModArmory.ROSE_GOLD_CHESTPLATE, ModArmory.ROSE_GOLD_LEGGINGS, ModArmory.ROSE_GOLD_BOOTS);
        addToGroup(group, ModArmory.TRIMETAL_SWORD, ModArmory.TRIMETAL_DAGGER, ModArmory.TRIMETAL_PICKAXE, ModArmory.TRIMETAL_AXE, ModArmory.TRIMETAL_SHOVEL,
                ModArmory.TRIMETAL_HOE, ModArmory.TRIMETAL_HELMET, ModArmory.TRIMETAL_CHESTPLATE, ModArmory.TRIMETAL_LEGGINGS, ModArmory.TRIMETAL_BOOTS);
        addToGroup(group, ModArmory.IMPERIAL_SWORD, ModArmory.IMPERIAL_DAGGER, ModArmory.IMPERIAL_PICKAXE, ModArmory.IMPERIAL_AXE, ModArmory.IMPERIAL_SHOVEL,
                ModArmory.IMPERIAL_HOE, ModArmory.IMPERIAL_HELMET, ModArmory.IMPERIAL_CHESTPLATE, ModArmory.IMPERIAL_LEGGINGS, ModArmory.IMPERIAL_BOOTS);
        addToGroup(group, ModArmory.TRANSITITE_SWORD, ModArmory.TRANSITITE_DAGGER, ModArmory.TRANSITITE_PICKAXE, ModArmory.TRANSITITE_AXE, ModArmory.TRANSITITE_SHOVEL,
                ModArmory.TRANSITITE_HOE, ModArmory.TRANSITITE_HELMET, ModArmory.TRANSITITE_CHESTPLATE, ModArmory.TRANSITITE_LEGGINGS, ModArmory.TRANSITITE_BOOTS);
        addToGroup(group, ModArmory.DARKSTEEL_SWORD, ModArmory.DARKSTEEL_DAGGER, ModArmory.DARKSTEEL_PICKAXE, ModArmory.DARKSTEEL_AXE, ModArmory.DARKSTEEL_SHOVEL,
                ModArmory.DARKSTEEL_HOE, ModArmory.DARKSTEEL_HELMET, ModArmory.DARKSTEEL_CHESTPLATE, ModArmory.DARKSTEEL_LEGGINGS, ModArmory.DARKSTEEL_BOOTS);
        addToGroup(group, ModArmory.NUCLEAR_SWORD, ModArmory.NUCLEAR_DAGGER, ModArmory.NUCLEAR_PICKAXE, ModArmory.NUCLEAR_AXE, ModArmory.NUCLEAR_SHOVEL,
                ModArmory.NUCLEAR_HOE, ModArmory.NUCLEAR_HELMET, ModArmory.NUCLEAR_CHESTPLATE, ModArmory.NUCLEAR_LEGGINGS, ModArmory.NUCLEAR_BOOTS);
        addToGroup(group, ModArmory.NANOTECH_SWORD, ModArmory.NANOTECH_DAGGER, ModArmory.NANOTECH_PICKAXE, ModArmory.NANOTECH_AXE, ModArmory.NANOTECH_SHOVEL,
                ModArmory.NANOTECH_HOE, ModArmory.NANOTECH_HELMET, ModArmory.NANOTECH_CHESTPLATE, ModArmory.NANOTECH_LEGGINGS, ModArmory.NANOTECH_BOOTS);
        addToGroup(group, ModArmory.ZENITHIUM_SWORD, ModArmory.ZENITHIUM_DAGGER, ModArmory.ZENITHIUM_PICKAXE, ModArmory.ZENITHIUM_AXE, ModArmory.ZENITHIUM_SHOVEL,
                ModArmory.ZENITHIUM_HOE, ModArmory.THANATU_SKULL, ModArmory.THANATU_SHOULDERPADS, ModArmory.ZENITHIUM_CHESTPLATE, ModArmory.ZENITHIUM_LEGGINGS,
                ModArmory.ZENITHIUM_BOOTS);

        logInstall(group, "Ballistics");
        addToGroup(group, ModArmory.LASER_PISTOL, ModArmory.LASER_TASER, ModArmory.LASER_SNIPER_ECHO, ModArmory.LASER_RIFLE, ModArmory.LASER_HEALER,
                ModArmory.LASER_MINIGUN, ModArmory.LASER_SHOTGUN, ModArmory.LASER_SPREADER, ModArmory.LASER_SNIPER, ModArmory.LASER_REVOLVER, ModArmory.VILE_SPITTER);
    }

    public static void logInstall(RegistryKey<ItemGroup> group){ trevorssentinels.LOGGER.info("Filling unit [" + group.getValue().toTranslationKey() + "]... (" + MOD_ID + ")"); }
    public static void logInstall(RegistryKey<ItemGroup> group, String subunitName){
        trevorssentinels.LOGGER.info("Filling subunit [" + subunitName + "] in unit [" + group.getValue().toTranslationKey() + "]... (" + MOD_ID + ")");
    }

    public static void addToGroup(RegistryKey<ItemGroup> group, ItemConvertible... items){
        for (ItemConvertible itemConvertible : items) { ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(itemConvertible)); }
    }

    public static void addToGroupAfter(RegistryKey<ItemGroup> group, ItemConvertible after, ItemConvertible... items){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(after, items));
    }

    public static void addToGroupBefore(RegistryKey<ItemGroup> group, ItemConvertible before, ItemConvertible... items){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addBefore(before, items));
    }

    public static void registerAllGroupEvents(){
        installSentinels(trevorssentinels.SENTINELS);
        installBuildingBlocks(ItemGroups.BUILDING_BLOCKS); //00
        installColoredBlocks(ItemGroups.COLORED_BLOCKS); //01
        installNaturalBlocks(ItemGroups.NATURAL); //02
        installFunctionalBlocks(ItemGroups.FUNCTIONAL); //03
        installRedstoneBlocks(ItemGroups.REDSTONE); //04
        installTools(ItemGroups.TOOLS); //05
        installCombat(ItemGroups.COMBAT); //06
        installFoods(ItemGroups.FOOD_AND_DRINK); //07
        installIngredients(ItemGroups.INGREDIENTS); //08
        installSpawnEggs(ItemGroups.SPAWN_EGGS); //09
    }
}