package net.trevorskullcrafter.trevorssentinels.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.ArmorMaterials;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.*;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;
import static net.trevorskullcrafter.trevorssentinels.util.LangGenUtils.*;
import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.*;

public class EnglishLangGenerator extends FabricLanguageProvider {
    public EnglishLangGenerator(FabricDataOutput dataOutput) { super(dataOutput, "en_us"); }

    @Override public void generateTranslations(TranslationBuilder translationBuilder) {
        generateMultiple(translationBuilder, 0, galliumGray, ModArmory.GALLIUM_PICKAXE);
        generateItem(translationBuilder, ModArmory.GALLIUM_HELMET, 0, "Gallium Helmet", "\"I will be the king of the sentinels!\"", galliumGray);
        generateItem(translationBuilder, ModArmory.GALLIUM_CHESTPLATE, 0, "Gallium Chestplate", "Feels odd...", galliumGray);
        generateItem(translationBuilder, ModArmory.GALLIUM_LEGGINGS, 0, "Gallium Loincloth", "Just try not to wiggle.", galliumGray);
        generateItem(translationBuilder, ModArmory.GALLIUM_BOOTS, 0, "Gallium Sabatons", "Like walking on a razor-sharp cloud.", galliumGray);
        generateItem(translationBuilder, ModArmory.GALLIUM_SWORD, 0, "Gallium Vibroblade", "", galliumGray);
        generateItem(translationBuilder, ModArmory.GALLIUM_DAGGER, 0, "Gallium Vibroknife", null, galliumGray);
        generateItem(translationBuilder, ModArmory.GALLIUM_AXE, 0, "Gallium Hatchet", null, galliumGray);
        generateItem(translationBuilder, ModArmory.GALLIUM_SHOVEL, 0, "Gallium Spade", null, galliumGray);
        generateItem(translationBuilder, ModArmory.GALLIUM_HOE, 0, "Gallium Sickle", null, galliumGray);
        generateItem(translationBuilder, ModArmory.GALLIUM_CHAINSAW, 0, "Gallium Chainsaw", "Right click to launch globs at enemies!", galliumGray);

        generateMultiple(translationBuilder, 0, SCRAP, ModArmory.SCRAP_SWORD, ModArmory.SCRAP_DAGGER, ModArmory.SCRAP_PICKAXE, ModArmory.SCRAP_SHOVEL);
        generateItem(translationBuilder, ModArmory.SCRAP_HELMET, 0, "Scrap Helmet", "\"I will be the king of the sentinels!\"", SCRAP);
        generateItem(translationBuilder, ModArmory.SCRAP_CHESTPLATE, 0, "Scrap Chestplate", "Feels odd...", SCRAP);
        generateItem(translationBuilder, ModArmory.SCRAP_LEGGINGS, 0, "Scrap Loincloth", "Just try not to wiggle.", SCRAP);
        generateItem(translationBuilder, ModArmory.SCRAP_BOOTS, 0, "Scrap Boots", "Like walking on a razor-sharp cloud.", SCRAP);
        generateItem(translationBuilder, ModArmory.SCRAP_AXE, 0, "Scrap Hatchet", null, SCRAP);
        generateItem(translationBuilder, ModArmory.SCRAP_HOE, 0, "Scrap Hoe", null, SCRAP);
        generateItem(translationBuilder, ModArmory.SCRAP_CHAINSAW, 0, "Scrap Chainsaw", "Right click to launch shards at enemies!", SCRAP);

        generateItem(translationBuilder, ModArmory.SPACEFARERS_HELMET, 0, "Spacefarer's Visor", "\"J.A.R.V.I.S., you there?\"", GUNMETAL);
        generateItem(translationBuilder, ModArmory.SPACEFARERS_CHESTPLATE, 0, "Spacefarer's Armor", "Arm-shield functionality not guaranteed.", GUNMETAL);
        generateItem(translationBuilder, ModArmory.SPACEFARERS_LEGGINGS, 0, "Spacefarer's Kilt", "\"It's not a skirt, it's a kilt!\"", GUNMETAL);
        generateItem(translationBuilder, ModArmory.SPACEFARERS_BOOTS, 0, "Spacefarer's Boots", "heh... feet.", GUNMETAL);
        generateItem(translationBuilder, ModArmory.SPACEFARERS_SWORD, 0, "Spacefarer's Vibroblade", null, GUNMETAL);
        generateItem(translationBuilder, ModArmory.SPACEFARERS_DAGGER, 0, "Spacefarer's Vibroknife", null, GUNMETAL);
        generateItem(translationBuilder, ModArmory.SPACEFARERS_PICKAXE, 0, "Spacefarer's Pickaxe", null, GUNMETAL);
        generateItem(translationBuilder, ModArmory.SPACEFARERS_AXE, 0, "Spacefarer's Hatchet", null, GUNMETAL);
        generateItem(translationBuilder, ModArmory.SPACEFARERS_SHOVEL, 0, "Spacefarer's Spade", null, GUNMETAL);
        generateItem(translationBuilder, ModArmory.SPACEFARERS_HOE, 0, "Spacefarer's Sickle", null, GUNMETAL);

        generateMultiple(translationBuilder, 0, ROSE_GOLD, ModArmory.ROSE_GOLD_SWORD, ModArmory.ROSE_GOLD_DAGGER, ModArmory.ROSE_GOLD_PICKAXE);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_HELMET, 0, "Rose Gold Helm", "Hides your rosy cheeks.", ROSE_GOLD);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_CHESTPLATE, 0, "Rose Gold Cuirass", "Guaranteed 100% thorn-free.", ROSE_GOLD);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_LEGGINGS, 0, "Rose Gold Leggings", "Flowery skirt not included", ROSE_GOLD);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_BOOTS, 0, "Rose Gold Sabatons", "Petal to the metal!", ROSE_GOLD);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_AXE, 0, "Rose Gold Battleaxe", null, ROSE_GOLD);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_SHOVEL, 0, "Rose Gold Spade", null, ROSE_GOLD);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_HOE, 0, "Rose Gold Sickle", null, ROSE_GOLD);

        generateMultiple(translationBuilder, 0, COPPER, ModArmory.COPPER_AXE, ModArmory.COPPER_SHOVEL, ModArmory.COPPER_HOE);
        generateItem(translationBuilder, ModArmory.COPPER_HELMET, 0, "Copper Helmet", "Hides your rosy cheeks.", COPPER);
        generateItem(translationBuilder, ModArmory.COPPER_CHESTPLATE, 0, "Copper ", "Guaranteed 100% thorn-free.", COPPER);
        generateItem(translationBuilder, ModArmory.COPPER_LEGGINGS, 0, "Rose Gold Leggings", "Flowery skirt not included", COPPER);
        generateItem(translationBuilder, ModArmory.COPPER_BOOTS, 0, "Rose Gold Sabatons", "Petal to the metal!", COPPER);
        generateItem(translationBuilder, ModArmory.COPPER_SWORD, 0, "Copper Sword", "An ornamental blade of goblin tradition.", COPPER);
        generateItem(translationBuilder, ModArmory.COPPER_DAGGER, 0, "Copper Gladius", null, COPPER);
        generateItem(translationBuilder, ModArmory.COPPER_PICKAXE, 0, "Copper Pickaxe", "", COPPER);
        generateItem(translationBuilder, BetaItems.COPPER_ARM, 0, "Copper Arm", "Contains the soul of a once-powerful goddess.", COPPER);

        generateMultiple(translationBuilder, 0, TRIMETAL, ModArmory.TRIMETAL_HELMET, ModArmory.TRIMETAL_SHOVEL, ModArmory.TRIMETAL_HOE);
        generateItem(translationBuilder, ModArmory.TRIMETAL_CHESTPLATE, 0, "Industrial Harness", "Bulletproof... maybe.", TRIMETAL);
        generateItem(translationBuilder, ModArmory.TRIMETAL_LEGGINGS, 0, "Industrial Leg Guards", "Good for sports and combat!", TRIMETAL);
        generateItem(translationBuilder, ModArmory.TRIMETAL_BOOTS, 0, "Industrial Boots", "These boots were made for walking...", TRIMETAL);
        generateItem(translationBuilder, ModArmory.TRIMETAL_SWORD, 0, "Industrial Crowbar", "Rise, and... shine.", TRIMETAL);
        generateItem(translationBuilder, ModArmory.TRIMETAL_DAGGER, 0, "Industrial Knife", null, TRIMETAL);
        generateItem(translationBuilder, ModArmory.TRIMETAL_PICKAXE, 0, "Industrial Drill", null, TRIMETAL);
        generateItem(translationBuilder, ModArmory.TRIMETAL_AXE, 0, "Industrial Cleaver", null, TRIMETAL);

        generateMultiple(translationBuilder, 0, IMPERIAL_ALLOY, ModArmory.IMPERIAL_PICKAXE, ModArmory.IMPERIAL_AXE, ModArmory.IMPERIAL_SHOVEL, ModArmory.IMPERIAL_HOE);
        generateItem(translationBuilder, ModArmory.IMPERIAL_HELMET, 0, "Imperial Helmet", "Good soldiers see everything.", IMPERIAL_ALLOY);
        generateItem(translationBuilder, ModArmory.IMPERIAL_CHESTPLATE, 0, "Imperial Chestplate", "Good soldiers know how to defend themselves.", IMPERIAL_ALLOY);
        generateItem(translationBuilder, ModArmory.IMPERIAL_LEGGINGS, 0, "Imperial Leggings", "Good soldiers suppress their emotions.", IMPERIAL_ALLOY);
        generateItem(translationBuilder, ModArmory.IMPERIAL_BOOTS, 0, "Imperial Boots", "Good soldiers show no weakness.", IMPERIAL_ALLOY);
        generateItem(translationBuilder, ModArmory.IMPERIAL_SWORD, 0, "Imperial Sword", null, IMPERIAL_ALLOY);
        generateItem(translationBuilder, ModArmory.IMPERIAL_DAGGER, 0, "Imperial Gladius", null, IMPERIAL_ALLOY);

        generateMultiple(translationBuilder, 0, LIGHT_PURPLE, ModArmory.TRANSITITE_HELMET, ModArmory.TRANSITITE_CHESTPLATE, ModArmory.TRANSITITE_LEGGINGS,
                ModArmory.TRANSITITE_BOOTS, ModArmory.TRANSITITE_SWORD, ModArmory.TRANSITITE_DAGGER, ModArmory.TRANSITITE_PICKAXE, ModArmory.TRANSITITE_AXE,
                ModArmory.TRANSITITE_SHOVEL);
        generateItem(translationBuilder, ModArmory.TRANSITITE_HOE, 0, "Unholy Sickle", null, LIGHT_PURPLE);

        generateMultiple(translationBuilder, 0, DARK_PURPLE, ModArmory.DARKSTEEL_HELMET, ModArmory.DARKSTEEL_CHESTPLATE, ModArmory.DARKSTEEL_LEGGINGS,
                ModArmory.DARKSTEEL_SWORD, ModArmory.DARKSTEEL_DAGGER, ModArmory.DARKSTEEL_PICKAXE, ModArmory.DARKSTEEL_AXE);
        generateItem(translationBuilder, ModArmory.DARKSTEEL_BOOTS, 0, "Darksteel Sabatons", null, DARK_PURPLE);
        generateItem(translationBuilder, ModArmory.DARKSTEEL_SHOVEL, 0, "Darksteel Spade", null, DARK_PURPLE);
        generateItem(translationBuilder, ModArmory.DARKSTEEL_HOE, 0, "Darksteel Sickle", null, DARK_PURPLE);

        generateMultiple(translationBuilder, 0, NUCLEAR, ModArmory.NUCLEAR_CHESTPLATE, ModArmory.NUCLEAR_LEGGINGS, ModArmory.NUCLEAR_DAGGER,
                ModArmory.NUCLEAR_AXE, ModArmory.NUCLEAR_SHOVEL);
        generateItem(translationBuilder, ModArmory.NUCLEAR_HELMET, 0, "Nuclear Visor", null, NUCLEAR);
        generateItem(translationBuilder, ModArmory.NUCLEAR_BOOTS, 0, "Nuclear Sabatons", null, NUCLEAR);
        generateItem(translationBuilder, ModArmory.NUCLEAR_SWORD, 0, "Nuclear Sword", "Irradiates enemies.", NUCLEAR);
        generateItem(translationBuilder, ModArmory.NUCLEAR_PICKAXE, 0, "Nuclear Drill", null, NUCLEAR);
        generateItem(translationBuilder, ModArmory.NUCLEAR_HOE, 0, "Nuclear Sickle", null, NUCLEAR);

        generateMultiple(translationBuilder, 0, BLOOD_RED, ModArmory.NANOTECH_HELMET, ModArmory.NANOTECH_CHESTPLATE, ModArmory.NANOTECH_LEGGINGS,
                ModArmory.NANOTECH_BOOTS, ModArmory.NANOTECH_DAGGER, ModArmory.NANOTECH_PICKAXE, ModArmory.NANOTECH_AXE, ModArmory.NANOTECH_SHOVEL);
        generateItem(translationBuilder, ModArmory.NANOTECH_SWORD, 0, null, "\"I've even forgotten my name...\"", BLOOD_RED);
        generateItem(translationBuilder, ModArmory.NANOTECH_HOE, 0, "Nanotech Sickle", null, BLOOD_RED);

        generateMultiple(translationBuilder, 0, DARK_GREEN, ModArmory.ZENITHIUM_SWORD, ModArmory.ZENITHIUM_DAGGER, ModArmory.ZENITHIUM_PICKAXE,
                ModArmory.ZENITHIUM_AXE, ModArmory.ZENITHIUM_SHOVEL, ModArmory.ZENITHIUM_HOE);
        generateItem(translationBuilder, BetaItems.BLACKSMITHS_WELDING_MASK, 0, "Blacksmith's Welding Mask", null, DARK_GREEN);
        generateItem(translationBuilder, BetaItems.MAD_SCIENTISTS_LAB_COAT, 0, "Mad Scientist's Lab Coat", null, DARK_GREEN);
        generateItem(translationBuilder, ModArmory.ZENITHIUM_CHESTPLATE, 0, "Zenithium Chestplate", "\"Honey, where's my super suit?\"", DARK_GREEN);
        generateItem(translationBuilder, ModArmory.ZENITHIUM_LEGGINGS, 0, "Zenithium Leggings", "Gaming pants!", DARK_GREEN);
        generateItem(translationBuilder, ModArmory.ZENITHIUM_BOOTS, 0, "Utaricorp™ SkyHoppers", "Get your head into the clouds!", DARK_GREEN);
        generateItem(translationBuilder, BetaItems.PAPPYM_BLADE, 0, "Jade Seraphim",
                "Passed down through ancient tradition... and now it has found its way to you.", GREEN);
        generateItem(translationBuilder, BetaItems.PAPPYD_BLADE, 0, "Hell's Flaming Fury", null, HELLFIRE);
        generateItem(translationBuilder, BetaItems.THANATU_BLADE, 0, "Harmonious Rapture", null, LIGHT_PURPLE);
        generateItem(translationBuilder, BetaItems.MORPHEUS_BLADE, 0, "Thunderous Legacy", null, AQUA);
        generateItem(translationBuilder, BetaItems.SKYLAR_BLADE, 0, "Equitous Retribution", null, SHINY_GOLD);
        generateItem(translationBuilder, BetaItems.LILITH_BLADE, 0, "Unwavering Judgement", null, DUNE_TAN);
        generateItem(translationBuilder, BetaItems.TREVOR_BLADE, 0, "blade_null", null, SENTINEL_AQUA);
        generateItem(translationBuilder, BetaItems.KINGS_BLADE, 0, "Stainless Resolve", null, null);
        generateItem(translationBuilder, ModArmory.SCARA_SHEARS, 0, "SCARA Shears", "A military-grade threat.", DARK_PURPLE);
        generateItem(translationBuilder, ModArmory.MASTER_SWORD, 0, "The Master's Sword", "From a distant universe...", AQUA);

        generateItem(translationBuilder, ModArmory.THANATU_SKULL, 0, "Thanatu's Exoskull", "The skull of the demon king.", LIGHT_PURPLE);
        generateItem(translationBuilder, ModArmory.THANATU_SHOULDERPADS, 0, "Thanatu's Shoulderpads", "There's no way these protect anything", LIGHT_PURPLE);

        generateItem(translationBuilder, ModArmory.LASER_PISTOL, 0, "UNMA-28 Comet", "\"Fast and portable!\"", GUNMETAL);
        generateItem(translationBuilder, ModArmory.LASER_TASER, 0, "CCPD-23 Taser", "\"Non-lethal!\"", AQUA);
        generateItem(translationBuilder, ModArmory.LASER_SNIPER_ECHO, 0, "UNMA-52 Echo", "\"They'll never see it coming!\"", DUNE_TAN);
        generateItem(translationBuilder, ModArmory.LASER_MINIGUN, 0, "UTARI-91 Serenity", "\"Keep the peace!\"", BLUE);
        generateItem(translationBuilder, ModArmory.LASER_MINIGUN, 1, "UTARI-91 Serenity", "\"America! Hell yeah!\"", PATRIOT_1);
        generateItem(translationBuilder, ModArmory.LASER_RIFLE, 0, "UNMA-63 Agnostyk", "\"Packs a punch!\"", MOSS);
        generateItem(translationBuilder, ModArmory.LASER_SHOTGUN, 0, "KHAOS-66 Tremor", "\"Rip and tear!\"", HELLFIRE);
        generateItem(translationBuilder, ModArmory.LASER_HEALER, 0, "UTARI-49 Firebird", "\"Those who can't do, heal!\"", SHINY_GOLD);
        generateItem(translationBuilder, ModArmory.LASER_SNIPER, 0, "MW88 Shadow", "\"The assassin's weapon of choice!\"", DARK_PURPLE);
        generateItem(translationBuilder, ModArmory.LASER_SPREADER, 0, "MW76 Pandemic", "\"Filled with a toxic bioweapon.\"", GREEN);
        generateItem(translationBuilder, ModArmory.LASER_REVOLVER, 0, "Drunkard's Handcannon", "\"But you have heard of me!\"", null);
        generateItem(translationBuilder, ModArmory.VILE_SPITTER, 0, "Vile Spitter", "\"Behold, the wrath of Xirang!\"", FLESH_PINK);


        generateAdvancement(translationBuilder, "trevorssentinels", "Trevor's Sentinels", "Acquire a shard of galinite");
        generateAdvancement(translationBuilder, "brownie", "This Edible Ain't Shi-", "Consume a brownie");
        generateAdvancement(translationBuilder, "chainsaw_man", "チェンソーマン", "Craft a chainsaw");
        generateAdvancement(translationBuilder, "forge", "Forging Ahead", "Acquire a forge to harness the power of alloys");
        generateAdvancement(translationBuilder, "trimetal", "Detrimetal", "Acquire any industrial-tier item");
        generateAdvancement(translationBuilder, "ancient_metal", "Ancient Metal", "Acquire any item made from Imperial alloy");
        generateAdvancement(translationBuilder, "rose_gold", "False Belief", "Acquire an ingot of Rose Gold");
        generateAdvancement(translationBuilder, "rose_gold_2", "False Hope", "Craft equipment made from Rose Gold");
        generateAdvancement(translationBuilder, "thanatu", "False Idol", "Acquire the tools of the demon lord");
        generateAdvancement(translationBuilder, "cerberus", "False Idol", "Defeat Cerberus, and release the seal on ancient forces");
        generateAdvancement(translationBuilder, "netherite", "I Can't Believe It's Not Darksteel", "Acquire a netherite item");
        generateAdvancement(translationBuilder, "spf", "SPF 50+", "Obtain a Banana Boat");
        generateAdvancement(translationBuilder, "uranium", "Nuclear Age", "Acquire a cube of Torbernite");
        generateAdvancement(translationBuilder, "superforge", "Master Forger", "Acquire a superforge");
        generateAdvancement(translationBuilder, "zenithium", "Infinity Squared", "Acquire a cluster of Zenithium");
        generateAdvancement(translationBuilder, "heretic", "Heretic", "Burn fabric in a forge");
        generateAdvancement(translationBuilder, "bacon_and_eggs", "Bacon and Eggs", "Part of a complete breakfast!");


        generateMultiple(translationBuilder, 0, YGGDRASIL, ModBlocks.YGGDRASIL_LOG, ModBlocks.YGGDRASIL_WOOD,
                ModBlocks.STRIPPED_YGGDRASIL_LOG, ModBlocks.STRIPPED_YGGDRASIL_WOOD, ModBlocks.YGGDRASIL_PLANKS, ModBlocks.YGGDRASIL_LEAVES, ModBlocks.YGGDRASIL_SAPLING,
                ModBlocks.POTTED_YGGDRASIL_SAPLING, ModBlocks.YGGDRASIL_SLAB, ModBlocks.YGGDRASIL_STAIRS, ModBlocks.YGGDRASIL_FENCE, ModBlocks.YGGDRASIL_FENCE_GATE,
                ModBlocks.YGGDRASIL_BUTTON, ModBlocks.YGGDRASIL_PRESSURE_PLATE, ModBlocks.YGGDRASIL_DOOR, ModBlocks.YGGDRASIL_TRAPDOOR, ModItems.YGGDRASIL_SIGN,
                ModItems.YGGDRASIL_HANGING_SIGN, ModItems.YGGDRASIL_BOAT, ModItems.YGGDRASIL_CHEST_BOAT);
        generateMultiple(translationBuilder, 0, CHARRED, ModBlocks.CHARRED_LOG, ModBlocks.CHARRED_WOOD,
                ModBlocks.STRIPPED_CHARRED_LOG, ModBlocks.STRIPPED_CHARRED_WOOD, ModBlocks.CHARRED_PLANKS, null, null, null,
                ModBlocks.CHARRED_SLAB, ModBlocks.CHARRED_STAIRS, ModBlocks.CHARRED_FENCE, ModBlocks.CHARRED_FENCE_GATE, ModBlocks.CHARRED_BUTTON,
                ModBlocks.CHARRED_PRESSURE_PLATE, ModBlocks.CHARRED_DOOR, ModBlocks.CHARRED_TRAPDOOR, ModItems.CHARRED_SIGN, ModItems.CHARRED_HANGING_SIGN,
                ModItems.CHARRED_BOAT, ModItems.CHARRED_CHEST_BOAT);
        generateMultiple(translationBuilder, 0, MIDAS, ModBlocks.MIDAS_LOG, ModBlocks.MIDAS_WOOD,
                ModBlocks.STRIPPED_MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_WOOD, ModBlocks.MIDAS_PLANKS, ModBlocks.MIDAS_LEAVES, ModBlocks.MIDAS_SAPLING,
                ModBlocks.POTTED_MIDAS_SAPLING, ModBlocks.MIDAS_SLAB, ModBlocks.MIDAS_STAIRS, ModBlocks.MIDAS_FENCE, ModBlocks.MIDAS_FENCE_GATE, ModBlocks.MIDAS_BUTTON,
                ModBlocks.MIDAS_PRESSURE_PLATE, ModBlocks.MIDAS_DOOR, ModBlocks.MIDAS_TRAPDOOR, ModItems.MIDAS_SIGN, ModItems.MIDAS_HANGING_SIGN, ModItems.MIDAS_BOAT,
                ModItems.MIDAS_CHEST_BOAT);
        generateMultiple(translationBuilder, 0, VIRIDESCENT, ModBlocks.VIRIDESCENT_LOG, ModBlocks.VIRIDESCENT_WOOD,
                ModBlocks.STRIPPED_VIRIDESCENT_LOG, ModBlocks.STRIPPED_VIRIDESCENT_WOOD, ModBlocks.VIRIDESCENT_PLANKS, ModBlocks.VIRIDESCENT_LEAVES, ModBlocks.VIRIDESCENT_SAPLING,
                ModBlocks.POTTED_VIRIDESCENT_SAPLING, ModBlocks.VIRIDESCENT_SLAB, ModBlocks.VIRIDESCENT_STAIRS, ModBlocks.VIRIDESCENT_FENCE, ModBlocks.VIRIDESCENT_FENCE_GATE,
                ModBlocks.VIRIDESCENT_BUTTON, ModBlocks.VIRIDESCENT_PRESSURE_PLATE, ModBlocks.VIRIDESCENT_DOOR, ModBlocks.VIRIDESCENT_TRAPDOOR, ModItems.VIRIDESCENT_SIGN,
                ModItems.VIRIDESCENT_HANGING_SIGN, ModItems.VIRIDESCENT_BOAT, ModItems.VIRIDESCENT_CHEST_BOAT);
        generateMultiple(translationBuilder, 0, CERULII, ModBlocks.CERULII_LOG, ModBlocks.CERULII_WOOD,
                ModBlocks.STRIPPED_CERULII_LOG, ModBlocks.STRIPPED_CERULII_WOOD, ModBlocks.CERULII_PLANKS, ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SAPLING,
                ModBlocks.POTTED_CERULII_SAPLING, ModBlocks.CERULII_SLAB, ModBlocks.CERULII_STAIRS, ModBlocks.CERULII_FENCE, ModBlocks.CERULII_FENCE_GATE,
                ModBlocks.CERULII_BUTTON, ModBlocks.CERULII_PRESSURE_PLATE, ModBlocks.CERULII_DOOR, ModBlocks.CERULII_TRAPDOOR, ModItems.CERULII_SIGN,
                ModItems.CERULII_HANGING_SIGN, ModItems.CERULII_BOAT, ModItems.CERULII_CHEST_BOAT);

        generateStatusEffect(translationBuilder, ModEffects.REDSTONED, "Redstoned", true);
        generateStatusEffect(translationBuilder, ModEffects.FLIGHT, "Flight", true);
        generateStatusEffect(translationBuilder, ModEffects.WELL_FED, "Well-Fed", false);
        generateStatusEffect(translationBuilder, ModEffects.COSMIC_FIRE, "Cosmic Flame", false);
        generateStatusEffect(translationBuilder, ModEffects.INFESTED, "☣ Infested ☣", false);
        generateStatusEffect(translationBuilder, ModEffects.IRRADIATED, "☢ Irradiated ☢", false);

        generateMultiple(translationBuilder, 0, GOLD, ModItems.BANANA, ModItems.BANANA_BREAD);
        generateMultiple(translationBuilder, 0, SENTINEL_CRIMSON, ModItems.RED_BANANA, ModItems.RED_BANANA_BREAD);
        generateMultiple(translationBuilder, 0, SENTINEL_AQUA, ModItems.BLUE_JAVA_BANANA, ModItems.BLUE_JAVA_BANANA_BREAD);

        generateItem(translationBuilder, ModBlocks.FLESH_BLOCK, 0, null, "It's strangely warm...", FLESH_PINK);
        generateItem(translationBuilder, ModBlocks.FLESH_VEINS, 0, null, "They're spreading...", FLESH_PINK);
        generateItem(translationBuilder, ModBlocks.FLESHY_EYE, 0, null, "It's staring...", FLESH_PINK);
        generateItem(translationBuilder, ModItems.DUBIOUS_BACON, 0, null, "Don't ask where it came from.", FLESH_PINK);
        generateItem(translationBuilder, ModItems.RUINOUS_GAZE, 0, "Eye of Ruin", "It has a troubling gaze...", FLESH_PINK);

        generateMultiple(translationBuilder, 0, galliumGray, ModBlocks.GALINITE_BLOCK, ModBlocks.CHISELED_GALINITE_BLOCK, ModBlocks.GALINITE_PILLAR, ModItems.SCRAP_METAL_SHARD);
        generateItem(translationBuilder, ModItems.STEEL_INGOT, 0, null, null, null);
        generateItem(translationBuilder, ModItems.GUNMETAL_INGOT, 0, null, null, GUNMETAL);
        generateItem(translationBuilder, ModBlocks.COPPER_IRON_BLOCK, 0, "Block of Dnilvar", null, null);
        generateItem(translationBuilder, ModItems.COPPER_IRON_INGOT, 0, "Dnilvar Ingot", null, null);
        generateItem(translationBuilder, ModBlocks.ROSE_GOLD_BLOCK, 0, "Block of Rose Gold", null, ROSE_GOLD);
        generateItem(translationBuilder, ModItems.ROSE_GOLD_INGOT, 0, null, null, ROSE_GOLD);
        generateItem(translationBuilder, ModBlocks.IRON_GOLD_BLOCK, 0, "Block of Ferro-Aurium", null, IMPERIAL_ALLOY);
        generateItem(translationBuilder, ModItems.IMPERIAL_ALLOY_INGOT, 0, "Ferro-Aurium Ingot", null, IMPERIAL_ALLOY);
        generateItem(translationBuilder, ModBlocks.TRANSITITE_BLOCK, 0, "Block of Unholy Alloy", null, LIGHT_PURPLE);
        generateItem(translationBuilder, ModItems.TRANSITITE_SHARDS, 0, "Unholy Shards", null, LIGHT_PURPLE);
        generateItem(translationBuilder, ModItems.REDSTONE_CRYSTAL, 0, "Crystallized Redstone", "Sparkles with potential.", BLOOD_RED);
        generateItem(translationBuilder, ModItems.BLOOD_DIAMOND, 0, null, "Chaos itself shines through.", BLOOD_RED);
        generateItem(translationBuilder, ModItems.ASH, 0, "Wither Ash", "Contains traces of dark magic.", TRANQUIL);
        generateItem(translationBuilder, ModItems.TRANQUIL_DUST, 0, "Tranquil Pollen", "Useful in dark alchemy.", TRANQUIL);
        generateItem(translationBuilder, ModBlocks.DARKSTEEL_BLOCK, 0, "Block of Darksteel", null, DARK_PURPLE);
        generateItem(translationBuilder, ModBlocks.DARKENED_STEEL_BLOCK, 0, "Darkened Block of Steel", null, DARK_PURPLE);
        generateItem(translationBuilder, ModItems.DARKSTEEL_INGOT, 0, null, "Reflects only Tranquility's light.", DARK_PURPLE);
        generateItem(translationBuilder, ModBlocks.NUCLEAR_ORE, 0, "Torbernite Ore", null, NUCLEAR);
        generateItem(translationBuilder, ModBlocks.NUCLEAR_BLOCK, 0, "Block of Torbernite", "Do not touch.", NUCLEAR);
        generateItem(translationBuilder, ModBlocks.NUCLEAR_CHARGE, 0, null, "WARNING: Highly destructive.", NUCLEAR);
        generateItem(translationBuilder, ModItems.TORBERNITE_CUBE, 0, null, "Radiates a powerful aura.", NUCLEAR);
        generateItem(translationBuilder, ModItems.ZENITHIUM_CLUSTER, 0, null, "The concentrated essence of a galaxy.", DARK_GREEN);

        generateItem(translationBuilder, ModItems.ANTIMILK, 0, "Doctor Chadd's Ultimate Anti-Milk of Wondrous Effects", "Contains brief, yet unlimited, power.", null);
        generateItem(translationBuilder, ModItems.SALT, 0, null, "Used for keeping meat fresh.", SALT);

        generateMultiple(translationBuilder, 0, null, ModItems.RICE_SEEDS, ModItems.RICE_CAKE);
        generateMultiple(translationBuilder, 0, SHINY_GOLD, ModItems.GOLDEN_RICE_SEEDS, ModItems.GOLDEN_RICE_CAKE);

        generateItem(translationBuilder, ModItems.SUSHI_ROLL, 0, null, null, null);
        generateItem(translationBuilder, ModItems.TORTILLA, 0, null, null, null);
        generateItem(translationBuilder, ModItems.BURRITO, 0, null, null, null);
        generateItem(translationBuilder, ModItems.FRIED_EGG, 0, null, null, null);
        generateItem(translationBuilder, ModItems.PEARFRUIT, 0, null, "As good as gold.", PEARFRUIT);
        generateItem(translationBuilder, ModItems.PEARFRUIT_JUICE, 0, null, null, PEARFRUIT);
        generateItem(translationBuilder, ModItems.APPLE_JUICE, 0, null, null, null);
        generateItem(translationBuilder, ModItems.GOLDEN_APPLE_JUICE, 0, null, null, null);
        generateItem(translationBuilder, ModItems.SWEET_BERRY_JUICE, 0, null, null, null);
        generateItem(translationBuilder, ModItems.MIDAS_FRUIT, 0, null, "22 karats", SHINY_GOLD);
        generateItem(translationBuilder, ModItems.BROWNIE, 0, null, "Comes from outer space?", null);
        generateItem(translationBuilder, ModItems.CHORUS_COBBLER, 0, null, "Memah's favorite recipe", CHORUS);
        generateItem(translationBuilder, ModItems.SANDFISH, 0, null, "This isn't a fish...", DUNE_TAN);
        generateItem(translationBuilder, ModItems.COOKED_SANDFISH, 0, null, "Just like Mama used to make!", DUNE_TAN);
        generateItem(translationBuilder, ModItems.DUNE_EEL, 0, null, "Isn't this a snake?", DUNE_TAN);
        generateItem(translationBuilder, ModItems.SMOKED_FISH, 0, null, null, SMOKED_FISH);

        generateItem(translationBuilder, ModItems.EMPTY_CAN, 0, null, null, null);
        generateItem(translationBuilder, ModItems.BEETROOT_SOUP_CAN, 0, "Can of Beetroot Soup", null, null);
        generateItem(translationBuilder, ModItems.MUSHROOM_STEW_CAN, 0, "Can of Mushroom Stew", null, null);
        generateItem(translationBuilder, ModItems.RABBIT_STEW_CAN, 0, "Can of Rabbit Stew", null, null);
        generateItem(translationBuilder, ModItems.MILK_CAN, 0, "Can of Evaporated Milk", null, null);
        generateItem(translationBuilder, ModItems.COLA_ORANGE, 0, "Can of A&L", null, null);
        generateItem(translationBuilder, ModItems.COLA_GREEN, 0, "Can of Trola-Cola", null, null);
        generateItem(translationBuilder, ModItems.COLA_CYAN, 0, "Can of AquaDei Lite", null, null);

        generateItem(translationBuilder, ModItems.VIOLENT_CATALYST, 0, null, "The essence of eternity.", RED);

        generateItem(translationBuilder, BetaItems.DEMONIC_CORE, 0, "Demonic Core", "Use while crouching to bind to a location!", LIGHT_PURPLE);
        generateItem(translationBuilder, BetaItems.DISTANCE_TRACKER, 0, "Lifeform Tracker", "Right click a mob to track it.", galliumGray);
        generateItem(translationBuilder, ModItems.GALINITE_LENS, 0, null, "Use on certain blocks and entities to gather data on them!", SENTINEL_AQUA);
        generateItem(translationBuilder, ModItems.HARD_LIGHT_PROJECTOR, 0, "Hard Light Projector", null, SENTINEL_AQUA);
        generateItem(translationBuilder, ModItems.CAUTION_HARD_LIGHT_PROJECTOR, 0, "Hard Light Projector", null, GOLD);
        generateItem(translationBuilder, ModItems.SENTINEL_HARD_LIGHT_PROJECTOR, 0, "Hard Light Projector", null, SENTINEL_CRIMSON);
        generateItem(translationBuilder, ModItems.NUCLEAR_ROCKET, 0, null, null, NUCLEAR);
        generateItem(translationBuilder, ModItems.NUCLEAR_DETONATOR, 0, null, "Can activate nuclear charges.", NUCLEAR);
        generateItem(translationBuilder, ModItems.ENERGY_CELL, 0, null, null, null);
        generateItem(translationBuilder, ModItems.GAS_CAPSULE, 0, null, null, GAS_TEST);
        generateItem(translationBuilder, BetaItems.JUMP_DRIVE, 0, null, null, GUNMETAL);
        generateItem(translationBuilder, BetaItems.JETPACK, 0, null, null, BLOOD_RED);

        generateItem(translationBuilder, ModEffectItems.RESISTANCE_ITEM, 0, "Shield Badge", null, GRAY);
        generateItem(translationBuilder, ModEffectItems.FIRE_RESISTANCE_ITEM, 0, "Flaming Badge", null, HELLFIRE);
        generateItem(translationBuilder, ModEffectItems.JUMP_BOOST_ITEM, 0, "Icarus' Gust", null, NUCLEAR);
        //strength_item: Sword Badge
        generateItem(translationBuilder, ModEffectItems.WEAKNESS_ITEM, 0, "Shattered Sword", "A reminder of your past failures.", null);
        //regeneration_item: Ever-Beating Heart
        //water_breathing_item: Bubbles of the Abyss
        //invisibility_item: Vampire's Mirror
        generateItem(translationBuilder, ModEffectItems.DOLPHINS_GRACE_ITEM, 0, "Squishy Foam Dolphin",
                "Its silky skin makes you feel hydrodynamic.", DOLPHIN);
        //conduit_power_item: Eye of the Sea
        //night_vision_item: Night Vision Goggles
        generateItem(translationBuilder, ModEffectItems.HERO_OF_THE_VILLAGE_ITEM, 0, "Hero's Emerald", "Gifted to the one who shall never be forgotten.", NUCLEAR);
        //paladins_badge: Paladin's Badge
        generateItem(translationBuilder, ModEffectItems.GALLIUM_STOMACH, 0, null, "Powers the body.", galliumGray);
        generateItem(translationBuilder, ModEffectItems.ONE_PENCE, 0, "The One Pence", null, COPPER);

        generateItem(translationBuilder, ModBlocks.SUPERFORGE, 0, "Nuclear Superforge", null, NUCLEAR);
        generateItem(translationBuilder, ModBlocks.MODIFICATION_TABLE, 0, null, null, null);
        generateItem(translationBuilder, ModBlocks.RED_BUTTON, 0, "Big Red Button", "\"Whatever you do, don't press it.\"", SENTINEL_CRIMSON);
        generateItem(translationBuilder, ModBlocks.RED_PLATE, 0, "Big Red Pressure Plate", "1500 Megawatt Heavy Duty Super Colliding Super Plate", SENTINEL_CRIMSON);
        generatePot(translationBuilder, ModBlocks.TRANQUIL_ROSE, ModBlocks.POTTED_TRANQUIL_ROSE, 0, null, "Smells delightful.", TRANQUIL);
        generatePot(translationBuilder, ModBlocks.SKULLWEED, ModBlocks.POTTED_SKULLWEED, 0, null, "It's so cold...", SKULLWEED);
        generateItem(translationBuilder, ModBlocks.FEATHERCORN, 0, null, "Soft and warm.", SHINY_GOLD);

        generateItem(translationBuilder, ModItems.SENTINEL_SPAWN_EGG, 0, "Sentinel Spawn Beacon", "A mindless, yet not soulless, killing machine.", galliumGray);
        generateItem(translationBuilder, ModItems.ROOMBA_SPAWN_EGG, 0, "Sentinel Cleaning Droid", "Once a human, now reduced to wiping away garbage.", galliumGray);
        generateItem(translationBuilder, ModItems.FLORBUS_SPAWN_EGG, 0, "Florbus Spawn Sac", null, null);
        generateItem(translationBuilder, ModItems.VENDOR_TOKEN, 0, null, null, VENDOR_TOKEN);
        generateItem(translationBuilder, ModItems.LEGENDARY_TOKEN, 0, null, null, null);

        generateMusicDisc(translationBuilder, ModItems.MUSIC_DISC_ASSASSINATION_UPLOAD, 0, "Galinite Cassette", null, null,
                "Kristoffer Kaufmann - Assassination Upload", ModSounds.ASSASSINATION_UPLOAD);
        generateMusicDisc(translationBuilder, ModItems.MUSIC_DISC_ODE_TO_TRANQUILITY, 0, "Music Disc", null, null,
                "Kristoffer Kaufmann - Ode to Tranquility", ModSounds.ODE_TO_TRANQUILITY);
        generateMusicDisc(translationBuilder, ModItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT, 0, "War-Torn Music Disc", null, null,
                "Kristoffer Kaufmann - Lapse in Judgement", ModSounds.LAPSE_IN_JUDGEMENT);
        generateMusicDisc(translationBuilder, ModItems.MUSIC_DISC_RECITAL, 0, "Aged Cassette", "It's in remarkably good condition.", null,
                "Trevor Skullcrafter - recital", ModSounds.RECITAL);

        generateSound(translationBuilder, ModSounds.FLESH_AMBIENT, "Flesh wriggles");
        generateSound(translationBuilder, ModSounds.BLASTER_SHOOT, "Shot laser");
        generateSound(translationBuilder, ModSounds.PISTOL_RELOAD, "Reloading");
        generateSound(translationBuilder, ModSounds.SHOTGUN_RELOAD, "Reloading");
        generateSound(translationBuilder, ModSounds.SNIPER_RELOAD, "Reloading");
        generateSound(translationBuilder, ModSounds.BIO_RELOAD, "Reloading");
        generateSound(translationBuilder, ModSounds.DATABASE_OPEN, "Codex opened");
        generateSound(translationBuilder, ModSounds.DATABASE_FLIP, "Codex flipped");
        generateSound(translationBuilder, ModSounds.NOTCH_UP, "Powering up");

        generateItem(translationBuilder, ModItems.FERRAURIUM_DARKSTEEL_INGOT, 0, "Hallucium Ingot", "Born from both light and dark.", GREEN);

        translationBuilder.add(trevorssentinels.SENTINELS, "Trevor's Sentinels");
        translationBuilder.add(trevorssentinels.EFFECTS, "Trevor's Effect Items");
        translationBuilder.add(trevorssentinels.BETA, "Trevor's Sentinels - Beta");

        translationBuilder.add("trevorssentinels.database.name", "HoloCodex");
        translationBuilder.add("trevorssentinels.database.desc", "Your guide to this world of magic and technology, this database will store all information that may be useful on your adventure.");

        translationBuilder.add("pillar.trevorssentinels.chaos", "Chaos");
        translationBuilder.add("pillar.trevorssentinels.truth", "Truth");
        translationBuilder.add("pillar.trevorssentinels.power", "Power");
        translationBuilder.add("pillar.trevorssentinels.justice", "Justice");
        translationBuilder.add("pillar.trevorssentinels.balance", "☮ Balance");
        translationBuilder.add("pillar.trevorssentinels.wisdom", "Wisdom");
        translationBuilder.add("pillar.trevorssentinels.tranquility", "☽ Tranquility");
        translationBuilder.add("pillar.trevorssentinels.purity", "Purity");

        translationBuilder.add("item.trevorssentinels.quicksand_bucket", "Quicksand Bucket");
        generateItem(translationBuilder, ModBlocks.DATA_BLOCK, 0, null, null, SENTINEL_AQUA);
        generateItem(translationBuilder, ModBlocks.BLUE_AGILITY_BLOCK, 0, null, null, SENTINEL_AQUA);
        generateItem(translationBuilder, ModBlocks.ORANGE_AGILITY_BLOCK, 0, null, null, GOLD);
        generateItem(translationBuilder, ModBlocks.BLACK_AGILITY_BLOCK, 0, "Steel Magno-Repulsion Block", "Watch your step.", null);
        generateItem(translationBuilder, ModBlocks.LIGHT_CHAMBER_BLOCK, 0, null, null, null);
        generateItem(translationBuilder, ModBlocks.DARK_CHAMBER_BLOCK, 0, null, null, null);

        generateItem(translationBuilder, ModBlocks.STEEL_BLOCK, 0, "Block of Steel", null, null);
        generateItem(translationBuilder, ModBlocks.CAUTION_STEEL_BLOCK, 0, "Caution-Pattern Block of Steel", null, null);
        generateItem(translationBuilder, ModBlocks.RUSTED_STEEL_BLOCK, 0, "Rusted Block of Steel", null, null);
        generateItem(translationBuilder, ModBlocks.STAINLESS_STEEL_BLOCK, 0, null, null, null);
        generateItem(translationBuilder, ModBlocks.WAX_INFUSED_COPPER_BLOCK, 0, "Wax-Infused Block of Copper", null, null);
        generateItem(translationBuilder, ModBlocks.STEEL_LAMP_BLOCK, 0, "Steel Industrial Lamp", null, null);
        generateItem(translationBuilder, ModBlocks.STEEL_FAN, 0, "Steel Industrial Fan", null, null);
        generateItem(translationBuilder, ModBlocks.BATTERY, 0, null, null, null);
        generateItem(translationBuilder, ModBlocks.FUSEBOX, 0, null, null, null);
        generateItem(translationBuilder, ModBlocks.STEEL_LADDER, 0, null, null, null);
        generateItem(translationBuilder, ModBlocks.VENDOR, 0, null, null, null);
        generateItem(translationBuilder, ModBlocks.FANCY_COMPUTER, 0, null, null, null);
        generateItem(translationBuilder, ModItems.STEEL_SIGN, 0, null, null, null);
        generateItem(translationBuilder, ModItems.HOLOGRAPHIC_BLUE_SIGN, 0, "Steel Holographic Sign", null, null);

        generateItem(translationBuilder, ModBlocks.HARD_LIGHT, 0, "Hard Light", null, SENTINEL_AQUA);
        generateItem(translationBuilder, ModBlocks.CAUTION_HARD_LIGHT, 0, "Hard Light", null, GOLD);
        generateItem(translationBuilder, ModBlocks.SENTINEL_HARD_LIGHT, 0, "Hard Light", null, SENTINEL_CRIMSON);
        generateItem(translationBuilder, ModBlocks.HARD_LIGHT_BARRIER, 0, "Hard Light Barrier", "Creative only!", SENTINEL_AQUA);
        generateItem(translationBuilder, ModBlocks.CAUTION_HARD_LIGHT_BARRIER, 0, "Hard Light Barrier", "Creative only!", GOLD);
        generateItem(translationBuilder, ModBlocks.SENTINEL_HARD_LIGHT_BARRIER, 0, "Hard Light Barrier", "Creative only!", SENTINEL_CRIMSON);

        generateMultiple(translationBuilder, 0, null, ModBlocks.CRACKED_END_STONE_BRICKS, ModBlocks.CHISELED_END_STONE_BRICKS, ModBlocks.END_STONE_BRICK_COLUMN);
        generateMultiple(translationBuilder, 0, SNOWSTONE, ModBlocks.SNOWSTONE, ModBlocks.SNOWSTONE_STAIRS, ModBlocks.SNOWSTONE_SLAB, ModBlocks.SNOWSTONE_WALL,
                ModBlocks.SMOOTH_SNOWSTONE, ModBlocks.SMOOTH_SNOWSTONE_STAIRS, ModBlocks.SMOOTH_SNOWSTONE_SLAB, ModBlocks.SMOOTH_SNOWSTONE_WALL, ModBlocks.CUT_SNOWSTONE,
                ModBlocks.CUT_SNOWSTONE_SLAB, ModBlocks.CHISELED_SNOWSTONE);
        generateMultiple(translationBuilder, 0, null, ModBlocks.MOSS_STAIRS, ModBlocks.MOSS_SLAB, ModBlocks.OVERGROWN_GRASS_BLOCK, ModBlocks.GRASS_STAIRS, ModBlocks.GRASS_SLAB,
                ModBlocks.DIRT_STAIRS, ModBlocks.DIRT_SLAB, ModBlocks.COARSE_DIRT_STAIRS, ModBlocks.COARSE_DIRT_SLAB);

        generateMultiple(translationBuilder, 0, null, ModBlocks.RICE_PLANT, ModBlocks.RICE_BLOCK);
        generateMultiple(translationBuilder, 0, null, ModBlocks.GOLDEN_RICE_PLANT, ModBlocks.GOLDEN_RICE_BLOCK);

        translationBuilder.add("death.attack.redstoned", "%1$s gave into the pain");
        translationBuilder.add("death.attack.infested", "%1$s didn't make it");
        translationBuilder.add("death.attack.irradiated", "%1$s ate one too many bananas");

        translationBuilder.add("key.category.trevorssentinels.trevorssentinels", "Trevor's Sentinels");
        translationBuilder.add("key.trevorssentinels.style_switch", "Style Switch");
        translationBuilder.add("key.trevorssentinels.reload", "Reload");

        translationBuilder.add("color.rarity.minecraft.uncommon", String.valueOf(YELLOW.getRGB()));
        translationBuilder.add("color.rarity.minecraft.rare", String.valueOf(AQUA.getRGB()));
        translationBuilder.add("color.rarity.minecraft.epic", String.valueOf(GREEN.getRGB()));

        generateNumbered(translationBuilder, MOD_ID+".worldLevelTooLow.", "",
                "Demonic power has too much of a hold over the world!", "The power is too strong!");
        generateNumbered(translationBuilder, "color."+MOD_ID+".worldLevelTooLow.", "", String.valueOf(LIGHT_PURPLE.getRGB()), String.valueOf(BLUE.getRGB()));
        translationBuilder.add(MOD_ID+".worldLevelTooLow.other", "A mysterious force pushes back!");

        translationBuilder.add(ModEntities.GALLIUM_SHARD, ModItems.SCRAP_METAL_SHARD.getTranslationKey());
        translationBuilder.add(ModEntities.LASER, "Laser Bolt");
        translationBuilder.add(ModEntities.GRENADE, "Delayed Bomb");
        translationBuilder.add(ModEntities.NUCLEAR_CHARGE, ModBlocks.NUCLEAR_CHARGE.getTranslationKey());
        translationBuilder.add(ModEntities.SENTINEL, "Sentinel");
        translationBuilder.add(ModEntities.GALINITE_ROOMBA, "Sentinel Cleaning Droid");
        translationBuilder.add(ModEntities.FLORBUS, "Florbus");
        translationBuilder.add("entity.minecraft.villager.attendant", "§6Engineer");
        translationBuilder.add("entity.minecraft.villager.demolitionist", "§cDemolitionist");
        translationBuilder.add("entity.minecraft.villager.astronomer", "§bAstronomer");
        translationBuilder.add("entity.minecraft.villager.monk", "§aMonk");
        translationBuilder.add("entity.minecraft.villager.officer", "§eOfficer");
        translationBuilder.add("entity.minecraft.villager.cultist_merchant", "§dCultist Merchant");

        generateSetBonus(translationBuilder, ModArmorMaterials.GUNMETAL, "Set Bonus: Night Vision", SENTINEL_AQUA);
        generateSetBonus(translationBuilder, ArmorMaterials.IRON, "Set Bonus: Resistance", DUNE_TAN);
        generateSetBonus(translationBuilder, ModArmorMaterials.TRANSITITE, "Set Bonus: Regeneration", FLESH_PINK);
        generateSetBonus(translationBuilder, ArmorMaterials.DIAMOND, "Set Bonus: Luck", AQUA);
        generateSetBonus(translationBuilder, ArmorMaterials.NETHERITE, "Set Bonus: Fire Resistance", HELLFIRE);
        generateSetBonus(translationBuilder, ModArmorMaterials.NUCLEAR, "Set Bonus: Sneak to Fly, Sprint to Hover", GUNMETAL);
        generateSetBonus(translationBuilder, ModArmorMaterials.JETBLACK, "Set Bonus: Gradual Absorption", GOLD);

        translationBuilder.add("gamerule.trevorssentinels:useVelocityFallDamage", "Use velocity-based fall damage");
        translationBuilder.add("gamerule.trevorssentinels:useVelocityFallDamage.description", "If enabled, fall damage will be calculated based on velocity.");
        translationBuilder.add("gamerule.trevorssentinels:milkCuresPotionEffects", "Drinking milk cures potion effects");
        //translationBuilder.add("gamerule.trevorssentinels:milkCuresPotionEffects.description", "If enabled, fall damage will be calculated based on velocity.");

        translationBuilder.add("tooltip." + MOD_ID + ".style", "Style: ");
        translationBuilder.add("tooltip." + MOD_ID + ".mode", "Mode: ");
        generateNumbered(translationBuilder, "tooltip." + MOD_ID + ".style_switch.", " to switch style.", " to cycle modes.");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".pappym_blade.", "Trickster", "Paladin", "Predator", "Guardian");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".thanatu_blade.", "Riftwalker", "Riftcaller");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".lilith_blade.", "Holy Retribution", "LEAVE NOTHING ALIVE.");

        if (dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").isPresent()) try {
            translationBuilder.add(dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").get());
        } catch (Exception e) { throw new RuntimeException("Failed to add existing language file!", e); }
    }
}