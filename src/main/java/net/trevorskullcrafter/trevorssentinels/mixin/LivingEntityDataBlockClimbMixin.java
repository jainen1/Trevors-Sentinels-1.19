package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public class LivingEntityDataBlockClimbMixin {
    //@Inject(method = "supports", at = @At("HEAD"), cancellable = true)
    //something to make it so that you can shift through data blocks, like scaffolding
}