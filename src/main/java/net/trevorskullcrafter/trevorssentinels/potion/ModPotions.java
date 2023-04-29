package net.trevorskullcrafter.trevorssentinels.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModPotions {
    public static Potion REDSTONED_POTION;

    public static Potion registerPotion(String name, StatusEffectInstance statusEffectInstance){
        return Registry.register(Registries.POTION, new Identifier(trevorssentinels.MOD_ID, name), new Potion(statusEffectInstance));
    }

    public static void registerPotions(){
        trevorssentinels.LOGGER.info("Registering potions... (" + MOD_ID + ")");
        REDSTONED_POTION = registerPotion("redstoned_potion", new StatusEffectInstance(ModEffects.REDSTONED, 1000, 0));
    }
}