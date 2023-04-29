package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class DistanceTrackerItem extends Item {
    LivingEntity attachedMob; double distance; Text text1; Text text2; float pitch; int timeTick;
    public DistanceTrackerItem(Settings settings) { super(settings); }

    @Override public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(!user.getWorld().isClient() && hand == Hand.MAIN_HAND) attachedMob = entity; return super.useOnEntity(stack, user, entity, hand);
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity playerEntity) { if (!world.isClient) {
                if (attachedMob != null && attachedMob.isAlive()) {
                    distance = (double) Math.round(Math.sqrt(Math.pow(attachedMob.getBlockX() - entity.getBlockX(), 2) +
                            Math.pow(attachedMob.getBlockY() - entity.getBlockY(), 2) + Math.pow(attachedMob.getBlockZ() - entity.getBlockZ(), 2)) * 10) / 10;
                    if (distance < 100) {
                        if (distance >= 50) resetNbt(stack, 0, simpleText("88.8m", Formatting.DARK_GRAY),
                                simpleText("88.8m", Formatting.DARK_GRAY), 0f, 1);
                        else if (distance >= 25) resetNbt(stack, 1, simpleText(distance + "m", Formatting.DARK_GREEN),
                                simpleText(distance + "m", Formatting.GREEN), 0.9f, 20);
                        else if (distance >= 10) resetNbt(stack, 2, simpleText(distance + "m", Formatting.GOLD),
                                simpleText(distance + "m", Formatting.YELLOW), 1.0f, 10);
                        else resetNbt(stack, 3, simpleText("0" + distance + "m", Formatting.DARK_RED),
                                    simpleText("0" + distance + "m", Formatting.RED), 1.2f, 2);
                    }
                } else resetNbt(stack, 0, null, null, 0f, 0); attachedMob = null;
            } else {
                if (distance < 100 && text1 != null && text2 != null && selected) {
                    if ((world.getTime() & timeTick) == 0) {
                        playerEntity.sendMessage(text1, true);
                        if (pitch != 0f) entity.playSound(SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF, 0.5f, pitch);
                    } else ((PlayerEntity) entity).sendMessage(text2, true);
                }
            }
        } super.inventoryTick(stack, world, entity, slot, selected);
    }

    public void resetNbt(ItemStack stack, int state, Text text1p, Text text2p, float pitchp, int timeTickp){
        if((stack.getSubNbt("trevorssentinels:model") == null) || (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:model"))
                .getInt("trevorssentinels:modelNum") != state)){
            NbtCompound nbtData = new NbtCompound(); nbtData.putInt("trevorssentinels:modelNum", state); stack.setSubNbt("trevorssentinels:model", nbtData);
        } text1 = text1p; text2 = text2p; pitch = pitchp; timeTick = timeTickp;
    }

    public Text simpleText(String content, Formatting format){ return Text.literal(content).formatted(format); }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(attachedMob == null)tooltip.add(Text.literal("Tracking system offline.").formatted(Formatting.DARK_RED));
        else tooltip.add(Text.literal("Tracking system online...").formatted(Formatting.GOLD));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}