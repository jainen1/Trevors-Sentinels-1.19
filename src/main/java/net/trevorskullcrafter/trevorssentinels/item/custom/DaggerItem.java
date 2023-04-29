package net.trevorskullcrafter.trevorssentinels.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.custom.DaggerEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DaggerItem extends Item {
    public int attackDamage;
    StatusEffectInstance[] effects;
    private final int destroyChance;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public DaggerItem(Settings settings, int attackDamage, float attackSpeed, int destroyChance, StatusEffectInstance... effects) {
        super(settings); this.attackDamage = attackDamage; this.destroyChance = destroyChance; this.effects = effects;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override public UseAction getUseAction(ItemStack stack) { return UseAction.SPEAR; }
    @Override public int getMaxUseTime(ItemStack stack) { return 72000; }
    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            if(i >= 10) { if (!world.isClient) {
                DaggerEntity dagger = new DaggerEntity(world, user, stack.getItem().getDefaultStack(), attackDamage, destroyChance, effects);
                dagger.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, BowItem.getPullProgress(i) * 3.0f, 0.0f);
                if (playerEntity.getAbilities().creativeMode) dagger.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                world.spawnEntity(dagger);
                world.playSoundFromEntity(null, dagger, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS,
                        user.isSneaking()? 0.2f : 1f, 1f);
                if (!playerEntity.getAbilities().creativeMode) stack.decrement(1);
            } playerEntity.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
            }
        }
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //tooltip.add(Text.literal(attackDamage+" ").append(Text.translatable("attribute.name.generic.attack_damage")).formatted(Formatting.DARK_GREEN));
        if(effects != null) { if (Screen.hasShiftDown()) for (StatusEffectInstance statusEffectInstance : effects) {
                MutableText mutableText = Text.translatable(statusEffectInstance.getTranslationKey());
                StatusEffectCategory statusEffectCategory = statusEffectInstance.getEffectType().getCategory();
                if (statusEffectInstance.getAmplifier() > 0)
                    mutableText = Text.translatable("potion.withAmplifier", mutableText,
                            Text.translatable("potion.potency." + statusEffectInstance.getAmplifier()));
                if (statusEffectInstance.getDuration() > 20)
                    mutableText = Text.translatable("potion.withDuration", mutableText,
                            StatusEffectUtil.durationToString(statusEffectInstance, 1.0f));
                tooltip.add(mutableText.formatted(statusEffectCategory == StatusEffectCategory.BENEFICIAL ? Formatting.GREEN : statusEffectCategory ==
                        StatusEffectCategory.NEUTRAL ? Formatting.YELLOW : Formatting.RED));
            } else tooltip.add(Text.empty().append(Text.literal("SHIFT").formatted(Formatting.YELLOW)).append(Text.literal(" to show status effects.")
                        .formatted(Formatting.DARK_GRAY)));
        } super.appendTooltip(stack, world, tooltip, context);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (destroyChance > 0 && Random.createLocal().nextBetween(0, destroyChance * 2) == 0) {
            attacker.getWorld().playSoundFromEntity(null, attacker, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1, 1);
            stack.decrement(1);
        } return true;
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if ((double)state.getHardness(world, pos) != 0.0) {
            if (destroyChance > 0 && Random.createLocal().nextBetween(0, destroyChance) == 0) {
                miner.getWorld().playSoundFromEntity(null, miner, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1, 1);
                stack.decrement(1);
            }
        } return true;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return (slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND) ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }
}