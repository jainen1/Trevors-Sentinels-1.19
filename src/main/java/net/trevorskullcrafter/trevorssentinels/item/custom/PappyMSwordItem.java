package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.util.ColoredTextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PappyMSwordItem extends ModSwordItem {
    public PappyMSwordItem(String color, ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(color, toolMaterial, attackDamage, attackSpeed, settings);
        doDashes = true;
    }

    private final Text goodName = ColoredTextUtil.getColoredText("item.trevorssentinels.pappym_blade", "4_#55FF55_#FFFF55");
    private final Text badName = ColoredTextUtil.getColoredText("item.trevorssentinels.pappym_blade2", "4_#FF5555_#FFFF55");

    @Override
    public Text getName(ItemStack stack) {
        if(!notNull(stack) || stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 1 || stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 3){
            return badName;
        }else{
            return goodName;
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            if (notNull(itemStack)) {
                if (Screen.hasControlDown()) {
                    if (itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 1) {
                        switchStyle(itemStack, 2, 0);
                        user.sendMessage(Text.empty().append(ColoredTextUtil.styleText).append(Text.literal("Paladin").formatted(Formatting.GREEN)), true);
                        world.playSound(null, user.getX(), user.getY(),
                                user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                                SoundCategory.BLOCKS, 1.0F, 1.1F);
                    }else if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 2) {
                        switchStyle(itemStack, 3, 0);
                        user.sendMessage(Text.empty().append(ColoredTextUtil.styleText).append(Text.literal("Predator").formatted(Formatting.RED)), true);
                        world.playSound(null, user.getX(), user.getY(),
                                user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                                SoundCategory.BLOCKS, 1.0F, 1.0F);
                    }else if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 3) {
                        switchStyle(itemStack, 4, 0);
                        user.sendMessage(Text.empty().append(ColoredTextUtil.styleText).append(Text.literal("Guardian").formatted(Formatting.GREEN)), true);
                        world.playSound(null, user.getX(), user.getY(),
                                user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                                SoundCategory.BLOCKS, 1.0F, 0.9F);
                    } else {
                        switchStyle(itemStack, 1, 0);
                        user.sendMessage(Text.empty().append(ColoredTextUtil.styleText).append(Text.literal("Trickster").formatted(Formatting.RED)), true);
                        world.playSound(null, user.getX(), user.getY(),
                                user.getZ(), SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                                SoundCategory.BLOCKS, 1.0F, 1.2F);
                    }
                } else {
                    if (itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 1) {
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 1, false, false, false));
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2, false, false, false));
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 2, false, false, false));
                        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.BLOCKS, 2.0F, 5.0F);
                        user.sendMessage(Text.literal("Energized!").formatted(Formatting.GREEN), true);
                        user.getItemCooldownManager().set(this, 200);
                    }else if (itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 4){
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5, 255, false, false, false));
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 3, false, false, false));
                        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 2.0F, getRandom());
                        user.sendMessage(Text.literal("Parry!").formatted(Formatting.GRAY), true);
                        user.getItemCooldownManager().set(this, 100);
                    }
                }
                return TypedActionResult.success(itemStack);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity && !world.isClient && selected && notNull(stack)){
            if (stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 1) {
                ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 0, false, false, false));

            } else if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 2){
                ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, 0, false, false, false));
                if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 6){
                    ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1, 4, false, true, false));
                    if(world.getTime() % 2 == 0){
                        ((PlayerEntity) entity).sendMessage(Text.literal("◆ ◆ ◆ ◆ ◆ ◆").formatted(Formatting.AQUA), true);
                    }else{
                        ((PlayerEntity) entity).sendMessage(Text.literal("◆ ◆ ◆ ◆ ◆ ◆").formatted(Formatting.DARK_AQUA), true);
                    }
                }
            }else if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 3){
                ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1, 2, false, false, false));

            }else{
                ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 0, false, false, false));
            }
            stack.setDamage(0);
        }
    }

    public float getRandom(){
        return Random.createLocal().nextFloat();
    }

    public boolean notNull(ItemStack stack){
        if(stack.getSubNbt("trevorssentinels:style") != null){
            return true;
        }else{
            switchStyle(stack, 4, 0);
            return true;
        }
    }

    public void switchStyle(ItemStack stack, int style, int paladinCharge){
        NbtCompound nbtData = new NbtCompound();
        nbtData.putInt("trevorssentinels:styleInt", style);
        nbtData.putInt("trevorssentinels:paladinCharge", paladinCharge);
        stack.setSubNbt("trevorssentinels:style", nbtData);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(notNull(stack)){
            if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 2){
                if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 6){
                    ((PlayerEntity) attacker).sendMessage(Text.literal("◇ ◇ ◇ ◇ ◇ ◇").formatted(Formatting.GRAY), true);
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 77, 2, false, false, false));
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 77, 1, false, false, false));
                    switchStyle(stack, 2, 0);
                }else if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 5){
                    switchStyle(stack, 2, 6);
                }else if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 4){
                    ((PlayerEntity) attacker).sendMessage(Text.literal("◆ ◆ ◆ ◆ ◆ ◇").formatted(Formatting.GREEN), true);
                    switchStyle(stack, 2, 5);
                }else if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 3){
                    ((PlayerEntity) attacker).sendMessage(Text.literal("◆ ◆ ◆ ◆ ◇ ◇").formatted(Formatting.GREEN), true);
                    switchStyle(stack, 2, 4);
                }else if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 2){
                    ((PlayerEntity) attacker).sendMessage(Text.literal("◆ ◆ ◆ ◇ ◇ ◇").formatted(Formatting.DARK_GREEN), true);
                    switchStyle(stack, 2, 3);
                }else if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 1){
                    ((PlayerEntity) attacker).sendMessage(Text.literal("◆ ◆ ◇ ◇ ◇ ◇").formatted(Formatting.DARK_GREEN), true);
                    switchStyle(stack, 2, 2);
                }else{
                    ((PlayerEntity) attacker).sendMessage(Text.literal("◆ ◇ ◇ ◇ ◇ ◇").formatted(Formatting.DARK_GREEN), true);
                    switchStyle(stack, 2, 1);
                }
            }else if(stack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 3){
                attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1, 1, false, false, false));
            }
        }
        return true;
    }

    @Override
    public boolean hasGlint(ItemStack itemStack){
        return notNull(itemStack) && itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 6;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(notNull(itemStack)) {
            if (itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 1) {
                tooltip.add(Text.empty().append(ColoredTextUtil.styleText).append(Text.literal("Trickster").formatted(Formatting.RED)));
                tooltip.add(Text.literal("You feel more agile than usual.").formatted(Formatting.DARK_RED));
                tooltip.add(Text.literal("Right click to become energized!").formatted(Formatting.GRAY));

            } else if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 2){
                tooltip.add(Text.empty().append(ColoredTextUtil.styleText).append(Text.literal("Paladin").formatted(Formatting.GREEN)));
                tooltip.add(Text.literal("You feel heavier than usual.").formatted(Formatting.DARK_GREEN));
                tooltip.add(Text.literal("Every seventh strike is incredibly powerful.").formatted(Formatting.GRAY));

                if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 6){
                    if((world.getTime() & 2) == 0){
                        tooltip.add(Text.literal("◆ ◆ ◆ ◆ ◆ ◆").formatted(Formatting.AQUA));
                    }else{
                        tooltip.add(Text.literal("◆ ◆ ◆ ◆ ◆ ◆").formatted(Formatting.DARK_AQUA));
                    }
                }else if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 5){
                    tooltip.add(Text.literal("◆ ◆ ◆ ◆ ◆ ◇").formatted(Formatting.GREEN));
                }else if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 4){
                    tooltip.add(Text.literal("◆ ◆ ◆ ◆ ◇ ◇").formatted(Formatting.GREEN));
                }else if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 3){
                    tooltip.add(Text.literal("◆ ◆ ◆ ◇ ◇ ◇").formatted(Formatting.DARK_GREEN));
                }else if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 2){
                    tooltip.add(Text.literal("◆ ◆ ◇ ◇ ◇ ◇").formatted(Formatting.DARK_GREEN));
                }else if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:paladinCharge") == 1){
                    tooltip.add(Text.literal("◆ ◇ ◇ ◇ ◇ ◇").formatted(Formatting.DARK_GREEN));
                }else{
                    tooltip.add(Text.literal("◇ ◇ ◇ ◇ ◇ ◇").formatted(Formatting.GRAY));
                }
            }else if(itemStack.getSubNbt("trevorssentinels:style").getInt("trevorssentinels:styleInt") == 3){
                tooltip.add(Text.empty().append(ColoredTextUtil.styleText).append(Text.literal("Predator").formatted(Formatting.RED)));
                tooltip.add(Text.literal("You feel hungrier than usual.").formatted(Formatting.DARK_RED));
                tooltip.add(Text.literal("Striking enemies satiates you.").formatted(Formatting.GRAY));

            }else{
                tooltip.add(Text.empty().append(ColoredTextUtil.styleText).append(Text.literal("Guardian").formatted(Formatting.GREEN)));
                tooltip.add(Text.literal("You feel more resilient than usual.").formatted(Formatting.DARK_GREEN));
                tooltip.add(Text.literal("Right click to parry!").formatted(Formatting.GRAY));

            }
        }
        tooltip.add(Text.translatable("tooltip.trevorssentinels.style_switch").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.translatable("pillar.trevorssentinels.balance").formatted(Formatting.DARK_GREEN, Formatting.ITALIC));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}