package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.api.ModInitializer;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class trevorssentinels implements ModInitializer {
	public static final String MOD_ID = "trevorssentinels";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

	}
}
