package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.command.WorldLevelCommand;
import net.trevorskullcrafter.trevorssentinels.item.BetaItems;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.LensItem;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import java.util.Objects;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModRegistries {
    public static final Identifier yggdrasil = new Identifier(trevorssentinels.MOD_ID, "yggdrasil");
    public static final Identifier charred = new Identifier(trevorssentinels.MOD_ID, "charred");
    public static final Identifier midas = new Identifier(trevorssentinels.MOD_ID, "midas");
    public static final Identifier viridescent = new Identifier(trevorssentinels.MOD_ID, "viridescent");
    public static final Identifier cerulii = new Identifier(trevorssentinels.MOD_ID, "cerulii");
    public static final Identifier steel = new Identifier(trevorssentinels.MOD_ID, "steel");
    public static final Identifier holographic_blue = new Identifier(trevorssentinels.MOD_ID, "holographic_blue");
    public static final Identifier holographic_red = new Identifier(trevorssentinels.MOD_ID, "holographic_red");

    public static final BlockSetType YGGDRASIL_SET = BlockSetTypeBuilder.copyOf(BlockSetType.CRIMSON).build(yggdrasil);
    public static final BlockSetType CHARRED_SET = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(charred);
    public static final BlockSetType MIDAS_SET = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(midas);
    public static final BlockSetType VIRIDESCENT_SET = BlockSetTypeBuilder.copyOf(BlockSetType.CHERRY).build(viridescent);
    public static final BlockSetType CERULII_SET = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(cerulii);
    public static final BlockSetType STEEL_SET = BlockSetTypeBuilder.copyOf(BlockSetType.IRON).soundGroup(ModSounds.STEEL_SOUNDS).build(steel);
    public static final BlockSetType HOLOGRAPHIC_BLUE_SET = BlockSetTypeBuilder.copyOf(STEEL_SET).build(holographic_blue);
    public static final BlockSetType HOLOGRAPHIC_RED_SET = BlockSetTypeBuilder.copyOf(STEEL_SET).build(holographic_red);

    public static final WoodType YGGDRASIL_WOOD = WoodTypeBuilder.copyOf(WoodType.CRIMSON).build(yggdrasil, YGGDRASIL_SET);
    public static final WoodType CHARRED_WOOD = WoodTypeBuilder.copyOf(WoodType.OAK).build(charred, CHARRED_SET);
    public static final WoodType MIDAS_WOOD = WoodTypeBuilder.copyOf(WoodType.OAK).build(midas, MIDAS_SET);
    public static final WoodType VIRIDESCENT_WOOD = WoodTypeBuilder.copyOf(WoodType.CHERRY).build(viridescent, VIRIDESCENT_SET);
    public static final WoodType CERULII_WOOD = WoodTypeBuilder.copyOf(WoodType.OAK).build(cerulii, CERULII_SET);
    public static final WoodType STEEL_WOOD = WoodTypeBuilder.copyOf(WoodType.ACACIA).hangingSignSoundGroup(ModSounds.STEEL_SOUNDS).build(steel, STEEL_SET);
    public static final WoodType HOLOGRAPHIC_BLUE_WOOD = WoodTypeBuilder.copyOf(STEEL_WOOD).build(holographic_blue, HOLOGRAPHIC_BLUE_SET);
    public static final WoodType HOLOGRAPHIC_RED_WOOD = WoodTypeBuilder.copyOf(STEEL_WOOD).build(holographic_red, HOLOGRAPHIC_RED_SET);

    public static void registerModelPredicates() {
        trevorssentinels.LOGGER.info("Registering model predicates... ("+ MOD_ID + ")");
        ModelPredicateProviderRegistry.register(BetaItems.PAPPYM_BLADE, new Identifier(trevorssentinels.MOD_ID, "bad"), (stack, world, entity, seed) -> {
            if (StyleUtil.getStyle(stack) == 1 || StyleUtil.getStyle(stack) == 3) return 0.2f; return 0f;});
        ModelPredicateProviderRegistry.register(ModItems.GALINITE_LENS, new Identifier(trevorssentinels.MOD_ID, "on"), (stack, world, entity, seed) -> {
            if (stack.getSubNbt("trevorssentinels:lens_learned") == null) return 0f;
            else{ if(Objects.requireNonNull(stack.getSubNbt("trevorssentinels:lens_learned")).getDouble("trevorssentinels:lens_version") == LensItem.currentVersion)
                return 0.5f; return 1f;}
        });
        ModelPredicateProviderRegistry.register(BetaItems.DISTANCE_TRACKER, new Identifier(trevorssentinels.MOD_ID, "model"), (stack, world, entity, seed) -> {
            if(stack.getSubNbt("trevorssentinels:model") == null) return 0.0f;
            else{
                switch (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:model")).getInt("trevorssentinels:modelNum")){
                    case 1 -> { return 0.5f; }
                    case 2 -> { return 0.7f; }
                    case 3 -> { return 1.0f; }
                    default -> { return 0.0f; }}
            }
        });
    }

    public static void registerFlammableBlocks(){
        trevorssentinels.LOGGER.info("Committing arson... ("+ MOD_ID + ")");
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.YGGDRASIL_LOG, 5, 5);
        registry.add(ModBlocks.YGGDRASIL_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_YGGDRASIL_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_YGGDRASIL_WOOD, 5, 5);
        registry.add(ModBlocks.YGGDRASIL_PLANKS, 5, 20);
        registry.add(ModBlocks.YGGDRASIL_LEAVES, 30, 60);


        registry.add(ModBlocks.CHARRED_LOG, 2, 2);
        registry.add(ModBlocks.CHARRED_WOOD, 2, 2);
        registry.add(ModBlocks.STRIPPED_CHARRED_LOG, 2, 2);
        registry.add(ModBlocks.STRIPPED_CHARRED_WOOD, 2, 2);
        registry.add(ModBlocks.CHARRED_PLANKS, 2, 8);


        registry.add(ModBlocks.MIDAS_LOG, 3, 3);
        registry.add(ModBlocks.MIDAS_WOOD, 3, 3);
        registry.add(ModBlocks.STRIPPED_MIDAS_LOG, 3, 3);
        registry.add(ModBlocks.STRIPPED_MIDAS_WOOD, 3, 3);
        registry.add(ModBlocks.MIDAS_PLANKS, 3, 12);
        registry.add(ModBlocks.MIDAS_LEAVES, 18, 40);


        registry.add(ModBlocks.VIRIDESCENT_LOG, 5, 5);
        registry.add(ModBlocks.VIRIDESCENT_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_VIRIDESCENT_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_VIRIDESCENT_WOOD, 5, 5);
        registry.add(ModBlocks.VIRIDESCENT_PLANKS, 5, 20);
        registry.add(ModBlocks.VIRIDESCENT_LEAVES, 30, 60);


        registry.add(ModBlocks.CERULII_LOG, 5, 5);
        registry.add(ModBlocks.CERULII_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_CERULII_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_CERULII_WOOD, 5, 5);
        registry.add(ModBlocks.CERULII_PLANKS, 5, 20);
        registry.add(ModBlocks.CERULII_LEAVES, 30, 60);
    }

    public static void registerStrippables(){
        trevorssentinels.LOGGER.info("Stripping logs... ("+ MOD_ID + ")");
        StrippableBlockRegistry.register(ModBlocks.YGGDRASIL_LOG, ModBlocks.STRIPPED_YGGDRASIL_LOG);
        StrippableBlockRegistry.register(ModBlocks.YGGDRASIL_WOOD, ModBlocks.STRIPPED_YGGDRASIL_WOOD);

        StrippableBlockRegistry.register(ModBlocks.CHARRED_LOG, ModBlocks.STRIPPED_CHARRED_LOG);
        StrippableBlockRegistry.register(ModBlocks.CHARRED_WOOD, ModBlocks.STRIPPED_CHARRED_WOOD);

        StrippableBlockRegistry.register(ModBlocks.MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_LOG);
        StrippableBlockRegistry.register(ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_WOOD);

        StrippableBlockRegistry.register(ModBlocks.VIRIDESCENT_LOG, ModBlocks.STRIPPED_VIRIDESCENT_LOG);
        StrippableBlockRegistry.register(ModBlocks.VIRIDESCENT_WOOD, ModBlocks.STRIPPED_VIRIDESCENT_WOOD);

        StrippableBlockRegistry.register(ModBlocks.CERULII_LOG, ModBlocks.STRIPPED_CERULII_LOG);
        StrippableBlockRegistry.register(ModBlocks.CERULII_WOOD, ModBlocks.STRIPPED_CERULII_WOOD);
    }

    public static void registerFuels(){
        trevorssentinels.LOGGER.info("Registering fuels... ("+ MOD_ID + ")");
        FuelRegistry.INSTANCE.add(ModItems.FEATHERCORN, 200);
    }

    public static void registerWorldLevelState(){
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            ServerState serverState = ServerState.getServerState(Objects.requireNonNull(entity.getServer(), "Server is null"));
            int originalLevel = serverState.worldLevel;

            if(entity instanceof WitherEntity witherEntity){
                world.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 8f, false, World.ExplosionSourceType.MOB);
                WitherSkeletonEntity leftovers = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
                leftovers.setPosition(witherEntity.getPos());
                leftovers.setCustomName(TextUtil.coloredText("Cerberus, Darkness Incarnate", TextUtil.DARK_PURPLE));
                witherEntity.getWorld().spawnEntity(leftovers);
                for (PlayerEntity player:world.getPlayers()) {
                    player.sendMessage(Text.literal(witherEntity.getName().getString() + " grows restless!").formatted(Formatting.RED));
                }
                if(serverState.worldLevel < 2) {
                    serverState.worldLevel = 2;
                    serverState.markDirty();
                }
            }

            if(serverState.worldLevel != originalLevel){ for (PlayerEntity player:world.getPlayers()) {
                player.sendMessage(Text.empty().append(Text.literal((serverState.worldLevel > originalLevel)? "World level upgraded to " : "World level reverted to "))
                        .append(Text.literal(String.valueOf(serverState.worldLevel)).formatted(Formatting.GOLD)).append(Text.literal(" from "))
                        .append(Text.literal(String.valueOf(originalLevel)).formatted(Formatting.RED)).append(Text.literal("!")));
            }}
        });

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            server.getCommandManager();
            handler.player.sendMessage(Text.literal("Welcome back, " + handler.player.getEntityName()+"!").formatted(Formatting.GREEN));
            //handler.player.sendMessage(Text.translatable(new Identifier(MOD_ID, "join.");
        });
    }

    public static void registerCommands(){ CommandRegistrationCallback.EVENT.register(WorldLevelCommand::register); }
}