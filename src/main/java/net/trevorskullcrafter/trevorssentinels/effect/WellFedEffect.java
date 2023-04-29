package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class WellFedEffect extends StatusEffect {
    public WellFedEffect(StatusEffectCategory statusEffectCategory, int color) { super(statusEffectCategory, color); }

    @Override public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i; i = 25 >> amplifier;
        if (i > 0) return duration % i == 0;
        else return true;
    }

    @Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player && player.getHungerManager().isNotFull()) { player.getHungerManager().add(1, 1.0f); }
    }
}