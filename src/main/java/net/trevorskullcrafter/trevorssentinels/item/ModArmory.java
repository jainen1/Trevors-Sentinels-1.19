package net.trevorskullcrafter.trevorssentinels.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.trevorskullcrafter.trevorssentinels.item.custom.*;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.util.Identifier;
import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;
import static net.trevorskullcrafter.trevorssentinels.util.ColoredTextUtil.*;

public class ModArmory {
    public static final Item FLIMSY_SENTINUM_SHIV = registerItem("flimsy_sentinum_shiv",
            new ModSwordItem(flimsy_sentinum, ModToolMaterials.FLIMSY_SENTINUM, 0, -2f, new FabricItemSettings()));

    public static final Item FLIMSY_SENTINUM_PICKAXE = registerItem("flimsy_sentinum_pickaxe",
            new ModPickaxeItem(flimsy_sentinum, ModToolMaterials.FLIMSY_SENTINUM, 1, -2.8f, new FabricItemSettings()));

    public static final Item FLIMSY_SENTINUM_HATCHET = registerItem("flimsy_sentinum_hatchet",
            new ModAxeItem(flimsy_sentinum, ModToolMaterials.FLIMSY_SENTINUM, 4, -3.2f, new FabricItemSettings()));

    public static final Item FLIMSY_SENTINUM_SPADE = registerItem("flimsy_sentinum_spade",
            new ModShovelItem(flimsy_sentinum, ModToolMaterials.FLIMSY_SENTINUM, 1.5f, -3f, new FabricItemSettings()));

    public static final Item FLIMSY_SENTINUM_SCYTHE = registerItem("flimsy_sentinum_scythe",
            new ModHoeItem(flimsy_sentinum, ModToolMaterials.FLIMSY_SENTINUM, 0, -3f, new FabricItemSettings()));

    public static final Item FLIMSY_SENTINUM_HAT = registerItem("flimsy_sentinum_hat",
            new ModArmorItem(flimsy_sentinum, ModArmorMaterials.FLIMSY_SENTINUM, EquipmentSlot.HEAD,
                    new FabricItemSettings()));

    public static final Item FLIMSY_SENTINUM_CHESTPLATE = registerItem("flimsy_sentinum_chestplate",
            new ModArmorItem(flimsy_sentinum, ModArmorMaterials.FLIMSY_SENTINUM, EquipmentSlot.CHEST,
                    new FabricItemSettings()));

    public static final Item FLIMSY_SENTINUM_LOINCLOTH = registerItem("flimsy_sentinum_loincloth",
            new ModArmorItem(flimsy_sentinum, ModArmorMaterials.FLIMSY_SENTINUM, EquipmentSlot.LEGS, new FabricItemSettings()));

    public static final Item FLIMSY_SENTINUM_SABATONS = registerItem("flimsy_sentinum_sabatons",
            new ModArmorItem(flimsy_sentinum, ModArmorMaterials.FLIMSY_SENTINUM, EquipmentSlot.FEET,
                    new FabricItemSettings()));

    public static final Item SENTINUM_DIRK = registerItem("sentinum_dirk",
            new ModSwordItem(sentinum, ModToolMaterials.SENTINUM, 0, -2f, new FabricItemSettings()));

    public static final Item SENTINUM_PICKAXE = registerItem("sentinum_pickaxe",
            new ModPickaxeItem(sentinum, ModToolMaterials.SENTINUM, 0, -2.8f, new FabricItemSettings()));

    public static final Item SENTINUM_CHAINSAW = registerItem("sentinum_chainsaw",
            new SentinumChainsawItem(sentinum, ModToolMaterials.SENTINUM, 3, -3f, new FabricItemSettings()));

    public static final Item SENTINUM_SPADE = registerItem("sentinum_spade",
            new ModShovelItem(sentinum, ModToolMaterials.SENTINUM, 1.5f, -3f, new FabricItemSettings()));

    public static final Item SENTINUM_SCYTHE = registerItem("sentinum_scythe",
            new ModHoeItem(sentinum, ModToolMaterials.SENTINUM, 0, -3f, new FabricItemSettings()));

    public static final Item SENTINUM_VISOR = registerItem("sentinum_visor",
            new SentinumArmorItem(sentinum, ModArmorMaterials.SENTINUM, EquipmentSlot.HEAD, new FabricItemSettings()));

