package net.trevorskullcrafter.trevorssentinels.block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.trevorskullcrafter.trevorssentinels.block.custom.*;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModSignTypes;
import net.trevorskullcrafter.trevorssentinels.item.ModItemGroup;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.trevorskullcrafter.trevorssentinels.world.feature.tree.MidasSaplingGenerator;
import net.trevorskullcrafter.trevorssentinels.world.feature.tree.YggdrasilSaplingGenerator;

public class ModBlocks {
    public static final Block SENTINUM_BLOCK = registerBlock("sentinum_block",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.CALCITE).strength(3.5f,3f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block CHISELED_SENTINUM_BLOCK = registerBlock("chiseled_sentinum_block",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.CALCITE).strength(3.5f,3f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block SENTINUM_PILLAR = registerBlock("sentinum_pillar",
            new PillarBlock(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.CALCITE).strength(3.5f,3f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block DATA_BLOCK = registerBlock("data_block",
            new DataBlock(FabricBlockSettings.copy(Blocks.HONEY_BLOCK).sounds(BlockSoundGroup.HONEY).luminance((state) -> 5).strength(0f,0f).nonOpaque()), ModItemGroup.SENTINELS);

    public static final Block RICE_PLANT = registerBlockWithoutBlockItem("rice_plant",
            new RiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));

    public static final Block GOLDEN_RICE_PLANT = registerBlockWithoutBlockItem("golden_rice_plant",
            new GoldenRiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));

    public static final Block RICE_BLOCK = registerBlock("rice_block",
            new PillarBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.YELLOW).strength(0.5f).sounds(BlockSoundGroup.GRASS)),ModItemGroup.KITCHEN);

