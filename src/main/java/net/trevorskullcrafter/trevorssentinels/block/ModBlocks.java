package net.trevorskullcrafter.trevorssentinels.block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.custom.*;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModSignTypes;
import net.trevorskullcrafter.trevorssentinels.item.custom.NamedBlockItem;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.util.ColoredTextUtil.*;

public class ModBlocks {
    public static final Block SENTINUM_BLOCK = registerBlock("sentinum_block", flimsy_sentinum,
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.CALCITE).strength(3.5f,3f).requiresTool()));

    public static final Block CHISELED_SENTINUM_BLOCK = registerBlock("chiseled_sentinum_block", flimsy_sentinum,
            new Block(FabricBlockSettings.copy(ModBlocks.SENTINUM_BLOCK)));

    public static final Block SENTINUM_PILLAR = registerBlock("sentinum_pillar", flimsy_sentinum,
            new PillarBlock(FabricBlockSettings.copy(ModBlocks.SENTINUM_BLOCK)));

    public static final Block DATA_BLOCK = registerBlock("data_block", accent_blue,
            new DataBlock(FabricBlockSettings.copy(Blocks.HONEY_BLOCK).sounds(BlockSoundGroup.HONEY).luminance((state) -> 5).strength(0f,0f).nonOpaque()));

    public static final Block RICE_PLANT = registerBlockWithoutBlockItem("rice_plant",
            new RiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));

    public static final Block GOLDEN_RICE_PLANT = registerBlockWithoutBlockItem("golden_rice_plant",
            new GoldenRiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));

    public static final Block RICE_BLOCK = registerBlock("rice_block",
            new PillarBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK)));

    public static final Block GOLDEN_RICE_BLOCK = registerBlock("golden_rice_block",
            new PillarBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK)));

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).sounds(ModSounds.STEEL_SOUNDS).requiresTool()));

    public static final Block CAUTION_STEEL_BLOCK = registerBlock("caution_steel_block",
            new PillarBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));

    public static final Block STAINLESS_STEEL_BLOCK = registerBlock("stainless_steel_block",
            new Block(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));

    public static final Block STEEL_LAMP_BLOCK = registerBlock("steel_lamp_block",
            new SteelLampBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).luminance((state) -> state.get(SteelLampBlock.CLICKED) ? 15 : 0)));

    public static final Block STEEL_FAN = registerBlock("steel_fan",
            new Block(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));

    public static final Block RUSTED_STEEL_BLOCK = registerBlock("rusted_steel_block",
            new Block(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));

    public static final Block BATTERY = registerBlock("battery",
            new DirectionalBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));

    public static final Block FUSEBOX = registerBlock("fusebox",
            new DirectionalBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));

    public static final Block VENDOR = registerBlock("vendor",
            new VendorBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).luminance((state) -> 5)));

    public static final Block STEEL_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("steel_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN).sounds(ModSounds.STEEL_SOUNDS), ModSignTypes.STEEL));

    public static final Block STEEL_SIGN_BLOCK = registerBlockWithoutBlockItem("steel_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN).sounds(ModSounds.STEEL_SOUNDS), ModSignTypes.STEEL));

    public static final Block HOLOGRAPHIC_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.HOLOGRAPHIC));

    public static final Block HOLOGRAPHIC_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.HOLOGRAPHIC));

    public static final Block WAX_INFUSED_COPPER_BLOCK = registerBlock("wax_infused_copper_block",
            new DirectionalBlock(FabricBlockSettings.copy(Blocks.COPPER_BLOCK)));

    public static final Block HOLOBARRIER = registerBlockWithoutBlockItem("holobarrier",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque().strength(-1f,3600000f)));

    public static final Block URANIUM_BLOCK = registerBlock("uranium_block", nuclear,
            new UraniumBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(50f,1200f).requiresTool()));

    public static final Block URANIUM_ORE = registerBlock("uranium_ore", nuclear,
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(50f,1200f).requiresTool()));

    public static final Block NUCLEAR_CHARGE = registerBlock("nuclear_charge", nuclear,
            new NuclearChargeBlock(FabricBlockSettings.of(Material.TNT).sounds(ModSounds.STEEL_SOUNDS)));

    public static final Block CHISELED_END_STONE_BRICKS = registerBlock("chiseled_end_stone_bricks",
            new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));

    public static final Block CRACKED_END_STONE_BRICKS = registerBlock("cracked_end_stone_bricks",
            new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));

    public static final Block END_STONE_BRICK_COLUMN = registerBlock("end_stone_brick_column",
            new PillarBlock(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));

    public static final Block CHISELED_SNOWSTONE = registerBlock("chiseled_snowstone",
            new Block(FabricBlockSettings.copy(Blocks.CHISELED_SANDSTONE)));

    public static final Block CUT_SNOWSTONE = registerBlock("cut_snowstone",
            new Block(FabricBlockSettings.copy(Blocks.CUT_SANDSTONE)));

    public static final Block SNOWSTONE = registerBlock("snowstone",
            new Block(FabricBlockSettings.copy(Blocks.SANDSTONE)));

    public static final Block SMOOTH_SNOWSTONE = registerBlock("smooth_snowstone",
            new Block(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE)));

    public static final Block SNOWSTONE_SLAB = registerBlock("snowstone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.SANDSTONE_SLAB)));

    public static final Block CUT_SNOWSTONE_SLAB = registerBlock("cut_snowstone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.CUT_SANDSTONE_SLAB)));

    public static final Block SNOWSTONE_STAIRS = registerBlock("snowstone_stairs",
            new StairsBlock(ModBlocks.SNOWSTONE.getDefaultState(), FabricBlockSettings.copy(Blocks.SANDSTONE_STAIRS)));

    public static final Block SNOWSTONE_WALL = registerBlock("snowstone_wall",
            new WallBlock(FabricBlockSettings.copy(Blocks.SANDSTONE_WALL)));

    public static final Block SMOOTH_SNOWSTONE_STAIRS = registerBlock("smooth_snowstone_stairs",
            new StairsBlock(ModBlocks.SMOOTH_SNOWSTONE.getDefaultState(), FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_STAIRS)));

    public static final Block SMOOTH_SNOWSTONE_SLAB = registerBlock("smooth_snowstone_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_SLAB)));

    public static final Block DIRT_STAIRS = registerBlock("dirt_stairs",
            new StairsBlock(Blocks.DIRT.getDefaultState(), FabricBlockSettings.copy(Blocks.DIRT)));

    public static final Block DIRT_SLAB = registerBlock("dirt_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.DIRT)));

    public static final Block COARSE_DIRT_STAIRS = registerBlock("coarse_dirt_stairs",
            new StairsBlock(Blocks.COARSE_DIRT.getDefaultState(), FabricBlockSettings.copy(Blocks.COARSE_DIRT)));

    public static final Block COARSE_DIRT_SLAB = registerBlock("coarse_dirt_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.COARSE_DIRT)));

    public static final Block OVERGROWN_GRASS_BLOCK = registerBlock("overgrown_grass_block",
            new Block(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));

    public static final Block GRASS_STAIRS = registerBlock("grass_stairs",
            new StairsBlock(Blocks.GRASS_BLOCK.getDefaultState(), FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));

    public static final Block GRASS_SLAB = registerBlock("grass_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));

    public static final Block MOSS_STAIRS = registerBlock("moss_stairs",
            new StairsBlock(Blocks.MOSS_BLOCK.getDefaultState(), FabricBlockSettings.copy(Blocks.MOSS_BLOCK)));

    public static final Block MOSS_SLAB = registerBlock("moss_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.MOSS_BLOCK)));

    public static final Block FLESH_BLOCK = registerBlock("flesh_block", flesh_pink,
            new FallDamagelessBlock(0.5f, FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.RED).slipperiness(0.7f).strength(1.5F, 6.0F).sounds(BlockSoundGroup.CORAL)));

    public static final Block RED_BUTTON = registerBlock("red_button", accent_red,
            new ButtonBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).noCollision(), 5, false, SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON));

    public static final Block RED_PLATE = registerBlock("red_plate", accent_red,
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK), SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON));

    public static final Block YGGDRASIL_PLANKS = registerBlock("yggdrasil_planks", yggdrasil,
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    /*public static final Block YGGDRASIL_SAPLING = registerBlock("yggdrasil_sapling",
            new SaplingBlock(new YggdrasilSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));*/
    public static final Block YGGDRASIL_LOG = registerBlock("yggdrasil_log", yggdrasil,
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block STRIPPED_YGGDRASIL_LOG = registerBlock("stripped_yggdrasil_log", yggdrasil,
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block YGGDRASIL_WOOD = registerBlock("yggdrasil_wood", yggdrasil,
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_YGGDRASIL_WOOD = registerBlock("stripped_yggdrasil_wood", yggdrasil,
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block YGGDRASIL_LEAVES = registerBlock("yggdrasil_leaves", yggdrasil,
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block YGGDRASIL_SLAB = registerBlock("yggdrasil_slab", yggdrasil,
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block YGGDRASIL_FENCE = registerBlock("yggdrasil_fence", yggdrasil,
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)));
    public static final Block YGGDRASIL_STAIRS = registerBlock("yggdrasil_stairs", yggdrasil,
            new StairsBlock(ModBlocks.YGGDRASIL_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block YGGDRASIL_BUTTON = registerBlock("yggdrasil_button", yggdrasil,
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON), 30, true, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON));
    public static final Block YGGDRASIL_PRESSURE_PLATE = registerBlock("yggdrasil_pressure_plate", yggdrasil,
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE), SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON));
    public static final Block YGGDRASIL_DOOR = registerBlock("yggdrasil_door", yggdrasil,
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR), SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
    public static final Block YGGDRASIL_TRAPDOOR = registerBlock("yggdrasil_trapdoor", yggdrasil,
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR), SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN));
    public static final Block YGGDRASIL_FENCE_GATE = registerBlock("yggdrasil_fence_gate", yggdrasil,
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE), SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN));
    public static final Block YGGDRASIL_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("yggdrasil_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.YGGDRASIL));
    public static final Block YGGDRASIL_SIGN_BLOCK = registerBlockWithoutBlockItem("yggdrasil_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.YGGDRASIL));

    public static final Block CHARRED_OAK_PLANKS = registerBlock("charred_oak_planks", charred_oak,
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CHARRED_OAK_LOG = registerBlock("charred_oak_log", charred_oak,
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block STRIPPED_CHARRED_OAK_LOG = registerBlock("stripped_charred_oak_log", charred_oak,
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block CHARRED_OAK_WOOD = registerBlock("charred_oak_wood", charred_oak,
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_CHARRED_OAK_WOOD = registerBlock("stripped_charred_oak_wood", charred_oak,
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CHARRED_OAK_SLAB = registerBlock("charred_oak_slab", charred_oak,
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block CHARRED_OAK_FENCE = registerBlock("charred_oak_fence", charred_oak,
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)));
    public static final Block CHARRED_OAK_STAIRS = registerBlock("charred_oak_stairs", charred_oak,
            new StairsBlock(ModBlocks.CHARRED_OAK_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block CHARRED_OAK_BUTTON = registerBlock("charred_oak_button", charred_oak,
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON), 30, true, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON));
    public static final Block CHARRED_OAK_PRESSURE_PLATE = registerBlock("charred_oak_pressure_plate", charred_oak,
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE), SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON));
    public static final Block CHARRED_OAK_DOOR = registerBlock("charred_oak_door", charred_oak,
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR), SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
    public static final Block CHARRED_OAK_TRAPDOOR = registerBlock("charred_oak_trapdoor", charred_oak,
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR),SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
    public static final Block CHARRED_OAK_FENCE_GATE = registerBlock("charred_oak_fence_gate", charred_oak,
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE), SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN));
    public static final Block CHARRED_OAK_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("charred_oak_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.YGGDRASIL));
    public static final Block CHARRED_OAK_SIGN_BLOCK = registerBlockWithoutBlockItem("charred_oak_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.YGGDRASIL));

    public static final Block MIDAS_PLANKS = registerBlock("midas_planks", midas,
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    /*public static final Block MIDAS_SAPLING = registerBlock("midas_sapling",
            new SaplingBlock(new MidasSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));*/
    public static final Block MIDAS_LOG = registerBlock("midas_log", midas,
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block STRIPPED_MIDAS_LOG = registerBlock("stripped_midas_log", midas,
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block MIDAS_WOOD = registerBlock("midas_wood", midas,
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_MIDAS_WOOD = registerBlock("stripped_midas_wood", midas,
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block MIDAS_LEAVES = registerBlock("midas_leaves", midas,
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block MIDAS_SLAB = registerBlock("midas_slab", midas,
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block MIDAS_FENCE = registerBlock("midas_fence", midas,
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)));
    public static final Block MIDAS_STAIRS = registerBlock("midas_stairs", midas,
            new StairsBlock(ModBlocks.MIDAS_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block MIDAS_BUTTON = registerBlock("midas_button", midas,
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON), 30, true, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON));
    public static final Block MIDAS_PRESSURE_PLATE = registerBlock("midas_pressure_plate", midas,
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE), SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON));
    public static final Block MIDAS_DOOR = registerBlock("midas_door", midas,
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR), SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
    public static final Block MIDAS_TRAPDOOR = registerBlock("midas_trapdoor", midas,
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR), SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN));
    public static final Block MIDAS_FENCE_GATE = registerBlock("midas_fence_gate", midas,
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE), SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN));
    public static final Block MIDAS_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("midas_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.MIDAS));
    public static final Block MIDAS_SIGN_BLOCK = registerBlockWithoutBlockItem("midas_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.MIDAS));

    public static final Block BANANA_PLANKS = registerBlock("banana_planks", viridian,
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    /*public static final Block BANANA_SAPLING = registerBlock("banana_sapling",
            new SaplingBlock(new BananaSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));*/
    public static final Block BANANA_LOG = registerBlock("banana_log", viridian,
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block STRIPPED_BANANA_LOG = registerBlock("stripped_banana_log", viridian,
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block BANANA_WOOD = registerBlock("banana_wood", viridian,
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_BANANA_WOOD = registerBlock("stripped_banana_wood", viridian,
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block BANANA_LEAVES = registerBlock("banana_leaves", viridian,
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block BANANA_SLAB = registerBlock("banana_slab", viridian,
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    public static final Block BANANA_FENCE = registerBlock("banana_fence", viridian,
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE)));
    public static final Block BANANA_STAIRS = registerBlock("banana_stairs", viridian,
            new StairsBlock(ModBlocks.BANANA_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block BANANA_BUTTON = registerBlock("banana_button", viridian,
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON), 30, true, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON));
    public static final Block BANANA_PRESSURE_PLATE = registerBlock("banana_pressure_plate", viridian,
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE), SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON));
    public static final Block BANANA_DOOR = registerBlock("banana_door", viridian,
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR), SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
    public static final Block BANANA_TRAPDOOR = registerBlock("banana_trapdoor", viridian,
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR), SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN));
    public static final Block BANANA_FENCE_GATE = registerBlock("banana_fence_gate", viridian,
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE), SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN));
    public static final Block BANANA_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("banana_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.BANANA));
    public static final Block BANANA_SIGN_BLOCK = registerBlockWithoutBlockItem("banana_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.BANANA));

    public static final Block DARKSTEEL_BLOCK = registerBlock("darksteel_block", darksteel,
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.NETHERITE).strength(8f,12f).requiresTool()));

    public static final Block DARKENED_STEEL_BLOCK = registerBlock("darkened_steel_block", darksteel,
            new Block(FabricBlockSettings.copy(ModBlocks.DARKSTEEL_BLOCK)));

    public static final Block IRON_GOLD_BLOCK = registerBlock("iron_gold_block", iron_gold,
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).requiresTool()));

    public static final Block COPPER_IRON_BLOCK = registerBlock("copper_iron_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).requiresTool()));

    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block", rose_gold,
            new Block(FabricBlockSettings.of(Material.METAL).strength(5f,7f).requiresTool()));

    public static final Block DARK_CHAMBER_BLOCK = registerBlock("dark_chamber_block",
            new FallDamagelessBlock(0.0f, FabricBlockSettings.of(Material.SHULKER_BOX).sounds(BlockSoundGroup.NETHER_STEM).strength(2f,4f)));

    public static final Block LIGHT_CHAMBER_BLOCK = registerBlock("light_chamber_block",
            new FallDamagelessBlock(0.0f, FabricBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK)));

    public static final Block BLUE_AGILITY_BLOCK = registerBlock("blue_agility_block", accent_blue,
            new FallDamagelessBlock(0.0f, FabricBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).sounds(BlockSoundGroup.SLIME).jumpVelocityMultiplier(2.7f).slipperiness(0.989f)));

    public static final Block ORANGE_AGILITY_BLOCK = registerBlock("orange_agility_block", accent_gold,
            new FallDamagelessBlock(0.0f, FabricBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).sounds(BlockSoundGroup.SLIME).velocityMultiplier(1.4f).slipperiness(0.75f)));

    public static final Block BLACK_AGILITY_BLOCK = registerBlock("black_agility_block",
            new Block(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).slipperiness(/*1.098*/1.2f)));

    public static final Block FORGE = registerBlock("forge",
            new ForgeBlock(FabricBlockSettings.of(Material.STONE).strength(3.5f,3.5f).requiresTool()));

    public static final Block SUPERFORGE = registerBlockWithoutBlockItem("superforge",
            new SuperforgeBlock(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(50f,1200f).nonOpaque().requiresTool()));

    private static Block registerBlock(String name, String color, Block block){
        registerBlockItem(name, color, block);
        return Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, String color, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name),
                new NamedBlockItem(block, color, new FabricItemSettings()));
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name),
                new NamedBlockItem(block, "#FFFFFF", new FabricItemSettings()));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block);
    }

    public static void registerModBlocks(){
        trevorssentinels.LOGGER.info("Registering blocks... (" + trevorssentinels.MOD_ID + ")");
    }
}