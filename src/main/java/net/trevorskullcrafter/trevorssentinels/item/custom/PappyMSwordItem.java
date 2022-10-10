package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
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

import java.util.List;

public class PappyMSwordItem extends SwordItem {
    public PappyMSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            if (itemStack.getSubNbt("trevorssentinels:raptureMode") != null) {
                if (Screen.hasControlDown()) {
                    if (itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 1) {
                        NbtCompound nbtData = new NbtCompound();
                        nbtData.putInt("trevorssentinels:raptureModeInt", 2);
                        itemStack.setSubNbt("trevorssentinels:raptureMode", nbtData);

                        user.sendMessage(Text.literal("Style: Paladin").formatted(Formatting.GREEN), true);
                        world.playSound(null, user.getX(), user.getY(),
                                user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                                SoundCategory.BLOCKS, 1.0F, 1.1F);
                    }else if(itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 2) {
                        NbtCompound nbtData = new NbtCompound();
                        nbtData.putInt("trevorssentinels:raptureModeInt", 3);
                        itemStack.setSubNbt("trevorssentinels:raptureMode", nbtData);

                        user.sendMessage(Text.literal("Style: Predator").formatted(Formatting.GREEN), true);
                        world.playSound(null, user.getX(), user.getY(),
                                user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                                SoundCategory.BLOCKS, 1.0F, 1.0F);
                    }else if(itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 3) {
                        NbtCompound nbtData = new NbtCompound();
                        nbtData.putInt("trevorssentinels:raptureModeInt", 4);
                        itemStack.setSubNbt("trevorssentinels:raptureMode", nbtData);

                        user.sendMessage(Text.literal("Style: Guardian").formatted(Formatting.GREEN), true);
                        world.playSound(null, user.getX(), user.getY(),
                                user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                                SoundCategory.BLOCKS, 1.0F, 0.9F);
                    } else {
                        NbtCompound nbtData = new NbtCompound();
                        nbtData.putInt("trevorssentinels:raptureModeInt", 1);
                        itemStack.setSubNbt("trevorssentinels:raptureMode", nbtData);

                        user.sendMessage(Text.literal("Style: Trickster").formatted(Formatting.GREEN), true);
                        world.playSound(null, user.getX(), user.getY(),
                                user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                                SoundCategory.BLOCKS, 1.0F, 1.2F);
                    }
                } else {
                    if (itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 1) {
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 1, false, false, false));
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2, false, false, false));
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 2, false, false, false));
                        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.BLOCKS, 2.0F, 5.0F);
                        user.sendMessage(Text.literal("Energized!").formatted(Formatting.GREEN), true);
                        user.getItemCooldownManager().set(this, 200);
                    }else if (itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 2) {

                    }else if (itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 3){

                    }else{
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5, 255, false, false, false));
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 3, false, false, false));
                        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 2.0F, getRandom());
                        user.sendMessage(Text.literal("Parry!").formatted(Formatting.GRAY), true);
                        user.getItemCooldownManager().set(this, 100);
                    }
                }
                return TypedActionResult.success(itemStack);
            }
        }
        return super.use(world, user, hand);
    }

    public float getRandom(){
        return Random.createLocal().nextFloat();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(itemStack.getSubNbt("trevorssentinels:raptureMode") != null) {
            if (itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 1) {
                tooltip.add(Text.literal("Style: Trickster").formatted(Formatting.ITALIC, Formatting.GREEN));
                tooltip.add(Text.literal("You are more agile than usual.").formatted(Formatting.DARK_GREEN));
                tooltip.add(Text.literal("Right click to become energized!").formatted(Formatting.GRAY));

            } else if(itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 2){
                tooltip.add(Text.literal("Style: Paladin").formatted(Formatting.ITALIC, Formatting.GREEN));
                tooltip.add(Text.literal("You are weighed down.").formatted(Formatting.DARK_GREEN));
                tooltip.add(Text.literal("Hitting enemies charges the blade.").formatted(Formatting.GRAY));
                tooltip.add(Text.literal("At full charge, hits become incredibly powerful.").formatted(Formatting.GRAY));

            }else if(itemStack.getSubNbt("trevorssentinels:raptureMode").getInt("trevorssentinels:raptureModeInt") == 3){
                tooltip.add(Text.literal("Style: Predator").formatted(Formatting.ITALIC, Formatting.GREEN));
                tooltip.add(Text.literal("You are constantly hungry.").formatted(Formatting.DARK_GREEN));
                tooltip.add(Text.literal("Hitting enemies satiates you.").formatted(Formatting.GRAY));

            }else{
                tooltip.add(Text.literal("Style: Guardian").formatted(Formatting.ITALIC, Formatting.GREEN));
                tooltip.add(Text.literal(".").formatted(Formatting.DARK_GREEN));
                tooltip.add(Text.literal("Right click to parry!").formatted(Formatting.GRAY));

            }
        } else {
            NbtCompound nbtData = new NbtCompound();
            nbtData.putInt("trevorssentinels:raptureModeInt", 1);
            itemStack.setSubNbt("trevorssentinels:raptureMode", nbtData);
        }
        tooltip.add(Text.literal("Ctrl + right click to switch style.").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.literal("Balance").formatted(Formatting.ITALIC, Formatting.DARK_GREEN));
    }
}
