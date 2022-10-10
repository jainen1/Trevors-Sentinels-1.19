package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.List;

import static java.lang.Math.round;

public class ThanatuBladeItem extends SwordItem {
    public ThanatuBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            if (Screen.hasControlDown()) {
                if (itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 1) {
                    NbtCompound nbtData = new NbtCompound();
                    nbtData.putInt("trevorssentinels:raptureModeInt", 2);
                    itemStack.setSubNbt("trevorssentinels:raptureMode", nbtData);

                    user.sendMessage(Text.literal("Style: Riftcaller").formatted(Formatting.DARK_PURPLE), true);
                    world.playSound(null, user.getX(), user.getY(),
                            user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                            SoundCategory.BLOCKS, 1.0F, 1.0F);
                } else {
                    NbtCompound nbtData = new NbtCompound();
                    nbtData.putInt("trevorssentinels:raptureModeInt", 1);
                    itemStack.setSubNbt("trevorssentinels:raptureMode", nbtData);

                    user.sendMessage(Text.literal("Style: Riftwalker").formatted(Formatting.DARK_PURPLE), true);
                    world.playSound(null, user.getX(), user.getY(),
                            user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                            SoundCategory.BLOCKS, 1.0F, 0.8F);
                }
            } else {
                if (itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 1) {
                    if (Screen.hasShiftDown()) {
                        NbtCompound nbtData = new NbtCompound();
                        nbtData.putDouble("trevorssentinels:playerPosX", user.getX());
                        nbtData.putDouble("trevorssentinels:playerPosY", user.getY());
                        nbtData.putDouble("trevorssentinels:playerPosZ", user.getZ());
                        nbtData.putString("trevorssentinels:boundText",
                                "Bound to " + round(user.getX()) + ", " + round(user.getY()) + ", " + round(user.getZ()));
                        itemStack.setSubNbt("trevorssentinels:harmoniousTeleportData", nbtData);

                        NbtCompound timer = new NbtCompound();
                        timer.putLong("trevorssentinels:timer", world.getTime() + 200);
                        itemStack.setSubNbt("trevorssentinels:timerHolder", timer);

                        user.sendMessage(Text.literal(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData")
                                .getString("trevorssentinels:boundText")).formatted(Formatting.LIGHT_PURPLE), true);
                        world.playSound(null, user.getBlockPos(),
                                SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.BLOCKS, 2.0F, 2.0F);
                        user.getItemCooldownManager().set(this, 10);
                        return TypedActionResult.success(itemStack);

                    } else {
                        if (itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData") != null) {
                            user.requestTeleportAndDismount(
                                    itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData").getInt("trevorssentinels:playerPosX"),
                                    itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData").getInt("trevorssentinels:playerPosY"),
                                    itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData").getInt("trevorssentinels:playerPosZ"));
                            world.playSound(null, user.getBlockPos(),
                                    SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.BLOCKS, 2.0f, 2.0f);
                            user.getItemCooldownManager().set(this, 20);
                            return TypedActionResult.success(itemStack);
                        } else {
                            user.sendMessage(Text.literal("This item is not bound to a location!")
                                    .formatted(Formatting.GRAY), true);
                        }
                    }
                } else {
                    user.sendMessage(Text.literal("Yeah this isn't working yet, sorry.")
                            .formatted(Formatting.DARK_PURPLE), true);
                    world.playSound(null, user.getBlockPos(),
                            SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.BLOCKS, 0.5f, 1.0f);
                    user.getItemCooldownManager().set(this, 200);
                }
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public boolean postHit(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if(itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 1){
            if(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData") != null) {
                target.requestTeleportAndDismount(
                        itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData").getInt("trevorssentinels:playerPosX"),
                        itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData").getInt("trevorssentinels:playerPosY"),
                        itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData").getInt("trevorssentinels:playerPosZ"));
                target.world.playSound(null, target.getBlockPos(),
                        SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.BLOCKS, 2.0F, 2.0F);
            }else{
                target.requestTeleportAndDismount(target.getX(), target.getY() + 10, target.getZ());
            }
        }else{
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,60,0,true,true,false));
        }
        return true;
    }

    @Override
    public void inventoryTick(ItemStack itemStack, World world, Entity entity, int slot, boolean selected) {
            if (itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData") != null) {
                if(itemStack.getSubNbt("trevorssentinels:timerHolder").getLong("trevorssentinels:timer") <= world.getTime()){
                    itemStack.removeSubNbt("trevorssentinels:harmoniousTeleportData");
                    itemStack.removeSubNbt("trevorssentinels:timerHolder");
                }
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(itemStack.getSubNbt("trevorssentinels:raptureMode") != null) {
            if (itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 1) {
                tooltip.add(Text.literal("Style: Riftwalker").formatted(Formatting.ITALIC, Formatting.DARK_PURPLE));

                if(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData") != null) {
                    tooltip.add(Text.literal(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData").
                            getString("trevorssentinels:boundText")).formatted(Formatting.LIGHT_PURPLE));

                    tooltip.add(Text.literal("Attacks will also teleport").formatted(Formatting.ITALIC, Formatting.GRAY));
                    tooltip.add(Text.literal("the target to this location.").formatted(Formatting.ITALIC, Formatting.GRAY));

                    if (itemStack.getSubNbt("trevorssentinels:timerHolder") != null){
                        tooltip.add(Text.literal("Rift " + (itemStack.getSubNbt("trevorssentinels:timerHolder").getLong
                                ("trevorssentinels:timer") - world.getTime()) / 2 + "% Stable"));
                    }
                }else {
                    tooltip.add(Text.literal("Hold shift and right click").formatted(Formatting.GRAY));
                    tooltip.add(Text.literal("to bind to a location!").formatted(Formatting.GRAY));
                }

            } else {
                tooltip.add(Text.literal("Style: Riftcaller").formatted(Formatting.ITALIC, Formatting.DARK_PURPLE));
                tooltip.add(Text.literal("Alt + right click to summon allies! (WIP)").formatted(Formatting.LIGHT_PURPLE));

                tooltip.add(Text.literal("Attacks will also apply").formatted(Formatting.ITALIC, Formatting.GRAY));
                tooltip.add(Text.literal("the Crystallized debuff.").formatted(Formatting.ITALIC, Formatting.GRAY));
            }

        }else {
            NbtCompound nbtData = new NbtCompound();
            nbtData.putInt("trevorssentinels:raptureModeInt", 1);
            itemStack.setSubNbt("trevorssentinels:raptureMode", nbtData);
        }
        tooltip.add(Text.literal("Ctrl + right click to switch style.").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("Tranquility").formatted(Formatting.ITALIC, Formatting.DARK_PURPLE));
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return stack.getSubNbt("trevorssentinels:timerHolder") != null;
    }
}