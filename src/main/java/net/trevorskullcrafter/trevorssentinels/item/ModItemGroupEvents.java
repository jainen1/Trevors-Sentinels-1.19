package net.trevorskullcrafter.trevorssentinels.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModItemGroupEvents {
    public static void installBuildingBlocks(ItemGroup group){
        logInstall(group);

        //yggdrasil wood
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.WARPED_BUTTON,
                ModBlocks.YGGDRASIL_LOG, ModBlocks.YGGDRASIL_WOOD, ModBlocks.STRIPPED_YGGDRASIL_LOG, ModBlocks.STRIPPED_YGGDRASIL_WOOD,
                ModBlocks.YGGDRASIL_PLANKS, ModBlocks.YGGDRASIL_STAIRS, ModBlocks.YGGDRASIL_SLAB, ModBlocks.YGGDRASIL_FENCE, ModBlocks.YGGDRASIL_FENCE_GATE,
                ModBlocks.YGGDRASIL_DOOR, ModBlocks.YGGDRASIL_TRAPDOOR, ModBlocks.YGGDRASIL_PRESSURE_PLATE, ModBlocks.YGGDRASIL_BUTTON));

        //charred oak wood
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(ModBlocks.YGGDRASIL_BUTTON,
                ModBlocks.CHARRED_OAK_LOG, ModBlocks.CHARRED_OAK_WOOD, ModBlocks.STRIPPED_CHARRED_OAK_LOG, ModBlocks.STRIPPED_CHARRED_OAK_WOOD,
                ModBlocks.CHARRED_OAK_PLANKS, ModBlocks.CHARRED_OAK_STAIRS, ModBlocks.CHARRED_OAK_SLAB, ModBlocks.CHARRED_OAK_FENCE,
                ModBlocks.CHARRED_OAK_FENCE_GATE, ModBlocks.CHARRED_OAK_DOOR, ModBlocks.CHARRED_OAK_TRAPDOOR, ModBlocks.CHARRED_OAK_PRESSURE_PLATE,
                ModBlocks.CHARRED_OAK_BUTTON));

        //midas wood
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(ModBlocks.CHARRED_OAK_BUTTON,
                ModBlocks.MIDAS_LOG, ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_WOOD,
                ModBlocks.MIDAS_PLANKS, ModBlocks.MIDAS_STAIRS, ModBlocks.MIDAS_SLAB, ModBlocks.MIDAS_FENCE, ModBlocks.MIDAS_FENCE_GATE,
                ModBlocks.MIDAS_DOOR, ModBlocks.MIDAS_TRAPDOOR, ModBlocks.MIDAS_PRESSURE_PLATE, ModBlocks.MIDAS_BUTTON));

        //banana wood
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(ModBlocks.MIDAS_BUTTON,
                ModBlocks.BANANA_LOG, ModBlocks.BANANA_WOOD, ModBlocks.STRIPPED_BANANA_LOG, ModBlocks.STRIPPED_BANANA_WOOD,
                ModBlocks.BANANA_PLANKS, ModBlocks.BANANA_STAIRS, ModBlocks.BANANA_SLAB, ModBlocks.BANANA_FENCE, ModBlocks.BANANA_FENCE_GATE,
                ModBlocks.BANANA_DOOR, ModBlocks.BANANA_TRAPDOOR, ModBlocks.BANANA_PRESSURE_PLATE, ModBlocks.BANANA_BUTTON));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.NETHERITE_BLOCK, ModBlocks.URANIUM_BLOCK));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.CUT_RED_SANDSTONE_SLAB,
                ModBlocks.SNOWSTONE, ModBlocks.SNOWSTONE_STAIRS, ModBlocks.SNOWSTONE_SLAB, ModBlocks.SNOWSTONE_WALL, ModBlocks.CHISELED_SNOWSTONE,
                ModBlocks.SMOOTH_SNOWSTONE, ModBlocks.SMOOTH_SNOWSTONE_STAIRS, ModBlocks.SMOOTH_SNOWSTONE_SLAB, ModBlocks.CUT_SNOWSTONE,
                ModBlocks.CUT_SNOWSTONE_SLAB));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.END_STONE_BRICK_WALL, ModBlocks.CRACKED_END_STONE_BRICKS,
                ModBlocks.END_STONE_BRICK_COLUMN, ModBlocks.CHISELED_END_STONE_BRICKS));

        //steel
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,
                ModBlocks.WAX_INFUSED_COPPER_BLOCK, ModBlocks.STEEL_BLOCK, ModBlocks.CAUTION_STEEL_BLOCK, ModBlocks.STAINLESS_STEEL_BLOCK,
                ModBlocks.RUSTED_STEEL_BLOCK, ModBlocks.STEEL_FAN, ModBlocks.STEEL_LAMP_BLOCK, ModBlocks.BATTERY, ModBlocks.FUSEBOX));
    }

    public static void installColoredBlocks(ItemGroup group){
        logInstall(group);
    }

    public static void installNaturalBlocks(ItemGroup group){
        logInstall(group);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.ANCIENT_DEBRIS, ModBlocks.URANIUM_ORE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.WHEAT_SEEDS, ModItems.RICE, ModItems.GOLDEN_RICE));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.WARPED_STEM,
                ModBlocks.YGGDRASIL_LOG, ModBlocks.CHARRED_OAK_LOG, ModBlocks.MIDAS_LOG, ModBlocks.BANANA_LOG));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.FLOWERING_AZALEA_LEAVES,
                ModBlocks.YGGDRASIL_LEAVES, ModBlocks.MIDAS_LEAVES, ModBlocks.BANANA_LEAVES));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.MOSS_BLOCK,
                ModBlocks.FLESH_BLOCK));
    }

    public static void installFunctionalBlocks(ItemGroup group){
        logInstall(group);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.VENDOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.SEA_LANTERN, ModBlocks.STEEL_LAMP_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Blocks.SCAFFOLDING,
                ModBlocks.BLUE_AGILITY_BLOCK, ModBlocks.ORANGE_AGILITY_BLOCK, ModBlocks.BLACK_AGILITY_BLOCK));
    }

    public static void installRedstoneBlocks(ItemGroup group){
        logInstall(group);
    }

    public static void installTools(ItemGroup group){
        logInstall(group);

        //flimsy sentinum
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addBefore(Items.WOODEN_SHOVEL,
                ModArmory.FLIMSY_SENTINUM_SPADE, ModArmory.FLIMSY_SENTINUM_PICKAXE, ModArmory.FLIMSY_SENTINUM_HATCHET, ModArmory.FLIMSY_SENTINUM_SCYTHE));

        //sentinum
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.WOODEN_HOE,
                ModArmory.SENTINUM_SPADE, ModArmory.SENTINUM_PICKAXE, ModArmory.SENTINUM_CHAINSAW, ModArmory.SENTINUM_SCYTHE));

        //hunter
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.DIAMOND_HOE,
                ModArmory.HUNTERS_SPADE, ModArmory.HUNTERS_DRILL, ModArmory.HUNTERS_CHAINSAW, ModArmory.HUNTERS_SCYTHE));

        //nuclear
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.NETHERITE_HOE,
                ModArmory.NUCLEAR_SHOVEL, ModArmory.NUCLEAR_DRILL, ModArmory.NUCLEAR_AXE, ModArmory.NUCLEAR_SCYTHE));

        //zenithium
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(ModArmory.NUCLEAR_SCYTHE,
                ModArmory.ZENITHIUM_SHOVEL, ModArmory.ZENITHIUM_PICKAXE, ModArmory.ZENITHIUM_AXE, ModArmory.ZENITHIUM_HOE));

        //music discs
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.MUSIC_DISC_PIGSTEP,
                ModItems.MUSIC_DISC_ASSASSINATION_UPLOAD, ModItems.MUSIC_DISC_ODE_TO_TRANQUILITY, ModItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT,
                ModItems.MUSIC_DISC_RECITAL));
    }

    public static void installCombat(ItemGroup group){
        logInstall(group);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addBefore(Items.WOODEN_SWORD, ModArmory.FLIMSY_SENTINUM_SHIV));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.WOODEN_SWORD, ModArmory.SENTINUM_DIRK));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.GOLDEN_SWORD, ModArmory.ROSE_GOLD_DAGGER));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.DIAMOND_SWORD, ModArmory.HUNTERS_VIBROBLADE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.NETHERITE_SWORD, ModArmory.CRYSTAL_DAGGER));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.DIAMOND_AXE, ModArmory.HUNTERS_CHAINSAW));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.NETHERITE_AXE, ModArmory.NUCLEAR_AXE, ModArmory.ZENITHIUM_AXE));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModArmory.PAPPYM_BLADE));
    }

    public static void installFoods(ItemGroup group){
        logInstall(group);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.GOLDEN_APPLE, ModItems.PEARFRUIT));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addBefore(Items.CARROT, ModItems.RICE, ModItems.GOLDEN_RICE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.BREAD, ModItems.RICE_CAKE, ModItems.GOLDEN_RICE_CAKE,
                ModItems.TORTILLA, ModItems.BURRITO));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.PUFFERFISH,
                ModItems.SANDFISH, ModItems.COOKED_SANDFISH, ModItems.DUNE_EEL));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.COOKIE, ModItems.BROWNIE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.DRIED_KELP, ModItems.SUSHI_ROLL));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.MUSHROOM_STEW, ModItems.MUSHROOM_STEW_CAN));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.BEETROOT_SOUP, ModItems.BEETROOT_SOUP_CAN));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.RABBIT_STEW, ModItems.RABBIT_STEW_CAN));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.SPIDER_EYE, ModItems.ASH));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.MILK_BUCKET, ModItems.MILK_CAN, ModItems.ANTIMILK));
    }

    public static void installIngredients(ItemGroup group){
        logInstall(group);
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addBefore(Items.IRON_NUGGET, ModItems.SENTINUM_SHARD));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addBefore(Items.IRON_INGOT, ModItems.SENTINUM_INGOT));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(Items.WHEAT, ModItems.RICE, ModItems.GOLDEN_RICE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModItems.REDSTONE_CRYSTAL));
    }

    public static void installSpawnEggs(ItemGroup group){
        logInstall(group);
        registerInGroup(group, ModItems.SENTINEL_SPAWN_EGG);
        registerInGroup(group, ModItems.ROOMBA_SPAWN_EGG);
        registerInGroup(group, ModItems.FLORBUS_SPAWN_EGG);
    }

    public static void installSentinels(ItemGroup group){
        logInstall(group);
        //blocks
        registerInGroup(group, ModBlocks.SENTINUM_BLOCK);
        registerInGroup(group, ModBlocks.CHISELED_SENTINUM_BLOCK);
        registerInGroup(group, ModBlocks.SENTINUM_PILLAR);
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.DATA_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STEEL_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CAUTION_STEEL_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STAINLESS_STEEL_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STEEL_LAMP_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STEEL_FAN));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.RUSTED_STEEL_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BATTERY));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.FUSEBOX));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.VENDOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.WAX_INFUSED_COPPER_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.URANIUM_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.URANIUM_ORE));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.NUCLEAR_CHARGE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHISELED_END_STONE_BRICKS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CRACKED_END_STONE_BRICKS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.END_STONE_BRICK_COLUMN));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHISELED_SNOWSTONE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CUT_SNOWSTONE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.SNOWSTONE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.SMOOTH_SNOWSTONE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.SNOWSTONE_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CUT_SNOWSTONE_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.SNOWSTONE_STAIRS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.SNOWSTONE_WALL));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.SMOOTH_SNOWSTONE_STAIRS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.SMOOTH_SNOWSTONE_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.DIRT_STAIRS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.DIRT_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.COARSE_DIRT_STAIRS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.COARSE_DIRT_SLAB));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.OVERGROWN_GRASS_BLOCK));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.GRASS_STAIRS));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.GRASS_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MOSS_STAIRS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MOSS_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.FLESH_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.RED_BUTTON));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.RED_PLATE));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_PLANKS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_LOG));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STRIPPED_YGGDRASIL_LOG));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_WOOD));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STRIPPED_YGGDRASIL_WOOD));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_LEAVES));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_FENCE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_STAIRS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_BUTTON));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_PRESSURE_PLATE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_DOOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_TRAPDOOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.YGGDRASIL_FENCE_GATE));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModItems.YGGDRASIL_SIGN));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_PLANKS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_LOG));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STRIPPED_CHARRED_OAK_LOG));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_WOOD));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STRIPPED_CHARRED_OAK_WOOD));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_FENCE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_STAIRS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_BUTTON));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_PRESSURE_PLATE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_DOOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_TRAPDOOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.CHARRED_OAK_FENCE_GATE));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModItems.CHARRED_OAK_SIGN));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_PLANKS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_LOG));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STRIPPED_MIDAS_LOG));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_WOOD));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STRIPPED_MIDAS_WOOD));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_LEAVES));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_FENCE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_STAIRS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_BUTTON));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_PRESSURE_PLATE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_DOOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_TRAPDOOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.MIDAS_FENCE_GATE));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModItems.MIDAS_SIGN));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_PLANKS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_LOG));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STRIPPED_BANANA_LOG));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_WOOD));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.STRIPPED_BANANA_WOOD));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_LEAVES));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_SLAB));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_FENCE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_STAIRS));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_BUTTON));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_PRESSURE_PLATE));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_DOOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_TRAPDOOR));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BANANA_FENCE_GATE));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModItems.BANANA_SIGN));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.DARKSTEEL_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.DARKENED_STEEL_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.IRON_GOLD_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.COPPER_IRON_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.ROSE_GOLD_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.DARK_CHAMBER_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.LIGHT_CHAMBER_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BLUE_AGILITY_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.ORANGE_AGILITY_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.BLACK_AGILITY_BLOCK));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.FORGE));
        //ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(ModBlocks.SUPERFORGE));

        //items
        registerInGroup(group, ModItems.SENTINUM_SHARD);
        //registerInGroup(group, ModItems.SENTINUM_LENS);
        //registerInGroup(group, ModItems.SENTINUM_HOLOPROJECTOR);
        registerInGroup(group, ModItems.MUSIC_DISC_ASSASSINATION_UPLOAD);
        registerInGroup(group, ModItems.MUSIC_DISC_ODE_TO_TRANQUILITY);
        registerInGroup(group, ModItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT);
        registerInGroup(group, ModItems.MUSIC_DISC_RECITAL);
        registerInGroup(group, ModItems.SENTINUM_INGOT);
        registerInGroup(group, ModItems.GUNMETAL_INGOT);
        registerInGroup(group, ModItems.STEEL_SHEET);
        registerInGroup(group, ModItems.COPPER_IRON_INGOT);
        registerInGroup(group, ModItems.ROSE_GOLD_INGOT);
        registerInGroup(group, ModItems.IRON_GOLD_INGOT);
        registerInGroup(group, ModItems.TRANSITITE_SHARDS);
        registerInGroup(group, ModItems.ASH);
        registerInGroup(group, ModItems.DARKSTEEL_INGOT);
        registerInGroup(group, ModItems.REDSTONE_CRYSTAL);
        registerInGroup(group, ModItems.BLOOD_DIAMOND);
        registerInGroup(group, ModItems.VIOLENT_CATALYST);
        registerInGroup(group, ModItems.FERRAURIUM_DARKSTEEL_INGOT);
        registerInGroup(group, ModItems.URANIUM_CRYSTAL);
        registerInGroup(group, ModItems.STEEL_SIGN);
        registerInGroup(group, ModItems.HOLOGRAPHIC_SIGN);
        registerInGroup(group, ModItems.SENTINEL_SPAWN_EGG);
        registerInGroup(group, ModItems.ROOMBA_SPAWN_EGG);
        registerInGroup(group, ModItems.FLORBUS_SPAWN_EGG);
        //registerInGroup(group, ModItems.YGGDRASIL_BOAT);
        //registerInGroup(group, ModItems.YGGDRASIL_CHEST_BOAT);
        //registerInGroup(group, ModItems.CHARRED_OAK_BOAT);
        //registerInGroup(group, ModItems.CHARRED_OAK_CHEST_BOAT);
        //registerInGroup(group, ModItems.MIDAS_BOAT);
        //registerInGroup(group, ModItems.MIDAS_CHEST_BOAT);
        //registerInGroup(group, ModItems.BANANA_BOAT);
        //registerInGroup(group, ModItems.BANANA_CHEST_BOAT);
        //registerInGroup(group, ModItems.JUMP_DRIVE);
        //registerInGroup(group, ModItems.JETPACK);
        //registerInGroup(group, ModItems.PORTKEY);
        //registerInGroup(group, ModItems.DISTANCE_TRACKER);
        registerInGroup(group, ModItems.EMPTY_CAN);
        //registerInGroup(group, ModItems.VENDOR_TOKEN);
        //registerInGroup(group, ModItems.LEGENDARY_TOKEN);
        registerInGroup(group, ModItems.NUCLEAR_ROCKET);
        //registerInGroup(group, ModItems.SUPERFORGE_ITEM);

        //food
        registerInGroup(group, ModItems.FRIED_EGG);
        registerInGroup(group, ModItems.BANANA);
        registerInGroup(group, ModItems.RED_BANANA);
        registerInGroup(group, ModItems.BLUE_JAVA_BANANA);
        //registerInGroup(group, ModBlocks.RICE_BLOCK);
        registerInGroup(group, ModItems.RICE);
        registerInGroup(group, ModItems.RICE_CAKE);
        registerInGroup(group, ModItems.SUSHI_ROLL);
        //registerInGroup(group, ModBlocks.GOLDEN_RICE_BLOCK);
        registerInGroup(group, ModItems.GOLDEN_RICE);
        registerInGroup(group, ModItems.GOLDEN_RICE_CAKE);
        registerInGroup(group, ModItems.TORTILLA);
        registerInGroup(group, ModItems.BURRITO);
        registerInGroup(group, ModItems.PEARFRUIT);
        registerInGroup(group, ModItems.BROWNIE);
        registerInGroup(group, ModItems.SANDFISH);
        registerInGroup(group, ModItems.COOKED_SANDFISH);
        registerInGroup(group, ModItems.DUNE_EEL);
        registerInGroup(group, ModItems.ANTIMILK);
        registerInGroup(group, ModItems.BEETROOT_SOUP_CAN);
        registerInGroup(group, ModItems.MUSHROOM_STEW_CAN);
        registerInGroup(group, ModItems.RABBIT_STEW_CAN);
        registerInGroup(group, ModItems.MILK_CAN);
        registerInGroup(group, ModItems.COLA_ORANGE);
        registerInGroup(group, ModItems.COLA_GREEN);
        registerInGroup(group, ModItems.COLA_CYAN);

        //armory
        registerInGroup(group, ModArmory.FLIMSY_SENTINUM_SHIV);
        registerInGroup(group, ModArmory.FLIMSY_SENTINUM_PICKAXE);
        registerInGroup(group, ModArmory.FLIMSY_SENTINUM_HATCHET);
        registerInGroup(group, ModArmory.FLIMSY_SENTINUM_SPADE);
        registerInGroup(group, ModArmory.FLIMSY_SENTINUM_SCYTHE);
        registerInGroup(group, ModArmory.FLIMSY_SENTINUM_HAT);
        registerInGroup(group, ModArmory.FLIMSY_SENTINUM_CHESTPLATE);
        registerInGroup(group, ModArmory.FLIMSY_SENTINUM_LOINCLOTH);
        registerInGroup(group, ModArmory.FLIMSY_SENTINUM_SABATONS);

        registerInGroup(group, ModArmory.SENTINUM_DIRK);
        registerInGroup(group, ModArmory.SENTINUM_PICKAXE);
        registerInGroup(group, ModArmory.SENTINUM_CHAINSAW);
        registerInGroup(group, ModArmory.SENTINUM_SPADE);
        registerInGroup(group, ModArmory.SENTINUM_SCYTHE);
        registerInGroup(group, ModArmory.SENTINUM_VISOR);
        registerInGroup(group, ModArmory.SENTINUM_CUIRASS);
        registerInGroup(group, ModArmory.SENTINUM_KILT);
        registerInGroup(group, ModArmory.SENTINUM_SABATONS);

        registerInGroup(group, ModArmory.ROSE_GOLD_DAGGER);
        registerInGroup(group, ModArmory.ROSE_GOLD_PICKAXE);
        registerInGroup(group, ModArmory.ROSE_GOLD_BATTLEAXE);
        registerInGroup(group, ModArmory.ROSE_GOLD_SPADE);
        registerInGroup(group, ModArmory.ROSE_GOLD_SCYTHE);
        registerInGroup(group, ModArmory.ROSE_GOLD_HELM);
        registerInGroup(group, ModArmory.ROSE_GOLD_CUIRASS);
        registerInGroup(group, ModArmory.ROSE_GOLD_LEGGINGS);
        registerInGroup(group, ModArmory.ROSE_GOLD_SABATONS);

        registerInGroup(group, ModArmory.TRIMETAL_CROWBAR);
        registerInGroup(group, ModArmory.TRIMETAL_DRILL);
        registerInGroup(group, ModArmory.TRIMETAL_CLEAVER);
        registerInGroup(group, ModArmory.TRIMETAL_SHOVEL);
        registerInGroup(group, ModArmory.TRIMETAL_HOE);
        registerInGroup(group, ModArmory.TRIMETAL_HELMET);
        registerInGroup(group, ModArmory.TRIMETAL_HARNESS);
        registerInGroup(group, ModArmory.TRIMETAL_LEG_GUARDS);
        registerInGroup(group, ModArmory.TRIMETAL_BOOTS);

        registerInGroup(group, ModArmory.HUNTERS_VIBROBLADE);
        registerInGroup(group, ModArmory.HUNTERS_DRILL);
        registerInGroup(group, ModArmory.HUNTERS_CHAINSAW);
        registerInGroup(group, ModArmory.HUNTERS_SPADE);
        registerInGroup(group, ModArmory.HUNTERS_SCYTHE);
        registerInGroup(group, ModArmory.HUNTERS_VISOR);
        registerInGroup(group, ModArmory.HUNTERS_TORSO);
        registerInGroup(group, ModArmory.HUNTERS_LEGS);
        registerInGroup(group, ModArmory.HUNTERS_BOOTS);

        registerInGroup(group, ModArmory.CRYSTAL_DAGGER);
        registerInGroup(group, ModArmory.NUCLEAR_DRILL);
        registerInGroup(group, ModArmory.NUCLEAR_AXE);
        registerInGroup(group, ModArmory.NUCLEAR_SHOVEL);
        registerInGroup(group, ModArmory.NUCLEAR_SCYTHE);
        registerInGroup(group, ModArmory.HARDENED_N7_VISOR);
        registerInGroup(group, ModArmory.HARDENED_N7_CUIRASS);
        registerInGroup(group, ModArmory.HARDENED_N7_LEGGINGS);
        registerInGroup(group, ModArmory.HARDENED_N7_SABATONS);

        //registerInGroup(group, ModArmory.PAPPYM_BLADE);
        //registerInGroup(group, ModArmory.PAPPYD_BLADE);
        //registerInGroup(group, ModArmory.THANATU_BLADE);
        //registerInGroup(group, ModArmory.MORPHEUS_BLADE);
        //registerInGroup(group, ModArmory.SKYLAR_BLADE);
        //registerInGroup(group, ModArmory.LILITH_BLADE);
        //registerInGroup(group, ModArmory.TREVOR_BLADE);
        //registerInGroup(group, ModArmory.KINGS_BLADE);
        //registerInGroup(group, ModArmory.COPPER_ARM);

        registerInGroup(group, ModArmory.ZENITHIUM_PICKAXE);
        registerInGroup(group, ModArmory.ZENITHIUM_AXE);
        registerInGroup(group, ModArmory.ZENITHIUM_SHOVEL);
        registerInGroup(group, ModArmory.ZENITHIUM_HOE);
        registerInGroup(group, ModArmory.BLACKSMITHS_WELDING_MASK);
        registerInGroup(group, ModArmory.MAD_SCIENTISTS_LAB_COAT);
        registerInGroup(group, ModArmory.THANATU_SKULL);
        registerInGroup(group, ModArmory.THANATU_SHOULDERPADS);
        registerInGroup(group, ModArmory.ZENITHIUM_BODYSUIT_TORSO);
        registerInGroup(group, ModArmory.ZENITHIUM_BODYSUIT_PANTS);
        registerInGroup(group, ModArmory.SKYHOPPERS);
    }

    public static void installEffectItems(ItemGroup group){
        logInstall(group);
        registerInGroup(group, ModEffectItems.RESISTANCE_ITEM);
        registerInGroup(group, ModEffectItems.JUMP_BOOST_ITEM);
        registerInGroup(group, ModEffectItems.DOLPHINS_GRACE_ITEM);
        registerInGroup(group, ModEffectItems.HERO_OF_THE_VILLAGE_ITEM);
        registerInGroup(group, ModEffectItems.SENTINUM_STOMACH);
        registerInGroup(group, ModEffectItems.ONE_PENCE);
        registerInGroup(group, ModEffectItems.REDSTONE_BONG);
    }

    public static void logInstall(ItemGroup group){
        trevorssentinels.LOGGER.info("Installing unit [" + group.getDisplayName().getString() + "]... (" + MOD_ID + ")");
    }

    public static void registerInGroup(ItemGroup group, ItemConvertible item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }


    public static void registerAllGroupEvents(){
        installSentinels(trevorssentinels.SENTINELS);
        installEffectItems(trevorssentinels.EFFECTS);
        installBuildingBlocks(ItemGroups.BUILDING_BLOCKS); //00
        //installColoredBlocks(ItemGroups.COLORED_BLOCKS); //01
        installNaturalBlocks(ItemGroups.NATURAL); //02
        installFunctionalBlocks(ItemGroups.FUNCTIONAL); //03
        //installRedstoneBlocks(ItemGroups.REDSTONE); //04
        installTools(ItemGroups.TOOLS); //05
        installCombat(ItemGroups.COMBAT); //06
        installFoods(ItemGroups.FOOD_AND_DRINK); //07
        installIngredients(ItemGroups.INGREDIENTS); //08
        installSpawnEggs(ItemGroups.SPAWN_EGGS); //09
    }
}