package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.trevorskullcrafter.trevorssentinels.entity.damage.ModDamageSources;

public class IrradiatedStatusEffect extends StatusEffect {
    public IrradiatedStatusEffect(StatusEffectCategory statusEffectCategory, int color) { super(statusEffectCategory, color); }

    @Override public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        if(entity instanceof PlayerEntity) ((PlayerEntity)entity).getHungerManager().add(amplifier + 1, 1.0F);
        else entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, amplifier), entity);
    }

    @Override public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 40 >> amplifier;
        if (i > 0) return duration % i == 0;
        else return true;
    }

    @Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(entity.getDamageSources().generic(), (amplifier / 2f)+0.5f);
    }
}