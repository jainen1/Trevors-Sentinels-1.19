package net.trevorskullcrafter.trevorssentinels.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModSounds {
    public static SoundEvent STEEL_BREAK = registerSoundEvent("steel_break");
    public static SoundEvent STEEL_STEP = registerSoundEvent("steel_step");
    public static SoundEvent STEEL_PLACE = registerSoundEvent("steel_place");
    public static SoundEvent STEEL_HIT = registerSoundEvent("steel_hit");
    public static SoundEvent STEEL_FALL = registerSoundEvent("steel_fall");

    public static SoundEvent ASSASSINATION_UPLOAD = registerSoundEvent("assassination_upload");
    public static SoundEvent ODE_TO_TRANQUILITY = registerSoundEvent("ode_to_tranquility");


    public static final BlockSoundGroup STEEL_SOUNDS = new BlockSoundGroup(1f,1f,
            ModSounds.STEEL_BREAK, ModSounds.STEEL_STEP, ModSounds.STEEL_PLACE, ModSounds.STEEL_HIT, ModSounds.STEEL_FALL);

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(trevorssentinels.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
