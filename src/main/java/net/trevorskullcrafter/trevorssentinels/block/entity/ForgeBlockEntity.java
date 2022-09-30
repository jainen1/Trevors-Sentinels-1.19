package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.recipe.ForgeRecipe;
import net.trevorskullcrafter.trevorssentinels.screen.ForgeScreen;
import net.trevorskullcrafter.trevorssentinels.screen.ForgeScreenHandler;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Optional;

import static net.minecraft.datafixer.TypeReferences.RECIPE;

public class ForgeBlockEntity extends BlockEntity implements NamedScreenHandlerFactory,ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(11, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public ForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FORGE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ForgeBlockEntity.this.progress;
                    case 1 -> ForgeBlockEntity.this.maxProgress;
                    case 2 -> ForgeBlockEntity.this.fuelTime;
                    case 3 -> ForgeBlockEntity.this.maxFuelTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> {
                        ForgeBlockEntity.this.progress = value;
                        break;
                    }
                    case 1 -> {
                        ForgeBlockEntity.this.maxProgress = value;
                        break;
                    }
                    case 2 -> {
                        ForgeBlockEntity.this.fuelTime = value;
                        break;
                    }
                    case 3 -> {
                        ForgeBlockEntity.this.maxFuelTime = value;
                        break;
                    }
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Forge Metals and Alloys");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ForgeScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("forge.progress", progress);
        nbt.putInt("forge.maxProgress", maxProgress);
        nbt.putInt("forge.fuelTime", fuelTime);
        nbt.putInt("forge.maxFuelTime", maxFuelTime);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("forge.progress");
        maxProgress = nbt.getInt("forge.maxProgress");
        fuelTime = nbt.getInt("forge.fuelTime");
        maxFuelTime = nbt.getInt("forge.maxFuelTime");
    }

    /*public static void tick(World world, BlockPos blockPos, BlockState blockState, ForgeBlockEntity entity) {
        if(isConsumingFuel(entity)){
            entity.fuelTime--;
        }

        if(hasRecipe(entity)){
            if(hasFuelInFuelSlot(entity) && !isConsumingFuel(entity)){
                entity.consumeFuel();
            }
            if(isConsumingFuel(entity)){
                entity.progress++;
                markDirty(world, blockPos, blockState);
                if(entity.progress >= entity.maxProgress){
                    craftItem(entity);
                }
            }
        } else {
            entity.progress = 0;
            markDirty(world, blockPos, blockState);
        }
    }

    private void consumeFuel() {
        if(!getStack(0).isEmpty()) {
            this.fuelTime = FuelRegistry.INSTANCE.get(this.removeStack(0, 1).getItem());
            this.maxFuelTime = this.fuelTime;
        }
    }

    private static boolean hasFuelInFuelSlot(ForgeBlockEntity entity){
        return !entity.getStack(0).isEmpty();
    }

    private static boolean isConsumingFuel(ForgeBlockEntity entity){
        return entity.fuelTime > 0;
    }

    private static void craftItem(ForgeBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(10);
        for(int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        if(hasRecipe(entity)){
            entity.removeStack(0,1);

            Optional<ForgeRecipe> match = entity.getWorld().getServer().getRecipeManager().getFirstMatch(
                    ForgeRecipe.Type.INSTANCE, inventory, entity.getWorld());

            entity.setStack(10, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(10).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress(){
        this.progress = 0;
    }

    private static boolean hasRecipe(ForgeBlockEntity entity){
        SimpleInventory inventory = new SimpleInventory(10);
        for(int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<ForgeRecipe> match = entity.getWorld().getServer().getRecipeManager().getFirstMatch(
                ForgeRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertItemIntoOutputSlot(inventory)
                && canInsertAmountIntoOutputSlot(inventory, match.get().getOutput().getItem());
        return false;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(10).getMaxCount() > inventory.getStack(10).getCount();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(10).getItem() == output || inventory.getStack(10).isEmpty();
    }*/
}