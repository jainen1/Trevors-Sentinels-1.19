package net.trevorskullcrafter.trevorssentinels.item.client;

import net.trevorskullcrafter.trevorssentinels.item.custom.SuperforgeItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SuperforgeItemRenderer extends GeoItemRenderer<SuperforgeItem> {
    public SuperforgeItemRenderer() {
        super(new SuperforgeBlockModel());
    }
}