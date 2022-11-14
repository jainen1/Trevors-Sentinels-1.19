package net.trevorskullcrafter.trevorssentinels.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.trevorskullcrafter.trevorssentinels.item.custom.*;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModArmory {

    public static final Item FLIMSY_SENTINUM_SHIV = registerItem("flimsy_sentinum_shiv",
            new SwordItem(ModToolMaterials.FLIMSY_SENTINUM, 0, -1f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item FLIMSY_SENTINUM_PICKAXE = registerItem("flimsy_sentinum_pickaxe",
            new ModPickaxeItem(ModToolMaterials.FLIMSY_SENTINUM, 1, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY).maxCount(1)));

    public static final Item FLIMSY_SENTINUM_HATCHET = registerItem("flimsy_sentinum_hatchet",
            new ModAxeItem(ModToolMaterials.FLIMSY_SENTINUM, 4, -3.2f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY).maxCount(1)));

    public static final Item FLIMSY_SENTINUM_SPADE = registerItem("flimsy_sentinum_spade",
            new ShovelItem(ModToolMaterials.FLIMSY_SENTINUM, 1.5f, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY).maxCount(1)));

    public static final Item FLIMSY_SENTINUM_SCYTHE = registerItem("flimsy_sentinum_scythe",
            new ModHoeItem(ModToolMaterials.FLIMSY_SENTINUM, 0, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY).maxCount(1)));

    public static final Item FLIMSY_SENTINUM_HAT = registerItem("flimsy_sentinum_hat",
            new ModArmorItem(ModArmorMaterials.FLIMSY_SENTINUM, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item FLIMSY_SENTINUM_CHESTPLATE = registerItem("flimsy_sentinum_chestplate",
            new ModArmorItem(ModArmorMaterials.FLIMSY_SENTINUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item FLIMSY_SENTINUM_LOINCLOTH = registerItem("flimsy_sentinum_loincloth",
            new ModArmorItem(ModArmorMaterials.FLIMSY_SENTINUM, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item FLIMSY_SENTINUM_SABATONS = registerItem("flimsy_sentinum_sabatons",
            new ModArmorItem(ModArmorMaterials.FLIMSY_SENTINUM, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item SENTINUM_DIRK = registerItem("sentinum_dirk",
            new SwordItem(ModToolMaterials.SENTINUM, 0, -1f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item SENTINUM_PICKAXE = registerItem("sentinum_pickaxe",
            new ModPickaxeItem(ModToolMaterials.SENTINUM, 0, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item SENTINUM_CHAINSAW = registerItem("sentinum_chainsaw",
            new SentinumChainsawItem(ModToolMaterials.SENTINUM, 3, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item SENTINUM_SPADE = registerItem("sentinum_spade",
            new ShovelItem(ModToolMaterials.SENTINUM, 1.5f, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY).maxCount(1)));

    public static final Item SENTINUM_SCYTHE = registerItem("sentinum_scythe",
            new ModHoeItem(ModToolMaterials.SENTINUM, 0, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY).maxCount(1)));

    public static final Item SENTINUM_VISOR = registerItem("sentinum_visor",
            new SentinumArmorItem(ModArmorMaterials.SENTINUM, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item SENTINUM_CUIRASS = registerItem("sentinum_cuirass",
            new SentinumArmorItem(ModArmorMaterials.SENTINUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item SENTINUM_KILT = registerItem("sentinum_kilt",
            new SentinumArmorItem(ModArmorMaterials.SENTINUM, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item SENTINUM_SABATONS = registerItem("sentinum_sabatons",
            new SentinumArmorItem(ModArmorMaterials.SENTINUM, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ROSE_GOLD_DAGGER = registerItem("rose_gold_dagger",
            new SwordItem(ModToolMaterials.ROSE_GOLD, 1, -1f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe",
            new ModPickaxeItem(ModToolMaterials.ROSE_GOLD, 1, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ROSE_GOLD_BATTLEAXE = registerItem("rose_gold_battleaxe",
            new ModAxeItem(ModToolMaterials.ROSE_GOLD, 3, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ROSE_GOLD_SPADE = registerItem("rose_gold_spade",
            new ShovelItem(ModToolMaterials.ROSE_GOLD, 1.5f, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ROSE_GOLD_SCYTHE = registerItem("rose_gold_scythe",
            new ModHoeItem(ModToolMaterials.ROSE_GOLD, 0, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ROSE_GOLD_HELM = registerItem("rose_gold_helm",
            new ModArmorItem(ModArmorMaterials.ROSE_GOLD, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ROSE_GOLD_CUIRASS = registerItem("rose_gold_cuirass",
            new ModArmorItem(ModArmorMaterials.ROSE_GOLD, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ROSE_GOLD_LEGGINGS = registerItem("rose_gold_leggings",
            new ModArmorItem(ModArmorMaterials.ROSE_GOLD, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ROSE_GOLD_SABATONS = registerItem("rose_gold_sabatons",
            new ModArmorItem(ModArmorMaterials.ROSE_GOLD, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item TRIMETAL_TWINBLADE = registerItem("trimetal_twinblade",
            new SwordItem(ModToolMaterials.TRIMETAL, 3, -2f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item TRIMETAL_DRILL = registerItem("trimetal_drill",
            new ModPickaxeItem(ModToolMaterials.TRIMETAL, 1, 0f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item TRIMETAL_CLEAVER = registerItem("trimetal_cleaver",
            new ModAxeItem(ModToolMaterials.TRIMETAL, 3, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item TRIMETAL_SHOVEL = registerItem("trimetal_shovel",
            new ShovelItem(ModToolMaterials.TRIMETAL, 1.5f, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item TRIMETAL_HOE = registerItem("trimetal_hoe",
            new ModHoeItem(ModToolMaterials.TRIMETAL, 0, -3f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item TRIMETAL_HELMET = registerItem("trimetal_helmet",
            new ModArmorItem(ModArmorMaterials.TRIMETAL, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item TRIMETAL_HARNESS = registerItem("trimetal_harness",
            new ModArmorItem(ModArmorMaterials.TRIMETAL, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item TRIMETAL_LEG_GUARDS = registerItem("trimetal_leg_guards",
            new ModArmorItem(ModArmorMaterials.TRIMETAL, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item TRIMETAL_BOOTS = registerItem("trimetal_boots",
            new ModArmorItem(ModArmorMaterials.TRIMETAL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item HUNTERS_VIBROBLADE = registerItem("hunters_vibroblade",
            new SwordItem(ModToolMaterials.DARKSTEEL, -3, -1f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item HUNTERS_DRILL = registerItem("hunters_drill",
            new ModPickaxeItem(ModToolMaterials.DARKSTEEL, 0,0f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item HUNTERS_CHAINSAW = registerItem("hunters_chainsaw",
            new SentinumChainsawItem(ModToolMaterials.DARKSTEEL, 3, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item HUNTERS_PISTOL = registerItem("hunters_pistol",
            new CrossbowItem(new FabricItemSettings().maxDamage(465).group(ModItemGroup.ARMORY)));

    public static final Item HUNTERS_SHIELD = registerItem("hunters_shield",
            new ShieldItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.ARMORY)));

    public static final Item HUNTERS_VISOR = registerItem("hunters_visor",
            new ModArmorItem(ModArmorMaterials.DARKSTEEL, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item HUNTERS_TORSO = registerItem("hunters_torso",
            new ModArmorItem(ModArmorMaterials.DARKSTEEL, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item HUNTERS_LEGS = registerItem("hunters_legs",
            new ModArmorItem(ModArmorMaterials.DARKSTEEL, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item HUNTERS_BOOTS = registerItem("hunters_boots",
            new ModArmorItem(ModArmorMaterials.DARKSTEEL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item CRYSTAL_DAGGER = registerItem("crystal_dagger",
            new SwordItem(ModToolMaterials.URANIUM, -3, -1f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item NUCLEAR_DRILL = registerItem("nuclear_drill",
            new ModPickaxeItem(ModToolMaterials.URANIUM, 0, 0,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item NUCLEAR_AXE = registerItem("nuclear_axe",
            new ModAxeItem(ModToolMaterials.URANIUM, 3, -3.1f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item NUCLEAR_SHOVEL = registerItem("nuclear_shovel",
            new ShovelItem(ModToolMaterials.URANIUM, 1.5f, -3f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item NUCLEAR_SCYTHE = registerItem("nuclear_scythe",
            new ModHoeItem(ModToolMaterials.URANIUM, 0, -3f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item HARDENED_N7_VISOR = registerItem("hardened_n7_visor",
            new ModArmorItem(ModArmorMaterials.URANIUM, EquipmentSlot.HEAD,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item HARDENED_N7_CUIRASS = registerItem("hardened_n7_cuirass",
            new ModArmorItem(ModArmorMaterials.URANIUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item HARDENED_N7_LEGGINGS = registerItem("hardened_n7_leggings",
            new ModArmorItem(ModArmorMaterials.URANIUM, EquipmentSlot.LEGS,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item HARDENED_N7_SABATONS = registerItem("hardened_n7_sabatons",
            new ModArmorItem(ModArmorMaterials.URANIUM, EquipmentSlot.FEET,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item PAPPYM_BLADE = registerItem("pappym_blade",
            new PappyMSwordItem(ModToolMaterials.ZENITHIUM,3,-2.4f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item PAPPYD_BLADE = registerItem("pappyd_blade",
            new PappyDSwordItem(ModToolMaterials.ZENITHIUM,3,-2.6f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item THANATU_BLADE = registerItem("thanatu_blade",
            new ThanatuBladeItem(ModToolMaterials.ZENITHIUM, -6,-2.8f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item MORPHEUS_BLADE = registerItem("morpheus_blade",
            new MorpheusBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item SKYLAR_BLADE = registerItem("skylar_blade",
            new SkylarBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item LILITH_BLADE = registerItem("lilith_blade",
            new LilithBladeItem(ModToolMaterials.ZENITHIUM,-5,-2.4f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item TREVOR_BLADE = registerItem("trevor_blade",
            new TrevorBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item KINGS_BLADE = registerItem("kings_blade",
            new KingsBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item COPPER_ARM = registerItem("copper_arm",
            new CrossbowItem(new FabricItemSettings().maxDamage(465).group(ModItemGroup.ARMORY)));

    public static final Item ZENITHIUM_PICKAXE = registerItem("zenithium_pickaxe",
            new ModPickaxeItem(ModToolMaterials.ZENITHIUM, 1, -2.8f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item ZENITHIUM_AXE = registerItem("zenithium_axe",
            new ModAxeItem(ModToolMaterials.ZENITHIUM, 6, -3f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item ZENITHIUM_SHOVEL = registerItem("zenithium_shovel",
            new ShovelItem(ModToolMaterials.ZENITHIUM, 1.5f, -3f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item ZENITHIUM_HOE = registerItem("zenithium_hoe",
            new ModHoeItem(ModToolMaterials.ZENITHIUM, 0, -3f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    /*public static final Item BLACKSMITHS_WELDING_MASK = registerItem("blacksmiths_welding_mask",
            new ModArmorItem(ModArmorMaterials.ZENITHIUM, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item MAD_SCIENTISTS_LAB_COAT = registerItem("mad_scientists_lab_coat",
            new ModArmorItem(ModArmorMaterials.ZENITHIUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));*/

    public static final Item THANATU_SKULL = registerItem("thanatu_skull",
            new ModArmorItem(ModArmorMaterials.BONE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item THANATU_SHOULDERPADS = registerItem("thanatu_shoulderpads",
            new ModArmorItem(ModArmorMaterials.BONE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    public static final Item ZENITHIUM_BODYSUIT_TORSO = registerItem("zenithium_bodysuit_torso",
            new ModArmorItem(ModArmorMaterials.ZENITHIUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item ZENITHIUM_BODYSUIT_PANTS = registerItem("zenithium_bodysuit_pants",
            new ModArmorItem(ModArmorMaterials.ZENITHIUM, EquipmentSlot.LEGS,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item SKYHOPPERS = registerItem("skyhoppers",
            new ModArmorItem(ModArmorMaterials.ZENITHIUM, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ARMORY)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item);
    }

    public static void registerArmory(){
        trevorssentinels.LOGGER.info("Registering Armory for "+ MOD_ID);
    }
}