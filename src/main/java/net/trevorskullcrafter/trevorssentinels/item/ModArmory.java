package net.trevorskullcrafter.trevorssentinels.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
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

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModArmory {
    public static final Item FLIMSY_GALINITE_SWORD = registerItem("flimsy_galinite_sword",
            new SwordItem(ModToolMaterials.FLIMSY_GALINITE, 1, -2.4f, new FabricItemSettings()));
    public static final Item FLIMSY_GALINITE_DAGGER = registerItem("flimsy_galinite_dagger",
            new DaggerItem(new FabricItemSettings().maxCount(16), 1, 0, 1));
    public static final Item FLIMSY_GALINITE_PICKAXE = registerItem("flimsy_galinite_pickaxe",
            new PickaxeItem(ModToolMaterials.FLIMSY_GALINITE, 1, -2.8f, new FabricItemSettings()));
    public static final Item FLIMSY_GALINITE_AXE = registerItem("flimsy_galinite_axe",
            new AxeItem(ModToolMaterials.FLIMSY_GALINITE, 4, -3.2f, new FabricItemSettings()));
    public static final Item FLIMSY_GALINITE_SHOVEL = registerItem("flimsy_galinite_shovel",
            new ShovelItem(ModToolMaterials.FLIMSY_GALINITE, 1.5f, -3f, new FabricItemSettings()));
    public static final Item FLIMSY_GALINITE_HOE = registerItem("flimsy_galinite_hoe",
            new HoeItem(ModToolMaterials.FLIMSY_GALINITE, 0, -3f, new FabricItemSettings()));
    public static final Item FLIMSY_GALINITE_HELMET = registerItem("flimsy_galinite_helmet",
            new ArmorItem(ModArmorMaterials.FLIMSY_GALINITE, EquipmentSlot.HEAD, new FabricItemSettings()));
    public static final Item FLIMSY_GALINITE_CHESTPLATE = registerItem("flimsy_galinite_chestplate",
            new ArmorItem(ModArmorMaterials.FLIMSY_GALINITE, EquipmentSlot.CHEST, new FabricItemSettings()));
    public static final Item FLIMSY_GALINITE_LEGGINGS = registerItem("flimsy_galinite_leggings",
            new ArmorItem(ModArmorMaterials.FLIMSY_GALINITE, EquipmentSlot.LEGS, new FabricItemSettings()));
    public static final Item FLIMSY_GALINITE_BOOTS = registerItem("flimsy_galinite_boots",
            new ArmorItem(ModArmorMaterials.FLIMSY_GALINITE, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item GALINITE_SWORD = registerItem("galinite_sword",
            new SwordItem(ModToolMaterials.GALINITE, 0, -2.4f, new FabricItemSettings()));
    public static final Item GALINITE_DAGGER = registerItem("galinite_dagger",
            new DaggerItem(new FabricItemSettings().maxCount(16), 2, 0.5f, 2));
    public static final Item GALINITE_PICKAXE = registerItem("galinite_pickaxe",
            new PickaxeItem(ModToolMaterials.GALINITE, 0, -2.8f, new FabricItemSettings()));
    public static final Item GALINITE_CHAINSAW = registerItem("galinite_chainsaw",
            new GaliniteChainsawItem(ModToolMaterials.GALINITE, 3, -3f, new FabricItemSettings()));
    public static final Item GALINITE_SHOVEL = registerItem("galinite_shovel",
            new ShovelItem(ModToolMaterials.GALINITE, 1.5f, -3f, new FabricItemSettings()));
    public static final Item GALINITE_HOE = registerItem("galinite_hoe",
            new HoeItem(ModToolMaterials.GALINITE, 0, -3f, new FabricItemSettings()));
    public static final Item GALINITE_HELMET = registerItem("galinite_helmet",
            new SentinumArmorItem(ModArmorMaterials.GALINITE, EquipmentSlot.HEAD, new FabricItemSettings()));
    public static final Item GALINITE_CHESTPLATE = registerItem("galinite_chestplate",
            new SentinumArmorItem(ModArmorMaterials.GALINITE, EquipmentSlot.CHEST, new FabricItemSettings()));
    public static final Item GALINITE_LEGGINGS = registerItem("galinite_leggings",
            new SentinumArmorItem(ModArmorMaterials.GALINITE, EquipmentSlot.LEGS, new FabricItemSettings()));
    public static final Item GALINITE_BOOTS = registerItem("galinite_boots",
            new SentinumArmorItem(ModArmorMaterials.GALINITE, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword",
            new SwordItem(ModToolMaterials.ROSE_GOLD, 3, -2.4f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_DAGGER = registerItem("rose_gold_dagger",
            new DaggerItem(new FabricItemSettings().maxCount(16), 1, 0, 3));
    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe",
            new PickaxeItem(ModToolMaterials.ROSE_GOLD, 1, -2.8f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_AXE = registerItem("rose_gold_axe",
            new AxeItem(ModToolMaterials.ROSE_GOLD, 3, -3f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel",
            new ShovelItem(ModToolMaterials.ROSE_GOLD, 1.5f, -3f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_HOE = registerItem("rose_gold_hoe",
            new HoeItem(ModToolMaterials.ROSE_GOLD, 0, -3f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_HELMET = registerItem("rose_gold_helmet",
            new ArmorItem(ModArmorMaterials.ROSE_GOLD, EquipmentSlot.HEAD, new FabricItemSettings()));
    public static final Item ROSE_GOLD_CHESTPLATE = registerItem("rose_gold_chestplate",
            new ArmorItem(ModArmorMaterials.ROSE_GOLD, EquipmentSlot.CHEST, new FabricItemSettings()));
    public static final Item ROSE_GOLD_LEGGINGS = registerItem("rose_gold_leggings",
            new ArmorItem(ModArmorMaterials.ROSE_GOLD, EquipmentSlot.LEGS, new FabricItemSettings()));
    public static final Item ROSE_GOLD_BOOTS = registerItem("rose_gold_boots",
            new ArmorItem(ModArmorMaterials.ROSE_GOLD, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item TRIMETAL_SWORD = registerItem("trimetal_sword",
            new SwordItem(ModToolMaterials.TRIMETAL, 3, -2.4f, new FabricItemSettings()));
    public static final Item TRIMETAL_DAGGER = registerItem("trimetal_dagger",
            new DaggerItem(new FabricItemSettings().maxCount(16), 3, 1.5f, 5));
    public static final Item TRIMETAL_PICKAXE = registerItem("trimetal_pickaxe",
            new PickaxeItem(ModToolMaterials.TRIMETAL, 1, 0f, new FabricItemSettings()));
    public static final Item TRIMETAL_AXE = registerItem("trimetal_axe",
            new AxeItem(ModToolMaterials.TRIMETAL, 3, -2.8f, new FabricItemSettings()));
    public static final Item TRIMETAL_SHOVEL = registerItem("trimetal_shovel",
            new ShovelItem(ModToolMaterials.TRIMETAL, 1.5f, -3f, new FabricItemSettings()));
    public static final Item TRIMETAL_HOE = registerItem("trimetal_hoe",
            new HoeItem(ModToolMaterials.TRIMETAL, 0, -3f, new FabricItemSettings()));
    public static final Item TRIMETAL_HELMET = registerItem("trimetal_helmet",
            new ArmorItem(ModArmorMaterials.TRIMETAL, EquipmentSlot.HEAD, new FabricItemSettings()));
    public static final Item TRIMETAL_CHESTPLATE = registerItem("trimetal_chestplate",
            new ArmorItem( ModArmorMaterials.TRIMETAL, EquipmentSlot.CHEST, new FabricItemSettings()));
    public static final Item TRIMETAL_LEGGINGS = registerItem("trimetal_leggings",
            new ArmorItem(ModArmorMaterials.TRIMETAL, EquipmentSlot.LEGS, new FabricItemSettings()));
    public static final Item TRIMETAL_BOOTS = registerItem("trimetal_boots",
            new ArmorItem(ModArmorMaterials.TRIMETAL, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item TRANSITITE_SWORD = registerItem("transitite_sword",
            new SwordItem(ModToolMaterials.TRANSITITE, 3, -2.4f, new FabricItemSettings()));
    public static final Item TRANSITITE_DAGGER = registerItem("transitite_dagger",
            new DaggerItem(new FabricItemSettings().maxCount(16), 4, 2f, 7));
    public static final Item TRANSITITE_PICKAXE = registerItem("transitite_pickaxe",
            new PickaxeItem(ModToolMaterials.TRANSITITE, 0,0f, new FabricItemSettings()));
    public static final Item TRANSITITE_AXE = registerItem("transitite_axe",
            new AxeItem(ModToolMaterials.TRANSITITE, 3, -2.8f, new FabricItemSettings()));
    public static final Item TRANSITITE_SHOVEL = registerItem("transitite_shovel",
            new ShovelItem(ModToolMaterials.TRANSITITE, 1.5f, -3f, new FabricItemSettings()));
    public static final Item TRANSITITE_HOE = registerItem("transitite_hoe",
            new HoeItem(ModToolMaterials.TRANSITITE, 0, -3f, new FabricItemSettings()));
    public static final Item TRANSITITE_HELMET = registerItem("transitite_helmet",
            new ArmorItem(ModArmorMaterials.TRANSITITE, EquipmentSlot.HEAD, new FabricItemSettings()));
    public static final Item TRANSITITE_CHESTPLATE = registerItem("transitite_chestplate",
            new ArmorItem(ModArmorMaterials.TRANSITITE, EquipmentSlot.CHEST, new FabricItemSettings()));
    public static final Item TRANSITITE_LEGGINGS = registerItem("transitite_leggings",
            new ArmorItem(ModArmorMaterials.TRANSITITE, EquipmentSlot.LEGS, new FabricItemSettings()));
    public static final Item TRANSITITE_BOOTS = registerItem("transitite_boots",
            new ArmorItem(ModArmorMaterials.TRANSITITE, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item DARKSTEEL_SWORD = registerItem("darksteel_sword",
            new SwordItem(ModToolMaterials.DARKSTEEL, 3, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_DAGGER = registerItem("darksteel_dagger",
            new DaggerItem(new FabricItemSettings().maxCount(16).fireproof(), 6, 2.5f, 12));
    public static final Item DARKSTEEL_PICKAXE = registerItem("darksteel_pickaxe",
            new PickaxeItem(ModToolMaterials.DARKSTEEL, 0,0f, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_AXE = registerItem("darksteel_axe",
            new AxeItem(ModToolMaterials.DARKSTEEL, 3, -2.8f, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_SHOVEL = registerItem("darksteel_shovel",
            new ShovelItem(ModToolMaterials.DARKSTEEL, 1.5f, -3f, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_HOE = registerItem("darksteel_hoe",
            new HoeItem(ModToolMaterials.DARKSTEEL, 0, -3f, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_HELMET = registerItem("darksteel_helmet",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, EquipmentSlot.HEAD, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_CHESTPLATE = registerItem("darksteel_chestplate",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, EquipmentSlot.CHEST, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_LEGGINGS = registerItem("darksteel_leggings",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, EquipmentSlot.LEGS, new FabricItemSettings().fireproof()));
    public static final Item DARKSTEEL_BOOTS = registerItem("darksteel_boots",
            new ArmorItem(ModArmorMaterials.DARKSTEEL, EquipmentSlot.FEET, new FabricItemSettings().fireproof()));

    public static final Item NUCLEAR_SWORD = registerItem("nuclear_sword",
            new SwordItem(ModToolMaterials.NUCLEAR, 3, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_DAGGER = registerItem("nuclear_dagger",
            new DaggerItem(new FabricItemSettings().maxCount(16).fireproof(), 6, 2.5f, 12,
                    new StatusEffectInstance(ModEffects.IRRADIATED, 100, 1)));
    public static final Item NUCLEAR_PICKAXE = registerItem("nuclear_pickaxe",
            new PickaxeItem(ModToolMaterials.NUCLEAR, 0, 0, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_AXE = registerItem("nuclear_axe",
            new AxeItem(ModToolMaterials.NUCLEAR, 3, -3.1f, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_SHOVEL = registerItem("nuclear_shovel",
            new ShovelItem(ModToolMaterials.NUCLEAR, 1.5f, -3f, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_HOE = registerItem("nuclear_hoe",
            new HoeItem(ModToolMaterials.NUCLEAR, 0, -3f, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_HELMET = registerItem("nuclear_helmet",
            new ArmorItem(ModArmorMaterials.NUCLEAR, EquipmentSlot.HEAD, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_CHESTPLATE = registerItem("nuclear_chestplate",
            new ArmorItem(ModArmorMaterials.NUCLEAR, EquipmentSlot.CHEST, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_LEGGINGS = registerItem("nuclear_leggings",
            new ArmorItem(ModArmorMaterials.NUCLEAR, EquipmentSlot.LEGS, new FabricItemSettings().fireproof()));
    public static final Item NUCLEAR_BOOTS = registerItem("nuclear_boots",
            new ArmorItem(ModArmorMaterials.NUCLEAR, EquipmentSlot.FEET, new FabricItemSettings().fireproof()));

    public static final Item NANOTECH_SWORD = registerItem("nanotech_sword",
            new SwordItem(ModToolMaterials.NANOTECH, 3, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_DAGGER = registerItem("nanotech_dagger",
            new DaggerItem(new FabricItemSettings().maxCount(16).fireproof(), 7, 3f, 12));
    public static final Item NANOTECH_PICKAXE = registerItem("nanotech_pickaxe",
            new PickaxeItem(ModToolMaterials.NUCLEAR, 0, 0, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_AXE = registerItem("nanotech_axe",
            new AxeItem(ModToolMaterials.NUCLEAR, 3, -3.1f, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_SHOVEL = registerItem("nanotech_shovel",
            new ShovelItem(ModToolMaterials.NUCLEAR, 1.5f, -3f, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_HOE = registerItem("nanotech_hoe",
            new HoeItem(ModToolMaterials.NUCLEAR, 0, -3f, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_HELMET = registerItem("nanotech_helmet",
            new ArmorItem(ModArmorMaterials.NANOTECH, EquipmentSlot.HEAD, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_CHESTPLATE = registerItem("nanotech_chestplate",
            new ArmorItem(ModArmorMaterials.NANOTECH, EquipmentSlot.CHEST, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_LEGGINGS = registerItem("nanotech_leggings",
            new ArmorItem(ModArmorMaterials.NANOTECH, EquipmentSlot.LEGS, new FabricItemSettings().fireproof()));
    public static final Item NANOTECH_BOOTS = registerItem("nanotech_boots",
            new ArmorItem(ModArmorMaterials.NANOTECH, EquipmentSlot.FEET, new FabricItemSettings().fireproof()));

    public static final Item ZENITHIUM_SWORD = registerItem("zenithium_sword",
            new SwordItem(ModToolMaterials.ZENITHIUM, 3, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_DAGGER = registerItem("zenithium_dagger",
            new DaggerItem(new FabricItemSettings().maxCount(16).fireproof(), 9, 4f, 100));
    public static final Item ZENITHIUM_PICKAXE = registerItem("zenithium_pickaxe",
            new PickaxeItem(ModToolMaterials.ZENITHIUM, 1, -2.8f, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_AXE = registerItem("zenithium_axe",
            new AxeItem(ModToolMaterials.ZENITHIUM, 6, -3f, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_SHOVEL = registerItem("zenithium_shovel",
            new ShovelItem(ModToolMaterials.ZENITHIUM, 1.5f, -3f, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_HOE = registerItem("zenithium_hoe",
            new HoeItem(ModToolMaterials.ZENITHIUM, 0, -3f, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_CHESTPLATE = registerItem("zenithium_chestplate",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, EquipmentSlot.CHEST, new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_LEGGINGS = registerItem("zenithium_leggings",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, EquipmentSlot.LEGS, new FabricItemSettings().fireproof()));
    public static final Item SKYHOPPERS = registerItem("skyhoppers",
            new ArmorItem(ModArmorMaterials.ZENITHIUM, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item THANATU_SKULL = registerItem("thanatu_skull",
            new ArmorItem(ModArmorMaterials.BONE, EquipmentSlot.HEAD, new FabricItemSettings()));
    public static final Item THANATU_SHOULDERPADS = registerItem("thanatu_shoulderpads",
            new ArmorItem(ModArmorMaterials.BONE, EquipmentSlot.CHEST, new FabricItemSettings()));

    public static final Item SCARA_SHEARS = registerItem("scara_shears",
            new SwordItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new FabricItemSettings().fireproof()));
    public static final Item MASTER_SWORD = registerItem("master_sword",
            new SwordItem(ModToolMaterials.ZENITHIUM, 3, -2.4f, new FabricItemSettings().fireproof()));

    public static final Item LASER_PISTOL = registerItem("laser_pistol", new LaserGunItem(new FabricItemSettings().maxDamage(7), 1, 1.5f,
            4.0f, 1.0f, 0.01f, 20, 4, 9, 50, ModSounds.BLASTER_SHOOT,
            ModSounds.PISTOL_RELOAD, 1, 16711680));

    public static final Item LASER_TASER = registerItem("laser_taser", new LaserGunItem(new FabricItemSettings().maxDamage(5), 1, 2.0f,
            3.0f, 0.5f, 0.01f, 10, 1, 99, 20, ModSounds.BLASTER_SHOOT,
            ModSounds.PISTOL_RELOAD, 1, -1, new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 9)));

    public static final Item LASER_SNIPER_ECHO = registerItem("laser_sniper_echo", new LaserGunItem(new FabricItemSettings().maxDamage(4), 1, 2.0f,
            1.0f, 5.0f, 0.09f,  52, 10, 19, 120, ModSounds.BLASTER_SHOOT,
            ModSounds.SNIPER_RELOAD, 1, 16711680));

    public static final Item LASER_MINIGUN = registerItem("laser_minigun", new LaserGunItem(new FabricItemSettings().maxDamage(65), 2, 2.0f,
            12.0f, 5.0f, 0.04f, 40, 1.5F, 3, 200, ModSounds.BLASTER_SHOOT,
            ModSounds.SHOTGUN_RELOAD, 1, 16711680));

    public static final Item LASER_SHOTGUN = registerItem("laser_shotgun", new LaserGunItem(new FabricItemSettings().maxDamage(5), 6, 2.5f,
            15.0f, 5.0f, 0.035f, 7,12,19, 100, ModSounds.BLASTER_SHOOT,
            ModSounds.SHOTGUN_RELOAD, 1, -1));

    public static final Item LASER_SNIPER = registerItem("laser_sniper", new LaserGunItem(new FabricItemSettings().maxDamage(2), 1, 4.0f,
            0.1f, 20.0f, 0.18f, 96, 20, 19, 200, ModSounds.BLASTER_SHOOT,
            ModSounds.SNIPER_RELOAD, 1, -1));

    public static final Item LASER_HEALER = registerItem("laser_healer", new LaserGunItem(new FabricItemSettings().maxDamage(8), 1, 1.5f,
            2.5f, 2.5f, 0.05f, 16, -1, 39, 150, ModSounds.BLASTER_SHOOT,
            ModSounds.BIO_RELOAD, 1, -1, new StatusEffectInstance(StatusEffects.REGENERATION, 60, 1),
            new StatusEffectInstance(StatusEffects.GLOWING, 60)));

    public static final Item LASER_SPREADER = registerItem("laser_spreader", new LaserGunItem(new FabricItemSettings().maxDamage(13), 8, 0.25f,
            10.0f, 5.0f, 0.05f, 32, 2, 3, 150, SoundEvents.BLOCK_FIRE_EXTINGUISH,
            ModSounds.BIO_RELOAD, 2, -1, new StatusEffectInstance(StatusEffects.WITHER, 100, 1),
            new StatusEffectInstance(StatusEffects.BLINDNESS, 40)));

    public static final Item LASER_RIFLE = registerItem("laser_rifle", new LaserGunItem(new FabricItemSettings().maxDamage(21), 1, 2.0f,
            2.5f, 2.5f, 0.035f, 48, 3, 3, 30, ModSounds.BLASTER_SHOOT,
            ModSounds.SHOTGUN_RELOAD, 1, 16711680));

    public static final Item LASER_REVOLVER = registerItem("laser_revolver", new LaserGunItem(new FabricItemSettings().maxDamage(7), 1, 3.0f,
            15.0f, 5.0f, 0.075f, 48, 12, 3, 90, ModSounds.BLASTER_SHOOT,
            ModSounds.SHOTGUN_RELOAD, 3, 11184810));

    public static final Item VILE_SPITTER = registerItem("vile_spitter", new LaserGunItem(new FabricItemSettings().maxDamage(8), 1, 2.0f,
            4.0f, 2.0f, 0.035f, 48, 8, 11, 60, ModSounds.FLESH_BREAK,
            ModSounds.FLESH_AMBIENT, 3, 13164900, new StatusEffectInstance(ModEffects.INFESTED, 20)));

    private static Item registerItem(String name, Item item){ return Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item); }
    public static void registerArmory(){ trevorssentinels.LOGGER.info("Registering armory... (" + MOD_ID + ")"); }
}