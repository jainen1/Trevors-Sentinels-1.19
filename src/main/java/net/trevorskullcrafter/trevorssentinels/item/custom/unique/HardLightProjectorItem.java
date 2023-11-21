package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.event.KeyInputHandler;
import net.trevorskullcrafter.trevorssentinels.util.StyleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class HardLightProjectorItem extends Item implements StyleUtil.StyleSwitcher {
    public HardLightProjectorItem(Settings settings) { super(settings); }

    @Override public int getStyles(){ return 3; }
    @Override public void onStyleSwitch(ServerPlayerEntity player){
        ServerWorld world = Objects.requireNonNull(player.getServer()).getWorld(World.OVERWORLD);
        ItemStack stack = player.getMainHandStack();
        player.sendMessage(Text.empty().append(StyleUtil.mode).append(StyleUtil.currentStyle(stack)).formatted(getStyleSwitchFormatting(stack)), true);
        assert world != null;
        world.playSoundFromEntity(null, player, SoundEvents.UI_BUTTON_CLICK.value(), SoundCategory.BLOCKS, 0.5f, 1.5f);
    }
    @Override public Formatting getStyleSwitchFormatting(ItemStack stack){
        return StyleUtil.getStyle(stack) == 1? Formatting.AQUA : StyleUtil.getStyle(stack) == 2? Formatting.YELLOW : Formatting.RED;
    }

    @Override public ActionResult useOnBlock(ItemUsageContext context) {
        //Server: giving/removing items
        //Client: rendering, particle effects, music/sound
        World world = context.getWorld(); PlayerEntity user = context.getPlayer(); BlockPos blockPos = context.getBlockPos(); ActionResult actionResult = ActionResult.FAIL;
        if(!world.isClient() && context.getHand() == Hand.MAIN_HAND && user != null){
            ItemStack itemStack = user.getMainHandStack();
            if(!KeyInputHandler.styleSwitch.isPressed()){
                switch (StyleUtil.getStyle(itemStack)){
                    case 1 -> {
                        if(itemStack.getDamage() < itemStack.getMaxDamage()-1) {
                            if(world.canPlace(ModBlocks.HARD_LIGHT.getPlacementState(new ItemPlacementContext(context)), blockPos.offset(context.getSide()), ShapeContext.absent())){
                                context.getWorld().setBlockState(blockPos.offset(context.getSide()), ModBlocks.HARD_LIGHT.getPlacementState(new ItemPlacementContext(context)), 11);
                                itemStack.damage(1, user, p -> p.sendToolBreakStatus(context.getHand()));
                                world.playSoundFromEntity(null, user, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 0.5F, 2.0F);
                                actionResult = ActionResult.SUCCESS;
                            } else user.sendMessage(Text.literal("Block placement failed!").formatted(Formatting.DARK_AQUA), true);
                        } else user.sendMessage(Text.literal("Maximum blocks projected!").formatted(Formatting.DARK_RED),true);
                    } case 2 -> {
                        if(world.getBlockState(blockPos).getBlock() == ModBlocks.HARD_LIGHT){
                            if(itemStack.getDamage() > 0){
                                world.breakBlock(blockPos, false);
                                itemStack.damage(-1, user, p -> p.sendToolBreakStatus(context.getHand()));
                                world.playSoundFromEntity(null, user, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 0.5F, 2.0F);
                                actionResult = ActionResult.SUCCESS;
                            } else user.sendMessage(Text.literal("Cannot fit block in storage!").formatted(Formatting.DARK_RED),true);
                        } else user.sendMessage(Text.literal("This is not a hard light block!").formatted(Formatting.GOLD),true);
                    } case 3 -> {
                        if(world.getBlockState(blockPos).getBlock() == ModBlocks.HARD_LIGHT){
                            if(itemStack.getDamage() > 0) user.sendMessage(Text.literal("There is space in storage!").formatted(Formatting.GOLD),true);
                            else{
                                world.breakBlock(blockPos, false);
                                world.playSoundFromEntity(null, user, SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.BLOCKS, 0.5F, -2.0F);
                                actionResult = ActionResult.SUCCESS;
                            }
                        } else user.sendMessage(Text.literal("This is not a hard light block!").formatted(Formatting.GOLD),true);
                    }
                }
            }
        } return actionResult;
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.empty().append(StyleUtil.mode).append(StyleUtil.currentStyle(itemStack)).formatted(getStyleSwitchFormatting(itemStack)));
        if (StyleUtil.getStyle(itemStack) == 1) tooltip.add(Text.literal("Places hard light blocks.").formatted(Formatting.DARK_AQUA));
        else if (StyleUtil.getStyle(itemStack) == 2) tooltip.add(Text.literal("Picks up hard light blocks.").formatted(Formatting.GOLD));
        else tooltip.add(Text.literal("Permanently destroys hard light blocks.").formatted(Formatting.DARK_RED));
        tooltip.add(StyleUtil.switchText(world, 2));
        tooltip.add(Text.literal("Blocks remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+
                " / " + (itemStack.getMaxDamage()-1)).formatted(itemStack.getDamage() <= (itemStack.getMaxDamage()/2)-1 ? Formatting.AQUA :
                ((itemStack.getDamage() < itemStack.getMaxDamage()-1) ? Formatting.YELLOW : Formatting.RED)));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}