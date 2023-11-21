package net.trevorskullcrafter.trevorssentinels.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import org.jetbrains.annotations.Nullable;

public class DaggerEntity extends PersistentProjectileEntity {
    private static final TrackedData<ItemStack> STORED_STACK = DataTracker.registerData(DaggerEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);
    private StatusEffectInstance[] effects;
    private float destroyChance;
    private boolean dealtDamage;

    public DaggerEntity(EntityType<? extends DaggerEntity> entityType, World world) { super(entityType, world); }

    public DaggerEntity(World world, LivingEntity owner, ItemStack stack, float damage, float destroyChance, StatusEffectInstance... effects) {
        super(ModEntities.DAGGER, owner, world);
        this.dataTracker.set(STORED_STACK, stack.copy()); this.setDamage(damage); this.effects = effects; this.destroyChance = destroyChance;
    }
    public DaggerEntity(World world, double x, double y, double z, ItemStack stack, float damage, float destroyChance, StatusEffectInstance... effects) {
        super(ModEntities.DAGGER, x, y, z, world);
        this.dataTracker.set(STORED_STACK, stack.copy()); this.setDamage(damage); this.effects = effects; this.destroyChance = destroyChance;
    }

    @Override public boolean isCritical() { return true; }
    @Override public boolean isCollidable() { return inGround; }

    @Override public void onPlayerCollision(PlayerEntity player) {
        if(player.isSneaking()) super.onPlayerCollision(player);
    }

    @Override protected float getDragInWater() { return 0.8f; }
    @Override protected SoundEvent getHitSound() { return SoundEvents.ITEM_TRIDENT_HIT_GROUND; }
    @Override public boolean shouldRender(double cameraX, double cameraY, double cameraZ) { return true; }

    protected boolean tryPickup(PlayerEntity player) {
        return super.tryPickup(player) || (this.isNoClip() && player.getInventory().insertStack(asItemStack()));
    }

    @Override public ItemStack asItemStack() { return dataTracker.get(STORED_STACK); }

    @Override public void tick() {
        if(this.inGroundTime > 4) this.dealtDamage = true; if(this.inGroundTime > 6000){
            if(pickupType != PickupPermission.CREATIVE_ONLY) dropStack(asItemStack(), 0.1F);
            discard();
        } super.tick();
    }

    @Nullable protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        return this.dealtDamage ? null : super.getEntityCollision(currentPosition, nextPosition);
    }

    @Override protected void age() {}
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        this.dealtDamage = true;
        if (entity.damage(getDamageSources().mobProjectile(this, getOwner() instanceof LivingEntity livingEntity? livingEntity : null), (float) getDamage())) {
            if (entity.getType() == EntityType.ENDERMAN) return;
            if (entity instanceof LivingEntity livingEntity){
                this.onHit(livingEntity);
                for(StatusEffectInstance effect : effects) livingEntity.addStatusEffect(new StatusEffectInstance(effect.getEffectType(), effect.getDuration(),
                        effect.getAmplifier(), effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon()));
            }
        }
        this.setVelocity(this.getVelocity().multiply(-0.01, -0.1, -0.01));
        this.playSound(SoundEvents.ITEM_TRIDENT_HIT, 1.0f, 1.0F);
    }

    @Override protected void onCollision(HitResult hitResult) {
        if((hitResult.getType() == HitResult.Type.ENTITY || hitResult.getType() == HitResult.Type.BLOCK) && (random.nextFloat() % 1f) < destroyChance) {
            if(getWorld() instanceof ServerWorld serverWorld) {
                ParticleEffect particleEffect = new ItemStackParticleEffect(ParticleTypes.ITEM, asItemStack());
                serverWorld.spawnParticles(particleEffect, getX(), getY(), getZ(), 8, 0, 0, 0, 0.1);
                serverWorld.playSound(null, getX(), getY(), getZ(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1, 1);
                this.discard();
            }
        } super.onCollision(hitResult);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(STORED_STACK, ModArmory.SCRAP_DAGGER.getDefaultStack());
    }
}