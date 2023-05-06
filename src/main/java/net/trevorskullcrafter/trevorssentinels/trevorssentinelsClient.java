package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModBlockEntities;
import net.trevorskullcrafter.trevorssentinels.client.render.block.ModificationTableRenderer;
import net.trevorskullcrafter.trevorssentinels.client.render.block.SuperforgeRenderer;
import net.trevorskullcrafter.trevorssentinels.client.render.entity.*;
import net.trevorskullcrafter.trevorssentinels.client.render.block.entity.NuclearChargeEntityRenderer;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.event.KeyInputHandler;
import net.trevorskullcrafter.trevorssentinels.fluid.ModFluids;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.networking.ModMessages;
import net.trevorskullcrafter.trevorssentinels.screen.ForgeScreen;
import net.trevorskullcrafter.trevorssentinels.screen.ModScreenHandlers;
import net.trevorskullcrafter.trevorssentinels.util.ModRegistries;

public class trevorssentinelsClient implements ClientModInitializer {

    @Override public void onInitializeClient(){
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xCFF8FF, ModItems.VENDOR_TOKEN);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xaa00aa, ModItems.LEGENDARY_TOKEN);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.YGGDRASIL_LEAVES, ModBlocks.YGGDRASIL_SAPLING, ModBlocks.POTTED_YGGDRASIL_SAPLING,
                ModBlocks.YGGDRASIL_DOOR, ModBlocks.YGGDRASIL_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHARRED_OAK_DOOR, ModBlocks.CHARRED_OAK_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MIDAS_LEAVES, ModBlocks.MIDAS_SAPLING, ModBlocks.POTTED_MIDAS_SAPLING,
                ModBlocks.MIDAS_DOOR, ModBlocks.MIDAS_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.BANANA_LEAVES, ModBlocks.BANANA_SAPLING, ModBlocks.POTTED_BANANA_SAPLING,
                ModBlocks.BANANA_DOOR, ModBlocks.BANANA_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SAPLING, ModBlocks.POTTED_CERULII_SAPLING,
                ModBlocks.CERULII_DOOR, ModBlocks.CERULII_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FANCY_COMPUTER, ModBlocks.TRANSITITE_BLOCK, ModBlocks.SUPERFORGE,
                ModBlocks.MODIFICATION_TABLE, ModBlocks.TRANQUIL_ROSE, ModBlocks.POTTED_TRANQUIL_ROSE, ModBlocks.FEATHERCORN, ModBlocks.SKULLWEED,
                ModBlocks.POTTED_SKULLWEED, ModBlocks.RICE_PLANT, ModBlocks.GOLDEN_RICE_PLANT, ModBlocks.FLESH_VEINS);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), ModBlocks.HOLOBARRIER, ModBlocks.DATA_BLOCK);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.QUICKSAND_STILL, ModFluids.QUICKSAND_FLOWING,
        new SimpleFluidRenderHandler(new Identifier("trevorssentinels:block/quicksand_still"), new Identifier("trevorssentinels:block/quicksand_flow")));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.QUICKSAND_STILL, ModFluids.QUICKSAND_FLOWING);

        HandledScreens.register(ModScreenHandlers.FORGE_SCREEN_HANDLER, ForgeScreen::new);

        KeyInputHandler.register();
        ModMessages.registerS2CPackets();

        ModRegistries.registerModelPredicates();
        EntityRendererRegistry.register(ModEntities.SENTINEL, SentinelRenderer::new);
        EntityRendererRegistry.register(ModEntities.GALINITE_ROOMBA, RoombaRenderer::new);
        EntityRendererRegistry.register(ModEntities.FLORBUS, FlorbusRenderer::new);
        EntityRendererRegistry.register(ModEntities.NUCLEAR_CHARGE, NuclearChargeEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GALINITE_SHARD, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DAGGER, DaggerEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GRENADE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LASER, LaserEntityRenderer::new);
        EntityRendererRegistry.register(EntityType.ENDERMAN, ReplacedEndermanRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.SUPERFORGE, context -> new SuperforgeRenderer("superforge"));
        BlockEntityRendererFactories.register(ModBlockEntities.MODIFICATION_TABLE, context -> new ModificationTableRenderer("modification_table"));
    }
}