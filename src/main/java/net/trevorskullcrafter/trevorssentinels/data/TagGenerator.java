package net.trevorskullcrafter.trevorssentinels.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import java.util.concurrent.CompletableFuture;

public class TagGenerator extends FabricTagProvider.ItemTagProvider {
    public TagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<Item> NUCLEAR_CHARGE_ACTIVATOR = TagKey.of
            (RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "nuclear_charge_activator"));
    public static final TagKey<Block> LASER_REFLECTIVE = TagKey.of
            (RegistryKeys.BLOCK, new Identifier(trevorssentinels.MOD_ID, "laser_reflective"));
    public static final TagKey<Block> LASER_PASS = TagKey.of
            (RegistryKeys.BLOCK, new Identifier(trevorssentinels.MOD_ID, "laser_pass"));
    public static final TagKey<Item> CROSSBOW_HOLD = TagKey.of
            (RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "crossbow_hold"));
    public static final TagKey<Item> ITEM_BAR_COLOR_OVERRIDE = TagKey.of
            (RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "item_bar_color_override"));
    public static final TagKey<EntityType<?>> MILKABLES = TagKey.of
            (RegistryKeys.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "milkables"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

    }
}