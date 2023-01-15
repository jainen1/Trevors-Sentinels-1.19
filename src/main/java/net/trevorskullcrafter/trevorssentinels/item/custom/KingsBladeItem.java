package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KingsBladeItem extends SwordItem {
    public KingsBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            if(!Screen.hasAltDown()){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5, 255,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,5,3,false,false,false));
                world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 2.0F, getRandom());
                user.sendMessage(Text.literal("Parry!").formatted(Formatting.GRAY),true);
                user.getItemCooldownManager().set(this, 100);
            }else {

            }
            return TypedActionResult.success(itemStack);
        }
        return super.use(world, user, hand);
    }

    public float getRandom(){
        return Random.createLocal().nextFloat();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    boolean iceShield(ItemStack stack){
        return stack.getSubNbt("trevorssentinels:runes").getString("trevorssentinels:rune1").equals("ᚾ") &&
                stack.getSubNbt("trevorssentinels:runes").getString("trevorssentinels:rune2").equals("ᛁ") &&
                stack.getSubNbt("trevorssentinels:runes").getString("trevorssentinels:rune3").equals("ᛉ");
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.getSubNbt("trevorssentinels:runes") != null){
            tooltip.add(Text.literal("" + stack.getSubNbt("trevorssentinels:runes").getString("trevorssentinels:rune1") + " " +
                    stack.getSubNbt("trevorssentinels:runes").getString("trevorssentinels:rune2") + " " +
                    stack.getSubNbt("trevorssentinels:runes").getString("trevorssentinels:rune3").formatted(Formatting.DARK_RED)));
            if(iceShield(stack)){
                tooltip.add(Text.literal("Ice Shield"));
                tooltip.add(Text.literal("Right click to parry!").formatted(Formatting.AQUA));
            }else{
                tooltip.add(Text.literal("NaN"));
            }
        }else{
            NbtCompound nbtData = new NbtCompound();
            nbtData.putString("trevorssentinels:rune1", "ᚾ");
            nbtData.putString("trevorssentinels:rune2", "ᛁ");
            nbtData.putString("trevorssentinels:rune3", "ᛉ");
            stack.setSubNbt("trevorssentinels:runes", nbtData);
        }
        tooltip.add(Text.translatable("pillar.trevorssentinels.purity").formatted(Formatting.ITALIC, Formatting.WHITE));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
