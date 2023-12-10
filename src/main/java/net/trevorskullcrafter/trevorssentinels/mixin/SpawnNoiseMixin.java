package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.sound.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class SpawnNoiseMixin extends ClientImplementerMixin {

    @Inject(method = "playSpawnSound", at = @At("TAIL"))
    private void playSpawnSound(Entity entity, CallbackInfo ci){
        //@Nullable TickableSoundInstance soundInstance = null;
        //if (entity instanceof BoatEntity boat) { soundInstance = new EntitySoundInstance(boat, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS); }
        //this.client.getSoundManager().play(soundInstance);
    }
}