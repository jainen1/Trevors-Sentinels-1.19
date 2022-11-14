package net.trevorskullcrafter.trevorssentinels.block.entity.client;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.FlorbusEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.SentinelEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FlorbusModel extends AnimatedGeoModel<FlorbusEntity> {
    @Override
    public Identifier getModelResource(FlorbusEntity object) {
        return new Identifier(trevorssentinels.MOD_ID, "geo/florbus.geo.json");
    }

    @Override
    public Identifier getTextureResource(FlorbusEntity object) {
        return new Identifier(trevorssentinels.MOD_ID, "textures/entity/florbus.png");
    }

    @Override
    public Identifier getAnimationResource(FlorbusEntity animatable) {
        return new Identifier(trevorssentinels.MOD_ID, "animations/florbus_animation.json");
    }
}