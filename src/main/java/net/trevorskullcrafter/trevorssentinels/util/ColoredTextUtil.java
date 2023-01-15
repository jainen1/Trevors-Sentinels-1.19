package net.trevorskullcrafter.trevorssentinels.util;

import com.anthonyhilyard.prism.util.ConfigHelper;
import com.google.common.collect.Lists;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Language;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ColoredTextUtil {
    public static String accent_blue = "#189DBB";
    public static String accent_gold = "#FFAA00";
    public static String accent_red = "#D31400";

    public static String flimsy_sentinum = "#64666b";
    public static String sentinum = "12_"+flimsy_sentinum+"_#4a4752_"+accent_blue;
    public static String rose_gold = "8_#fbebe5_#f7d2c5";
    public static String gunmetal = "#906150";
    public static String trimetal = "8_"+gunmetal+"_#6f7d9d";
    public static String iron_gold_RAW = "#eae69b_#a78442";
    public static String iron_gold = "8_#eae69b_#a78442";
    public static String darksteel_RAW = "#383444_#2f273b";
    public static String darksteel = "12_"+darksteel_RAW+"_#AA00AA";
    public static String blood_red_RAW = "#d90012_#9e000d";
    public static String blood_red = "8_"+blood_red_RAW;
    public static String hunter = "6_#d90012_#8e5c5c";
    public static String hallucium = "16_"+iron_gold_RAW+"_"+darksteel_RAW;
    public static String nuclear = "8_#55FF55_#00AA00";
    public static String demonic = "8_#FF55FF_#AA00AA";
    public static String zenithium = "9_#00AA00_#00AAAA_#AA00AA";

    public static String yggdrasil = "8_#eae1e5_#846977";
    public static String charred_oak = "8_#494949_#252525";
    public static String midas = "8_#beab27_#47320e";
    public static String viridian = "8_#6b892e_#485d26";
    public static String flesh_pink = "8_#bf5755_#772221";
    public static String dune_tan = "#d4b963";
    public static String rainbow = "8_#ed4d9c_#ed764d_#eced4d_#75ed4d_#4ded9f_#4dc3ed_#4e4ded_#c64ded";
    public static String sentinel_accent = "24_"+accent_blue+"_"+flimsy_sentinum+"_"+accent_gold+"_"+flimsy_sentinum+"_"+accent_red+"_"+flimsy_sentinum;

    public static Text styleText = new Text() {
        private final TextContent content = new TranslatableTextContent("tooltip.trevorssentinels.style");
        private final Style style = Style.EMPTY.withFormatting(Formatting.ITALIC).withColor((TextColor) (Object) ConfigHelper.parseColor(rainbow));
        @Nullable
        private Language decomposedWith;
        private OrderedText visualOrderText = OrderedText.EMPTY;

        @Override
        public Style getStyle() {
            return style;
        }

        @Override
        public TextContent getContent() {
            return content;
        }

        @Override
        public List<Text> getSiblings() {
            return Lists.newArrayList();
        }

        @Override
        public OrderedText asOrderedText() {
            Language language = Language.getInstance();
            if (this.decomposedWith != language) {
                this.visualOrderText = language.reorder(this);
                this.decomposedWith = language;
            }
            return this.visualOrderText;
        }
    };

    public static Text getColoredText(String textContent, String color){
        return new Text() {
            private final TextContent content = new TranslatableTextContent(textContent);
            private final Style style = Style.EMPTY.withColor((TextColor) (Object) ConfigHelper.parseColor(color));

            @Nullable
            private Language decomposedWith;
            private OrderedText visualOrderText = OrderedText.EMPTY;

            @Override
            public Style getStyle() {
                return style;
            }

            @Override
            public TextContent getContent() {
                return content;
            }

            @Override
            public List<Text> getSiblings() {
                return Lists.newArrayList();
            }

            @Override
            public OrderedText asOrderedText() {
                Language language = Language.getInstance();
                if (this.decomposedWith != language) {
                    this.visualOrderText = language.reorder(this);
                    this.decomposedWith = language;
                }
                return this.visualOrderText;
            }
        };
    }

    public static Text getColoredText(String textContent, Style styleContent){
        return new Text() {
            private final TextContent content = new TranslatableTextContent(textContent);

            @Nullable
            private Language decomposedWith;
            private OrderedText visualOrderText = OrderedText.EMPTY;

            @Override
            public Style getStyle() {
                return styleContent;
            }

            @Override
            public TextContent getContent() {
                return content;
            }

            @Override
            public List<Text> getSiblings() {
                return Lists.newArrayList();
            }

            @Override
            public OrderedText asOrderedText() {
                Language language = Language.getInstance();
                if (this.decomposedWith != language) {
                    this.visualOrderText = language.reorder(this);
                    this.decomposedWith = language;
                }
                return this.visualOrderText;
            }
        };
    }
}