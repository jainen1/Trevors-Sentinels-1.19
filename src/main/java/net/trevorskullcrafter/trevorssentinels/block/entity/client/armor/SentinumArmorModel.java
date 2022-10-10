package net.trevorskullcrafter.trevorssentinels.block.entity.client.armor;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.item.custom.SentinumArmorItem;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SentinumArmorModel extends AnimatedGeoModel<SentinumArmorItem> {
    @Override
    public Identifier getModelResource(SentinumArmorItem object) {
        return new Identifier(trevorssentinels.MOD_ID, "geo/sentinum_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(SentinumArmorItem object) {
        return new Identifier(trevorssentinels.MOD_ID, "textures/models/armor/sentinum_armor.png");
    }

    @Override
    public Identifier getAnimationResource(SentinumArmorItem animatable) {
        return new Identifier(trevorssentinels.MOD_ID, "animations/armor_animation.json");
    }
}
