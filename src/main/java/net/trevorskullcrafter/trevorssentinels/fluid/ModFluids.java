package net.trevorskullcrafter.trevorssentinels.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModFluids {
    public static FlowableFluid QUICKSAND_STILL;
    public static FlowableFluid QUICKSAND_FLOWING;
    public static Block QUICKSAND_BLOCK;
    public static Item QUICKSAND_BUCKET;

    public static void registerFluids(){
        trevorssentinels.LOGGER.info("Registering fluids... ("+ MOD_ID + ")");
        QUICKSAND_STILL = Registry.register(Registries.FLUID,
                new Identifier(trevorssentinels.MOD_ID, "quicksand"), new QuicksandFluid.Still());
        QUICKSAND_FLOWING = Registry.register(Registries.FLUID,
                new Identifier(trevorssentinels.MOD_ID, "flowing_quicksand"), new QuicksandFluid.Flowing());

        QUICKSAND_BLOCK = Registry.register(Registries.BLOCK, new Identifier(trevorssentinels.MOD_ID, "quicksand_block"),
                new FluidBlock(ModFluids.QUICKSAND_STILL, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        QUICKSAND_BUCKET = Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, "quicksand_bucket"),
                new BucketItem(ModFluids.QUICKSAND_STILL, new FabricItemSettings().maxCount(1).recipeRemainder(Items.BUCKET)));
    }
}