package net.trevorskullcrafter.trevorssentinels.entity.damage;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageSources {
    public static RegistryKey<DamageType> INFESTED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("infested"));
    public static RegistryKey<DamageType> IRRADIATED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("irradiated"));
    public static RegistryKey<DamageType> REDSTONED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("redstoned"));
    public static RegistryKey<DamageType> SHARD_ENTITY = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("shard_entity"));
    public static RegistryKey<DamageType> LASER_ENTITY = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("laser_entity"));
    public static RegistryKey<DamageType> DAGGER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("dagger"));

    //private final Registry<DamageType> registry = ;
    //private final DamageSource INFESTED = new DamageSource()

    public static void registerAll(Registerable<DamageType> damageTypeRegisterable) {
        damageTypeRegisterable.register(INFESTED, new DamageType("infested", 0.1F)); //bypasses armor, unblockable
        damageTypeRegisterable.register(IRRADIATED, new DamageType("irradiated", 0.1F)); //bypasses armor
        damageTypeRegisterable.register(REDSTONED, new DamageType("redstoned", 0.1F));
        damageTypeRegisterable.register(SHARD_ENTITY, new DamageType("shard_entity", 0.1F));
        damageTypeRegisterable.register(LASER_ENTITY, new DamageType("shard_entity", 0.1F));
        damageTypeRegisterable.register(DAGGER, new DamageType("dagger", 0.1F));

    }
}