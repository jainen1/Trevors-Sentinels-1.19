package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.custom.ShardEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SentinumChainsawItem extends ModAxeItem {
    public SentinumChainsawItem(String color, ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(color, material, attackDamage, attackSpeed, settings);
        doDashes = true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.BLOCKS, 1.0F, 1.0F);

            ShardEntity shardEntity = new ShardEntity(world, user);
            shardEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.0f, 1.0f);
            world.spawnEntity(shardEntity);
            itemStack.damage(2, user, p -> p.sendToolBreakStatus(hand));
            user.getItemCooldownManager().set(this,10);
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Right click to launch").formatted(Formatting.RED));
        tooltip.add(Text.literal("shards at enemies!").formatted(Formatting.RED));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}