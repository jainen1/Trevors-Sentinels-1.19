package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModStrippableBlocks {
    public static void registerStrippables(){
        trevorssentinels.LOGGER.info("Stripping logs... ("+ MOD_ID + ")");
        StrippableBlockRegistry.register(ModBlocks.YGGDRASIL_LOG, ModBlocks.STRIPPED_YGGDRASIL_LOG);
        StrippableBlockRegistry.register(ModBlocks.YGGDRASIL_WOOD, ModBlocks.STRIPPED_YGGDRASIL_WOOD);

        StrippableBlockRegistry.register(ModBlocks.CHARRED_OAK_LOG, ModBlocks.STRIPPED_CHARRED_OAK_LOG);
        StrippableBlockRegistry.register(ModBlocks.CHARRED_OAK_WOOD, ModBlocks.STRIPPED_CHARRED_OAK_WOOD);

        StrippableBlockRegistry.register(ModBlocks.MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_LOG);
        StrippableBlockRegistry.register(ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_WOOD);

        StrippableBlockRegistry.register(ModBlocks.BANANA_LOG, ModBlocks.STRIPPED_BANANA_LOG);
        StrippableBlockRegistry.register(ModBlocks.BANANA_WOOD, ModBlocks.STRIPPED_BANANA_WOOD);
    }
}