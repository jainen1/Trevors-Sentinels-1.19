package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent FRIED_EGG = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build();
    public static final FoodComponent PEARFRUIT = new FoodComponent.Builder().hunger(4).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 1), 1.0f).alwaysEdible().build();
    public static final FoodComponent BROWNIE = new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build();

    public static final FoodComponent ANTIMILK = new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 1, 0), 1.0f)
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
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, 0), 1.0f).alwaysEdible().build();
}
