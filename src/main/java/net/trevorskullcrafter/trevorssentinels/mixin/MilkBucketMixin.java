package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.MilkBucketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import com.llamalad7.mixinextras.injector.WrapWithCondition;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MILK_CURES_POTION_EFFECTS;

@Mixin(MilkBucketItem.class)
public abstract class MilkBucketMixin extends NamedItemMixin {
    @WrapWithCondition(method = "finishUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;clearStatusEffects()Z"))
    private boolean milkCuresPotionEffects(LivingEntity instance) { return instance.getWorld().getGameRules().getBoolean(MILK_CURES_POTION_EFFECTS); }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void applyEffect(Item.Settings settings, CallbackInfo ci){
        settings.food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 10), 0.85f).build());
    }
}