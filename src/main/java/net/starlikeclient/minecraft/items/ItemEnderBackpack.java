package net.starlikeclient.minecraft.items;

import net.lax1dude.eaglercraft.v1_8.EaglercraftUUID;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.starlikeclient.minecraft.guis.inventory.ContainerEnderBackpack;

public class ItemEnderBackpack extends Item {
	public class InterfaceEnderBackpack implements IInteractionObject {
		public InterfaceEnderBackpack() {
		}

		@Override
		public ContainerEnderBackpack createContainer(InventoryPlayer inventoryplayer, EntityPlayer entityplayer) {
			return new ContainerEnderBackpack(inventoryplayer, entityplayer.getCurrentEquippedItem());
		}

		@Override
		public IChatComponent getDisplayName() {
			return new ChatComponentTranslation(ItemEnderBackpack.this.getUnlocalizedName() + ".name", new Object[0]);
		}

		@Override
		public String getGuiID() {
			return "starlike:ender_backpack";
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

	public ItemEnderBackpack() {
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabStarlike);
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
			if (refreshNeeded) {
				((EntityPlayerMP) entityplayer).playerNetServerHandler.sendPacket(new S30PacketWindowItems(
						entityplayer.inventoryContainer.windowId, entityplayer.inventoryContainer.getInventory()));
			}

			entityplayer.displayGui(new ItemEnderBackpack.InterfaceEnderBackpack());
		}
		return itemstack;
	}
}
