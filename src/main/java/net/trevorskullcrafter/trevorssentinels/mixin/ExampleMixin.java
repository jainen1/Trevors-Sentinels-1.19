package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.util.math.random.Random;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		String[] flavors = {"ay yo, the pizza here", "touching grass is prohibited.", "*mic drop*",
				"I'll load the game when you fix this damn door!", "Error 404: tasteless joke not found",
				"Oh, here we go again...", "Don't you have work to be doing?"};
		trevorssentinels.LOGGER.info(flavors[Random.create().nextInt(flavors.length)]);
	}
}