package net.trevorskullcrafter.trevorssentinels.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<ForgeScreenHandler> FORGE_SCREEN_HANDLER;
    public static void registerScreenHandlers() {
        FORGE_SCREEN_HANDLER = new ScreenHandlerType<>(ForgeScreenHandler::new);
    }
}