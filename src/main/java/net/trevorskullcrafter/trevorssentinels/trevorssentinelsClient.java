package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;

public class trevorssentinelsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUPERFORGE, RenderLayer.getCutout());

        /*ModModelPredicateProvider.registerModModels();*/
    }
}
