package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
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

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            if(!Screen.hasShiftDown()){
                if (itemStack.getSubNbt("trevorssentinels:teleportData") != null) {
                    if(itemStack.getDamage() <= 0){
                        user.requestTeleportAndDismount(
                                itemStack.getSubNbt("trevorssentinels:teleportData").getInt("trevorssentinels:playerPosX"),
                                itemStack.getSubNbt("trevorssentinels:teleportData").getInt("trevorssentinels:playerPosY"),
                                itemStack.getSubNbt("trevorssentinels:teleportData").getInt("trevorssentinels:playerPosZ"));
                        world.playSound(null, user.getBlockPos(),
                                SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.BLOCKS, 2.0f, 2.0f);
                        user.getItemCooldownManager().set(this, /*200*/20);
                        itemStack.damage(itemStack.getMaxDamage()-1, user, p -> p.sendToolBreakStatus(hand));
                        return TypedActionResult.success(itemStack);
                    }else{
                        user.sendMessage(Text.literal("This item must be repaired!")
                                .formatted(Formatting.YELLOW),true);
                    }
                } else {
                    user.sendMessage(Text.literal("You must first bind this item to a location!")
                            .formatted(Formatting.YELLOW),true);
                }
            }else {
                if(itemStack.getDamage() > 0){
                    world.playSound(null, user.getBlockPos(),
                            SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.BLOCKS, 1.0f,-2.0f);
                    itemStack.damage(-1, user, p -> p.sendToolBreakStatus(hand));
                    user.getItemCooldownManager().set(this,100);
                }else {
                    //if(user.getStackInHand(hand).hasNbt()){
                    //  user.getStackInHand(hand).setNbt(new NbtCompound());
                    //}
                    NbtCompound nbtData = new NbtCompound();
                    nbtData.putDouble("trevorssentinels:playerPosX", user.getX());
                    nbtData.putDouble("trevorssentinels:playerPosY", user.getY());
                    nbtData.putDouble("trevorssentinels:playerPosZ", user.getZ());
                    nbtData.putString("trevorssentinels:boundText",
                            "Bound to " + floor(user.getX()) + ", " + floor(user.getY()) + ", " + floor(user.getZ()));
                    itemStack.setSubNbt("trevorssentinels:teleportData", nbtData);

                    user.sendMessage(Text.literal(itemStack.getSubNbt("trevorssentinels:teleportData").getString("trevorssentinels:boundText"))
                            .formatted(Formatting.DARK_PURPLE), true);
                    world.playSound(null, user.getBlockPos(),
                            SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.BLOCKS, 2.0F, 2.0F);
                    user.getItemCooldownManager().set(this, 10);
                    return TypedActionResult.success(itemStack);
                }
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(itemStack.getSubNbt("trevorssentinels:teleportData") != null){
            if(itemStack.getDamage() <= 0){
                tooltip.add(Text.literal(itemStack.getSubNbt("trevorssentinels:teleportData").getString("trevorssentinels:boundText"))
                        .formatted(Formatting.DARK_PURPLE));
                tooltip.add(Text.literal("Hold shift and right click").formatted(Formatting.GRAY));
                tooltip.add(Text.literal("to bind to a new location!").formatted(Formatting.GRAY));
            }else{
                tooltip.add(Text.literal(itemStack.getSubNbt("trevorssentinels:teleportData").getString("trevorssentinels:boundText"))
                        .formatted(Formatting.GRAY));
                tooltip.add(Text.literal("Hold shift and right click")
                        .formatted(Formatting.DARK_GRAY));
                tooltip.add(Text.literal("to repair!")
                        .formatted(Formatting.DARK_GRAY));
            }
        }else{
            tooltip.add(Text.literal("Hold shift and right click").formatted(Formatting.YELLOW));
            tooltip.add(Text.literal("to bind to a location!").formatted(Formatting.YELLOW));

        }
    }

    @Override
    public boolean hasGlint(ItemStack stack){
            return stack.getSubNbt("trevorssentinels:teleportData") != null;
    }
}