package net.trevorskullcrafter.trevorssentinels.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.item.custom.*;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModEffectItems {

    public static final Item RESISTANCE_ITEM = registerItem("resistance_item",
            new InfiniteEffectItem(getStatusEffects(1, new StatusEffectInstance(StatusEffects.RESISTANCE, 2, 0, false, false, false)),
                    "8_#AAAAAA_#555555", new FabricItemSettings().maxCount(1)));

    public static final Item JUMP_BOOST_ITEM = registerItem("jump_boost_item",
            new InfiniteEffectItem(getStatusEffects(1, new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 0, false, false, false)),
                    "8_#55FF55_#00AA00", new FabricItemSettings().maxCount(1)));

    public static final Item DOLPHINS_GRACE_ITEM = registerItem("dolphins_grace_item",
            new InfiniteEffectItem(getStatusEffects(1, new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1, 0, false, false, false)),
                    "8_#cddced_#577391", new FabricItemSettings().maxCount(1)));

    public static final Item HERO_OF_THE_VILLAGE_ITEM = registerItem("hero_of_the_village_item",
            new InfiniteEffectItem(getStatusEffects(1, new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 1, 0, false, false, false)),
                    "8_#55FF55_#00AA00", new FabricItemSettings().maxCount(1)));

    public static final Item SENTINUM_STOMACH = registerItem("sentinum_stomach",
            new InfiniteEffectItem(getStatusEffects(1, new StatusEffectInstance(StatusEffects.SATURATION, 1, 2, false, false, false)),
                    "8_#FF8F00_#AAAAAA", new FabricItemSettings().maxCount(1)));

    public static final Item ONE_PENCE = registerItem("one_pence",
            new InfiniteEffectItem(getStatusEffects(1, new StatusEffectInstance(StatusEffects.LUCK, 1, 9, false, false, false)),
                    "8_#e77c56_#8a4129", new FabricItemSettings().maxCount(1)));

    public static final Item REDSTONE_BONG = registerItem("redstone_bong",
            new InfiniteEffectItem(getStatusEffects(1, new StatusEffectInstance(ModEffects.REDSTONED, 1, 0, false, true, false)),
                    "8_#d90012_#9e000d", new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item);
    }

    public static void registerModItems(){
        trevorssentinels.LOGGER.info("Registering special items... ("+ MOD_ID + ")");
    }

    public static StatusEffectInstance[] getStatusEffects(int size, StatusEffectInstance effect){
        StatusEffectInstance[] effects = new StatusEffectInstance[size];
        effects[0] = effect;
        return effects;
    }

    public static StatusEffectInstance[] getStatusEffects(int size, StatusEffectInstance effect, StatusEffectInstance effectTwo){
        StatusEffectInstance[] effects = new StatusEffectInstance[size];
        effects[0] = effect;
        effects[1] = effectTwo;
        return effects;
    }
}