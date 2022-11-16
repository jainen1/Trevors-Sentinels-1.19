package net.trevorskullcrafter.trevorssentinels.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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

    public static final Item SENTINUM_INGOT = registerItem("sentinum_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item GUNMETAL_INGOT = registerItem("gunmetal_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item STEEL_SHEET = registerItem("steel_sheet",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

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
            new ViolentCatalystItem(new FabricItemSettings().group(ModItemGroup.SENTINELS).fireproof()));

    public static final Item URANIUM_CRYSTAL = registerItem("uranium_crystal",
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

    public static final Item BANANA = registerItem("banana",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.4f).build())));

    public static final Item RED_BANANA = registerItem("red_banana",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).build())));

    public static final Item BLUE_JAVA_BANANA = registerItem("blue_java_banana",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));

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
            new ChaddBucketItem(new FabricItemSettings().group(ModItemGroup.KITCHEN).rarity(Rarity.EPIC)));

    public static final Item SENTINEL_SPAWN_EGG = registerItem("sentinel_spawn_egg",
            new SpawnEggItem(ModEntities.SENTINEL, 0xffffff, 0xffffff,
                    new FabricItemSettings().group(ModItemGroup.WORLD)));

    public static final Item ROOMBA_SPAWN_EGG = registerItem("roomba_spawn_egg",
            new SpawnEggItem(ModEntities.SENTINUM_ROOMBA, 0xffffff, 0xffffff,
                    new FabricItemSettings().group(ModItemGroup.WORLD)));

    public static final Item FLORBUS_SPAWN_EGG = registerItem("florbus_spawn_egg",
            new SpawnEggItem(ModEntities.FLORBUS, 0xd9c996, 0xb6a269,
                    new FabricItemSettings().group(ModItemGroup.WORLD)));

    public static final Item ONE_PENCE = registerItem("one_pence",
            new OnePenceItem(StatusEffects.LUCK, 9, new FabricItemSettings().maxCount(1).group(ModItemGroup.SENTINELS)));

    public static final Item SENTINUM_STOMACH = registerItem("sentinum_stomach",
            new InfiniteEffectItem(StatusEffects.SATURATION, 0, new FabricItemSettings().maxCount(1).group(ModItemGroup.SENTINELS)));

    public static final Item JUMP_DRIVE = registerItem("jump_drive",
            new JumpItem(new FabricItemSettings().maxCount(1).group(ModItemGroup.SENTINELS)));

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
        trevorssentinels.LOGGER.info("Registering items... ("+ MOD_ID + ")");
    }
}