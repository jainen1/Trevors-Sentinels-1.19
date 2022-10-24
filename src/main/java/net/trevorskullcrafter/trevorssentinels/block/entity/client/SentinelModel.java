package net.trevorskullcrafter.trevorssentinels.block.entity.client;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.SentinelEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SentinelModel extends AnimatedGeoModel<SentinelEntity> {
    @Override
    public Identifier getModelResource(SentinelEntity object) {
        return new Identifier(trevorssentinels.MOD_ID, "geo/sentinel.geo.json");
    }

    @Override
    public Identifier getTextureResource(SentinelEntity object) {
        return new Identifier(trevorssentinels.MOD_ID, "textures/entity/sentinel.png");
    }

    @Override
    public Identifier getAnimationResource(SentinelEntity animatable) {
        return new Identifier(trevorssentinels.MOD_ID, "animations/sentinel_animation.json");
    }
}