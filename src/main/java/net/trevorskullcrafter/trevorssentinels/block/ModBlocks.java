package net.trevorskullcrafter.trevorssentinels.block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.trevorskullcrafter.trevorssentinels.item.ModItemGroup;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModBlocks {

    public static final Block SENTINUM_BLOCK = registerBlock("sentinum_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3.5f,3f).requiresTool()), ModItemGroup.SENTINELS);

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f,8f).requiresTool()), ModItemGroup.SENTINELS);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(trevorssentinels.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(trevorssentinels.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks(){
        trevorssentinels.LOGGER.info("Registering ModBlocks for " + trevorssentinels.MOD_ID);
    }
}
