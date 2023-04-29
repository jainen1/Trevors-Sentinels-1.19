package net.trevorskullcrafter.trevorssentinels.entity.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;

public class ShardEntity extends ThrownItemEntity {
    public ShardEntity(EntityType<? extends ShardEntity> entityType, World world) { super(entityType, world); }
    public ShardEntity(World world, LivingEntity owner) { super(ModEntities.GALINITE_SHARD, owner, world); }
    public ShardEntity(World world, double x, double y, double z) { super(ModEntities.GALINITE_SHARD, x, y, z, world); }

    @Override protected Item getDefaultItem() { return ModItems.GALINITE_SHARD; }

    @Environment(EnvType.CLIENT) private ParticleEffect getParticleParameters() { // Not entirely sure, but probably has to do with the snowball's particles. (OPTIONAL)
        ItemStack itemStack = ModItems.GALINITE_SHARD.getDefaultStack();
        return itemStack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack);
    }

    @Environment(EnvType.CLIENT) public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();
            for(int i = 0; i < 8; ++i) this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 3);
    }

    @Override protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES); this.discard();
        }
    }
}