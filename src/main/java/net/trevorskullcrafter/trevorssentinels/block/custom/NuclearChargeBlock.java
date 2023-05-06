package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import net.trevorskullcrafter.trevorssentinels.entity.custom.LaserEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.NuclearChargeEntity;
import net.trevorskullcrafter.trevorssentinels.data.ItemTagGenerator;
import org.jetbrains.annotations.Nullable;

public class NuclearChargeBlock extends Block {
    public static final BooleanProperty UNSTABLE = Properties.UNSTABLE;
    public NuclearChargeBlock(AbstractBlock.Settings settings) {
        super(settings); this.setDefaultState(this.getDefaultState().with(UNSTABLE, false));
    }

    @Override public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.isOf(state.getBlock())) return;
        if (world.isReceivingRedstonePower(pos)) { NuclearChargeBlock.primeTnt(world, pos); world.removeBlock(pos, false); }
    }

    @Override public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) { NuclearChargeBlock.primeTnt(world, pos); world.removeBlock(pos, false); }
    }

    @Override public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && !player.isCreative() && state.get(UNSTABLE)) NuclearChargeBlock.primeTnt(world, pos);
        super.onBreak(world, pos, state, player);
    }

    @Override public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (world.isClient) return;
        NuclearChargeEntity tntEntity = new NuclearChargeEntity(world, (double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, explosion.getCausingEntity());
        int i = tntEntity.getFuse();
        tntEntity.setFuse((short)(world.random.nextInt(i / 4) + i / 8));
        world.spawnEntity(tntEntity);
    }

    public static void primeTnt(World world, BlockPos pos) { NuclearChargeBlock.primeTnt(world, pos, null); }
    private static void primeTnt(World world, BlockPos pos, @Nullable LivingEntity igniter) {
        if (world.isClient) return;
        NuclearChargeEntity tntEntity = new NuclearChargeEntity(world, (double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, igniter);
        world.spawnEntity(tntEntity);
        world.playSound(null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
        world.emitGameEvent(igniter, GameEvent.PRIME_FUSE, pos);
    }

    @Override public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player2, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player2.getStackInHand(hand);
        if (itemStack.isIn(ItemTagGenerator.NUCLEAR_CHARGE_ACTIVATOR)) {
            NuclearChargeBlock.primeTnt(world, pos, player2);
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            Item item = itemStack.getItem();
            player2.incrementStat(Stats.USED.getOrCreateStat(item));
            return ActionResult.success(world.isClient);
        } return super.onUse(state, world, pos, player2, hand, hit);
    }

    @Override public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient){
            BlockPos blockPos = hit.getBlockPos(); Entity entity = projectile.getOwner();
            if (projectile instanceof LaserEntity && projectile.canModifyAt(world, blockPos)){
                primeTnt(world, blockPos, entity instanceof LivingEntity ? (LivingEntity)entity : null);
                world.removeBlock(blockPos, false);
            }
        }
    }

    @Override public boolean shouldDropItemsOnExplosion(Explosion explosion) { return false; }
    @Override protected void appendProperties(StateManager.Builder<Block, BlockState> builder) { builder.add(UNSTABLE); }
}