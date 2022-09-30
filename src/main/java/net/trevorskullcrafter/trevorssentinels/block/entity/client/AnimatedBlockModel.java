package net.trevorskullcrafter.trevorssentinels.block.entity.client;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.entity.AnimatedBlockEntity;
import net.trevorskullcrafter.trevorssentinels.item.custom.AnimatedBlockItem;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedBlockModel extends AnimatedGeoModel<AnimatedBlockEntity> {
    @Override
    public Identifier getModelResource(AnimatedBlockEntity object) {
        return new Identifier(trevorssentinels.MOD_ID, "geo/superforge.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnimatedBlockEntity object) {
        return new Identifier(trevorssentinels.MOD_ID, "textures/block/superforge.png");
    }

    @Override
    public Identifier getAnimationResource(AnimatedBlockEntity animatable) {
        return new Identifier(trevorssentinels.MOD_ID, "animations/superforge_animation.json");
    }
}
