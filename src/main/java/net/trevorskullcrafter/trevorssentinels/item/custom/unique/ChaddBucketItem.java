package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
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

import java.util.Objects;

public class ChaddBucketItem extends Item {
    public ChaddBucketItem(Settings settings) { super(settings); }

    @Override public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack); serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            for(int i = 0; i < 100; i++) user.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(i) == null ? StatusEffects.RESISTANCE : Objects.requireNonNull(StatusEffect.byRawId(i))));
            if(!serverPlayerEntity.getAbilities().creativeMode) stack.decrement(1);
        } if (stack.isEmpty()) return new ItemStack(Items.BUCKET); return stack;
    }

    @Override public ItemStack getRecipeRemainder(ItemStack stack) { return new ItemStack(Items.BUCKET); }
    @Override public int getMaxUseTime(ItemStack stack) { return 32; } @Override public UseAction getUseAction(ItemStack stack) { return UseAction.DRINK; }
    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) { return ItemUsage.consumeHeldItem(world, user, hand); }
}