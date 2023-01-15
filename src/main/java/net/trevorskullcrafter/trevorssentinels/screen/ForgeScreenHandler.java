package net.trevorskullcrafter.trevorssentinels.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.recipe.ForgeRecipe;
import net.trevorskullcrafter.trevorssentinels.screen.slot.ModFuelSlot;
import net.trevorskullcrafter.trevorssentinels.screen.slot.ModResultSlot;

import java.util.Optional;

public class ForgeScreenHandler extends ScreenHandler{
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;

    public ForgeScreenHandler(int syncId, PlayerInventory inventory){
        this(syncId, inventory, new SimpleInventory(10), new ArrayPropertyDelegate(4));
    }

    public static void updateResult(ScreenHandler handler, World world, PlayerEntity player, CraftingInventory craftingInventory, CraftingResultInventory resultInventory) {
        ForgeRecipe recipe;
        if (world.isClient) {
            return;
        }
        ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)player;
        ItemStack itemStack = ItemStack.EMPTY;
        Optional<ForgeRecipe> match = world.getServer().getRecipeManager().getFirstMatch(ForgeRecipe.Type.INSTANCE, craftingInventory, world);
        if (match.isPresent() && resultInventory.shouldCraftRecipe(world, serverPlayerEntity, recipe = match.get())) {
            itemStack = recipe.craft(craftingInventory);
        }
        resultInventory.setStack(10, itemStack);
        handler.setPreviousTrackedSlot(10, itemStack);
        serverPlayerEntity.networkHandler.sendPacket(new ScreenHandlerSlotUpdateS2CPacket(handler.syncId, handler.nextRevision(), 0, itemStack));
    }

    public ForgeScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate){
        super(ModScreenHandlers.FORGE_SCREEN_HANDLER, syncId);
        checkSize(inventory, 10);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;

        this.addSlot(new ModFuelSlot(inventory, 0, 7, 35));
        this.addSlot(new Slot(inventory, 1, 30, 17));
        this.addSlot(new Slot(inventory, 2, 48, 17));
        this.addSlot(new Slot(inventory, 3, 66, 17));
        this.addSlot(new Slot(inventory, 4, 30, 35));
        this.addSlot(new Slot(inventory, 5, 48, 35));
        this.addSlot(new Slot(inventory, 6, 66, 35));
        this.addSlot(new Slot(inventory, 7, 30, 53));
        this.addSlot(new Slot(inventory, 8, 48, 53));
        this.addSlot(new Slot(inventory, 9, 66, 53));
        this.addSlot(new ModResultSlot(inventory, 10, 124, 35));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public boolean hasFuel(){
        return propertyDelegate.get(2) > 0;
    }

    public int getScaledProgress(){
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 22; //width in pixels of arrow

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getScaledFuel(){
        int fuel = this.propertyDelegate.get(0);
        int maxFuel = this.propertyDelegate.get(1);
        int fuelArrowSize = 13; //width in pixels of arrow

        return maxFuel != 0 && fuel != 0 ? fuel * fuelArrowSize / maxFuel : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }
            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player){
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory){
        for (int i = 0; i < 3; i++){
            for(int l = 0; l < 9; l++){
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory){
        for(int i = 0; i < 9; i++){
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
}