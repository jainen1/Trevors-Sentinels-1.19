package net.trevorskullcrafter.trevorssentinels.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.trevorskullcrafter.trevorssentinels.entity.custom.DaggerEntity;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

@Environment(EnvType.CLIENT)
public class DaggerEntityRenderer<T extends DaggerEntity> extends EntityRenderer<T> {
    private final ItemRenderer itemRenderer; private final float scale; private final boolean lit;

    public DaggerEntityRenderer(EntityRendererFactory.Context ctx, float scale, boolean lit) {
        super(ctx); this.itemRenderer = ctx.getItemRenderer(); this.scale = scale; this.lit = lit;
    }

    public DaggerEntityRenderer(EntityRendererFactory.Context context) { this(context, 1.7F, false); }

    protected int getBlockLight(T entity, BlockPos pos) { return this.lit ? 15 : super.getBlockLight(entity, pos); }

    public void render(T entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (entity.age >= 2) {
            matrices.push();
            matrices.scale(scale, scale, scale);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch()) - 45.0F));
            float s = (float)entity.shake - tickDelta;
            if (s > 0.0F) {
                float t = -MathHelper.sin(s * 3.0F) * s;
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(t));
            }

            itemRenderer.renderItem(null, entity.asItemStack() == null? ModArmory.ROSE_GOLD_DAGGER.getDefaultStack(): entity.asItemStack(),
                    ModelTransformationMode.GROUND, false, matrices, vertexConsumers, null, light, OverlayTexture.DEFAULT_UV, entity.getId());
            matrices.pop();
            super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        }
    }

    @Override public Identifier getTexture(T entity) { return new Identifier(trevorssentinels.MOD_ID, entity.asItemStack().getTranslationKey()); }
}