    public static final Item SENTINUM_CUIRASS = registerItem("sentinum_cuirass",
            new SentinumArmorItem(sentinum, ModArmorMaterials.SENTINUM, EquipmentSlot.CHEST, new FabricItemSettings()));

    public static final Item SENTINUM_KILT = registerItem("sentinum_kilt",
            new SentinumArmorItem(sentinum, ModArmorMaterials.SENTINUM, EquipmentSlot.LEGS,
                    new FabricItemSettings()));

    public static final Item SENTINUM_SABATONS = registerItem("sentinum_sabatons",
            new SentinumArmorItem(sentinum, ModArmorMaterials.SENTINUM, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item ROSE_GOLD_DAGGER = registerItem("rose_gold_dagger",
            new ModSwordItem(rose_gold, ModToolMaterials.ROSE_GOLD, 1, -2f, new FabricItemSettings()));

    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe",
            new ModPickaxeItem(rose_gold, ModToolMaterials.ROSE_GOLD, 1, -2.8f, new FabricItemSettings()));

    public static final Item ROSE_GOLD_BATTLEAXE = registerItem("rose_gold_battleaxe",
            new ModAxeItem(rose_gold, ModToolMaterials.ROSE_GOLD, 3, -3f, new FabricItemSettings()));

    public static final Item ROSE_GOLD_SPADE = registerItem("rose_gold_spade",
            new ModShovelItem(rose_gold, ModToolMaterials.ROSE_GOLD, 1.5f, -3f, new FabricItemSettings()));

    public static final Item ROSE_GOLD_SCYTHE = registerItem("rose_gold_scythe",
            new ModHoeItem(rose_gold, ModToolMaterials.ROSE_GOLD, 0, -3f, new FabricItemSettings()));

    public static final Item ROSE_GOLD_HELM = registerItem("rose_gold_helm",
            new ModArmorItem(rose_gold, ModArmorMaterials.ROSE_GOLD, EquipmentSlot.HEAD, new FabricItemSettings()));

    public static final Item ROSE_GOLD_CUIRASS = registerItem("rose_gold_cuirass",
            new ModArmorItem(rose_gold, ModArmorMaterials.ROSE_GOLD, EquipmentSlot.CHEST, new FabricItemSettings()));

    public static final Item ROSE_GOLD_LEGGINGS = registerItem("rose_gold_leggings",
            new ModArmorItem(rose_gold, ModArmorMaterials.ROSE_GOLD, EquipmentSlot.LEGS, new FabricItemSettings()));

    public static final Item ROSE_GOLD_SABATONS = registerItem("rose_gold_sabatons",
            new ModArmorItem(rose_gold, ModArmorMaterials.ROSE_GOLD, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item TRIMETAL_CROWBAR = registerItem("trimetal_crowbar",
            new ModSwordItem(trimetal, ModToolMaterials.TRIMETAL, 3, -2f, new FabricItemSettings()));

    public static final Item TRIMETAL_DRILL = registerItem("trimetal_drill",
            new ModPickaxeItem(trimetal, ModToolMaterials.TRIMETAL, 1, 0f, new FabricItemSettings()));

    public static final Item TRIMETAL_CLEAVER = registerItem("trimetal_cleaver",
            new ModAxeItem(trimetal, ModToolMaterials.TRIMETAL, 3, -2.8f, new FabricItemSettings()));

    public static final Item TRIMETAL_SHOVEL = registerItem("trimetal_shovel",
            new ModShovelItem(trimetal, ModToolMaterials.TRIMETAL, 1.5f, -3f, new FabricItemSettings()));

    public static final Item TRIMETAL_HOE = registerItem("trimetal_hoe",
            new ModHoeItem(trimetal, ModToolMaterials.TRIMETAL, 0, -3f, new FabricItemSettings()));

    public static final Item TRIMETAL_HELMET = registerItem("trimetal_helmet",
            new ModArmorItem(trimetal, ModArmorMaterials.TRIMETAL, EquipmentSlot.HEAD, new FabricItemSettings()));

    public static final Item TRIMETAL_HARNESS = registerItem("trimetal_harness",
            new ModArmorItem(trimetal,  ModArmorMaterials.TRIMETAL, EquipmentSlot.CHEST, new FabricItemSettings()));

    public static final Item TRIMETAL_LEG_GUARDS = registerItem("trimetal_leg_guards",
            new ModArmorItem(trimetal, ModArmorMaterials.TRIMETAL, EquipmentSlot.LEGS, new FabricItemSettings()));

    public static final Item TRIMETAL_BOOTS = registerItem("trimetal_boots",
            new ModArmorItem(trimetal, ModArmorMaterials.TRIMETAL, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item HUNTERS_VIBROBLADE = registerItem("hunters_vibroblade",
            new ModSwordItem(hunter, ModToolMaterials.DARKSTEEL, -3, -2f, new FabricItemSettings()));

    public static final Item HUNTERS_DRILL = registerItem("hunters_drill",
            new ModPickaxeItem(hunter, ModToolMaterials.DARKSTEEL, 0,0f, new FabricItemSettings()));

    public static final Item HUNTERS_CHAINSAW = registerItem("hunters_chainsaw",
            new SentinumChainsawItem(hunter, ModToolMaterials.DARKSTEEL, 3, -2.8f, new FabricItemSettings()));

    public static final Item HUNTERS_SPADE = registerItem("hunters_spade",
            new ModShovelItem(hunter, ModToolMaterials.DARKSTEEL, 1.5f, -3f, new FabricItemSettings()));

    public static final Item HUNTERS_SCYTHE = registerItem("hunters_scythe",
            new ModHoeItem(hunter, ModToolMaterials.DARKSTEEL, 0, -3f, new FabricItemSettings()));

    public static final Item HUNTERS_VISOR = registerItem("hunters_visor",
            new ModArmorItem(hunter, ModArmorMaterials.DARKSTEEL, EquipmentSlot.HEAD, new FabricItemSettings()));

    public static final Item HUNTERS_TORSO = registerItem("hunters_torso",
            new ModArmorItem(hunter,  ModArmorMaterials.DARKSTEEL, EquipmentSlot.CHEST, new FabricItemSettings()));

    public static final Item HUNTERS_LEGS = registerItem("hunters_legs",
            new ModArmorItem(hunter, ModArmorMaterials.DARKSTEEL, EquipmentSlot.LEGS,
                    new FabricItemSettings()));

    public static final Item HUNTERS_BOOTS = registerItem("hunters_boots",
            new ModArmorItem(hunter, ModArmorMaterials.DARKSTEEL, EquipmentSlot.FEET, new FabricItemSettings()));

    public static final Item CRYSTAL_DAGGER = registerItem("crystal_dagger",
            new ModSwordItem(nuclear, ModToolMaterials.URANIUM, -3, -2f, new FabricItemSettings().fireproof()));

    public static final Item NUCLEAR_DRILL = registerItem("nuclear_drill",
            new ModPickaxeItem(nuclear, ModToolMaterials.URANIUM, 0, 0, new FabricItemSettings().fireproof()));

    public static final Item NUCLEAR_AXE = registerItem("nuclear_axe",
            new ModAxeItem(nuclear, ModToolMaterials.URANIUM, 3, -3.1f, new FabricItemSettings().fireproof()));

    public static final Item NUCLEAR_SHOVEL = registerItem("nuclear_shovel",
            new ModShovelItem(nuclear, ModToolMaterials.URANIUM, 1.5f, -3f, new FabricItemSettings().fireproof()));

    public static final Item NUCLEAR_SCYTHE = registerItem("nuclear_scythe",
            new ModHoeItem(nuclear, ModToolMaterials.URANIUM, 0, -3f, new FabricItemSettings().fireproof()));

    public static final Item HARDENED_N7_VISOR = registerItem("hardened_n7_visor",
            new ModArmorItem(nuclear, ModArmorMaterials.URANIUM, EquipmentSlot.HEAD, new FabricItemSettings().fireproof()));

    public static final Item HARDENED_N7_CUIRASS = registerItem("hardened_n7_cuirass",
            new ModArmorItem(nuclear, ModArmorMaterials.URANIUM, EquipmentSlot.CHEST, new FabricItemSettings().fireproof()));

    public static final Item HARDENED_N7_LEGGINGS = registerItem("hardened_n7_leggings",
            new ModArmorItem(nuclear, ModArmorMaterials.URANIUM, EquipmentSlot.LEGS, new FabricItemSettings().fireproof()));

    public static final Item HARDENED_N7_SABATONS = registerItem("hardened_n7_sabatons",
            new ModArmorItem(nuclear, ModArmorMaterials.URANIUM, EquipmentSlot.FEET, new FabricItemSettings().fireproof()));

    public static final Item PAPPYM_BLADE = registerItem("pappym_blade",
            new PappyMSwordItem("#FFFF55", ModToolMaterials.ZENITHIUM,0,-2.5f,
                    new FabricItemSettings().fireproof().maxDamage(1200)));

    public static final Item PAPPYD_BLADE = registerItem("pappyd_blade",
            new PappyDSwordItem(ModToolMaterials.ZENITHIUM,0,-2.5f, new FabricItemSettings().fireproof()));

    public static final Item THANATU_BLADE = registerItem("thanatu_blade",
            new ThanatuBladeItem(demonic, ModToolMaterials.ZENITHIUM, 3,-2.8f, new FabricItemSettings().fireproof()));

    public static final Item MORPHEUS_BLADE = registerItem("morpheus_blade",
            new MorpheusBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new FabricItemSettings().fireproof()));

    public static final Item SKYLAR_BLADE = registerItem("skylar_blade",
            new SkylarBladeItem(ModToolMaterials.ZENITHIUM,0,-2.4f, new FabricItemSettings().fireproof()));

    public static final Item LILITH_BLADE = registerItem("lilith_blade",
            new LilithBladeItem(ModToolMaterials.ZENITHIUM,-5,-2.4f, new FabricItemSettings().fireproof()));

    public static final Item TREVOR_BLADE = registerItem("trevor_blade",
            new TrevorBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new FabricItemSettings().fireproof()));

    public static final Item KINGS_BLADE = registerItem("kings_blade",
            new KingsBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new FabricItemSettings().fireproof()));

    public static final Item COPPER_ARM = registerItem("copper_arm",
            new CopperArmItem("8_#e77c56_#8a4129", new FabricItemSettings().maxDamage(465)));

    public static final Item ZENITHIUM_PICKAXE = registerItem("zenithium_pickaxe",
            new ModPickaxeItem(zenithium, ModToolMaterials.ZENITHIUM, 1, -2.8f, new FabricItemSettings().fireproof()));

    public static final Item ZENITHIUM_AXE = registerItem("zenithium_axe",
            new ModAxeItem(zenithium, ModToolMaterials.ZENITHIUM, 6, -3f, new FabricItemSettings().fireproof()));

    public static final Item ZENITHIUM_SHOVEL = registerItem("zenithium_shovel",
            new ModShovelItem(zenithium, ModToolMaterials.ZENITHIUM, 1.5f, -3f, new FabricItemSettings().fireproof()));

    public static final Item ZENITHIUM_HOE = registerItem("zenithium_hoe",
            new ModHoeItem(zenithium, ModToolMaterials.ZENITHIUM, 0, -3f, new FabricItemSettings().fireproof()));

    public static final Item BLACKSMITHS_WELDING_MASK = registerItem("blacksmiths_welding_mask",
            new ModArmorItem(zenithium, ModArmorMaterials.ZENITHIUM, EquipmentSlot.HEAD, new FabricItemSettings()));

    public static final Item MAD_SCIENTISTS_LAB_COAT = registerItem("mad_scientists_lab_coat",
            new ModArmorItem(zenithium, ModArmorMaterials.ZENITHIUM, EquipmentSlot.CHEST, new FabricItemSettings()));

    public static final Item THANATU_SKULL = registerItem("thanatu_skull",
            new ModArmorItem(demonic, ModArmorMaterials.BONE, EquipmentSlot.HEAD, new FabricItemSettings()));

    public static final Item THANATU_SHOULDERPADS = registerItem("thanatu_shoulderpads",
            new ModArmorItem(demonic, ModArmorMaterials.BONE, EquipmentSlot.CHEST, new FabricItemSettings()));

    public static final Item ZENITHIUM_BODYSUIT_TORSO = registerItem("zenithium_bodysuit_torso",
            new ModArmorItem(zenithium, ModArmorMaterials.ZENITHIUM, EquipmentSlot.CHEST,
                    new FabricItemSettings().fireproof()));

    public static final Item ZENITHIUM_BODYSUIT_PANTS = registerItem("zenithium_bodysuit_pants",
            new ModArmorItem(zenithium, ModArmorMaterials.ZENITHIUM, EquipmentSlot.LEGS, new FabricItemSettings().fireproof()));

    public static final Item SKYHOPPERS = registerItem("skyhoppers",
            new ModArmorItem(zenithium, ModArmorMaterials.ZENITHIUM, EquipmentSlot.FEET, new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item);
    }

    public static void registerArmory(){
        trevorssentinels.LOGGER.info("Registering armory... (" + MOD_ID + ")");
    }
}