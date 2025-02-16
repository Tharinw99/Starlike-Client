package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

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
public class InventoryCrafting implements IInventory {
	private final ItemStack[] stackList;
	private final int inventoryWidth;
	private final int inventoryHeight;
	private final Container eventHandler;

	public InventoryCrafting(Container eventHandlerIn, int width, int height) {
		int i = width * height;
		this.stackList = new ItemStack[i];
		this.eventHandler = eventHandlerIn;
		this.inventoryWidth = width;
		this.inventoryHeight = height;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.stackList.length; ++i) {
			this.stackList[i] = null;
		}

	}

	@Override
	public void closeInventory(EntityPlayer var1) {
	}

	/**
	 * + Removes up to a specified number of items from an inventory slot and
	 * returns them in a new stack.
	 */
	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.stackList[i] != null) {
			if (this.stackList[i].stackSize <= j) {
				ItemStack itemstack1 = this.stackList[i];
				this.stackList[i] = null;
				this.eventHandler.onCraftMatrixChanged(this);
				return itemstack1;
			} else {
				ItemStack itemstack = this.stackList[i].splitStack(j);
				if (this.stackList[i].stackSize == 0) {
					this.stackList[i] = null;
				}

				this.eventHandler.onCraftMatrixChanged(this);
				return itemstack;
			}
		} else {
			return null;
		}
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

	public int getHeight() {
		return this.inventoryHeight;
	}

	/**
	 * + Returns the maximum stack size for a inventory slot. Seems to always be 64,
	 * possibly will be extended.
	 */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	/**
	 * + Gets the name of this command sender (usually username, but possibly
	 * "Rcon")
	 */
	@Override
	public String getName() {
		return "container.crafting";
	}

	/**
	 * + Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return this.stackList.length;
	}

	/**
	 * + Returns the itemstack in the slot specified (Top left is 0, 0). Args: row,
	 * column
	 */
	public ItemStack getStackInRowAndColumn(int row, int column) {
		return row >= 0 && row < this.inventoryWidth && column >= 0 && column <= this.inventoryHeight
				? this.getStackInSlot(row + column * this.inventoryWidth)
				: null;
	}

	/**
	 * + Returns the stack in the given slot.
	 */
	@Override
	public ItemStack getStackInSlot(int i) {
		return i >= this.getSizeInventory() ? null : this.stackList[i];
	}

	public int getWidth() {
		return this.inventoryWidth;
	}

	/**
	 * + Returns true if this thing is named
	 */
	@Override
	public boolean hasCustomName() {
		return false;
	}

	/**
	 * + Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}

	/**
	 * + Do not make give this method the name canInteractWith because it clashes
	 * with Container
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	/**
	 * + For tile entities, ensures the chunk containing the tile entity is saved to
	 * disk later - the game won't think it hasn't changed and skip it.
	 */
	@Override
	public void markDirty() {
	}

	@Override
	public void openInventory(EntityPlayer var1) {
	}

	/**
	 * + Removes a stack from the given slot and returns it.
	 */
	@Override
	public ItemStack removeStackFromSlot(int i) {
		if (this.stackList[i] != null) {
			ItemStack itemstack = this.stackList[i];
			this.stackList[i] = null;
			return itemstack;
		} else {
			return null;
		}
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
		this.stackList[i] = itemstack;
		this.eventHandler.onCraftMatrixChanged(this);
	}
}
