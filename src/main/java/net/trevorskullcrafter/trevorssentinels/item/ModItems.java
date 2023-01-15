package net.trevorskullcrafter.trevorssentinels.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.custom.*;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.util.Identifier;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;
import static net.trevorskullcrafter.trevorssentinels.util.ColoredTextUtil.*;

public class ModItems {
    public static final Item SENTINUM_SHARD = registerItem("sentinum_shard",
            new NamedItem(flimsy_sentinum, new FabricItemSettings()));

    public static final Item SENTINUM_LENS = registerItem("sentinum_lens",
            new LensItem("4_#189dbb_#189dbb_#189dbb_#189dbb_#189dbb_#ffffff_#d31400_#d31400_#ffffff_#ffffff_#ffffff", true,
                    new FabricItemSettings().maxCount(1)));

    public static final Item SENTINUM_HOLOPROJECTOR = registerItem("sentinum_holoprojector",
            new HoloprojectorItem("#FFFFFF", true, new FabricItemSettings().maxDamage(129)));

    public static final Item MUSIC_DISC_ASSASSINATION_UPLOAD = registerItem("music_disc_assassination_upload",
            new ModMusicDiscItem(7, ModSounds.ASSASSINATION_UPLOAD,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 190));

    public static final Item MUSIC_DISC_ODE_TO_TRANQUILITY = registerItem("music_disc_ode_to_tranquility",
            new ModMusicDiscItem(7, ModSounds.ODE_TO_TRANQUILITY,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 80));

    public static final Item MUSIC_DISC_LAPSE_IN_JUDGEMENT = registerItem("music_disc_lapse_in_judgement",
            new ModMusicDiscItem(7, ModSounds.LAPSE_IN_JUDGEMENT,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 142));

    public static final Item MUSIC_DISC_RECITAL = registerItem("music_disc_recital",
            new ModMusicDiscItem(7, ModSounds.RECITAL,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 114));

    public static final Item SENTINUM_INGOT = registerItem("sentinum_ingot",
            new NamedItem(flimsy_sentinum, new FabricItemSettings()));

    public static final Item GUNMETAL_INGOT = registerItem("gunmetal_ingot",
            new Item(new FabricItemSettings()));

