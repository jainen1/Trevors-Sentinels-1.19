package net.trevorskullcrafter.trevorssentinels.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.datagen.BlockTagGenerator;
import org.joml.Vector3f;

public class GasEntity extends LaserEntity{
    public GasEntity(EntityType<? extends LaserEntity> type, World world) {
        super(type, world);
    }

    public GasEntity(EntityType<? extends LaserEntity> type, double x, double y, double z, World world, int lifetime, float speed, float damage, int color, StatusEffectInstance... effects) {
        super(type, x, y, z, world, lifetime, speed, damage, color, effects);
    }

    public GasEntity(EntityType<? extends LaserEntity> type, World world, LivingEntity owner, int lifetime, float speed, float damage, int color, StatusEffectInstance... effects) {
        super(type, world, owner, lifetime, speed, damage, color, effects);
    }

    @Override protected float getGravity() { return 0.005F; }
    @Override public void reflect(BlockState state, BlockHitResult blockHitResult) {}
    @Override public void doExplosion(ServerWorld serverWorld) {
        AreaEffectCloudEntity entity = new AreaEffectCloudEntity(getWorld(), this.getX(), this.getY(), this.getZ());
        entity.setColor(getColor());
        entity.setDuration(100);
        entity.setRadius(2.0F);
        if(getOwner() instanceof LivingEntity livingOwner) { entity.setOwner(livingOwner); }
        for(StatusEffectInstance effect : effects){ entity.addEffect(effect); }
        getWorld().spawnEntity(entity);
        this.discard();
    }

    @Override public void tick() {
        super.tick();
        if(getWorld().isClient()) { for(int i = 0; i <= 24; i++) {
            getWorld().addParticle(new DustParticleEffect(new Vector3f(Vec3d.unpackRgb(getColor()).toVector3f().x(), Vec3d.unpackRgb(getColor()).toVector3f().y(),
                    Vec3d.unpackRgb(getColor()).toVector3f().z()), 1.0f), true, getX() + ((double) Random.create().nextBetween(-10, 20) / 50),
                    getY() + ((double) Random.create().nextBetween(-10, 20) / 50), getZ() + ((double) Random.create().nextBetween(-10, 20) / 50), 0.0, 0.0, 0.0);
        }}
    }

    @Override public boolean collidesWithStateAtPos(BlockPos pos, BlockState state) {
        return !state.isIn(BlockTagGenerator.SOLID_PROJECTILE_PASS);
    }
}