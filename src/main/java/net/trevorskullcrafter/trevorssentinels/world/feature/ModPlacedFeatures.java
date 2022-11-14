package net.trevorskullcrafter.trevorssentinels.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> URANIUM_ORE_PLACED = PlacedFeatures.register("uranium_ore_placed",
            ModConfiguredFeatures.URANIUM_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

    public static final RegistryEntry<PlacedFeature> YGGDRASIL_PLACED = PlacedFeatures.register("yggdrasil_placed",
            ModConfiguredFeatures.YGGDRASIL_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.5f, 2)));

    public static final RegistryEntry<PlacedFeature> MIDAS_PLACED = PlacedFeatures.register("midas_placed",
            ModConfiguredFeatures.MIDAS_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.5f, 2)));

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier){
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier){
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier){
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
