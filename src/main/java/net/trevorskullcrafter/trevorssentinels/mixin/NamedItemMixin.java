package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.datagen.EnglishLangGenerator;
import net.trevorskullcrafter.trevorssentinels.datagen.ItemTagGenerator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

import java.util.List;

@Mixin(Item.class)
public abstract class NamedItemMixin{
    //@Shadow public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {}
    @Shadow public abstract String getTranslationKey(ItemStack stack);
    @Shadow @Final private Rarity rarity;

    @Inject(at = @At("HEAD"), method = "appendTooltip")
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        String tooltipRaw = "tooltip." + stack.getTranslationKey();
        if(stack.getNbt() != null){ int data = stack.getNbt().getInt("CustomModelData"); String newTooltip = tooltipRaw + ".custom" + data;
            if(data != 0 && !newTooltip.equals(Text.translatable(newTooltip).getString())) { tooltipRaw = newTooltip; }}
        String tooltipText = Text.translatable(tooltipRaw).getString();
        if(!tooltipRaw.equals(tooltipText)) {
            if (tooltipText.contains(" ") && tooltipText.length() > stack.getName().getString().length() * 1.75) { //if tooltip is very long, split it in half
                int halfPoint = tooltipText.indexOf(" ", (int) (tooltipText.length() / 2.0)) + 1;
                tooltip.add(Text.literal(tooltipText.substring(0, halfPoint)).formatted(Formatting.ITALIC, Formatting.GRAY));
                tooltip.add(Text.literal(tooltipText.substring(halfPoint)).formatted(Formatting.ITALIC, Formatting.GRAY));
            } else { tooltip.add(Text.literal(tooltipText).formatted(Formatting.ITALIC, Formatting.GRAY)); }
        }
    }

    @Inject(at = @At("HEAD"), method = "getItemBarColor", cancellable = true)
    public void getItemBarColor(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        TextColor styleColor = stack.getName().getStyle().getColor();
        if(stack.isIn(ItemTagGenerator.ITEM_BAR_COLOR_OVERRIDE) && styleColor != null) { cir.setReturnValue(styleColor.getRgb()); }
    }

    @Unique private String customTranslationKey(String type, ItemStack stack){
        String typeKey = (type != null? type + "." : "") + getTranslationKey(stack);
        if(stack.getNbt() != null) { int data = stack.getNbt().getInt("CustomModelData"); String customKey = typeKey + ".custom" + data;
            if(data != 0 && !customKey.equals(Text.translatable(customKey).getString())) { return customKey; }} return typeKey;
    }

    @Inject(at = @At("TAIL"), method = "getName(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/text/Text;", cancellable = true)
    void getName(ItemStack stack, CallbackInfoReturnable<Text> cir) {
        Text name; String translationKey = customTranslationKey(null, stack); String nameColor = customTranslationKey("color", stack);
        String colorString = Text.translatable(nameColor).getString();
        if (!nameColor.equals(colorString)) { name = EnglishLangGenerator.getColoredText(translationKey, colorString); }
        else if (rarity != Rarity.COMMON) { name = EnglishLangGenerator.getColoredText(translationKey,
                Text.translatable("color.rarity.minecraft." + rarity.name().toLowerCase()).getString()); }
        else { name = Text.translatable(translationKey); }
        cir.setReturnValue(name);
    }

    @Inject(method = "inventoryTick", at = @At("HEAD"))
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) { tickHandler(stack, world, entity, slot, selected, ci); }
    @Unique public void tickHandler(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {}
}