package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ChaddBucketItem extends NamedItem {
    public ChaddBucketItem(String color, Settings settings) {
        super(color, settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1, 0, false, false, false));

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1, 0, false, false, false));

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 1, 0, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 1, 0, false, false, false));
        }
        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            stack.decrement(1);
        }
        if (stack.isEmpty()) {
            return new ItemStack(Items.BUCKET);
        }
        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}