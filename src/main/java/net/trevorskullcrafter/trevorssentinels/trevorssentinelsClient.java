package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModBlockEntities;
import net.trevorskullcrafter.trevorssentinels.block.entity.client.FlorbusRenderer;
import net.trevorskullcrafter.trevorssentinels.block.entity.client.RoombaRenderer;
import net.trevorskullcrafter.trevorssentinels.block.entity.client.SentinelRenderer;
import net.trevorskullcrafter.trevorssentinels.block.entity.client.renderer.armor.SentinumArmorRenderer;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.event.KeyInputHandler;
import net.trevorskullcrafter.trevorssentinels.fluid.ModFluids;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.client.SuperforgeItemRenderer;
import net.trevorskullcrafter.trevorssentinels.screen.ForgeScreen;
import net.trevorskullcrafter.trevorssentinels.screen.ModScreenHandlers;
import net.trevorskullcrafter.trevorssentinels.util.ModModelPredicateProvider;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class trevorssentinelsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUPERFORGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_RICE_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YGGDRASIL_LEAVES, RenderLayer.getCutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YGGDRASIL_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDAS_LEAVES, RenderLayer.getCutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDAS_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BANANA_LEAVES, RenderLayer.getCutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BANANA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOLOBARRIER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DATA_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VENDOR, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.QUICKSAND_STILL, ModFluids.QUICKSAND_FLOWING,
        new SimpleFluidRenderHandler(
                new Identifier("trevorssentinels:block/quicksand_still"),
                new Identifier("trevorssentinels:block/quicksand_flow")
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),ModFluids.QUICKSAND_STILL, ModFluids.QUICKSAND_FLOWING);

        HandledScreens.register(ModScreenHandlers.FORGE_SCREEN_HANDLER, ForgeScreen::new);

        KeyInputHandler.register();

        /*GeoItemRenderer.registerItemRenderer(ModItems.SUPERFORGE_ITEM, new SuperforgeItemRenderer());
        BlockEntityRendererRegistry.register(ModBlockEntities.SUPERFORGE, SuperforgeRenderer::new);*/

        ModModelPredicateProvider.registerModModels();
        EntityRendererRegistry.register(ModEntities.SENTINEL, SentinelRenderer::new);
        EntityRendererRegistry.register(ModEntities.SENTINUM_ROOMBA, RoombaRenderer::new);
        EntityRendererRegistry.register(ModEntities.FLORBUS, FlorbusRenderer::new);
        EntityRendererRegistry.register(trevorssentinels.ShardEntityType, (context) -> new FlyingItemEntityRenderer(context));
    }
}