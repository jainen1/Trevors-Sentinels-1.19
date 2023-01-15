package net.trevorskullcrafter.trevorssentinels.block.entity.client.renderer.armor;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.item.custom.SentinumArmorItem;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SentinumArmorRenderer extends GeoArmorRenderer<SentinumArmorItem> {
    public SentinumArmorRenderer() {
        super(new DefaultedItemGeoModel<>(new Identifier(trevorssentinels.MOD_ID, "armor/sentinum_armor")));
    }
}