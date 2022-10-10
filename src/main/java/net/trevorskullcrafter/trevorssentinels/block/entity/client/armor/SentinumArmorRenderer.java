package net.trevorskullcrafter.trevorssentinels.block.entity.client.armor;

import net.trevorskullcrafter.trevorssentinels.item.custom.SentinumArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class SentinumArmorRenderer extends GeoArmorRenderer<SentinumArmorItem> {
    public SentinumArmorRenderer() {
        super(new SentinumArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
