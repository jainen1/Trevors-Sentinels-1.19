package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
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
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import java.util.Objects;

import static net.trevorskullcrafter.trevorssentinels.data.EnglishLangGenerator.animPurple;
import static net.trevorskullcrafter.trevorssentinels.data.EnglishLangGenerator.getColoredText;
import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModRegistries {
    public static void registerModelPredicates() {
        trevorssentinels.LOGGER.info("Registering model predicates... ("+ MOD_ID + ")");
        ModelPredicateProviderRegistry.register(ModItems.GALINITE_HOLOPROJECTOR, new Identifier(trevorssentinels.MOD_ID, "mode"), (stack, world, entity, seed) -> {
            switch (StyleUtil.getStyle(stack)){
                case 2 -> { return 0.5f; }
                case 3 -> { return 1.0f; }
                default -> { return 0.0f; } }});
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
                    default -> { return 0.0f; } }
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


        registry.add(ModBlocks.CHARRED_OAK_LOG, 2, 2);
        registry.add(ModBlocks.CHARRED_OAK_WOOD, 2, 2);
        registry.add(ModBlocks.STRIPPED_CHARRED_OAK_LOG, 2, 2);
        registry.add(ModBlocks.STRIPPED_CHARRED_OAK_WOOD, 2, 2);

        registry.add(ModBlocks.CHARRED_OAK_PLANKS, 2, 8);


        registry.add(ModBlocks.MIDAS_LOG, 3, 3);
        registry.add(ModBlocks.MIDAS_WOOD, 3, 3);
        registry.add(ModBlocks.STRIPPED_MIDAS_LOG, 3, 3);
        registry.add(ModBlocks.STRIPPED_MIDAS_WOOD, 3, 3);

        registry.add(ModBlocks.MIDAS_PLANKS, 3, 12);
        registry.add(ModBlocks.MIDAS_LEAVES, 18, 40);


        registry.add(ModBlocks.BANANA_LOG, 5, 5);
        registry.add(ModBlocks.BANANA_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_BANANA_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_BANANA_WOOD, 5, 5);

        registry.add(ModBlocks.BANANA_PLANKS, 5, 20);
        registry.add(ModBlocks.BANANA_LEAVES, 30, 60);


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

        StrippableBlockRegistry.register(ModBlocks.CHARRED_OAK_LOG, ModBlocks.STRIPPED_CHARRED_OAK_LOG);
        StrippableBlockRegistry.register(ModBlocks.CHARRED_OAK_WOOD, ModBlocks.STRIPPED_CHARRED_OAK_WOOD);

        StrippableBlockRegistry.register(ModBlocks.MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_LOG);
        StrippableBlockRegistry.register(ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_WOOD);

        StrippableBlockRegistry.register(ModBlocks.BANANA_LOG, ModBlocks.STRIPPED_BANANA_LOG);
        StrippableBlockRegistry.register(ModBlocks.BANANA_WOOD, ModBlocks.STRIPPED_BANANA_WOOD);

        StrippableBlockRegistry.register(ModBlocks.CERULII_LOG, ModBlocks.STRIPPED_CERULII_LOG);
        StrippableBlockRegistry.register(ModBlocks.CERULII_WOOD, ModBlocks.STRIPPED_CERULII_WOOD);
    }

    public static void registerFuels(){
        trevorssentinels.LOGGER.info("Registering fuels... ("+ MOD_ID + ")");
        FuelRegistry.INSTANCE.add(ModItems.FEATHERCORN, 200);
    }

    public static void registerWorldLevelState(){
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
            ServerState serverState = ServerState.getServerState(Objects.requireNonNull(entity.getServer(), "Server is null"));
            int originalLevel = serverState.worldLevel;
            World world = entity.getWorld();

            if(entity instanceof WitherEntity witherEntity){
                world.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 8f, false, World.ExplosionSourceType.MOB);
                WitherSkeletonEntity leftovers = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
                leftovers.setPosition(witherEntity.getPos());
                leftovers.setCustomName(getColoredText("Cerberus, Darkness Incarnate", animPurple));
                witherEntity.getWorld().spawnEntity(leftovers);
                for (PlayerEntity player:world.getPlayers()) {
                    player.sendMessage(Text.literal(witherEntity.getName().getString() + " grows restless!").formatted(Formatting.RED));
                }
                if(serverState.worldLevel < 2) {
                    serverState.worldLevel = 2;
                    serverState.markDirty();
                }
            }

            if(serverState.worldLevel > originalLevel){
                for (PlayerEntity player:world.getPlayers()) {
                    player.sendMessage(Text.empty().append(Text.literal("World level upgraded to "))
                            .append(Text.literal(String.valueOf(serverState.worldLevel)).formatted(Formatting.GOLD))
                            .append(Text.literal(" from ")).append(Text.literal(String.valueOf(originalLevel)).formatted(Formatting.RED))
                            .append(Text.literal("!")));
                }
            }else if(serverState.worldLevel < originalLevel){
                for (PlayerEntity player:world.getPlayers()) {
                    player.sendMessage(Text.empty().append(Text.literal("World level reverted to "))
                            .append(Text.literal(String.valueOf(serverState.worldLevel)).formatted(Formatting.GOLD))
                            .append(Text.literal(" from ")).append(Text.literal(String.valueOf(originalLevel)).formatted(Formatting.RED))
                            .append(Text.literal("!")));
                }
            }
        });

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            server.getCommandManager();
        });
    }

    public static void registerCommands(){
        CommandRegistrationCallback.EVENT.register(WorldLevelCommand::register);
    }
}