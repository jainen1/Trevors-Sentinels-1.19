package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class JumpItem extends Item {
    int jumpTime = 0;
    long cooldownTime = 0;
    float velocity = 0f;
    boolean dirty = false;

    public JumpItem(Settings settings) { super(settings); }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (hand == Hand.MAIN_HAND && Screen.hasControlDown()) {
            if(!world.isClient) {
                if (itemStack.getSubNbt("trevorssentinels:power") != null) {
                    if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:power")).getBoolean("trevorssentinels:powerMode")) {
                        NbtCompound nbtData = new NbtCompound();
                        nbtData.putBoolean("trevorssentinels:powerMode", false);
                        itemStack.setSubNbt("trevorssentinels:power", nbtData);
                        user.sendMessage(Text.literal("JETS: OFF").formatted(Formatting.DARK_RED, Formatting.BOLD), true);
                    } else {
                        NbtCompound nbtData = new NbtCompound();
                        nbtData.putBoolean("trevorssentinels:powerMode", true);
                        itemStack.setSubNbt("trevorssentinels:power", nbtData);
                        user.sendMessage(Text.literal("JETS: ON").formatted(Formatting.DARK_GREEN, Formatting.BOLD), true);
                    }
                } else {
                    NbtCompound nbtData = new NbtCompound(); nbtData.putBoolean("trevorssentinels:powerMode", true);
                    itemStack.setSubNbt("trevorssentinels:power", nbtData);
                    user.sendMessage(Text.literal("JETS: ON").formatted(Formatting.DARK_GREEN, Formatting.BOLD), true);
                }
            } else world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.MASTER, 1.0f, 1.0f);
        } return TypedActionResult.success(itemStack);
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity){
            if(stack.getSubNbt("trevorssentinels:power") != null && Objects.requireNonNull(stack.getSubNbt("trevorssentinels:power"))
                    .getBoolean("trevorssentinels:powerMode")) {
                if (world.getTime() > cooldownTime) {
                    if (Screen.hasShiftDown()) {
                        if (!world.isClient) {
                            if (jumpTime == 100) {
                                if(world.getTime() % 2 == 0) ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ ▲ ▲").formatted(Formatting.AQUA), true);
                                else ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ ▲ ▲").formatted(Formatting.DARK_AQUA), true);
                            } else {
                                if (jumpTime >= 80) ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ ▲ △").formatted(Formatting.GREEN), true);
                                else if (jumpTime >= 60) ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ △ △").formatted(Formatting.YELLOW), true);
                                else if (jumpTime >= 40) ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ △ △ △").formatted(Formatting.GOLD), true);
                                else if (jumpTime >= 20) ((PlayerEntity) entity).sendMessage(Text.literal("▲ △ △ △ △").formatted(Formatting.RED), true);
                                else ((PlayerEntity) entity).sendMessage(Text.literal("△ △ △ △ △").formatted(Formatting.GRAY), true);
                                jumpTime += 2;
                            }
                        } else {
                            if ((jumpTime % 20 == 0 && !dirty && jumpTime != 0)) {
                                world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON,
                                        SoundCategory.MASTER, 1.0f, (float) ((double) jumpTime / 100));
                                if (jumpTime == 100) dirty = true;
                            }
                        }
                    } else {
                        if (world.isClient) {
                            if (jumpTime >= 20) {
                                velocity = (float) jumpTime / 60;
                                entity.addVelocity(0f, velocity, 0f);
                                world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, velocity, -velocity + 0.7f);
                                cooldownTime = world.getTime() + jumpTime;
                                ((PlayerEntity) entity).getItemCooldownManager().set(this, jumpTime);
                            }
                            dirty = false; jumpTime = 0;
                        } else if (jumpTime >= 20) ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, jumpTime, 0,
                                    false, true, false));
                    }
                } else {
                    if (world.isClient) {
                        if (((cooldownTime - world.getTime()) & 20) == 0) world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(),
                                SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, ((float) (cooldownTime - world.getTime()) / 200), 0.0f);
                    }
                }
            }
        }
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(itemStack.getSubNbt("trevorssentinels:power") != null){
            if(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:power")).getBoolean("trevorssentinels:powerMode")){
                tooltip.add(Text.literal("JETS: ON").formatted(Formatting.DARK_GREEN, Formatting.BOLD));
                tooltip.add(Text.literal("Hold SHIFT to charge; release to jump.").formatted(Formatting.DARK_GREEN));
                tooltip.add(Text.literal("Works from the inventory.").formatted(Formatting.GRAY, Formatting.UNDERLINE));
            }else tooltip.add(Text.literal("JETS: OFF").formatted(Formatting.DARK_RED, Formatting.BOLD));
        }else{
            NbtCompound nbtData = new NbtCompound(); nbtData.putBoolean("trevorssentinels:powerMode", false);
            itemStack.setSubNbt("trevorssentinels:power", nbtData);
        }
        tooltip.add(Text.literal("Ctrl + right click to toggle.").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}