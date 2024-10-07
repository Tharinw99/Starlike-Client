package net.minecraft.item.crafting;

import net.minecraft.block.BlockMosaic;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * + This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source
 * code.
 * 
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!" Mod
 * Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 * 
 * EaglercraftX 1.8 patch files (c) 2022-2024 lax1dude, ayunami2000. All Rights
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
public class RecipesCrafting {
	/**
	 * + Adds the crafting recipes to the CraftingManager.
	 */
	public void addRecipes(CraftingManager parCraftingManager) {
		parCraftingManager.addRecipe(new ItemStack(Items.steel, 1), new Object[] { "III", "ICI", "III",
				Character.valueOf('I'), Items.iron_ingot, Character.valueOf('C'), Items.coal });
		parCraftingManager.addRecipe(new ItemStack(Blocks.steel_grate, 4),
				new Object[] { "SSS", "S S", "SSS", Character.valueOf('S'), Items.steel });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_sword, 1), new Object[] { "P", "P", "B",
				Character.valueOf('P'), Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_pickaxe, 1), new Object[] { "PPP", " B ", " B ",
				Character.valueOf('P'), Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_shovel, 1), new Object[] { "P", "B", "B",
				Character.valueOf('P'), Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_axe, 1), new Object[] { "PP ", "PB ", " B ",
				Character.valueOf('P'), Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_axe, 1), new Object[] { " PP", " BP", " B ",
				Character.valueOf('P'), Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_hoe, 1), new Object[] { "PP ", " B ", " B ",
				Character.valueOf('P'), Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_hoe, 1), new Object[] { " PP", " B ", " B ",
				Character.valueOf('P'), Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_helmet, 1),
				new Object[] { "PPP", "P P", Character.valueOf('P'), Items.platinum_ingot });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_chestplate, 1),
				new Object[] { "P P", "PPP", "PPP", Character.valueOf('P'), Items.platinum_ingot });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_leggings, 1),
				new Object[] { "PPP", "P P", "P P", Character.valueOf('P'), Items.platinum_ingot });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_boots, 1),
				new Object[] { "P P", "P P", Character.valueOf('P'), Items.platinum_ingot });
		parCraftingManager.addRecipe(new ItemStack(Items.uranium_rod, 1),
				new Object[] { "U", "U", "U", Character.valueOf('U'), Items.uranium_crystal, });
		parCraftingManager.addRecipe(new ItemStack(Items.platinum_drill, 1),
				new Object[] { " PP", "SUP", "SS ", Character.valueOf('P'), Items.platinum_ingot,
						Character.valueOf('S'), Items.steel, Character.valueOf('U'), Items.uranium_rod });
		parCraftingManager.addRecipe(new ItemStack(Items.titanium_drill, 1), new Object[] { "TTT", "TDT", "TTT",
				Character.valueOf('T'), Items.titanium_ingot, Character.valueOf('D'), Items.platinum_drill });
		/*
		parCraftingManager.addRecipe(new ItemStack(Blocks.mosaic, 4, BlockMosaic.EnumType.OAK.getMetadata()),
				new Object[] { "##", "##", Character.valueOf('#'),
						new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.OAK.getMetadata()) });
		parCraftingManager.addRecipe(new ItemStack(Blocks.mosaic, 4, BlockMosaic.EnumType.SPRUCE.getMetadata()),
				new Object[] { "##", "##", Character.valueOf('#'),
						new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.SPRUCE.getMetadata()) });
		parCraftingManager.addRecipe(new ItemStack(Blocks.mosaic, 4, BlockMosaic.EnumType.BIRCH.getMetadata()),
				new Object[] { "##", "##", Character.valueOf('#'),
						new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.BIRCH.getMetadata()) });
		parCraftingManager.addRecipe(new ItemStack(Blocks.mosaic, 4, BlockMosaic.EnumType.JUNGLE.getMetadata()),
				new Object[] { "##", "##", Character.valueOf('#'),
						new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.JUNGLE.getMetadata()) });
		parCraftingManager.addRecipe(new ItemStack(Blocks.mosaic, 4, BlockMosaic.EnumType.ACACIA.getMetadata()),
				new Object[] { "##", "##", Character.valueOf('#'),
						new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.ACACIA.getMetadata()) });
		parCraftingManager.addRecipe(new ItemStack(Blocks.mosaic, 4, BlockMosaic.EnumType.DARK_OAK.getMetadata()),
				new Object[] { "##", "##", Character.valueOf('#'),
						new ItemStack(Blocks.planks, 1, BlockPlanks.EnumType.DARK_OAK.getMetadata()) });
		*/
	}
}