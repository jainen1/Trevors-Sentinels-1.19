package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.BetaItems;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) { super(output, completableFuture); }

    public static final TagKey<Item> NUCLEAR_CHARGE_ACTIVATOR = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "nuclear_charge_activator"));
    public static final TagKey<Item> CROSSBOW_HOLD = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "crossbow_hold"));
    public static final TagKey<Item> ITEM_BAR_COLOR_OVERRIDE = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "item_bar_color_override"));

    public static final TagKey<Item> CERULII_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "cerulii_logs"));
    public static final TagKey<Item> CHARRED_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "charred_logs"));
    public static final TagKey<Item> MIDAS_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "midas_logs"));
    public static final TagKey<Item> VIRIDESCENT_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "viridescent_logs"));
    public static final TagKey<Item> YGGDRASIL_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(trevorssentinels.MOD_ID, "yggdrasil_logs"));

    public static final TagKey<EntityType<?>> MILKABLES = TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "milkables"));

    @Override protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(NUCLEAR_CHARGE_ACTIVATOR).add(ModItems.NUCLEAR_DETONATOR);
        getOrCreateTagBuilder(CROSSBOW_HOLD)
                .add(ModArmory.LASER_PISTOL, ModArmory.LASER_TASER, ModArmory.LASER_SNIPER_ECHO, ModArmory.LASER_MINIGUN, ModArmory.LASER_SHOTGUN, ModArmory.LASER_SNIPER,
                        ModArmory.LASER_HEALER, ModArmory.LASER_SPREADER, ModArmory.LASER_RIFLE, ModArmory.LASER_REVOLVER, ModArmory.VILE_SPITTER);
        getOrCreateTagBuilder(ITEM_BAR_COLOR_OVERRIDE)
                .add(ModArmory.NUCLEAR_SWORD, ModArmory.NUCLEAR_PICKAXE, ModArmory.NUCLEAR_AXE, ModArmory.NUCLEAR_SHOVEL, ModArmory.NUCLEAR_HOE, ModArmory.NUCLEAR_HELMET,
                        ModArmory.NUCLEAR_CHESTPLATE, ModArmory.NUCLEAR_LEGGINGS, ModArmory.NUCLEAR_BOOTS, ModArmory.NANOTECH_SWORD, ModArmory.NANOTECH_PICKAXE,
                        ModArmory.NANOTECH_AXE, ModArmory.NANOTECH_SHOVEL, ModArmory.NANOTECH_HOE, ModArmory.NANOTECH_HELMET, ModArmory.NANOTECH_CHESTPLATE,
                        ModArmory.NANOTECH_LEGGINGS, ModArmory.NANOTECH_BOOTS, ModArmory.ZENITHIUM_SWORD, ModArmory.ZENITHIUM_PICKAXE, ModArmory.ZENITHIUM_AXE,
                        ModArmory.ZENITHIUM_SHOVEL, ModArmory.ZENITHIUM_HOE, ModArmory.ZENITHIUM_CHESTPLATE, ModArmory.ZENITHIUM_LEGGINGS, ModArmory.ZENITHIUM_BOOTS,
                        BetaItems.DEMONIC_CORE, BetaItems.THANATU_BLADE, ModItems.HARD_LIGHT_PROJECTOR, ModItems.CAUTION_HARD_LIGHT_PROJECTOR, ModItems.SENTINEL_HARD_LIGHT_PROJECTOR,
                        ModArmory.LASER_PISTOL, ModArmory.LASER_TASER, ModArmory.LASER_SNIPER_ECHO, ModArmory.LASER_MINIGUN, ModArmory.LASER_SHOTGUN, ModArmory.LASER_SNIPER,
                        ModArmory.LASER_HEALER, ModArmory.LASER_SPREADER, ModArmory.LASER_RIFLE, ModArmory.LASER_REVOLVER, ModArmory.VILE_SPITTER);

        getOrCreateTagBuilder(CERULII_LOGS).add(ModBlocks.CERULII_LOG.asItem(), ModBlocks.CERULII_WOOD.asItem(), ModBlocks.STRIPPED_CERULII_LOG.asItem(), ModBlocks.STRIPPED_CERULII_WOOD.asItem());
        getOrCreateTagBuilder(CHARRED_LOGS).add(ModBlocks.CHARRED_LOG.asItem(), ModBlocks.CHARRED_WOOD.asItem(), ModBlocks.STRIPPED_CHARRED_LOG.asItem(), ModBlocks.STRIPPED_CHARRED_WOOD.asItem());
        getOrCreateTagBuilder(MIDAS_LOGS).add(ModBlocks.MIDAS_LOG.asItem(), ModBlocks.MIDAS_WOOD.asItem(), ModBlocks.STRIPPED_MIDAS_LOG.asItem(), ModBlocks.STRIPPED_MIDAS_WOOD.asItem());
        getOrCreateTagBuilder(VIRIDESCENT_LOGS)
                .add(ModBlocks.VIRIDESCENT_LOG.asItem(), ModBlocks.VIRIDESCENT_WOOD.asItem(), ModBlocks.STRIPPED_VIRIDESCENT_LOG.asItem(), ModBlocks.STRIPPED_VIRIDESCENT_WOOD.asItem());
        getOrCreateTagBuilder(YGGDRASIL_LOGS)
                .add(ModBlocks.YGGDRASIL_LOG.asItem(), ModBlocks.YGGDRASIL_WOOD.asItem(), ModBlocks.STRIPPED_YGGDRASIL_LOG.asItem(), ModBlocks.STRIPPED_YGGDRASIL_WOOD.asItem());
    }
}