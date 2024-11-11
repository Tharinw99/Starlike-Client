package net.starlikeclient.minecraft.guis.inventory;

import net.lax1dude.eaglercraft.v1_8.EaglercraftUUID;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;
import net.starlikeclient.minecraft.items.ItemEnderBackpack;

public class ContainerEnderBackpack extends ContainerChest {
	private final EaglercraftUUID backpackUUID;
	private final InventoryPlayer inventoryplayer;

	public ContainerEnderBackpack(InventoryPlayer inventoryplayer, ItemStack itemstack) {
		super(inventoryplayer, inventoryplayer.player.getInventoryEnderChest(), inventoryplayer.player);

		if (!(itemstack != null && itemstack.getItem() instanceof ItemEnderBackpack)) {
			throw new IllegalArgumentException();
		}

		long[] uuidArray = itemstack.getTagCompound().getLongArray("UUID");
		this.backpackUUID = new EaglercraftUUID(uuidArray[0], uuidArray[1]);

		this.inventoryplayer = inventoryplayer;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		if (getBackpackItem() != null) {
			return true;
		} else {
			this.onContainerClosed(entityplayer);
			Minecraft.getMinecraft().thePlayer.closeScreen();
			return false;
		}
	}

	/**
	 * + Gets the item that the player is currently holding. If the item's UUID
	 * matches current UUID, returns ItemStack. Otherwise, returns null.
	 */
	private ItemStack getBackpackItem() {
		ItemStack itemstack = this.inventoryplayer.getCurrentItem();
		if (itemstack != null && itemstack.getItem() instanceof ItemEnderBackpack && itemstack.hasTagCompound()
				&& itemstack.getTagCompound().hasKey("UUID", 12)) {
			long[] uuidArray = itemstack.getTagCompound().getLongArray("UUID");
			if ((new EaglercraftUUID(uuidArray[0], uuidArray[1])).equals(this.backpackUUID)) {
				return itemstack;
			}
		}
		return null;
	}
}
