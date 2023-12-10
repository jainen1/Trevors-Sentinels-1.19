package net.trevorskullcrafter.trevorssentinels.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.*;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.datagen.ItemTagGenerator;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

import java.util.List;

@Mixin(Item.class)
public abstract class NamedItemMixin{
    @Shadow public abstract String getTranslationKey(ItemStack stack);
    @Shadow @Final private Rarity rarity;
    @Shadow public abstract boolean isFood();
    @Shadow @Nullable public abstract FoodComponent getFoodComponent();
    @Unique int modelData;

    @Unique private String customTranslationKey(String type, ItemStack stack){
        String typeKey = (type != null? type + "." : "") + getTranslationKey(stack);
        return typeKey + ((modelData > 0 && TextUtil.translationDiffersFromKey(typeKey + ".custom" + modelData) != null)? ".custom" + modelData : "");
    }

    @Inject(at = @At("TAIL"), method = "getName(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/text/Text;", cancellable = true)
    void getName(ItemStack stack, CallbackInfoReturnable<Text> cir) {
        String colorKey = customTranslationKey("color", stack);
        boolean b1 = TextUtil.translationDiffersFromKey(colorKey) != null;
        if(b1 || rarity != Rarity.COMMON){ cir.setReturnValue(TextUtil.coloredText(customTranslationKey(null, stack),
                TextUtil.decodedColorKey((b1)? colorKey : "color.rarity.minecraft." + rarity.name().toLowerCase()))); }
    }

    @Inject(at = @At("HEAD"), method = "appendTooltip")
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if(this.isFood() && getFoodComponent().getStatusEffects() != null){ for(Pair<StatusEffectInstance, Float> effect : getFoodComponent().getStatusEffects()){
            tooltip.add(Text.empty().append(TextUtil.potionText(effect.getFirst(), false)).append(Text.literal(" ["+String.format("%.0f",effect.getSecond()*100)+"%]")
                    .formatted(Formatting.YELLOW)));
        }}
        String text = TextUtil.translationDiffersFromKey(customTranslationKey("tooltip", stack));
        if(text != null) {
            Formatting[] formattings = new Formatting[]{Formatting.ITALIC, Formatting.GRAY};
            if (text.contains(" ") && text.length() >= 24) { //if tooltip is very long, split it in half
                int halfPoint = text.indexOf(" ", (int) (text.length() / 2.0)) + 1;
                tooltip.add(Text.literal(text.substring(0, halfPoint)).formatted(formattings));
                tooltip.add(Text.literal(text.substring(halfPoint)).formatted(formattings));
            } else { tooltip.add(Text.literal(text).formatted(formattings)); }
        }
    }

    @Inject(at = @At("HEAD"), method = "getItemBarColor", cancellable = true)
    public void getItemBarColor(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        TextColor styleColor = stack.getName().getStyle().getColor();
        if(stack.isIn(ItemTagGenerator.ITEM_BAR_COLOR_OVERRIDE) && styleColor != null) { cir.setReturnValue(styleColor.getRgb()); }
    }

    @Inject(method = "inventoryTick", at = @At("HEAD"))
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
        tickHandler(stack, world, entity, slot, selected, ci);
        if(stack.getNbt() != null) { modelData = stack.getNbt().getInt("CustomModelData"); }
    }
    @Unique public void tickHandler(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {}
}