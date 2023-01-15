package net.trevorskullcrafter.trevorssentinels.block.entity.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModBlockEntities;

public class VendorBlockEntity extends BlockEntity {

    public VendorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.VENDOR, pos, state);
    }
}