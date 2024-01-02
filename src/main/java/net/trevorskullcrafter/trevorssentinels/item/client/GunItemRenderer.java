package net.trevorskullcrafter.trevorssentinels.item.client;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.item.custom.NewGunItem;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GunItemRenderer extends GeoItemRenderer<NewGunItem> {
    public GunItemRenderer() {
        super(new DefaultedItemGeoModel<>(new Identifier(trevorssentinels.MOD_ID, "agnostyk")));
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}