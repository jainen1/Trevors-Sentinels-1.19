package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SuperforgeBlockEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation DEFAULT = RawAnimation.begin().thenPlay("build").thenWait(20).thenLoop("idle");

    public SuperforgeBlockEntity(BlockPos pos, BlockState state) { super(ModBlockEntities.SUPERFORGE, pos, state); }

    @Override public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, state -> state.setAndContinue(DEFAULT)));
    }

    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }
}