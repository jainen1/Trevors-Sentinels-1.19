package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.trevorskullcrafter.trevorssentinels.datagen.ItemTagGenerator;
import net.trevorskullcrafter.trevorssentinels.item.custom.NewGunItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class LaserGunHoldMixin {
    @Inject(at = @At("TAIL"), method = "getArmPose", cancellable = true)
    private static void getArmPose(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> cir) {
        if (!player.handSwinging && player.getStackInHand(hand).isIn(ItemTagGenerator.CROSSBOW_HOLD)) {
            if(isDualWielding(player) && player.getStackInHand(hand).getItem() instanceof NewGunItem newGunItem && newGunItem.canDualWield){
                cir.setReturnValue(BipedEntityModel.ArmPose.BOW_AND_ARROW);
            }
            cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_HOLD);
        }
    }

    @Unique private static boolean isDualWielding(PlayerEntity user){ return user.getStackInHand(Hand.MAIN_HAND).getItem() == user.getStackInHand(Hand.OFF_HAND).getItem(); }
}