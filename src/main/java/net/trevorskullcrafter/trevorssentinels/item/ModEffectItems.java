package net.trevorskullcrafter.trevorssentinels.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
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
            new InfiniteEffectItem(new FabricItemSettings().maxCount(1),
                    new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false)));

    public static final Item FIRE_RESISTANCE_ITEM = registerItem("fire_resistance_item",
            new InfiniteEffectItem(new FabricItemSettings().maxCount(1).fireproof(),
                    new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 1, false, false),
                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false)));

    public static final Item JUMP_BOOST_ITEM = registerItem("jump_boost_item",
            new InfiniteEffectItem(new FabricItemSettings().maxCount(1),
                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 0, false, false)));

    public static final Item DOLPHINS_GRACE_ITEM = registerItem("dolphins_grace_item",
            new InfiniteEffectItem(new FabricItemSettings().maxCount(1),
                    new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 200, 0, false, false)));

    public static final Item HERO_OF_THE_VILLAGE_ITEM = registerItem("hero_of_the_village_item",
            new InfiniteEffectItem(new FabricItemSettings().maxCount(1),
                    new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 200, 0, false, false)));

    public static final Item GALINITE_STOMACH = registerItem("galinite_stomach",
            new InfiniteEffectItem(new FabricItemSettings().maxCount(1),
                    new StatusEffectInstance(ModEffects.WELL_FED, 200, 5, false, false)));

    public static final Item ONE_PENCE = registerItem("one_pence",
            new InfiniteEffectItem(new FabricItemSettings().maxCount(1),
                    new StatusEffectInstance(StatusEffects.LUCK, 200, 9, false, false)));

    public static final Item WEAKNESS_ITEM = registerItem("weakness_item",
            new InfiniteEffectItem(new FabricItemSettings().maxCount(1),
                    new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 0, false, false)));

    private static Item registerItem(String name, Item item){
        ItemGroupEvents.modifyEntriesEvent(trevorssentinels.EFFECTS).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item);
    }
    public static void registerModItems(){ trevorssentinels.LOGGER.info("Registering items with status effects... ("+ MOD_ID + ")"); }
}