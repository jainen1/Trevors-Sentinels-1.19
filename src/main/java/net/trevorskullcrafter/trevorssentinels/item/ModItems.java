package net.trevorskullcrafter.trevorssentinels.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.custom.*;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModItems {

    public static final Item SENTINUM_SHARD = registerItem("sentinum_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item SENTINUM_LENS = registerItem("sentinum_lens",
            new LensItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.SENTINELS)));

    public static final Item SENTINUM_HOLOPROJECTOR = registerItem("sentinum_holoprojector",
            new HoloprojectorItem(
                    new FabricItemSettings().maxDamage(129).group(ModItemGroup.SENTINELS)));

    public static final Item MUSIC_DISC_ASSASSINATION_UPLOAD = registerItem("music_disc_assassination_upload",
            new ModMusicDiscItem(7, ModSounds.ASSASSINATION_UPLOAD,
                    new FabricItemSettings().maxCount(1).group(ModItemGroup.WORLD).rarity(Rarity.RARE)));

    public static final Item MUSIC_DISC_ODE_TO_TRANQUILITY = registerItem("music_disc_ode_to_tranquility",
            new ModMusicDiscItem(7, ModSounds.ODE_TO_TRANQUILITY,
                    new FabricItemSettings().maxCount(1).group(ModItemGroup.WORLD).rarity(Rarity.RARE)));

    public static final Item STEEL_SHEET = registerItem("steel_sheet",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item STEEL_SIGN = registerItem("steel_sign",
            new SignItem(new FabricItemSettings().group(ModItemGroup.SENTINELS).maxCount(16),
                    ModBlocks.STEEL_SIGN_BLOCK, ModBlocks.STEEL_WALL_SIGN_BLOCK));

    public static final Item HOLOGRAPHIC_SIGN = registerItem("holographic_sign",
            new SignItem(new FabricItemSettings().group(ModItemGroup.SENTINELS).maxCount(16),
                    ModBlocks.HOLOGRAPHIC_SIGN_BLOCK, ModBlocks.HOLOGRAPHIC_WALL_SIGN_BLOCK));

    public static final Item FRIED_EGG = registerItem("fried_egg",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));

    public static final Item RICE = registerItem("rice",
            new AliasedBlockItem(ModBlocks.RICE_PLANT, new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build())));

    public static final Item RICE_CAKE = registerItem("rice_cake",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));

    public static final Item SUSHI_ROLL = registerItem("sushi_roll",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).build())));

    public static final Item GOLDEN_RICE = registerItem("golden_rice",
            new AliasedBlockItem(ModBlocks.GOLDEN_RICE_PLANT, new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build())));

    public static final Item GOLDEN_RICE_CAKE = registerItem("golden_rice_cake",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).build())));

    public static final Item TORTILLA = registerItem("tortilla",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item BURRITO = registerItem("burrito",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(12).saturationModifier(2.4f).build())));

    public static final Item PEARFRUIT = registerItem("pearfruit",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 1), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 1), 1.0f)
                            .alwaysEdible().build())));

    public static final Item BROWNIE = registerItem("brownie",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));

    public static final Item SANDFISH = registerItem("sandfish",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build())));

    public static final Item ANTIMILK = registerItem("antimilk",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN).food(new FoodComponent.Builder()
                            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1, 0), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, 0), 1.0f)
                            .alwaysEdible().build()).rarity(Rarity.EPIC)));

    public static final Item SENTINEL_SPAWN_EGG = registerItem("sentinel_spawn_egg",
            new SpawnEggItem(ModEntities.SENTINEL, 0xffffff, 0xffffff,
                    new FabricItemSettings().group(ModItemGroup.WORLD)));

    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item IRON_GOLD_INGOT = registerItem("iron_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item TRANSITITE_SHARDS = registerItem("transitite_shards",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item ASH = registerItem("ash",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)
                    .food(new FoodComponent.Builder().hunger(-2).saturationModifier(0.2f).build())));

    public static final Item DARKSTEEL_INGOT = registerItem("darksteel_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item BLOOD_DIAMOND = registerItem("blood_diamond",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS).fireproof()));

    public static final Item VIOLENT_CATALYST = registerItem("violent_catalyst",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS).fireproof()));

    public static final Item URANIUM_CRYSTAL = registerItem("uranium_crystal",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item FLIMSY_SENTINUM_SHIV = registerItem("flimsy_sentinum_shiv",
            new DaggerItem(ModToolMaterials.FLIMSY_SENTINUM, 0, -1f,
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
            new DaggerItem(ModToolMaterials.SENTINUM, 0, -1f,
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
            new DaggerItem(ModToolMaterials.ROSE_GOLD, 1, -1f,
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
            new TwinBladeItem(ModToolMaterials.TRIMETAL, 3, -2f,
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
            new DaggerItem(ModToolMaterials.DARKSTEEL, -3, -1f,
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
            new DaggerItem(ModToolMaterials.URANIUM, -3, -1f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item NUCLEAR_DRILL = registerItem("nuclear_drill",
            new ModPickaxeItem(ModToolMaterials.URANIUM, 0, 0,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item NUCLEAR_AXE = registerItem("nuclear_axe",
            new ModAxeItem(ModToolMaterials.URANIUM, 3, -3.2f,
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
            new PappyDSwordItem(ModToolMaterials.ZENITHIUM,3,-2.4f,
                    new FabricItemSettings().fireproof().group(ModItemGroup.ARMORY)));

    public static final Item THANATU_BLADE = registerItem("thanatu_blade",
            new ThanatuBladeItem(ModToolMaterials.ZENITHIUM, -6,-2.4f,
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
            new ModAxeItem(ModToolMaterials.ZENITHIUM, 6, -3.2f,
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

    public static final Item PORTKEY = registerItem("portkey",
            new PortkeyItem(new FabricItemSettings().maxDamage(11).group(ModItemGroup.SENTINELS)));

    public static final Item NUCLEAR_ROCKET = registerItem("nuclear_rocket",
            new NuclearFireworkItem(new FabricItemSettings().maxCount(1).maxDamage(65).rarity(Rarity.RARE).group(ModItemGroup.SENTINELS)));

    public static final Item SUPERFORGE_ITEM = registerItem("superforge_item",
            new AnimatedBlockItem(ModBlocks.SUPERFORGE, new FabricItemSettings().fireproof().group(ModItemGroup.SENTINELS)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item);
    }

    public static void registerModItems(){
        trevorssentinels.LOGGER.info("Registering Mod Items for "+ MOD_ID);
    }
}
