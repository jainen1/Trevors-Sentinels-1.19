package net.trevorskullcrafter.trevorssentinels.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModRecipes {
    public static void registerRecipes(){
        trevorssentinels.LOGGER.info("Cooking up some fun... ("+ MOD_ID + ")");
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(trevorssentinels.MOD_ID, ForgeRecipe.Serializer.ID),
                ForgeRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(trevorssentinels.MOD_ID, ForgeRecipe.Type.ID),
                ForgeRecipe.Type.INSTANCE);
    }
}