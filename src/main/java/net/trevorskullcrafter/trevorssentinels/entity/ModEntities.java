package net.trevorskullcrafter.trevorssentinels.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.trevorskullcrafter.trevorssentinels.entity.custom.SentinelEntity;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModEntities {
    public static final EntityType<SentinelEntity> SENTINEL = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "sentinel"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SentinelEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 1.0f)).build());
}
