package net.trevorskullcrafter.trevorssentinels.data;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemConvertible;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Language;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class EnglishLangGenerator extends FabricLanguageProvider {
    public EnglishLangGenerator(FabricDataOutput dataOutput) { super(dataOutput, "en_us"); }

    @Contract(pure = true) public static @NotNull Text getColoredText(String textContent, String color) { Style style = Style.EMPTY;
        try { style = style.withColor((TextColor) Class.forName("com.anthonyhilyard.prism.util.ConfigHelper").getMethod("parseColor", Object.class).invoke(null, color));} catch(Exception e) {
            if (color != null)
                style = style.withColor(TextColor.parse(color.substring(color.contains("#") ? color.indexOf("#") : 0, color.contains("_") ?
                        color.indexOf("_", color.indexOf("#")) : color.length())));
        }
        return getStyledText(textContent, style);
    }

    public void generateArmory(TranslationBuilder translationBuilder){
        generateEquipmentSet(translationBuilder, "Flimsy Galinite", galiniteGray, null, null, null, null,
                ModArmory.FLIMSY_GALINITE_SWORD, null, ModArmory.FLIMSY_GALINITE_PICKAXE, null, null, null);
        generateItem(translationBuilder, ModArmory.FLIMSY_GALINITE_HELMET, 0, "Flimsy Galinite Hat", "\"I will be the king of the sentinels!\"", galiniteGray);
        generateItem(translationBuilder, ModArmory.FLIMSY_GALINITE_CHESTPLATE, 0, "Flimsy Galinite Chestplate", "One size larger and this'd snap right off.", galiniteGray);
        generateItem(translationBuilder, ModArmory.FLIMSY_GALINITE_LEGGINGS, 0, "Flimsy Galinite Loincloth", "Just try not to wiggle.", galiniteGray);
        generateItem(translationBuilder, ModArmory.FLIMSY_GALINITE_BOOTS, 0, "Flimsy Galinite Sabatons", "Like walking on a razor-sharp cloud.", galiniteGray);
        generateItem(translationBuilder, ModArmory.FLIMSY_GALINITE_DAGGER, 0, "Flimsy Galinite Shiv", null, galiniteGray);
        generateItem(translationBuilder, ModArmory.FLIMSY_GALINITE_AXE, 0, "Flimsy Galinite Hatchet", null, galiniteGray);
        generateItem(translationBuilder, ModArmory.FLIMSY_GALINITE_SHOVEL, 0, "Flimsy Galinite Spade", null, galiniteGray);
        generateItem(translationBuilder, ModArmory.FLIMSY_GALINITE_HOE, 0, "Flimsy Galinite Scythe", null, galiniteGray);

        generateEquipmentSet(translationBuilder, "Galinite", galinite, null, null, null, null,
                ModArmory.GALINITE_SWORD, ModArmory.GALINITE_DAGGER, ModArmory.GALINITE_PICKAXE, null, null, null);
        generateItem(translationBuilder, ModArmory.GALINITE_HELMET, 0, "Galinite Visor", "\"J.A.R.V.I.S., you there?\"", galinite);
        generateItem(translationBuilder, ModArmory.GALINITE_CHESTPLATE, 0, "Galinite Cuirass", "Arm-shield functionality not guaranteed.", galinite);
        generateItem(translationBuilder, ModArmory.GALINITE_LEGGINGS, 0, "Galinite Kilt", "\"Eht's noht a dhress, eht's a keilt!\"", galinite);
        generateItem(translationBuilder, ModArmory.GALINITE_BOOTS, 0, "Galinite Sabatons", "heh... feet.", galinite);
        generateItem(translationBuilder, ModArmory.GALINITE_CHAINSAW, 0, "Galinite Chainsaw", "Right click to launch shards at enemies!", galinite);
        generateItem(translationBuilder, ModArmory.GALINITE_SHOVEL, 0, "Galinite Spade", null, galinite);
        generateItem(translationBuilder, ModArmory.GALINITE_HOE, 0, "Galinite Scythe", null, galinite);

        generateEquipmentSet(translationBuilder, "Rose Gold", rose_gold, null, null, null, null,
                ModArmory.ROSE_GOLD_SWORD, ModArmory.ROSE_GOLD_DAGGER, ModArmory.ROSE_GOLD_PICKAXE, null, null, null);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_HELMET, 0, "Rose Gold Helm", "Hides your rosy cheeks.", rose_gold);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_CHESTPLATE, 0, "Rose Gold Cuirass", "Guaranteed 100% thorn-free.", rose_gold);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_LEGGINGS, 0, "Rose Gold Leggings", "Flowery skirt not included", rose_gold);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_BOOTS, 0, "Rose Gold Sabatons", "Petal to the metal!", rose_gold);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_AXE, 0, "Rose Gold Battleaxe", null, rose_gold);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_SHOVEL, 0, "Rose Gold Spade", null, rose_gold);
        generateItem(translationBuilder, ModArmory.ROSE_GOLD_HOE, 0, "Rose Gold Scythe", null, rose_gold);

        generateEquipmentSet(translationBuilder, "Industrial", trimetal, ModArmory.TRIMETAL_HELMET, null, null, null, null,
                null, null, null, ModArmory.TRIMETAL_SHOVEL, ModArmory.TRIMETAL_HOE);
        generateItem(translationBuilder, ModArmory.TRIMETAL_CHESTPLATE, 0, "Industrial Harness", "Bulletproof... maybe.", trimetal);
        generateItem(translationBuilder, ModArmory.TRIMETAL_LEGGINGS, 0, "Industrial Leg Guards", "Good for sports and combat!", trimetal);
        generateItem(translationBuilder, ModArmory.TRIMETAL_BOOTS, 0, "Industrial Boots", "These boots were made for walking...", trimetal);
        generateItem(translationBuilder, ModArmory.TRIMETAL_SWORD, 0, "Industrial Crowbar", "Rise, and... shine.", trimetal);
        generateItem(translationBuilder, ModArmory.TRIMETAL_DAGGER, 0, "Industrial Knife", null, trimetal);
        generateItem(translationBuilder, ModArmory.TRIMETAL_PICKAXE, 0, "Industrial Drill", null, trimetal);
        generateItem(translationBuilder, ModArmory.TRIMETAL_AXE, 0, "Industrial Cleaver", null, trimetal);

        generateEquipmentSet(translationBuilder, "Unholy", animPurple, ModArmory.TRANSITITE_HELMET, ModArmory.TRANSITITE_CHESTPLATE, ModArmory.TRANSITITE_LEGGINGS,
                ModArmory.TRANSITITE_BOOTS, ModArmory.TRANSITITE_SWORD, ModArmory.TRANSITITE_DAGGER, ModArmory.TRANSITITE_PICKAXE, ModArmory.TRANSITITE_AXE,
                ModArmory.TRANSITITE_SHOVEL, null);
        generateItem(translationBuilder, ModArmory.TRANSITITE_HOE, 0, "Unholy Scythe", null, animPurple);

        /*generateItem(translationBuilder, ModArmory.HUNTERS_VISOR, 0, "Hunter's Visor", "A good hunter sees everything.", hunter);
        generateItem(translationBuilder, ModArmory.HUNTERS_TORSO, 0, "Hunter's Torso", "A good hunter knows how to protect themselves.", hunter);
        generateItem(translationBuilder, ModArmory.HUNTERS_LEGS, 0, "Hunter's Legs", "A good hunter protects their valuables.", hunter);
        generateItem(translationBuilder, ModArmory.HUNTERS_BOOTS, 0, "Hunter's Boots", "A good hunter shows no weakness.", hunter);*/

        generateEquipmentSet(translationBuilder, "Darksteel", darksteel, ModArmory.DARKSTEEL_HELMET, ModArmory.DARKSTEEL_CHESTPLATE, ModArmory.DARKSTEEL_LEGGINGS,
                null, ModArmory.DARKSTEEL_SWORD, ModArmory.DARKSTEEL_DAGGER, ModArmory.DARKSTEEL_PICKAXE, ModArmory.DARKSTEEL_AXE, null, null);
        generateItem(translationBuilder, ModArmory.DARKSTEEL_BOOTS, 0, "Darksteel Sabatons", null, darksteel);
        generateItem(translationBuilder, ModArmory.DARKSTEEL_SHOVEL, 0, "Darksteel Spade", null, darksteel);
        generateItem(translationBuilder, ModArmory.DARKSTEEL_HOE, 0, "Darksteel Scythe", null, darksteel);

        generateEquipmentSet(translationBuilder, "Nuclear", animGreen, null, ModArmory.NUCLEAR_CHESTPLATE, ModArmory.NUCLEAR_LEGGINGS, null,
                null, null, null, ModArmory.NUCLEAR_AXE, ModArmory.NUCLEAR_SHOVEL, null);
        generateItem(translationBuilder, ModArmory.NUCLEAR_HELMET, 0, "Nuclear Visor", null, animGreen);
        generateItem(translationBuilder, ModArmory.NUCLEAR_BOOTS, 0, "Nuclear Sabatons", null, animGreen);
        generateItem(translationBuilder, ModArmory.NUCLEAR_SWORD, 0, "Nuclear Sword", "Irradiates enemies.", animGreen);
        generateItem(translationBuilder, ModArmory.NUCLEAR_DAGGER, 0, "Crystallized Dagger", null, animGreen);
        generateItem(translationBuilder, ModArmory.NUCLEAR_PICKAXE, 0, "Nuclear Drill", null, animGreen);
        generateItem(translationBuilder, ModArmory.NUCLEAR_HOE, 0, "Nuclear Scythe", null, animGreen);

        generateEquipmentSet(translationBuilder, "Nanotech", rainbow, ModArmory.NANOTECH_HELMET, ModArmory.NANOTECH_CHESTPLATE, ModArmory.NANOTECH_LEGGINGS,
                ModArmory.NANOTECH_BOOTS, null, ModArmory.NANOTECH_DAGGER, ModArmory.NANOTECH_PICKAXE, ModArmory.NANOTECH_AXE, ModArmory.NANOTECH_SHOVEL, null);
        generateItem(translationBuilder, ModArmory.NANOTECH_SWORD, 0, "Nanotech Sword", "\"I've even forgotten my name...\"", rainbow);
        generateItem(translationBuilder, ModArmory.NANOTECH_HOE, 0, "Nanotech Scythe", null, rainbow);

        generateEquipmentSet(translationBuilder, "Zenithium", zenithium, null, null, null, null, ModArmory.ZENITHIUM_SWORD,
                ModArmory.ZENITHIUM_DAGGER, ModArmory.ZENITHIUM_PICKAXE, ModArmory.ZENITHIUM_AXE, ModArmory.ZENITHIUM_SHOVEL, ModArmory.ZENITHIUM_HOE);
        generateItem(translationBuilder, BetaItems.BLACKSMITHS_WELDING_MASK, 0, "Blacksmith's Welding Mask", null, zenithium);
        generateItem(translationBuilder, BetaItems.MAD_SCIENTISTS_LAB_COAT, 0, "Mad Scientist's Lab Coat", null, zenithium);
        generateItem(translationBuilder, ModArmory.ZENITHIUM_CHESTPLATE, 0, "Zenithium Chestplate", "\"Honey, where's my super suit?\"", zenithium);
        generateItem(translationBuilder, ModArmory.ZENITHIUM_LEGGINGS, 0, "Zenithium Leggings", "Gaming pants!", zenithium);
        generateItem(translationBuilder, ModArmory.SKYHOPPERS, 0, "Utaricorp™ SkyHoppers", "Get your head into the clouds!", zenithium);
        generateItem(translationBuilder, BetaItems.PAPPYM_BLADE, 0, "Jade Seraphim",
                "Passed down through ancient tradition... and now it has found its way to you.", newColor("#EFFFA0", "#CCFFAA"));
        generateItem(translationBuilder, BetaItems.PAPPYD_BLADE, 0, "Hell's Flaming Fury", null, hellfire);
        generateItem(translationBuilder, BetaItems.THANATU_BLADE, 0, "Harmonious Rapture", null, animPurple);
        generateItem(translationBuilder, BetaItems.MORPHEUS_BLADE, 0, "Thunderous Legacy", null, animAqua);
        generateItem(translationBuilder, BetaItems.SKYLAR_BLADE, 0, "Equitous Retribution", null, shiny_gold);
        generateItem(translationBuilder, BetaItems.LILITH_BLADE, 0, "Unwavering Judgement", null, dune_tan);
        generateItem(translationBuilder, BetaItems.TREVOR_BLADE, 0, "blade_null", null, sentiBlue);
        generateItem(translationBuilder, BetaItems.KINGS_BLADE, 0, "Stainless Resolve", null, null);
        generateItem(translationBuilder, ModArmory.SCARA_SHEARS, 0, "SCARA Shears", "A military-grade threat.", darksteel);

        generateItem(translationBuilder, ModArmory.THANATU_SKULL, 0, "Thanatu's Exoskull", "The skull of the demon king.", animPurple);
        generateItem(translationBuilder, ModArmory.THANATU_SHOULDERPADS, 0, "Thanatu's Shoulderpads", "There's no way these protect anything", animPurple);

        generateItem(translationBuilder, ModArmory.LASER_PISTOL, 0, "UNMA-28 Comet", "\"Fast and portable!\"", gunmetal);
        generateItem(translationBuilder, ModArmory.LASER_TASER, 0, "CCPD-23 Taser", "\"Non-lethal!\"", animAqua);
        generateItem(translationBuilder, ModArmory.LASER_SNIPER_ECHO, 0, "UNMA-52 Echo", "\"They'll never see it coming!\"", dune_tan);
        generateItem(translationBuilder, ModArmory.LASER_MINIGUN, 0, "UTARI-91 Serenity", "\"Keep the peace!\"", animBlue);
        generateItem(translationBuilder, ModArmory.LASER_MINIGUN, 1, "UTARI-91 Serenity", "\"America! Hell yeah!\"", patriot);
        generateItem(translationBuilder, ModArmory.LASER_RIFLE, 0, "UNMA-63 Agnostyk", "\"Packs a punch!\"", "1_#6b892e_#485d26");
        generateItem(translationBuilder, ModArmory.LASER_SHOTGUN, 0, "KHAOS-66 Tremor", "\"Rip and tear!\"", hellfire);
        generateItem(translationBuilder, ModArmory.LASER_HEALER, 0, "UTARI-49 Firebird", "\"Those who can't do, heal!\"", shiny_gold);
        generateItem(translationBuilder, ModArmory.LASER_SNIPER, 0, "MW88 Shadow", "\"The assassin's weapon of choice!\"", animPurple);
        generateItem(translationBuilder, ModArmory.LASER_SPREADER, 0, "MW76 Pandemic", "\"Filled with a toxic bioweapon.\"", animGreen);
        generateItem(translationBuilder, ModArmory.LASER_REVOLVER, 0, "Drunkard's Handcannon", "\"But you have heard of me!\"", "#C4A484");
        generateItem(translationBuilder, ModArmory.VILE_SPITTER, 0, "Vile Spitter", "\"Behold, the wrath of Xirang!\"", flesh_pink);
        generateItem(translationBuilder, BetaItems.COPPER_ARM, 0, "Hand of the Goddess", "Contains the soul of a powerful being.", copper);
    }
    public void generateAdvancements(TranslationBuilder translationBuilder){
        generateAdvancement(translationBuilder, "trevorssentinels", "Trevor's Sentinels", "Acquire a shard of galinite");
        generateAdvancement(translationBuilder, "brownie", "This Edible Ain't Shi-", "Consume a brownie");
        generateAdvancement(translationBuilder, "chainsaw_man", "チェンソーマン", "Craft a chainsaw");
        generateAdvancement(translationBuilder, "ferraurium", "Will of Iron, Heart of Gold", "Acquire an ingot of Ferro-Aurium");
        generateAdvancement(translationBuilder, "forge", "Forging Ahead", "Acquire a forge to harness the power of alloys");
        generateAdvancement(translationBuilder, "trimetal", "Detrimetal", "Acquire any industrial-tier item");
        generateAdvancement(translationBuilder, "rose_gold", "False Belief", "Acquire an ingot of Rose Gold");
        generateAdvancement(translationBuilder, "rose_gold_2", "False Hope", "Craft equipment made from Rose Gold");
        generateAdvancement(translationBuilder, "thanatu", "False Idol", "Acquire the tools of the demon lord");
        generateAdvancement(translationBuilder, "netherite", "I Can't Believe It's Not Darksteel", "Acquire an N-7 alloy item");
        generateAdvancement(translationBuilder, "spf", "SPF 50+", "Obtain a Banana Boat");
        generateAdvancement(translationBuilder, "uranium", "Keep Away From Face", "Acquire a cube of Torbernite");
        generateAdvancement(translationBuilder, "superforge", "Master Forger", "Acquire a superforge");
        generateAdvancement(translationBuilder, "zenithium", "Infinity Squared", "Acquire a cluster of Zenithium");
        generateAdvancement(translationBuilder, "heretic", "Heretic", "Burn fabric in a forge");
        generateAdvancement(translationBuilder, "bacon_and_eggs", "Bacon and Eggs", "Part of a complete breakfast!");
    }
    public void generateStatusEffects(TranslationBuilder translationBuilder){
        translationBuilder.add(ModEffects.REDSTONED, "Redstoned");
        translationBuilder.add(ModEffects.FLIGHT, "Flight");
        translationBuilder.add(ModEffects.WELL_FED, "Well-Fed");
        translationBuilder.add(ModEffects.COSMIC_FIRE, "Cosmic Flame");
        translationBuilder.add(ModEffects.INFESTED, "☣ Infested ☣");
        translationBuilder.add(ModEffects.IRRADIATED, "☢ Irradiated ☢");
    }
    public void generateMisc(TranslationBuilder translationBuilder){
        translationBuilder.add("color.rarity.minecraft.uncommon", newColor("#EFFFA0", "#CCFFAA"));
        translationBuilder.add("color.rarity.minecraft.rare", newColor(aqua, "#3BBCE9"));
        translationBuilder.add("color.rarity.minecraft.epic", rainbow);

        translationBuilder.add(ModEntities.GALINITE_SHARD, ModItems.GALINITE_SHARD.getTranslationKey());
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

        generateSetBonus(translationBuilder, ModArmorMaterials.GALINITE, "Set Bonus: Night Vision", sentiBlue);
        generateSetBonus(translationBuilder, ArmorMaterials.IRON, "Set Bonus: Resistance", dune_tan);
        generateSetBonus(translationBuilder, ModArmorMaterials.TRANSITITE, "Set Bonus: Regeneration", flesh_pink);
        generateSetBonus(translationBuilder, ArmorMaterials.DIAMOND, "Set Bonus: Luck", animBlue);
        generateSetBonus(translationBuilder, ArmorMaterials.NETHERITE, "Set Bonus: Fire Resistance", hellfire);
        generateSetBonus(translationBuilder, ModArmorMaterials.NUCLEAR, "Set Bonus: Sneak to Fly, Sprint to Hover", gunmetal);
        generateSetBonus(translationBuilder, ModArmorMaterials.NANOTECH, "Set Bonus: Gradual Absorption", animYellow);
    }

    @Override public void generateTranslations(TranslationBuilder translationBuilder) {
        generateArmory(translationBuilder); generateAdvancements(translationBuilder); generateStatusEffects(translationBuilder); generateMisc(translationBuilder);

        generateWoodTranslations(translationBuilder, "Yggdrasil", newColor("#eae1e5", "#846977"), ModBlocks.YGGDRASIL_LOG, ModBlocks.YGGDRASIL_WOOD,
                ModBlocks.STRIPPED_YGGDRASIL_LOG, ModBlocks.STRIPPED_YGGDRASIL_WOOD, ModBlocks.YGGDRASIL_PLANKS, ModBlocks.YGGDRASIL_LEAVES, ModBlocks.YGGDRASIL_SAPLING,
                ModBlocks.POTTED_YGGDRASIL_SAPLING, ModBlocks.YGGDRASIL_SLAB, ModBlocks.YGGDRASIL_STAIRS, ModBlocks.YGGDRASIL_FENCE, ModBlocks.YGGDRASIL_FENCE_GATE,
                ModBlocks.YGGDRASIL_BUTTON, ModBlocks.YGGDRASIL_PRESSURE_PLATE, ModBlocks.YGGDRASIL_DOOR, ModBlocks.YGGDRASIL_TRAPDOOR, ModItems.YGGDRASIL_SIGN,
                ModItems.YGGDRASIL_HANGING_SIGN, ModItems.YGGDRASIL_BOAT, ModItems.YGGDRASIL_CHEST_BOAT);
        generateWoodTranslations(translationBuilder, "Charred Oak", newColor("#494949", "#252525"), ModBlocks.CHARRED_OAK_LOG, ModBlocks.CHARRED_OAK_WOOD,
                ModBlocks.STRIPPED_CHARRED_OAK_LOG, ModBlocks.STRIPPED_CHARRED_OAK_WOOD, ModBlocks.CHARRED_OAK_PLANKS, null, null, null,
                ModBlocks.CHARRED_OAK_SLAB, ModBlocks.CHARRED_OAK_STAIRS, ModBlocks.CHARRED_OAK_FENCE, ModBlocks.CHARRED_OAK_FENCE_GATE, ModBlocks.CHARRED_OAK_BUTTON,
                ModBlocks.CHARRED_OAK_PRESSURE_PLATE, ModBlocks.CHARRED_OAK_DOOR, ModBlocks.CHARRED_OAK_TRAPDOOR, ModItems.CHARRED_OAK_SIGN, ModItems.CHARRED_OAK_HANGING_SIGN,
                ModItems.CHARRED_OAK_BOAT, ModItems.CHARRED_OAK_CHEST_BOAT);
        generateWoodTranslations(translationBuilder, "Midas", newColor("#beab27", "#47320e"), ModBlocks.MIDAS_LOG, ModBlocks.MIDAS_WOOD,
                ModBlocks.STRIPPED_MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_WOOD, ModBlocks.MIDAS_PLANKS, ModBlocks.MIDAS_LEAVES, ModBlocks.MIDAS_SAPLING,
                ModBlocks.POTTED_MIDAS_SAPLING, ModBlocks.MIDAS_SLAB, ModBlocks.MIDAS_STAIRS, ModBlocks.MIDAS_FENCE, ModBlocks.MIDAS_FENCE_GATE, ModBlocks.MIDAS_BUTTON,
                ModBlocks.MIDAS_PRESSURE_PLATE, ModBlocks.MIDAS_DOOR, ModBlocks.MIDAS_TRAPDOOR, ModItems.MIDAS_SIGN, ModItems.MIDAS_HANGING_SIGN, ModItems.MIDAS_BOAT,
                ModItems.MIDAS_CHEST_BOAT);
        generateWoodTranslations(translationBuilder, "Viridescent", newColor("#75892e", "#56731f"), ModBlocks.BANANA_LOG, ModBlocks.BANANA_WOOD,
                ModBlocks.STRIPPED_BANANA_LOG, ModBlocks.STRIPPED_BANANA_WOOD, ModBlocks.BANANA_PLANKS, ModBlocks.BANANA_LEAVES, ModBlocks.BANANA_SAPLING,
                ModBlocks.POTTED_BANANA_SAPLING, ModBlocks.BANANA_SLAB, ModBlocks.BANANA_STAIRS, ModBlocks.BANANA_FENCE, ModBlocks.BANANA_FENCE_GATE,
                ModBlocks.BANANA_BUTTON, ModBlocks.BANANA_PRESSURE_PLATE, ModBlocks.BANANA_DOOR, ModBlocks.BANANA_TRAPDOOR, ModItems.BANANA_SIGN,
                ModItems.BANANA_HANGING_SIGN, ModItems.BANANA_BOAT, ModItems.BANANA_CHEST_BOAT);
        generateWoodTranslations(translationBuilder, "Cerulii", newColor("#117bcd", "#1558bc"), ModBlocks.CERULII_LOG, ModBlocks.CERULII_WOOD,
                ModBlocks.STRIPPED_CERULII_LOG, ModBlocks.STRIPPED_CERULII_WOOD, ModBlocks.CERULII_PLANKS, ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SAPLING,
                ModBlocks.POTTED_CERULII_SAPLING, ModBlocks.CERULII_SLAB, ModBlocks.CERULII_STAIRS, ModBlocks.CERULII_FENCE, ModBlocks.CERULII_FENCE_GATE,
                ModBlocks.CERULII_BUTTON, ModBlocks.CERULII_PRESSURE_PLATE, ModBlocks.CERULII_DOOR, ModBlocks.CERULII_TRAPDOOR, ModItems.CERULII_SIGN,
                ModItems.CERULII_HANGING_SIGN, ModItems.CERULII_BOAT, ModItems.CERULII_CHEST_BOAT);

        generateItem(translationBuilder, ModItems.BANANA, 0, "Banana", null, gold);
        generateItem(translationBuilder, ModItems.RED_BANANA, 0, "Red Banana", null, sentiRed);
        generateItem(translationBuilder, ModItems.BLUE_JAVA_BANANA, 0, "Blue Java Banana", null, sentiBlue);
        generateItem(translationBuilder, ModItems.BANANA_BREAD, 0, "Banana Bread", null, gold);
        generateItem(translationBuilder, ModItems.RED_BANANA_BREAD, 0, "Red Banana Bread", null, sentiRed);
        generateItem(translationBuilder, ModItems.BLUE_JAVA_BANANA_BREAD, 0, "Blue Java Banana Bread", null, sentiBlue);

        generateItem(translationBuilder, ModBlocks.FLESH_BLOCK, 0, "Flesh Block", "It's strangely warm...", flesh_pink);
        generateItem(translationBuilder, ModBlocks.FLESH_VEINS, 0, "Fleshy Veins", "They're spreading...", flesh_pink);
        generateItem(translationBuilder, ModBlocks.FLESHY_EYE, 0, "Fleshy Eye", "It's staring...", flesh_pink);

        generateItem(translationBuilder, ModItems.DUBIOUS_BACON, 0, "Dubious Bacon", "Don't ask where it came from.", flesh_pink);
        generateItem(translationBuilder, ModItems.RUINOUS_GAZE, 0, "Eye of Ruin", "Its gaze is troubling...", flesh_pink);

        generateItem(translationBuilder, ModBlocks.GALINITE_BLOCK, 0, "Galinite Block", null, galiniteGray);
        generateItem(translationBuilder, ModBlocks.CHISELED_GALINITE_BLOCK, 0, "Chiseled Galinite Block", null, galiniteGray);
        generateItem(translationBuilder, ModBlocks.GALINITE_PILLAR, 0, "Galinite Pillar", null, galiniteGray);
        generateItem(translationBuilder, ModItems.GALINITE_SHARD, 0, "Galinite Shard", null, galiniteGray);
        generateItem(translationBuilder, ModItems.GALINITE_INGOT, 0, "Galinite Bar", null, galiniteGray);
        generateItem(translationBuilder, ModItems.STEEL_INGOT, 0, "Steel Ingot", null, null);
        generateItem(translationBuilder, ModItems.GUNMETAL_INGOT, 0, "Gunmetal Ingot", null, gunmetal);
        generateItem(translationBuilder, ModBlocks.COPPER_IRON_BLOCK, 0, "Block of Dnilvar", null, null);
        generateItem(translationBuilder, ModItems.COPPER_IRON_INGOT, 0, "Dnilvar Ingot", null, null);
        generateItem(translationBuilder, ModBlocks.ROSE_GOLD_BLOCK, 0, "Block of Rose Gold", null, rose_gold);
        generateItem(translationBuilder, ModItems.ROSE_GOLD_INGOT, 0, "Rose Gold Ingot", null, rose_gold);
        generateItem(translationBuilder, ModBlocks.IRON_GOLD_BLOCK, 0, "Block of Ferro-Aurium", null, iron_gold);
        generateItem(translationBuilder, ModItems.IRON_GOLD_INGOT, 0, "Ferro-Aurium Ingot", null, iron_gold);
        generateItem(translationBuilder, ModBlocks.TRANSITITE_BLOCK, 0, "Block of Unholy Alloy", null, animPurple);
        generateItem(translationBuilder, ModItems.TRANSITITE_SHARDS, 0, "Unholy Shards", null, animPurple);
        generateItem(translationBuilder, ModItems.REDSTONE_CRYSTAL, 0, "Crystallized Redstone", "Sparkles with potential.", blood_red);
        generateItem(translationBuilder, ModItems.BLOOD_DIAMOND, 0, "Blood Diamond", "Chaos itself shines through.", blood_red);
        generateItem(translationBuilder, ModItems.ASH, 0, "Wither Ash", "Contains traces of dark magic.", wither);
        generateItem(translationBuilder, ModItems.TRANQUIL_DUST, 0, "Tranquil Pollen", "Useful in dark alchemy.", tranquil);
        generateItem(translationBuilder, ModBlocks.DARKSTEEL_BLOCK, 0, "Block of Darksteel", null, darksteel);
        generateItem(translationBuilder, ModBlocks.DARKENED_STEEL_BLOCK, 0, "Darkened Block of Steel", null, darksteel);
        generateItem(translationBuilder, ModItems.DARKSTEEL_INGOT, 0, "Darksteel Ingot", "Reflects only Tranquility's light.", darksteel);
        generateItem(translationBuilder, ModBlocks.URANIUM_ORE, 0, "Torbernite Ore", null, animGreen);
        generateItem(translationBuilder, ModBlocks.URANIUM_BLOCK, 0, "Block of Torbernite", "Do not touch.", animGreen);
        generateItem(translationBuilder, ModBlocks.NUCLEAR_CHARGE, 0, "Nuclear Charge", "WARNING: Highly destructive.", animGreen);
        generateItem(translationBuilder, ModItems.TORBERNITE_CUBE, 0, "Torbernite Cube", "Radiates a powerful aura.", animGreen);
        generateItem(translationBuilder, ModItems.ZENITHIUM_CLUSTER, 0, "Zenithium Cluster", "The concentrated essence of a galaxy.", zenithium);

        generateItem(translationBuilder, ModItems.ANTIMILK, 0, "Doctor Chadd's Ultimate Anti-Milk of Wondrous Effects", "Contains brief, yet unlimited, power.", null);
        generateItem(translationBuilder, ModItems.SALT, 0, "Salt", "Used for keeping meat fresh.", "2_#fbebe5_#f7d2c5");

        generateItem(translationBuilder, ModItems.RICE, 0, "Rice Seeds", null, null);
        generateItem(translationBuilder, ModItems.RICE_CAKE, 0, "Rice Cake", null, null);
        generateItem(translationBuilder, ModItems.SUSHI_ROLL, 0, "Sushi Roll", null, null);
        generateItem(translationBuilder, ModItems.GOLDEN_RICE, 0, "Golden Rice Seeds", null, shiny_gold);
        generateItem(translationBuilder, ModItems.GOLDEN_RICE_CAKE, 0, "Golden Rice Cake", null, shiny_gold);
        generateItem(translationBuilder, ModItems.TORTILLA, 0, "Tortilla", null, null);
        generateItem(translationBuilder, ModItems.BURRITO, 0, "Burrito", null, null);
        generateItem(translationBuilder, ModItems.FRIED_EGG, 0, "Fried Egg", null, null);
        generateItem(translationBuilder, ModItems.PEARFRUIT, 0, "Pearfruit", "As good as gold.", "#d4ff1c");
        generateItem(translationBuilder, ModItems.PEARFRUIT_JUICE, 0, "Pearfruit Juice", null, "#d4ff1c");
        generateItem(translationBuilder, ModItems.APPLE_JUICE, 0, "Apple Juice", null, null);
        generateItem(translationBuilder, ModItems.GOLDEN_APPLE_JUICE, 0, "Golden Apple Juice", null, null);
        generateItem(translationBuilder, ModItems.SWEET_BERRY_JUICE, 0, "Sweet Berry Juice", null, null);
        generateItem(translationBuilder, ModItems.MIDAS_FRUIT, 0, "Midas Fruit", "22 karats", shiny_gold);
        generateItem(translationBuilder, ModItems.BROWNIE, 0, "Brownie", "Comes from outer space?", null);
        generateItem(translationBuilder, ModItems.CHORUS_COBBLER, 0, "Chorus Cobbler", "Memah's favorite recipe", chorus);
        generateItem(translationBuilder, ModItems.SANDFISH, 0, "Sandfish", "This isn't a fish...", dune_tan);
        generateItem(translationBuilder, ModItems.COOKED_SANDFISH, 0, "Cooked Sandfish", "Just like Mama used to make!", dune_tan);
        generateItem(translationBuilder, ModItems.DUNE_EEL, 0, "Dune Eel", "Isn't this a snake?", dune_tan);
        generateItem(translationBuilder, ModItems.SMOKED_FISH, 0, "Smoked Fish", null, "2_#beab27_#47320e");

        generateItem(translationBuilder, ModItems.EMPTY_CAN, 0, "Empty Can", null, null);
        generateItem(translationBuilder, ModItems.BEETROOT_SOUP_CAN, 0, "Can of Beetroot Soup", null, null);
        generateItem(translationBuilder, ModItems.MUSHROOM_STEW_CAN, 0, "Can of Mushroom Stew", null, null);
        generateItem(translationBuilder, ModItems.RABBIT_STEW_CAN, 0, "Can of Rabbit Stew", null, null);
        generateItem(translationBuilder, ModItems.MILK_CAN, 0, "Can of Evaporated Milk", null, null);
        generateItem(translationBuilder, ModItems.COLA_ORANGE, 0, "Can of A&L", null, null);
        generateItem(translationBuilder, ModItems.COLA_GREEN, 0, "Can of Trola-Cola", null, null);
        generateItem(translationBuilder, ModItems.COLA_CYAN, 0, "Can of AquaDei Lite", null, null);

        generateItem(translationBuilder, ModItems.VIOLENT_CATALYST, 0, "Violent Catalyst", "The essence of eternity.", newColor(3, aqua, green, red));

        generateItem(translationBuilder, BetaItems.PORTKEY, 0, "Amethyst Core", "Use while crouching to bind to a location!", animPurple);
        generateItem(translationBuilder, BetaItems.DISTANCE_TRACKER, 0, "Lifeform Tracker", "Right click a mob to track it.", galiniteGray);
        generateItem(translationBuilder, ModItems.GALINITE_LENS, 0, "Galinite Lens", "Use on certain blocks and entities to gather data on them!",
                newColor(2, sentiBlue, sentiBlue, sentiBlue, sentiBlue, sentiBlue, white, sentiRed, sentiRed, white, white, white));
        generateItem(translationBuilder, ModItems.GALINITE_HOLOPROJECTOR, 0, "Hard Light Projector", null, sentiBlue);
        generateItem(translationBuilder, ModItems.NUCLEAR_ROCKET, 0, "Nuclear Rocket", null, animGreen);
        generateItem(translationBuilder, ModItems.NUCLEAR_DETONATOR, 0, "Nuclear Detonator", "Can activate nuclear charges.", animGreen);
        generateItem(translationBuilder, ModItems.ENERGY_CELL, 0, "Energy Cell", null, null);
        generateItem(translationBuilder, BetaItems.JUMP_DRIVE, 0, "Jump Drive", null, gunmetal);
        generateItem(translationBuilder, BetaItems.JETPACK, 0, "Jetpack", null, blood_red);

        generateItem(translationBuilder, ModEffectItems.RESISTANCE_ITEM, 0, "Shield Badge", null, newColor(2, gray, davys_grey));
        generateItem(translationBuilder, ModEffectItems.FIRE_RESISTANCE_ITEM, 0, "Flaming Badge", null, hellfire);
        generateItem(translationBuilder, ModEffectItems.JUMP_BOOST_ITEM, 0, "Icarus' Gust", null, animGreen);
        //strength_item: Sword Badge
        generateItem(translationBuilder, ModEffectItems.WEAKNESS_ITEM, 0, "Shattered Sword", "A reminder of your past failures.", null);
        //regeneration_item: Ever-Beating Heart
        //water_breathing_item: Bubbles of the Abyss
        //invisibility_item: Vampire's Mirror
        generateItem(translationBuilder, ModEffectItems.DOLPHINS_GRACE_ITEM, 0, "Squishy Foam Dolphin",
                "Touching it makes you feel hydrodynamic.", "2_#cddced_#577391");
        //conduit_power_item: Eye of the Sea
        //night_vision_item: Night Vision Goggles
        generateItem(translationBuilder, ModEffectItems.HERO_OF_THE_VILLAGE_ITEM, 0, "Hero's Emerald", "Gifted to the one who shall never be forgotten.", animGreen);
        //paladins_badge: Paladin's Badge
        generateItem(translationBuilder, ModEffectItems.GALINITE_STOMACH, 0, "Galinite Stomach", "Powers the body.", newColor(2, "#FF8F00", galiniteGray));
        generateItem(translationBuilder, ModEffectItems.ONE_PENCE, 0, "The One Pence", null, copper);

        generateItem(translationBuilder, ModBlocks.SUPERFORGE, 0, "Nuclear Superforge", null, animGreen);
        generateItem(translationBuilder, ModBlocks.MODIFICATION_TABLE, 0, "Modification Table", null, null);
        generateItem(translationBuilder, ModBlocks.RED_BUTTON, 0, "Big Red Button", "\"Whatever you do, don't press it.\"", sentiRed);
        generateItem(translationBuilder, ModBlocks.RED_PLATE, 0, "Big Red Pressure Plate", "1500 Megawatt Heavy Duty Super Colliding Super Plate", sentiRed);
        generatePot(translationBuilder, ModBlocks.TRANQUIL_ROSE, ModBlocks.POTTED_TRANQUIL_ROSE, 0, "Tranquil Rose", "Smells delightful.", tranquil);
        generatePot(translationBuilder, ModBlocks.SKULLWEED, ModBlocks.POTTED_SKULLWEED, 0, "Skullweed", "It's so cold...", skullweed);
        generateItem(translationBuilder, ModBlocks.FEATHERCORN, 0, "Feathercorn", "Soft and warm.", shiny_gold);

        generateItem(translationBuilder, ModItems.SENTINEL_SPAWN_EGG, 0, "Sentinel Spawn Beacon", "A mindless, yet not soulless, killing machine.", galiniteGray);
        generateItem(translationBuilder, ModItems.ROOMBA_SPAWN_EGG, 0, "Sentinel Cleaning Droid", "Once a human, now reduced to wiping away garbage.", galiniteGray);
        generateItem(translationBuilder, ModItems.VENDOR_TOKEN, 0, "Vendor Token", null, "2_#a2afb1_#6b7779");
        generateItem(translationBuilder, ModItems.LEGENDARY_TOKEN, 0, "Legendary Token", null, null);

        translationBuilder.add(new Identifier(MOD_ID, "assassination_upload"), ModItems.MUSIC_DISC_ASSASSINATION_UPLOAD.getName().getString()+" plays");
        translationBuilder.add(new Identifier(MOD_ID, "ode_to_tranquility"), ModItems.MUSIC_DISC_ODE_TO_TRANQUILITY.getName().getString()+" plays");
        translationBuilder.add(new Identifier(MOD_ID, "lapse_in_judgement"), ModItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT.getName().getString()+" plays");
        translationBuilder.add("trevorssentinels:recital", "Aged Cassette plays");

        if (dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").isPresent()) try {
            translationBuilder.add(dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").get());
        } catch (Exception e) { throw new RuntimeException("Failed to add existing language file!", e); }
    }

    public static final String black = "#000000"; public static final String dark_blue = "#0000AA"; public static final String dark_green = "#00AA00";
    public static final String dark_aqua = "#00AAAA"; public static final String dark_red = "#AA0000"; public static final String dark_purple = "#AA00AA";
    public static final String gold = "#FFAA00"; public static final String gray = "#AAAAAA"; public static final String dark_gray = "#555555";
    public static final String blue = "#5555FF"; public static final String green = "#55FF55"; public static final String aqua = "#55FFFF";
    public static final String red = "#FF5555"; public static final String light_purple = "#FF55FF"; public static final String yellow = "#FFFF55";
    public static final String white = "#FFFFFF"; public static final String davys_grey = "555555"; public static final String sentiBlue = "#189DBB";
    public static final String sentiRed = "#D31400"; public static final String galiniteGray = "#64666b";

    public static final String animRed = newColor(red, dark_red);
    public static final String animYellow = newColor(yellow, gold);
    public static final String animGreen = newColor(green, dark_green);
    public static final String animAqua = newColor(aqua, dark_aqua);
    public static final String animBlue = newColor(blue, dark_blue);
    public static final String animPurple = newColor(light_purple, dark_purple);
    public static final String animGray = newColor(gray, dark_gray);

    public static final String galinite = newColor(1.5, galiniteGray, "#4a4752", sentiBlue);
    public static final String copper = "2_#e77c56_#8a4129";
    public static final String rose_gold = "2_#fbebe5_#f7d2c5";
    public static final String gunmetal = "#6f7d9d";
    public static final String trimetal = "2_#6f7d9d_#906150";
    public static final String iron_gold = "2_#eae69b_#a78442";
    public static final String darksteel = newColor("#383444", "#2f273b", dark_purple);
    public static final String blood_red = "2_#d90012_#9e000d";
    public static final String zenithium = newColor(1.3, dark_green, dark_aqua, dark_purple);

    public static final String tranquil = newColor("#9949f2", dark_purple);
    public static final String skullweed = "1_#807bad_#6c5ca1";
    public static final String chorus = "1_#ba9bba_#a381a2";
    public static final String wither = "1_#383444_#2f273b";
    public static final String shiny_gold = "1_#f5cc27_#f9bd23";
    public static final String flesh_pink = "1_#bf5755_#772221";
    public static final String dune_tan = "#d4b963";
    public static final String rainbow = "1_#ed4d9c_#ed764d_#eced4d_#75ed4d_#4ded9f_#4dc3ed_#4e4ded_#c64ded";
    public static final String sentinel_accent = newColor(3, sentiBlue, galiniteGray, gold, galiniteGray, sentiRed, galiniteGray);
    public static final String patriot = "2_#b40000_#fbfbfb_#273b93_#fbfbfb";
    public static final String hellfire = "1_#f48522_#ca4e06";

    public static String newColor(double length, String... colors){
        StringBuilder builder = new StringBuilder(); for (String string:colors) builder.append("_").append(string); return String.valueOf(length) + builder;
    }
    public static String newColor(String... colors){
        StringBuilder builder = new StringBuilder(); for (String string:colors) builder.append("_").append(string); return "1" + builder;
    }

    public static Text getStyledText(String textContent, Style styleContent) {
        return new Text() {
            private final TextContent content = new TranslatableTextContent(textContent);
            @Nullable private Language decomposedWith; private OrderedText visualOrderText = OrderedText.EMPTY;
            @Override public Style getStyle() { return styleContent; } @Override public TextContent getContent() { return content; }
            @Override public List<Text> getSiblings() { return Lists.newArrayList(); }
            @Override public OrderedText asOrderedText() { Language language = Language.getInstance();
                if (this.decomposedWith != language) this.visualOrderText = language.reorder(this);
                this.decomposedWith = language; return this.visualOrderText;
            }};
    }

    public static Formatting numTooltipFormat(double variable, double factor) {
        if (variable >= factor) return Formatting.DARK_PURPLE;
        else if (variable >= (factor * 4) / 5) return Formatting.LIGHT_PURPLE; else if (variable >= (factor * 3) / 5) return Formatting.AQUA;
        else if (variable >= (factor * 2) / 5) return Formatting.GREEN; else if (variable >= (factor * 1) / 5) return Formatting.YELLOW;
        else if (variable > 0) return Formatting.RED; else return Formatting.GRAY;
    }

    public void generateWoodTranslations(@NotNull TranslationBuilder translationBuilder, String name, String color, ItemConvertible LOG, ItemConvertible WOOD,
             ItemConvertible STRIPPED_LOG, ItemConvertible STRIPPED_WOOD, ItemConvertible PLANKS, ItemConvertible LEAVES, ItemConvertible SAPLING, ItemConvertible POTTED,
             ItemConvertible SLAB, ItemConvertible STAIRS, ItemConvertible FENCE, ItemConvertible FENCE_GATE, ItemConvertible BUTTON, ItemConvertible PRESSURE_PLATE,
             ItemConvertible DOOR, ItemConvertible TRAPDOOR, ItemConvertible SIGN, ItemConvertible HANGING_SIGN, ItemConvertible BOAT, ItemConvertible CHEST_BOAT){
        if(LOG != null) generateItem(translationBuilder, LOG, 0, name+" Log", null, color);
        if(WOOD != null) generateItem(translationBuilder, WOOD, 0, name+" Wood", null, color);
        if(STRIPPED_LOG != null) generateItem(translationBuilder, STRIPPED_LOG, 0, "Stripped "+name+" Log", null, color);
        if(STRIPPED_WOOD != null) generateItem(translationBuilder, STRIPPED_WOOD, 0, "Stripped "+name+" Wood", null, color);
        if(PLANKS != null) generateItem(translationBuilder, PLANKS, 0, name+" Planks", null, color);
        if(LEAVES != null) generateItem(translationBuilder, LEAVES, 0, name+" Leaves", null, color);
        generatePot(translationBuilder, SAPLING, POTTED, 0, name+" Sapling", null, color);
        if(SLAB != null) generateItem(translationBuilder, SLAB, 0, name+" Slab", null, color);
        if(STAIRS != null) generateItem(translationBuilder, STAIRS, 0, name+" Stairs", null, color);
        if(FENCE != null) generateItem(translationBuilder, FENCE, 0, name+" Fence", null, color);
        if(FENCE_GATE != null) generateItem(translationBuilder, FENCE_GATE, 0, name+" Fence Gate", null, color);
        if(BUTTON != null) generateItem(translationBuilder, BUTTON, 0, name+" Button", null, color);
        if(PRESSURE_PLATE != null) generateItem(translationBuilder, PRESSURE_PLATE, 0, name+" Pressure Plate", null, color);
        if(DOOR != null) generateItem(translationBuilder, DOOR, 0, name+" Door", null, color);
        if(TRAPDOOR != null) generateItem(translationBuilder, TRAPDOOR, 0, name+" Trapdoor", null, color);
        if(SIGN != null) generateItem(translationBuilder, SIGN, 0, name+" Sign", null, color);
        if(HANGING_SIGN != null) generateItem(translationBuilder, HANGING_SIGN, 0, name+" Hanging Sign", null, color);
        if(BOAT != null) generateItem(translationBuilder, BOAT, 0, name+" Boat", null, color);
        if(CHEST_BOAT != null) generateItem(translationBuilder, CHEST_BOAT, 0, name+" Boat with Chest", null, color);
    }

    public void generateEquipmentSet(@NotNull TranslationBuilder translationBuilder, String name, String color, ItemConvertible HELMET, ItemConvertible CHESTPLATE,
             ItemConvertible LEGGINGS, ItemConvertible BOOTS, ItemConvertible SWORD, ItemConvertible DAGGER, ItemConvertible PICKAXE, ItemConvertible AXE,
             ItemConvertible SHOVEL, ItemConvertible HOE){
        if(HELMET != null) generateItem(translationBuilder, HELMET, 0, name+" Helmet", null, color);
        if(CHESTPLATE != null) generateItem(translationBuilder, CHESTPLATE, 0, name+" Chestplate", null, color);
        if(LEGGINGS != null) generateItem(translationBuilder, LEGGINGS, 0, name+" Leggings", null, color);
        if(BOOTS != null) generateItem(translationBuilder, BOOTS, 0, name+" Boots", null, color);
        if(SWORD != null) generateItem(translationBuilder, SWORD, 0, name+" Sword", null, color);
        if(DAGGER != null) generateItem(translationBuilder, DAGGER, 0, name+" Dagger", null, color);
        if(PICKAXE != null) generateItem(translationBuilder, PICKAXE, 0, name+" Pickaxe", null, color);
        if(AXE != null) generateItem(translationBuilder, AXE, 0, name+" Axe", null, color);
        if(SHOVEL != null) generateItem(translationBuilder, SHOVEL, 0, name+" Shovel", null, color);
        if(HOE != null) generateItem(translationBuilder, HOE, 0, name+" Hoe", null, color);
    }

    public void generateAdvancement(@NotNull TranslationBuilder translationBuilder, String advancement, String title, String desc) {
        translationBuilder.add("advancements." + MOD_ID + "." + advancement + ".title", title);
        translationBuilder.add("advancements." + MOD_ID + "." + advancement + ".desc", desc);
    }

    public void generateSetBonus(@NotNull TranslationBuilder translationBuilder, ArmorMaterial material, String tooltip, String color) {
        translationBuilder.add("tooltip.material." + MOD_ID + "." + material.getName(), tooltip);
        if(color != null) translationBuilder.add("color.material." + MOD_ID + "." + material.getName(), color);
    }

    public void generatePot(@NotNull TranslationBuilder translationBuilder, ItemConvertible r, ItemConvertible p, int custom, String name, String tooltip, String color){
        if(r!=null) generateItem(translationBuilder, r, custom, name, tooltip, color);
        if(p!=null) generateItem(translationBuilder, p, custom, "Potted "+name, tooltip, color);
    }

    public void generateItem(TranslationBuilder translationBuilder, ItemConvertible item, int custom, String name, String tooltip, String color) {
        String key; if (item instanceof Block block) key = block.getTranslationKey(); else key = item.asItem().getTranslationKey();
        if(name != null) translationBuilder.add(key + (custom != 0 ? (".custom" + custom) : ""), name);
        if (tooltip != null) translationBuilder.add("tooltip." + key + (custom != 0? (".custom" + custom) : ""), tooltip);
        if (color != null) translationBuilder.add("color." + key + (custom != 0? (".custom" + custom) : ""), color);
    }
}