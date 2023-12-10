package net.trevorskullcrafter.trevorssentinels.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.item.custom.*;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.*;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;

import java.awt.*;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModArmory {
    public static final Item GALLIUM_HELMET = registerItem("gallium_helmet",
            new ArmorItem(ModArmorMaterials.GALLIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item GALLIUM_CHESTPLATE = registerItem("gallium_chestplate",
            new ArmorItem(ModArmorMaterials.GALLIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GALLIUM_LEGGINGS = registerItem("gallium_leggings",
            new ArmorItem(ModArmorMaterials.GALLIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item GALLIUM_BOOTS = registerItem("gallium_boots",
            new ArmorItem(ModArmorMaterials.GALLIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item GALLIUM_SWORD = registerItem("gallium_sword",
            new SwordItem(ModToolMaterials.GALLIUM, 1, -2.4f, new FabricItemSettings()));
    public static final Item GALLIUM_DAGGER = registerItem("gallium_dagger",
            new DaggerItem(ModToolMaterials.GALLIUM, 1, 0, 0.9f, new FabricItemSettings().maxCount(16)));
    public static final Item GALLIUM_PICKAXE = registerItem("gallium_pickaxe",
            new PickaxeItem(ModToolMaterials.GALLIUM, 1, -2.8f, new FabricItemSettings()));
    public static final Item GALLIUM_AXE = registerItem("gallium_axe",
            new AxeItem(ModToolMaterials.GALLIUM, 4, -3.2f, new FabricItemSettings()));
    public static final Item GALLIUM_SHOVEL = registerItem("gallium_shovel",
            new ShovelItem(ModToolMaterials.GALLIUM, 1.5f, -3f, new FabricItemSettings()));
    public static final Item GALLIUM_HOE = registerItem("gallium_hoe",
            new HoeItem(ModToolMaterials.GALLIUM, 0, -3f, new FabricItemSettings()));
    public static final Item GALLIUM_CHAINSAW = registerItem("gallium_chainsaw",
            new GaliniteChainsawItem(ModToolMaterials.GALLIUM, 3, -3f, new FabricItemSettings()));

    public static final Item SCRAP_HELMET = registerItem("scrap_helmet",
            new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SCRAP_CHESTPLATE = registerItem("scrap_chestplate",
            new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SCRAP_LEGGINGS = registerItem("scrap_leggings",
            new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SCRAP_BOOTS = registerItem("scrap_boots",
            new ArmorItem(ModArmorMaterials.SCRAP, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SCRAP_SWORD = registerItem("scrap_sword",
            new SwordItem(ModToolMaterials.SCRAP, 1, -2.4f, new FabricItemSettings()));
    public static final Item SCRAP_DAGGER = registerItem("scrap_dagger",
            new DaggerItem(ModToolMaterials.SCRAP, 1, 0, 0.9f, new FabricItemSettings().maxCount(16)));
    public static final Item SCRAP_PICKAXE = registerItem("scrap_pickaxe",
            new PickaxeItem(ModToolMaterials.SCRAP, 1, -2.8f, new FabricItemSettings()));
    public static final Item SCRAP_AXE = registerItem("scrap_axe",
            new AxeItem(ModToolMaterials.SCRAP, 4, -3.2f, new FabricItemSettings()));
    public static final Item SCRAP_SHOVEL = registerItem("scrap_shovel",
            new ShovelItem(ModToolMaterials.SCRAP, 1.5f, -3f, new FabricItemSettings()));
    public static final Item SCRAP_HOE = registerItem("scrap_hoe",
            new HoeItem(ModToolMaterials.SCRAP, 0, -3f, new FabricItemSettings()));
    public static final Item SCRAP_CHAINSAW = registerItem("scrap_chainsaw",
            new GaliniteChainsawItem(ModToolMaterials.SCRAP, 3, -3f, new FabricItemSettings()));

    public static final Item SPACEFARERS_HELMET = registerItem("spacefarers_helmet",
            new SentinumArmorItem(ModArmorMaterials.GUNMETAL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SPACEFARERS_CHESTPLATE = registerItem("spacefarers_chestplate",
            new SentinumArmorItem(ModArmorMaterials.GUNMETAL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SPACEFARERS_LEGGINGS = registerItem("spacefarers_leggings",
            new SentinumArmorItem(ModArmorMaterials.GUNMETAL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SPACEFARERS_BOOTS = registerItem("spacefarers_boots",
            new SentinumArmorItem(ModArmorMaterials.GUNMETAL, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SPACEFARERS_SWORD = registerItem("spacefarers_sword",
            new SwordItem(ModToolMaterials.GUNMETAL, 0, -2.4f, new FabricItemSettings()));
    public static final Item SPACEFARERS_DAGGER = registerItem("spacefarers_dagger",
            new DaggerItem(ModToolMaterials.GUNMETAL, 2, 0.5f, 0.3f, new FabricItemSettings().maxCount(16)));
    public static final Item SPACEFARERS_PICKAXE = registerItem("spacefarers_pickaxe",
            new PickaxeItem(ModToolMaterials.GUNMETAL, 0, -2.8f, new FabricItemSettings()));
    public static final Item SPACEFARERS_AXE = registerItem("spacefarers_axe",
            new AxeItem(ModToolMaterials.GUNMETAL, 3, -3f, new FabricItemSettings()));
    public static final Item SPACEFARERS_SHOVEL = registerItem("spacefarers_shovel",
            new ShovelItem(ModToolMaterials.GUNMETAL, 1.5f, -3f, new FabricItemSettings()));
    public static final Item SPACEFARERS_HOE = registerItem("spacefarers_hoe",
            new HoeItem(ModToolMaterials.GUNMETAL, 0, -3f, new FabricItemSettings()));

    public static final Item ROSE_GOLD_HELMET = registerItem("rose_gold_helmet",
            new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ROSE_GOLD_CHESTPLATE = registerItem("rose_gold_chestplate",
            new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ROSE_GOLD_LEGGINGS = registerItem("rose_gold_leggings",
            new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ROSE_GOLD_BOOTS = registerItem("rose_gold_boots",
            new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword",
            new SwordItem(ModToolMaterials.ROSE_GOLD, 3, -2.4f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_DAGGER = registerItem("rose_gold_dagger",
            new DaggerItem(ModToolMaterials.ROSE_GOLD, 1, 0, 0.85f, new FabricItemSettings().maxCount(16)));
    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe",
            new PickaxeItem(ModToolMaterials.ROSE_GOLD, 1, -2.8f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_AXE = registerItem("rose_gold_axe",
            new AxeItem(ModToolMaterials.ROSE_GOLD, 3, -3f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel",
            new ShovelItem(ModToolMaterials.ROSE_GOLD, 1.5f, -3f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_HOE = registerItem("rose_gold_hoe",
            new HoeItem(ModToolMaterials.ROSE_GOLD, 0, -3f, new FabricItemSettings()));

    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new ArmorItem( ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, 3, -2.4f, new FabricItemSettings()));
    public static final Item COPPER_DAGGER = registerItem("copper_dagger",
            new DaggerItem(ModToolMaterials.COPPER, 3, 1.5f, 0.6f, new FabricItemSettings().maxCount(16)));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterials.COPPER, 1, 0f, new FabricItemSettings()));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterials.COPPER, 3, -2.8f, new FabricItemSettings()));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, 1.5f, -3f, new FabricItemSettings()));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterials.COPPER, 0, -3f, new FabricItemSettings()));

    public static final Item TRIMETAL_HELMET = registerItem("trimetal_helmet",
            new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TRIMETAL_CHESTPLATE = registerItem("trimetal_chestplate",
            new ArmorItem( ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TRIMETAL_LEGGINGS = registerItem("trimetal_leggings",
            new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TRIMETAL_BOOTS = registerItem("trimetal_boots",
            new ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item TRIMETAL_SWORD = registerItem("trimetal_sword",
            new SwordItem(ModToolMaterials.STEEL, 3, -2.4f, new FabricItemSettings()));
    public static final Item TRIMETAL_DAGGER = registerItem("trimetal_dagger",
            new DaggerItem(ModToolMaterials.STEEL, 3, 1.5f, 0.5f, new FabricItemSettings().maxCount(16)));
    public static final Item TRIMETAL_PICKAXE = registerItem("trimetal_pickaxe",
            new PickaxeItem(ModToolMaterials.STEEL, 1, 0f, new FabricItemSettings()));
    public static final Item TRIMETAL_AXE = registerItem("trimetal_axe",
            new AxeItem(ModToolMaterials.STEEL, 3, -2.8f, new FabricItemSettings()));
    public static final Item TRIMETAL_SHOVEL = registerItem("trimetal_shovel",
            new ShovelItem(ModToolMaterials.STEEL, 1.5f, -3f, new FabricItemSettings()));
    public static final Item TRIMETAL_HOE = registerItem("trimetal_hoe",
            new HoeItem(ModToolMaterials.STEEL, 0, -3f, new FabricItemSettings()));

    public static final Item IMPERIAL_HELMET = registerItem("imperial_helmet",
            new ArmorItem(ModArmorMaterials.ALLOY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IMPERIAL_CHESTPLATE = registerItem("imperial_chestplate",
            new ArmorItem(ModArmorMaterials.ALLOY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item IMPERIAL_LEGGINGS = registerItem("imperial_leggings",
            new ArmorItem(ModArmorMaterials.ALLOY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item IMPERIAL_BOOTS = registerItem("imperial_boots",
            new ArmorItem(ModArmorMaterials.ALLOY, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item IMPERIAL_SWORD = registerItem("imperial_sword",
            new SwordItem(ModToolMaterials.IMPERIAL_ALLOY, 3, -2.4f, new FabricItemSettings()));
    public static final Item IMPERIAL_DAGGER = registerItem("imperial_dagger",
            new DaggerItem(ModToolMaterials.IMPERIAL_ALLOY, 4, 2f, 0.35f, new FabricItemSettings().maxCount(16)));
    public static final Item IMPERIAL_PICKAXE = registerItem("imperial_pickaxe",
            new PickaxeItem(ModToolMaterials.IMPERIAL_ALLOY, 0,0f, new FabricItemSettings()));
    public static final Item IMPERIAL_AXE = registerItem("imperial_axe",
            new AxeItem(ModToolMaterials.IMPERIAL_ALLOY, 3, -2.8f, new FabricItemSettings()));
    public static final Item IMPERIAL_SHOVEL = registerItem("imperial_shovel",
            new ShovelItem(ModToolMaterials.IMPERIAL_ALLOY, 1.5f, -3f, new FabricItemSettings()));
    public static final Item IMPERIAL_HOE = registerItem("imperial_hoe",
            new HoeItem(ModToolMaterials.IMPERIAL_ALLOY, 0, -3f, new FabricItemSettings()));

    public static final Item TRANSITITE_HELMET = registerItem("transitite_helmet",
            new ArmorItem(ModArmorMaterials.TRANSITITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TRANSITITE_CHESTPLATE = registerItem("transitite_chestplate",
            new ArmorItem(ModArmorMaterials.TRANSITITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TRANSITITE_LEGGINGS = registerItem("transitite_leggings",
            new ArmorItem(ModArmorMaterials.TRANSITITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TRANSITITE_BOOTS = registerItem("transitite_boots",
            new ArmorItem(ModArmorMaterials.TRANSITITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item TRANSITITE_SWORD = registerItem("transitite_sword",
            new SwordItem(ModToolMaterials.TRANSITITE, 3, -2.4f, new FabricItemSettings()));
    public static final Item TRANSITITE_DAGGER = registerItem("transitite_dagger",
            new DaggerItem(ModToolMaterials.TRANSITITE, 4, 2f, 0.25f, new FabricItemSettings().maxCount(16)));
    public static final Item TRANSITITE_PICKAXE = registerItem("transitite_pickaxe",
            new PickaxeItem(ModToolMaterials.TRANSITITE, 0,0f, new FabricItemSettings()));
    public static final Item TRANSITITE_AXE = registerItem("transitite_axe",
            new AxeItem(ModToolMaterials.TRANSITITE, 3, -2.8f, new FabricItemSettings()));
    public static final Item TRANSITITE_SHOVEL = registerItem("transitite_shovel",
            new ShovelItem(ModToolMaterials.TRANSITITE, 1.5f, -3f, new FabricItemSettings()));
    public static final Item TRANSITITE_HOE = registerItem("transitite_hoe",
            new HoeItem(ModToolMaterials.TRANSITITE, 0, -3f, new FabricItemSettings()));

    public static final Item DARKSTEEL_HELMET = registerItem("darksteel_helmet",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_CHESTPLATE = registerItem("darksteel_chestplate",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_LEGGINGS = registerItem("darksteel_leggings",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_BOOTS = registerItem("darksteel_boots",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_SWORD = registerItem("darksteel_sword",
            new SwordItem(ModToolMaterials.DARKSTEEL, 3, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_DAGGER = registerItem("darksteel_dagger",
            new DaggerItem(ModToolMaterials.DARKSTEEL, 6, 2.5f, 0.15f, new FabricItemSettings().maxCount(16).fireproof()));
    public static final Item DARKSTEEL_PICKAXE = registerItem("darksteel_pickaxe",
            new PickaxeItem(ModToolMaterials.DARKSTEEL, 0,0f, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_AXE = registerItem("darksteel_axe",
            new AxeItem(ModToolMaterials.DARKSTEEL, 3, -2.8f, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_SHOVEL = registerItem("darksteel_shovel",
            new ShovelItem(ModToolMaterials.DARKSTEEL, 1.5f, -3f, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_HOE = registerItem("darksteel_hoe",
            new HoeItem(ModToolMaterials.DARKSTEEL, 0, -3f, new FabricItemSettings().fireproof()));

    public static final Item NUCLEAR_HELMET = registerItem("nuclear_helmet",
            new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_CHESTPLATE = registerItem("nuclear_chestplate",
            new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_LEGGINGS = registerItem("nuclear_leggings",
            new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_BOOTS = registerItem("nuclear_boots",
            new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_SWORD = registerItem("nuclear_sword",
            new SwordItem(ModToolMaterials.NUCLEAR, 3, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_DAGGER = registerItem("nuclear_dagger",
        new DaggerItem(ModToolMaterials.NUCLEAR, 1, 2.5f, 0.15f, new FabricItemSettings().maxCount(16).fireproof(),
                new StatusEffectInstance(ModEffects.IRRADIATED, 100, 1)));
    public static final Item NUCLEAR_PICKAXE = registerItem("nuclear_pickaxe",
            new PickaxeItem(ModToolMaterials.NUCLEAR, 0, 0, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_AXE = registerItem("nuclear_axe",
            new AxeItem(ModToolMaterials.NUCLEAR, 3, -3.1f, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_SHOVEL = registerItem("nuclear_shovel",
            new ShovelItem(ModToolMaterials.NUCLEAR, 1.5f, -3f, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_HOE = registerItem("nuclear_hoe",
            new HoeItem(ModToolMaterials.NUCLEAR, 0, -3f, new FabricItemSettings().fireproof()));

    public static final Item NANOTECH_HELMET = registerItem("nanotech_helmet",
            new ArmorItem(ModArmorMaterials.JETBLACK, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_CHESTPLATE = registerItem("nanotech_chestplate",
            new ArmorItem(ModArmorMaterials.JETBLACK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_LEGGINGS = registerItem("nanotech_leggings",
            new ArmorItem(ModArmorMaterials.JETBLACK, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_BOOTS = registerItem("nanotech_boots",
            new ArmorItem(ModArmorMaterials.JETBLACK, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_SWORD = registerItem("nanotech_sword",
            new SwordItem(ModToolMaterials.JETBLACK, 3, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_DAGGER = registerItem("nanotech_dagger",
            new DaggerItem(ModToolMaterials.JETBLACK, 1, 3f, 0.15f, new FabricItemSettings().maxCount(16).fireproof()));
    public static final Item NANOTECH_PICKAXE = registerItem("nanotech_pickaxe",
            new PickaxeItem(ModToolMaterials.JETBLACK, 0, 0, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_AXE = registerItem("nanotech_axe",
            new AxeItem(ModToolMaterials.JETBLACK, 3, -3.1f, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_SHOVEL = registerItem("nanotech_shovel",
            new ShovelItem(ModToolMaterials.JETBLACK, 1.5f, -3f, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_HOE = registerItem("nanotech_hoe",
            new HoeItem(ModToolMaterials.JETBLACK, 0, -3f, new FabricItemSettings().fireproof()));

    public static final Item ZENITHIUM_HELMET = registerItem("zenithium_helmet",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_CHESTPLATE = registerItem("zenithium_chestplate",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_LEGGINGS = registerItem("zenithium_leggings",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_BOOTS = registerItem("zenithium_boots",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item ZENITHIUM_SWORD = registerItem("zenithium_sword",
            new SwordItem(ModToolMaterials.ZENITHIUM, 3, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_DAGGER = registerItem("zenithium_dagger",
            new DaggerItem(ModToolMaterials.ZENITHIUM, 1, 4f, 0, new FabricItemSettings().maxCount(16).fireproof()));
    public static final Item ZENITHIUM_PICKAXE = registerItem("zenithium_pickaxe",
            new PickaxeItem(ModToolMaterials.ZENITHIUM, 1, -2.8f, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_AXE = registerItem("zenithium_axe",
            new AxeItem(ModToolMaterials.ZENITHIUM, 6, -3f, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_SHOVEL = registerItem("zenithium_shovel",
            new ShovelItem(ModToolMaterials.ZENITHIUM, 1.5f, -3f, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_HOE = registerItem("zenithium_hoe",
            new HoeItem(ModToolMaterials.ZENITHIUM, 0, -3f, new FabricItemSettings().fireproof()));

    public static final Item THANATU_SKULL = registerItem("thanatu_skull",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item THANATU_SHOULDERPADS = registerItem("thanatu_shoulderpads",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item SCARA_SHEARS = registerItem("scara_shears",
            new SwordItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new FabricItemSettings().fireproof()));
    public static final Item MASTER_SWORD = registerItem("master_sword",
            new SwordItem(ModToolMaterials.ZENITHIUM, 3, -2.4f, new FabricItemSettings().fireproof()));

    public static final Item LASER_PISTOL = registerItem("laser_pistol", new GunItem(new FabricItemSettings().maxDamage(7), 1, 1.5f,
            4.0f, 1.0f, 0.01f, 10, 50, ModSounds.BLASTER_SHOOT, ModSounds.PISTOL_RELOAD,
            20, 4, 1, TextUtil.BLOOD_RED));

    public static final Item LASER_TASER = registerItem("laser_taser", new GunItem(new FabricItemSettings().maxDamage(5), 1, 2.0f,
            3.0f, 0.5f, 0.01f, 100, 20, ModSounds.BLASTER_SHOOT, ModSounds.PISTOL_RELOAD,
            10, 1, 3, TextUtil.BLOOD_RED, new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 9)));

    public static final Item LASER_SNIPER_ECHO = registerItem("laser_sniper_echo", new GunItem(new FabricItemSettings().maxDamage(4), 1, 2.0f,
            1.0f, 5.0f, 0.09f,  20, 120, ModSounds.BLASTER_SHOOT, ModSounds.SNIPER_RELOAD,
            52,  10, 1, TextUtil.BLOOD_RED));

    public static final Item LASER_MINIGUN = registerItem("laser_minigun", new GunItem(new FabricItemSettings().maxDamage(65), 2, 2.0f,
            12.0f, 5.0f, 0.04f, 3, 200, ModSounds.BLASTER_SHOOT, ModSounds.SHOTGUN_RELOAD,
            40,  2, 1, TextUtil.BLOOD_RED));

    public static final Item LASER_SHOTGUN = registerItem("laser_shotgun", new GunItem(new FabricItemSettings().maxDamage(5), 6, 2.5f,
            15.0f, 5.0f, 0.035f, 20, 100, ModSounds.BLASTER_SHOOT, ModSounds.SHOTGUN_RELOAD,
            7, 12, 1, TextUtil.BLOOD_RED));

    public static final Item LASER_SNIPER = registerItem("laser_sniper", new GunItem(new FabricItemSettings().maxDamage(2), 1, 4.0f,
            0.1f, 20.0f, 0.18f, 19, 200, ModSounds.BLASTER_SHOOT, ModSounds.SNIPER_RELOAD,
            96, 20, 1, TextUtil.BLOOD_RED));

    public static final Item LASER_HEALER = registerItem("laser_healer", new GunItem(new FabricItemSettings().maxDamage(8), 1, 1.5f,
            2.5f, 2.5f, 0.05f, 40, 150, ModSounds.BLASTER_SHOOT, ModSounds.BIO_RELOAD,
            16, -1, 2, TextUtil.BLOOD_RED,
            new StatusEffectInstance(StatusEffects.REGENERATION, 60, 1), new StatusEffectInstance(StatusEffects.GLOWING, 60)));

    public static final Item LASER_SPREADER = registerItem("laser_spreader", new GunItem(new FabricItemSettings().maxDamage(13), 1, 0.25f,
            10.0f, 5.0f, 0.05f, 3, 150, SoundEvents.BLOCK_FIRE_EXTINGUISH, ModSounds.BIO_RELOAD,
            32, 2, 2, TextUtil.NUCLEAR,
            new StatusEffectInstance(StatusEffects.WITHER, 100, 1), new StatusEffectInstance(StatusEffects.BLINDNESS, 40)));

    public static final Item LASER_RIFLE = registerItem("laser_rifle", new GunItem(new FabricItemSettings().maxDamage(21), 1, 2.0f,
            2.5f, 2.5f, 0.035f, 3, 30, ModSounds.BLASTER_SHOOT, ModSounds.SHOTGUN_RELOAD,
            48, 3, 1, TextUtil.BLOOD_RED));

    public static final Item LASER_REVOLVER = registerItem("laser_revolver", new GunItem(new FabricItemSettings().maxDamage(7), 1, 3.0f,
            15.0f, 5.0f, 0.075f, 3, 90, ModSounds.BLASTER_SHOOT, ModSounds.SHOTGUN_RELOAD,
            48, 12, 3, Color.decode("11184810")));

    public static final Item VILE_SPITTER = registerItem("vile_spitter", new GunItem(new FabricItemSettings().maxDamage(8), 1, 2.0f,
            4.0f, 2.0f, 0.035f, 11, 60, ModSounds.FLESH_BREAK, ModSounds.FLESH_AMBIENT,
            48, 8, 3, TextUtil.FLESH_PUS, new StatusEffectInstance(ModEffects.INFESTED, 20)));

    private static Item registerItem(String name, Item item){ return Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item); }
    public static void registerArmory(){ trevorssentinels.LOGGER.info("Registering armory... (" + MOD_ID + ")"); }
}