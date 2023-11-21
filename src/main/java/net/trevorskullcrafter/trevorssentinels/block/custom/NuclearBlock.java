package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;

public class NuclearBlock extends Block {
    public NuclearBlock(Settings settings) { super(settings); }

    @Override public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(ModEffects.IRRADIATED, 20));
        super.onBreak(world, pos, state, player);
    }

    @Override public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity){
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.IRRADIATED, 200));
        } super.onSteppedOn(world, pos, state, entity);
    }

    @Override public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
    }
}