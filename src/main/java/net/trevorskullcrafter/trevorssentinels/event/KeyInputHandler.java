package net.trevorskullcrafter.trevorssentinels.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.trevorskullcrafter.trevorssentinels.networking.ModMessages;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_TREVORSSENTINELS = "key.category.trevorssentinels.trevorssentinels";
    public static final String KEY_STYLE_SWITCH = "key.trevorssentinels.style_switch";
    public static final String KEY_RELOAD = "key.trevorssentinels.reload";

    public static KeyBinding styleSwitch;
    public static KeyBinding reload;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(styleSwitch.wasPressed()) ClientPlayNetworking.send(ModMessages.STYLE_SWITCH_ID, PacketByteBufs.create());
            if(reload.wasPressed()) ClientPlayNetworking.send(ModMessages.RELOAD_ID, PacketByteBufs.create());
        });
    }

    public static void register(){
        styleSwitch = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_STYLE_SWITCH, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_TREVORSSENTINELS));
        reload = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_RELOAD, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_TREVORSSENTINELS));

        registerKeyInputs();
    }
}