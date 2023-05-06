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
import net.trevorskullcrafter.trevorssentinels.item.BetaItems;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) { super(output, completableFuture); }

    public static final TagKey<Block> LASER_REFLECTIVE = TagKey.of(RegistryKeys.BLOCK, new Identifier(trevorssentinels.MOD_ID, "laser_reflective"));
    public static final TagKey<Block> LASER_PASS = TagKey.of(RegistryKeys.BLOCK, new Identifier(trevorssentinels.MOD_ID, "laser_pass"));

    public static final TagKey<Item> NUCLEAR_CHARGE_ACTIVATOR = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "nuclear_charge_activator"));
    public static final TagKey<Item> CROSSBOW_HOLD = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "crossbow_hold"));
    public static final TagKey<Item> ITEM_BAR_COLOR_OVERRIDE = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "item_bar_color_override"));

    public static final TagKey<EntityType<?>> MILKABLES = TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "milkables"));

    @Override protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(NUCLEAR_CHARGE_ACTIVATOR)
                .add(ModItems.NUCLEAR_DETONATOR);
        getOrCreateTagBuilder(CROSSBOW_HOLD)
                .add(ModArmory.LASER_PISTOL, ModArmory.LASER_TASER, ModArmory.LASER_SNIPER_ECHO, ModArmory.LASER_MINIGUN, ModArmory.LASER_SHOTGUN, ModArmory.LASER_SNIPER,
                        ModArmory.LASER_HEALER, ModArmory.LASER_SPREADER, ModArmory.LASER_RIFLE, ModArmory.LASER_REVOLVER, ModArmory.VILE_SPITTER);
        getOrCreateTagBuilder(ITEM_BAR_COLOR_OVERRIDE)
                .add(ModArmory.NUCLEAR_SWORD, ModArmory.NUCLEAR_PICKAXE, ModArmory.NUCLEAR_AXE, ModArmory.NUCLEAR_SHOVEL, ModArmory.NUCLEAR_HOE, ModArmory.NUCLEAR_HELMET,
                        ModArmory.NUCLEAR_CHESTPLATE, ModArmory.NUCLEAR_LEGGINGS, ModArmory.NUCLEAR_BOOTS, ModArmory.NANOTECH_SWORD, ModArmory.NANOTECH_PICKAXE,
                        ModArmory.NANOTECH_AXE, ModArmory.NANOTECH_SHOVEL, ModArmory.NANOTECH_HOE, ModArmory.NANOTECH_HELMET, ModArmory.NANOTECH_CHESTPLATE,
                        ModArmory.NANOTECH_LEGGINGS, ModArmory.NANOTECH_BOOTS, ModArmory.ZENITHIUM_SWORD, ModArmory.ZENITHIUM_PICKAXE, ModArmory.ZENITHIUM_AXE,
                        ModArmory.ZENITHIUM_SHOVEL, ModArmory.ZENITHIUM_HOE, ModArmory.ZENITHIUM_CHESTPLATE, ModArmory.ZENITHIUM_LEGGINGS, ModArmory.SKYHOPPERS,
                        BetaItems.PORTKEY, BetaItems.THANATU_BLADE, ModItems.GALINITE_HOLOPROJECTOR, ModArmory.LASER_PISTOL, ModArmory.LASER_TASER,
                        ModArmory.LASER_SNIPER_ECHO, ModArmory.LASER_MINIGUN, ModArmory.LASER_SHOTGUN, ModArmory.LASER_SNIPER, ModArmory.LASER_HEALER,
                        ModArmory.LASER_SPREADER, ModArmory.LASER_RIFLE, ModArmory.LASER_REVOLVER, ModArmory.VILE_SPITTER);
    }
}