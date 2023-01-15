package net.trevorskullcrafter.trevorssentinels.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_FLYING = "key.category.trevorssentinels.flying";
    public static final String KEY_FLY_UPWARD = "key.trevorssentinels.fly.upward";
    public static final String KEY_FLY_FORWARD = "key.trevorssentinels.fly.forward";
    public static final String KEY_FLY_LEFT = "key.trevorssentinels.fly.left";
    public static final String KEY_FLY_RIGHT = "key.trevorssentinels.fly.right";
    public static final String KEY_FLY_BACKWARD = "key.trevorssentinels.fly.backward";
    public static final String KEY_FLY_HOVER = "key.trevorssentinels.fly.hover";

    public static KeyBinding flyUpKey;

    /*public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(flyUpKey.wasPressed()){

            }
        });
    }*/

    public static void register(){
        flyUpKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FLY_UPWARD,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_SPACE,
                KEY_CATEGORY_FLYING
        ));

        //registerKeyInputs();
    }
}


