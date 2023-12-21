package net.trevorskullcrafter.trevorssentinels.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.trevorskullcrafter.trevorssentinels.item.custom.GunItem;

public class LaserGunReloadC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        if(player.getMainHandStack().getItem() instanceof GunItem gun){
            gun.reloadGun(player.getMainHandStack(), player.getWorld(), player);
            if(player.getMainHandStack().getItem() == player.getOffHandStack().getItem()) { gun.reloadGun(player.getOffHandStack(), player.getWorld(), player); }
        }
    }
}