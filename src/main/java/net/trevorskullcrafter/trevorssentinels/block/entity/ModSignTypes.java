package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.minecraft.util.SignType;
import net.trevorskullcrafter.trevorssentinels.mixin.SignTypeAccessor;

public class ModSignTypes {
    public static final SignType HOLOGRAPHIC = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("holographic"));
    public static final SignType STEEL = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("steel"));
    public static final SignType MIDAS = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("midas"));
    public static final SignType YGGDRASIL = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("yggdrasil"));
    public static final SignType CHARRED_OAK = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("charred_oak"));
    public static final SignType BANANA = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("banana"));
    public static final SignType CERULII = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("cerulii"));
}