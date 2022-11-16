package net.trevorskullcrafter.trevorssentinels.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.trevorskullcrafter.trevorssentinels.world.feature.ModPlacedFeatures;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModOreGeneration {
    public static void generateOres(){
        trevorssentinels.LOGGER.info("Making space radioactive... (" + MOD_ID + ")");
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.URANIUM_ORE_PLACED.getKey().get());
    }
}
