package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class LensItem extends Item {
    public LensItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        //Server: giving/removing items
        //Client: rendering, particle effects, music/sound
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();
        if (!world.isClient() && context.getHand() == Hand.MAIN_HAND) {
            ItemStack itemStack = context.getPlayer().getStackInHand(context.getHand());
            boolean found = false;

            if (block == ModBlocks.HOLOBARRIER) {
                displayEntry(context, 0);
                found = true;
            }
            if(block == ModBlocks.STEEL_BLOCK || block == ModBlocks.CAUTION_STEEL_BLOCK || block == ModBlocks.RUSTED_STEEL_BLOCK ||
                    block == ModBlocks.STAINLESS_STEEL_BLOCK || block == ModBlocks.STEEL_LAMP_BLOCK || block == ModBlocks.STEEL_FAN ||
                    block == ModBlocks.BATTERY || block == ModBlocks.FUSEBOX || block == ModBlocks.SUPERFORGE || block == ModBlocks.NUCLEAR_CHARGE) {
                displayEntry(context, 1);
                found = true;
            }
            if(block == ModBlocks.SENTINUM_BLOCK || block == ModBlocks.SENTINUM_PILLAR || block == ModBlocks.CHISELED_SENTINUM_BLOCK) {
                displayEntry(context, 2);
                found = true;
            }
            if(block == ModBlocks.URANIUM_ORE || block == ModBlocks.URANIUM_BLOCK || block == ModBlocks.NUCLEAR_CHARGE || block == ModBlocks.SUPERFORGE) {
                displayEntry(context, 3);
                found = true;
            }
            if(block == ModBlocks.LIGHT_CHAMBER_BLOCK || block == ModBlocks.DARK_CHAMBER_BLOCK){
                displayEntry(context, 4);
                found = true;
            }
            if(block == ModBlocks.BLUE_AGILITY_BLOCK || block == ModBlocks.ORANGE_AGILITY_BLOCK) {
                displayEntry(context, 4);
                displayEntry(context, 5);
                found = true;
            }
            if(block == Blocks.GRASS_BLOCK || block == Blocks.GRASS || block == Blocks.TALL_GRASS ||
                    block == Blocks.MOSS_BLOCK || block == Blocks.BROWN_MUSHROOM_BLOCK || block == Blocks.BROWN_MUSHROOM || block == Blocks.RED_MUSHROOM_BLOCK ||
                    block == Blocks.RED_MUSHROOM || block == Blocks.ACACIA_LEAVES || block == Blocks.ACACIA_LOG || block == Blocks.STRIPPED_ACACIA_LOG ||
                    block == Blocks.ACACIA_WOOD || block == Blocks.STRIPPED_ACACIA_WOOD || block == Blocks.ALLIUM || block == Blocks.ATTACHED_MELON_STEM ||
                    block == Blocks.ATTACHED_PUMPKIN_STEM || block == Blocks.AZALEA || block == Blocks.AZALEA_LEAVES || block == Blocks.FLOWERING_AZALEA_LEAVES ||
                    block == Blocks.FLOWERING_AZALEA || block == Blocks.POTTED_AZALEA_BUSH || block == Blocks.POTTED_FLOWERING_AZALEA_BUSH || block == Blocks.AZURE_BLUET ||
                    block == Blocks.BAMBOO || block == Blocks.BAMBOO_SAPLING || block == Blocks.POTTED_BAMBOO || block == Blocks.ACACIA_SAPLING ||
                    block == Blocks.BIG_DRIPLEAF || block == Blocks.BIG_DRIPLEAF_STEM || block == Blocks.BIRCH_LEAVES || block == Blocks.BIRCH_LOG ||
                    block == Blocks.STRIPPED_BIRCH_LOG || block == Blocks.BIRCH_WOOD || block == Blocks.STRIPPED_BIRCH_WOOD || block == Blocks.BIRCH_SAPLING ||
                    block == Blocks.POTTED_BIRCH_SAPLING || block == Blocks.POTTED_ACACIA_SAPLING || block == Blocks.BLUE_ORCHID || block == Blocks.CACTUS ||
                    block == Blocks.CAVE_VINES || block == Blocks.CAVE_VINES_PLANT || block == Blocks.COCOA || block == Blocks.CORNFLOWER || block == Blocks.DANDELION ||
                    block == Blocks.DARK_OAK_LEAVES || block == Blocks.DARK_OAK_LOG || block == Blocks.STRIPPED_DARK_OAK_LOG || block == Blocks.DARK_OAK_WOOD ||
                    block == Blocks.STRIPPED_DARK_OAK_WOOD || block == Blocks.DARK_OAK_SAPLING || block == Blocks.POTTED_DARK_OAK_SAPLING || block == Blocks.DEAD_BUSH ||
                    block == Blocks.FERN || block == Blocks.GLOW_LICHEN || block == Blocks.HANGING_ROOTS || block == Blocks.JUNGLE_LEAVES || block == Blocks.JUNGLE_LOG ||
                    block == Blocks.STRIPPED_JUNGLE_LOG || block == Blocks.JUNGLE_WOOD || block == Blocks.STRIPPED_JUNGLE_WOOD || block == Blocks.KELP ||
                    block == Blocks.KELP_PLANT || block == Blocks.LARGE_FERN || block == Blocks.LILAC || block == Blocks.LILY_OF_THE_VALLEY ||
                    block == Blocks.POTTED_LILY_OF_THE_VALLEY || block == Blocks.LILY_PAD || block == Blocks.MANGROVE_LEAVES || block == Blocks.JUNGLE_SAPLING ||
                    block == Blocks.POTTED_JUNGLE_SAPLING || block == Blocks.MANGROVE_LOG || block == Blocks.STRIPPED_MANGROVE_LOG || block == Blocks.MANGROVE_WOOD ||
                    block == Blocks.STRIPPED_MANGROVE_WOOD || block == Blocks.MANGROVE_PROPAGULE || block == Blocks.POTTED_MANGROVE_PROPAGULE || block == Blocks.MANGROVE_ROOTS ||
                    block == Blocks.MELON || block == Blocks.MELON_STEM || block == Blocks.MOSS_CARPET || block == Blocks.MOSSY_COBBLESTONE ||
                    block == Blocks.MOSSY_COBBLESTONE_SLAB || block == Blocks.MOSSY_COBBLESTONE_STAIRS || block == Blocks.MOSSY_COBBLESTONE_WALL ||
                    block == Blocks.MOSSY_STONE_BRICK_SLAB || block == Blocks.MOSSY_STONE_BRICKS || block == Blocks.INFESTED_MOSSY_STONE_BRICKS ||
                    block == Blocks.MOSSY_STONE_BRICK_STAIRS || block == Blocks.MOSSY_STONE_BRICK_WALL || block == Blocks.MUDDY_MANGROVE_ROOTS || block == Blocks.MUSHROOM_STEM ||
                    block == Blocks.OAK_LEAVES || block == Blocks.OAK_LOG || block == Blocks.STRIPPED_OAK_LOG || block == Blocks.OAK_WOOD || block == Blocks.STRIPPED_OAK_WOOD ||
                    block == Blocks.OAK_SAPLING || block == Blocks.POTTED_OAK_SAPLING || block == Blocks.ORANGE_TULIP || block == Blocks.POTTED_ORANGE_TULIP ||
                    block == Blocks.POTTED_BLUE_ORCHID || block == Blocks.OXEYE_DAISY || block == Blocks.PEONY || block == Blocks.POTTED_OXEYE_DAISY ||
                    block == Blocks.PINK_TULIP || block == Blocks.POTTED_PINK_TULIP || block == Blocks.POPPY || block == Blocks.POTTED_POPPY || block == Blocks.POTTED_ALLIUM ||
                    block == Blocks.POTTED_BROWN_MUSHROOM || block == Blocks.POTTED_RED_MUSHROOM || block == Blocks.RED_TULIP || block == Blocks.POTTED_RED_TULIP ||
                    block == Blocks.POTTED_CACTUS || block == Blocks.POTTED_CORNFLOWER || block == Blocks.POTTED_DANDELION || block == Blocks.POTTED_AZURE_BLUET ||
                    block == Blocks.POTTED_WHITE_TULIP || block == Blocks.WHITE_TULIP || block == Blocks.ROSE_BUSH || block == Blocks.POTTED_FERN ||
                    block == Blocks.PUMPKIN || block == Blocks.PUMPKIN_STEM || block == Blocks.ROOTED_DIRT || block == Blocks.SPORE_BLOSSOM || block == Blocks.SPRUCE_LEAVES ||
                    block == Blocks.SPRUCE_SAPLING || block == Blocks.SPRUCE_LOG || block == Blocks.STRIPPED_SPRUCE_LOG || block == Blocks.SPRUCE_WOOD ||
                    block == Blocks.STRIPPED_SPRUCE_WOOD || block == Blocks.POTTED_SPRUCE_SAPLING || block == Blocks.SUGAR_CANE || block == Blocks.SUNFLOWER ||
                    block == Blocks.SWEET_BERRY_BUSH || block == Blocks.SEAGRASS || block == Blocks.SEA_PICKLE || block == Blocks.TALL_SEAGRASS || block == Blocks.VINE){
                displayEntry(context, 6);
                found = true;
            }
            if(block == ModBlocks.BLACK_AGILITY_BLOCK) {
                displayEntry(context, 7);
                found = true;
            }
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
            block == Blocks.LIGHTNING_ROD) {
                displayEntry(context, 8);
                found = true;
            }

            if(!found){
                if(itemStack.getSubNbt("trevorssentinels:lens_learned") == null){
                    error(context, "No connection to database.");
                }else{
                    error(context, "No entry found.");
                }
            }
        }
        return super.useOnBlock(context);
    }

    public void error(ItemUsageContext context, String message){
        context.getPlayer().sendMessage(Text.literal("--- ERROR ---").formatted(Formatting.RED, Formatting.BOLD));
        context.getPlayer().sendMessage(Text.literal(message).formatted(Formatting.DARK_RED));
        context.getPlayer().sendMessage(Text.literal("-------------").formatted(Formatting.RED, Formatting.BOLD));
    }

    public double getCurrentVersion(){
        return 1.1;
    }

    public int getDatabaseSize(){
        return 10;
    }

    public String accessIndex(String type, int indexNum){
        String[] indexNames = new String[getDatabaseSize()];
        String[] indexDescriptions = new String[getDatabaseSize()];
        String[] indexWarnings = new String[getDatabaseSize()];

        indexNames[0] = "Hard Light";
        indexDescriptions[0] = "A block of concentrated, frozen photons; can only be interacted with using a Hard Light Projector.";

        indexNames[1] = "Steel";
        indexDescriptions[1] = "A carbon-ferrite alloy widely used in construction for its strength and flexibility.";

        indexNames[2] = "Sentinum";
        indexDescriptions[2] = "A silicon-based nanocrystallite used in the manufacturing of SSS drones.";
        indexWarnings[2] = "WARNING: Is weak to sudden changes in environmental conditions.";

        indexNames[3] = "Uranium";
        indexDescriptions[3] = "A highly radioactive crystal mostly found in asteroid belts. Can be harnessed in high-energy systems.";

        indexNames[4] = "Chamber Panels";
        indexDescriptions[4] = "Lightweight panels built to protect against any amount of fall damage. Used in laboratories for experimentation, especially alongside agility gel.";

        indexNames[5] = "Agility Gel";
        indexDescriptions[5] = "A velocity-enhancing gel used to simulate high velocity situations, typically for experimentation purposes.";

        indexNames[6] = "Terran Flora";
        indexDescriptions[6] = "Mostly immobile lifeforms living in a variety of habitats across the planet. Provide a natural cycle necessary for life.";
        indexWarnings[6] = "Destroy whenever possible.";

        indexNames[7] = "Magno-Repulsion";
        indexDescriptions[7] = "A transportation method using hypermagnesis to propel the user in any direction while within a magnetic field.";
        indexWarnings[7] = "WARNING: Lack of a functional guidance system may result in uncontrollable acceleration on magno-repulsive surfaces.";

        indexNames[8] = "Copper";
        indexDescriptions[8] = "A common metal used in electronics as a conductor.";

        indexNames[9] = "SSS";
        indexDescriptions[9] = "A fully self-sufficient security system created by Utarian scientists to protect against the threat of Vmortexian invasion.";
        indexWarnings[9] = "They made us gods, and expected us to follow their rules.";

        if(type.equals("warning")){
            return indexWarnings[indexNum];
        }else if(type.equals("text")){
            return indexDescriptions[indexNum];
        }else{
            return indexNames[indexNum];
        }
    }

    public void displayEntry(ItemUsageContext context, int indexNum) {
        ItemStack itemStack = context.getPlayer().getStackInHand(context.getHand());
        int[] index = new int[getDatabaseSize()];
        if (itemStack.getSubNbt("trevorssentinels:lens_learned") != null) {
            if (itemStack.getSubNbt("trevorssentinels:lens_learned").getIntArray("trevorssentinels:indexArray")[indexNum] == 0) {
                context.getPlayer().sendMessage(Text.literal("--- NEW DATA ENTRY: " + accessIndex("name", indexNum).toUpperCase() + " ---")
                        .formatted(Formatting.AQUA, Formatting.BOLD));
                context.getPlayer().sendMessage(Text.literal(accessIndex("text", indexNum)).formatted(Formatting.DARK_AQUA));
                String hyphens = "------------------------";
                for (int i = 3; i <= accessIndex("name", indexNum).length(); i++) {
                    hyphens = hyphens + "-";
                }
                if(accessIndex("warning", indexNum) != null) {
                    context.getPlayer().sendMessage(Text.literal(accessIndex("warning", indexNum)).formatted(Formatting.DARK_RED));
                    context.getPlayer().sendMessage(Text.literal(hyphens).formatted(Formatting.RED, Formatting.BOLD));
                }else{
                    context.getPlayer().sendMessage(Text.literal(hyphens).formatted(Formatting.AQUA, Formatting.BOLD));
                }

                NbtCompound nbtData = new NbtCompound();
                for (int i = 0; i <= getDatabaseSize() -1; i++) {
                    index[i] = itemStack.getSubNbt("trevorssentinels:lens_learned").getIntArray("trevorssentinels:indexArray")[i];
                }
                index[indexNum] = 1;
                nbtData.putIntArray("trevorssentinels:indexArray", index);
                itemStack.setSubNbt("trevorssentinels:lens_learned", nbtData);
            }else{
                context.getPlayer().sendMessage(Text.literal("--- WARNING ---").formatted(Formatting.YELLOW, Formatting.BOLD));
                context.getPlayer().sendMessage(Text.literal("The data for " + accessIndex("name", indexNum) + " has already been acquired.").formatted(Formatting.GOLD));
                context.getPlayer().sendMessage(Text.literal("---------------").formatted(Formatting.YELLOW, Formatting.BOLD));
            }
        } else {
            NbtCompound nbtData = new NbtCompound();
            nbtData.putIntArray("trevorssentinels:indexArray", index);
            nbtData.putDouble("trevorssentinels:lens_version", getCurrentVersion());
            itemStack.setSubNbt("trevorssentinels:lens_learned", nbtData);
            context.getPlayer().sendMessage(Text.literal("--- CONNECTION ESTABLISHED ---").formatted(Formatting.RED, Formatting.BOLD));
            context.getPlayer().sendMessage(Text.literal("ACCESS POINT 1ex" + (context.getWorld().getTime() / 100) + "... UNSTABLE.").formatted(Formatting.DARK_RED));
            context.getPlayer().sendMessage(Text.literal("RECOMMEND FILLING MISSING DATA ENTRIES FOR ANALYSIS.").formatted(Formatting.GOLD));
            context.getPlayer().sendMessage(Text.literal("DATABASE v" + itemStack.getSubNbt("trevorssentinels:lens_learned").getDouble("trevorssentinels:lens_version") + " DOWNLOADED.")
                    .formatted(Formatting.DARK_AQUA));
            context.getPlayer().sendMessage(Text.literal("-----------------------------").formatted(Formatting.AQUA, Formatting.BOLD));
        }
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(!Screen.hasShiftDown()) {
            if(itemStack.getSubNbt("trevorssentinels:lens_learned") != null) {
                    tooltip.add(Text.literal("STATUS: CONNECTED").formatted(Formatting.AQUA));
                    if(itemStack.getSubNbt("trevorssentinels:lens_learned").getDouble("trevorssentinels:lens_version") == getCurrentVersion()){
                        tooltip.add(Text.literal("DATABASE v" + itemStack.getSubNbt("trevorssentinels:lens_learned").getDouble("trevorssentinels:lens_version") + " (Current)")
                                .formatted(Formatting.DARK_AQUA));
                    }else{
                        tooltip.add(Text.literal("DATABASE v" + itemStack.getSubNbt("trevorssentinels:lens_learned").getDouble("trevorssentinels:lens_version") + " (Outdated)")
                                .formatted(Formatting.DARK_RED));
                    }
                if (world.getTime() % 10 == 0) {
                    tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime() / 100)).formatted(Formatting.DARK_GRAY));
                } else if (world.getTime() % 12 == 0) {
                    tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime() / 100)).formatted(Formatting.DARK_RED));
                } else if ((world.getTime() & 13) == 0) {
                    tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime()) / 100).formatted(Formatting.RED));
                } else if ((world.getTime() % 4 == 0)) {
                    tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime()) / 100).formatted(Formatting.RED, Formatting.OBFUSCATED));
                } else {
                    tooltip.add(Text.literal("ACCESS POINT 1ex" + (world.getTime()) / 100).formatted(Formatting.DARK_GRAY, Formatting.OBFUSCATED));
                }
            }else{
                if (world.getTime() % 2 == 0) {
                    tooltip.add(Text.literal("STATUS: NO CONNECTION").formatted(Formatting.RED));
                }else{
                    tooltip.add(Text.literal("STATUS: NO CONNECTION").formatted(Formatting.DARK_RED));
                }
            }
            tooltip.add(Text.literal("Use on certain blocks and entities").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("to learn more about them!").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Hold shift to see missing data entries!").formatted(Formatting.DARK_AQUA));
        }else{
            if(itemStack.getSubNbt("trevorssentinels:lens_learned") != null) {
                boolean complete = true;
                for (int i = 0; i <= getDatabaseSize() -1; i++) {
                    if (itemStack.getSubNbt("trevorssentinels:lens_learned").getIntArray("trevorssentinels:indexArray")[i] == 0) {
                        complete = false;
                    }
                }
                if (!complete){
                    tooltip.add(Text.literal("Missing data entries:").formatted(Formatting.AQUA));
                    for (int i = 0; i <= getDatabaseSize() -1; i++) {
                        if (itemStack.getSubNbt("trevorssentinels:lens_learned").getIntArray("trevorssentinels:indexArray")[i] == 0) {
                            tooltip.add(Text.literal(accessIndex("name", i)).formatted(Formatting.DARK_AQUA));
                        }
                    }
                }else{
                    tooltip.add(Text.literal("DATABASE COMPLETE. NO MISSING ENTRIES.").formatted(Formatting.GOLD));
                    tooltip.add(Text.literal("ACCESS POINT 1ex"+ (world.getTime() / 100) + " DIAGNOSED.").formatted(Formatting.YELLOW));
                    tooltip.add(Text.literal("LOCATION: null. TIME: null. DIAGNOSIS:").formatted(Formatting.RED));
                    tooltip.add(Text.literal("ACCESS POINT DOES NOT EXIST.").formatted(Formatting.DARK_RED));
                }
            }else{
                tooltip.add(Text.literal("ERROR: CANNOT ACCESS.").formatted(Formatting.DARK_RED));
                tooltip.add(Text.literal("PLEASE CONNECT TO SSS DATABASE.").formatted(Formatting.RED));
            }
        }
    }

    @Override
    public boolean hasGlint(ItemStack itemStack){
        if(itemStack.getSubNbt("trevorssentinels:lens_learned") != null){
            boolean complete = true;
            for (int i = 0; i <= (itemStack.getSubNbt("trevorssentinels:lens_learned").getIntArray("trevorssentinels:indexArray").length - 1); i++) {
                if (itemStack.getSubNbt("trevorssentinels:lens_learned").getIntArray("trevorssentinels:indexArray")[i] == 0) {
                    complete = false;
                }
            }
            return complete;
        }else{
            return false;
        }
    }
}