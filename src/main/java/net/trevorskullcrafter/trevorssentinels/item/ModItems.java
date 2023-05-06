package net.trevorskullcrafter.trevorssentinels.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.custom.*;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.ChaddBucketItem;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.HoloprojectorItem;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.LensItem;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.NuclearFireworkItem;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.util.Identifier;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModItems {
    public static final Item GALINITE_SHARD = registerItem("galinite_shard", new Item(new FabricItemSettings()));
    public static final Item GALINITE_INGOT = registerItem("galinite_ingot", new Item(new FabricItemSettings()));
    public static final Item GUNMETAL_INGOT = registerItem("gunmetal_ingot", new Item(new FabricItemSettings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot", new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item IRON_GOLD_INGOT = registerItem("iron_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item TRANSITITE_SHARDS = registerItem("transitite_shards", new Item(new FabricItemSettings()));
    public static final Item ASH = registerItem("ash", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(-1).saturationModifier(0.2f).build())));
    public static final Item TRANQUIL_DUST = registerItem("tranquil_dust", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), 0.6f).build())));
    public static final Item RUINOUS_GAZE = registerItem("ruinous_gaze", new Item(new FabricItemSettings()));
    public static final Item SALT = registerItem("salt", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(-0.5f).build())));
    public static final Item DARKSTEEL_INGOT = registerItem("darksteel_ingot", new Item(new FabricItemSettings()));
    public static final Item REDSTONE_CRYSTAL = registerItem("redstone_crystal", new Item(new FabricItemSettings()));
    public static final Item BLOOD_DIAMOND = registerItem("blood_diamond", new Item(new FabricItemSettings().fireproof()));
    public static final Item VIOLENT_CATALYST = registerItem("violent_catalyst", new Item(new FabricItemSettings().fireproof()));
    public static final Item FERRAURIUM_DARKSTEEL_INGOT = registerItem("ferraurium_darksteel_ingot", new Item(new FabricItemSettings()));
    public static final Item TORBERNITE_CUBE = registerItem("uranium_crystal", new Item(new FabricItemSettings().fireproof()));
    public static final Item ZENITHIUM_CLUSTER = registerItem("zenithium_cluster", new Item(new FabricItemSettings().fireproof()));

    public static final Item GALINITE_LENS = registerItem("galinite_lens", new LensItem(new FabricItemSettings().maxCount(1), 1.6, 15));
    public static final Item GALINITE_HOLOPROJECTOR = registerItem("galinite_holoprojector",
            new HoloprojectorItem(new FabricItemSettings().maxDamage(129)));
    public static final Item ENERGY_CELL = registerItem("energy_cell", new Item(new FabricItemSettings()));
    public static final Item NUCLEAR_ROCKET = registerItem("nuclear_rocket", new NuclearFireworkItem(new FabricItemSettings().maxDamage(93)));
    public static final Item NUCLEAR_DETONATOR = registerItem("nuclear_detonator", new Item(new FabricItemSettings().maxCount(1)));

    public static final Item MUSIC_DISC_ASSASSINATION_UPLOAD = registerItem("music_disc_assassination_upload", new MusicDiscItem
            (7, ModSounds.ASSASSINATION_UPLOAD, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 190));
    public static final Item MUSIC_DISC_ODE_TO_TRANQUILITY = registerItem("music_disc_ode_to_tranquility", new MusicDiscItem
            (7, ModSounds.ODE_TO_TRANQUILITY, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 80));
    public static final Item MUSIC_DISC_LAPSE_IN_JUDGEMENT = registerItem("music_disc_lapse_in_judgement", new MusicDiscItem
            (7, ModSounds.LAPSE_IN_JUDGEMENT, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 142));
    public static final Item MUSIC_DISC_RECITAL = registerItem("music_disc_recital", new MusicDiscItem
            (7, ModSounds.RECITAL, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 114));

    public static final Item FRIED_EGG = registerItem("fried_egg", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    public static final Item DUBIOUS_BACON = registerItem("dubious_bacon", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(
                    ModEffects.INFESTED, 200, 0), 0.1f).build())));
    public static final Item BANANA = registerItem("banana", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(
                    ModEffects.IRRADIATED, 20, 0), 0.3f).build())));
    public static final Item RED_BANANA = registerItem("red_banana", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(
                    ModEffects.IRRADIATED, 40, 1), 0.4f).build())));
    public static final Item BLUE_JAVA_BANANA = registerItem("blue_java_banana", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(
                    ModEffects.IRRADIATED, 80, 2), 0.5f).build())));
    public static final Item BANANA_BREAD = registerItem("banana_bread", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(
                    ModEffects.WELL_FED, 100, 0), 0.3f).build())));
    public static final Item RED_BANANA_BREAD = registerItem("red_banana_bread", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(
                    ModEffects.WELL_FED, 200, 1), 0.4f).build())));
    public static final Item BLUE_JAVA_BANANA_BREAD = registerItem("blue_java_banana_bread", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(
                    ModEffects.WELL_FED, 400, 2), 0.5f).build())));
    public static final Item RICE = registerItem("rice", new AliasedBlockItem(ModBlocks.RICE_PLANT, new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build())));
    public static final Item RICE_CAKE = registerItem("rice_cake", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));
    public static final Item SUSHI_ROLL = registerItem("sushi_roll", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).build())));
    public static final Item GOLDEN_RICE = registerItem("golden_rice", new AliasedBlockItem(ModBlocks.GOLDEN_RICE_PLANT, new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build())));
    public static final Item GOLDEN_RICE_CAKE = registerItem("golden_rice_cake", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).build())));
    public static final Item TORTILLA = registerItem("tortilla", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));
    public static final Item BURRITO = registerItem("burrito", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(12).saturationModifier(2.4f).build())));
    public static final Item PEARFRUIT = registerItem("pearfruit", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 1), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 1), 1.0f).alwaysEdible().build())));
    public static final Item MIDAS_FRUIT = registerItem("midas_fruit", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 120, 1), 1.0f).alwaysEdible().build())));
    public static final Item APPLE_JUICE = registerItem("apple_juice", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item GOLDEN_APPLE_JUICE = registerItem("golden_apple_juice", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item PEARFRUIT_JUICE = registerItem("pearfruit_juice", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item SWEET_BERRY_JUICE = registerItem("sweet_berry_juice", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(1.0f).build())));
    public static final Item BROWNIE = registerItem("brownie", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build())));
    public static final Item CHORUS_COBBLER = registerItem("chorus_cobbler", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 120, 0), 1.0f).build())));

    public static final Item CURED_BEEF = registerItem("cured_beef", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build())));
    public static final Item CURED_CHICKEN = registerItem("cured_chicken", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.8f).build())));

    public static final Item SANDFISH = registerItem("sandfish", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2)
            .saturationModifier(0.6f).build())));
    public static final Item COOKED_SANDFISH = registerItem("cooked_sandfish", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));
    public static final Item DUNE_EEL = registerItem("dune_eel", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build())));
    public static final Item SMOKED_FISH = registerItem("smoked_fish", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0f).build())));
    public static final Item ANTIMILK = registerItem("antimilk", new ChaddBucketItem(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item EMPTY_CAN = registerItem("empty_can", new Item(new FabricItemSettings()));
    public static final Item BEETROOT_SOUP_CAN = registerItem("beetroot_soup_can", new CannedItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().snack().hunger(3).saturationModifier(0.6f).build())));
    public static final Item MUSHROOM_STEW_CAN = registerItem("mushroom_stew_can", new CannedItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().snack().hunger(3).saturationModifier(0.6f).build())));
    public static final Item RABBIT_STEW_CAN = registerItem("rabbit_stew_can", new CannedItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().snack().hunger(5).saturationModifier(0.6f).build())));
    public static final Item MILK_CAN = registerItem("milk_can", new CannedItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build())));
    public static final Item COLA_ORANGE = registerItem("cola_orange", new CannedItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build())));
    public static final Item COLA_GREEN = registerItem("cola_green", new CannedItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build())));
    public static final Item COLA_CYAN = registerItem("cola_cyan", new CannedItem(new FabricItemSettings()
            .food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build())));

    public static final Item SENTINEL_SPAWN_EGG = registerItem("sentinel_spawn_egg",
            new SpawnEggItem(ModEntities.SENTINEL, 0xffffff, 0xD31400, new FabricItemSettings()));
    public static final Item ROOMBA_SPAWN_EGG = registerItem("roomba_spawn_egg",
            new SpawnEggItem(ModEntities.GALINITE_ROOMBA, 0xffffff, 0xffffff, new FabricItemSettings()));
    public static final Item FLORBUS_SPAWN_EGG = registerItem("florbus_spawn_egg",
            new SpawnEggItem(ModEntities.FLORBUS, 0xd9c996, 0xb6a269, new FabricItemSettings()));

    public static final Item STEEL_SIGN = registerItem("steel_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.STEEL_SIGN_BLOCK, ModBlocks.STEEL_WALL_SIGN_BLOCK));
    public static final Item HOLOGRAPHIC_SIGN = registerItem("holographic_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.HOLOGRAPHIC_SIGN_BLOCK, ModBlocks.HOLOGRAPHIC_WALL_SIGN_BLOCK));

    public static final Item YGGDRASIL_SIGN = registerItem("yggdrasil_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.YGGDRASIL_SIGN_BLOCK, ModBlocks.YGGDRASIL_WALL_SIGN_BLOCK));
    public static final Item YGGDRASIL_HANGING_SIGN = registerItem("yggdrasil_hanging_sign",
            new HangingSignItem(ModBlocks.YGGDRASIL_HANGING_SIGN, ModBlocks.YGGDRASIL_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item CHARRED_OAK_SIGN = registerItem("charred_oak_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.CHARRED_OAK_SIGN_BLOCK, ModBlocks.CHARRED_OAK_WALL_SIGN_BLOCK));
    public static final Item CHARRED_OAK_HANGING_SIGN = registerItem("charred_oak_hanging_sign",
            new HangingSignItem(ModBlocks.CHARRED_OAK_HANGING_SIGN, ModBlocks.CHARRED_OAK_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item MIDAS_SIGN = registerItem("midas_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.MIDAS_SIGN_BLOCK, ModBlocks.MIDAS_WALL_SIGN_BLOCK));
    public static final Item MIDAS_HANGING_SIGN = registerItem("midas_hanging_sign",
            new HangingSignItem(ModBlocks.MIDAS_HANGING_SIGN, ModBlocks.MIDAS_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item BANANA_SIGN = registerItem("banana_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.BANANA_SIGN_BLOCK, ModBlocks.BANANA_WALL_SIGN_BLOCK));
    public static final Item BANANA_HANGING_SIGN = registerItem("banana_hanging_sign",
            new HangingSignItem(ModBlocks.BANANA_HANGING_SIGN, ModBlocks.BANANA_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
    public static final Item CERULII_SIGN = registerItem("cerulii_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.CERULII_SIGN_BLOCK, ModBlocks.CERULII_WALL_SIGN_BLOCK));
    public static final Item CERULII_HANGING_SIGN = registerItem("cerulii_hanging_sign",
            new HangingSignItem(ModBlocks.CERULII_HANGING_SIGN, ModBlocks.CERULII_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));

    public static final Item YGGDRASIL_BOAT = registerItem("yggdrasil_boat",
            new BoatItem(false, BoatEntity.Type.BIRCH, new Item.Settings().maxCount(1)));
    public static final Item YGGDRASIL_CHEST_BOAT = registerItem("yggdrasil_chest_boat",
            new BoatItem(true, BoatEntity.Type.BIRCH, new Item.Settings().maxCount(1)));
    public static final Item CHARRED_OAK_BOAT = registerItem("charred_oak_boat",
            new BoatItem(false, BoatEntity.Type.OAK, new Item.Settings().maxCount(1)));
    public static final Item CHARRED_OAK_CHEST_BOAT = registerItem("charred_oak_chest_boat",
            new BoatItem(true, BoatEntity.Type.OAK, new Item.Settings().maxCount(1)));
    public static final Item MIDAS_BOAT = registerItem("midas_boat",
            new BoatItem(false, BoatEntity.Type.DARK_OAK, new Item.Settings().maxCount(1)));
    public static final Item MIDAS_CHEST_BOAT = registerItem("midas_chest_boat",
            new BoatItem(true, BoatEntity.Type.DARK_OAK, new Item.Settings().maxCount(1)));
    public static final Item BANANA_BOAT = registerItem("banana_boat",
            new BoatItem(false, BoatEntity.Type.JUNGLE, new Item.Settings().maxCount(1)));
    public static final Item BANANA_CHEST_BOAT = registerItem("banana_chest_boat",
            new BoatItem(true, BoatEntity.Type.JUNGLE, new Item.Settings().maxCount(1)));
    public static final Item CERULII_BOAT = registerItem("cerulii_boat",
            new BoatItem(false, BoatEntity.Type.JUNGLE, new Item.Settings().maxCount(1)));
    public static final Item CERULII_CHEST_BOAT = registerItem("cerulii_chest_boat",
            new BoatItem(true, BoatEntity.Type.JUNGLE, new Item.Settings().maxCount(1)));

    public static final Item FEATHERCORN = registerItem("feathercorn", new TallBlockItem(ModBlocks.FEATHERCORN, new FabricItemSettings()));

    public static final Item VENDOR_TOKEN = registerItem("vendor_token", new Item(new FabricItemSettings()));
    public static final Item LEGENDARY_TOKEN = registerItem("legendary_token", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));

    public static final Item COMMON_SKIN_PACK = registerItem("common_skin_pack", new PaintPack(1, new FabricItemSettings()));

    private static Item registerItem(String name, Item item){return Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item);}
    public static void registerModItems(){ trevorssentinels.LOGGER.info("Registering items... ("+ MOD_ID + ")"); }
}