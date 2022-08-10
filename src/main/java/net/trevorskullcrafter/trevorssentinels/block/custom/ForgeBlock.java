package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.Block;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;

public class ForgeBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public ForgeBlock(Settings settings){
        super(settings);
    }
}
