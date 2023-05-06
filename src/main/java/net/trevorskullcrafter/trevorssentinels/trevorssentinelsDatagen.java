package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.trevorskullcrafter.trevorssentinels.data.*;
import net.trevorskullcrafter.trevorssentinels.world.feature.ModConfiguredFeatures;

public class trevorssentinelsDatagen implements DataGeneratorEntrypoint {
    @Override public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModLootTableGenerator::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(AdvancementGenerator::new);
        pack.addProvider(EnglishLangGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
    }

    @Override public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
    }
}