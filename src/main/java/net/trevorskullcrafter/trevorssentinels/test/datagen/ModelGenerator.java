package net.trevorskullcrafter.trevorssentinels.test.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModelGenerator extends FabricModelProvider {
    private ModelGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // ...
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // ...
    }

    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        // ...
        fabricDataGenerator.addProvider(ModelGenerator::new);
        // ...
    }
}