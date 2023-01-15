package net.trevorskullcrafter.trevorssentinels.block.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.FlorbusEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FlorbusRenderer extends GeoEntityRenderer<FlorbusEntity> {
    public FlorbusRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DefaultedEntityGeoModel<>(new Identifier(trevorssentinels.MOD_ID, "florbus")));
        this.shadowRadius = 0.9f;
    }

    @Override
    public Identifier getTexture(FlorbusEntity instance){
        return super.getTexture(instance);
    }
}