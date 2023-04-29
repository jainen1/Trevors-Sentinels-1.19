package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PaintPack extends Item {
    int index;
    public PaintPack(int index, Settings settings) {
        super(settings);
        this.index = index;
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public int getItemSkinData(Item item){ return 1; }
}