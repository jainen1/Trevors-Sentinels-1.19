package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.item.Item;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;

public class HardLightBlock extends GlassBlock {
    public HardLightBlock(AbstractBlock.Settings settings) { super(settings); }

    @Override public Item asItem() { return ModItems.GALINITE_HOLOPROJECTOR; }
}