package net.starlikeclient.minecraft.guis.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.starlikeclient.minecraft.items.ItemBackpack;

public class BackpackInventory extends InventoryBasic {
    private final ItemStack backpackItem;

    public BackpackInventory(ItemStack backpackItem) {
        super("Backpack", false, 32);
        this.backpackItem = backpackItem;
        loadInventoryFromNBT();
    }

    @Override
    public void markDirty() {
        saveInventoryToNBT();
        super.markDirty();
    }

    @Override
    public void closeInventory(EntityPlayer player) {
        saveInventoryToNBT();
		super.closeInventory(player);
        ItemBackpack.onInventoryClosed(); 
    }

    public void loadInventoryFromNBT() {
        if (backpackItem != null && backpackItem.hasTagCompound()) {
            NBTTagCompound nbt = backpackItem.getTagCompound();
            NBTTagList itemList = nbt.getTagList("BackpackItems", 10);

            for (int i = 0; i < itemList.tagCount(); i++) {
                NBTTagCompound slotTag = itemList.getCompoundTagAt(i);
                int slot = slotTag.getByte("Slot") & 255;
                ItemStack stack = ItemStack.loadItemStackFromNBT(slotTag);
                if (slot >= 0 && slot < getSizeInventory()) {
                    setInventorySlotContents(slot, stack);
                }
            }
        }
    }

    public void saveInventoryToNBT() {
        if (backpackItem == null) return;
        
        NBTTagCompound nbt = backpackItem.hasTagCompound() ? 
            backpackItem.getTagCompound() : new NBTTagCompound();
            
        NBTTagList itemList = new NBTTagList();

        for (int i = 0; i < getSizeInventory(); i++) {
            ItemStack stack = getStackInSlot(i);
            if (stack != null) {
                NBTTagCompound slotTag = new NBTTagCompound();
                slotTag.setByte("Slot", (byte)i);
                stack.writeToNBT(slotTag);
                itemList.appendTag(slotTag);
            }
        }

        nbt.setTag("BackpackItems", itemList);
        backpackItem.setTagCompound(nbt);
    }
}