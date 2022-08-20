package net.trevorskullcrafter.trevorssentinels.item;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModItems {
    public static final Item SENTINUM_SHARD = registerItem("sentinum_shard",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));
    public static final Item BLOOD_DIAMOND = registerItem("blood_diamond",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item VIOLENT_CATALYST = registerItem("violent_catalyst",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item FRIED_EGG = registerItem("fried_egg",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN).food(ModFoodComponents.FRIED_EGG).maxCount(128)));

    public static final Item PEARFRUIT = registerItem("pearfruit",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN).food(ModFoodComponents.PEARFRUIT)));

    public static final Item BROWNIE = registerItem("brownie",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN).food(ModFoodComponents.BROWNIE)));

    public static final Item ANTIMILK = registerItem("antimilk",
            new Item(new FabricItemSettings().group(ModItemGroup.KITCHEN).food(ModFoodComponents.ANTIMILK)));

    public static final Item ASH = registerItem("ash",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item DARKSTEEL_INGOT = registerItem("darksteel_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item IRON_GOLD_INGOT = registerItem("iron_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));

    public static final Item URANIUM_CRYSTAL = registerItem("uranium_crystal",
            new Item(new FabricItemSettings().group(ModItemGroup.SENTINELS)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(trevorssentinels.MOD_ID, name), item);
    }
    public static void registerModItems(){
        trevorssentinels.LOGGER.info("Registering Mod Items for "+ MOD_ID);
    }
}
