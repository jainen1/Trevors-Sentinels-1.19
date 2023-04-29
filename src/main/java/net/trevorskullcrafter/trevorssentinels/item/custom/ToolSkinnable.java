package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public interface ToolSkinnable {
    default int getCustomModelData(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        return nbtCompound != null && nbtCompound.contains("CustomModelData") ? nbtCompound.getInt("CustomModelData") : 0;
    }

    default void setCustomModelData(ItemStack stack, int data) {
        stack.getOrCreateNbt().putInt("CustomModelData", data);
    }

    static ItemStack newCustomModelStack(ItemStack stack, int data){
        ItemStack newStack = stack.copy();
        if(newStack.getItem() instanceof ToolSkinnable newNewStack) newNewStack.setCustomModelData(stack, data);
        return stack;
    }
}