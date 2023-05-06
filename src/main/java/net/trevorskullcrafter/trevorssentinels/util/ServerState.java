package net.trevorskullcrafter.trevorssentinels.util;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ServerState extends PersistentState {
    public int worldLevel = 1; boolean keepingTrack = true;

    @Override public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putInt("trevorssentinels:worldLevel", worldLevel);
        nbt.putBoolean("trevorssentinels:worldLevelTracking", keepingTrack);
        return nbt;
    }

    public static ServerState createFromNbt(NbtCompound tag){
        ServerState serverState = new ServerState();
        serverState.worldLevel = tag.getInt("trevorssentinels:worldLevel");
        serverState.keepingTrack = tag.getBoolean("trevorssentinels:worldLevelTracking");
        return serverState;
    }

    public static ServerState getServerState(MinecraftServer server){
        PersistentStateManager persistentStateManager = server.getWorld(World.OVERWORLD).getPersistentStateManager();
        ServerState serverState = persistentStateManager.getOrCreate(
                ServerState::createFromNbt,
                ServerState::new,
                trevorssentinels.MOD_ID);
        return serverState;
    }
}