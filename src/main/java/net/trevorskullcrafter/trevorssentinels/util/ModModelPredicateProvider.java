package net.trevorskullcrafter.trevorssentinels.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        ModelPredicateProviderRegistry.register(ModItems.SENTINUM_HOLOPROJECTOR, new Identifier(trevorssentinels.MOD_ID, "mode"),
                (stack, world, entity, seed) -> {
            if (stack.getSubNbt("trevorssentinels:holoprojector") != null) {
                if (stack.getSubNbt("trevorssentinels:holoprojector").getInt("trevorssentinels:holoMode") == 2) {
                    return 0.5f;
                } else if (stack.getSubNbt("trevorssentinels:holoprojector").getInt("trevorssentinels:holoMode") == 3) {
                    return 1.0f;
                }
            }
            return 0.0f;
        });
    }
}