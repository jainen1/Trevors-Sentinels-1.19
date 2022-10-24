package net.trevorskullcrafter.trevorssentinels.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

public class ModVillagers {
    public static final PointOfInterestType SUPERFORGE_POI = registerPOI("superforge_poi", ModBlocks.SUPERFORGE);
    public static final VillagerProfession ATTENDANT = registerProfession("attendant",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(trevorssentinels.MOD_ID, "superforge_poi")));

    public static final PointOfInterestType DEMOLITIONIST_POI = registerPOI("demolitionist_poi", Blocks.TNT);
    public static final VillagerProfession DEMOLITIONIST = registerProfession("demolitionist",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(trevorssentinels.MOD_ID,"demolitionist_poi")));

    public static final PointOfInterestType CULTIST_MERCHANT_POI = registerPOI("cultist_merchant_poi", Blocks.RESPAWN_ANCHOR);
    public static final VillagerProfession CULTIST_MERHANT = registerProfession("cultist_merchant",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(trevorssentinels.MOD_ID,"cultist_merchant_poi")));

    public static final PointOfInterestType MONK_POI = registerPOI("monk_poi", Blocks.DRAGON_HEAD);
    public static final VillagerProfession MONK = registerProfession("monk",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(trevorssentinels.MOD_ID,"monk_poi")));

    public static final PointOfInterestType OFFICER_POI = registerPOI("officer_poi", Blocks.TARGET);
    public static final VillagerProfession OFFICER = registerProfession("officer",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(trevorssentinels.MOD_ID,"officer_poi")));

    public static final PointOfInterestType CARPENTER_POI = registerPOI("carpenter_poi", Blocks.CRAFTING_TABLE);
    public static final VillagerProfession CARPENTER = registerProfession("carpenter",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(trevorssentinels.MOD_ID,"carpenter_poi")));

    public static final PointOfInterestType ASTRONOMER_POI = registerPOI("astronomer_poi", Blocks.DRAGON_EGG);
    public static final VillagerProfession ASTRONOMER = registerProfession("astronomer",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(trevorssentinels.MOD_ID,"astronomer_poi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(trevorssentinels.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(trevorssentinels.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(trevorssentinels.MOD_ID, name),
                1,1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers(){
        trevorssentinels.LOGGER.debug("Registering villagers for "+trevorssentinels.MOD_ID);
    }

    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(ATTENDANT,1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.BLOOD_DIAMOND, 5),
                            new ItemStack(ModItems.URANIUM_CRYSTAL,1),
                            6,2,0.02f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.URANIUM_CRYSTAL, 3),
                            new ItemStack(Items.MILK_BUCKET,1),
                            new ItemStack(ModItems.ANTIMILK,1),
                            6,2,0.02f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST,1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(Items.GUNPOWDER,64),
                            4,2,0.02f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 6),
                            new ItemStack(Items.FIREWORK_STAR,2),
                            6,2,0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST,2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(Items.FIREWORK_ROCKET,16),
                            4,2,0.02f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(Items.TNT,1),
                            8,2,0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST,3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(Items.FIREWORK_ROCKET,16),
                            4,2,0.02f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(Items.TNT,1),
                            8,2,0.02f
                    ));
                });
    }
}
