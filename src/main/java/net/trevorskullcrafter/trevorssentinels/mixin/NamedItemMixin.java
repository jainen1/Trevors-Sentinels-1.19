package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.data.EnglishLangGenerator;
import net.trevorskullcrafter.trevorssentinels.data.TagGenerator;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

import java.util.List;

@Mixin(Item.class)
public abstract class NamedItemMixin{
    public Text name = null;
    @Shadow public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {}
    @Shadow public abstract String getTranslationKey(ItemStack stack);

    @Shadow @Final private Rarity rarity;

    @Inject(at = @At("HEAD"), method = "appendTooltip")
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        String tooltipRaw = "tooltip." + stack.getTranslationKey() + (stack.getNbt() != null && stack.getNbt().getInt("CustomModelData") != 0 &&
                !("tooltip." + stack.getTranslationKey() + ".custom" + stack.getNbt().getInt("CustomModelData")).equals(Text.translatable("tooltip." + stack.getTranslationKey() +
                        ".custom" + stack.getNbt().getInt("CustomModelData")).getString())? ".custom" + stack.getNbt().getInt("CustomModelData") : "");
        String tooltipText = Text.translatable(tooltipRaw).getString();
        if(!tooltipRaw.equals(tooltipText)) {
            if (tooltipText.contains(" ") && tooltipText.length() > stack.getName().getString().length() * 1.75) {
                double halfPoint = tooltipText.length() / 2.0;
                tooltip.add(Text.literal(tooltipText.substring(0, tooltipText.indexOf(" ", (int) halfPoint) + 1))
                        .formatted(Formatting.ITALIC, Formatting.GRAY));
                tooltip.add(Text.literal(tooltipText.substring(tooltipText.indexOf(" ", (int) halfPoint) + 1))
                        .formatted(Formatting.ITALIC, Formatting.GRAY));
            } else tooltip.add(Text.literal(tooltipText).formatted(Formatting.ITALIC, Formatting.GRAY));
        } if(world != null && world.getTime() % 100 == 0) name = null;
    }

    @Inject(at = @At("HEAD"), method = "getItemBarColor", cancellable = true)
    public void getItemBarColor(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        if(stack.isIn(TagGenerator.ITEM_BAR_COLOR_OVERRIDE) && stack.getName().getStyle().getColor() != null)
            cir.setReturnValue(stack.getName().getStyle().getColor().getRgb());
    }

    private String customTranslationKey(String type, ItemStack stack){
        return (type != null? type + "." : "") + getTranslationKey(stack) + (stack.getNbt() != null && stack.getNbt().getInt("CustomModelData") != 0 &&
                !((type != null? type + "." : "") + getTranslationKey(stack) + ".custom" + stack.getNbt().getInt("CustomModelData"))
                        .equals(Text.translatable((type != null? type + "." : "") + getTranslationKey(stack) + ".custom" +
                                stack.getNbt().getInt("CustomModelData")).getString())? ".custom" + stack.getNbt().getInt("CustomModelData") : "");
    }

    @Inject(at = @At("TAIL"), method = "getName(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/text/Text;", cancellable = true)
    void getName(ItemStack stack, CallbackInfoReturnable<Text> cir) {
        if (name == null) {
            String translationKey = customTranslationKey(null, stack);
            String nameColor = customTranslationKey("color", stack);
            if (!nameColor.equals(Text.translatable(nameColor).getString()))
                name = EnglishLangGenerator.getColoredText(translationKey, Text.translatable(nameColor).getString());
            else if (rarity != Rarity.COMMON) name = EnglishLangGenerator.getColoredText(translationKey, Text.translatable("color.rarity.minecraft." +
                    rarity.name().toLowerCase()).getString());
            else name = Text.translatable(translationKey);
        } cir.setReturnValue(name);
    }

    @Inject(method = "inventoryTick", at = @At("HEAD"))
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
        tickHandler(stack, world, entity, slot, selected, ci);
    } public void tickHandler(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {}
}