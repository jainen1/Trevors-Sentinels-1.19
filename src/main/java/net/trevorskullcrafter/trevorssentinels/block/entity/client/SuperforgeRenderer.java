package net.trevorskullcrafter.trevorssentinels.block.entity.client;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.entity.SuperforgeBlockEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SuperforgeRenderer extends GeoBlockRenderer<SuperforgeBlockEntity> {
    public SuperforgeRenderer() {
        super(new DefaultedBlockGeoModel<>(new Identifier(trevorssentinels.MOD_ID, "superforge")));
    }
}