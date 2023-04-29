package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundEvents;
import net.trevorskullcrafter.trevorssentinels.entity.damage.ModDamageSources;

public class RedstonedStatusEffect extends StatusEffect {
    float storedHealth; float changeInHealth;
    public RedstonedStatusEffect(StatusEffectCategory statusEffectCategory, int color) { super(statusEffectCategory, color); }

    @Override public boolean canApplyUpdateEffect(int duration, int amplifier) { return true; }
    @Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        /*if (entity instanceof PlayerEntity) { ((PlayerEntity) entity).addExperience(1 << amplifier); // Higher amplifier gives you EXP faster }*/
        if(!entity.world.isClient()){
            if(storedHealth != entity.getHealth()) changeInHealth += (entity.getHealth() - storedHealth);
            if(entity.getHealth() > 0) entity.setHealth(storedHealth);
        }
    }

    @Override public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier); storedHealth = entity.getHealth();
        if(entity.world.isClient()){
            entity.playSound(SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, 1.0f, 5.0f);
        }
    }

    @Override public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (changeInHealth < 0) entity.damage(ModDamageSources.REDSTONED, Math.abs(changeInHealth));
        else if(changeInHealth > 0) entity.heal(changeInHealth);
        storedHealth = 0; changeInHealth = 0;
        if(entity.world.isClient()){
            entity.playSound(SoundEvents.ENTITY_WARDEN_SONIC_BOOM, 1.0f, 5.0f);
        }
    }
}