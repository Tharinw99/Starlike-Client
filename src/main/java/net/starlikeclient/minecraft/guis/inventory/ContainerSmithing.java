package net.starlikeclient.minecraft.guis.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.starlikeclient.minecraft.guis.crafting.SmithingManager;
import net.minecraft.network.play.server.S30PacketWindowItems;

public class ContainerSmithing extends Container {
	private final IInventory smithingInventory;

	public ContainerSmithing(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) {
		this.smithingInventory = new InventoryBasic("Smithing", true, 3);

		this.addSlotToContainer(new Slot(smithingInventory, 0, 27, 47) {
			@Override
			public void onSlotChanged() {
				super.onSlotChanged();
				ContainerSmithing.this.onCraftMatrixChanged(smithingInventory);
			}
		});

		this.addSlotToContainer(new Slot(smithingInventory, 1, 76, 47) {
			@Override
			public boolean isItemValid(ItemStack itemstack) {
				return itemstack.getItem() == Items.netherite_ingot;
			}

			@Override
			public void onSlotChanged() {
				super.onSlotChanged();
				ContainerSmithing.this.onCraftMatrixChanged(smithingInventory);
			}
		});

		this.addSlotToContainer(new Slot(smithingInventory, 2, 134, 47) {
			@Override
			public boolean isItemValid(ItemStack itemstack) {
				return false;
			}

			@Override
			public void onPickupFromSlot(EntityPlayer playerIn, ItemStack itemstack) {
				super.onPickupFromSlot(playerIn, itemstack);
				ContainerSmithing.this.decrementInputItems();
			}
		});

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

	private void decrementInputItems() {
		ItemStack input = this.smithingInventory.getStackInSlot(0);
		ItemStack material = this.smithingInventory.getStackInSlot(1);

		if (input != null) {
			input.stackSize--;
			if (input.stackSize <= 0) {
				this.smithingInventory.setInventorySlotContents(0, null);
			}
		}

		if (material != null) {
			material.stackSize--;
			if (material.stackSize <= 0) {
				this.smithingInventory.setInventorySlotContents(1, null);
			}
		}
	}

	public boolean isCraftingValid() {
		ItemStack input = this.smithingInventory.getStackInSlot(0);
		ItemStack material = this.smithingInventory.getStackInSlot(1);

		if (input != null && material != null) {
			return SmithingManager.getInstance().getSmithingResult(input) != null;
		}
		return false;
	}

	@Override
	public void onContainerClosed(EntityPlayer entityplayer) {
		super.onContainerClosed(entityplayer);
		if (!entityplayer.worldObj.isRemote) {
			for (int i = 0; i < 2; ++i) {
				ItemStack itemstack = this.smithingInventory.removeStackFromSlot(i);
				if (itemstack != null) {
					if (!entityplayer.inventory.addItemStackToInventory(itemstack)) {
						entityplayer.dropPlayerItemWithRandomChoice(itemstack, false);
					}
				}
			}
			((EntityPlayerMP) entityplayer).playerNetServerHandler.sendPacket(new S30PacketWindowItems(entityplayer.inventoryContainer.windowId, entityplayer.inventoryContainer.getInventory()));
		}
	}

	@Override
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		super.onCraftMatrixChanged(inventoryIn);
		this.updateCraftingResult();
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityplayer, int i) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(i);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if ((i != 0 && i != 1) && ((itemstack1.getItem() == Items.netherite_ingot)
					|| (SmithingManager.getInstance().getSmithingResult(itemstack1) != null))) {
				if (itemstack1.getItem() == Items.netherite_ingot) {
					if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
						return null;
					}
				} else if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
					return null;
				}
			} else if (i >= 3 && i < 30) {
				if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
					return null;
				}
			} else if (i >= 30 && i < 39) {
				if (!this.mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(entityplayer, itemstack1);
		}

		return itemstack;
	}

	private void updateCraftingResult() {
		ItemStack input = this.smithingInventory.getStackInSlot(0);
		ItemStack material = this.smithingInventory.getStackInSlot(1);

		if (input != null && material != null && material.getItem() == Items.netherite_ingot) {
			ItemStack result = SmithingManager.getInstance().getSmithingResult(input);
			if (result != null) {
				result.stackSize = 1;
				result.setItemDamage(input.getItemDamage());
				if (input.hasTagCompound()) {
					result.setTagCompound((NBTTagCompound) input.getTagCompound().copy());
				}
				this.smithingInventory.setInventorySlotContents(2, result);
			} else {
				this.smithingInventory.setInventorySlotContents(2, null);
			}
		} else {
			this.smithingInventory.setInventorySlotContents(2, null);
		}
	}
}
