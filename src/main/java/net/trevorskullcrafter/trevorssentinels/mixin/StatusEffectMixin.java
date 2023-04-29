package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.trevorskullcrafter.trevorssentinels.data.EnglishLangGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StatusEffect.class)
public abstract class StatusEffectMixin {
    @Shadow public abstract String getTranslationKey();
    @Shadow public abstract int getColor();

    @Inject(at = @At("HEAD"), method = "getName", cancellable = true)
    private void getName(CallbackInfoReturnable<Text> cir) {
        cir.setReturnValue(EnglishLangGenerator.getColoredText(Text.translatable(getTranslationKey()).getString(), TextColor.fromRgb(getColor()).getHexCode()));
    }
}