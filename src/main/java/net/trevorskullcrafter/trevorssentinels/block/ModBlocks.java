package net.trevorskullcrafter.trevorssentinels.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.custom.*;
import net.trevorskullcrafter.trevorssentinels.block.sapling.CeruliiSaplingGenerator;
import net.trevorskullcrafter.trevorssentinels.block.sapling.MidasSaplingGenerator;
import net.trevorskullcrafter.trevorssentinels.block.sapling.ViridescentSaplingGenerator;
import net.trevorskullcrafter.trevorssentinels.block.sapling.YggdrasilSaplingGenerator;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.trevorskullcrafter.trevorssentinels.util.ModRegistries;

public class ModBlocks {
    public static final Block GALINITE_BLOCK = registerBlock("galinite_block", new Block(FabricBlockSettings.create()
            .pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.CALCITE).mapColor(MapColor.GRAY).strength(3.5f,3f).requiresTool()));
    public static final Block CHISELED_GALINITE_BLOCK = registerBlock("chiseled_galinite_block", new Block(FabricBlockSettings.copy(ModBlocks.GALINITE_BLOCK)));
    public static final Block GALINITE_PILLAR = registerBlock("galinite_pillar", new PillarBlock(FabricBlockSettings.copy(ModBlocks.GALINITE_BLOCK)));
    public static final Block DATA_BLOCK = registerBlock("data_block", new DataBlock(FabricBlockSettings.create().mapColor(MapColor.CYAN)
            .sounds(BlockSoundGroup.HONEY).nonOpaque().dynamicBounds().allowsSpawning(Blocks::never).pistonBehavior(PistonBehavior.PUSH_ONLY).solidBlock(Blocks::never)));
    public static final Block RICE_PLANT = registerBlockWithoutBlockItem("rice_plant", new RiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));
    public static final Block GOLDEN_RICE_PLANT = registerBlockWithoutBlockItem("golden_rice_plant", new RiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).mapColor(MapColor.GOLD).nonOpaque()));
    public static final Block RICE_BLOCK = registerBlock("rice_block", new PillarBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK)));
    public static final Block GOLDEN_RICE_BLOCK = registerBlock("golden_rice_block", new PillarBlock(FabricBlockSettings.copy(Blocks.HAY_BLOCK).mapColor(MapColor.GOLD)));

    public static final Block STEEL_BLOCK = registerBlock("steel_block", new Block(FabricBlockSettings.create().strength(6f,8f)
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

    public static final Identifier STEEL_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/steel");
    public static final Identifier STEEL_HANGING_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/hanging/steel");
    public static final Identifier STEEL_HANGING_GUI_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "textures/gui/hanging_signs/steel");

    public static final Block STEEL_SIGN = registerBlockWithoutBlockItem("steel_sign",
            new TerraformSignBlock(STEEL_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).noCollision().instrument(Instrument.BASS)));
    public static final Block STEEL_WALL_SIGN = registerBlockWithoutBlockItem("steel_wall_sign",
            new TerraformWallSignBlock(STEEL_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.STEEL_SIGN)));
    public static final Block STEEL_HANGING_SIGN = registerBlockWithoutBlockItem("steel_hanging_sign",
            new TerraformHangingSignBlock(STEEL_HANGING_SIGN_TEXTURE, STEEL_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.STEEL_SIGN)));
    public static final Block STEEL_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("steel_wall_hanging_sign",
            new TerraformWallHangingSignBlock(STEEL_HANGING_SIGN_TEXTURE, STEEL_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.STEEL_SIGN)));

    public static final BlockFamily STEEL_FAMILY = BlockFamilies.register(ModBlocks.STEEL_BLOCK).sign(ModBlocks.STEEL_SIGN, ModBlocks.STEEL_WALL_SIGN).unlockCriterionName("has_steel").build();

    public static final Block HOLOGRAPHIC_BLUE_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_blue_wall_sign", new WallSignBlock(FabricBlockSettings.copy(STEEL_WALL_SIGN), ModRegistries.HOLOGRAPHIC_BLUE_WOOD));
    public static final Block HOLOGRAPHIC_BLUE_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_blue_sign", new SignBlock(FabricBlockSettings.copy(STEEL_SIGN), ModRegistries.HOLOGRAPHIC_BLUE_WOOD));
    public static final Block HOLOGRAPHIC_RED_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_red_wall_sign", new WallSignBlock(FabricBlockSettings.copy(STEEL_WALL_SIGN), ModRegistries.HOLOGRAPHIC_RED_WOOD));
    public static final Block HOLOGRAPHIC_RED_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_red_sign", new SignBlock(FabricBlockSettings.copy(STEEL_SIGN), ModRegistries.HOLOGRAPHIC_RED_WOOD));

    public static final Block TRANSITITE_BLOCK = registerBlock("transitite_block", new Block(FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK).nonOpaque()
            .mapColor(MapColor.LIGHT_GRAY)));
    public static final Block WAX_INFUSED_COPPER_BLOCK = registerBlock("wax_infused_copper_block", new Block(FabricBlockSettings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.ORANGE)));

    public static final Block HARD_LIGHT = registerBlockWithoutBlockItem("hard_light", new HardLightBlock(ModItems.HARD_LIGHT_PROJECTOR, FabricBlockSettings.create().mapColor(MapColor.CYAN)
            .sounds(ModSounds.HARD_LIGHT_SOUNDS).luminance((state) -> 5).emissiveLighting(Blocks::always).noBlockBreakParticles().nonOpaque().dynamicBounds().allowsSpawning(Blocks::never)
            .blockVision(Blocks::never).pistonBehavior(PistonBehavior.IGNORE).strength(-1f, 3600000f)));
    public static final Block CAUTION_HARD_LIGHT = registerBlockWithoutBlockItem("caution_hard_light", new HardLightBlock(ModItems.CAUTION_HARD_LIGHT_PROJECTOR, FabricBlockSettings.copy(HARD_LIGHT).mapColor(MapColor.GOLD)));
    public static final Block SENTINEL_HARD_LIGHT = registerBlockWithoutBlockItem("sentinel_hard_light", new HardLightBlock(ModItems.SENTINEL_HARD_LIGHT_PROJECTOR, FabricBlockSettings.copy(HARD_LIGHT).mapColor(MapColor.RED)));
    public static final Block HARD_LIGHT_BARRIER = registerBlock("hard_light_barrier", new GlassBlock(FabricBlockSettings.copy(HARD_LIGHT)));
    public static final Block CAUTION_HARD_LIGHT_BARRIER = registerBlock("caution_hard_light_barrier", new GlassBlock(FabricBlockSettings.copy(CAUTION_HARD_LIGHT)));
    public static final Block SENTINEL_HARD_LIGHT_BARRIER = registerBlock("sentinel_hard_light_barrier", new GlassBlock(FabricBlockSettings.copy(SENTINEL_HARD_LIGHT)));

    public static final Block NUCLEAR_BLOCK = registerBlock("nuclear_block", new NuclearBlock(FabricBlockSettings.create()
            .sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(50f,1200f).mapColor(MapColor.EMERALD_GREEN).requiresTool()),
            new FabricItemSettings().fireproof());
    public static final Block NUCLEAR_ORE = registerBlock("nuclear_ore", new ExperienceDroppingBlock(FabricBlockSettings.create()
            .sounds(BlockSoundGroup.STONE).strength(50f,1200f).mapColor(MapColor.EMERALD_GREEN).requiresTool()),
            new FabricItemSettings().fireproof());
    public static final Block NUCLEAR_CHARGE = registerBlock("nuclear_charge", new NuclearChargeBlock(FabricBlockSettings.create().mapColor(MapColor.EMERALD_GREEN).sounds(ModSounds.STEEL_SOUNDS)),
            new FabricItemSettings().fireproof());
    public static final Block CHISELED_END_STONE_BRICKS = registerBlock("chiseled_end_stone_bricks", new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block CRACKED_END_STONE_BRICKS = registerBlock("cracked_end_stone_bricks", new Block(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));
    public static final Block END_STONE_BRICK_COLUMN = registerBlock("end_stone_brick_column", new PillarBlock(FabricBlockSettings.copy(Blocks.END_STONE_BRICKS)));

    public static final Block SNOWSTONE = registerBlock("snowstone", new Block(FabricBlockSettings.copy(Blocks.SANDSTONE).mapColor(MapColor.OFF_WHITE)));
    public static final Block SNOWSTONE_STAIRS = registerBlock("snowstone_stairs", new StairsBlock(ModBlocks.SNOWSTONE.getDefaultState(), FabricBlockSettings.copy(Blocks.SANDSTONE_STAIRS).mapColor(MapColor.OFF_WHITE)));
    public static final Block SNOWSTONE_SLAB = registerBlock("snowstone_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.SANDSTONE_SLAB).mapColor(MapColor.OFF_WHITE)));
    public static final Block SNOWSTONE_WALL = registerBlock("snowstone_wall", new WallBlock(FabricBlockSettings.copy(Blocks.SANDSTONE_WALL).mapColor(MapColor.OFF_WHITE)));
    public static final Block SMOOTH_SNOWSTONE = registerBlock("smooth_snowstone", new Block(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE).mapColor(MapColor.OFF_WHITE)));
    public static final Block SMOOTH_SNOWSTONE_STAIRS = registerBlock("smooth_snowstone_stairs", new StairsBlock(ModBlocks.SMOOTH_SNOWSTONE.getDefaultState(),
            FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_STAIRS).mapColor(MapColor.OFF_WHITE)));
    public static final Block SMOOTH_SNOWSTONE_SLAB = registerBlock("smooth_snowstone_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.SMOOTH_SANDSTONE_SLAB).mapColor(MapColor.OFF_WHITE)));
    public static final Block SMOOTH_SNOWSTONE_WALL = registerBlock("smooth_snowstone_wall", new WallBlock(FabricBlockSettings.copy(Blocks.SANDSTONE_WALL).mapColor(MapColor.OFF_WHITE)));
    public static final Block CUT_SNOWSTONE = registerBlock("cut_snowstone", new Block(FabricBlockSettings.copy(Blocks.CUT_SANDSTONE).mapColor(MapColor.OFF_WHITE)));
    public static final Block CUT_SNOWSTONE_SLAB = registerBlock("cut_snowstone_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.CUT_SANDSTONE_SLAB).mapColor(MapColor.OFF_WHITE)));
    public static final Block CHISELED_SNOWSTONE = registerBlock("chiseled_snowstone", new Block(FabricBlockSettings.copy(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.OFF_WHITE)));

    public static final Block DIRT_STAIRS = registerBlock("dirt_stairs", new StairsBlock(Blocks.DIRT.getDefaultState(), FabricBlockSettings.copy(Blocks.DIRT)));
    public static final Block DIRT_SLAB = registerBlock("dirt_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.DIRT)));
    public static final Block COARSE_DIRT_STAIRS = registerBlock("coarse_dirt_stairs", new StairsBlock(Blocks.COARSE_DIRT.getDefaultState(), FabricBlockSettings.copy(Blocks.COARSE_DIRT)));
    public static final Block COARSE_DIRT_SLAB = registerBlock("coarse_dirt_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.COARSE_DIRT)));
    public static final Block OVERGROWN_GRASS_BLOCK = registerBlock("overgrown_grass_block", new Block(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block GRASS_STAIRS = registerBlock("grass_stairs", new StairsBlock(Blocks.GRASS_BLOCK.getDefaultState(), FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block GRASS_SLAB = registerBlock("grass_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)));
    public static final Block MOSS_STAIRS = registerBlock("moss_stairs", new StairsBlock(Blocks.MOSS_BLOCK.getDefaultState(), FabricBlockSettings.copy(Blocks.MOSS_BLOCK)));
    public static final Block MOSS_SLAB = registerBlock("moss_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.MOSS_BLOCK)));
    public static final Block FLESH_BLOCK = registerBlock("flesh_block", new FleshBlock(0.5f, ModSounds.FLESH_AMBIENT,
            FabricBlockSettings.create().slipperiness(0.7f).strength(1.5F, 6.0F).mapColor(MapColor.RED).sounds(ModSounds.FLESH_SOUNDS)));
    public static final Block FLESH_VEINS = registerBlock("flesh_veins", new FleshVeinBlock(FabricBlockSettings.copy(Blocks.GLOW_LICHEN)
            .strength(0.7F, 3.0F).luminance((state) -> 0).mapColor(MapColor.RED).sounds(ModSounds.FLESH_SOUNDS)));
    public static final Block FLESHY_EYE = registerBlock("fleshy_eye", new FleshyEyeBlock(FabricBlockSettings.copy(ModBlocks.FLESH_BLOCK)
            .mapColor(MapColor.YELLOW).luminance((state) -> state.get(ToggleableLampBlock.CLICKED) ? 8 : 0)));
    public static final Block RED_BUTTON = registerBlock("red_button", new ButtonBlock(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).noCollision().mapColor(MapColor.BRIGHT_RED),
            BlockSetType.IRON, 5, false));
    public static final Block RED_PLATE = registerBlock("red_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).mapColor(MapColor.BRIGHT_RED), BlockSetType.IRON));



    public static final Block YGGDRASIL_PLANKS = registerBlock("yggdrasil_planks", new Block(FabricBlockSettings.copy(Blocks.WARPED_PLANKS).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_SAPLING = registerBlock("yggdrasil_sapling",new SaplingBlock(new YggdrasilSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.OFF_WHITE)));
    public static final Block POTTED_YGGDRASIL_SAPLING = registerBlockWithoutBlockItem("potted_yggdrasil_sapling", new FlowerPotBlock(YGGDRASIL_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_LOG = registerBlock("yggdrasil_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.OFF_WHITE)));
    public static final Block STRIPPED_YGGDRASIL_LOG = registerBlock("stripped_yggdrasil_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_WOOD = registerBlock("yggdrasil_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.OFF_WHITE)));
    public static final Block STRIPPED_YGGDRASIL_WOOD = registerBlock("stripped_yggdrasil_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_LEAVES = registerBlock("yggdrasil_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.MAGENTA)));
    public static final Block YGGDRASIL_SLAB = registerBlock("yggdrasil_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.WARPED_SLAB).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_FENCE = registerBlock("yggdrasil_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.WARPED_FENCE).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_STAIRS = registerBlock("yggdrasil_stairs", new StairsBlock(ModBlocks.YGGDRASIL_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.WARPED_STAIRS).mapColor(MapColor.OFF_WHITE)));
    public static final Block YGGDRASIL_BUTTON = registerBlock("yggdrasil_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.WARPED_BUTTON).mapColor(MapColor.OFF_WHITE), ModRegistries.YGGDRASIL_WOOD.setType(), 30, true));
    public static final Block YGGDRASIL_PRESSURE_PLATE = registerBlock("yggdrasil_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.OFF_WHITE), ModRegistries.YGGDRASIL_WOOD.setType()));
    public static final Block YGGDRASIL_DOOR = registerBlock("yggdrasil_door", new DoorBlock(FabricBlockSettings.copy(Blocks.WARPED_DOOR).mapColor(MapColor.OFF_WHITE), ModRegistries.YGGDRASIL_WOOD.setType()));
    public static final Block YGGDRASIL_TRAPDOOR = registerBlock("yggdrasil_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.OFF_WHITE), ModRegistries.YGGDRASIL_WOOD.setType()));
    public static final Block YGGDRASIL_FENCE_GATE = registerBlock("yggdrasil_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.OFF_WHITE), ModRegistries.YGGDRASIL_WOOD));

    public static final Identifier YGGDRASIL_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/yggdrasil");
    public static final Identifier YGGDRASIL_HANGING_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/hanging/yggdrasil");
    public static final Identifier YGGDRASIL_HANGING_GUI_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "textures/gui/hanging_signs/yggdrasil");

    public static final Block YGGDRASIL_SIGN = registerBlockWithoutBlockItem("yggdrasil_sign",
            new TerraformSignBlock(YGGDRASIL_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.YGGDRASIL_PLANKS).noCollision().instrument(Instrument.BASS)));
    public static final Block YGGDRASIL_WALL_SIGN = registerBlockWithoutBlockItem("yggdrasil_wall_sign",
            new TerraformWallSignBlock(YGGDRASIL_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.YGGDRASIL_SIGN)));
    public static final Block YGGDRASIL_HANGING_SIGN = registerBlockWithoutBlockItem("yggdrasil_hanging_sign",
            new TerraformHangingSignBlock(YGGDRASIL_HANGING_SIGN_TEXTURE, YGGDRASIL_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.YGGDRASIL_SIGN)));
    public static final Block YGGDRASIL_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("yggdrasil_wall_hanging_sign",
            new TerraformWallHangingSignBlock(YGGDRASIL_HANGING_SIGN_TEXTURE, YGGDRASIL_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.YGGDRASIL_SIGN)));

    public static final BlockFamily YGGDRASIL_FAMILY = BlockFamilies.register(YGGDRASIL_PLANKS).stairs(YGGDRASIL_STAIRS).slab(YGGDRASIL_SLAB).button(YGGDRASIL_BUTTON)
            .pressurePlate(YGGDRASIL_PRESSURE_PLATE).fence(YGGDRASIL_FENCE).fenceGate(YGGDRASIL_FENCE_GATE).door(YGGDRASIL_DOOR).trapdoor(YGGDRASIL_TRAPDOOR)
            .sign(YGGDRASIL_SIGN, YGGDRASIL_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();



    public static final Block CHARRED_PLANKS = registerBlock("charred_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_LOG = registerBlock("charred_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block STRIPPED_CHARRED_LOG = registerBlock("stripped_charred_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_WOOD = registerBlock("charred_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block STRIPPED_CHARRED_WOOD = registerBlock("stripped_charred_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_SLAB = registerBlock("charred_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_FENCE = registerBlock("charred_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_STAIRS = registerBlock("charred_stairs", new StairsBlock(ModBlocks.CHARRED_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GRAY)));
    public static final Block CHARRED_BUTTON = registerBlock("charred_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD.setType(), 30, true));
    public static final Block CHARRED_PRESSURE_PLATE = registerBlock("charred_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD.setType()));
    public static final Block CHARRED_DOOR = registerBlock("charred_door", new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD.setType()));
    public static final Block CHARRED_TRAPDOOR = registerBlock("charred_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD.setType()));
    public static final Block CHARRED_FENCE_GATE = registerBlock("charred_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GRAY), ModRegistries.CHARRED_WOOD));

    public static final Identifier CHARRED_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/charred");
    public static final Identifier CHARRED_HANGING_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/hanging/charred");
    public static final Identifier CHARRED_HANGING_GUI_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "textures/gui/hanging_signs/charred");

    public static final Block CHARRED_SIGN = registerBlockWithoutBlockItem("charred_sign",
            new TerraformSignBlock(CHARRED_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.CHARRED_PLANKS).noCollision().instrument(Instrument.BASS)));
    public static final Block CHARRED_WALL_SIGN = registerBlockWithoutBlockItem("charred_wall_sign",
            new TerraformWallSignBlock(CHARRED_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.CHARRED_SIGN)));
    public static final Block CHARRED_HANGING_SIGN = registerBlockWithoutBlockItem("charred_hanging_sign",
            new TerraformHangingSignBlock(CHARRED_HANGING_SIGN_TEXTURE, CHARRED_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.CHARRED_SIGN)));
    public static final Block CHARRED_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("charred_wall_hanging_sign",
            new TerraformWallHangingSignBlock(CHARRED_HANGING_SIGN_TEXTURE, CHARRED_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.CHARRED_SIGN)));

    public static final BlockFamily CHARRED_FAMILY = BlockFamilies.register(CHARRED_PLANKS).stairs(CHARRED_STAIRS).slab(CHARRED_SLAB).button(CHARRED_BUTTON)
            .pressurePlate(CHARRED_PRESSURE_PLATE).fence(CHARRED_FENCE).fenceGate(CHARRED_FENCE_GATE).door(CHARRED_DOOR).trapdoor(CHARRED_TRAPDOOR)
            .sign(CHARRED_SIGN, CHARRED_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();



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
    public static final Block MIDAS_BUTTON = registerBlock("midas_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD.setType(), 30, true));
    public static final Block MIDAS_PRESSURE_PLATE = registerBlock("midas_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD.setType()));
    public static final Block MIDAS_DOOR = registerBlock("midas_door", new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD.setType()));
    public static final Block MIDAS_TRAPDOOR = registerBlock("midas_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD.setType()));
    public static final Block MIDAS_FENCE_GATE = registerBlock("midas_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GOLD), ModRegistries.MIDAS_WOOD));

    public static final Identifier MIDAS_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/midas");
    public static final Identifier MIDAS_HANGING_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/hanging/midas");
    public static final Identifier MIDAS_HANGING_GUI_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "textures/gui/hanging_signs/midas");

    public static final Block MIDAS_SIGN = registerBlockWithoutBlockItem("midas_sign",
            new TerraformSignBlock(MIDAS_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.MIDAS_PLANKS).noCollision().instrument(Instrument.BASS)));
    public static final Block MIDAS_WALL_SIGN = registerBlockWithoutBlockItem("midas_wall_sign",
            new TerraformWallSignBlock(MIDAS_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.MIDAS_SIGN)));
    public static final Block MIDAS_HANGING_SIGN = registerBlockWithoutBlockItem("midas_hanging_sign",
            new TerraformHangingSignBlock(MIDAS_HANGING_SIGN_TEXTURE, MIDAS_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.MIDAS_SIGN)));
    public static final Block MIDAS_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("midas_wall_hanging_sign",
            new TerraformWallHangingSignBlock(MIDAS_HANGING_SIGN_TEXTURE, MIDAS_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.MIDAS_SIGN)));

    public static final BlockFamily MIDAS_FAMILY = BlockFamilies.register(MIDAS_PLANKS).stairs(MIDAS_STAIRS).slab(MIDAS_SLAB).button(MIDAS_BUTTON)
            .pressurePlate(MIDAS_PRESSURE_PLATE).fence(MIDAS_FENCE).fenceGate(MIDAS_FENCE_GATE).door(MIDAS_DOOR).trapdoor(MIDAS_TRAPDOOR)
            .sign(MIDAS_SIGN, MIDAS_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();



    public static final Block VIRIDESCENT_PLANKS = registerBlock("viridescent_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GREEN)));
    public static final Block VIRIDESCENT_SAPLING = registerBlock("viridescent_sapling",new SaplingBlock(new ViridescentSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));
    public static final Block POTTED_VIRIDESCENT_SAPLING = registerBlockWithoutBlockItem("potted_viridescent_sapling", new FlowerPotBlock(VIRIDESCENT_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block VIRIDESCENT_LOG = registerBlock("viridescent_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG).mapColor(MapColor.GREEN)));
    public static final Block STRIPPED_VIRIDESCENT_LOG = registerBlock("stripped_viridescent_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GREEN)));
    public static final Block VIRIDESCENT_WOOD = registerBlock("viridescent_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).mapColor(MapColor.GREEN)));
    public static final Block STRIPPED_VIRIDESCENT_WOOD = registerBlock("stripped_viridescent_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GREEN)));
    public static final Block VIRIDESCENT_LEAVES = registerBlock("viridescent_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.GREEN)));
    public static final Block VIRIDESCENT_SLAB = registerBlock("viridescent_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).mapColor(MapColor.GREEN)));
    public static final Block VIRIDESCENT_FENCE = registerBlock("viridescent_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GREEN)));
    public static final Block VIRIDESCENT_STAIRS = registerBlock("viridescent_stairs", new StairsBlock(ModBlocks.VIRIDESCENT_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GREEN)));
    public static final Block VIRIDESCENT_BUTTON = registerBlock("viridescent_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD.setType(), 30, true));
    public static final Block VIRIDESCENT_PRESSURE_PLATE = registerBlock("viridescent_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.JUNGLE_PRESSURE_PLATE).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD.setType()));
    public static final Block VIRIDESCENT_DOOR = registerBlock("viridescent_door", new DoorBlock(FabricBlockSettings.copy(Blocks.JUNGLE_DOOR).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD.setType()));
    public static final Block VIRIDESCENT_TRAPDOOR = registerBlock("viridescent_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.JUNGLE_TRAPDOOR).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD.setType()));
    public static final Block VIRIDESCENT_FENCE_GATE = registerBlock("viridescent_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.JUNGLE_FENCE_GATE).mapColor(MapColor.GREEN), ModRegistries.VIRIDESCENT_WOOD));

    public static final Identifier VIRIDESCENT_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/viridescent");
    public static final Identifier VIRIDESCENT_HANGING_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/hanging/viridescent");
    public static final Identifier VIRIDESCENT_HANGING_GUI_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "textures/gui/hanging_signs/viridescent");

    public static final Block VIRIDESCENT_SIGN = registerBlockWithoutBlockItem("viridescent_sign",
            new TerraformSignBlock(VIRIDESCENT_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.VIRIDESCENT_PLANKS).noCollision().instrument(Instrument.BASS)));
    public static final Block VIRIDESCENT_WALL_SIGN = registerBlockWithoutBlockItem("viridescent_wall_sign",
            new TerraformWallSignBlock(VIRIDESCENT_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.VIRIDESCENT_SIGN)));
    public static final Block VIRIDESCENT_HANGING_SIGN = registerBlockWithoutBlockItem("viridescent_hanging_sign",
            new TerraformHangingSignBlock(VIRIDESCENT_HANGING_SIGN_TEXTURE, VIRIDESCENT_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.VIRIDESCENT_SIGN)));
    public static final Block VIRIDESCENT_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("viridescent_wall_hanging_sign",
            new TerraformWallHangingSignBlock(VIRIDESCENT_HANGING_SIGN_TEXTURE, VIRIDESCENT_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.VIRIDESCENT_SIGN)));

    public static final BlockFamily VIRIDESCENT_FAMILY = BlockFamilies.register(VIRIDESCENT_PLANKS).stairs(VIRIDESCENT_STAIRS).slab(VIRIDESCENT_SLAB).button(VIRIDESCENT_BUTTON)
            .pressurePlate(VIRIDESCENT_PRESSURE_PLATE).fence(VIRIDESCENT_FENCE).fenceGate(VIRIDESCENT_FENCE_GATE).door(VIRIDESCENT_DOOR).trapdoor(VIRIDESCENT_TRAPDOOR)
            .sign(VIRIDESCENT_SIGN, VIRIDESCENT_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();



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
    public static final Block CERULII_BUTTON = registerBlock("cerulii_button", new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD.setType(), 30, true));
    public static final Block CERULII_PRESSURE_PLATE = registerBlock("cerulii_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD.setType()));
    public static final Block CERULII_DOOR = registerBlock("cerulii_door", new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD.setType()));
    public static final Block CERULII_TRAPDOOR = registerBlock("cerulii_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD.setType()));
    public static final Block CERULII_FENCE_GATE = registerBlock("cerulii_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.BLUE), ModRegistries.CERULII_WOOD));

    public static final Identifier CERULII_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/cerulii");
    public static final Identifier CERULII_HANGING_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "entity/signs/hanging/cerulii");
    public static final Identifier CERULII_HANGING_GUI_SIGN_TEXTURE = new Identifier(trevorssentinels.MOD_ID, "textures/gui/hanging_signs/cerulii");

    public static final Block CERULII_SIGN = registerBlockWithoutBlockItem("cerulii_sign",
            new TerraformSignBlock(CERULII_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.CERULII_PLANKS).noCollision().instrument(Instrument.BASS)));
    public static final Block CERULII_WALL_SIGN = registerBlockWithoutBlockItem("cerulii_wall_sign",
            new TerraformWallSignBlock(CERULII_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.CERULII_SIGN)));
    public static final Block CERULII_HANGING_SIGN = registerBlockWithoutBlockItem("cerulii_hanging_sign",
            new TerraformHangingSignBlock(CERULII_HANGING_SIGN_TEXTURE, CERULII_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.CERULII_SIGN)));
    public static final Block CERULII_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("cerulii_wall_hanging_sign",
            new TerraformWallHangingSignBlock(CERULII_HANGING_SIGN_TEXTURE, CERULII_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copy(ModBlocks.CERULII_SIGN)));

    public static final BlockFamily CERULII_FAMILY = BlockFamilies.register(CERULII_PLANKS).stairs(CERULII_STAIRS).slab(CERULII_SLAB).button(CERULII_BUTTON)
            .pressurePlate(CERULII_PRESSURE_PLATE).fence(CERULII_FENCE).fenceGate(CERULII_FENCE_GATE).door(CERULII_DOOR).trapdoor(CERULII_TRAPDOOR)
            .sign(CERULII_SIGN, CERULII_WALL_SIGN).unlockCriterionName("has_planks").group("wooden").build();

    public static final Block DARKSTEEL_BLOCK = registerBlock("darksteel_block", new Block(FabricBlockSettings.create()
            .sounds(BlockSoundGroup.NETHERITE).mapColor(MapColor.TERRACOTTA_PURPLE).strength(8f,12f).requiresTool()));
    public static final Block DARKENED_STEEL_BLOCK = registerBlock("darkened_steel_block", new Block(FabricBlockSettings.copy(ModBlocks.DARKSTEEL_BLOCK)
            .mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block IRON_GOLD_BLOCK = registerBlock("iron_gold_block", new Block(FabricBlockSettings.create()
            .strength(6f,8f).mapColor(MapColor.YELLOW).requiresTool()));
    public static final Block COPPER_IRON_BLOCK = registerBlock("copper_iron_block", new Block(FabricBlockSettings.create()
            .strength(6f,8f).mapColor(MapColor.RAW_IRON_PINK).requiresTool()));
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block", new Block(FabricBlockSettings.create()
            .mapColor(MapColor.RAW_IRON_PINK).strength(5f,7f).requiresTool()));
    public static final Block DARK_CHAMBER_BLOCK = registerBlock("dark_chamber_block", new FallDamagelessBlock(0.0f,
            FabricBlockSettings.create().mapColor(MapColor.BLACK).sounds(BlockSoundGroup.NETHER_STEM).strength(2f,4f)));
    public static final Block LIGHT_CHAMBER_BLOCK = registerBlock("light_chamber_block", new FallDamagelessBlock(0.0f,
            FabricBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).mapColor(MapColor.WHITE)));
    public static final Block BLUE_AGILITY_BLOCK = registerBlock("blue_agility_block", new FallDamagelessBlock(0.0f,
            FabricBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).sounds(BlockSoundGroup.SLIME).mapColor(MapColor.CYAN).jumpVelocityMultiplier(2.7f).slipperiness(0.989f)));
    public static final Block ORANGE_AGILITY_BLOCK = registerBlock("orange_agility_block", new FallDamagelessBlock(0.0f,
            FabricBlockSettings.copy(ModBlocks.DARK_CHAMBER_BLOCK).sounds(BlockSoundGroup.SLIME).mapColor(MapColor.ORANGE).velocityMultiplier(1.4f).slipperiness(0.75f)));
    public static final Block BLACK_AGILITY_BLOCK = registerBlock("black_agility_block",
            new Block(FabricBlockSettings.copy(ModBlocks.STEEL_BLOCK).slipperiness(/*1.098*/1.2f).mapColor(MapColor.LIGHT_BLUE)));
    //public static final Block FORGE = registerBlock("forge",
    //        new ForgeBlock(FabricBlockSettings.create().strength(3.5f,3.5f).mapColor(MapColor.GRAY).requiresTool()));
    public static final Block SUPERFORGE = registerBlock("superforge", new SuperforgeBlock(FabricBlockSettings.create()
            .sounds(ModSounds.STEEL_SOUNDS).mapColor(MapColor.BRIGHT_TEAL).strength(35f,1200f).nonOpaque().requiresTool()),
            new FabricItemSettings().fireproof());
    public static final Block MODIFICATION_TABLE = registerBlock("modification_table", new ModificationTableBlock(FabricBlockSettings.create()
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

    private static Block registerBlock(String name, Block block){ registerBlockItem(name, block, new FabricItemSettings()); return Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block); }
    private static Block registerBlock(String name, Block block, FabricItemSettings settings){ registerBlockItem(name, block, settings); return Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block); }
    private static void registerBlockItem(String name, Block block, FabricItemSettings settings) { Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name), new BlockItem(block, settings)); }
    private static Block registerBlockWithoutBlockItem(String name, Block block){ return Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block); }

    public static void registerModBlocks(){ trevorssentinels.LOGGER.info("Registering blocks... (" + trevorssentinels.MOD_ID + ")"); }
}