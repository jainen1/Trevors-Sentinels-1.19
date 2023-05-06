package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.data.ItemTagGenerator;

public class MilkingBlock extends Block {
    //please don't ask, I didn't want to make this.
    public MilkingBlock(Settings settings) { super(settings); }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20));
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity){
        if(entity instanceof LivingEntity livingEntity && livingEntity.getType().isIn(ItemTagGenerator.MILKABLES)){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200));
        } super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
    }
}