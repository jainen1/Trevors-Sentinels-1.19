package net.trevorskullcrafter.trevorssentinels.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.RoombaEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RoombaRenderer extends GeoEntityRenderer<RoombaEntity> {
    public RoombaRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DefaultedEntityGeoModel<>(new Identifier(trevorssentinels.MOD_ID, "roomba")));
        this.shadowRadius = 0.4f;
    }
}