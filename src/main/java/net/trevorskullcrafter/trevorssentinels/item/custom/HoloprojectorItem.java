package net.trevorskullcrafter.trevorssentinels.item.custom;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HoloprojectorItem extends Item {
    public HoloprojectorItem(Settings settings) {
        super(settings);
    }
    private int mode = 1;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        //Server: giving/removing items
        //Client: rendering, particle effects, music/sound
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();
        if(!world.isClient() && context.getHand() == Hand.MAIN_HAND){
            ItemStack itemStack = context.getPlayer().getStackInHand(context.getHand());

            if(!Screen.hasControlDown()){
                if(mode == 1){

                    if(itemStack.getDamage() < itemStack.getMaxDamage()-1) {

                        world.setBlockState(context.getBlockPos().offset(context.getSide(),1),
                                ModBlocks.HOLOBARRIER.getDefaultState());
                        itemStack.damage(1, context.getPlayer(), p -> p.sendToolBreakStatus(context.getHand()));
                        world.playSound(null, context.getPlayer().getX(), context.getPlayer().getY(),
                                context.getPlayer().getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE,
                                SoundCategory.BLOCKS, 0.5F, 2.0F);

                    }else{
                        context.getPlayer().sendMessage(Text.literal("Maximum blocks projected!")
                                .formatted(Formatting.DARK_RED),true);
                    }

                }else if(mode == 2){

                    if(block == ModBlocks.HOLOBARRIER){
                        if(itemStack.getDamage() > 0){

                            world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                            itemStack.damage(-1, context.getPlayer(),
                                    p -> p.sendToolBreakStatus(context.getHand()));
                            world.playSound(null, context.getPlayer().getX(), context.getPlayer().getY(),
                                    context.getPlayer().getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_DEPLETE,
                                    SoundCategory.BLOCKS, 0.5F, 2.0F);

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
                            world.playSound(null, context.getPlayer().getX(), context.getPlayer().getY(),
                                    context.getPlayer().getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_DEPLETE,
                                    SoundCategory.BLOCKS, 0.5F, -2.0F);
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
            if(mode == 1){
                mode = 2;
                user.sendMessage(Text.literal("Mode: Recall").formatted(Formatting.YELLOW),true);
                world.playSound(null, user.getX(), user.getY(),
                        user.getZ(), SoundEvents.UI_BUTTON_CLICK,
                        SoundCategory.BLOCKS, 0.5F, 1.0F);
            }else if(mode == 2){
                mode = 3;
                user.sendMessage(Text.literal("Mode: Destroy").formatted(Formatting.RED),true);
                world.playSound(null, user.getX(), user.getY(),
                        user.getZ(), SoundEvents.UI_BUTTON_CLICK,
                        SoundCategory.BLOCKS, 0.5F, 0.5F);
            }else{
                mode = 1;
                user.sendMessage(Text.literal("Mode: Deploy").formatted(Formatting.AQUA),true);
                world.playSound(null, user.getX(), user.getY(),
                        user.getZ(), SoundEvents.UI_BUTTON_CLICK,
                        SoundCategory.BLOCKS, 0.5F, 1.5F);
            }
        }
        return TypedActionResult.success(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(mode == 1){
            tooltip.add(Text.literal("Mode: Deploy")
                    .formatted(Formatting.AQUA));
            tooltip.add(Text.literal("Right click to place hard light blocks.")
                    .formatted(Formatting.DARK_AQUA));
        }else if(mode == 2){
            tooltip.add(Text.literal("Mode: Recall")
                    .formatted(Formatting.YELLOW));
            tooltip.add(Text.literal("Right click to pick up hard light blocks.")
                    .formatted(Formatting.GOLD));
        }else{
            tooltip.add(Text.literal("Mode: Destroy")
                    .formatted(Formatting.RED));
            tooltip.add(Text.literal("When storage is full, right click to")
                    .formatted(Formatting.DARK_RED));
            tooltip.add(Text.literal("permanently destroy hard light blocks.")
                    .formatted(Formatting.DARK_RED));
        }
        tooltip.add(Text.literal("Ctrl + right click to cycle modes.")
                .formatted(Formatting.DARK_GRAY));
        if(itemStack.getDamage() <= 63){
            tooltip.add(
                    Text.literal("Blocks remaining: " + (itemStack.getMaxDamage() - itemStack.getDamage() - 1))
                            .formatted(Formatting.AQUA));
        }else if((itemStack.getDamage() >= 64) && (itemStack.getDamage() < itemStack.getMaxDamage()-1)){
            tooltip.add(
                    Text.literal("Blocks remaining: " + (itemStack.getMaxDamage() - itemStack.getDamage() - 1))
                            .formatted(Formatting.YELLOW));
        }else{
            tooltip.add(
                    Text.literal("Blocks remaining: " + (itemStack.getMaxDamage() - itemStack.getDamage() - 1))
                            .formatted(Formatting.RED));
        }

    }
}
