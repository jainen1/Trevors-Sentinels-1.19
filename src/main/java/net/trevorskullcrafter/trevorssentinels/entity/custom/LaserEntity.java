package net.trevorskullcrafter.trevorssentinels.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.data.ItemTagGenerator;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import org.joml.Vector3f;

public class LaserEntity extends PersistentProjectileEntity {
    //Laser = 1, Gas = 2, Solid = 3
    private static final TrackedData<Integer> COLOR = DataTracker.registerData(LaserEntity.class, TrackedDataHandlerRegistry.INTEGER);
    float damageAmount; float laserSpeed; public int age; int maxLifeTime; int projectileType; StatusEffectInstance[] statusEffect;

    public LaserEntity(EntityType<? extends LaserEntity> entityType, World world) { super(entityType, world); }

    public LaserEntity(World world, LivingEntity owner, int lifeTime, float speed, float damage, int projectileType, int color, StatusEffectInstance[] effects) {
        super(ModEntities.LASER, owner, world); this.damageAmount = damage; this.laserSpeed = speed; this.maxLifeTime = lifeTime; this.projectileType = projectileType;
        this.statusEffect = effects; this.dataTracker.set(COLOR, color);
    }

    public LaserEntity(World world, double x, double y, double z, int lifeTime, float speed, float damage, int projectileType, int color, StatusEffectInstance[] effects) {
        super(ModEntities.LASER, x, y, z, world); this.damageAmount = damage; this.laserSpeed = speed; this.maxLifeTime = lifeTime; this.projectileType = projectileType;
        this.statusEffect = effects; this.dataTracker.set(COLOR, color);
    }

    @Override public void tick() {
        super.tick(); if(world.isClient) for(int i = 0; i <= 4; i++) world.addParticle(
            new DustParticleEffect(new Vector3f(Vec3d.unpackRgb(dataTracker.get(COLOR)).toVector3f().x(), Vec3d.unpackRgb(dataTracker.get(COLOR)).toVector3f().y(),
            Vec3d.unpackRgb(dataTracker.get(COLOR)).toVector3f().z()), 1.0f), true, getX(), getY(), getZ(), 0.0, 0.0, 0.0);
        else{ if(this.age>=this.maxLifeTime || this.laserSpeed <= 0.2f) this.discard(); else this.age++; }
    }

    @Override public ItemStack asItemStack() { return ModItems.ASH.getDefaultStack(); }
    @Override protected SoundEvent getHitSound() { return SoundEvents.ENTITY_GENERIC_EXPLODE; }
    @Override public boolean hasNoGravity() { return true; }
    @Override protected void initDataTracker() { super.initDataTracker(); this.dataTracker.startTracking(COLOR, 16711680); }
    @Override public boolean collidesWithStateAtPos(BlockPos pos, BlockState state) {
        return !(projectileType==1 && state.isIn(ItemTagGenerator.LASER_PASS));
    }

    private void reflectLaser1(Direction sideHit) {
        LaserEntity laser = new LaserEntity(world, this.getX(), this.getY(), this.getZ(), maxLifeTime-1, laserSpeed-0.2f,
                damageAmount, projectileType, dataTracker.get(COLOR), statusEffect);
        laser.setVelocity(this.getVelocity().x * ((sideHit == Direction.EAST || sideHit == Direction.WEST)? -1: 0),
                (this.getVelocity().y * ((sideHit == Direction.UP || sideHit == Direction.DOWN)? -1: 0)),
                (this.getVelocity().z * ((sideHit == Direction.NORTH || sideHit == Direction.SOUTH)? -1: 0)), laserSpeed-0.2f, 0);
        if(getOwner()!=null) laser.setOwner(getOwner()); world.spawnEntity(laser);
    }

    @Override protected void onCollision(HitResult hitResult) {
        HitResult.Type type = hitResult.getType();
        if(hitResult.getType() != HitResult.Type.MISS && world instanceof ServerWorld serverWorld) {
            if (type == HitResult.Type.ENTITY && ((EntityHitResult) hitResult).getEntity() instanceof LivingEntity entity) {
                if (damageAmount < 1) {
                    entity.heal(Math.abs(damageAmount));
                    serverWorld.spawnParticles(ParticleTypes.HEART, getX(), getY(), getZ(), (int) damageAmount, 0, 0, 0, 0.01);
                    serverWorld.playSound(null, getX(), getY(), getZ(), SoundEvents.BLOCK_NOTE_BLOCK_BELL.value(), SoundCategory.PLAYERS, 1, 1);
                } else {
                    entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), damageAmount);
                    if(projectileType != 2) doExplosion(serverWorld);
                }
                if (statusEffect != null) for (StatusEffectInstance sEI : statusEffect) entity.addStatusEffect(new StatusEffectInstance(sEI.getEffectType(),
                        sEI.getDuration(), sEI.getAmplifier(), sEI.isAmbient(), sEI.shouldShowParticles(), sEI.shouldShowIcon()));
                entity.addVelocity((getVelocity().multiply(0.1)));
                this.discard();
            } else if (type == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) hitResult;
                BlockState state = serverWorld.getBlockState(blockHitResult.getBlockPos());
                trevorssentinels.LOGGER.info("Trying block...");
                if(collidesWithStateAtPos(blockHitResult.getBlockPos(), state)){
                    trevorssentinels.LOGGER.info("Collides with block!");
                    if(projectileType != 2) doExplosion(serverWorld);
                    if(projectileType == 1 && state.isIn(ItemTagGenerator.LASER_REFLECTIVE)) reflectLaser1(blockHitResult.getSide());
                    state.onProjectileHit(serverWorld, state, blockHitResult, this);
                    this.discard();
                }
            }
        }
    }

    private void doExplosion(ServerWorld serverWorld){
        serverWorld.spawnParticles(ParticleTypes.SMOKE, getX(), getY(), getZ(), (int) damageAmount, 0, 0, 0, 0.05);
        serverWorld.spawnParticles(ParticleTypes.FLAME, getX(), getY(), getZ(), (int) damageAmount / 2, 0, 0, 0, 0.02);
        serverWorld.playSound(null, getX(), getY(), getZ(), getHitSound(), SoundCategory.PLAYERS, 1, 1);
    }
}