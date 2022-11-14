package net.trevorskullcrafter.trevorssentinels.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> END_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.URANIUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> URANIUM_ORE =
            ConfiguredFeatures.register("uranium_ore", Feature.ORE, new OreFeatureConfig(END_ORES,3));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> YGGDRASIL_TREE =
            ConfiguredFeatures.register("yggdrasil_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.YGGDRASIL_LOG),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(ModBlocks.YGGDRASIL_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> YGGDRASIL_CHECKED = PlacedFeatures.register("yggdrasil_checked",
            ModConfiguredFeatures.YGGDRASIL_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.YGGDRASIL_SAPLING)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> YGGDRASIL_SPAWN =
            ConfiguredFeatures.register("yggdrasil_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(YGGDRASIL_CHECKED, 0.5f)),
                            YGGDRASIL_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> MIDAS_TREE =
            ConfiguredFeatures.register("midas_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.MIDAS_LOG),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(ModBlocks.MIDAS_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> MIDAS_CHECKED = PlacedFeatures.register("midas_checked",
            ModConfiguredFeatures.MIDAS_TREE, List.of(PlacedFeatures.wouldSurvive(ModBlocks.MIDAS_SAPLING)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MIDAS_SPAWN =
            ConfiguredFeatures.register("midas_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(MIDAS_CHECKED, 0.2f)),
                            MIDAS_CHECKED));

    public static void registerConfiguredFeatures(){
        trevorssentinels.LOGGER.debug("Registering the ModConfiguredFeatures for "+ trevorssentinels.MOD_ID);
    }
}