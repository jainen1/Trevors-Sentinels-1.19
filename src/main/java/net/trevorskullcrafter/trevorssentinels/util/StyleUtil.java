package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.event.KeyInputHandler;

import java.util.Objects;

import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.*;

public class StyleUtil {
    public static final Text style = TextUtil.coloredText("tooltip.trevorssentinels.style", GOLD);
    public static final Text mode = TextUtil.coloredText("tooltip.trevorssentinels.mode", SENTINEL_AQUA);

    @Environment(EnvType.CLIENT) public static Text switchText(World world, int mode){
        if (world instanceof ClientWorld) return Text.literal(Text.keybind(KeyInputHandler.styleSwitch.getTranslationKey()).getString().toUpperCase())
                .formatted(Formatting.YELLOW).append(Text.translatable("tooltip.trevorssentinels.style_switch."+ mode).formatted(Formatting.DARK_GRAY));
        return Text.literal("ERROR LOADING KEYBIND").formatted(Formatting.RED);
    }

    public static Text currentStyle(ItemStack stack) { return Text.translatable("style."+stack.getTranslationKey()+"."+StyleUtil.getStyle(stack)); }

    public static int getStyle(ItemStack stack){
        if(stack.getSubNbt("trevorssentinels:style") == null){ setStyle(stack, 1); }
        return Objects.requireNonNull(stack.getSubNbt("trevorssentinels:style")).getInt("trevorssentinels:styleInt");
    }

    public static void setStyle(ItemStack stack, int newStyle){
        NbtCompound style = new NbtCompound();
        style.putInt("trevorssentinels:styleInt", newStyle);
        stack.setSubNbt("trevorssentinels:style", style);
    }

    public interface StyleSwitcher {
        default void onStyleSwitch(ServerPlayerEntity player){
            player.getWorld().playSoundFromEntity(null, player, SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, SoundCategory.BLOCKS, 1.0F,
                    (StyleUtil.getStyle(player.getMainHandStack()) & 2) == 0? 1.0F : 1.2F);
            player.sendMessage(Text.empty().append(StyleUtil.style).append(StyleUtil.currentStyle(player.getMainHandStack()))
                    .formatted(getStyleSwitchFormatting(player.getMainHandStack())), true);
        }

        default int getStyles() { return 2; }
        default Formatting getStyleSwitchFormatting(ItemStack stack){ return Formatting.RESET; }
    }
}