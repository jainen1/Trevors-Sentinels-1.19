package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks(){
        trevorssentinels.LOGGER.info("Committing arson... ("+ MOD_ID + ")");
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.YGGDRASIL_LOG, 5, 5);
        registry.add(ModBlocks.YGGDRASIL_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_YGGDRASIL_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_YGGDRASIL_WOOD, 5, 5);

        registry.add(ModBlocks.YGGDRASIL_PLANKS, 5, 20);
        registry.add(ModBlocks.YGGDRASIL_LEAVES, 30, 60);


        registry.add(ModBlocks.CHARRED_OAK_LOG, 2, 2);
        registry.add(ModBlocks.CHARRED_OAK_WOOD, 2, 2);
        registry.add(ModBlocks.STRIPPED_CHARRED_OAK_LOG, 2, 2);
        registry.add(ModBlocks.STRIPPED_CHARRED_OAK_WOOD, 2, 2);

        registry.add(ModBlocks.CHARRED_OAK_PLANKS, 2, 8);


        registry.add(ModBlocks.MIDAS_LOG, 3, 3);
        registry.add(ModBlocks.MIDAS_WOOD, 3, 3);
        registry.add(ModBlocks.STRIPPED_MIDAS_LOG, 3, 3);
        registry.add(ModBlocks.STRIPPED_MIDAS_WOOD, 3, 3);

        registry.add(ModBlocks.MIDAS_PLANKS, 3, 12);
        registry.add(ModBlocks.MIDAS_LEAVES, 18, 40);


        registry.add(ModBlocks.BANANA_LOG, 5, 5);
        registry.add(ModBlocks.BANANA_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_BANANA_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_BANANA_WOOD, 5, 5);

        registry.add(ModBlocks.BANANA_PLANKS, 5, 20);
        registry.add(ModBlocks.BANANA_LEAVES, 30, 60);


        registry.add(ModBlocks.CERULII_LOG, 5, 5);
        registry.add(ModBlocks.CERULII_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_CERULII_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_CERULII_WOOD, 5, 5);

        registry.add(ModBlocks.CERULII_PLANKS, 5, 20);
        registry.add(ModBlocks.CERULII_LEAVES, 30, 60);
    }
}