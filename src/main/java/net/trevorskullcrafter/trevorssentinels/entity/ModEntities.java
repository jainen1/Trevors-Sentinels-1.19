package net.trevorskullcrafter.trevorssentinels.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.*;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModEntities {
    public static final EntityType<SentinelEntity> SENTINEL = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "sentinel"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SentinelEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build());
    public static final EntityType<RoombaEntity> SENTINUM_ROOMBA = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "sentinum_roomba"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RoombaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.2f)).build());
    public static final EntityType<FlorbusEntity> FLORBUS = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "florbus"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FlorbusEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.25f)).build());
    /*public static final EntityType<NuclearChargeEntity> NUCLEAR_CHARGE = Registry.register(
            "nuclear_charge", FabricEntityTypeBuilder.create(SpawnGroup.MISC, NuclearChargeEntity::new)
                    .makeFireImmune().setDimensions(0.98f, 0.98f).maxTrackingRange(10).trackingTickInterval(10));*/
}