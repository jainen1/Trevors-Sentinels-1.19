package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EntityShapeContext;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DataBlock extends Block {
    public DataBlock(Settings settings) { super(settings); }
    private static final VoxelShape FALLING_SHAPE = VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.9f, 1.0);

    @Override public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(this)) return true;
        return super.isSideInvisible(state, stateFrom, direction);
    }

    @Override public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity) || entity.getBlockStateAtPos().isOf(this)) {
            entity.slowMovement(state, new Vec3d(0.9f, 1.5f, 0.9f));
            if (world.isClient) {
                boolean bl; Random random = world.getRandom();
                boolean bl2 = bl = entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ();
                if (bl && random.nextBoolean()) {
                    world.addParticle(ParticleTypes.SPLASH, entity.getX(), pos.getY() + 1, entity.getZ(),
                            MathHelper.nextBetween(random, -1.0f, 1.0f) * 0.083333336f, 0.05f,
                            MathHelper.nextBetween(random, -1.0f, 1.0f) * 0.083333336f);
                }
            }
        } if (!world.isClient) entity.setOnFire(false);
    }

    @Override public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if ((double)fallDistance < 4.0 || !(entity instanceof LivingEntity livingEntity)) return;
        LivingEntity.FallSounds fallSounds = livingEntity.getFallSounds();
        SoundEvent soundEvent = (double)fallDistance < 7.0 ? fallSounds.small() : fallSounds.big();
        entity.playSound(soundEvent, 1.0f, 1.0f);
    }

    @Override public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Entity entity;
        if (context instanceof EntityShapeContext && (entity = ((EntityShapeContext)context).getEntity()) != null) {
            if (entity.fallDistance > 2.5f) return FALLING_SHAPE;
            if (context.isAbove(VoxelShapes.fullCube(), pos, false) && !context.isDescending())
                return super.getCollisionShape(state, world, pos, context);
        } return VoxelShapes.empty();
    }

    @Override public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) { return 1.0F; }
    @Override public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) { return VoxelShapes.empty(); }
    @Override public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) { return VoxelShapes.empty(); }
    @Override public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) { return false; }
}