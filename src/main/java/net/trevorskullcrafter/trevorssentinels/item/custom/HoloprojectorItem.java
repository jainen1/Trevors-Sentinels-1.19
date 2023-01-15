package net.trevorskullcrafter.trevorssentinels.item.custom;
import net.minecraft.block.Block;
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
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.util.ColoredTextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HoloprojectorItem extends NamedItem {
    public HoloprojectorItem(String color, boolean doDashes, Settings settings) {
        super(color, doDashes, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        //Server: giving/removing items
        //Client: rendering, particle effects, music/sound
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();
        if(!world.isClient() && context.getHand() == Hand.MAIN_HAND){
            ItemStack itemStack = context.getPlayer().getStackInHand(context.getHand());

            if(!Screen.hasControlDown()){
                if(itemStack.getSubNbt("trevorssentinels:holoprojector").getInt("trevorssentinels:holoMode") == 1){
                    if(itemStack.getDamage() < itemStack.getMaxDamage()-1) {
                        if(context.getPlayer().getBlockPos() != context.getBlockPos().offset(context.getSide(),1)){
                            world.setBlockState(context.getBlockPos().offset(context.getSide(),1),
                                    ModBlocks.HOLOBARRIER.getDefaultState());
                            itemStack.damage(1, context.getPlayer(), p -> p.sendToolBreakStatus(context.getHand()));
                            world.playSound(null, context.getPlayer().getX(), context.getPlayer().getY(),
                                    context.getPlayer().getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE,
                                    SoundCategory.BLOCKS, 0.5F, 2.0F);
                        }else{
                            context.getPlayer().sendMessage(Text.literal("You are on this block!")
                                    .formatted(Formatting.DARK_AQUA), true);
                        }
                    }else{
                        context.getPlayer().sendMessage(Text.literal("Maximum blocks projected!")
                                .formatted(Formatting.DARK_RED),true);
                    }

                }else if(itemStack.getSubNbt("trevorssentinels:holoprojector").getInt("trevorssentinels:holoMode") == 2){

                    if(block == ModBlocks.HOLOBARRIER){
                        if(itemStack.getDamage() > 0){

                            world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                            itemStack.damage(-1, context.getPlayer(),
                                    p -> p.sendToolBreakStatus(context.getHand()));
                            world.playSound(context.getPlayer().getX(), context.getPlayer().getY(),
                                    context.getPlayer().getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE,
                                    SoundCategory.BLOCKS, 0.5F, 2.0F, false);

                        }else{
                            context.getPlayer().sendMessage(Text.literal("Cannot fit block in storage!")
                                    .formatted(Formatting.DARK_RED),true);
                        }
                    }else{
                        context.getPlayer().sendMessage(Text.literal("This is not a hard light block!")
                                .formatted(Formatting.GOLD),true);
                    }

                }else{

                    if(block == ModBlocks.HOLOBARRIER){
                        if(itemStack.getDamage() > 0) {
                            context.getPlayer().sendMessage(Text.literal("There is space in storage!")
                                    .formatted(Formatting.GOLD),true);
                        }else{
                            world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                            world.playSound(context.getPlayer().getX(), context.getPlayer().getY(),
                                    context.getPlayer().getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE,
                                    SoundCategory.BLOCKS, 0.5F, -2.0F, false);
                        }
                    }else{
                        context.getPlayer().sendMessage(Text.literal("This is not a hard light block!")
                                .formatted(Formatting.GOLD),true);
                    }
                }
            }
        }
        return super.useOnBlock(context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient && hand == Hand.MAIN_HAND && Screen.hasControlDown()){
            if(itemStack.getSubNbt("trevorssentinels:holoprojector").getInt("trevorssentinels:holoMode") == 1){
                NbtCompound nbtData = new NbtCompound();
                nbtData.putInt("trevorssentinels:holoMode", 2);
                itemStack.setSubNbt("trevorssentinels:holoprojector", nbtData);

                user.sendMessage(Text.literal("Mode: Recall").formatted(Formatting.YELLOW),true);
                world.playSound(user, user.getX(), user.getY(),
                        user.getZ(), SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON,
                        SoundCategory.BLOCKS, 0.5F, 1.0F);
            }else if(itemStack.getSubNbt("trevorssentinels:holoprojector").getInt("trevorssentinels:holoMode") == 2){
                NbtCompound nbtData = new NbtCompound();
                nbtData.putInt("trevorssentinels:holoMode", 3);
                itemStack.setSubNbt("trevorssentinels:holoprojector", nbtData);

                user.sendMessage(Text.literal("Mode: Destroy").formatted(Formatting.RED),true);
                world.playSound(user, user.getX(), user.getY(),
                        user.getZ(), SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON,
                        SoundCategory.BLOCKS, 0.5F, 0.5F);
            }else{
                NbtCompound nbtData = new NbtCompound();
                nbtData.putInt("trevorssentinels:holoMode", 1);
                itemStack.setSubNbt("trevorssentinels:holoprojector", nbtData);

                user.sendMessage(Text.literal("Mode: Deploy").formatted(Formatting.AQUA),true);
                world.playSound(user, user.getX(), user.getY(),
                        user.getZ(), SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON,
                        SoundCategory.BLOCKS, 0.5F, 1.5F);
            }
        }
        return TypedActionResult.success(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(itemStack.getSubNbt("trevorssentinels:holoprojector") != null) {
            if (itemStack.getSubNbt("trevorssentinels:holoprojector").getInt("trevorssentinels:holoMode") == 1) {
                tooltip.add(Text.literal("Mode: Deploy")
                        .formatted(Formatting.AQUA));
                tooltip.add(Text.literal("Right click to place hard light blocks.")
                        .formatted(Formatting.DARK_AQUA));
            } else if (itemStack.getSubNbt("trevorssentinels:holoprojector").getInt("trevorssentinels:holoMode") == 2) {
                tooltip.add(Text.literal("Mode: Recall")
                        .formatted(Formatting.YELLOW));
                tooltip.add(Text.literal("Right click to pick up hard light blocks.")
                        .formatted(Formatting.GOLD));
            } else {
                tooltip.add(Text.literal("Mode: Destroy")
                        .formatted(Formatting.RED));
                tooltip.add(Text.literal("When storage is full, right click to")
                        .formatted(Formatting.DARK_RED));
                tooltip.add(Text.literal("permanently destroy hard light blocks.")
                        .formatted(Formatting.DARK_RED));
            }
        }else{
            NbtCompound nbtData = new NbtCompound();
            nbtData.putInt("trevorssentinels:holoMode", 1);
            itemStack.setSubNbt("trevorssentinels:holoprojector", nbtData);
        }

        tooltip.add(Text.literal("Ctrl + right click to cycle modes.")
                .formatted(Formatting.DARK_GRAY));
        if(itemStack.getDamage() <= 63){
            tooltip.add(
                    Text.literal("Blocks remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+
                            " / " + (itemStack.getMaxDamage()-1)).formatted(Formatting.AQUA));
        }else if((itemStack.getDamage() >= 64) && (itemStack.getDamage() < itemStack.getMaxDamage()-1)){
            tooltip.add(
                    Text.literal("Blocks remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+
                            " / " + (itemStack.getMaxDamage()-1)).formatted(Formatting.YELLOW));
        }else{
            tooltip.add(
                    Text.literal("Blocks remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+
                                    " / " + (itemStack.getMaxDamage()-1)).formatted(Formatting.RED));
        }
        super.appendTooltip(itemStack, world, tooltip, context);
    }

    @Override
    public Text getName(ItemStack stack) {
        if(stack.getSubNbt("holoprojector") != null){
            if(stack.getSubNbt("holoprojector").getInt("holoMode") == 1){
                return name;
            }else if(stack.getSubNbt("holoprojector").getInt("holoMode") == 2){
                return name2;
            }else{
                return name3;
            }
        }
        return name;
    }

    private final Text name = ColoredTextUtil.getColoredText("item.trevorssentinels.sentinum_holoprojector", "#189DBB");
    private final Text name2 = ColoredTextUtil.getColoredText("item.trevorssentinels.sentinum_holoprojector", "#FFAA00");
    private final Text name3 = ColoredTextUtil.getColoredText("item.trevorssentinels.sentinum_holoprojector", "#D31400");
}