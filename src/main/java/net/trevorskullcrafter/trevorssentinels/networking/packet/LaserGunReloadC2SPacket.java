package net.trevorskullcrafter.trevorssentinels.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.trevorskullcrafter.trevorssentinels.item.custom.LaserGunItem;

import java.util.Objects;

public class LaserGunReloadC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        if(player.isSneaking()){
            player.sendMessage(Text.empty().append("Automatic Reloading: ").append(getAutomaticReloading(player.getMainHandStack(), true) ?
            Text.literal("ON").formatted(Formatting.GREEN, Formatting.BOLD) : Text.literal("OFF").formatted(Formatting.RED, Formatting.BOLD)), true);
            player.getWorld().playSoundFromEntity(null, player, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.PLAYERS, 1.0f, 1.0f);
        } else if(player.getMainHandStack().getItem() instanceof LaserGunItem laserGun){
            if(player.getMainHandStack().getItem() == player.getOffHandStack().getItem()) { laserGun.reloadGun(player.getOffHandStack(), player.getWorld(), player); }
            laserGun.reloadGun(player.getMainHandStack(), player.getWorld(), player);
        }
    }

    public static boolean getAutomaticReloading(ItemStack stack, boolean r){
        if(stack.getSubNbt("trevorssentinels:autoReload") == null){
            NbtCompound nbtData = new NbtCompound(); nbtData.putBoolean("isOn", false);
            stack.setSubNbt("trevorssentinels:autoReload", nbtData);
        } if(r){
            NbtCompound nbtData = new NbtCompound();
            nbtData.putBoolean("isOn", !Objects.requireNonNull(stack.getSubNbt("trevorssentinels:autoReload")).getBoolean("isOn"));
            stack.setSubNbt("trevorssentinels:autoReload", nbtData);
        } return Objects.requireNonNull(stack.getSubNbt("trevorssentinels:autoReload")).getBoolean("isOn");
    }
}