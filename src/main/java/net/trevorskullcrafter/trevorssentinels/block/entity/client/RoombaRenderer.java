package net.trevorskullcrafter.trevorssentinels.block.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.RoombaEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RoombaRenderer extends GeoEntityRenderer<RoombaEntity> {
    public RoombaRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new RoombaModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(RoombaEntity instance){
        return super.getTextureResource(instance);
    }

    @Override
    public RenderLayer getRenderType(RoombaEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation){
        stack.scale(1f, 1f, 1f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
