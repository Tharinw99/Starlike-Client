package net.starlikeclient.minecraft.crafting;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipesBackpackUpgrade implements IRecipe {
	private static class BackpackUpgradeRecipe {
		private final Item material;
		private final Item result;

		BackpackUpgradeRecipe(Item material, Item result) {
			this.material = material;
			this.result = result;
		}

		public Item getMaterial() {
			return this.material;
		}

		public Item getResult() {
			return this.result;
		}
	}

	private static final Map<Item, BackpackUpgradeRecipe> backpackRecipes = new HashMap<>(
			Map.of(Item.getItemFromBlock(Blocks.chest),
					new BackpackUpgradeRecipe(Items.leather, Items.leather_backpack), Items.leather_backpack,
					new BackpackUpgradeRecipe(Item.getItemFromBlock(Blocks.steel_block), Items.iron_backpack),
					Items.iron_backpack,
					new BackpackUpgradeRecipe(Item.getItemFromBlock(Blocks.diamond_block), Items.diamond_backpack),
					Item.getItemFromBlock(Blocks.ender_chest),
					new BackpackUpgradeRecipe(Item.getItemFromBlock(Blocks.dragonite_block), Items.ender_backpack)));

	/**
	 * + Returns an Item that is the result of this recipe
	 */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) {
		ItemStack centerSlotItem = inventorycrafting.getStackInSlot(4);
		ItemStack result = new ItemStack(backpackRecipes.get(centerSlotItem.getItem()).getResult(), 1,
				centerSlotItem.getMetadata());
		if (centerSlotItem.hasTagCompound()) {
			result.setTagCompound((NBTTagCompound) centerSlotItem.getTagCompound().copy());
		}
		if (centerSlotItem.hasDisplayName()) {
			result.setStackDisplayName(centerSlotItem.getDisplayName());
		}
		return result;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return null;
	}

	/**
	 * + Returns the size of the recipe area
	 */
	@Override
	public int getRecipeSize() {
		return 9;
	}

	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting inventorycrafting) {
		ItemStack[] aitemstack = new ItemStack[inventorycrafting.getSizeInventory()];

		for (int i = 0; i < aitemstack.length; ++i) {
			ItemStack itemstack = inventorycrafting.getStackInSlot(i);
			if (itemstack != null && itemstack.getItem().hasContainerItem()) {
				aitemstack[i] = new ItemStack(itemstack.getItem().getContainerItem());
			}
		}

		return aitemstack;
	}

	/**
	 * + Used to check if a recipe matches current crafting inventory
	 */
	@Override
	public boolean matches(InventoryCrafting inventorycrafting, World world) {
		if (inventorycrafting.getSizeInventory() == 9) {
			ItemStack itemstack = inventorycrafting.getStackInSlot(4);
			if (itemstack != null && backpackRecipes.containsKey(itemstack.getItem())) {
				BackpackUpgradeRecipe upgradeRecipe = backpackRecipes.get(itemstack.getItem());
				Item recipeMaterial = upgradeRecipe.getMaterial();

				for (int i = 0; i < 9; ++i) {
					if (i == 4) {
						continue;
					}
					ItemStack itemstack1 = inventorycrafting.getStackInSlot(i);
					if (itemstack1 == null || itemstack1.getItem() != recipeMaterial) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
