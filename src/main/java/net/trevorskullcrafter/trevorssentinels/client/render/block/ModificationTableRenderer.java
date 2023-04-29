package net.trevorskullcrafter.trevorssentinels.client.render.block;

import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModificationTableBlockEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ModificationTableRenderer extends GeoBlockRenderer<ModificationTableBlockEntity> {
    public ModificationTableRenderer(String path) { super(new DefaultedBlockGeoModel<>(new Identifier(trevorssentinels.MOD_ID, path))); }
}