package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class JetpackItem extends ArmorItem {
    public JetpackItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (hand == Hand.MAIN_HAND) {
            if(!world.isClient()) {
                if (itemStack.getSubNbt("trevorssentinels:power") != null) {
                    if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:power")).getBoolean("trevorssentinels:powerMode")) {
                        NbtCompound nbtData = new NbtCompound(); nbtData.putBoolean("trevorssentinels:powerMode", false);
                        itemStack.setSubNbt("trevorssentinels:power", nbtData);
                        user.sendMessage(Text.literal("JETS: OFF").formatted(Formatting.DARK_RED, Formatting.BOLD), true);
                    } else {
                        NbtCompound nbtData = new NbtCompound(); nbtData.putBoolean("trevorssentinels:powerMode", true);
                        itemStack.setSubNbt("trevorssentinels:power", nbtData);
                        user.sendMessage(Text.literal("JETS: ON").formatted(Formatting.DARK_GREEN, Formatting.BOLD), true);
                    }
                } else {
                    NbtCompound nbtData = new NbtCompound(); nbtData.putBoolean("trevorssentinels:powerMode", true);
                    itemStack.setSubNbt("trevorssentinels:power", nbtData);
                    user.sendMessage(Text.literal("JETS: ON").formatted(Formatting.DARK_GREEN, Formatting.BOLD), true);
                }
            }else world.playSound(user, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON, SoundCategory.MASTER, 1.0f, 1.0f);
        } return TypedActionResult.success(itemStack);
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if((entity instanceof PlayerEntity)){
            //if on
            if(stack.getSubNbt("trevorssentinels:power") != null && Objects.requireNonNull(stack.getSubNbt("trevorssentinels:power"))
                    .getBoolean("trevorssentinels:powerMode")) {
                if (stack.getDamage() < stack.getMaxDamage() - 1) {
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(ModEffects.FLIGHT, 1));
                    stack.damage(1, (PlayerEntity) entity, p -> p.sendToolBreakStatus(((PlayerEntity) entity).preferredHand));
                }
            } else stack.damage(-1, (PlayerEntity) entity, p -> p.sendToolBreakStatus(((PlayerEntity) entity).preferredHand));
        }
    }


    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(itemStack.getSubNbt("trevorssentinels:power") != null){
            if(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:power")).getBoolean("trevorssentinels:powerMode")){
                tooltip.add(Text.literal("JETS: ON").formatted(Formatting.DARK_GREEN, Formatting.BOLD));
                tooltip.add(Text.literal("Hold SPACEBAR to fly.").formatted(Formatting.DARK_GREEN));
                tooltip.add(Text.literal("Hold SHIFT to hover.").formatted(Formatting.GRAY, Formatting.UNDERLINE));
            }else tooltip.add(Text.literal("JETS: OFF").formatted(Formatting.DARK_RED, Formatting.BOLD));
        }else{
            NbtCompound nbtData = new NbtCompound(); nbtData.putBoolean("trevorssentinels:powerMode", false);
            itemStack.setSubNbt("trevorssentinels:power", nbtData);
        } tooltip.add(Text.literal("Right click to toggle.").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}