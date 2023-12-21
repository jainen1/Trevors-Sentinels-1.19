package net.trevorskullcrafter.trevorssentinels.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.trevorskullcrafter.trevorssentinels.entity.custom.LaserEntity;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class LaserEntityRenderer<T extends LaserEntity> extends EntityRenderer<T> {
    private final ItemRenderer itemRenderer; private final float scale; private final boolean lit;

    public LaserEntityRenderer(EntityRendererFactory.Context ctx, float scale, boolean lit) {
        super(ctx); this.itemRenderer = ctx.getItemRenderer(); this.scale = scale; this.lit = lit;
    }
    public LaserEntityRenderer(EntityRendererFactory.Context context) { this(context, 1.0F, true); }

    protected int getBlockLight(T entity, BlockPos pos) { return this.lit ? 15 : super.getBlockLight(entity, pos); }
    @Override public void render(T entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (entity.age >= 2) {
            matrices.push();
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw())));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch())));

            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(45.0F));
            matrices.scale(0.05625F, 0.05625F, 0.05625F);
            matrices.translate(-4.0F, 0.0F, 0.0F);
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(this.getTexture(entity)));
            MatrixStack.Entry entry = matrices.peek();
            Matrix4f matrix4f = entry.getPositionMatrix();
            Matrix3f matrix3f = entry.getNormalMatrix();

            Integer color = entity.getColor();

            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, light, color);
            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, light, color);

            /*
            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, light, color);
            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, light, color);
            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, light, color);
            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, light, color);
            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, light, color);
            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, light, color);
            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, light, color);
            this.vertex(matrix4f, matrix3f, vertexConsumer, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, light, color);

            for(int u = 0; u < 4; ++u) {
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
                this.vertex(matrix4f, matrix3f, vertexConsumer, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, light, color);
                this.vertex(matrix4f, matrix3f, vertexConsumer, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, light, color);
                this.vertex(matrix4f, matrix3f, vertexConsumer, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, light, color);
                this.vertex(matrix4f, matrix3f, vertexConsumer, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, light, color);
            }*/

            matrices.pop();
            super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        }
    }

    public void vertex(Matrix4f positionMatrix, Matrix3f normalMatrix, VertexConsumer vertexConsumer, int x, int y, int z, float u, float v, int normalX, int normalZ, int normalY, int light, Integer color) {
        vertexConsumer.vertex(positionMatrix, (float)x, (float)y, (float)z).color(Vec3d.unpackRgb(color).toVector3f().x(), Vec3d.unpackRgb(color).toVector3f().y(),
                Vec3d.unpackRgb(color).toVector3f().z(), 1.0f).texture(u, v).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(normalMatrix, (float)normalX, (float)normalY, (float)normalZ).next();
    }

    @Override public Identifier getTexture(T entity) { return new Identifier("textures/entity/projectiles/tipped_arrow.png"); }
}