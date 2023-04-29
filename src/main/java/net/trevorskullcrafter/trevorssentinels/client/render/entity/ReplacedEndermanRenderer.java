package net.trevorskullcrafter.trevorssentinels.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.ReplacedEndermanEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class ReplacedEndermanRenderer extends GeoReplacedEntityRenderer<EndermanEntity, ReplacedEndermanEntity> {
    public ReplacedEndermanRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(new Identifier(trevorssentinels.MOD_ID, "enderman")), new ReplacedEndermanEntity());
    }
}