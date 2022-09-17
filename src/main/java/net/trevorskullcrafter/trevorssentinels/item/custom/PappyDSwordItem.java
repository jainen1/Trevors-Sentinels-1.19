package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PappyDSwordItem extends PappyMSwordItem {
    public PappyDSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            if(!Screen.hasShiftDown()){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5, 255,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,5,3,false,false,false));
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 2.0F, getRandom());
                user.sendMessage(Text.literal("Parry!").formatted(Formatting.GRAY),true);
                user.getItemCooldownManager().set(this, 100);
            }else {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,200,1,false,true,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,2,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,200,255,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER,200,5,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,240,2,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,200,2,false,false,false));
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.BLOCKS, 2.0F, 0.0F);
                user.sendMessage(Text.literal("Enraged!").formatted(Formatting.DARK_RED),true);
                user.getItemCooldownManager().set(this,200);
            }
            return TypedActionResult.success(itemStack);
        }
        return super.use(world, user, hand);
    }

    public float getRandom(){
        return Random.createLocal().nextFloat();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION,1,1,false,false,false));
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("Right click to parry!").formatted(Formatting.RED));
            tooltip.add(Text.literal("Shift + right click to become enraged!").formatted(Formatting.DARK_RED));
    }
}
