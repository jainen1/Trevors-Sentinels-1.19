package net.trevorskullcrafter.trevorssentinels.world.gen;

public class ModWorldGen {
    public static void generateWorldGen(){
        ModOreGeneration.generateOres();

        ModTreeGeneration.generateTrees();
    }
}
