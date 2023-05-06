package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModBlockEntities;
import net.trevorskullcrafter.trevorssentinels.data.EnglishLangGenerator;
import static net.trevorskullcrafter.trevorssentinels.data.EnglishLangGenerator.*;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.custom.*;
import net.trevorskullcrafter.trevorssentinels.fluid.ModFluids;
import net.trevorskullcrafter.trevorssentinels.item.*;
import net.trevorskullcrafter.trevorssentinels.networking.ModMessages;
import net.trevorskullcrafter.trevorssentinels.potion.ModPotions;
import net.trevorskullcrafter.trevorssentinels.recipe.ModRecipes;
import net.trevorskullcrafter.trevorssentinels.screen.ModScreenHandlers;
import net.trevorskullcrafter.trevorssentinels.util.*;
import net.trevorskullcrafter.trevorssentinels.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class trevorssentinels implements ModInitializer {
	public static final String MOD_ID = "trevorssentinels";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ItemGroup SENTINELS = FabricItemGroup.builder(new Identifier(trevorssentinels.MOD_ID, "sentinels"))
			.displayName(EnglishLangGenerator.getColoredText("itemGroup.trevorssentinels.sentinels", sentinel_accent))
			.icon(() -> new ItemStack(ModItems.GALINITE_HOLOPROJECTOR)).build();
	public static ItemGroup EFFECTS = FabricItemGroup.builder(new Identifier(trevorssentinels.MOD_ID, "effects"))
			.displayName(EnglishLangGenerator.getColoredText("itemGroup.trevorssentinels.effects", rainbow))
			.icon(() -> new ItemStack(ModEffectItems.ONE_PENCE)).build();
	public static ItemGroup BETA = FabricItemGroup.builder(new Identifier(trevorssentinels.MOD_ID, "beta"))
			.displayName(EnglishLangGenerator.getColoredText("itemGroup.trevorssentinels.beta", zenithium))
			.icon(() -> new ItemStack(ModItems.RUINOUS_GAZE)).build();

	@Override public void onInitialize() {
        /*EntityElytraEvents.CUSTOM.register((entity, tickElytra) -> {
			if (entity instanceof PlayerEntity player && !player.isOnGround() &&
					player.getInventory().getArmorStack(0).getItem() instanceof ArmorItem boots && boots.getMaterial() == ModArmorMaterials.NUCLEAR &&
					player.getInventory().getArmorStack(1).getItem() instanceof ArmorItem leggings && leggings.getMaterial() == ModArmorMaterials.NUCLEAR &&
					player.getInventory().getArmorStack(2).getItem() instanceof ArmorItem chestplate && chestplate.getMaterial() == ModArmorMaterials.NUCLEAR &&
					player.getInventory().getArmorStack(3).getItem() instanceof ArmorItem helmet && helmet.getMaterial() == ModArmorMaterials.NUCLEAR){
				if (tickElytra) { player.addExhaustion(0.1f); //placeholder effect for soul
				if(!player.getWorld().isClient() && player.getWorld().getTime() % 5 == 0) player.getWorld().playSoundFromEntity(null, player,
						SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.MASTER, Math.min(Math.abs((float) player.getVelocity().y), 2.0f), 0f);
				else player.getWorld().addParticle(ParticleTypes.LARGE_SMOKE, player.getX(), player.getY(), player.getZ(),
						-player.getVelocity().x, -player.getVelocity().y, -player.getVelocity().z);
			} return true; } return false;
		});*/

		FabricLoader.getInstance().getModContainer(trevorssentinels.MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(trevorssentinels.MOD_ID, "hologui"), modContainer,
					Text.literal("Sentinel HoloGUI"), ResourcePackActivationType.NORMAL);
			ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(trevorssentinels.MOD_ID, "vanilla_parity"), modContainer,
					Text.literal("Vanilla Parity"), ResourcePackActivationType.DEFAULT_ENABLED);
		});

		ModEffects.registerStatusEffects();
		ModItems.registerModItems();
		ModMessages.registerC2SPackets();
		ModArmory.registerArmory();
		ModEffectItems.registerModItems();
		BetaItems.registerModItems();
		ModPotions.registerPotions();
		ModBlocks.registerModBlocks();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModFluids.registerFluids();
		ModRegistries.registerFlammableBlocks();
		ModRegistries.registerStrippables();
		ModRegistries.registerFuels();
		ModRegistries.registerCommands();
		ModLootTableModifiers.modifyLootTables();

		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.SENTINEL, SentinelEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GALINITE_ROOMBA, RoombaEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FLORBUS, FlorbusEntity.setAttributes());

		ModItemGroupEvents.registerAllGroupEvents();
		ModRegistries.registerWorldLevelState();
	}
}