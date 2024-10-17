package net.starlikeclient.minecraft.guis.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class FabricatorManager {
	private static FabricatorManager instance;

	/**
	 * + Returns the static instance of this class
	 */
	public static FabricatorManager getInstance() {
		if (instance == null) {
			instance = new FabricatorManager();
		}
		return instance;
	}

	/**
	 * + A list of all the recipes added
	 */
	private final List<IRecipe> recipes = Lists.newArrayList();

	private FabricatorManager() {
		this.addRecipe(new ItemStack(Items.steel, 1),
				new Object[] { "///", " / ", "/_/", Character.valueOf('/'), Items.stick, Character.valueOf('_'),
						new ItemStack(Blocks.stone, 1, BlockStoneSlab.EnumType.STONE.getMetadata()) });
		Collections.sort(this.recipes, new Comparator<IRecipe>() {
			public int compare(IRecipe parIRecipe, IRecipe parIRecipe2) {
				return parIRecipe instanceof ShapelessRecipes && parIRecipe2 instanceof ShapedRecipes ? 1
						: (parIRecipe2 instanceof ShapelessRecipes && parIRecipe instanceof ShapedRecipes ? -1
								: (parIRecipe2.getRecipeSize() < parIRecipe.getRecipeSize() ? -1
										: (parIRecipe2.getRecipeSize() > parIRecipe.getRecipeSize() ? 1 : 0)));
			}
		});
	}

	/**
	 * + Adds an IRecipe to the list of crafting recipes.
	 */
	public void addRecipe(IRecipe recipe) {
		this.recipes.add(recipe);
	}

	/**
	 * + Adds an IRecipe to the list of crafting recipes.
	 */
	public ShapedRecipes addRecipe(ItemStack stack, Object... recipeComponents) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;
		if (recipeComponents[i] instanceof String[]) {
			String[] astring = (String[]) ((String[]) recipeComponents[i++]);

			for (int l = 0; l < astring.length; ++l) {
				String s2 = astring[l];
				++k;
				j = s2.length();
				s = s + s2;
			}
		} else {
			while (recipeComponents[i] instanceof String) {
				String s1 = (String) recipeComponents[i++];
				++k;
				j = s1.length();
				s = s + s1;
			}
		}

		HashMap hashmap;
		for (hashmap = Maps.newHashMap(); i < recipeComponents.length; i += 2) {
			Character character = (Character) recipeComponents[i];
			ItemStack itemstack = null;
			if (recipeComponents[i + 1] instanceof Item) {
				itemstack = new ItemStack((Item) recipeComponents[i + 1]);
			} else if (recipeComponents[i + 1] instanceof Block) {
				itemstack = new ItemStack((Block) recipeComponents[i + 1], 1, 32767);
			} else if (recipeComponents[i + 1] instanceof ItemStack) {
				itemstack = (ItemStack) recipeComponents[i + 1];
			}

			hashmap.put(character, itemstack);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);
			if (hashmap.containsKey(Character.valueOf(c0))) {
				aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).copy();
			} else {
				aitemstack[i1] = null;
			}
		}

		ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, stack);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	/**
	 * + Adds a shapeless crafting recipe to the the game.
	 */
	public void addShapelessRecipe(ItemStack stack, Object... recipeComponents) {
		ArrayList arraylist = Lists.newArrayList();

		for (int i = 0; i < recipeComponents.length; ++i) {
			Object object = recipeComponents[i];
			if (object instanceof ItemStack) {
				arraylist.add(((ItemStack) object).copy());
			} else if (object instanceof Item) {
				arraylist.add(new ItemStack((Item) object));
			} else {
				if (!(object instanceof Block)) {
					throw new IllegalArgumentException(
							"Invalid shapeless recipe: unknown type " + object.getClass().getName() + "!");
				}

				arraylist.add(new ItemStack((Block) object));
			}
		}

		this.recipes.add(new ShapelessRecipes(stack, arraylist));
	}

	/**
	 * + Retrieves an ItemStack that has multiple recipes for it.
	 */
	public ItemStack findMatchingRecipe(InventoryCrafting worldIn, World parWorld) {
		for (int i = 0, l = this.recipes.size(); i < l; ++i) {
			IRecipe irecipe = this.recipes.get(i);
			if (irecipe.matches(worldIn, parWorld)) {
				return irecipe.getCraftingResult(worldIn);
			}
		}

		return null;
	}

	public ItemStack[] func_180303_b(InventoryCrafting worldIn, World parWorld) {
		for (int i = 0, l = this.recipes.size(); i < l; ++i) {
			IRecipe irecipe = this.recipes.get(i);
			if (irecipe.matches(worldIn, parWorld)) {
				return irecipe.getRemainingItems(worldIn);
			}
		}

		ItemStack[] aitemstack = new ItemStack[worldIn.getSizeInventory()];

		for (int i = 0; i < aitemstack.length; ++i) {
			aitemstack[i] = worldIn.getStackInSlot(i);
		}

		return aitemstack;
	}

	/**
	 * + returns the List<> of all recipes
	 */
	public List<IRecipe> getRecipeList() {
		return this.recipes;
	}
}