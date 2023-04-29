package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Shadow public abstract void onEntityLand(BlockView world, Entity entity);

    @Inject(method = "onLandedUpon", at = @At(value = "HEAD"))
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci){
        entity.handleFallDamage((float) (Math.abs(entity.getVelocity().y) * fallDistance), getDamageMultiplier(), DamageSource.FALL);
        onEntityLand(world, entity);
    }

    public float getDamageMultiplier(){
        return 1.0f;
    }
}