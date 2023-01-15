package net.trevorskullcrafter.trevorssentinels.item.client;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.item.custom.SuperforgeItem;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib.model.GeoModel;

public class SuperforgeBlockModel extends GeoModel<SuperforgeItem> {
    @Override
    public Identifier getModelResource(SuperforgeItem object) {
        return new Identifier(trevorssentinels.MOD_ID, "geo/superforge.geo.json");
    }

    @Override
    public Identifier getTextureResource(SuperforgeItem object) {
        return new Identifier(trevorssentinels.MOD_ID, "textures/block/superforge.png");
    }

    @Override
    public Identifier getAnimationResource(SuperforgeItem animatable) {
        return new Identifier(trevorssentinels.MOD_ID, "animations/superforge_animation.json");
    }
}