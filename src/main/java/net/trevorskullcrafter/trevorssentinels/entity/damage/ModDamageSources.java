package net.trevorskullcrafter.trevorssentinels.entity.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import org.jetbrains.annotations.Nullable;

public class ModDamageSources {
    public static final DamageSource INFESTED = (new DamageSource("infested")).setBypassesArmor().setUnblockable();
    public static final DamageSource IRRADIATED = (new DamageSource("irradiated")).setBypassesArmor();
    public static final DamageSource REDSTONED = (new DamageSource("redstoned"));
    public static final DamageSource SHARD_ENTITY = (new DamageSource("shard_entity"));
    public static final DamageSource LASER_ENTITY = (new DamageSource("laser_entity"));

    public static DamageSource dagger(Entity dagger, @Nullable Entity attacker) {
        return (new ProjectileDamageSource("dagger", dagger, attacker)).setProjectile();
    }
}