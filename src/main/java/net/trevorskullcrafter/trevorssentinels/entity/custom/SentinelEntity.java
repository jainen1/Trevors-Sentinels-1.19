package net.trevorskullcrafter.trevorssentinels.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

public class SentinelEntity extends HostileEntity implements GeoEntity, Flutterer {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation ATTACK = RawAnimation.begin().thenPlay("attack");
    private static final RawAnimation SCAN = RawAnimation.begin().thenPlay("scan");
    private static final RawAnimation BUILD = RawAnimation.begin().thenPlay("build");

    public SentinelEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 10, true);
    }

    public static DefaultAttributeContainer.Builder setAttributes(){
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.8f);
    }

    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) { return false; }
    @Override protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) { }

    @Override public boolean isClimbing() { return false; }

    @Override protected void initGoals(){
        this.goalSelector.add(0, new MeleeAttackGoal(this, 0.6f, true));
        this.goalSelector.add(2, new FlyRandomlyGoal(this));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, VillagerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
    }

    @Override public boolean canBreatheInWater() { return true; }

    @Override protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world){
            public boolean isValidPosition(BlockPos pos) { return !this.world.getBlockState(pos.down()).isAir(); }
        };
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(true);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    @Override protected SoundEvent getAmbientSound(){ return SoundEvents.ENTITY_BEE_LOOP; }
    @Override protected SoundEvent getHurtSound(DamageSource source){ return SoundEvents.ENTITY_BEE_HURT; }
    @Override protected SoundEvent getDeathSound(){ return SoundEvents.ENTITY_BEE_DEATH; }

    @Override public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(DefaultAnimations.getSpawnController(this, state -> state.setAndContinue(BUILD), 0));
        controllerRegistrar.add(DefaultAnimations.genericAttackAnimation(this, ATTACK));
        controllerRegistrar.add(DefaultAnimations.genericWalkController(this));
    }

    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return this.cache; }

    @Override public boolean isInAir() { return !this.onGround; }

    private static class FlyRandomlyGoal extends Goal {
        private final SentinelEntity entity;

        public FlyRandomlyGoal(SentinelEntity sentinel) {
            this.entity = sentinel;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            MoveControl moveControl = this.entity.getMoveControl();
            if (!moveControl.isMoving()) { return true; }
            else {
                double d = moveControl.getTargetX() - this.entity.getX();
                double e = moveControl.getTargetY() - this.entity.getY();
                double f = moveControl.getTargetZ() - this.entity.getZ();
                double g = d * d + e * e + f * f;
                return g < 1.0 || g > 3600.0;
            }
        }

        public boolean shouldContinue() { return false; }

        public void start() {
            Random random = this.entity.getRandom();
            double d = this.entity.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double e = this.entity.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            double f = this.entity.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.entity.getMoveControl().moveTo(d, e, f, 1.0);
        }
    }
}