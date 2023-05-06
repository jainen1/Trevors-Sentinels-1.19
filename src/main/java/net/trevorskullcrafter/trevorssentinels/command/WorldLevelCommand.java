package net.trevorskullcrafter.trevorssentinels.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.trevorskullcrafter.trevorssentinels.util.ServerState;

public class WorldLevelCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess access, CommandManager.RegistrationEnvironment env) {
        dispatcher.register((CommandManager.literal("trevorssentinels:worldlevel"))
                .then(CommandManager.literal("get").requires((source) -> source.hasPermissionLevel(0)).executes(WorldLevelCommand::get))
                .requires((source) -> source.hasPermissionLevel(4))
                .then(CommandManager.literal("set").then(CommandManager.argument("level", IntegerArgumentType.integer(1)))
                        .executes(context -> set(context, IntegerArgumentType.getInteger(context, "level"))))
                .then(CommandManager.literal("add").then(CommandManager.argument("level", IntegerArgumentType.integer(0)))
                        .executes(context -> add(context, IntegerArgumentType.getInteger(context, "level"))))
                .then(CommandManager.literal("sub").then(CommandManager.argument("level", IntegerArgumentType.integer(0)))
                        .executes(context -> sub(context, IntegerArgumentType.getInteger(context, "level")))));
    }

    private static int get(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(Text.empty().append(Text.literal("The current world level is "))
                .append(Text.literal(String.valueOf(ServerState.getServerState(context.getSource().getServer()).worldLevel))
                        .formatted(Formatting.GOLD)), false);
        return 1;
    }

    private static int set(CommandContext<ServerCommandSource> context, int level) {
        int currentLevel = ServerState.getServerState(context.getSource().getServer()).worldLevel;
        if(currentLevel != level) add(context, level - currentLevel);
        return 1;
    }

    private static int add(CommandContext<ServerCommandSource> context, int level) {
        ServerState serverState = ServerState.getServerState(context.getSource().getServer()); int originalLevel = serverState.worldLevel;
        if(level > 0) {
            serverState.worldLevel += level; serverState.markDirty();
            context.getSource().sendFeedback(Text.empty().append(Text.literal("World level upgraded to "))
                    .append(Text.literal(String.valueOf(serverState.worldLevel)).formatted(Formatting.GOLD))
                    .append(Text.literal(" from ")).append(Text.literal(String.valueOf(originalLevel)).formatted(Formatting.RED))
                    .append(Text.literal("!")), false);
        } else sub(context, Math.abs(level));
        return 1;
    }

    private static int sub(CommandContext<ServerCommandSource> context, int level) {
        ServerState serverState = ServerState.getServerState(context.getSource().getServer()); int originalLevel = serverState.worldLevel;
        if(level > 0) {
            serverState.worldLevel -= level;
            if(serverState.worldLevel < 0) serverState.worldLevel = 1;
            serverState.markDirty();
            context.getSource().sendFeedback(Text.empty().append(Text.literal("World level reverted to "))
                    .append(Text.literal(String.valueOf(serverState.worldLevel)).formatted(Formatting.GOLD))
                    .append(Text.literal(" from ")).append(Text.literal(String.valueOf(originalLevel)).formatted(Formatting.RED))
                    .append(Text.literal("!")), false);
        } else add(context, Math.abs(level));
        return 1;
    }
}