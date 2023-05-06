package net.trevorskullcrafter.trevorssentinels.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.networking.packet.LaserGunReloadC2SPacket;
import net.trevorskullcrafter.trevorssentinels.networking.packet.StyleSwitchC2SPacket;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModMessages {
    public static final Identifier STYLE_SWITCH_ID = new Identifier(trevorssentinels.MOD_ID, "style_switch");
    public static final Identifier RELOAD_ID = new Identifier(trevorssentinels.MOD_ID, "reload");

    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(STYLE_SWITCH_ID, StyleSwitchC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(RELOAD_ID, LaserGunReloadC2SPacket::receive);
    }

    public static void registerS2CPackets(){

    }
}