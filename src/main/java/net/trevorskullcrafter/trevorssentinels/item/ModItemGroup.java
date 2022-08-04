package net.trevorskullcrafter.trevorssentinels.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModItemGroup {
    public static final ItemGroup SENTINELS = FabricItemGroupBuilder.build(new Identifier(trevorssentinels.MOD_ID, "sentinels"),
            () -> new ItemStack(ModItems.SENTINUM_SHARD));

    public static final ItemGroup ARMORY = FabricItemGroupBuilder.build(new Identifier(trevorssentinels.MOD_ID, "armory"),
            () -> new ItemStack(ModItems.BLOOD_DIAMOND));
}
