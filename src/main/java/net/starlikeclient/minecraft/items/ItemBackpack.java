package net.starlikeclient.minecraft.items;

import net.lax1dude.eaglercraft.v1_8.EaglercraftUUID;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.starlikeclient.minecraft.guis.inventory.ContainerBackpack;

public class ItemBackpack extends Item {
	public class InterfaceBackpack implements IInteractionObject {
		public InterfaceBackpack() {
		}

		@Override
		public ContainerBackpack createContainer(InventoryPlayer inventoryplayer, EntityPlayer entityplayer) {
			return new ContainerBackpack(inventoryplayer, entityplayer.getCurrentEquippedItem());
		}

		@Override
		public IChatComponent getDisplayName() {
			return new ChatComponentTranslation(ItemBackpack.this.getUnlocalizedName() + ".name", new Object[0]);
		}

		@Override
		public String getGuiID() {
			return "starlike:backpack";
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		public boolean hasCustomName() {
			return false;
		}
	}

	private final int slots;

	public ItemBackpack(int rows) {
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabStarlike);
		this.slots = rows * 9;
	}

	/**
	 * + Returns the number of slots in the backpack
	 */
	public int getSlots() {
		return this.slots;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (!world.isRemote) {
			boolean refreshNeeded = false;
			if (!itemstack.hasTagCompound()) {
				itemstack.setTagCompound(new NBTTagCompound());
				refreshNeeded = true;
			}
			NBTTagCompound nbttagcompound = itemstack.getTagCompound();
			if (!nbttagcompound.hasKey("UUID")) {
				EaglercraftUUID uuid = EaglercraftUUID.randomUUID();
				nbttagcompound.setLongArray("UUID",
						new long[] { uuid.getMostSignificantBits(), uuid.getLeastSignificantBits() });
				refreshNeeded = true;
			}
			if (!nbttagcompound.hasKey("Items")) {
				nbttagcompound.setTag("Items", new NBTTagList());
				refreshNeeded = true;
			}
			if (refreshNeeded) {
				((EntityPlayerMP) entityplayer).playerNetServerHandler.sendPacket(new S30PacketWindowItems(
						entityplayer.inventoryContainer.windowId, entityplayer.inventoryContainer.getInventory()));
			}

			entityplayer.displayGui(new ItemBackpack.InterfaceBackpack());
		}
		return itemstack;
	}
}
