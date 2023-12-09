package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class LangGenUtils {
    public static void generateAdvancement(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, String advancement, String title, String desc) {
        translationBuilder.add("advancements." + MOD_ID + "." + advancement + ".title", title);
        translationBuilder.add("advancements." + MOD_ID + "." + advancement + ".desc", desc);
    }

    public static void generateAdvancement(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, AdvancementEntry advancement, String title, String desc) {
        translationBuilder.add("advancements." + advancement.id() + ".title", title);
        translationBuilder.add("advancements." + advancement.id() + ".desc", desc);
    }

    public static void generateSetBonus(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, ArmorMaterial material, String tooltip, Color color) {
        translationBuilder.add("tooltip.material." + MOD_ID + "." + material.getName(), tooltip);
        if(color != null) translationBuilder.add("color.material." + MOD_ID + "." + material.getName(), String.valueOf(color.getRGB()));
    }

    public static void generateStatusEffect(FabricLanguageProvider.TranslationBuilder translationBuilder, StatusEffect statusEffect, String name, boolean potion){
        translationBuilder.add(statusEffect, name);
        if(potion){
            String key = statusEffect.getTranslationKey().substring(("effect."+ MOD_ID).length()+1);
            translationBuilder.add("item.minecraft.potion.effect."+key+"_potion", name + " Potion");
            translationBuilder.add("item.minecraft.splash_potion.effect."+key+"_potion", "Splash Potion of " + name);
            translationBuilder.add("item.minecraft.lingering_potion.effect."+key+"_potion", "Lingering Potion of " + name);
            translationBuilder.add("item.minecraft.tipped_arrow.effect."+key+"_potion", "Arrow of " + name);
        }
    }

    public static void generatePot(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, ItemConvertible r, ItemConvertible p, int custom, String name, String tooltip, Color color){
        if(r!=null) generateItem(translationBuilder, r, custom, name, tooltip, color);
        if(p!=null) generateItem(translationBuilder, p, custom, "Potted "+name, tooltip, color);
    }

    public static void generateSound(FabricLanguageProvider.TranslationBuilder translationBuilder, SoundEvent sound, String subtitle){
        translationBuilder.add(MOD_ID+":"+sound.getId().getPath(), subtitle);
    }

    public static void generateMusicDisc(FabricLanguageProvider.TranslationBuilder translationBuilder, ItemConvertible item, int custom, String name, String tooltip, Color color, String desc, SoundEvent sound){
        generateItem(translationBuilder, item, custom, name, tooltip, color);
        translationBuilder.add(item.asItem().getTranslationKey()+".desc", desc);
        generateSound(translationBuilder, sound, item.asItem().getName().getString()+" plays");
    }

    public static String getItemKey(ItemConvertible item){
        if (item instanceof Block block) { return block.getTranslationKey(); }
        else { return item.asItem().getTranslationKey(); }
    }

    public static void generateTooltip(FabricLanguageProvider.TranslationBuilder translationBuilder, ItemConvertible item, int custom, String tooltip){
        translationBuilder.add("tooltip." + getItemKey(item) + (custom != 0? (".custom" + custom) : ""), tooltip);
    }

    public static void generateColor(FabricLanguageProvider.TranslationBuilder translationBuilder, ItemConvertible item, int custom, Color color){
        translationBuilder.add("color." + getItemKey(item) + (custom != 0? (".custom" + custom) : ""), String.valueOf(color.getRGB()));
    }

    public static String capitalize(String str) {
        if (str.isEmpty()) { return str; }
        else {
            char[] buffer = str.toCharArray();
            boolean capitalizeNext = true;
            for(int i = 0; i < buffer.length; ++i) {
                char ch = buffer[i];
                if (Character.isWhitespace(ch)) { capitalizeNext = true; }
                else if (capitalizeNext) {
                    buffer[i] = Character.toTitleCase(ch);
                    capitalizeNext = false;
                }
            } return new String(buffer);
        }
    }

    public static void generateItem(FabricLanguageProvider.TranslationBuilder translationBuilder, ItemConvertible item, int custom, String name){
        translationBuilder.add(getItemKey(item) + (custom != 0 ? (".custom" + custom) : ""),
                name == null? capitalize(getItemKey(item).substring(getItemKey(item).lastIndexOf(".") + 1).replace("_", " ")) : name);
    }

    public static void generateItem(FabricLanguageProvider.TranslationBuilder translationBuilder, ItemConvertible item, int custom, String name, String tooltip, Color color) {
        generateItem(translationBuilder, item, custom, name);
        if (tooltip != null) { generateTooltip(translationBuilder, item, custom, tooltip); }
        if (color != null) { generateColor(translationBuilder, item, custom, color); }
    }

    public static void generateMultiple(@NotNull FabricLanguageProvider.TranslationBuilder translationBuilder, int custom, Color color, ItemConvertible... items){
        for (ItemConvertible item:items) { if(item != null) { generateItem(translationBuilder, item, custom, null, null, color); }}
    }

    public static void generateNumbered(FabricLanguageProvider.TranslationBuilder translationBuilder, String translationKey, String... nums){
        for (int i = 0; i < nums.length; i++) { translationBuilder.add(translationKey+(i+1), nums[i]); }
    }
}