package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TwinBladeItem extends SwordItem {
    public TwinBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        int stabby = Random.createLocal().nextBetween(1,12);
        if(stabby >= 1 && stabby <= 8){
            attacker.sendMessage(Text.literal("SPIN!").formatted(Formatting.DARK_GRAY));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,20,0,false,false,false));
            attacker.world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                    SoundEvents.ITEM_TRIDENT_RIPTIDE_1, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }else if(stabby >= 9 && stabby <= 11){
            attacker.sendMessage(Text.literal("SUPERSONIC SPIN!").formatted(Formatting.GRAY));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,20,1,false,false,false));
            attacker.world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                    SoundEvents.ITEM_TRIDENT_RIPTIDE_1, SoundCategory.BLOCKS, 1.5F, 1.5F);
        }else{
            attacker.sendMessage(Text.literal("HYPERSONIC SPIN!").formatted(Formatting.WHITE));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,20,2,false,false,false));
            attacker.world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                    SoundEvents.ITEM_TRIDENT_RIPTIDE_1, SoundCategory.BLOCKS, 2.0F, 2.0F);
        }
        return true;
    }
}