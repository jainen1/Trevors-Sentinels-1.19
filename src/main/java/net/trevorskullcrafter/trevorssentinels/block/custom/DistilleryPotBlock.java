package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class DistilleryPotBlock extends CropBlock {
    public int maxAge;
    public final IntProperty AGE = IntProperty.of("age",0, maxAge);
    final ItemConvertible item;

    public DistilleryPotBlock(int maxAge, ItemConvertible item, Settings settings) {
        super(settings);
        this.maxAge = maxAge;
        this.item = item;
    }

    @Override protected ItemConvertible getSeedsItem(){ return item; }

    @Override public int getMaxAge(){ return maxAge; }

    @Override public IntProperty getAgeProperty(){ return AGE; }

    @Override protected void appendProperties(StateManager.Builder<Block, BlockState> builder){ builder.add(AGE); }

    @Override protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) { return floor.isFullCube(world, pos); }
}