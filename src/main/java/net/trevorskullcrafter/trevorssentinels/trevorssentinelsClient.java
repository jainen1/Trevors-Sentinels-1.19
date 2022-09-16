package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.screen.ForgeScreen;
import net.trevorskullcrafter.trevorssentinels.screen.ModScreenHandlers;

public class trevorssentinelsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUPERFORGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_RICE_PLANT, RenderLayer.getCutout());
        HandledScreens.register(ModScreenHandlers.FORGE_SCREEN_HANDLER, ForgeScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOLOBARRIER, RenderLayer.getTranslucent());
    }
}