    public static final Item STEEL_SHEET = registerItem("steel_sheet",
            new Item(new FabricItemSettings()));

    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot",
            new Item(new FabricItemSettings()));

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new NamedItem(rose_gold, new FabricItemSettings()));

    public static final Item IRON_GOLD_INGOT = registerItem("iron_gold_ingot",
            new NamedItem(iron_gold, new FabricItemSettings()));

    public static final Item TRANSITITE_SHARDS = registerItem("transitite_shards",
            new NamedItem(demonic, new FabricItemSettings()));

    public static final Item ASH = registerItem("ash",
            new NamedItem("8_"+darksteel_RAW, new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(-2).saturationModifier(0.2f).build())));

    public static final Item DARKSTEEL_INGOT = registerItem("darksteel_ingot",
            new NamedItem(darksteel, new FabricItemSettings()));

    public static final Item REDSTONE_CRYSTAL = registerItem("redstone_crystal",
            new NamedItem(blood_red, new FabricItemSettings()));

    public static final Item BLOOD_DIAMOND = registerItem("blood_diamond",
            new NamedItem(blood_red, new FabricItemSettings().fireproof()));

    public static final Item VIOLENT_CATALYST = registerItem("violent_catalyst",
            new NamedItem("3_#55FFFF_#55FF55_#FF5555", new FabricItemSettings().fireproof()));

    public static final Item FERRAURIUM_DARKSTEEL_INGOT = registerItem("ferraurium_darksteel_ingot",
            new NamedItem(hallucium, new FabricItemSettings()));

    public static final Item URANIUM_CRYSTAL = registerItem("uranium_crystal",
            new NamedItem(nuclear, new FabricItemSettings()));

    public static final Item STEEL_SIGN = registerItem("steel_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.STEEL_SIGN_BLOCK, ModBlocks.STEEL_WALL_SIGN_BLOCK));
    public static final Item HOLOGRAPHIC_SIGN = registerItem("holographic_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.HOLOGRAPHIC_SIGN_BLOCK, ModBlocks.HOLOGRAPHIC_WALL_SIGN_BLOCK));

    public static final Item YGGDRASIL_SIGN = registerItem("yggdrasil_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.YGGDRASIL_SIGN_BLOCK, ModBlocks.YGGDRASIL_WALL_SIGN_BLOCK));
    public static final Item CHARRED_OAK_SIGN = registerItem("charred_oak_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.CHARRED_OAK_SIGN_BLOCK, ModBlocks.CHARRED_OAK_WALL_SIGN_BLOCK));
    public static final Item MIDAS_SIGN = registerItem("midas_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.MIDAS_SIGN_BLOCK, ModBlocks.MIDAS_WALL_SIGN_BLOCK));
    public static final Item BANANA_SIGN = registerItem("banana_sign",
            new SignItem(new FabricItemSettings().maxCount(16),
                    ModBlocks.BANANA_SIGN_BLOCK, ModBlocks.BANANA_WALL_SIGN_BLOCK));

    public static final Item FRIED_EGG = registerItem("fried_egg",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));

    public static final Item BANANA = registerItem("banana",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.4f).build())));

    public static final Item RED_BANANA = registerItem("red_banana",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).build())));

    public static final Item BLUE_JAVA_BANANA = registerItem("blue_java_banana",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));

    public static final Item RICE = registerItem("rice",
            new AliasedBlockItem(ModBlocks.RICE_PLANT, new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build())));

    public static final Item RICE_CAKE = registerItem("rice_cake",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));

    public static final Item SUSHI_ROLL = registerItem("sushi_roll",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).build())));

    public static final Item GOLDEN_RICE = registerItem("golden_rice",
            new AliasedBlockItem(ModBlocks.GOLDEN_RICE_PLANT, new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build())));

    public static final Item GOLDEN_RICE_CAKE = registerItem("golden_rice_cake",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).build())));

    public static final Item TORTILLA = registerItem("tortilla",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));

    public static final Item BURRITO = registerItem("burrito",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(12).saturationModifier(2.4f).build())));

    public static final Item PEARFRUIT = registerItem("pearfruit",
            new NamedItem("#d4ff1c", new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 1), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 1), 1.0f)
                            .alwaysEdible().build())));

    public static final Item BROWNIE = registerItem("brownie",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));

    public static final Item SANDFISH = registerItem("sandfish",
            new NamedItem(dune_tan, new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build())));

    public static final Item COOKED_SANDFISH = registerItem("cooked_sandfish",
            new NamedItem(dune_tan, new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));

    public static final Item DUNE_EEL = registerItem("dune_eel",
            new NamedItem(dune_tan, new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build())));

    public static final Item SENTINEL_SPAWN_EGG = registerItem("sentinel_spawn_egg",
            new SpawnEggItem(ModEntities.SENTINEL, 0xffffff, 0xD31400,
                    new FabricItemSettings()));

    public static final Item ROOMBA_SPAWN_EGG = registerItem("roomba_spawn_egg",
            new SpawnEggItem(ModEntities.SENTINUM_ROOMBA, 0xffffff, 0xffffff,
                    new FabricItemSettings()));

    public static final Item FLORBUS_SPAWN_EGG = registerItem("florbus_spawn_egg",
            new SpawnEggItem(ModEntities.FLORBUS, 0xd9c996, 0xb6a269,
                    new FabricItemSettings()));

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

    public static final Item ANTIMILK = registerItem("antimilk",
            new ChaddBucketItem(rainbow, new FabricItemSettings().rarity(Rarity.EPIC)));

    /*public static final Item JUMP_DRIVE = registerItem("jump_drive",
            new JumpItem(new FabricItemSettings().maxCount(1)));*/

    public static final Item JUMP_DRIVE = registerItem("jump_drive",
                new JumpItemv2(gunmetal, ModArmorMaterials.TRIMETAL, EquipmentSlot.CHEST, new FabricItemSettings().maxDamage(100)));

    public static final Item JETPACK = registerItem("jetpack",
            new JetpackItem(blood_red, ModArmorMaterials.URANIUM, EquipmentSlot.CHEST, new FabricItemSettings().maxDamage(100)));

    public static final Item PORTKEY = registerItem("portkey",
            new PortkeyItem(demonic, true, new FabricItemSettings().maxDamage(11)));

    public static final Item DISTANCE_TRACKER = registerItem("distance_tracker",
            new DistanceTrackerItem("8_#30194c_#686868",
                    new FabricItemSettings().maxCount(1)));

    public static final Item EMPTY_CAN = registerItem("empty_can",
            new Item(new FabricItemSettings()));

    public static final Item BEETROOT_SOUP_CAN = registerItem("beetroot_soup_can",
            new CannedItem(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));

    public static final Item MUSHROOM_STEW_CAN = registerItem("mushroom_stew_can",
            new CannedItem(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));

    public static final Item RABBIT_STEW_CAN = registerItem("rabbit_stew_can",
            new CannedItem(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));

    public static final Item MILK_CAN = registerItem("milk_can",
            new CannedItem(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));

    public static final Item COLA_ORANGE = registerItem("cola_orange",
            new CannedItem(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));

    public static final Item COLA_GREEN = registerItem("cola_green",
            new CannedItem(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));

    public static final Item COLA_CYAN = registerItem("cola_cyan",
            new CannedItem(new FabricItemSettings()
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));

    public static final Item VENDOR_TOKEN = registerItem("vendor_token",
            new NamedItem("8_#a2afb1_#6b7779", new FabricItemSettings()));

    public static final Item LEGENDARY_TOKEN = registerItem("legendary_token",
            new NamedItem(rainbow, new FabricItemSettings()));

    public static final Item NUCLEAR_ROCKET = registerItem("nuclear_rocket",
            new NuclearFireworkItem(new FabricItemSettings().maxCount(1).maxDamage(65).rarity(Rarity.RARE)));

    public static final Item SUPERFORGE_ITEM = registerItem("superforge_item",
            new SuperforgeItem(ModBlocks.SUPERFORGE, new FabricItemSettings().fireproof()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item);
    }

    public static void registerModItems(){
        trevorssentinels.LOGGER.info("Registering items... ("+ MOD_ID + ")");
    }
}