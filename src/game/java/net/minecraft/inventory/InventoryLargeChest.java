package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.LockCode;

/**
 * + This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source
 * code.
 *
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!" Mod
 * Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 *
 * EaglercraftX 1.8 patch files (c) 2022-2025 lax1dude, ayunami2000. All Rights
 * Reserved.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
public class InventoryLargeChest implements ILockableContainer {
	private String name;
	private ILockableContainer upperChest;
	private ILockableContainer lowerChest;

	public InventoryLargeChest(String nameIn, ILockableContainer upperChestIn, ILockableContainer lowerChestIn) {
		this.name = nameIn;
		if (upperChestIn == null) {
			upperChestIn = lowerChestIn;
		}

		if (lowerChestIn == null) {
			lowerChestIn = upperChestIn;
		}

		this.upperChest = upperChestIn;
		this.lowerChest = lowerChestIn;
		if (upperChestIn.isLocked()) {
			lowerChestIn.setLockCode(upperChestIn.getLockCode());
		} else if (lowerChestIn.isLocked()) {
			upperChestIn.setLockCode(lowerChestIn.getLockCode());
		}

	}

	@Override
	public void clear() {
		this.upperChest.clear();
		this.lowerChest.clear();
	}

	@Override
	public void closeInventory(EntityPlayer entityplayer) {
		this.upperChest.closeInventory(entityplayer);
		this.lowerChest.closeInventory(entityplayer);
	}

	@Override
	public Container createContainer(InventoryPlayer inventoryplayer, EntityPlayer entityplayer) {
		return new ContainerChest(inventoryplayer, this, entityplayer);
	}

	/**
	 * + Removes up to a specified number of items from an inventory slot and
	 * returns them in a new stack.
	 */
	@Override
	public ItemStack decrStackSize(int i, int j) {
		return i >= this.upperChest.getSizeInventory()
				? this.lowerChest.decrStackSize(i - this.upperChest.getSizeInventory(), j)
				: this.upperChest.decrStackSize(i, j);
	}

	/**
	 * + Get the formatted ChatComponent that will be used for the sender's username
	 * in chat
	 */
	@Override
	public IChatComponent getDisplayName() {
		return (IChatComponent) (this.hasCustomName() ? new ChatComponentText(this.getName())
				: new ChatComponentTranslation(this.getName(), new Object[0]));
	}

	@Override
	public int getField(int var1) {
		return 0;
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public String getGuiID() {
		return this.upperChest.getGuiID();
	}

	/**
	 * + Returns the maximum stack size for a inventory slot. Seems to always be 64,
	 * possibly will be extended.
	 */
	@Override
	public int getInventoryStackLimit() {
		return this.upperChest.getInventoryStackLimit();
	}

	@Override
	public LockCode getLockCode() {
		return this.upperChest.getLockCode();
	}

	/**
	 * + Gets the name of this command sender (usually username, but possibly
	 * "Rcon")
	 */
	@Override
	public String getName() {
		return this.upperChest.hasCustomName() ? this.upperChest.getName()
				: (this.lowerChest.hasCustomName() ? this.lowerChest.getName() : this.name);
	}

	/**
	 * + Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return this.upperChest.getSizeInventory() + this.lowerChest.getSizeInventory();
	}

	/**
	 * + Returns the stack in the given slot.
	 */
	@Override
	public ItemStack getStackInSlot(int i) {
		return i >= this.upperChest.getSizeInventory()
				? this.lowerChest.getStackInSlot(i - this.upperChest.getSizeInventory())
				: this.upperChest.getStackInSlot(i);
	}

	/**
	 * + Returns true if this thing is named
	 */
	@Override
	public boolean hasCustomName() {
		return this.upperChest.hasCustomName() || this.lowerChest.hasCustomName();
	}

	/**
	 * + Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}

	@Override
	public boolean isLocked() {
		return this.upperChest.isLocked() || this.lowerChest.isLocked();
	}

	/**
	 * + Return whether the given inventory is part of this large chest.
	 */
	public boolean isPartOfLargeChest(IInventory inventoryIn) {
		return this.upperChest == inventoryIn || this.lowerChest == inventoryIn;
	}

	/**
	 * + Do not make give this method the name canInteractWith because it clashes
	 * with Container
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.upperChest.isUseableByPlayer(entityplayer) && this.lowerChest.isUseableByPlayer(entityplayer);
	}

	/**
	 * + For tile entities, ensures the chunk containing the tile entity is saved to
	 * disk later - the game won't think it hasn't changed and skip it.
	 */
	@Override
	public void markDirty() {
		this.upperChest.markDirty();
		this.lowerChest.markDirty();
	}

	@Override
	public void openInventory(EntityPlayer entityplayer) {
		this.upperChest.openInventory(entityplayer);
		this.lowerChest.openInventory(entityplayer);
	}

	/**
	 * + Removes a stack from the given slot and returns it.
	 */
	@Override
	public ItemStack removeStackFromSlot(int i) {
		return i >= this.upperChest.getSizeInventory()
				? this.lowerChest.removeStackFromSlot(i - this.upperChest.getSizeInventory())
				: this.upperChest.removeStackFromSlot(i);
	}

	@Override
	public void setField(int var1, int var2) {
	}

	/**
	 * + Sets the given item stack to the specified slot in the inventory (can be
	 * crafting or armor sections).
	 */
	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		if (i >= this.upperChest.getSizeInventory()) {
			this.lowerChest.setInventorySlotContents(i - this.upperChest.getSizeInventory(), itemstack);
		} else {
			this.upperChest.setInventorySlotContents(i, itemstack);
		}

	}

	@Override
	public void setLockCode(LockCode lockcode) {
		this.upperChest.setLockCode(lockcode);
		this.lowerChest.setLockCode(lockcode);
	}
}
