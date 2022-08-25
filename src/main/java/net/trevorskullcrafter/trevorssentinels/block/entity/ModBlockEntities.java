package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModBlockEntities {
    public static BlockEntityType<ForgeBlockEntity> FORGE;
    /*public static BlockEntityType<SuperforgeBlockEntity> SUPERFORGE;*/

    public static void registerAllBlockEntities(){
        FORGE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MOD_ID, "forge"),
                FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new,
                        ModBlocks.FORGE).build(null));
        /*SUPERFORGE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MOD_ID, "superforge"),
                FabricBlockEntityTypeBuilder.create(SuperforgeBlockEntity::new,
                        ModBlocks.SUPERFORGE).build(null));*/
    }
}
