package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import org.jetbrains.annotations.Nullable;

public class RedstonedStatusEffect extends StatusEffect {
    float storedHealth = 0;
    float changeInHealth;
    public RedstonedStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        /*if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addExperience(1 << amplifier); // Higher amplifier gives you EXP faster
        }*/
        if(!entity.world.isClient() && entity.getHealth() > 0){
            if(storedHealth == 0){
                storedHealth = entity.getHealth();
            }
            if(storedHealth != entity.getHealth()){
                changeInHealth += (entity.getHealth() - storedHealth);
                entity.setHealth(storedHealth);
            }
            if(changeInHealth != 0){ //true
                if(entity.getWorld().getTime() % 20 == 0) {
                    float toChange = Math.round(changeInHealth / 4);
                    if (changeInHealth > 0) {
                        entity.heal(toChange);
                    } else { //true
                        entity.damage(DamageSource.GENERIC, toChange);
                    }
                    storedHealth += toChange;
                    changeInHealth -= toChange;
                }
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}