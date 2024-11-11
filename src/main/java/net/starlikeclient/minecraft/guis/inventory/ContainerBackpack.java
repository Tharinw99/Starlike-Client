package net.starlikeclient.minecraft.guis.inventory;

import net.lax1dude.eaglercraft.v1_8.EaglercraftUUID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.starlikeclient.minecraft.items.ItemBackpack;

public class ContainerBackpack extends Container {
	private final EaglercraftUUID backpackUUID;
	private final InventoryPlayer inventoryplayer;
	private final IInventory backpackInventory;

	public ContainerBackpack(InventoryPlayer inventoryplayer, ItemStack itemstack) {
		if (!(itemstack != null && itemstack.getItem() instanceof ItemBackpack)) {
			throw new IllegalArgumentException();
		}

		long[] uuidArray = itemstack.getTagCompound().getLongArray("UUID");
		this.backpackUUID = new EaglercraftUUID(uuidArray[0], uuidArray[1]);

		this.inventoryplayer = inventoryplayer;
		this.backpackInventory = new InventoryBasic(itemstack.getUnlocalizedName() + ".name", false,
				((ItemBackpack) itemstack.getItem()).getSlots());

		int numRows = this.backpackInventory.getSizeInventory() / 9;
		int i = (numRows - 4) * 18;

		for (int j = 0; j < numRows; ++j) {
			for (int k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(backpackInventory, k + j * 9, 8 + k * 18, 18 + j * 18) {
					@Override
					public boolean isItemValid(ItemStack itemstack) {
						return !(itemstack.getItem() instanceof ItemBackpack);
					}

					@Override
					public void onSlotChanged() {
						ContainerBackpack.this.saveInventoryToNBT();
						super.onSlotChanged();
					}
				});
			}
		}

		for (int l = 0; l < 3; ++l) {
			for (int j1 = 0; j1 < 9; ++j1) {
				this.addSlotToContainer(new Slot(inventoryplayer, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i) {
					@Override
					public void onSlotChanged() {
						ContainerBackpack.this.saveInventoryToNBT();
						super.onSlotChanged();
					}
				});
			}
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			this.addSlotToContainer(new Slot(inventoryplayer, i1, 8 + i1 * 18, 161 + i) {
				@Override
				public void onSlotChanged() {
					ContainerBackpack.this.saveInventoryToNBT();
					super.onSlotChanged();
				}
			});
		}

		loadInventoryFromNBT();
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return getBackpackItem() != null;
	}

	public IInventory getBackpackInventory() {
		return this.backpackInventory;
	}

	/**
	 * + Gets the item that the player is currently holding. If the item's UUID
	 * matches current UUID, returns ItemStack. Otherwise, returns null.
	 */
	private ItemStack getBackpackItem() {
		ItemStack itemstack = this.inventoryplayer.getCurrentItem();
		if (itemstack != null && itemstack.getItem() instanceof ItemBackpack && itemstack.hasTagCompound()
				&& itemstack.getTagCompound().hasKey("UUID", 12)) {
			long[] uuidArray = itemstack.getTagCompound().getLongArray("UUID");
			if ((new EaglercraftUUID(uuidArray[0], uuidArray[1])).equals(this.backpackUUID)) {
				return itemstack;
			}
		}
		return null;
	}

	public void loadInventoryFromNBT() {
		ItemStack backpackItem = getBackpackItem();
		if (backpackItem != null) {
			NBTTagCompound nbttagcompound = backpackItem.getTagCompound();
			if (nbttagcompound.hasKey("Items", 9)) {
				NBTTagList parNBTTagList = nbttagcompound.getTagList("Items", 10);

				for (int i = 0; i < backpackInventory.getSizeInventory(); ++i) {
					backpackInventory.setInventorySlotContents(i, (ItemStack) null);
				}

				for (int k = 0; k < parNBTTagList.tagCount(); ++k) {
					NBTTagCompound nbttagcompound1 = parNBTTagList.getCompoundTagAt(k);
					int j = nbttagcompound1.getByte("Slot") & 255;
					if (j >= 0 && j < backpackInventory.getSizeInventory()) {
						backpackInventory.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
					}
				}

				this.detectAndSendChanges();
			}
		}
	}

	@Override
	public void onContainerClosed(EntityPlayer entityplayer) {
		saveInventoryToNBT();
		super.onContainerClosed(entityplayer);
	}

	public void saveInventoryToNBT() {
		ItemStack backpackItem = getBackpackItem();
		if (backpackItem != null) {
			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < backpackInventory.getSizeInventory(); ++i) {
				ItemStack itemstack = backpackInventory.getStackInSlot(i);
				if (itemstack != null) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setByte("Slot", (byte) i);
					itemstack.writeToNBT(nbttagcompound);
					nbttaglist.appendTag(nbttagcompound);
				}
			}

			backpackItem.getTagCompound().setTag("Items", nbttaglist);
			this.detectAndSendChanges();
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer var1, int i) {
		ItemStack itemstack = null;
		Slot slot = this.inventorySlots.get(i);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			int backpackSlots = this.backpackInventory.getSizeInventory();
			if (i < backpackSlots) {
				if (!this.mergeItemStack(itemstack1, backpackSlots, this.inventorySlots.size(), true)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, backpackSlots, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}
}
