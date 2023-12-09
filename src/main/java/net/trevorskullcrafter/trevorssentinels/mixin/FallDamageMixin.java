package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.USE_VELOCITY_FALL_DAMAGE;

@Mixin(Entity.class)
public abstract class FallDamageMixin {
    @Shadow public abstract Vec3d getVelocity();

    @Shadow private World world;

    @Inject(at = @At("HEAD"), method = "handleFallDamage")
    public void handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir){
        if(fallDistance > 4 && world.getGameRules().getBoolean(USE_VELOCITY_FALL_DAMAGE)){ fallDistance = (float) Math.floor(Math.abs(getVelocity().y) * 3); }
    }
}