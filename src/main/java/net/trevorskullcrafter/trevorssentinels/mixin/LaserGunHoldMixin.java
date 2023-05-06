package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Hand;
import net.trevorskullcrafter.trevorssentinels.data.ItemTagGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class LaserGunHoldMixin {
    @Inject(at = @At("TAIL"), method = "getArmPose", cancellable = true)
    private static void getArmPose(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> cir) {
        if (!player.handSwinging && player.getStackInHand(hand).isIn(ItemTagGenerator.CROSSBOW_HOLD)) cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_HOLD);
    }
}