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
		float randomJokeInt = Random.create().nextInt(5);
		if(randomJokeInt == 0) trevorssentinels.LOGGER.info("ay yo, the pizza here");
		else if(randomJokeInt == 1) trevorssentinels.LOGGER.info("touching grass is prohibited.");
		else if(randomJokeInt == 2) trevorssentinels.LOGGER.info("*mic drop*");
		else if(randomJokeInt == 3) trevorssentinels.LOGGER.info("I'll load the game when you fix this damn door!");
		else if(randomJokeInt == 4) trevorssentinels.LOGGER.info("Error: tasteless joke missing");
		else trevorssentinels.LOGGER.info("Missing joke! ("+randomJokeInt+")");
	}
}