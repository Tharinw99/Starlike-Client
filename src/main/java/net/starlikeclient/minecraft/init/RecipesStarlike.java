package net.starlikeclient.minecraft.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.starlikeclient.minecraft.blocks.BlockMosaic;
import net.starlikeclient.minecraft.guis.crafting.SmithingManager;

public class RecipesStarlike {
	public static void addCraftingRecipes(CraftingManager e) {
		addIngotRecipe(e, Blocks.netherite_block, Items.netherite_ingot);
		addIngotRecipe(e, Blocks.steel_block, Items.steel);
		addIngotRecipe(e, Blocks.platinum_block, Items.platinum_ingot);
		addIngotRecipe(e, Blocks.titanium_block, Items.titanium_ingot);
		addIngotRecipe(e, Blocks.uranium_block, Items.uranium_crystal);
		addIngotRecipe(e, Blocks.dragonite_block, Items.dragonite);

		e.addRecipe(new ItemStack(Blocks.steel_grate, 4),
				new Object[] { " S ", "S S", " S ", Character.valueOf('S'), Items.steel });
		e.addRecipe(new ItemStack(Items.platinum_sword, 1), new Object[] { "P", "P", "B", Character.valueOf('P'),
				Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		e.addRecipe(new ItemStack(Items.platinum_pickaxe, 1), new Object[] { "PPP", " B ", " B ",
				Character.valueOf('P'), Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		e.addRecipe(new ItemStack(Items.platinum_shovel, 1), new Object[] { "P", "B", "B", Character.valueOf('P'),
				Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		e.addRecipe(new ItemStack(Items.platinum_axe, 1), new Object[] { " PP", " BP", " B ", Character.valueOf('P'),
				Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		e.addRecipe(new ItemStack(Items.platinum_hoe, 1), new Object[] { " PP", " B ", " B ", Character.valueOf('P'),
				Items.platinum_ingot, Character.valueOf('B'), Items.blaze_rod });
		e.addRecipe(new ItemStack(Items.platinum_helmet, 1),
				new Object[] { "PPP", "P P", Character.valueOf('P'), Items.platinum_ingot });
		e.addRecipe(new ItemStack(Items.platinum_chestplate, 1),
				new Object[] { "P P", "PPP", "PPP", Character.valueOf('P'), Items.platinum_ingot });
		e.addRecipe(new ItemStack(Items.platinum_leggings, 1),
				new Object[] { "PPP", "P P", "P P", Character.valueOf('P'), Items.platinum_ingot });
		e.addRecipe(new ItemStack(Items.platinum_boots, 1),
				new Object[] { "P P", "P P", Character.valueOf('P'), Items.platinum_ingot });
		e.addRecipe(new ItemStack(Items.uranium_rod, 1),
				new Object[] { "U", "U", "U", Character.valueOf('U'), Items.uranium_crystal, });
		e.addRecipe(new ItemStack(Items.platinum_drill, 1),
				new Object[] { " PP", "SSP", "US ", Character.valueOf('P'), Items.platinum_ingot,
						Character.valueOf('S'), Blocks.steel_block, Character.valueOf('U'), Items.uranium_rod });
		e.addRecipe(new ItemStack(Items.titanium_drill, 1), new Object[] { "TTT", "TDT", "TTT", Character.valueOf('T'),
				Items.titanium_ingot, Character.valueOf('D'), Items.platinum_drill });
		for (BlockPlanks.EnumType variant : BlockPlanks.EnumType.values()) {
			e.addRecipe(new ItemStack(Blocks.mosaic, 4, BlockMosaic.EnumType.valueOf(variant.name()).getMetadata()),
					new Object[] { " # ", "# #", " # ", Character.valueOf('#'),
							new ItemStack(Blocks.planks, 1, variant.getMetadata()) });
		}
		e.addRecipe(new ItemStack(Blocks.dragon_egg, 2), new Object[] { "DDD", "DED", "DDD", Character.valueOf('E'),
				Blocks.dragon_egg, Character.valueOf('D'), Blocks.dragonite_block });
		e.addShapelessRecipe(new ItemStack(Items.netherite_ingot, 1),
				new Object[] { new ItemStack(Items.netherite_scrap, 1), new ItemStack(Items.netherite_scrap, 1),
						new ItemStack(Items.netherite_scrap, 1), new ItemStack(Items.netherite_scrap, 1),
						new ItemStack(Items.gold_ingot, 1), new ItemStack(Items.gold_ingot, 1),
						new ItemStack(Items.gold_ingot, 1), new ItemStack(Items.gold_ingot, 1) });
		e.addRecipe(new ItemStack(Items.chisel, 1), new Object[] { "  #", " / ", "/  ", Character.valueOf('#'),
				Items.steel, Character.valueOf('/'), Items.stick });
		e.addRecipe(new ItemStack(Blocks.smithing_table), new Object[] { "//", "##", "##", Character.valueOf('/'),
				Items.iron_ingot, Character.valueOf('#'), Blocks.planks });

		// Copper
		e.addRecipe(new ItemStack(Blocks.copper_block, 1),
				new Object[] { "###", "###", "###", Character.valueOf('#'), Items.copper_ingot });
		e.addRecipe(new ItemStack(Blocks.cut_copper, 1),
				new Object[] { "#C#", "CCC", "#C#", Character.valueOf('C'), Items.copper_ingot, });
		e.addRecipe(new ItemStack(Blocks.chiseled_copper, 1),
				new Object[] { "#C#", "C#C", "#C#", Character.valueOf('C'), Items.copper_ingot, });
		e.addRecipe(new ItemStack(Blocks.copper_grate, 1),
				new Object[] { "CCC", "C#C", "CCC", Character.valueOf('C'), Items.copper_ingot, });
		e.addRecipe(new ItemStack(Blocks.exposed_copper, 8), new Object[] { "###", "#W#", "###", Character.valueOf('W'),
				Items.water_bucket, Character.valueOf('#'), Blocks.copper_block });
		e.addRecipe(new ItemStack(Blocks.weathered_copper, 8), new Object[] { "###", "#E#", "###",
				Character.valueOf('E'), Blocks.exposed_copper, Character.valueOf('#'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.oxidized_copper, 8), new Object[] { "###", "#W#", "###",
				Character.valueOf('W'), Blocks.weathered_copper, Character.valueOf('#'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.exposed_cut_copper, 8), new Object[] { "###", "#W#", "###",
				Character.valueOf('#'), Blocks.cut_copper, Character.valueOf('W'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.weathered_cut_copper, 8), new Object[] { "###", "#E#", "###",
				Character.valueOf('E'), Blocks.exposed_cut_copper, Character.valueOf('#'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.oxidized_cut_copper, 8), new Object[] { "###", "#W#", "###",
				Character.valueOf('W'), Blocks.weathered_cut_copper, Character.valueOf('#'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.exposed_chiseled_copper, 8), new Object[] { "###", "#W#", "###",
				Character.valueOf('#'), Blocks.chiseled_copper, Character.valueOf('W'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.weathered_chiseled_copper, 8), new Object[] { "###", "#E#", "###",
				Character.valueOf('E'), Blocks.exposed_chiseled_copper, Character.valueOf('#'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.oxidized_chiseled_copper, 8), new Object[] { "###", "#W#", "###",
				Character.valueOf('W'), Blocks.weathered_chiseled_copper, Character.valueOf('#'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.exposed_copper_grate, 8), new Object[] { "###", "#W#", "###",
				Character.valueOf('#'), Blocks.copper_grate, Character.valueOf('W'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.weathered_copper_grate, 8), new Object[] { "###", "#E#", "###",
				Character.valueOf('E'), Blocks.exposed_copper_grate, Character.valueOf('#'), Items.water_bucket });
		e.addRecipe(new ItemStack(Blocks.oxidized_copper_grate, 8), new Object[] { "###", "#W#", "###",
				Character.valueOf('W'), Blocks.weathered_copper_grate, Character.valueOf('#'), Items.water_bucket });

		// Terracotta
		e.addRecipe(new ItemStack(Blocks.packed_terracotta, 1),
				new Object[] { "##", "##", Character.valueOf('#'), Blocks.hardened_clay });
		for (EnumDyeColor color : EnumDyeColor.values()) {
			String colorName = color.getName();
			e.addRecipe(
					new ItemStack(Block.getBlockFromName(
							"starlike:" + (colorName == "silver" ? "light_gray" : colorName) + "_packed_terracotta"),
							1),
					new Object[] { "##", "##", Character.valueOf('#'),
							new ItemStack(Blocks.stained_hardened_clay, 1, color.getMetadata()) });
		}
	}

	public static void addFurnaceRecipes(FurnaceRecipes e) {
		e.addSmeltingRecipeForBlock(Blocks.coal_ore, new ItemStack(Items.coal), 0.1F);
		e.addSmeltingRecipeForBlock(Blocks.redstone_ore, new ItemStack(Items.redstone), 0.7F);
		e.addSmeltingRecipeForBlock(Blocks.lapis_ore, new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()),
				0.2F);
		e.addSmeltingRecipeForBlock(Blocks.quartz_ore, new ItemStack(Items.quartz), 0.2F);

		e.addSmeltingRecipeForBlock(Blocks.cobbled_deepslate, new ItemStack(Blocks.deepslate), 0.1F);
		e.addSmelting(Items.iron_ingot, new ItemStack(Items.steel), 1.2F);
		e.addSmeltingRecipeForBlock(Blocks.platinum_ore, new ItemStack(Items.platinum_ingot), 1.5F);
		e.addSmeltingRecipeForBlock(Blocks.titanium_ore, new ItemStack(Items.titanium_ingot), 2.0F);
		e.addSmeltingRecipeForBlock(Blocks.uranium_ore, new ItemStack(Items.uranium_crystal), 0.2F);
		e.addSmeltingRecipeForBlock(Blocks.copper_ore, new ItemStack(Items.copper_ingot), 0.15F);
		e.addSmeltingRecipeForBlock(Blocks.deepslate_copper_ore, new ItemStack(Items.copper_ingot), 0.15F);
		e.addSmeltingRecipeForBlock(Blocks.ancient_debris, new ItemStack(Items.netherite_scrap), 2.0F);
	}

	private static void addIngotRecipe(CraftingManager e, Block block, Item item) {
		ItemStack itemstack = new ItemStack(item, 9);
		e.addRecipe(new ItemStack(block), new Object[] { "###", "###", "###", Character.valueOf('#'), itemstack });
		e.addRecipe(itemstack, new Object[] { "#", Character.valueOf('#'), block });
	}

	private static void addIngotRecipe(CraftingManager e, Block block, ItemStack itemstack) {
		e.addRecipe(new ItemStack(block), new Object[] { "###", "###", "###", Character.valueOf('#'), itemstack });
		e.addRecipe(itemstack, new Object[] { "#", Character.valueOf('#'), block });
	}

	public static void addSmithingRecipes(SmithingManager e) {
		e.addSmithingRecipe(new ItemStack(Items.diamond_sword), new ItemStack(Items.netherite_sword));
		e.addSmithingRecipe(new ItemStack(Items.diamond_pickaxe), new ItemStack(Items.netherite_pickaxe));
		e.addSmithingRecipe(new ItemStack(Items.diamond_axe), new ItemStack(Items.netherite_axe));
		e.addSmithingRecipe(new ItemStack(Items.diamond_shovel), new ItemStack(Items.netherite_shovel));
		e.addSmithingRecipe(new ItemStack(Items.diamond_hoe), new ItemStack(Items.netherite_hoe));
		e.addSmithingRecipe(new ItemStack(Items.diamond_helmet), new ItemStack(Items.netherite_helmet));
		e.addSmithingRecipe(new ItemStack(Items.diamond_chestplate), new ItemStack(Items.netherite_chestplate));
		e.addSmithingRecipe(new ItemStack(Items.diamond_leggings), new ItemStack(Items.netherite_leggings));
		e.addSmithingRecipe(new ItemStack(Items.diamond_boots), new ItemStack(Items.netherite_boots));
	}
}