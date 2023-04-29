package net.trevorskullcrafter.trevorssentinels.block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.custom.*;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModSignTypes;
import net.trevorskullcrafter.trevorssentinels.block.sapling.CeruliiSaplingGenerator;
import net.trevorskullcrafter.trevorssentinels.block.sapling.MidasSaplingGenerator;
import net.trevorskullcrafter.trevorssentinels.block.sapling.ViridescentSaplingGenerator;
import net.trevorskullcrafter.trevorssentinels.block.sapling.YggdrasilSaplingGenerator;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModBlocks {
    public static final Block GALINITE_BLOCK = registerBlock("galinite_block", new Block(FabricBlockSettings.of(Material.METAL)
            .sounds(BlockSoundGroup.CALCITE).mapColor(MapColor.GRAY).strength(3.5f,3f).requiresTool()));
    public static final Block CHISELED_GALINITE_BLOCK = registerBlock("chiseled_galinite_block", new Block(FabricBlockSettings.copy(ModBlocks.GALINITE_BLOCK)));
    public static final Block GALINITE_PILLAR = registerBlock("galinite_pillar", new PillarBlock(FabricBlockSettings.copy(ModBlocks.GALINITE_BLOCK)));
    public static final Block DATA_BLOCK = registerBlock("data_block", new DataBlock(FabricBlockSettings.copy(Blocks.HONEY_BLOCK).mapColor(MapColor.CYAN)
            .sounds(BlockSoundGroup.HONEY).luminance((state) -> 5).strength(0f,0f).nonOpaque()));
    public static final Block RICE_PLANT = registerBlockWithoutBlockItem("rice_plant", new RiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));
    public static final Block GOLDEN_RICE_PLANT = registerBlockWithoutBlockItem("golden_rice_plant", new RiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.GOLD).nonOpaque()));
    public static final Block RICE_BLOCK = registerBlock("rice_block", new PillarBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK)));
    public static final Block GOLDEN_RICE_BLOCK = registerBlock("golden_rice_block", new PillarBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK).mapColor(MapColor.GOLD)));

    public static final Block STEEL_BLOCK = registerBlock("steel_block", new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f)
            .mapColor(MapColor.STONE_GRAY).sounds(ModSounds.STEEL_SOUNDS).requiresTool()));
    public static final Block CAUTION_STEEL_BLOCK = registerBlock("caution_steel_block", new PillarBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block STAINLESS_STEEL_BLOCK = registerBlock("stainless_steel_block", new Block(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block STEEL_LAMP_BLOCK = registerBlock("steel_lamp_block", new ToggleableLampBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)
            .mapColor(MapColor.PALE_YELLOW).luminance((state) -> state.get(ToggleableLampBlock.CLICKED) ? 15 : 0)));
    public static final Block STEEL_FAN = registerBlock("steel_fan", new Block(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block RUSTED_STEEL_BLOCK = registerBlock("rusted_steel_block", new Block(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block BATTERY = registerBlock("battery", new DirectionalBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block FUSEBOX = registerBlock("fusebox", new DirectionalBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK)));
    public static final Block STEEL_LADDER = registerBlock("steel_ladder", new LadderBlock(FabricBlockSettings.copy(Blocks.LADDER).nonOpaque()
            .sounds(ModSounds.STEEL_SOUNDS).strength(6f, 8f).requiresTool()));
    public static final Block VENDOR = registerBlock("vendor", new VendorBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).mapColor(MapColor.RED).luminance((state) -> 5)));
    public static final Block FANCY_COMPUTER = registerBlock("fancy_computer", new DirectionalBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).nonOpaque()));
    public static final Block STEEL_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("steel_wall_sign", new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN).sounds(ModSounds.STEEL_SOUNDS), ModSignTypes.STEEL));
    public static final Block STEEL_SIGN_BLOCK = registerBlockWithoutBlockItem("steel_sign", new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN).sounds(ModSounds.STEEL_SOUNDS), ModSignTypes.STEEL));
    public static final Block HOLOGRAPHIC_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_wall_sign", new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.HOLOGRAPHIC));
    public static final Block HOLOGRAPHIC_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_sign", new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.HOLOGRAPHIC));

    public static final Block TRANSITITE_BLOCK = registerBlock("transitite_block", new Block(FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK).nonOpaque()
            .mapColor(MapColor.LIGHT_GRAY)));

    public static final Block WAX_INFUSED_COPPER_BLOCK = registerBlock("wax_infused_copper_block", new DirectionalBlock(FabricBlockSettings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.ORANGE)));
    public static final Block HOLOBARRIER = registerBlockWithoutBlockItem("holobarrier", new HardLightBlock(FabricBlockSettings.copy(Blocks.CYAN_STAINED_GLASS)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque().strength(-1f,3600000f)));
    public static final Block URANIUM_BLOCK = registerBlock("uranium_block", new UraniumBlock(FabricBlockSettings.of(Material.STONE)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(50f,1200f).mapColor(MapColor.EMERALD_GREEN).requiresTool()),
            new FabricItemSettings().fireproof());
    public static final Block URANIUM_ORE = registerBlock("uranium_ore", new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE)
            .sounds(BlockSoundGroup.STONE).strength(50f,1200f).mapColor(MapColor.EMERALD_GREEN).requiresTool()),
            new FabricItemSettings().fireproof());
    public static final Block NUCLEAR_CHARGE = registerBlock("nuclear_charge", new NuclearChargeBlock(FabricBlockSettings.of(Material.TNT).mapColor(MapColor.EMERALD_GREEN).sounds(ModSounds.STEEL_SOUNDS)),
            new FabricItemSettings().fireproof());
    public static final Block CHISELED_END_STONE_BRICKS = registerBlock("chiseled_end_stone_bricks", new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block CRACKED_END_STONE_BRICKS = registerBlock("cracked_end_stone_bricks", new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block END_STONE_BRICK_COLUMN = registerBlock("end_stone_brick_column", new PillarBlock(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block CHISELED_SNOWSTONE = registerBlock("chiseled_snowstone", new Block(FabricBlockSettings.copy(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.OFF_WHITE)));
    public static final Block CUT_SNOWSTONE = registerBlock("cut_snowstone", new Block(FabricBlockSettings.copy(Blocks.CUT_SANDSTONE).mapColor(MapColor.OFF_WHITE)));
    public static final Block SNOWSTONE = registerBlock("snowstone", new Block(FabricBlockSettings.copy(Blocks.SANDSTONE).mapColor(MapColor.OFF_WHITE)));
    public static final Block SMOOTH_SNOWSTONE = registerBlock("smooth_snowstone", new Block(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE).mapColor(MapColor.OFF_WHITE)));
    public static final Block SNOWSTONE_SLAB = registerBlock("snowstone_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.SANDSTONE_SLAB).mapColor(MapColor.OFF_WHITE)));
    public static final Block CUT_SNOWSTONE_SLAB = registerBlock("cut_snowstone_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.CUT_SANDSTONE_SLAB).mapColor(MapColor.OFF_WHITE)));
    public static final Block SNOWSTONE_STAIRS = registerBlock("snowstone_stairs", new StairsBlock(ModBlocks.SNOWSTONE.getDefaultState(), FabricBlockSettings.copy(Blocks.SANDSTONE_STAIRS).mapColor(MapColor.OFF_WHITE)));
    public static final Block SNOWSTONE_WALL = registerBlock("snowstone_wall", new WallBlock(FabricBlockSettings.copy(Blocks.SANDSTONE_WALL).mapColor(MapColor.OFF_WHITE)));
    public static final Block SMOOTH_SNOWSTONE_STAIRS = registerBlock("smooth_snowstone_stairs", new StairsBlock(ModBlocks.SMOOTH_SNOWSTONE.getDefaultState(),
            FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_STAIRS).mapColor(MapColor.OFF_WHITE)));
    public static final Block SMOOTH_SNOWSTONE_SLAB = registerBlock("smooth_snowstone_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_SLAB).mapColor(MapColor.OFF_WHITE)));
    public static final Block DIRT_STAIRS = registerBlock("dirt_stairs", new StairsBlock(Blocks.DIRT.getDefaultState(), FabricBlockSettings.copy(Blocks.DIRT)));
    public static final Block DIRT_SLAB = registerBlock("dirt_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.DIRT)));
    public static final Block COARSE_DIRT_STAIRS = registerBlock("coarse_dirt_stairs", new StairsBlock(Blocks.COARSE_DIRT.getDefaultState(), FabricBlockSettings.copy(Blocks.COARSE_DIRT)));
    public static final Block COARSE_DIRT_SLAB = registerBlock("coarse_dirt_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.COARSE_DIRT)));
    public static final Block OVERGROWN_GRASS_BLOCK = registerBlock("overgrown_grass_block", new Block(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block GRASS_STAIRS = registerBlock("grass_stairs", new StairsBlock(Blocks.GRASS_BLOCK.getDefaultState(), FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block GRASS_SLAB = registerBlock("grass_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block MOSS_STAIRS = registerBlock("moss_stairs", new StairsBlock(Blocks.MOSS_BLOCK.getDefaultState(), FabricBlockSettings.copy(Blocks.MOSS_BLOCK)));
    public static final Block MOSS_SLAB = registerBlock("moss_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.MOSS_BLOCK)));
    public static final Block FLESH_BLOCK = registerBlock("flesh_block",
            new FleshBlock(0.5f, ModSounds.FLESH_AMBIENT, FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.RED).slipperiness(0.7f).strength(1.5F, 6.0F).sounds(ModSounds.FLESH_SOUNDS)));
    public static final Block FLESH_VEINS = registerBlock("flesh_veins", new FleshVeinBlock(FabricBlockSettings.copy(Blocks.GLOW_LICHEN).strength(0.7F, 3.0F).luminance((state) -> 0).sounds(ModSounds.FLESH_SOUNDS)));
    public static final Block FLESHY_EYE = registerBlock("fleshy_eye", new FleshyEyeBlock(FabricBlockSettings.copy(ModBlocks.FLESH_BLOCK)
            .mapColor(MapColor.YELLOW).luminance((state) -> state.get(ToggleableLampBlock.CLICKED) ? 8 : 0)));
    public static final Block RED_BUTTON = registerBlock("red_button", new ButtonBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).noCollision().mapColor(MapColor.BRIGHT_RED),
            5, false, SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON));
    public static final Block RED_PLATE = registerBlock("red_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).mapColor(MapColor.BRIGHT_RED),
                    SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON));

    public static final Block YGGDRASIL_PLANKS = registerBlock("yggdrasil_planks", new Block(FabricBlockSettings.copy(Blocks.WARPED_PLANKS).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_SAPLING = registerBlock("yggdrasil_sapling",new SaplingBlock(new YggdrasilSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_YGGDRASIL_SAPLING = registerBlockWithoutBlockItem("potted_yggdrasil_sapling", new FlowerPotBlock(YGGDRASIL_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block YGGDRASIL_LOG = registerBlock("yggdrasil_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.OFF_WHITE)));
    public static final Block STRIPPED_YGGDRASIL_LOG = registerBlock("stripped_yggdrasil_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_WOOD = registerBlock("yggdrasil_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.OFF_WHITE)));
    public static final Block STRIPPED_YGGDRASIL_WOOD = registerBlock("stripped_yggdrasil_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_LEAVES = registerBlock("yggdrasil_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.MAGENTA)));
    public static final Block YGGDRASIL_SLAB = registerBlock("yggdrasil_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.WARPED_SLAB).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_FENCE = registerBlock("yggdrasil_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.WARPED_FENCE).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_STAIRS = registerBlock("yggdrasil_stairs", new StairsBlock(ModBlocks.YGGDRASIL_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.WARPED_STAIRS).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_BUTTON = registerBlock("yggdrasil_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.WARPED_BUTTON).mapColor(MapColor.OFF_WHITE),
            30, true, SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_OFF, SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_ON));
    public static final Block YGGDRASIL_PRESSURE_PLATE = registerBlock("yggdrasil_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.WARPED_PRESSURE_PLATE)
                    .mapColor(MapColor.OFF_WHITE), SoundEvents.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_ON));
    public static final Block YGGDRASIL_DOOR = registerBlock("yggdrasil_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.WARPED_DOOR).mapColor(MapColor.OFF_WHITE), SoundEvents.BLOCK_NETHER_WOOD_DOOR_CLOSE, SoundEvents.BLOCK_NETHER_WOOD_DOOR_OPEN));
    public static final Block YGGDRASIL_TRAPDOOR = registerBlock("yggdrasil_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.OFF_WHITE), SoundEvents.BLOCK_NETHER_WOOD_TRAPDOOR_CLOSE, SoundEvents.BLOCK_NETHER_WOOD_TRAPDOOR_OPEN));
    public static final Block YGGDRASIL_FENCE_GATE = registerBlock("yggdrasil_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.OFF_WHITE), SoundEvents.BLOCK_NETHER_WOOD_FENCE_GATE_CLOSE, SoundEvents.BLOCK_NETHER_WOOD_FENCE_GATE_OPEN));
    public static final Block YGGDRASIL_SIGN_BLOCK = registerBlockWithoutBlockItem("yggdrasil_sign", new SignBlock(FabricBlockSettings.copy(Blocks.WARPED_SIGN), ModSignTypes.YGGDRASIL));
    public static final Block YGGDRASIL_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("yggdrasil_wall_sign", new WallSignBlock(FabricBlockSettings.copy(Blocks.WARPED_WALL_SIGN), ModSignTypes.YGGDRASIL));
    public static final Block YGGDRASIL_HANGING_SIGN = registerBlockWithoutBlockItem("yggdrasil_hanging_sign", new HangingSignBlock(FabricBlockSettings.of(Material.WOOD, YGGDRASIL_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.YGGDRASIL));
    public static final Block YGGDRASIL_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("yggdrasil_wall_hanging_sign", new WallHangingSignBlock(FabricBlockSettings.of(Material.WOOD, YGGDRASIL_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.YGGDRASIL));

    public static final Block CHARRED_OAK_PLANKS = registerBlock("charred_oak_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_OAK_LOG = registerBlock("charred_oak_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block STRIPPED_CHARRED_OAK_LOG = registerBlock("stripped_charred_oak_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_OAK_WOOD = registerBlock("charred_oak_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block STRIPPED_CHARRED_OAK_WOOD = registerBlock("stripped_charred_oak_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_OAK_SLAB = registerBlock("charred_oak_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_OAK_FENCE = registerBlock("charred_oak_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_OAK_STAIRS = registerBlock("charred_oak_stairs", new StairsBlock(ModBlocks.CHARRED_OAK_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_OAK_BUTTON = registerBlock("charred_oak_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GRAY),
            30, true, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON));
    public static final Block CHARRED_OAK_PRESSURE_PLATE = registerBlock("charred_oak_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE)
                    .mapColor(MapColor.GRAY), SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON));
    public static final Block CHARRED_OAK_DOOR = registerBlock("charred_oak_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.GRAY), SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
    public static final Block CHARRED_OAK_TRAPDOOR = registerBlock("charred_oak_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GRAY),SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
    public static final Block CHARRED_OAK_FENCE_GATE = registerBlock("charred_oak_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GRAY), SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN));
    public static final Block CHARRED_OAK_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("charred_oak_wall_sign", new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.CHARRED_OAK));
    public static final Block CHARRED_OAK_SIGN_BLOCK = registerBlockWithoutBlockItem("charred_oak_sign", new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.CHARRED_OAK));
    public static final Block CHARRED_OAK_HANGING_SIGN = registerBlockWithoutBlockItem("charred_oak_hanging_sign", new HangingSignBlock(FabricBlockSettings.of(Material.WOOD, CHARRED_OAK_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.CHARRED_OAK));
    public static final Block CHARRED_OAK_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("charred_oak_wall_hanging_sign", new WallHangingSignBlock(FabricBlockSettings.of(Material.WOOD, CHARRED_OAK_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.CHARRED_OAK));

    public static final Block MIDAS_PLANKS = registerBlock("midas_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_SAPLING = registerBlock("midas_sapling",new SaplingBlock(new MidasSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_MIDAS_SAPLING = registerBlockWithoutBlockItem("potted_midas_sapling", new FlowerPotBlock(MIDAS_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block MIDAS_LOG = registerBlock("midas_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.GOLD)));
    public static final Block STRIPPED_MIDAS_LOG = registerBlock("stripped_midas_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_WOOD = registerBlock("midas_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.GOLD)));
    public static final Block STRIPPED_MIDAS_WOOD = registerBlock("stripped_midas_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_LEAVES = registerBlock("midas_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.EMERALD_GREEN)));
    public static final Block MIDAS_SLAB = registerBlock("midas_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_FENCE = registerBlock("midas_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_STAIRS = registerBlock("midas_stairs", new StairsBlock(ModBlocks.MIDAS_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GOLD)));
    public static final Block MIDAS_BUTTON = registerBlock("midas_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GOLD),
            30, true, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON));
    public static final Block MIDAS_PRESSURE_PLATE = registerBlock("midas_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GOLD), SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON));
    public static final Block MIDAS_DOOR = registerBlock("midas_door", new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.GOLD), SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
    public static final Block MIDAS_TRAPDOOR = registerBlock("midas_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GOLD), SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN));
    public static final Block MIDAS_FENCE_GATE = registerBlock("midas_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GOLD), SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN));
    public static final Block MIDAS_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("midas_wall_sign", new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.MIDAS));
    public static final Block MIDAS_SIGN_BLOCK = registerBlockWithoutBlockItem("midas_sign", new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.MIDAS));
    public static final Block MIDAS_HANGING_SIGN = registerBlockWithoutBlockItem("midas_hanging_sign", new HangingSignBlock(FabricBlockSettings.of(Material.WOOD, MIDAS_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.MIDAS));
    public static final Block MIDAS_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("midas_wall_hanging_sign", new WallHangingSignBlock(FabricBlockSettings.of(Material.WOOD, MIDAS_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.MIDAS));

    public static final Block BANANA_PLANKS = registerBlock("banana_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN)));
    public static final Block BANANA_SAPLING = registerBlock("banana_sapling",new SaplingBlock(new ViridescentSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_BANANA_SAPLING = registerBlockWithoutBlockItem("potted_banana_sapling", new FlowerPotBlock(BANANA_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block BANANA_LOG = registerBlock("banana_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.GREEN).sounds(BlockSoundGroup.NETHER_WOOD)));
    public static final Block STRIPPED_BANANA_LOG = registerBlock("stripped_banana_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GREEN).sounds(BlockSoundGroup.NETHER_WOOD)));
    public static final Block BANANA_WOOD = registerBlock("banana_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN)));
    public static final Block STRIPPED_BANANA_WOOD = registerBlock("stripped_banana_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN)));
    public static final Block BANANA_LEAVES = registerBlock("banana_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.GREEN)));
    public static final Block BANANA_SLAB = registerBlock("banana_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN)));
    public static final Block BANANA_FENCE = registerBlock("banana_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN)));
    public static final Block BANANA_STAIRS = registerBlock("banana_stairs", new StairsBlock(ModBlocks.BANANA_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN)));
    public static final Block BANANA_BUTTON = registerBlock("banana_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN),
            30, true, SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_OFF, SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_ON));
    public static final Block BANANA_PRESSURE_PLATE = registerBlock("banana_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.BAMBOO_PRESSURE_PLATE)
                    .sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN), SoundEvents.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_ON));
    public static final Block BANANA_DOOR = registerBlock("banana_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.BAMBOO_DOOR).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN), SoundEvents.BLOCK_NETHER_WOOD_DOOR_CLOSE, SoundEvents.BLOCK_NETHER_WOOD_DOOR_OPEN));
    public static final Block BANANA_TRAPDOOR = registerBlock("banana_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.BAMBOO_TRAPDOOR).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN), SoundEvents.BLOCK_NETHER_WOOD_TRAPDOOR_CLOSE, SoundEvents.BLOCK_NETHER_WOOD_TRAPDOOR_OPEN));
    public static final Block BANANA_FENCE_GATE = registerBlock("banana_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.BAMBOO_FENCE_GATE).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN), SoundEvents.BLOCK_NETHER_WOOD_FENCE_GATE_CLOSE, SoundEvents.BLOCK_NETHER_WOOD_FENCE_GATE_OPEN));
    public static final Block BANANA_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("banana_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.BAMBOO_WALL_SIGN).sounds(BlockSoundGroup.NETHER_WOOD).mapColor(MapColor.GREEN), ModSignTypes.BANANA));
    public static final Block BANANA_SIGN_BLOCK = registerBlockWithoutBlockItem("banana_sign", new SignBlock(FabricBlockSettings.copy(Blocks.BAMBOO_SIGN).sounds(BlockSoundGroup.NETHER_WOOD), ModSignTypes.BANANA));
    public static final Block BANANA_HANGING_SIGN = registerBlockWithoutBlockItem("banana_hanging_sign", new HangingSignBlock(FabricBlockSettings.of(Material.WOOD, BANANA_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.BANANA));
    public static final Block BANANA_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("banana_wall_hanging_sign", new WallHangingSignBlock(FabricBlockSettings.of(Material.WOOD, BANANA_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.BANANA));

    public static final Block CERULII_PLANKS = registerBlock("cerulii_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.BLUE)));
    public static final Block CERULII_SAPLING = registerBlock("cerulii_sapling",new SaplingBlock(new CeruliiSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_CERULII_SAPLING = registerBlockWithoutBlockItem("potted_cerulii_sapling", new FlowerPotBlock(CERULII_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block CERULII_LOG = registerBlock("cerulii_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.BLUE)));
    public static final Block STRIPPED_CERULII_LOG = registerBlock("stripped_cerulii_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.BLUE)));
    public static final Block CERULII_WOOD = registerBlock("cerulii_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.BLUE)));
    public static final Block STRIPPED_CERULII_WOOD = registerBlock("stripped_cerulii_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.BLUE)));
    public static final Block CERULII_LEAVES = registerBlock("cerulii_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.BLUE)));
    public static final Block CERULII_SLAB = registerBlock("cerulii_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.BLUE)));
    public static final Block CERULII_FENCE = registerBlock("cerulii_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.BLUE)));
    public static final Block CERULII_STAIRS = registerBlock("cerulii_stairs", new StairsBlock(ModBlocks.CERULII_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.BLUE)));
    public static final Block CERULII_BUTTON = registerBlock("cerulii_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.BLUE),
            30, true, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON));
    public static final Block CERULII_PRESSURE_PLATE = registerBlock("cerulii_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.BLUE), SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON));
    public static final Block CERULII_DOOR = registerBlock("cerulii_door", new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.BLUE), SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN));
    public static final Block CERULII_TRAPDOOR = registerBlock("cerulii_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.BLUE), SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN));
    public static final Block CERULII_FENCE_GATE = registerBlock("cerulii_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.BLUE), SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundEvents.BLOCK_FENCE_GATE_OPEN));
    public static final Block CERULII_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("cerulii_wall_sign", new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN).mapColor(MapColor.BLUE), ModSignTypes.CERULII));
    public static final Block CERULII_SIGN_BLOCK = registerBlockWithoutBlockItem("cerulii_sign", new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.CERULII));
    public static final Block CERULII_HANGING_SIGN = registerBlockWithoutBlockItem("cerulii_hanging_sign", new HangingSignBlock(FabricBlockSettings.of(Material.WOOD, CERULII_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.CERULII));
    public static final Block CERULII_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("cerulii_wall_hanging_sign", new WallHangingSignBlock(FabricBlockSettings.of(Material.WOOD, CERULII_LOG.getDefaultMapColor()).noCollision().strength(1.0F).sounds(BlockSoundGroup.HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20), ModSignTypes.CERULII));

    public static final Block DARKSTEEL_BLOCK = registerBlock("darksteel_block",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.NETHERITE).mapColor(MapColor.TERRACOTTA_PURPLE).strength(8f,12f).requiresTool()));
    public static final Block DARKENED_STEEL_BLOCK = registerBlock("darkened_steel_block",
            new Block(FabricBlockSettings.copy(ModBlocks.DARKSTEEL_BLOCK).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block IRON_GOLD_BLOCK = registerBlock("iron_gold_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).mapColor(MapColor.YELLOW).requiresTool()));
    public static final Block COPPER_IRON_BLOCK = registerBlock("copper_iron_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).mapColor(MapColor.RAW_IRON_PINK).requiresTool()));
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            new Block(FabricBlockSettings.of(Material.METAL).mapColor(MapColor.RAW_IRON_PINK).strength(5f,7f).requiresTool()));
    public static final Block DARK_CHAMBER_BLOCK = registerBlock("dark_chamber_block", new FallDamagelessBlock(0.0f,
            FabricBlockSettings.of(Material.SHULKER_BOX).mapColor(MapColor.BLACK).sounds(BlockSoundGroup.NETHER_STEM).strength(2f,4f)));
    public static final Block LIGHT_CHAMBER_BLOCK = registerBlock("light_chamber_block", new FallDamagelessBlock(0.0f,
            FabricBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).mapColor(MapColor.WHITE)));
    public static final Block BLUE_AGILITY_BLOCK = registerBlock("blue_agility_block", new FallDamagelessBlock(0.0f,
            FabricBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).sounds(BlockSoundGroup.SLIME).mapColor(MapColor.CYAN).jumpVelocityMultiplier(2.7f).slipperiness(0.989f)));
    public static final Block ORANGE_AGILITY_BLOCK = registerBlock("orange_agility_block", new FallDamagelessBlock(0.0f,
            FabricBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).sounds(BlockSoundGroup.SLIME).mapColor(MapColor.ORANGE).velocityMultiplier(1.4f).slipperiness(0.75f)));
    public static final Block BLACK_AGILITY_BLOCK = registerBlock("black_agility_block",
            new Block(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).slipperiness(/*1.098*/1.2f).mapColor(MapColor.LIGHT_BLUE)));
    public static final Block FORGE = registerBlock("forge",
            new ForgeBlock(FabricBlockSettings.of(Material.STONE).strength(3.5f,3.5f).mapColor(MapColor.BRIGHT_TEAL).requiresTool()));
    public static final Block SUPERFORGE = registerBlock("superforge", new SuperforgeBlock(FabricBlockSettings.of(Material.METAL)
            .sounds(ModSounds.STEEL_SOUNDS).mapColor(MapColor.BRIGHT_TEAL).strength(35f,1200f).nonOpaque().requiresTool()),
            new FabricItemSettings().fireproof());
    public static final Block MODIFICATION_TABLE = registerBlock("modification_table", new ModificationTableBlock(FabricBlockSettings.of(Material.METAL)
            .sounds(ModSounds.STEEL_SOUNDS).mapColor(MapColor.BRIGHT_TEAL).strength(35f,1200f).nonOpaque().requiresTool()));

    public static final Block TRANQUIL_ROSE = registerBlock("tranquil_rose",
            new FlowerBlock(StatusEffects.DARKNESS, 8, FabricBlockSettings.copy(Blocks.ALLIUM).luminance((state) -> 4)),
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.4f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 30, 0), 0.3f).build()));
    public static final Block POTTED_TRANQUIL_ROSE = registerBlockWithoutBlockItem("potted_tranquil_rose",
            new FlowerPotBlock(ModBlocks.TRANQUIL_ROSE, FabricBlockSettings.copy(Blocks.POTTED_ALLIUM).luminance((state) -> 4)));
    public static final Block SKULLWEED = registerBlock("skullweed",
            new FlowerBlock(StatusEffects.HASTE, 8, FabricBlockSettings.copy(Blocks.ALLIUM).sounds(BlockSoundGroup.NETHER_SPROUTS)),
            new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.4f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 30, 0), 0.3f).build()));
    public static final Block POTTED_SKULLWEED = registerBlockWithoutBlockItem("potted_skullweed",
            new FlowerPotBlock(ModBlocks.SKULLWEED, FabricBlockSettings.copy(Blocks.POTTED_ALLIUM)));
    public static final Block FEATHERCORN = registerBlockWithoutBlockItem("feathercorn", new TallFlowerBlock(FabricBlockSettings.copy(Blocks.ROSE_BUSH)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block, new FabricItemSettings()); return Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block); }
    private static Block registerBlock(String name, Block block, FabricItemSettings settings){
        registerBlockItem(name, block, settings); return Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block); }
    private static void registerBlockItem(String name, Block block, FabricItemSettings settings) {
        Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name), new BlockItem(block, settings));
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block);
    }

    public static void registerModBlocks(){ trevorssentinels.LOGGER.info("Registering blocks... (" + trevorssentinels.MOD_ID + ")"); }
}