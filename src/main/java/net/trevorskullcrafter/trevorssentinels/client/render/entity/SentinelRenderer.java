package net.trevorskullcrafter.trevorssentinels.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.SentinelEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SentinelRenderer extends GeoEntityRenderer<SentinelEntity> {
    public SentinelRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DefaultedEntityGeoModel<>(new Identifier(trevorssentinels.MOD_ID, "sentinel")));
        this.shadowRadius = 0.4f;
    }
}