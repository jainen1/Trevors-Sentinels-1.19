package net.trevorskullcrafter.trevorssentinels.item.custom;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HoloprojectorItem extends ToolItem {
    public HoloprojectorItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        //Server: giving/removing items
        //Client: rendering, particle effects, music/sound
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();
        if(!world.isClient() && context.getHand() == Hand.MAIN_HAND){
            ItemStack itemStack = context.getPlayer().getStackInHand(context.getHand());

            //If you are pressing shift, looking at a holobarrier and the item can hold it, replace the block with air and repair item
            if(Screen.hasControlDown()){
                    if(block == ModBlocks.HOLOBARRIER){
                        if(itemStack.getDamage() > 0){

                            world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                            itemStack.damage(-1, context.getPlayer(), p -> p.sendToolBreakStatus(context.getHand()));
                            world.playSound(null, context.getPlayer().getX(), context.getPlayer().getY(),
                                    context.getPlayer().getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_DEPLETE, SoundCategory.BLOCKS, 2.0F, 2.0F);

                        }else{
                            context.getPlayer().sendMessage(Text.literal("Cannot fit block in storage!").formatted(Formatting.DARK_AQUA));
                        }
                    }else{
                        context.getPlayer().sendMessage(Text.literal("This is not a hard light block!").formatted(Formatting.DARK_AQUA));
                    }
            }else{
                //If you're not holding shift and the item isn't at 1 durability, place block and damage item
                if(itemStack.getDamage() < itemStack.getMaxDamage()-1) {

                world.setBlockState(context.getBlockPos().offset(context.getSide(),1), ModBlocks.HOLOBARRIER.getDefaultState());
                itemStack.damage(1, context.getPlayer(), p -> p.sendToolBreakStatus(context.getHand()));
                world.playSound(null, context.getPlayer().getX(), context.getPlayer().getY(),
                        context.getPlayer().getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 2.0F, 2.0F);

                }else{
                    context.getPlayer().sendMessage(Text.literal("Maximum blocks projected!").formatted(Formatting.DARK_AQUA));
                }
            }
        }
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("Right click to place a hard light block.").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.literal("Ctrl + right click to pick it back up.").formatted(Formatting.GOLD));
    }
}
