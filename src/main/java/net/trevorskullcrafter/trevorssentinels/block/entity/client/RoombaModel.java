package net.trevorskullcrafter.trevorssentinels.block.entity.client;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.RoombaEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RoombaModel extends AnimatedGeoModel<RoombaEntity> {
    @Override
    public Identifier getModelResource(RoombaEntity object) {
        return new Identifier(trevorssentinels.MOD_ID, "geo/roomba.geo.json");
    }

    @Override
    public Identifier getTextureResource(RoombaEntity object) {
        return new Identifier(trevorssentinels.MOD_ID, "textures/entity/roomba.png");
    }

    @Override
    public Identifier getAnimationResource(RoombaEntity animatable) {
        return new Identifier(trevorssentinels.MOD_ID, "animations/roomba_animation.json");
    }
}