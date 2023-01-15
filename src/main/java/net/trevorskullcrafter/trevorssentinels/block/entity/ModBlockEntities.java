package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.block.entity.client.VendorBlockEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModBlockEntities {
    public static BlockEntityType<ForgeBlockEntity> FORGE;
    public static BlockEntityType<VendorBlockEntity> VENDOR;
    public static BlockEntityType<SuperforgeBlockEntity> SUPERFORGE;

    public static void registerBlockEntities(){
        trevorssentinels.LOGGER.info("Registering block entities... (" + MOD_ID + ")");
        FORGE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(MOD_ID, "forge"),
                FabricBlockEntityTypeBuilder.create(ForgeBlockEntity::new,
                        ModBlocks.FORGE).build(null));

        VENDOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(MOD_ID, "vendor"),
                FabricBlockEntityTypeBuilder.create(VendorBlockEntity::new,
                        ModBlocks.VENDOR).build(null));

        SUPERFORGE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(MOD_ID, "superforge"),
                FabricBlockEntityTypeBuilder.create(SuperforgeBlockEntity::new,
                        ModBlocks.SUPERFORGE).build(null));
    }
}
