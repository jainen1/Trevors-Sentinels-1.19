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
                    .dimensions(EntityDimensions.fixed(0.7f, 0.6f)).build());
    public static final EntityType<RoombaEntity> GALINITE_ROOMBA = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "sentinum_roomba"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RoombaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.2f)).build());
    public static final EntityType<FlorbusEntity> FLORBUS = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "florbus"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FlorbusEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 1.25f)).build());
    public static final EntityType<NuclearChargeEntity> NUCLEAR_CHARGE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "nuclear_charge"),
            FabricEntityTypeBuilder.<NuclearChargeEntity>create(SpawnGroup.MISC, NuclearChargeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().build());
    public static final EntityType<ShardEntity> GALLIUM_SHARD = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "galinite_shard"),
            FabricEntityTypeBuilder.<ShardEntity>create(SpawnGroup.MISC, ShardEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(8).trackedUpdateRate(10)/*necessary for all thrown projectiles (as it prevents it from breaking, lol)*/.build());
    public static final EntityType<DaggerEntity> DAGGER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "dagger"),
            FabricEntityTypeBuilder.<DaggerEntity>create(SpawnGroup.MISC, DaggerEntity::new)
                    .dimensions(EntityDimensions.fixed(0.35F, 0.15F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(8).trackedUpdateRate(10)/*necessary for all thrown projectiles (as it prevents it from breaking, lol)*/.build());
    public static final EntityType<GrenadeEntity> GRENADE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "grenade"),
            FabricEntityTypeBuilder.<GrenadeEntity>create(SpawnGroup.MISC, GrenadeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
                    .trackRangeBlocks(8).trackedUpdateRate(10)/*necessary for all thrown projectiles (as it prevents it from breaking, lol)*/.build());
    public static final EntityType<LaserEntity> LASER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "laser"),
            FabricEntityTypeBuilder.<LaserEntity>create(SpawnGroup.MISC, LaserEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(32).trackedUpdateRate(20).build());
    public static final EntityType<GasEntity> GAS = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "gas"),
            FabricEntityTypeBuilder.<GasEntity>create(SpawnGroup.MISC, GasEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(32).trackedUpdateRate(20).build());
    public static final EntityType<BulletEntity> BULLET = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "bullet"),
            FabricEntityTypeBuilder.<BulletEntity>create(SpawnGroup.MISC, BulletEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(32).trackedUpdateRate(20).build());
}