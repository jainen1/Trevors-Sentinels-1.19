package net.trevorskullcrafter.trevorssentinels.block.sapling;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.trevorskullcrafter.trevorssentinels.world.feature.ModConfiguredFeatures;

public class ViridescentSaplingGenerator extends SaplingGenerator {
    public ViridescentSaplingGenerator() {
    }

    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        if (random.nextInt(10) == 0) {
            return ModConfiguredFeatures.FANCY_VIRIDESCENT_TREE;
        } else {
            return ModConfiguredFeatures.VIRIDESCENT_TREE;
        }
    }
}