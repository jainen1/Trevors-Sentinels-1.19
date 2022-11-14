package net.trevorskullcrafter.trevorssentinels.block.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.FlorbusEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.SentinelEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FlorbusRenderer extends GeoEntityRenderer<FlorbusEntity> {
    public FlorbusRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new FlorbusModel());
        this.shadowRadius = 0.9f;
    }

    @Override
    public Identifier getTextureResource(FlorbusEntity instance){
        return super.getTextureResource(instance);
    }

    @Override
    public RenderLayer getRenderType(FlorbusEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation){
        stack.scale(1f, 1f, 1f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
