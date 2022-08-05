package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent FRIED_EGG = new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build();
    public static final FoodComponent PEARFRUIT = new FoodComponent.Builder().hunger(4).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 1), 1.0f).alwaysEdible().build();
    public static final FoodComponent BROWNIE = new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build();
}
