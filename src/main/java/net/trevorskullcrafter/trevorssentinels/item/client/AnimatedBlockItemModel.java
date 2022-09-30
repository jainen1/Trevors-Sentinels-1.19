package net.trevorskullcrafter.trevorssentinels.item.client;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.item.custom.AnimatedBlockItem;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AnimatedBlockItemModel extends AnimatedGeoModel<AnimatedBlockItem> {
    @Override
    public Identifier getModelResource(AnimatedBlockItem object) {
        return new Identifier(trevorssentinels.MOD_ID, "geo/superforge.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnimatedBlockItem object) {
        return new Identifier(trevorssentinels.MOD_ID, "textures/block/superforge.png");
    }

    @Override
    public Identifier getAnimationResource(AnimatedBlockItem animatable) {
        return new Identifier(trevorssentinels.MOD_ID, "animations/superforge_animation.json");
    }
}
