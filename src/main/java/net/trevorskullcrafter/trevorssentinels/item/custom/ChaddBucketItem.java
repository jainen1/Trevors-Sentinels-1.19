package net.trevorskullcrafter.trevorssentinels.item.custom;

import com.anthonyhilyard.prism.util.ConfigHelper;
import com.google.common.collect.Lists;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.*;
import net.minecraft.util.Hand;
import net.minecraft.util.Language;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChaddBucketItem extends Item {
    public ChaddBucketItem(Item.Settings settings) {
        super(settings);
    }

    private final Text name = new Text() {
        private final TextContent content = new TranslatableTextContent("item.trevorssentinels.antimilk");
        private final Style style = Style.EMPTY.withColor((TextColor)(Object) ConfigHelper.parseColor("8_#FF5555_#55FF55_#FF8F00_#55FF55_#FFFF55_#00AA00_#FFFF55_#55FF55_#5555FF_#55FF55_#AA00AA_#55FF55"));

        @Nullable
        private Language decomposedWith;
        private OrderedText visualOrderText = OrderedText.EMPTY;

        @Override
        public Style getStyle() { return style; }

        @Override
        public TextContent getContent() { return content; }

        @Override
        public List<Text> getSiblings() { return Lists.newArrayList(); }

        @Override
        public OrderedText asOrderedText()
        {
            Language language = Language.getInstance();
            if (this.decomposedWith != language)
            {
                this.visualOrderText = language.reorder(this);
                this.decomposedWith = language;
            }
            return this.visualOrderText;
        }
    };

    @Override
    public Text getName(ItemStack stack) {
        return name;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1, 1, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 1, 1, false, false, false));
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
