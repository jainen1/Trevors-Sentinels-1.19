package net.trevorskullcrafter.trevorssentinels.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.trevorskullcrafter.trevorssentinels.world.feature.ModPlacedFeatures;

public class ModTreeGeneration {
    public static void generateTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.YGGDRASIL_PLACED.getKey().get());

        /*BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.YGGDRASIL_PLACED.getKey().get());*/
    }
}