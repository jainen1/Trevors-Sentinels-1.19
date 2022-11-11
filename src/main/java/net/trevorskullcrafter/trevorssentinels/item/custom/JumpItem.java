package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JumpItem extends Item {
    int jumpTime = 0;
    long cooldownTime = 0;
    float velocity = 0f;

    public JumpItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity && !world.isClient()){
            if(world.getTime() > cooldownTime) {
                if (Screen.hasShiftDown()) {
                    if (jumpTime == 100) {
                        ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ ▲ ▲").formatted(Formatting.AQUA),true);
                    }else if(jumpTime >= 80){
                        ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ ▲ △").formatted(Formatting.GREEN),true);
                        jumpTime++;
                    }else if(jumpTime >= 60){
                        ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ ▲ △ △").formatted(Formatting.YELLOW),true);
                        jumpTime++;
                    }else if(jumpTime >= 40){
                        ((PlayerEntity) entity).sendMessage(Text.literal("▲ ▲ △ △ △").formatted(Formatting.GOLD),true);
                        jumpTime++;
                    }else if(jumpTime >= 20){
                        ((PlayerEntity) entity).sendMessage(Text.literal("▲ △ △ △ △").formatted(Formatting.RED),true);
                        jumpTime++;
                    }else{
                        ((PlayerEntity) entity).sendMessage(Text.literal("△ △ △ △ △").formatted(Formatting.GRAY),true);
                        jumpTime++;
                    }
                } else {
                    if (jumpTime > 0) {
                        velocity = (float) jumpTime / 60;
                        entity.addVelocity(0f, velocity, 0f);
                        world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.AMBIENT, velocity, -velocity + 0.7f);
                        cooldownTime = world.getTime() + jumpTime;
                        ((PlayerEntity) entity).getItemCooldownManager().set(this, jumpTime);
                    }
                    jumpTime = 0;
                }
            }else{
                if(((cooldownTime - world.getTime()) & 20) == 0){
                    world.playSound((PlayerEntity) entity, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.AMBIENT, (cooldownTime - world.getTime()) / 200, 0.0f);
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Hold SHIFT to charge; release to jump."));
        tooltip.add(Text.literal("WARNING: UNSTABLE, DOES NOT ALWAYS WORK.").formatted(Formatting.RED));
    }
}