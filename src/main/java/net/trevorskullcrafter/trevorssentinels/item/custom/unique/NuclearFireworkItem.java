package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import java.util.List;
import java.util.Objects;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.*;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class NuclearFireworkItem extends FireworkRocketItem {
    public NuclearFireworkItem(Settings settings) { super(settings);}

    @Override public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient) Objects.requireNonNull(context.getPlayer()).sendMessage(Text.literal("We don't do that here.")
                .formatted(Formatting.GREEN),true);
        return ActionResult.success(world.isClient);
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isFallFlying()) { ItemStack itemStack = user.getStackInHand(hand);
            if (!world.isClient) { if(itemStack.getDamage() < itemStack.getMaxDamage()-1) {
                FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(world, itemStack, user);
                world.spawnEntity(fireworkRocketEntity);
                if (!user.getAbilities().creativeMode) itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
                user.incrementStat(Stats.USED.getOrCreateStat(this));
            } else user.sendMessage(Text.literal("Out of charges!").formatted(Formatting.DARK_GREEN),true);
            } return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
        } return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Charges remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+ " / " + (itemStack.getMaxDamage()-1))
                .formatted(itemStack.getDamage() <= 31? Formatting.GREEN: ((itemStack.getDamage() >= 32 && (itemStack.getDamage() < itemStack.getMaxDamage()-1))?
                        Formatting.DARK_GREEN: Formatting.DARK_GRAY)));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}