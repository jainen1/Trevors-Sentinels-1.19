package net.trevorskullcrafter.trevorssentinels.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(trevorssentinels.MOD_ID, ForgeRecipe.Serializer.ID),
                ForgeRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(trevorssentinels.MOD_ID, ForgeRecipe.Type.ID),
                ForgeRecipe.Type.INSTANCE);
    }
}
