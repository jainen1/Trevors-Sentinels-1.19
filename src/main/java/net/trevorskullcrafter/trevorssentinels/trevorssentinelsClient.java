package net.trevorskullcrafter.trevorssentinels;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.entity.EntityType;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
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
import net.trevorskullcrafter.trevorssentinels.util.ModRegistries;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;

public class trevorssentinelsClient implements ClientModInitializer {

    @Override public void onInitializeClient(){
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xCFF8FF, ModItems.VENDOR_TOKEN);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TextUtil.DARK_PURPLE.getRGB(), ModItems.LEGENDARY_TOKEN);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.GAS_TEST, TextUtil.WHITE), ModItems.GAS_CAPSULE); //0x71ff7c

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_AQUA, TextUtil.SENTINEL_DARK_AQUA),
                ModBlocks.HARD_LIGHT, ModBlocks.HARD_LIGHT_BARRIER);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_AQUA, TextUtil.SENTINEL_DARK_AQUA),
                ModBlocks.HARD_LIGHT_BARRIER);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.GOLD, TextUtil.SENTINEL_DARK_GOLD),
                ModBlocks.CAUTION_HARD_LIGHT, ModBlocks.CAUTION_HARD_LIGHT_BARRIER);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.GOLD, TextUtil.SENTINEL_DARK_GOLD),
                ModBlocks.CAUTION_HARD_LIGHT_BARRIER);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_CRIMSON, TextUtil.SENTINEL_DARK_CRIMSON),
                ModBlocks.SENTINEL_HARD_LIGHT, ModBlocks.SENTINEL_HARD_LIGHT_BARRIER);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> TextUtil.tintByIndex(tintIndex, TextUtil.SENTINEL_CRIMSON, TextUtil.SENTINEL_DARK_CRIMSON),
                ModBlocks.SENTINEL_HARD_LIGHT_BARRIER);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.YGGDRASIL_LEAVES, ModBlocks.YGGDRASIL_SAPLING, ModBlocks.POTTED_YGGDRASIL_SAPLING,
                ModBlocks.YGGDRASIL_DOOR, ModBlocks.YGGDRASIL_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CHARRED_DOOR, ModBlocks.CHARRED_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.MIDAS_LEAVES, ModBlocks.MIDAS_SAPLING, ModBlocks.POTTED_MIDAS_SAPLING,
                ModBlocks.MIDAS_DOOR, ModBlocks.MIDAS_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.VIRIDESCENT_LEAVES, ModBlocks.VIRIDESCENT_SAPLING, ModBlocks.POTTED_VIRIDESCENT_SAPLING,
                ModBlocks.VIRIDESCENT_DOOR, ModBlocks.VIRIDESCENT_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SAPLING, ModBlocks.POTTED_CERULII_SAPLING,
                ModBlocks.CERULII_DOOR, ModBlocks.CERULII_TRAPDOOR);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.FANCY_COMPUTER, ModBlocks.TRANSITITE_BLOCK, ModBlocks.SUPERFORGE,
                ModBlocks.MODIFICATION_TABLE, ModBlocks.TRANQUIL_ROSE, ModBlocks.POTTED_TRANQUIL_ROSE, ModBlocks.FEATHERCORN, ModBlocks.SKULLWEED,
                ModBlocks.POTTED_SKULLWEED, ModBlocks.RICE_PLANT, ModBlocks.GOLDEN_RICE_PLANT, ModBlocks.FLESH_VEINS);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), ModBlocks.HARD_LIGHT, ModBlocks.CAUTION_HARD_LIGHT, ModBlocks.SENTINEL_HARD_LIGHT,
                ModBlocks.HARD_LIGHT_BARRIER, ModBlocks.CAUTION_HARD_LIGHT_BARRIER, ModBlocks.SENTINEL_HARD_LIGHT_BARRIER, ModBlocks.DATA_BLOCK);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.QUICKSAND_STILL, ModFluids.QUICKSAND_FLOWING,
        new SimpleFluidRenderHandler(new Identifier("trevorssentinels:block/quicksand_still"), new Identifier("trevorssentinels:block/quicksand_flow")));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.QUICKSAND_STILL, ModFluids.QUICKSAND_FLOWING);

        KeyInputHandler.register();
        ModMessages.registerS2CPackets();

        ModRegistries.registerModelPredicates();
        EntityRendererRegistry.register(ModEntities.SENTINEL, SentinelRenderer::new);
        EntityRendererRegistry.register(ModEntities.GALINITE_ROOMBA, RoombaRenderer::new);
        EntityRendererRegistry.register(ModEntities.FLORBUS, FlorbusRenderer::new);
        EntityRendererRegistry.register(ModEntities.NUCLEAR_CHARGE, NuclearChargeEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GALLIUM_SHARD, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.DAGGER, DaggerEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GRENADE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LASER, LaserEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.GAS, LaserEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.BULLET, LaserEntityRenderer::new);
        EntityRendererRegistry.register(EntityType.ENDERMAN, ReplacedEndermanRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.SUPERFORGE, context -> new SuperforgeRenderer("superforge"));
        BlockEntityRendererFactories.register(ModBlockEntities.MODIFICATION_TABLE, context -> new ModificationTableRenderer("modification_table"));

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.YGGDRASIL_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.YGGDRASIL_HANGING_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CHARRED_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CHARRED_HANGING_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.MIDAS_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.MIDAS_HANGING_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.VIRIDESCENT_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.VIRIDESCENT_HANGING_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CERULII_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.CERULII_HANGING_SIGN_TEXTURE));
    }
}