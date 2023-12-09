package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.sound.AbstractSoundInstance;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.PassiveBeeSoundInstance;
import net.minecraft.client.sound.TickableSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.random.Random;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientCommonNetworkHandler.class)
public class ClientImplementerMixin {
    @Final @Shadow protected MinecraftClient client;
}