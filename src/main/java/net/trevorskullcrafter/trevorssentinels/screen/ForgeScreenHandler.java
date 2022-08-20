package net.trevorskullcrafter.trevorssentinels.screen;

/*import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.trevorskullcrafter.trevorssentinels.block.entity.ForgeBlockEntity;
import net.trevorskullcrafter.trevorssentinels.screen.slot.ModFuelSlot;
import net.trevorskullcrafter.trevorssentinels.screen.slot.ModResultSlot;

public class ForgeScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public ForgeScreenHandler(int syncId, PlayerInventory playerInventory, ForgeBlockEntity ForgeBlockEntity, PropertyDelegate propertyDelegate){
        this(syncId, playerInventory, new SimpleInventory(11));
    }

    public ForgeScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory){
        super(ModScreenHandlers.FORGE_SCREEN_HANDLER,syncId);
        checkSize(inventory, 11);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

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
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
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

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
}*/
