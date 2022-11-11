package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;

public class ModStrippableBlocks {
    public static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.YGGDRASIL_LOG, ModBlocks.STRIPPED_YGGDRASIL_LOG);
        StrippableBlockRegistry.register(ModBlocks.YGGDRASIL_WOOD, ModBlocks.STRIPPED_YGGDRASIL_WOOD);
    }
}
