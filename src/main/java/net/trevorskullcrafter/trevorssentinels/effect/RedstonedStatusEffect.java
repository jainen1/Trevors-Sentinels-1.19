package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundEvents;

public class RedstonedStatusEffect extends StatusEffect {
    float storedHealth; float changeInHealth;
    public RedstonedStatusEffect(StatusEffectCategory statusEffectCategory, int color) { super(statusEffectCategory, color); }

    @Override public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }
    @Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if(!entity.getWorld().isClient()){
            if(storedHealth != entity.getHealth()) changeInHealth += (entity.getHealth() - storedHealth);
            if(entity.getHealth() > 0) entity.setHealth(storedHealth);
        }
    }

    @Override public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier); storedHealth = entity.getHealth();
        if(entity.getWorld().isClient()){ entity.playSound(SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, 1.0f, 5.0f); }
    }

    /*@Override public void onRemoved(AttributeContainer attributes) {
        super.onRemoved(attributes);
        LivingEntity entity = attributes
        if (changeInHealth < 0) entity.damage(entity.getDamageSources().generic(), Math.abs(changeInHealth));
        else if(changeInHealth > 0) entity.heal(changeInHealth);
        storedHealth = 0; changeInHealth = 0;
        if(entity.getWorld().isClient()){ entity.playSound(SoundEvents.ENTITY_WARDEN_SONIC_BOOM, 1.0f, 5.0f); }
    }*/
}