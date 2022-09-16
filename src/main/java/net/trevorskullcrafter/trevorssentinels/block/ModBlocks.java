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
import net.trevorskullcrafter.trevorssentinels.item.ModItemGroup;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModBlocks {

    public static final Block SENTINUM_BLOCK = registerBlock("sentinum_block",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.CALCITE).strength(3.5f,3f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block CHISELED_SENTINUM_BLOCK = registerBlock("chiseled_sentinum_block",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.CALCITE).strength(3.5f,3f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block SENTINUM_PILLAR = registerBlock("sentinum_pillar",
            new PillarBlock(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.CALCITE).strength(3.5f,3f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block DATA_BLOCK = registerBlock("data_block",
            new DataBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).sounds(BlockSoundGroup.HONEY).strength(0f,0f).nonOpaque()), ModItemGroup.SENTINELS);

    public static final Block RICE_PLANT = registerBlockWithoutBlockItem("rice_plant",
            new RiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));

    public static final Block GOLDEN_RICE_PLANT = registerBlockWithoutBlockItem("golden_rice_plant",
            new GoldenRiceCropBlock(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque()));

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).sounds(ModSounds.STEEL_SOUNDS).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block CAUTION_STEEL_BLOCK = registerBlock("caution_steel_block",
            new PillarBlock(FabricBlockSettings.of(Material.METAL).strength(6f,8f).sounds(ModSounds.STEEL_SOUNDS).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block STEEL_LAMP_BLOCK = registerBlock("steel_lamp_block",
            new SteelLampBlock(FabricBlockSettings.of(Material.METAL).strength(6f,8f)
                    .luminance((state) -> state.get(SteelLampBlock.CLICKED) ? 15 : 0).sounds(ModSounds.STEEL_SOUNDS).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block STEEL_FAN = registerBlock("steel_fan",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block BATTERY = registerBlock("battery",
            new DirectionalBlock(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block FUSEBOX = registerBlock("fusebox",
            new DirectionalBlock(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block HOLOBARRIER = registerBlockWithoutBlockItem("holobarrier",
            new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque().strength(-1f,3600000f)));

    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new UraniumBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(50f,1200f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block CHISELED_SNOWSTONE = registerBlock("chiseled_snowstone",
            new DirectionalBlock(FabricBlockSettings.of(Material.STONE).strength(0.8f,0.8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block CUT_SNOWSTONE = registerBlock("cut_snowstone",
            new DirectionalBlock(FabricBlockSettings.of(Material.STONE).strength(0.8f,0.8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block SNOWSTONE = registerBlock("snowstone",
            new DirectionalBlock(FabricBlockSettings.of(Material.STONE).strength(0.8f,0.8f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block SMOOTH_SNOWSTONE = registerBlock("smooth_snowstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f,6f).requiresTool()), ModItemGroup.SENTINELS);

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
            new OrangeAgilityBlock(FabricBlockSettings.of(Material.SHULKER_BOX).sounds(BlockSoundGroup.SLIME).strength(2f,4f)/*.velocityMultiplier(1.3f)*/.slipperiness(1.05f)), ModItemGroup.SENTINELS);

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

    public static final Block SUPERFORGE = registerBlock("superforge",
            new ForgeBlock(FabricBlockSettings.of(Material.METAL).sounds(ModSounds.STEEL_SOUNDS).strength(50f,1200f).nonOpaque().requiresTool()), ModItemGroup.SENTINELS);

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
        trevorssentinels.LOGGER.info("Registering ModBlocks for " + trevorssentinels.MOD_ID);
    }
}
