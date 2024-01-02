package net.trevorskullcrafter.trevorssentinels.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.trevorskullcrafter.trevorssentinels.util.ServerState;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(AbstractBlock.class)
public abstract class BlockMixin {

    @Inject(method = "onBlockBreakStart", at = @At("HEAD"))
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player, CallbackInfo ci) {
        if(world instanceof ServerWorld){
            int requiredLevel = trevorssentinels.getBlockWorldLevelRequirement(state);
            if(requiredLevel > ServerState.getServerState(Objects.requireNonNull(world.getServer())).worldLevel){
                String tooLow = trevorssentinels.MOD_ID + ".worldLevelTooLow.";
                String key = tooLow + requiredLevel;
                if(TextUtil.translationDiffersFromKey(key) == null){ player.sendMessage(TextUtil.coloredText(key, TextUtil.decodedColorKey("color." + key)), true); }
                else { player.sendMessage(Text.translatable(tooLow + "other").formatted(Formatting.GRAY), true); }
            }
            player.addVelocity(Vec3d.fromPolar(player.getPitch(), player.getYaw()).negate());
        }
    }
}