package net.trevorskullcrafter.trevorssentinels.item.custom;

import com.anthonyhilyard.prism.util.ConfigHelper;
import com.google.common.collect.Lists;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.text.*;
import net.minecraft.util.Language;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OnePenceItem extends InfiniteEffectItem{
    public OnePenceItem(StatusEffect effect, int level, Settings settings) {
        super(effect, level, settings);
    }

    private final Text name = new Text() {
        private final TextContent content = new TranslatableTextContent("item.trevorssentinels.one_pence");
        private final Style style = Style.EMPTY.withColor((TextColor)(Object) ConfigHelper.parseColor("8_#e77c56_#8a4129"));

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
