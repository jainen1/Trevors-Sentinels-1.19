package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModEffects {
    public static StatusEffect REDSTONED;
    public static StatusEffect FLIGHT;

    public static StatusEffect registerRedstoned(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(trevorssentinels.MOD_ID, name),
                new RedstonedStatusEffect(StatusEffectCategory.NEUTRAL, 0xd90012));
    }

    public static StatusEffect registerFlight(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(trevorssentinels.MOD_ID, name),
                new FlightStatusEffect(StatusEffectCategory.BENEFICIAL, 0x5c7bc1));
    }

    public static void registerStatusEffects(){
        REDSTONED = registerRedstoned("redstoned");
        FLIGHT = registerFlight("flight");
    }
}
