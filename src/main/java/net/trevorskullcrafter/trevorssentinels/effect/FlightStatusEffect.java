package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class FlightStatusEffect extends StatusEffect {
    public FlightStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public static boolean hasSpacebarDown() {
        return InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 32);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        float fallVelocity = (float) Math.abs(entity.getVelocity().y * 5);
        if (entity instanceof PlayerEntity) {
            //((PlayerEntity) entity).addExperience(1 << amplifier);
            if(hasSpacebarDown()){
                if(entity.getVelocity().y < 0.6){
                    entity.addVelocity(0, 0.15, 0);
                }else{
                    entity.setVelocity(entity.getVelocity().x, 0.6, entity.getVelocity().z);
                }
                entity.fallDistance = fallVelocity;
            }else if(Screen.hasShiftDown()){
                entity.setVelocity(entity.getVelocity().x, 0, entity.getVelocity().z);
                entity.fallDistance = 0.0f;
            }
            entity.getMovementDirection();
            //((PlayerEntity) entity).sendMessage(Text.literal("Velocity: " + Math.round(fallVelocity)), true);
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}