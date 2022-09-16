package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static java.lang.Math.floor;

public class PortkeyItem extends Item {
    public PortkeyItem(Settings settings) {
        super(settings);
    }
    private double recordedX;
    private double recordedY;
    private double recordedZ;
    private boolean recorded = false;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            if(!Screen.hasShiftDown()){
                if (!this.recorded) {
                    user.sendMessage(Text.literal("You must first bind this item to a location!").formatted(Formatting.YELLOW));
                } else {
                    user.teleport(recordedX, recordedY, recordedZ, true);

                    world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.BLOCKS, 2.0F, 2.0F);
                    user.getItemCooldownManager().set(this, 200);
                    return TypedActionResult.success(itemStack);
                }
            }else {
                recordedX = (user.getX());
                recordedY = (user.getY());
                recordedZ = (user.getZ());
                recorded = true;
                user.sendMessage(Text.literal("Item bound to "+floor(this.recordedX)+", "+floor(this.recordedY)+", "+floor(this.recordedZ)).formatted(Formatting.DARK_PURPLE));
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.BLOCKS, 2.0F, 2.0F);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(recorded){
            tooltip.add(Text.literal("Currently bound to: "+floor(this.recordedX)+", "+floor(this.recordedY)+", "+floor(this.recordedZ)).formatted(Formatting.DARK_PURPLE));
        }else{
            tooltip.add(Text.literal("Hold shift and right click to bind to a location!").formatted(Formatting.YELLOW));
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return recorded;
    }
}
