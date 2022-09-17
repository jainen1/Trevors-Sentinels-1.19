package net.trevorskullcrafter.trevorssentinels.fluid;

import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid QUICKSAND_STILL = register("quicksand_still", new QuicksandFluid.Still());
    public static final FlowableFluid QUICKSAND_FLOWING = register("quicksand_flowing", new QuicksandFluid.Flowing());

    private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
        return Registry.register(Registry.FLUID, new Identifier(trevorssentinels.MOD_ID, name), flowableFluid);
    }
}