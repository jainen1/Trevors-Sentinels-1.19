package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks(){
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.YGGDRASIL_LOG, 5, 5);
        registry.add(ModBlocks.YGGDRASIL_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_YGGDRASIL_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_YGGDRASIL_WOOD, 5, 5);

        registry.add(ModBlocks.YGGDRASIL_PLANKS, 5, 20);
        registry.add(ModBlocks.YGGDRASIL_LEAVES, 30, 60);
    }
}