package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.effect.FlightStatusEffect;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JumpItemv2 extends ModArmorItem {
    int jumpTime = 0;
    long cooldownTime = 0;
    float velocity = 0f;
    boolean dirty = false;
    public JumpItemv2(String color, ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(color, material, slot, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (hand == Hand.MAIN_HAND && Screen.hasControlDown()) {
            if(!world.isClient) {
                if (itemStack.getSubNbt("trevorssentinels:power") != null) {
                    if (itemStack.getSubNbt("trevorssentinels:power").getBoolean("trevorssentinels:powerMode")) {
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
                    NbtCompound nbtData = new NbtCompound();
                    nbtData.putBoolean("trevorssentinels:powerMode", true);
                    itemStack.setSubNbt("trevorssentinels:power", nbtData);
                    user.sendMessage(Text.literal("JETS: ON").formatted(Formatting.DARK_GREEN, Formatting.BOLD), true);
                }
            }else{
                world.playSound(user, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON, SoundCategory.MASTER, 1.0f, 1.0f);
            }
        }
        return TypedActionResult.success(itemStack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity){
            //if on
            if(stack.getSubNbt("trevorssentinels:power") != null && stack.getSubNbt("trevorssentinels:power")
                    .getBoolean("trevorssentinels:powerMode")) {
                if (world.getTime() > cooldownTime) {
                    if (Screen.hasShiftDown()) {
                        if (!world.isClient) {
                            if (jumpTime == 100) {
                                if(world.getTime() % 2 == 0){
                                    ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ ▲ ▲").formatted(Formatting.AQUA), true);
                                }else{
                                    ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ ▲ ▲").formatted(Formatting.DARK_AQUA), true);
                                }
                            } else {
                                if (jumpTime >= 80) {
                                    ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ ▲ △").formatted(Formatting.GREEN), true);
                                } else if (jumpTime >= 60) {
                                    ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ △ △").formatted(Formatting.YELLOW), true);
                                } else if (jumpTime >= 40) {
                                    ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ △ △ △").formatted(Formatting.GOLD), true);
                                } else if (jumpTime >= 20) {
                                    ((PlayerEntity) entity).sendMessage(Text.literal("▲ △ △ △ △").formatted(Formatting.RED), true);
                                } else {
                                    ((PlayerEntity) entity).sendMessage(Text.literal("△ △ △ △ △").formatted(Formatting.GRAY), true);
                                }
                                jumpTime += 2;
                                if (jumpTime == 100) {
                                    dirty = true;
                                }
                            }
                        } else {
                            if ((jumpTime % 20 == 0 && !dirty && jumpTime != 0)) world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(),
                                    SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.MASTER, 1.0f, (float) ((double) jumpTime / 100));
                        }
                    } else {
                        if (jumpTime >= 20) {
                            if(world.isClient()) {
                                world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(),
                                        SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, velocity, -velocity + 0.7f);
                            }else {
                                velocity = (float) jumpTime / 60;
                                entity.addVelocity(0f, velocity, 0f);
                                stack.damage(20, (PlayerEntity) entity, p -> p.sendToolBreakStatus(((PlayerEntity) entity).preferredHand));
                                cooldownTime = world.getTime() + jumpTime;
                                ((PlayerEntity) entity).getItemCooldownManager().set(this, jumpTime);
                            }
                        }
                        dirty = false;
                        jumpTime = 0;
                    }
                    if(FlightStatusEffect.hasSpacebarDown() && !entity.isOnGround()){
                        if(stack.getDamage() < stack.getMaxDamage() - 1) {
                            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(
                                    StatusEffects.SLOW_FALLING, jumpTime, 0, false, true, false));
                            world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(),
                                    SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, (float) (stack.getMaxDamage() - stack.getDamage()) / 50, 0.0f);
                            stack.damage(1, (PlayerEntity) entity, p -> p.sendToolBreakStatus(((PlayerEntity) entity).preferredHand));
                            ((PlayerEntity) entity).sendMessage(
                                    Text.literal((stack.getMaxDamage() - stack.getDamage()) + "%").formatted(Formatting.GRAY), true);
                        }else{
                            ((PlayerEntity) entity).sendMessage(Text.literal(("Out of fuel!").formatted(Formatting.RED)), true);
                        }
                    }

                } else {
                    if (world.isClient) {
                        if (((cooldownTime - world.getTime()) & 20) == 0) {
                            world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(),
                                    SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, ((float) (cooldownTime - world.getTime()) / 200), 0.0f);
                        }
                    }
                }
            }else{
                stack.damage(-1, (PlayerEntity) entity, p -> p.sendToolBreakStatus(((PlayerEntity) entity).preferredHand));
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(itemStack.getSubNbt("trevorssentinels:power") != null){
            if(itemStack.getSubNbt("trevorssentinels:power").getBoolean("trevorssentinels:powerMode")){
                tooltip.add(Text.literal("JETS: ON").formatted(Formatting.DARK_GREEN, Formatting.BOLD));
                tooltip.add(Text.literal("Hold SHIFT to charge; release to jump.").formatted(Formatting.DARK_GREEN));
                tooltip.add(Text.literal("Hold space to slow fall.").formatted(Formatting.GRAY, Formatting.UNDERLINE));
            }else{
                tooltip.add(Text.literal("JETS: OFF").formatted(Formatting.DARK_RED, Formatting.BOLD));
            }
        }else{
            NbtCompound nbtData = new NbtCompound();
            nbtData.putBoolean("trevorssentinels:powerMode", false);
            itemStack.setSubNbt("trevorssentinels:power", nbtData);
        }
        tooltip.add(Text.literal("Ctrl + right click to toggle.").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}