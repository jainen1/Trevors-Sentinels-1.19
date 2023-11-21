package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.trevorskullcrafter.trevorssentinels.entity.damage.ModDamageSources;

public class InfestedStatusEffect extends StatusEffect {
    int strength;
    public InfestedStatusEffect(StatusEffectCategory statusEffectCategory, int color) { super(statusEffectCategory, color); }

    @Override public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) return duration % i == 0;
        else return true;
    }

    @Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(entity.getDamageSources().generic(), (float) strength / 2);
        strength++;
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override public void onApplied(LivingEntity entity, int amplifier) {
        strength = amplifier;
        super.onApplied(entity, amplifier);
    }

    @Override public void onRemoved(AttributeContainer attributes) {
        strength = 0;
        super.onRemoved(attributes);
    }
}