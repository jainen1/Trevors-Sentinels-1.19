package net.trevorskullcrafter.trevorssentinels.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.trevorskullcrafter.trevorssentinels.entity.custom.LaserEntity;

@Environment(EnvType.CLIENT)
public class LaserEntityModel extends SinglePartEntityModel<LaserEntity> {
    private final ModelPart root;
    private final ModelPart inside;
    private final ModelPart outside;

    public LaserEntityModel(ModelPart root){
        this.root = root;
        this.inside = root.getChild("inside");
        this.outside = root.getChild("outside");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("neck", ModelPartBuilder.create().uv(68, 73).cuboid(-5.0F, -1.0F, -18.0F, 10.0F, 10.0F, 18.0F), ModelTransform.pivot(0.0F, -7.0F, 5.5F));
        modelPartData2.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -20.0F, -14.0F, 16.0F, 20.0F, 16.0F).uv(0, 0).cuboid(-2.0F, -6.0F, -18.0F, 4.0F, 8.0F, 4.0F), ModelTransform.pivot(0.0F, 16.0F, -17.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {

        super.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    @Override public ModelPart getPart() {
        return this.root;
    }

    @Override public void setAngles(LaserEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}