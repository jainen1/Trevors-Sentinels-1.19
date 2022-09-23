/*
 * Decompiled with CFR 0.1.1 (FabricMC 57d88659).
 */
package net.trevorskullcrafter.trevorssentinels.item.custom;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class NuclearFireworkItem extends FireworkRocketItem {
    public static final String FIREWORKS_KEY = "Fireworks";
    public static final String EXPLOSION_KEY = "Explosion";
    public static final String EXPLOSIONS_KEY = "Explosions";
    public static final String FLIGHT_KEY = "Flight";
    public static final String TYPE_KEY = "Type";
    public static final String TRAIL_KEY = "Trail";
    public static final String FLICKER_KEY = "Flicker";
    public static final String COLORS_KEY = "Colors";
    public static final String FADE_COLORS_KEY = "FadeColors";
    public static final double field_30884 = 0.15;

    public NuclearFireworkItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient) {
            context.getPlayer().sendMessage(Text.literal("We don't do that here.")
                    .formatted(Formatting.GREEN),true);
        }
        return ActionResult.success(world.isClient);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isFallFlying()) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (!world.isClient) {
                if(itemStack.getDamage() < itemStack.getMaxDamage()-1) {
                    FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(world, itemStack, user);
                    world.spawnEntity(fireworkRocketEntity);
                    if (!user.getAbilities().creativeMode) {
                        itemStack.damage(1, user,
                                p -> p.sendToolBreakStatus(hand));
                    }
                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                }else{
                    user.sendMessage(Text.literal("Out of charges!")
                            .formatted(Formatting.DARK_GREEN),true);
                }
            }
            return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(itemStack.getDamage() <= 31){
            tooltip.add(Text.literal("\"This baby's nuclear powered!\"")
                    .formatted(Formatting.ITALIC));
            tooltip.add(
                    Text.literal("Charges remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+
                            " / " + (itemStack.getMaxDamage()-1)).formatted(Formatting.GREEN));
        }else if((itemStack.getDamage() >= 32) && (itemStack.getDamage() < itemStack.getMaxDamage()-1)){
            tooltip.add(Text.literal("\"Huh, guess I have some juice left!\"")
                    .formatted(Formatting.ITALIC));
            tooltip.add(
                    Text.literal("Charges remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+
                            " / " + (itemStack.getMaxDamage()-1)).formatted(Formatting.DARK_GREEN));
        }else{
                tooltip.add(Text.literal("\"No-one hits my neighbor but ME!\"")
                    .formatted(Formatting.ITALIC));
            tooltip.add(
                    Text.literal("Charges remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+
                            " / " + (itemStack.getMaxDamage()-1)).formatted(Formatting.DARK_GRAY));
        }
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack itemStack = new ItemStack(this);
        itemStack.getOrCreateNbt().putByte(FLIGHT_KEY, (byte)1);
        return itemStack;
    }

    public static enum Type {
        SMALL_BALL(0, "small_ball"),
        LARGE_BALL(1, "large_ball"),
        STAR(2, "star"),
        CREEPER(3, "creeper"),
        BURST(4, "burst");

        private static final Type[] TYPES;
        private final int id;
        private final String name;

        private Type(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public static Type byId(int id) {
            if (id < 0 || id >= TYPES.length) {
                return SMALL_BALL;
            }
            return TYPES[id];
        }

        static {
            TYPES = (Type[])Arrays.stream(Type.values()).sorted(Comparator.comparingInt(type -> type.id)).toArray(Type[]::new);
        }
    }
}

