package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.util.ColoredTextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NamedBlockItem extends BlockItem{
    public String tooltipText;
    public boolean doDashes;
    public Text tooltipDashes;
    boolean halfDash;
    public String dashes = "";
    public String color;
    public Text name;
    public NamedBlockItem(Block block, String color, Settings settings) {
        super(block, settings);
        this.color = color;
        this.doDashes = false;
    }

    public NamedBlockItem(Block block, String color, boolean doDashes, Settings settings) {
        super(block, settings);
        this.color = color;
        this.doDashes = doDashes;
    }

    @Override
    public Text getName(ItemStack stack) {
        if(name == null) name = ColoredTextUtil.getColoredText(getTranslationKey(stack), color);
        return name;
    }

    public Text getSecondaryText(ItemStack stack, String string){
        if(tooltipDashes == null) tooltipDashes = ColoredTextUtil.getColoredText(string, getName(stack).getStyle());
        return tooltipDashes;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (this.tooltipText == null) this.tooltipText = Util.createTranslationKey("tooltip.item", Registries.ITEM.getId(this));
        if(!tooltipText.equals(Text.translatable(tooltipText).getString()) || doDashes) {
            if(!tooltipText.equals(Text.translatable(tooltipText).getString())) tooltip.add(Text.translatable(tooltipText).formatted(Formatting.ITALIC));
            if(dashes.equals("")){
                for(int i = 0; i < getName(stack).getString().length(); i++){
                    if(getName(stack).getString().charAt(i) != ' '
                            && getName(stack).getString().charAt(i) != 'i'
                            && getName(stack).getString().charAt(i) != 't'
                            && getName(stack).getString().charAt(i) != 'l'){
                        dashes = dashes + "-";
                    }else{
                        if(!halfDash){
                            halfDash = true;
                        }else{
                            dashes = dashes + "-";
                            halfDash = false;
                        }
                    }
                }
            }
            tooltip.add(getSecondaryText(stack, dashes));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
