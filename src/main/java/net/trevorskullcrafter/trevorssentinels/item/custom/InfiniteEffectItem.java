package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InfiniteEffectItem extends NamedItem {
    StatusEffectInstance[] effects;

    public InfiniteEffectItem(StatusEffectInstance[] effects, String color, Settings settings) {
        super(color, settings);
        this.effects = effects;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof PlayerEntity){
            for(StatusEffectInstance effect : effects) {
                ((PlayerEntity) entity).addStatusEffect(effect);
            }
        }
    }
}