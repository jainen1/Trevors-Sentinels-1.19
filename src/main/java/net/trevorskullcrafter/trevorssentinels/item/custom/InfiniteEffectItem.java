package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InfiniteEffectItem extends Item {
    StatusEffectInstance[] effects;

    public InfiniteEffectItem(Settings settings, StatusEffectInstance... effects) { super(settings); this.effects = effects; }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof LivingEntity livingEntity) for(StatusEffectInstance effect : effects)
            if(!livingEntity.hasStatusEffect(effect.getEffectType())) livingEntity.addStatusEffect(new StatusEffectInstance(effect.getEffectType(),
                    effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon()));
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(effects != null) { if(Screen.hasShiftDown()){ for (StatusEffectInstance statusEffectInstance : effects) {
            MutableText mutableText = Text.translatable(statusEffectInstance.getTranslationKey());
            if(statusEffectInstance.getAmplifier() > 0) mutableText = Text.translatable("potion.withAmplifier", mutableText,
                    Text.translatable("potion.potency." + statusEffectInstance.getAmplifier()));
            if(statusEffectInstance.getDuration() > 20) mutableText = Text.translatable("potion.withDuration", mutableText,
                    StatusEffectUtil.getDurationText(statusEffectInstance, 1.0f));
            if(statusEffectInstance.getEffectType().getCategory() == StatusEffectCategory.BENEFICIAL) tooltip.add(Text.empty().append("☀ ")
                    .append(mutableText).formatted(Formatting.GREEN));
            else if(statusEffectInstance.getEffectType().getCategory() == StatusEffectCategory.NEUTRAL) tooltip.add(Text.empty().append("☯ ")
                    .append(mutableText).formatted(Formatting.YELLOW));
            else tooltip.add(Text.empty().append("☠ ").append(mutableText).formatted(Formatting.RED));
        }} else tooltip.add(Text.empty().append(Text.literal("SHIFT").formatted(Formatting.YELLOW))
                .append(Text.literal(" to show effects.").formatted(Formatting.DARK_GRAY)));
        } super.appendTooltip(stack, world, tooltip, context);
    }
}