package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.minecraft.util.SignType;
import net.trevorskullcrafter.trevorssentinels.mixin.SignTypeAccessor;

public class ModSignTypes {
    public static final SignType HOLOGRAPHIC =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("holographic"));
    public static final SignType MIDAS =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("midas"));
    public static final SignType YGGDRASIL =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("yggdrasil"));
}
