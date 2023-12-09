package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModBlockEntities;
import net.trevorskullcrafter.trevorssentinels.datagen.BlockTagGenerator;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.custom.*;
import net.trevorskullcrafter.trevorssentinels.fluid.ModFluids;
import net.trevorskullcrafter.trevorssentinels.item.*;
import net.trevorskullcrafter.trevorssentinels.networking.ModMessages;
import net.trevorskullcrafter.trevorssentinels.potion.ModPotions;
import net.trevorskullcrafter.trevorssentinels.recipe.ModRecipes;
import net.trevorskullcrafter.trevorssentinels.util.*;
import net.trevorskullcrafter.trevorssentinels.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

import java.awt.*;
import java.util.Objects;

import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.*;

public class trevorssentinels implements ModInitializer {
	public static final String MOD_ID = "trevorssentinels";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<ItemGroup> SENTINELS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(trevorssentinels.MOD_ID, "sentinels"));
	public static final RegistryKey<ItemGroup> EFFECTS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(trevorssentinels.MOD_ID, "effects"));
	public static final RegistryKey<ItemGroup> BETA = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(trevorssentinels.MOD_ID, "beta"));

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

		PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, entity) -> {
			if(player.isCreative()) { return true; }
			int requiredLevel;
			if(state.isIn(BlockTagGenerator.REQUIRES_LEVEL_3)) { requiredLevel = 3; }
			else if(state.isIn(BlockTagGenerator.REQUIRES_LEVEL_2)) { requiredLevel = 2; }
			else { requiredLevel = 1; }
			if(requiredLevel > Objects.requireNonNull(ServerState.getServerState(Objects.requireNonNull(world.getServer()))).worldLevel){
				Identifier tooLow = new Identifier(trevorssentinels.MOD_ID, "worldLevelTooLow");
				if(TextUtil.translationDiffersFromKey(tooLow.toTranslationKey())) {
					player.sendMessage(coloredText(tooLow + "." + requiredLevel, Color.decode(Text.translatable("color" + tooLow + "." + requiredLevel).toString())), true);
				} else { player.sendMessage(Text.translatable(tooLow + ".other").formatted(Formatting.GRAY), true); }
				return false;
			} return true;
		});

		FabricLoader.getInstance().getModContainer(trevorssentinels.MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(trevorssentinels.MOD_ID, "hologui"), modContainer,
					Text.literal("Sentinel HoloGUI"), ResourcePackActivationType.NORMAL);
			ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(trevorssentinels.MOD_ID, "vanilla_parity"), modContainer,
					Text.literal("Vanilla Parity"), ResourcePackActivationType.DEFAULT_ENABLED);
			ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(trevorssentinels.MOD_ID, "legacy"), modContainer,
					Text.literal("Legacy Resources"), ResourcePackActivationType.NORMAL);
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

		Registry.register(Registries.ITEM_GROUP, SENTINELS, FabricItemGroup.builder()
				.displayName(TextUtil.coloredText("itemGroup.trevorssentinels.sentinels", SENTINEL_AQUA))
				.icon(() -> new ItemStack(ModItems.HARD_LIGHT_PROJECTOR)).build());
		Registry.register(Registries.ITEM_GROUP, EFFECTS, FabricItemGroup.builder()
				.displayName(TextUtil.coloredText("itemGroup.trevorssentinels.effects", COPPER))
				.icon(() -> new ItemStack(ModEffectItems.ONE_PENCE)).build());
		Registry.register(Registries.ITEM_GROUP, BETA, FabricItemGroup.builder()
				.displayName(TextUtil.coloredText("itemGroup.trevorssentinels.beta", DARK_GREEN))
				.icon(() -> new ItemStack(ModItems.RUINOUS_GAZE)).build());
		ModItemGroupEvents.registerAllGroupEvents();
		ModRegistries.registerWorldLevelState();
	}
}