package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PappyMSwordItem extends SwordItem {
    public PappyMSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            if(!Screen.hasShiftDown()){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 10, 255));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,10,3));
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 2.0F, -5.0F);
                user.getItemCooldownManager().set(this, 100);
                return TypedActionResult.success(itemStack);
            }else {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,200,1));
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.EVENT_RAID_HORN, SoundCategory.BLOCKS, 2.0F, 0.0F);
                user.getItemCooldownManager().set(this,200);
                return TypedActionResult.success(itemStack);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("Right click to parry!").formatted(Formatting.GREEN));
            tooltip.add(Text.literal("Shift + right click to gain a buff!").formatted(Formatting.GREEN));
    }
}
