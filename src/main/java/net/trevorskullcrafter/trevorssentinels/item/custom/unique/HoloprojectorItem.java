package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class HoloprojectorItem extends Item {
    public HoloprojectorItem(Settings settings) { super(settings); }

    @Override public ActionResult useOnBlock(ItemUsageContext context) {
        //Server: giving/removing items
        //Client: rendering, particle effects, music/sound
        World world = context.getWorld(); PlayerEntity user = context.getPlayer(); BlockPos blockPos = context.getBlockPos();
        if(!world.isClient() && context.getHand() == Hand.MAIN_HAND){ ItemStack itemStack = Objects.requireNonNull(user).getStackInHand(context.getHand());
            if(!Screen.hasControlDown()){
                if(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:holoprojector")).getInt("trevorssentinels:holoMode") == 1){
                    if(itemStack.getDamage() < itemStack.getMaxDamage()-1) {
                        if(user.getBlockPos() != blockPos.offset(context.getSide(),1)){
                            world.setBlockState(blockPos.offset(context.getSide(),1), ModBlocks.HOLOBARRIER.getDefaultState());
                            itemStack.damage(1, user, p -> p.sendToolBreakStatus(context.getHand()));
                            world.playSoundFromEntity(null, user, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 0.5F, 2.0F);
                        }else user.sendMessage(Text.literal("You are on this block!").formatted(Formatting.DARK_AQUA), true);
                    }else user.sendMessage(Text.literal("Maximum blocks projected!").formatted(Formatting.DARK_RED),true);

                }else if(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:holoprojector")).getInt("trevorssentinels:holoMode") == 2){
                    if(world.getBlockState(blockPos).getBlock() == ModBlocks.HOLOBARRIER){
                        if(itemStack.getDamage() > 0){
                            world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                            itemStack.damage(-1, user, p -> p.sendToolBreakStatus(context.getHand()));
                            world.playSoundFromEntity(null, user, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 0.5F, 2.0F);

                        }else user.sendMessage(Text.literal("Cannot fit block in storage!").formatted(Formatting.DARK_RED),true);
                    }else user.sendMessage(Text.literal("This is not a hard light block!").formatted(Formatting.GOLD),true);
                }else{
                    if(world.getBlockState(blockPos).getBlock() == ModBlocks.HOLOBARRIER){
                        if(itemStack.getDamage() > 0) user.sendMessage(Text.literal("There is space in storage!").formatted(Formatting.GOLD),true);
                        else{
                            world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                            world.playSoundFromEntity(null, user, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 0.5F, -2.0F);
                        }
                    }else user.sendMessage(Text.literal("This is not a hard light block!").formatted(Formatting.GOLD),true);
                }
            }
        } return super.useOnBlock(context);
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient && hand == Hand.MAIN_HAND && Screen.hasControlDown()){
            if(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:holoprojector")).getInt("trevorssentinels:holoMode") == 1){
                NbtCompound nbtData = new NbtCompound(); nbtData.putInt("trevorssentinels:holoMode", 2);
                itemStack.setSubNbt("trevorssentinels:holoprojector", nbtData);
                user.sendMessage(Text.literal("Mode: Recall").formatted(Formatting.YELLOW),true);
                world.playSoundFromEntity(null, user, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.5f, 1.0f);

            }else if(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:holoprojector")).getInt("trevorssentinels:holoMode") == 2){
                NbtCompound nbtData = new NbtCompound();
                nbtData.putInt("trevorssentinels:holoMode", 3);
                itemStack.setSubNbt("trevorssentinels:holoprojector", nbtData);
                user.sendMessage(Text.literal("Mode: Destroy").formatted(Formatting.RED),true);
                world.playSoundFromEntity(null, user, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.5f, 0.5f);

            }else{
                NbtCompound nbtData = new NbtCompound(); nbtData.putInt("trevorssentinels:holoMode", 1);
                itemStack.setSubNbt("trevorssentinels:holoprojector", nbtData);
                user.sendMessage(Text.literal("Mode: Deploy").formatted(Formatting.AQUA),true);
                world.playSoundFromEntity(null, user, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.5f, 1.5f);

            }
        } return TypedActionResult.success(itemStack);
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(itemStack.getSubNbt("trevorssentinels:holoprojector") != null) {
            if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:holoprojector")).getInt("trevorssentinels:holoMode") == 1) {
                tooltip.add(Text.literal("Mode: Deploy").formatted(Formatting.AQUA));
                tooltip.add(Text.literal("Right click to place hard light blocks.").formatted(Formatting.DARK_AQUA));
            } else if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:holoprojector")).getInt("trevorssentinels:holoMode") == 2) {
                tooltip.add(Text.literal("Mode: Recall").formatted(Formatting.YELLOW));
                tooltip.add(Text.literal("Right click to pick up hard light blocks.").formatted(Formatting.GOLD));
            } else {
                tooltip.add(Text.literal("Mode: Destroy").formatted(Formatting.RED));
                tooltip.add(Text.literal("When storage is full, right click to").formatted(Formatting.DARK_RED));
                tooltip.add(Text.literal("permanently destroy hard light blocks.").formatted(Formatting.DARK_RED));
            }
        }else{
            NbtCompound nbtData = new NbtCompound();nbtData.putInt("trevorssentinels:holoMode", 1);
            itemStack.setSubNbt("trevorssentinels:holoprojector", nbtData);
        }
        tooltip.add(Text.literal("Ctrl + right click to cycle modes.").formatted(Formatting.DARK_GRAY));

        if(itemStack.getDamage() <= (itemStack.getMaxDamage()/2)-1) tooltip.add(Text.literal("Blocks remaining: " +
                (itemStack.getMaxDamage() - itemStack.getDamage() - 1)+ " / " + (itemStack.getMaxDamage()-1)).formatted(Formatting.AQUA));
        else if((itemStack.getDamage() >= (itemStack.getMaxDamage()/2)) && (itemStack.getDamage() < itemStack.getMaxDamage()-1)) tooltip.add(Text.literal(
                "Blocks remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+ " / " + (itemStack.getMaxDamage()-1)).formatted(Formatting.YELLOW));
        else tooltip.add(Text.literal("Blocks remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1) + " / " + (itemStack.getMaxDamage()-1))
                .formatted(Formatting.RED));

        tooltip.add(Text.literal("Blocks remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+
                " / " + (itemStack.getMaxDamage()-1)).formatted(itemStack.getDamage() <= (itemStack.getMaxDamage()/2)-1 ? Formatting.AQUA :
                ((itemStack.getDamage() <= itemStack.getMaxDamage()-1) ? Formatting.YELLOW : Formatting.RED)));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}