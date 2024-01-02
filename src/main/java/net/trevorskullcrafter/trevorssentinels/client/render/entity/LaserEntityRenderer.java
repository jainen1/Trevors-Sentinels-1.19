package net.trevorskullcrafter.trevorssentinels.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.trevorskullcrafter.trevorssentinels.entity.client.ModEntityLayers;
import net.trevorskullcrafter.trevorssentinels.entity.custom.LaserEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import org.joml.Vector3f;

@Environment(EnvType.CLIENT)
public class LaserEntityRenderer extends EntityRenderer<LaserEntity> {
    private final LaserEntityModel model;

    public LaserEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new LaserEntityModel(context.getPart(ModEntityLayers.LASER));
    }

    public void render(LaserEntity laserEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(laserEntity.age > 1) {
            matrixStack.push();
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, laserEntity.prevYaw, laserEntity.getYaw()) - 90.0F));
            matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, laserEntity.prevPitch, laserEntity.getPitch()) + 90.0F));
            VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(laserEntity)));
            Vector3f color = Vec3d.unpackRgb(laserEntity.getColor()).toVector3f();
            this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, color.x(), color.y(), color.z(), 1.0f);
            matrixStack.pop();
            super.render(laserEntity, f, g, matrixStack, vertexConsumerProvider, i);
        }
    }

    @Override public Identifier getTexture(LaserEntity entity) { return new Identifier(trevorssentinels.MOD_ID, "textures/entity/laser.png"); }
}