package net.trevorskullcrafter.trevorssentinels.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.item.BetaItems;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.LensItem;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import java.util.Objects;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        trevorssentinels.LOGGER.info("Registering model predicates... ("+ MOD_ID + ")");
        ModelPredicateProviderRegistry.register(ModItems.GALINITE_HOLOPROJECTOR, new Identifier(trevorssentinels.MOD_ID, "mode"), (stack, world, entity, seed) -> {
            if (stack.getSubNbt("trevorssentinels:holoprojector") != null) {
                if (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:holoprojector")).getInt("trevorssentinels:holoMode") == 2) return 0.5f;
                else if (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:holoprojector")).getInt("trevorssentinels:holoMode") == 3) return 1.0f;
            } return 0.0f;});
        ModelPredicateProviderRegistry.register(BetaItems.PAPPYM_BLADE, new Identifier(trevorssentinels.MOD_ID, "bad"), (stack, world, entity, seed) -> {
            if (stack.getSubNbt("trevorssentinels:style") != null) {
                if (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:style")).getInt("trevorssentinels:styleInt") == 1 ||
                        Objects.requireNonNull(stack.getSubNbt("trevorssentinels:style")).getInt("trevorssentinels:styleInt") == 3) return 0.2f;
            } return 0f;});
        ModelPredicateProviderRegistry.register(ModItems.GALINITE_LENS, new Identifier(trevorssentinels.MOD_ID, "on"), (stack, world, entity, seed) -> {
            if (stack.getSubNbt("trevorssentinels:lens_learned") == null) return 0f;
            else{
                if(Objects.requireNonNull(stack.getSubNbt("trevorssentinels:lens_learned")).getDouble("trevorssentinels:lens_version")
                        == LensItem.currentVersion) return 0.5f; else return 1f;}});
        ModelPredicateProviderRegistry.register(BetaItems.DISTANCE_TRACKER, new Identifier(trevorssentinels.MOD_ID, "model"), (stack, world, entity, seed) -> {
            if (stack.getSubNbt("trevorssentinels:model") != null &&
                    Objects.requireNonNull(stack.getSubNbt("trevorssentinels:model")).getInt("trevorssentinels:modelNum") != 0) {
                if (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:model")).getInt("trevorssentinels:modelNum") == 1) return 0.5f;
                else if (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:model")).getInt("trevorssentinels:modelNum") == 2) return 0.7f;
                else if (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:model")).getInt("trevorssentinels:modelNum") == 3) return 1.0f;
            } return 0.0f;});
    }
}