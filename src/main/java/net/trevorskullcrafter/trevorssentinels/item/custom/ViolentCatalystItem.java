package net.trevorskullcrafter.trevorssentinels.item.custom;

import com.anthonyhilyard.prism.util.ConfigHelper;
import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.*;
import net.minecraft.util.Language;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ViolentCatalystItem extends Item {
    public ViolentCatalystItem(Settings settings) {
        super(settings);
    }

    private final Text name = new Text() {
        private final TextContent content = new TranslatableTextContent("item.trevorssentinels.violent_catalyst");
        private final Style style = Style.EMPTY.withColor((TextColor)(Object) ConfigHelper.parseColor("3_#55FFFF_#55FF55_#FF5555"));

        @Nullable
        private Language decomposedWith;
        private OrderedText visualOrderText = OrderedText.EMPTY;

        @Override
        public Style getStyle() { return style; }

        @Override
        public TextContent getContent() { return content; }

        @Override
        public List<Text> getSiblings() { return Lists.newArrayList(); }

        @Override
        public OrderedText asOrderedText()
        {
            Language language = Language.getInstance();
            if (this.decomposedWith != language)
            {
                this.visualOrderText = language.reorder(this);
                this.decomposedWith = language;
            }
            return this.visualOrderText;
        }
    };

    @Override
    public Text getName(ItemStack stack) {
        return name;
    }
}