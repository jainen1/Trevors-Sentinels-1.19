package net.trevorskullcrafter.trevorssentinels.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.trevorskullcrafter.trevorssentinels.datagen.BlockTagGenerator;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.joml.Vector3f;

public class LaserEntity extends ThrownEntity {
    private static final TrackedData<Integer> COLOR = DataTracker.registerData(LaserEntity.class, TrackedDataHandlerRegistry.INTEGER);
    float damage; float laserSpeed; int lifetime; StatusEffectInstance[] effects;

    public LaserEntity(EntityType<? extends LaserEntity> type, World world) { super(type, world); }

    public LaserEntity(EntityType<? extends LaserEntity> type, double x, double y, double z, World world, int lifetime, float speed, float damage, int color, StatusEffectInstance... effects) {
        this(type, world); this.setPosition(x, y, z); this.damage = damage; this.laserSpeed = speed; this.lifetime = lifetime; this.effects = effects; this.dataTracker.set(COLOR, color);
    }

    public LaserEntity(EntityType<? extends LaserEntity> type, World world, LivingEntity owner, int lifetime, float speed, float damage, int color, StatusEffectInstance... effects) {
        this(type, owner.getX(), owner.getEyeY() /* - 0.10000000149011612 */, owner.getZ(), world, lifetime, speed, damage, color, effects); setOwner(owner);
    }

    @Override public void setVelocity(Entity shooter, float pitch, float yaw, float roll, float speed, float divergence) {
        float x = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float y = -MathHelper.sin((pitch + roll) * 0.017453292F);
        float z = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        this.setVelocity(x, y, z, speed, divergence);
    }

    @Override public void tick() {
        super.tick(); if(!getWorld().isClient()) { if(this.lifetime < 1 || this.laserSpeed <= 0.2f) { this.discard(); } else { this.lifetime--; }}
        if(getWorld().isClient()) { for(int i = 0; i <= 4; i++) {
            getWorld().addParticle(new DustParticleEffect(new Vector3f(Vec3d.unpackRgb(getColor()).toVector3f().x(), Vec3d.unpackRgb(getColor()).toVector3f().y(),
                    Vec3d.unpackRgb(getColor()).toVector3f().z()), 1.0f), true, getX(), getY(), getZ(), 0.0, 0.0, 0.0);
        }}
    }

    @Override protected void onCollision(HitResult hitResult) {
        HitResult.Type type = hitResult.getType();
        if(hitResult.getType() != HitResult.Type.MISS && getWorld() instanceof ServerWorld serverWorld) {
            if (type == HitResult.Type.ENTITY && ((EntityHitResult) hitResult).getEntity() instanceof LivingEntity entity) {
                if (damage < 1) {
                    entity.heal(Math.abs(damage));
                    serverWorld.spawnParticles(ParticleTypes.HEART, getX(), getY(), getZ(), (int) damage, 0, 0, 0, 0.01);
                    serverWorld.playSound(null, getX(), getY(), getZ(), SoundEvents.BLOCK_NOTE_BLOCK_BELL.value(), SoundCategory.PLAYERS, 1, 1);
                } else {
                    entity.damage(entity.getDamageSources().mobProjectile(this, getOwner() instanceof LivingEntity livingEntity? livingEntity : null), damage);
                    doExplosion(serverWorld);
                }
                if (effects != null) for (StatusEffectInstance sEI : effects) entity.addStatusEffect(new StatusEffectInstance(sEI.getEffectType(),
                        sEI.getDuration(), sEI.getAmplifier(), sEI.isAmbient(), sEI.shouldShowParticles(), sEI.shouldShowIcon()));
                entity.addVelocity((getVelocity().multiply(0.1)));
                this.discard();
            } else if (type == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) hitResult;
                BlockState state = serverWorld.getBlockState(blockHitResult.getBlockPos());
                if(collidesWithStateAtPos(blockHitResult.getBlockPos(), state)){
                    state.onProjectileHit(serverWorld, state, blockHitResult, this);
                    doExplosion(serverWorld);
                    reflect(state, blockHitResult);
                }
            }
        }

        if (type == HitResult.Type.ENTITY) {
            this.onEntityHit((EntityHitResult)hitResult);
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, hitResult.getPos(), GameEvent.Emitter.of(this, null));
        } else if (type == HitResult.Type.BLOCK) {
            BlockHitResult blockHitResult = (BlockHitResult)hitResult;
            this.onBlockHit(blockHitResult);
            BlockPos blockPos = blockHitResult.getBlockPos();
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, blockPos, GameEvent.Emitter.of(this, this.getWorld().getBlockState(blockPos)));
        }
    }

    public void reflect(BlockState state, BlockHitResult blockHitResult){
        if(state.isIn(BlockTagGenerator.LASER_REFLECTIVE)){
            lifetime--; laserSpeed -= 0.2f;
            Direction sideHit = blockHitResult.getSide();
            setVelocity(this.getVelocity().x * ((sideHit == Direction.EAST || sideHit == Direction.WEST)? -1: 0),
                    (this.getVelocity().y * ((sideHit == Direction.UP || sideHit == Direction.DOWN)? -1: 0)),
                    (this.getVelocity().z * ((sideHit == Direction.NORTH || sideHit == Direction.SOUTH)? -1: 0)), laserSpeed-0.2f, 0);
        } else { this.discard(); }
    }

    public void doExplosion(ServerWorld serverWorld){
        serverWorld.spawnParticles(ParticleTypes.SMOKE, getX(), getY(), getZ(), (int) damage, 0, 0, 0, 0.05);
        serverWorld.spawnParticles(ParticleTypes.FLAME, getX(), getY(), getZ(), (int) damage / 2, 0, 0, 0, 0.02);
        serverWorld.playSound(null, getX(), getY(), getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1, 1);
    }

    @Override protected float getGravity() { return 0.0F; }
    @Override protected void initDataTracker() { this.dataTracker.startTracking(COLOR, TextUtil.BLOOD_RED.getRGB()); }
    @Override public boolean collidesWithStateAtPos(BlockPos pos, BlockState state) { return !state.isIn(BlockTagGenerator.LASER_PROJECTILE_PASS); }
    public void setColor(Integer color) { this.getDataTracker().set(COLOR, color); }
    public Integer getColor() { return this.getDataTracker().get(COLOR); }

    @Override protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Color", getColor());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setColor(nbt.getInt("Color"));
    }
}