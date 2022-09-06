package net.trevorskullcrafter.trevorssentinels.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nullable;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModItems {
    public static final Item SENTINUM_SHARD = registerItem("sentinum_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));
    public static final Item BLOOD_DIAMOND = registerItem("blood_diamond",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS).fireproof().rarity(Rarity.EPIC)));

    public static final Item VIOLENT_CATALYST = registerItem("violent_catalyst",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item FRIED_EGG = registerItem("fried_egg",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()).maxCount(128)));

    public static final Item RICE = registerItem("rice",
            new AliasedBlockItem(ModBlocks.RICE_PLANT, new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build())));

    public static final Item PEARFRUIT = registerItem("pearfruit",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 1), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 1), 1.0f).alwaysEdible().build())));

    public static final Item BROWNIE = registerItem("brownie",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN)
                    .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));

    public static final Item ANTIMILK = registerItem("antimilk",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN).food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1, 0), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, 0), 1.0f).alwaysEdible().build())
                    .rarity(Rarity.EPIC)));

    public static final Item ASH = registerItem("ash",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item DARKSTEEL_INGOT = registerItem("darksteel_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS).rarity(Rarity.UNCOMMON)));

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item IRON_GOLD_INGOT = registerItem("iron_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item URANIUM_CRYSTAL = registerItem("uranium_crystal",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS).rarity(Rarity.RARE)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item);
    }

    public static void registerModItems(){
        trevorssentinels.LOGGER.info("Registering Mod Items for "+ MOD_ID);
    }
}
