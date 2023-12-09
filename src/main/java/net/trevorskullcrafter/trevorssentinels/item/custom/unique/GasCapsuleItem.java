package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;

public class GasCapsuleItem extends Item {
    StatusEffectInstance[] effects;
    public GasCapsuleItem(Settings settings, StatusEffectInstance... effects) {
        super(settings); this.effects = effects;
    }
}