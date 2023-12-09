package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class FallDamageMixin {
    @Shadow public abstract Vec3d getVelocity();

    @Inject(at = @At("HEAD"), method = "handleFallDamage")
    public void handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir){
        if(fallDistance > 4){ fallDistance = (float) Math.floor(Math.abs(getVelocity().y) * 3); }
    }
}