    public static final Block GOLDEN_RICE_BLOCK = registerBlock("golden_rice_block",
            new PillarBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.YELLOW).strength(0.5f).sounds(BlockSoundGroup.GRASS)),ModItemGroup.KITCHEN);

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).sounds(ModSounds.STEEL_SOUNDS).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block CAUTION_STEEL_BLOCK = registerBlock("caution_steel_block",
            new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(6f,8f).sounds(ModSounds.STEEL_SOUNDS).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block STAINLESS_STEEL_BLOCK = registerBlock("stainless_steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).sounds(ModSounds.STEEL_SOUNDS).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block STEEL_LAMP_BLOCK = registerBlock("steel_lamp_block",
            new SteelLampBlock(FabricBlockSettings.of(Material.METAL).strength(6f,8f)
                    .luminance((state) -> state.get(SteelLampBlock.CLICKED) ? 15 : 0).sounds(ModSounds.STEEL_SOUNDS).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block STEEL_FAN = registerBlock("steel_fan",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block RUSTED_STEEL_BLOCK = registerBlock("rusted_steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(6f, 8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block BATTERY = registerBlock("battery",
            new DirectionalBlock(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block FUSEBOX = registerBlock("fusebox",
            new DirectionalBlock(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block STEEL_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("steel_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.STEEL));

    public static final Block STEEL_SIGN_BLOCK = registerBlockWithoutBlockItem("steel_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.STEEL));

    public static final Block HOLOGRAPHIC_WALL_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_wall_sign",
            new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), ModSignTypes.HOLOGRAPHIC));

    public static final Block HOLOGRAPHIC_SIGN_BLOCK = registerBlockWithoutBlockItem("holographic_sign",
            new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), ModSignTypes.HOLOGRAPHIC));

    public static final Block WAX_INFUSED_COPPER_BLOCK = registerBlock("wax_infused_copper_block",
            new DirectionalBlock(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.COPPER).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block HOLOBARRIER = registerBlockWithoutBlockItem("holobarrier",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque().strength(-1f,3600000f)));

    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new UraniumBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(50f,1200f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block URANIUM_ORE = registerBlock("uranium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(50f,1200f).requiresTool()),ModItemGroup.SENTINELS);

    public static final Block NUCLEAR_CHARGE = registerBlock("nuclear_charge",
            new TntBlock(FabricBlockSettings.of(Material.TNT).sounds(ModSounds.STEEL_SOUNDS)), ModItemGroup.SENTINELS);

    public static final Block CHISELED_SNOWSTONE = registerBlock("chiseled_snowstone",
            new DirectionalBlock(FabricBlockSettings.of(Material.STONE).strength(0.8f,0.8f).requiresTool()), ModItemGroup.WORLD);

    public static final Block CUT_SNOWSTONE = registerBlock("cut_snowstone",
            new DirectionalBlock(FabricBlockSettings.of(Material.STONE).strength(0.8f,0.8f).requiresTool()), ModItemGroup.WORLD);

    public static final Block SNOWSTONE = registerBlock("snowstone",
            new DirectionalBlock(FabricBlockSettings.of(Material.STONE).strength(0.8f,0.8f).requiresTool()), ModItemGroup.WORLD);

    public static final Block SMOOTH_SNOWSTONE = registerBlock("smooth_snowstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f,6f).requiresTool()), ModItemGroup.WORLD);

    public static final Block SNOWSTONE_SLAB = registerBlock("snowstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f,6f).requiresTool()), ModItemGroup.WORLD);

    public static final Block CUT_SNOWSTONE_SLAB = registerBlock("cut_snowstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f,6f).requiresTool()), ModItemGroup.WORLD);

    public static final Block SNOWSTONE_STAIRS = registerBlock("snowstone_stairs",
            new StairsBlock(ModBlocks.SNOWSTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(2f,6f).requiresTool()), ModItemGroup.WORLD);

    public static final Block SNOWSTONE_WALL = registerBlock("snowstone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(2f,6f).requiresTool()), ModItemGroup.WORLD);

    public static final Block SMOOTH_SNOWSTONE_STAIRS = registerBlock("smooth_snowstone_stairs",
            new StairsBlock(ModBlocks.SMOOTH_SNOWSTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(2f,6f).requiresTool()), ModItemGroup.WORLD);

    public static final Block SMOOTH_SNOWSTONE_SLAB = registerBlock("smooth_snowstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f,6f).requiresTool()), ModItemGroup.WORLD);

    public static final Block DIRT_STAIRS = registerBlock("dirt_stairs",
            new StairsBlock(Blocks.DIRT.getDefaultState(), FabricBlockSettings.of(Material.SOIL).strength(0.5f).sounds(BlockSoundGroup.GRAVEL)), ModItemGroup.WORLD);

    public static final Block DIRT_SLAB = registerBlock("dirt_slab",
            new SlabBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f).sounds(BlockSoundGroup.GRAVEL)), ModItemGroup.WORLD);

    public static final Block COARSE_DIRT_STAIRS = registerBlock("coarse_dirt_stairs",
            new StairsBlock(Blocks.COARSE_DIRT.getDefaultState(), FabricBlockSettings.of(Material.SOIL).strength(0.5f).sounds(BlockSoundGroup.GRAVEL)), ModItemGroup.WORLD);

    public static final Block COARSE_DIRT_SLAB = registerBlock("coarse_dirt_slab",
            new SlabBlock(FabricBlockSettings.of(Material.SOIL).strength(0.5f).sounds(BlockSoundGroup.GRAVEL)), ModItemGroup.WORLD);

    public static final Block RED_BUTTON = registerBlock("red_button",
            new StoneButtonBlock(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS)
                    .strength(6f,8f).noCollision().requiresTool()), ModItemGroup.SENTINELS);

    public static final Block RED_PLATE = registerBlock("red_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS)
                            .strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block YGGDRASIL_LOG = registerBlock("yggdrasil_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.WORLD);
    public static final Block YGGDRASIL_WOOD = registerBlock("yggdrasil_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroup.WORLD);
    public static final Block STRIPPED_YGGDRASIL_LOG = registerBlock("stripped_yggdrasil_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.WORLD);
    public static final Block STRIPPED_YGGDRASIL_WOOD = registerBlock("stripped_yggdrasil_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.WORLD);
    public static final Block YGGDRASIL_PLANKS = registerBlock("yggdrasil_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.WORLD);
    public static final Block YGGDRASIL_LEAVES = registerBlock("yggdrasil_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroup.WORLD);
    public static final Block YGGDRASIL_SAPLING = registerBlock("yggdrasil_sapling",
            new SaplingBlock(new YggdrasilSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.WORLD);

    public static final Block CHARRED_OAK_LOG = registerBlock("charred_oak_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.WORLD);
    public static final Block CHARRED_OAK_WOOD = registerBlock("charred_oak_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroup.WORLD);
    public static final Block STRIPPED_CHARRED_OAK_LOG = registerBlock("stripped_charred_oak_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.WORLD);
    public static final Block STRIPPED_CHARRED_OAK_WOOD = registerBlock("stripped_charred_oak_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.WORLD);
    public static final Block CHARRED_OAK_PLANKS = registerBlock("charred_oak_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.WORLD);

    public static final Block MIDAS_LOG = registerBlock("midas_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.WORLD);
    public static final Block MIDAS_WOOD = registerBlock("midas_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroup.WORLD);
    public static final Block STRIPPED_MIDAS_LOG = registerBlock("stripped_midas_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.WORLD);
    public static final Block STRIPPED_MIDAS_WOOD = registerBlock("stripped_midas_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.WORLD);
    public static final Block MIDAS_PLANKS = registerBlock("midas_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.WORLD);
    public static final Block MIDAS_LEAVES = registerBlock("midas_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroup.WORLD);
    public static final Block MIDAS_SAPLING = registerBlock("midas_sapling",
            new SaplingBlock(new MidasSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.WORLD);

    public static final Block DARKENED_STEEL_BLOCK = registerBlock("darkened_steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.NETHERITE).strength(8f,12f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block DARKSTEEL_BLOCK = registerBlock("darksteel_block",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.NETHERITE).strength(8f,12f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block IRON_GOLD_BLOCK = registerBlock("iron_gold_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block COPPER_IRON_BLOCK = registerBlock("copper_iron_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(5f,7f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block BLUE_AGILITY_BLOCK = registerBlock("blue_agility_block",
            new FallDamagelessBlock(FabricBlockSettings.of(Material.SHULKER_BOX).strength(2f,4f).sounds(BlockSoundGroup.SLIME).jumpVelocityMultiplier(2.7f).slipperiness(0.989f)), ModItemGroup.SENTINELS);

    public static final Block ORANGE_AGILITY_BLOCK = registerBlock("orange_agility_block",
            new FallDamagelessBlock(FabricBlockSettings.of(Material.SHULKER_BOX).sounds(BlockSoundGroup.SLIME).strength(2f,4f).velocityMultiplier(1.4f).slipperiness(0.75f)), ModItemGroup.SENTINELS);

    public static final Block BLACK_AGILITY_BLOCK = registerBlock("black_agility_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).sounds(ModSounds.STEEL_SOUNDS).slipperiness(/*1.098*/1.2f)), ModItemGroup.SENTINELS);

    public static final Block LIGHT_CHAMBER_BLOCK = registerBlock("light_chamber_block",
            new FallDamagelessBlock(FabricBlockSettings.of(Material.SHULKER_BOX).sounds(BlockSoundGroup.NETHER_STEM).strength(2f,4f)), ModItemGroup.SENTINELS);

    public static final Block DARK_CHAMBER_BLOCK = registerBlock("dark_chamber_block",
            new FallDamagelessBlock(FabricBlockSettings.of(Material.SHULKER_BOX).sounds(BlockSoundGroup.NETHER_STEM).strength(2f,4f)), ModItemGroup.SENTINELS);

    public static final Block HANGING_DECOMMISSIONED_SENTINEL = registerBlock("hanging_decommissioned_sentinel",
            new DirectionalBlock(FabricBlockSettings.of(Material.STONE).strength(3.5f,3.5f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block FORGE = registerBlock("forge",
            new ForgeBlock(FabricBlockSettings.of(Material.STONE).strength(3.5f,3.5f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block SUPERFORGE = registerBlockWithoutBlockItem("superforge",
            new SuperforgeBlock(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(50f,1200f).nonOpaque().requiresTool()));

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(trevorssentinels.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block);
    }

    public static void registerModBlocks(){
        trevorssentinels.LOGGER.info("Registering blocks... (" + trevorssentinels.MOD_ID + ")");
    }
}