package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DistanceTrackerItem extends NamedItem {
    LivingEntity attachedMob;
    double distance;
    public DistanceTrackerItem(String color, Settings settings) {
        super(color, settings);
        doDashes = true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(!user.getWorld().isClient() && hand == Hand.MAIN_HAND){
            attachedMob = entity;
        }

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity && attachedMob != null && attachedMob.isAlive()){
            distance = (double) Math.round(Math.sqrt( Math.pow( attachedMob.getBlockX() - entity.getBlockX() ,2) +
                    Math.pow( attachedMob.getBlockY() - entity.getBlockY() ,2) +
                    Math.pow( attachedMob.getBlockZ() - entity.getBlockZ() ,2)) * 10) / 10;
            if(world.isClient()){
                if(distance < 100) {
                    if (distance >= 50) {
                        if(selected) {
                            ((PlayerEntity) entity).sendMessage(Text.literal("88.8m").formatted(Formatting.DARK_GRAY), true);
                        }
                        resetNbt(stack, 0);
                    } else if (distance >= 25) {
                        if(selected) {
                            if ((world.getTime() & 20) == 0) {
                                ((PlayerEntity) entity).sendMessage(Text.literal(distance + "m").formatted(Formatting.DARK_GREEN), true);
                                world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.MASTER, 0.2f, 0.9f);
                            }else{
                                ((PlayerEntity) entity).sendMessage(Text.literal(distance + "m").formatted(Formatting.GREEN), true);
                            }
                        }
                        resetNbt(stack, 1);
                    } else if (distance >= 10) {
                        if(selected) {
                            if ((world.getTime() & 10) == 0) {
                                ((PlayerEntity) entity).sendMessage(Text.literal(distance + "m").formatted(Formatting.GOLD), true);
                                world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.MASTER, 0.2f, 1.0f);
                            }else{
                                ((PlayerEntity) entity).sendMessage(Text.literal(distance + "m").formatted(Formatting.YELLOW), true);
                            }
                        }
                        resetNbt(stack, 2);
                    } else {
                        if(selected) {
                            if ((world.getTime() & 2) == 0) {
                                ((PlayerEntity) entity).sendMessage(Text.literal("0" + distance + "m").formatted(Formatting.DARK_RED), true);
                                world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.MASTER, 0.2f, 1.2f);
                            } else {
                                ((PlayerEntity) entity).sendMessage(Text.literal("0" + distance + "m").formatted(Formatting.RED), true);
                            }
                        }
                        resetNbt(stack, 3);
                    }
                }
            }
        }else{
            resetNbt(stack, 0);
            attachedMob = null;
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public void resetNbt(ItemStack stack, int state){
        if((stack.getSubNbt("trevorssentinels:model") == null) || (stack.getSubNbt("trevorssentinels:model").getInt("trevorssentinels:modelNum") != state)){
            NbtCompound nbtData = new NbtCompound();
            nbtData.putInt("trevorssentinels:modelNum", state);
            stack.setSubNbt("trevorssentinels:model", nbtData);
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(attachedMob == null){
            tooltip.add(Text.literal("Tracking system offline.").formatted(Formatting.DARK_RED));
        }else{
            tooltip.add(Text.literal("Tracking system online...").formatted(Formatting.GOLD));
        }
        tooltip.add(Text.literal("Right click an entity to track it.").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}