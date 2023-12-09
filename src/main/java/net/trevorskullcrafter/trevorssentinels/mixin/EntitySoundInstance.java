package net.trevorskullcrafter.trevorssentinels.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class EntitySoundInstance extends MovingSoundInstance {
    protected final Entity entity;

    public EntitySoundInstance(Entity entity, SoundEvent sound, SoundCategory soundCategory) {
        super(sound, soundCategory, SoundInstance.createRandom());
        this.entity = entity;
        this.x = (float)entity.getX();
        this.y = (float)entity.getY();
        this.z = (float)entity.getZ();
        this.repeat = true;
        this.repeatDelay = 0;
        this.volume = 0.0F;
    }

    public void tick() {
        this.x = (float)this.entity.getX();
        this.y = (float)this.entity.getY();
        this.z = (float)this.entity.getZ();
        float f = (float)this.entity.getVelocity().horizontalLength();
        if (f >= 0.01F) {
            this.pitch = MathHelper.lerp(MathHelper.clamp(f, this.getMinPitch(), this.getMaxPitch()), this.getMinPitch(), this.getMaxPitch());
            this.volume = MathHelper.lerp(MathHelper.clamp(f, 0.0F, 0.5F), 0.0F, 1.2F);
        } else {
            this.pitch = 0.0F;
            this.volume = 0.0F;
        }
    }

    private float getMinPitch() { return (entity instanceof LivingEntity livingEntity && livingEntity.isBaby()) ? 1.1F : 0.7F; }
    private float getMaxPitch() { return (entity instanceof LivingEntity livingEntity && livingEntity.isBaby()) ? 1.5F : 1.1F; }
    public boolean shouldAlwaysPlay() { return true; }
    public boolean canPlay() { return !this.entity.isSilent(); }
}