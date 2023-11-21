package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class LensItem extends Item {
    public static double currentVersion; int databaseSize;
    public LensItem(Settings settings, double curVe, int datSi) { super(settings); LensItem.currentVersion = curVe; this.databaseSize = datSi; }

    @Override public ActionResult useOnBlock(ItemUsageContext context) {
        //Server: giving/removing items
        //Client: rendering, particle effects, music/sound
        World world = context.getWorld(); Block block = world.getBlockState(context.getBlockPos()).getBlock();
        //if(findBlockInTags(block, BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN));
        if (!world.isClient() && context.getHand() == Hand.MAIN_HAND) {
            if(block == ModBlocks.HARD_LIGHT) displayEntry(context, 0);
            if(block == ModBlocks.STEEL_BLOCK || block == ModBlocks.CAUTION_STEEL_BLOCK || block == ModBlocks.RUSTED_STEEL_BLOCK ||
                    block == ModBlocks.STAINLESS_STEEL_BLOCK || block == ModBlocks.STEEL_LAMP_BLOCK || block == ModBlocks.STEEL_FAN ||
                    block == ModBlocks.BATTERY || block == ModBlocks.FUSEBOX || block == ModBlocks.SUPERFORGE || block == ModBlocks.NUCLEAR_CHARGE) displayEntry(context, 1);
            if(block == ModBlocks.GALINITE_BLOCK || block == ModBlocks.GALINITE_PILLAR || block == ModBlocks.CHISELED_GALINITE_BLOCK){ displayEntry(context, 2); displayEntry(context, 9); }
            if(block == ModBlocks.NUCLEAR_ORE || block == ModBlocks.NUCLEAR_BLOCK || block == ModBlocks.NUCLEAR_CHARGE || block == ModBlocks.SUPERFORGE) displayEntry(context, 3);
            if(block == ModBlocks.LIGHT_CHAMBER_BLOCK || block == ModBlocks.DARK_CHAMBER_BLOCK) displayEntry(context, 4);
            if(block == ModBlocks.BLUE_AGILITY_BLOCK || block == ModBlocks.ORANGE_AGILITY_BLOCK)  displayEntry(context, 4); displayEntry(context, 5);
            if(block.getDefaultState().isIn(BlockTags.FLOWERS) || block.getDefaultState().isIn(BlockTags.FLOWER_POTS) || block.getDefaultState().isIn(BlockTags.LEAVES) ||
                    block.getDefaultState().isIn(BlockTags.LOGS_THAT_BURN) || block.getDefaultState().isIn(BlockTags.SAPLINGS) || block == Blocks.GRASS_BLOCK || block == Blocks.GRASS ||
                    block == Blocks.TALL_GRASS || block == Blocks.MOSS_BLOCK || block == Blocks.BROWN_MUSHROOM_BLOCK || block == Blocks.BROWN_MUSHROOM ||
                    block == Blocks.RED_MUSHROOM_BLOCK || block == Blocks.RED_MUSHROOM || block == Blocks.ATTACHED_MELON_STEM || block == Blocks.ATTACHED_PUMPKIN_STEM ||
                    block == Blocks.AZALEA || block == Blocks.BAMBOO || block == Blocks.BAMBOO_SAPLING || block == Blocks.POTTED_BAMBOO || block == Blocks.BIG_DRIPLEAF ||
                    block == Blocks.BIG_DRIPLEAF_STEM || block == Blocks.POTTED_BIRCH_SAPLING || block == Blocks.POTTED_ACACIA_SAPLING || block == Blocks.CACTUS ||
                    block == Blocks.CAVE_VINES || block == Blocks.CAVE_VINES_PLANT || block == Blocks.COCOA || block == Blocks.POTTED_DARK_OAK_SAPLING ||
                    block == Blocks.DEAD_BUSH || block == Blocks.FERN || block == Blocks.GLOW_LICHEN || block == Blocks.HANGING_ROOTS || block == Blocks.KELP ||
                    block == Blocks.KELP_PLANT || block == Blocks.LARGE_FERN || block == Blocks.LILY_PAD || block == Blocks.POTTED_JUNGLE_SAPLING ||
                    block == Blocks.POTTED_MANGROVE_PROPAGULE || block == Blocks.MANGROVE_ROOTS || block == Blocks.MELON || block == Blocks.MELON_STEM ||
                    block == Blocks.MOSS_CARPET || block == Blocks.MOSSY_COBBLESTONE || block == Blocks.MOSSY_COBBLESTONE_SLAB || block == Blocks.MOSSY_COBBLESTONE_STAIRS ||
                    block == Blocks.MOSSY_COBBLESTONE_WALL || block == Blocks.MOSSY_STONE_BRICK_SLAB || block == Blocks.MOSSY_STONE_BRICKS || block == Blocks.INFESTED_MOSSY_STONE_BRICKS ||
                    block == Blocks.MOSSY_STONE_BRICK_STAIRS || block == Blocks.MOSSY_STONE_BRICK_WALL || block == Blocks.MUDDY_MANGROVE_ROOTS || block == Blocks.MUSHROOM_STEM ||
                    block == Blocks.POTTED_OAK_SAPLING || block == Blocks.POTTED_BROWN_MUSHROOM || block == Blocks.POTTED_RED_MUSHROOM ||
                    block == Blocks.POTTED_CACTUS || block == Blocks.POTTED_FERN ||  block == Blocks.PUMPKIN || block == Blocks.PUMPKIN_STEM || block == Blocks.ROOTED_DIRT ||
                    block == Blocks.SPORE_BLOSSOM || block == Blocks.POTTED_SPRUCE_SAPLING || block == Blocks.SUGAR_CANE ||
                    block == Blocks.SWEET_BERRY_BUSH || block == Blocks.SEAGRASS || block == Blocks.SEA_PICKLE || block == Blocks.TALL_SEAGRASS || block == Blocks.VINE) displayEntry(context, 6);
            if(block == ModBlocks.BLACK_AGILITY_BLOCK) displayEntry(context, 7);
            if(block == Blocks.COPPER_BLOCK || block == Blocks.COPPER_ORE || block == Blocks.CUT_COPPER || block == Blocks.CUT_COPPER_SLAB || block == Blocks.CUT_COPPER_STAIRS ||
            block == Blocks.DEEPSLATE_COPPER_ORE || block == Blocks.EXPOSED_COPPER || block == Blocks.EXPOSED_CUT_COPPER || block == Blocks.EXPOSED_CUT_COPPER_SLAB ||
            block == Blocks.EXPOSED_CUT_COPPER_STAIRS || block == Blocks.OXIDIZED_COPPER || block == Blocks.OXIDIZED_CUT_COPPER || block == Blocks.OXIDIZED_CUT_COPPER_SLAB ||
            block == Blocks.OXIDIZED_CUT_COPPER_STAIRS || block == Blocks.RAW_COPPER_BLOCK || block == Blocks.WAXED_COPPER_BLOCK || block == Blocks.WAXED_CUT_COPPER ||
            block == Blocks.WAXED_CUT_COPPER_SLAB || block == Blocks.WAXED_CUT_COPPER_STAIRS || block == Blocks.WAXED_EXPOSED_COPPER || block == Blocks.WAXED_EXPOSED_CUT_COPPER ||
            block == Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB || block == Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS || block == Blocks.WAXED_OXIDIZED_COPPER ||
            block == Blocks.WAXED_OXIDIZED_CUT_COPPER || block == Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB || block == Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS ||
            block == Blocks.WAXED_WEATHERED_COPPER || block == Blocks.WAXED_WEATHERED_CUT_COPPER || block == Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB ||
            block == Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS || block == Blocks.WEATHERED_COPPER || block == Blocks.WEATHERED_CUT_COPPER ||
            block == Blocks.WEATHERED_CUT_COPPER_SLAB || block == Blocks.WEATHERED_CUT_COPPER_STAIRS || block == ModBlocks.WAX_INFUSED_COPPER_BLOCK ||
            block == Blocks.LIGHTNING_ROD) displayEntry(context, 8);
            if(block == ModBlocks.IRON_GOLD_BLOCK) displayEntry(context, 12); displayEntry(context, 10);
            if(block.getDefaultState().isIn(BlockTags.GOLD_ORES) || block == Blocks.RAW_GOLD_BLOCK) displayEntry(context, 12);
            if(block == Blocks.NETHERITE_BLOCK) displayEntry(context, 11);
            if(block == ModBlocks.ROSE_GOLD_BLOCK){ displayEntry(context, 12); displayEntry(context, 13); }
            if(block == Blocks.NETHER_SPROUTS || block == Blocks.NETHER_WART || block == Blocks.NETHER_WART_BLOCK || block == Blocks.WARPED_FUNGUS ||
                    block.getDefaultState().isIn(BlockTags.CRIMSON_STEMS) || block.getDefaultState().isIn(BlockTags.WARPED_STEMS) ||
            block == Blocks.WARPED_NYLIUM || block == Blocks.WARPED_ROOTS || block == Blocks.WARPED_WART_BLOCK ||
            block == Blocks.CRIMSON_FUNGUS || block == Blocks.POTTED_WARPED_FUNGUS || block == Blocks.POTTED_CRIMSON_FUNGUS || block == Blocks.POTTED_WARPED_ROOTS || block == Blocks.CRIMSON_NYLIUM ||
            block == Blocks.CRIMSON_ROOTS || block == Blocks.POTTED_CRIMSON_ROOTS) displayEntry(context, 14);
        } return super.useOnBlock(context);
    }

    public void displayEntry(ItemUsageContext context, int indexNum) {
        ItemStack itemStack = Objects.requireNonNull(context.getPlayer()).getStackInHand(context.getHand());
        String entryName = Text.translatable(Util.createTranslationKey("entry", new Identifier(trevorssentinels.MOD_ID, "name."+ indexNum))).getString();
        String entryText = Text.translatable(Util.createTranslationKey("entry", new Identifier(trevorssentinels.MOD_ID, "text."+ indexNum))).getString();
        String entryWarn = Text.translatable(Util.createTranslationKey("entry", new Identifier(trevorssentinels.MOD_ID, "warn."+ indexNum))).getString();

        int[] index = new int[databaseSize];
        if (itemStack.getSubNbt("trevorssentinels:lens_learned") != null) {
            if(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getDouble("trevorssentinels:lens_version") == currentVersion) {
                if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getIntArray("trevorssentinels:indexArray")[indexNum] == 0) {
                    context.getPlayer().sendMessage(Text.literal("--- NEW DATA ENTRY: " + entryName.toUpperCase() + " ---").formatted(Formatting.AQUA, Formatting.BOLD));
                    context.getPlayer().sendMessage(Text.literal(entryText).formatted(Formatting.DARK_AQUA));
                    StringBuilder hyphens = new StringBuilder("------------------------");
                    hyphens.append("-".repeat(Math.max(0, entryName.length() - 2)));
                    if (!Util.createTranslationKey("entry", new Identifier(trevorssentinels.MOD_ID, "warn."+ indexNum)).equals(entryWarn)){
                        context.getPlayer().sendMessage(Text.literal(entryWarn).formatted(Formatting.DARK_RED));
                        context.getPlayer().sendMessage(Text.literal(hyphens.toString()).formatted(Formatting.RED, Formatting.BOLD));
                    } else context.getPlayer().sendMessage(Text.literal(hyphens.toString()).formatted(Formatting.AQUA, Formatting.BOLD));

                    NbtCompound nbtData = new NbtCompound();
                    for (int i = 0; i <= databaseSize - 1; i++) index[i] = Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getIntArray("trevorssentinels:indexArray")[i];
                    index[indexNum] = 1;
                    nbtData.putIntArray("trevorssentinels:indexArray", index); nbtData.putDouble("trevorssentinels:lens_version", currentVersion);
                    itemStack.setSubNbt("trevorssentinels:lens_learned", nbtData);
                }else context.getPlayer().sendMessage(Text.literal("This data has already been acquired.").formatted(Formatting.GOLD),true);
            }else{
                NbtCompound nbtData = new NbtCompound();
                int newEntries = databaseSize - Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getIntArray("trevorssentinels:indexArray").length;
                for(int i = 0; i <= Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getIntArray("trevorssentinels:indexArray").length -1; i++){
                    index[i] = Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getIntArray("trevorssentinels:indexArray")[i];
                }
                nbtData.putIntArray("trevorssentinels:indexArray", index); nbtData.putDouble("trevorssentinels:lens_version", currentVersion);
                itemStack.setSubNbt("trevorssentinels:lens_learned", nbtData);

                context.getPlayer().sendMessage(Text.literal("--- UPDATE DOWNLOADED ---").formatted(Formatting.YELLOW, Formatting.BOLD));
                context.getPlayer().sendMessage(Text.literal(" SYNCED TO DATABASE v" + Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getDouble("trevorssentinels:lens_version") + ".")
                        .formatted(Formatting.GOLD));
                context.getPlayer().sendMessage(Text.literal(newEntries + " NEW ENTRIES.").formatted(Formatting.DARK_AQUA));
                context.getPlayer().sendMessage(Text.literal("-------------------------").formatted(Formatting.AQUA, Formatting.BOLD));
            }
        } else {
            NbtCompound nbtData = new NbtCompound();nbtData.putIntArray("trevorssentinels:indexArray", index);
            nbtData.putDouble("trevorssentinels:lens_version", currentVersion);itemStack.setSubNbt("trevorssentinels:lens_learned", nbtData);
            context.getPlayer().sendMessage(Text.literal("--- CONNECTION ESTABLISHED ---").formatted(Formatting.RED, Formatting.BOLD));
            context.getPlayer().sendMessage(Text.literal("ACCESS POINT 1ex" + (context.getWorld().getTime() / 100) + "... UNSTABLE.").formatted(Formatting.DARK_RED));
            context.getPlayer().sendMessage(Text.literal("RECOMMEND FILLING MISSING DATA ENTRIES FOR ANALYSIS.").formatted(Formatting.GOLD));
            context.getPlayer().sendMessage(Text.literal("DATABASE v" + Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getDouble("trevorssentinels:lens_version") + " DOWNLOADED.")
                    .formatted(Formatting.DARK_AQUA));
            context.getPlayer().sendMessage(Text.literal("-----------------------------").formatted(Formatting.AQUA, Formatting.BOLD));
        }
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(!(world == null)) {
            if (!Screen.hasShiftDown()) {
                if (itemStack.getSubNbt("trevorssentinels:lens_learned") != null) {
                    tooltip.add(Text.literal("STATUS: CONNECTED").formatted(Formatting.AQUA));
                    if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getDouble("trevorssentinels:lens_version") == currentVersion) {
                        tooltip.add(Text.literal("DATABASE v" + Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getDouble("trevorssentinels:lens_version")
                                + " (Current)").formatted(Formatting.DARK_AQUA));
                    } else tooltip.add(Text.literal("DATABASE v" + Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getDouble("trevorssentinels:lens_version")
                                + " (Outdated)").formatted(Formatting.DARK_RED));
                    if (world.getTime() % 10 == 0) tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime() / 100)).formatted(Formatting.DARK_GRAY));
                    else if (world.getTime() % 12 == 0) tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime() / 100)).formatted(Formatting.DARK_RED));
                    else if ((world.getTime() & 13) == 0) tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime()) / 100).formatted(Formatting.RED));
                    else if ((world.getTime() % 4 == 0)) tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime()) / 100).formatted(Formatting.RED, Formatting.OBFUSCATED));
                    else tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime()) / 100).formatted(Formatting.DARK_GRAY, Formatting.OBFUSCATED));
                } else tooltip.add(Text.literal("STATUS: NO CONNECTION").formatted(world.getTime() % 2 == 0 ? Formatting.RED : Formatting.DARK_RED));
                tooltip.add(Text.literal("Hold shift to see missing data entries!").formatted(Formatting.DARK_AQUA));
            } else {
                if (itemStack.getSubNbt("trevorssentinels:lens_learned") != null) {
                    if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getDouble("trevorssentinels:lens_version") == currentVersion) {
                        boolean complete = true;
                        for (int i = 0; i <= databaseSize - 1; i++)
                            if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getIntArray("trevorssentinels:indexArray")[i] == 0) complete = false;
                        if (!complete) {
                            tooltip.add(Text.literal("Missing data entries:").formatted(Formatting.AQUA));
                            for (int i = 0; i <= databaseSize - 1; i++)
                                if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getIntArray("trevorssentinels:indexArray")[i] == 0) tooltip.add(Text.literal(
                                        Text.translatable(Util.createTranslationKey("entry", new Identifier(trevorssentinels.MOD_ID, "name."+i)))
                                                .getString()).formatted(Formatting.DARK_AQUA));
                        } else {
                            tooltip.add(Text.literal("DATABASE COMPLETE. NO MISSING ENTRIES.").formatted(Formatting.GOLD));
                            tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime() / 100) + " DIAGNOSED.").formatted(Formatting.YELLOW));
                            tooltip.add(Text.literal("LOCATION: null. TIME: null. DIAGNOSIS:").formatted(Formatting.RED));
                            tooltip.add(Text.literal("ACCESS POINT DOES NOT EXIST.").formatted(Formatting.DARK_RED));
                        }
                    } else {
                        tooltip.add(Text.literal("ERROR: OUTDATED DATA.").formatted(Formatting.DARK_RED));
                        tooltip.add(Text.literal("PLEASE DOWNLOAD NEW VERSION.").formatted(Formatting.RED));
                    }
                } else {
                    tooltip.add(Text.literal("ERROR: CANNOT ACCESS.").formatted(Formatting.DARK_RED));
                    tooltip.add(Text.literal("PLEASE CONNECT TO SSS DATABASE.").formatted(Formatting.RED));
                }
            } super.appendTooltip(itemStack, world, tooltip, context);
        }
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference);

    }

    @Override public boolean hasGlint(ItemStack itemStack){
        if(itemStack.getSubNbt("trevorssentinels:lens_learned") != null){
            for (int i = 0; i <= (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getIntArray("trevorssentinels:indexArray").length - 1); i++)
                if (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:lens_learned")).getIntArray("trevorssentinels:indexArray")[i] == 0) return false;
            return true;
        } else return false;
    }
}