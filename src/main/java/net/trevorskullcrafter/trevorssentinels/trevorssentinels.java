package net.trevorskullcrafter.trevorssentinels;

import com.anthonyhilyard.prism.util.ConfigHelper;
import com.google.common.collect.Lists;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Language;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModBlockEntities;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.custom.*;
import net.trevorskullcrafter.trevorssentinels.fluid.ModFluids;
import net.trevorskullcrafter.trevorssentinels.item.*;
import net.trevorskullcrafter.trevorssentinels.potion.ModPotions;
import net.trevorskullcrafter.trevorssentinels.recipe.ModRecipes;
import net.trevorskullcrafter.trevorssentinels.screen.ModScreenHandlers;
import net.trevorskullcrafter.trevorssentinels.util.ColoredTextUtil;
import net.trevorskullcrafter.trevorssentinels.util.ModFlammableBlocks;
import net.trevorskullcrafter.trevorssentinels.util.ModLootTableModifiers;
import net.trevorskullcrafter.trevorssentinels.util.ModStrippableBlocks;
import net.trevorskullcrafter.trevorssentinels.villager.ModVillagers;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

import java.util.List;

public class trevorssentinels implements ModInitializer {
	public static final String MOD_ID = "trevorssentinels";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final EntityType<ShardEntity> ShardEntityType = Registry.register(
			Registries.ENTITY_TYPE, new Identifier(trevorssentinels.MOD_ID, "sentinum_shard"),
			FabricEntityTypeBuilder.<ShardEntity>create(SpawnGroup.MISC, ShardEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build()
	);

	private static final Text groupName = new Text() {
		private final TextContent content = new TranslatableTextContent("itemGroup.trevorssentinels.sentinels");
		private final Style style = Style.EMPTY.withColor((TextColor)(Object) ConfigHelper.parseColor(ColoredTextUtil.sentinel_accent));
		@Nullable
		private Language decomposedWith;
		private OrderedText visualOrderText = OrderedText.EMPTY;
		@Override
		public Style getStyle() { return style; }
		@Override
		public TextContent getContent() { return content; }
		@Override
		public List<Text> getSiblings() { return Lists.newArrayList(); }
		@Override
		public OrderedText asOrderedText()
		{
			Language language = Language.getInstance();
			if (this.decomposedWith != language)
			{
				this.visualOrderText = language.reorder(this);
				this.decomposedWith = language;
			}
			return this.visualOrderText;
		}
	};
	public static ItemGroup SENTINELS = FabricItemGroup.builder(new Identifier(trevorssentinels.MOD_ID, "sentinels"))
			.displayName(groupName).icon(() -> new ItemStack(ModItems.SENTINUM_HOLOPROJECTOR)).build();

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModArmory.registerArmory();
		ModEffects.registerStatusEffects();
		ModEffectItems.registerModItems();
		ModPotions.registerPotions();
		ModBlocks.registerModBlocks();
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xCFF8FF, ModItems.VENDOR_TOKEN);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xaa00aa, ModItems.LEGENDARY_TOKEN);

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModFluids.registerFluids();
		ModFlammableBlocks.registerFlammableBlocks();
		ModStrippableBlocks.registerStrippables();
		ModLootTableModifiers.modifyLootTables();

		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.SENTINEL, SentinelEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SENTINUM_ROOMBA, RoombaEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FLORBUS, FlorbusEntity.setAttributes());

		ModItemGroupEvents.registerAllGroupEvents();

		//ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}