package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class DataBlockClimbMixin {

    /*@Inject(method = "applyMovementInput", at = @At("RETURN"))
    protected void injectDataBlock(Vec3d movementInput, float slipperiness, CallbackInfoReturnable<Vec3d> cir){
        if ((this.horizontalCollision || this.jumping) && (this.isClimbing() || this.getBlockStateAtPos().isOf(ModBlocks.DATA_BLOCK) && PowderSnowBlock.canWalkOnPowderSnow(this))) {
            vec3d = new Vec3d(vec3d.x, 0.2, vec3d.z);
        }
    }*/
}