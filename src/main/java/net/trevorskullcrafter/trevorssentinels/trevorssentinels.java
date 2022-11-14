package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModBlockEntities;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.custom.FlorbusEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.RoombaEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.SentinelEntity;
import net.trevorskullcrafter.trevorssentinels.fluid.ModFluids;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.recipe.ModRecipes;
import net.trevorskullcrafter.trevorssentinels.screen.ModScreenHandlers;
import net.trevorskullcrafter.trevorssentinels.util.ModFlammableBlocks;
import net.trevorskullcrafter.trevorssentinels.util.ModStrippableBlocks;
import net.trevorskullcrafter.trevorssentinels.villager.ModVillagers;
import net.trevorskullcrafter.trevorssentinels.world.feature.ModConfiguredFeatures;
import net.trevorskullcrafter.trevorssentinels.world.gen.ModOreGeneration;
import net.trevorskullcrafter.trevorssentinels.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class trevorssentinels implements ModInitializer {
	public static final String MOD_ID = "trevorssentinels";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModArmory.registerArmory();
		ModBlocks.registerModBlocks();
		ModWorldGen.generateWorldGen();

		ModBlockEntities.registerAllBlockEntities();
		ModScreenHandlers.registerAllScreenHandlers();
		ModRecipes.registerRecipes();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModFluids.register();
		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippables();

		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.SENTINEL, SentinelEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SENTINUM_ROOMBA, RoombaEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FLORBUS, FlorbusEntity.setAttributes());

		//ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}