package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import javax.annotation.Nullable;

public class NuclearChargeEntity extends TntEntity {
    public NuclearChargeEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        super(world, x, y, z, igniter);
    }

    public NuclearChargeEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
    }

    private void explode() {
        float f = 4.0f;
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 12.0f, Explosion.DestructionType.BREAK);
    }
}