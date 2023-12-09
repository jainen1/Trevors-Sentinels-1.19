package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.sound.AbstractSoundInstance;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.PassiveBeeSoundInstance;
import net.minecraft.client.sound.TickableSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.random.Random;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class SpawnNoiseMixin {
    @Shadow client;

    @Inject(method = "playSpawnSound", at = @At("TAIL"))
    private void playSpawnSound(Entity entity, CallbackInfo ci){
        this.client.getSoundManager().playNextTick((TickableSoundInstance)new MovingSoundInstance(ModSounds.FLESH_PLACE, SoundCategory.HOSTILE, Random.create()));
    }
}
