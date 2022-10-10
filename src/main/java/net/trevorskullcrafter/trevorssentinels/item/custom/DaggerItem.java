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

public class DaggerItem extends SwordItem {
    public DaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int stabby = Random.createLocal().nextBetween(1,12);
        if(stabby >= 1 && stabby <= 8){
            stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            attacker.sendMessage(Text.literal("STAB!").formatted(Formatting.DARK_GRAY));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,20,0,false,false,false));
            attacker.world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                    SoundEvents.ENTITY_PLAYER_ATTACK_WEAK, SoundCategory.BLOCKS, 1.0F, 1.0F);

        }else if(stabby >= 9 && stabby <= 11){
            stack.damage(2, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            attacker.sendMessage(Text.literal("DOUBLE STAB!").formatted(Formatting.DARK_RED));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,20,1,false,false,false));
            attacker.world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                    SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, SoundCategory.BLOCKS, 1.5F, 1.5F);

        }else{
            stack.damage(3, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            attacker.sendMessage(Text.literal("MEGA STAB!").formatted(Formatting.RED));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,20,2,false,false,false));
            attacker.world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                    SoundEvents.ENTITY_IRON_GOLEM_DAMAGE, SoundCategory.BLOCKS, 2.0F, 2.0F);
        }
        return true;
    }
}