package net.trevorskullcrafter.trevorssentinels.item.custom;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.trevorskullcrafter.trevorssentinels.client.render.armor.SentinumArmorRenderer;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SentinumArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    public SentinumArmorItem(ArmorMaterial materialIn, Type type, Item.Settings builder) {
        super(materialIn, type, builder);
    }

    @Override public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 20, state -> {
            state.getController().setAnimation(DefaultAnimations.IDLE);

            // For this example, we only want the animation to play if the entity is wearing all pieces of the armor
            // Let's collect the armor pieces the entity is currently wearing
            Set<Item> wornArmor = new ObjectOpenHashSet<>();
            for (ItemStack stack : state.getData(DataTickets.ENTITY).getArmorItems()) {
                // We can stop immediately if any of the slots are empty
                if (stack.isEmpty()) return PlayState.STOP;
                wornArmor.add(stack.getItem());
            }

            // Play the animation if the full set is being worn, otherwise stop
            return wornArmor.containsAll(ObjectArrayList.of(ModArmory.SPACEFARERS_HELMET, ModArmory.SPACEFARERS_CHESTPLATE, ModArmory.SPACEFARERS_LEGGINGS,
                    ModArmory.SPACEFARERS_BOOTS)) ? PlayState.CONTINUE : PlayState.STOP;
        }));
    }

    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return this.cache; }
    @Override public Supplier<Object> getRenderProvider() { return this.renderProvider; }

    @Override public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() { private GeoArmorRenderer<?> renderer;
            @Override public @NotNull BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity,
                           ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null) this.renderer = new SentinumArmorRenderer();
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer; }});
    }
}