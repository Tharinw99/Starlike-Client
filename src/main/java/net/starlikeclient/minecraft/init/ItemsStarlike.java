package net.starlikeclient.minecraft.init;

import com.google.common.base.Function;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.starlikeclient.minecraft.blocks.BlockDeepslate;
import net.starlikeclient.minecraft.blocks.BlockMosaic;
import net.starlikeclient.minecraft.blocks.BlockSmithing;
import net.starlikeclient.minecraft.blocks.BlockSteelGrate;
import net.starlikeclient.minecraft.items.ItemBackpack;
import net.starlikeclient.minecraft.items.ItemChisel;
import net.starlikeclient.minecraft.items.ItemEnderBackpack;

public class ItemsStarlike {
	private static void blockBootstrapStates() {
		BlockMosaic.bootstrapStates();
	}

	public static void registerBlocks() {
		blockBootstrapStates();
		Block.registerBlock(512, "starlike:deepslate", (new BlockDeepslate()).setUnlocalizedName("deepslate"));
		Block.registerBlock(513, "starlike:cobbled_deepslate",
				(new Block(Material.rock)).setHardness(3.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston)
						.setUnlocalizedName("cobbled_deepslate").setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(514, "starlike:steel_block",
				(new Block(Material.iron, MapColor.ironColor)).setHardness(5.0F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("steel_block")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(515, "starlike:steel_grate", (new BlockSteelGrate()).setUnlocalizedName("steel_grate"));
		Block.registerBlock(516, "starlike:platinum_ore",
				(new BlockOre()).setHardness(50.0F).setResistance(250.0F).setStepSound(Block.soundTypePiston)
						.setUnlocalizedName("platinum_ore").setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(517, "starlike:platinum_block",
				(new Block(Material.iron, MapColor.ironColor)).setHardness(15.0F).setResistance(30.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("platinum_block")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(518, "starlike:titanium_ore",
				(new BlockOre()).setHardness(100.0F).setResistance(500.0F).setStepSound(Block.soundTypePiston)
						.setUnlocalizedName("titanium_ore").setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(519, "starlike:titanium_block",
				(new Block(Material.iron, MapColor.ironColor)).setHardness(25.0F).setResistance(50.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("titanium_block")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(520, "starlike:uranium_ore",
				(new BlockOre()).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston)
						.setUnlocalizedName("uranium_ore").setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(521, "starlike:uranium_block",
				(new Block(Material.iron, MapColor.greenColor)).setHardness(40.0F).setResistance(80.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("uranium_block")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(522, "starlike:mosaic", (new BlockMosaic()).setUnlocalizedName("mosaic"));
		Block.registerBlock(523, "starlike:dragonite_block",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(60.0F).setResistance(120.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("dragonite_block")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(684, "starlike:ancient_debris",
				(new Block(Material.iron, MapColor.blackColor)).setHardness(30.0F).setResistance(2000.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("ancient_debris")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(685, "starlike:netherite_block",
				(new Block(Material.iron, MapColor.blackColor)).setHardness(50.0F).setResistance(2000.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("netherite_block")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(686, "starlike:smithing_table", (new BlockSmithing()).setUnlocalizedName("smithing_table"));
		// Block.registerBlock(687, "starlike:fabricator", (new
		// BlockFabricator()).setUnlocalizedName("fabricator"));

//autogenerateequals
		Block.registerBlock(694, "starlike:stripped_spruce_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(5.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("stripped_spruce_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(693, "starlike:stripped_oak_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(5.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("stripped_oak_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(692, "starlike:stripped_jungle_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(5.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("stripped_jungle_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(691, "starlike:stripped_dark_oak_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(5.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("stripped_dark_oak_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(690, "starlike:stripped_birch_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(5.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("stripped_birch_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(689, "starlike:stripped_acacia_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(5.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("stripped_acacia_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(688, (String) "starlike:dirt_path",
				(new Block(Material.ground, MapColor.dirtColor)).setHardness(0.5F).setStepSound(Block.soundTypeGravel)
						.setUnlocalizedName("dirt_path").setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(683, "starlike:tuff_tiles",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("tuff_tiles")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(682, "starlike:soul_stone_tiles",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("soul_stone_tiles")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(681, "starlike:soul_stone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("soul_stone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(680, "starlike:smooth_basalt",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("smooth_basalt")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(679, "starlike:limestone_tiles",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("limestone_tiles")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(678, "starlike:limestone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("limestone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(677, "starlike:cobbled_soul_stone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("cobbled_soul_stone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(676, "starlike:chiseled_warped_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_warped_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(675, "starlike:chiseled_spruce_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_spruce_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(674, "starlike:chiseled_oak_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_oak_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(673, "starlike:chiseled_mangrove_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_mangrove_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(672, "starlike:chiseled_jungle_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_jungle_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(671, "starlike:chiseled_dark_oak_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_dark_oak_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(670, "starlike:chiseled_crimson_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_crimson_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(669, "starlike:chiseled_cherry_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_cherry_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(668, "starlike:chiseled_birch_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_birch_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(667, "starlike:chiseled_bamboo_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_bamboo_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(666, "starlike:chiseled_acacia_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("chiseled_acacia_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(665, "starlike:calcite_tiles",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("calcite_tiles")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(664, "starlike:calcite",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("calcite")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(663, "starlike:andesite_tiles",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("andesite_tiles")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(660, "starlike:polished_blackstone_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("polished_blackstone_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(659, "starlike:polished_blackstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("polished_blackstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(658, "starlike:gilded_blackstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("gilded_blackstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(657, "starlike:cracked_polished_blackstone_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("cracked_polished_blackstone_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(656, "starlike:cracked_blackstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("cracked_blackstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(655, "starlike:chiseled_polished_blackstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("chiseled_polished_blackstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(654, "starlike:blackstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("blackstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(653, "starlike:tuff_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("tuff_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(652, "starlike:tuff",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("tuff")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(651, "starlike:polished_tuff",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("polished_tuff")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(650, "starlike:chiseled_tuff_top",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("chiseled_tuff_top")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(649, "starlike:chiseled_tuff_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("chiseled_tuff_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(648, "starlike:chiseled_tuff",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("chiseled_tuff")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(647, "starlike:polished_granite_brick",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("polished_granite_brick")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(646, "starlike:polished_diorite_brick",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("polished_diorite_brick")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(645, "starlike:polished_andesite_brick",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("polished_andesite_brick")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(644, "starlike:cobbled_granite",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("cobbled_granite")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(643, "starlike:cobbled_diorite",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("cobbled_diorite")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(642, "starlike:cobbled_andesite",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("cobbled_andesite")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(641, "starlike:ornate_sandstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("ornate_sandstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(640, "starlike:ornate_red_sandstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("ornate_red_sandstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(639, "starlike:decorated_sandstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("decorated_sandstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(638, "starlike:decorated_red_sandstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("decorated_red_sandstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(637, "starlike:yellow_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("yellow_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(636, "starlike:white_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("white_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(635, "starlike:red_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("red_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(634, "starlike:purple_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("purple_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(633, "starlike:pink_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("pink_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(632, "starlike:orange_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("orange_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(631, "starlike:magenta_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("magenta_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(630, "starlike:lime_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("lime_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(629, "starlike:light_gray_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("light_gray_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(628, "starlike:light_blue_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("light_blue_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(627, "starlike:green_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("green_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(626, "starlike:gray_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("gray_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(625, "starlike:cyan_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("cyan_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(624, "starlike:brown_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("brown_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(623, "starlike:blue_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("blue_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(622, "starlike:black_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(0.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeWood).setUnlocalizedName("black_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(621, "starlike:yellow_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("yellow_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(620, "starlike:yellow_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("yellow_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(619, "starlike:yellow_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("yellow_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(618, "starlike:white_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("white_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(617, "starlike:white_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("white_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(616, "starlike:white_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("white_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(615, "starlike:terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(614, "starlike:red_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("red_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(613, "starlike:red_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("red_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(612, "starlike:red_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("red_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(611, "starlike:purple_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("purple_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(610, "starlike:purple_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("purple_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(609, "starlike:purple_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("purple_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(608, "starlike:pink_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("pink_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(607, "starlike:pink_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("pink_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(606, "starlike:pink_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("pink_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(605, "starlike:packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(604, "starlike:orange_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("orange_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(603, "starlike:orange_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("orange_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(602, "starlike:orange_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("orange_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(601, "starlike:magenta_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("magenta_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(600, "starlike:magenta_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("magenta_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(599, "starlike:magenta_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("magenta_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(598, "starlike:lime_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("lime_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(597, "starlike:lime_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("lime_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(596, "starlike:lime_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("lime_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(595, "starlike:light_gray_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("light_gray_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(594, "starlike:light_gray_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("light_gray_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(593, "starlike:light_gray_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("light_gray_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(592, "starlike:light_blue_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("light_blue_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(591, "starlike:light_blue_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("light_blue_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(590, "starlike:light_blue_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("light_blue_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(589, "starlike:green_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("green_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(588, "starlike:green_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("green_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(587, "starlike:green_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("green_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(586, "starlike:gray_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("gray_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(585, "starlike:gray_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("gray_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(584, "starlike:gray_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("gray_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(583, "starlike:cyan_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("cyan_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(582, "starlike:cyan_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("cyan_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(581, "starlike:cyan_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("cyan_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(580, "starlike:brown_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("brown_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(579, "starlike:brown_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("brown_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(578, "starlike:brown_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("brown_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(577, "starlike:blue_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("blue_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(576, "starlike:blue_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("blue_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(575, "starlike:blue_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("blue_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(574, "starlike:black_terracotta_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("black_terracotta_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(573, "starlike:black_packed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("black_packed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(572, "starlike:black_glazed_terracotta",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("black_glazed_terracotta")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(571, "starlike:zombie_chiseled_stone_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("zombie_chiseled_stone_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(570, "starlike:skeleton_chiseled_red_sandstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("skeleton_chiseled_red_sandstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(569, "starlike:head_chiseled_deepslate",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("head_chiseled_deepslate")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(568, "starlike:ghast_chiseled_quartz_block",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("ghast_chiseled_quartz_block")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(567, "starlike:creeper_chiseled_sandstone",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5f).setResistance(10.0f)
						.setStepSound(Block.soundTypePiston).setUnlocalizedName("creeper_chiseled_sandstone")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(547, "starlike:stone_tiles",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("stone_tiles")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(546, "starlike:gold_tiles",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("gold_tiles")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(545, "starlike:diorite_tiles",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("diorite_tiles")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(544, "starlike:deep_ocean_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("deep_ocean_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(543, "starlike:decorated_stripped_spruce_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_stripped_spruce_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(542, "starlike:decorated_stripped_oak_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_stripped_oak_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(541, "starlike:decorated_stripped_jungle_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_stripped_jungle_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(540, "starlike:decorated_stripped_dark_oak_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_stripped_dark_oak_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(539, "starlike:decorated_stripped_birch_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_stripped_birch_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(538, "starlike:decorated_stripped_acacia_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_stripped_acacia_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(537, "starlike:decorated_spruce_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_spruce_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(536, "starlike:decorated_spruce_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_spruce_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(535, "starlike:decorated_oak_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_oak_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(534, "starlike:decorated_oak_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_oak_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(533, "starlike:decorated_jungle_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_jungle_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(532, "starlike:decorated_jungle_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_jungle_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(531, "starlike:decorated_dark_oak_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_dark_oak_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(530, "starlike:decorated_dark_oak_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_dark_oak_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(529, "starlike:decorated_birch_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_birch_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(528, "starlike:decorated_birch_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_birch_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(527, "starlike:decorated_acacia_planks",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_acacia_planks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(526, "starlike:decorated_acacia_log",
				(new Block(Material.wood, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("decorated_acacia_log")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(525, "starlike:chiseled_deep_ocean_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("chiseled_deep_ocean_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(524, "starlike:andesite_bricks",
				(new Block(Material.rock, MapColor.purpleColor)).setHardness(1.5F).setResistance(10.0F)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("andesite_bricks")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(566, "starlike:weathered_cut_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("weathered_cut_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(565, "starlike:weathered_copper_grate",
				(new BlockSteelGrate()).setHardness(5f).setResistance(10.0f).setStepSound(Block.soundTypeMetal)
						.setUnlocalizedName("weathered_copper_grate").setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(564, "starlike:weathered_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("weathered_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(563, "starlike:weathered_chiseled_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("weathered_chiseled_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(562, "starlike:raw_copper_block",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("raw_copper_block")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(561, "starlike:oxidized_cut_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("oxidized_cut_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(560, "starlike:oxidized_copper_grate",
				(new BlockSteelGrate()).setHardness(5f).setResistance(10.0f).setStepSound(Block.soundTypeMetal)
						.setUnlocalizedName("oxidized_copper_grate").setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(559, "starlike:oxidized_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("oxidized_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(558, "starlike:oxidized_chiseled_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("oxidized_chiseled_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(557, "starlike:exposed_cut_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("exposed_cut_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(556, "starlike:exposed_copper_grate",
				(new BlockSteelGrate().setHardness(5f).setResistance(10.0f).setStepSound(Block.soundTypeMetal)
						.setUnlocalizedName("exposed_copper_grate").setCreativeTab(CreativeTabs.tabStarlike)));
		Block.registerBlock(555, "starlike:exposed_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("exposed_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(554, "starlike:exposed_chiseled_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("exposed_chiseled_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(553, "starlike:deepslate_copper_ore",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("deepslate_copper_ore")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(552, "starlike:cut_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("cut_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(551, "starlike:copper_ore",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("copper_ore")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(550, "starlike:copper_grate",
				(new BlockSteelGrate().setHardness(5f).setResistance(10.0f).setStepSound(Block.soundTypeMetal)
						.setUnlocalizedName("copper_grate").setCreativeTab(CreativeTabs.tabStarlike)));
		Block.registerBlock(549, "starlike:copper_block",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("copper_block")
						.setCreativeTab(CreativeTabs.tabStarlike));
		Block.registerBlock(548, "starlike:chiseled_copper",
				(new Block(Material.iron, MapColor.purpleColor)).setHardness(5f).setResistance(10.0f)
						.setStepSound(Block.soundTypeMetal).setUnlocalizedName("chiseled_copper")
						.setCreativeTab(CreativeTabs.tabStarlike));
	}

	public static void registerItems() {
		Item.registerItemBlock(Blocks.deepslate);
		Item.registerItemBlock(Blocks.cobbled_deepslate);
		Item.registerItemBlock(Blocks.steel_block);
		Item.registerItemBlock(Blocks.steel_grate);
		Item.registerItemBlock(Blocks.platinum_ore);
		Item.registerItemBlock(Blocks.platinum_block);
		Item.registerItemBlock(Blocks.titanium_ore);
		Item.registerItemBlock(Blocks.titanium_block);
		Item.registerItemBlock(Blocks.uranium_ore);
		Item.registerItemBlock(Blocks.uranium_block);
		Item.registerItemBlock(Blocks.mosaic,
				(new ItemMultiTexture(Blocks.mosaic, Blocks.mosaic, new Function<ItemStack, String>() {
					@Override
					public String apply(ItemStack itemstack) {
						return BlockMosaic.EnumType.byMetadata(itemstack.getMetadata()).getUnlocalizedName();
					}
				})).setUnlocalizedName("mosaic"));
		Item.registerItemBlock(Blocks.dragonite_block);
		Item.registerItemBlock(Blocks.ancient_debris).setIsImmuneToFire(true);
		Item.registerItemBlock(Blocks.netherite_block).setIsImmuneToFire(true);
		Item.registerItemBlock(Blocks.smithing_table);
		// Item.registerItemBlock(Blocks.fabricator);

		Item.registerItem(1024, "starlike:steel",
				(new Item()).setUnlocalizedName("steel").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1025, "starlike:platinum_ingot",
				(new Item()).setUnlocalizedName("platinum_ingot").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1026, "starlike:platinum_sword", (new ItemSword(Item.ToolMaterial.PLATINUM))
				.setUnlocalizedName("platinum_sword").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1027, "starlike:platinum_pickaxe", (new ItemPickaxe(Item.ToolMaterial.PLATINUM))
				.setUnlocalizedName("platinum_pickaxe").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1028, "starlike:platinum_shovel", (new ItemSpade(Item.ToolMaterial.PLATINUM))
				.setUnlocalizedName("platinum_shovel").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1029, "starlike:platinum_axe", (new ItemAxe(Item.ToolMaterial.PLATINUM))
				.setUnlocalizedName("platinum_axe").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1030, "starlike:platinum_hoe", (new ItemHoe(Item.ToolMaterial.PLATINUM))
				.setUnlocalizedName("platinum_hoe").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1031, "starlike:platinum_helmet", (new ItemArmor(ItemArmor.ArmorMaterial.PLATINUM, 6, 0))
				.setUnlocalizedName("platinum_helmet").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1032, "starlike:platinum_chestplate", (new ItemArmor(ItemArmor.ArmorMaterial.PLATINUM, 6, 1))
				.setUnlocalizedName("platinum_chestplate").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1033, "starlike:platinum_leggings", (new ItemArmor(ItemArmor.ArmorMaterial.PLATINUM, 6, 2))
				.setUnlocalizedName("platinum_leggings").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1034, "starlike:platinum_boots", (new ItemArmor(ItemArmor.ArmorMaterial.PLATINUM, 6, 3))
				.setUnlocalizedName("platinum_boots").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1035, "starlike:titanium_ingot",
				(new Item()).setUnlocalizedName("titanium_ingot").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1036, "starlike:uranium_crystal",
				(new Item()).setUnlocalizedName("uranium_crystal").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1037, "starlike:uranium_rod",
				(new Item()).setUnlocalizedName("uranium_rod").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1038, "starlike:platinum_drill", (new ItemPickaxe(Item.ToolMaterial.PLATINUM_DRILL))
				.setUnlocalizedName("platinum_drill").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1039, "starlike:titanium_drill", (new ItemPickaxe(Item.ToolMaterial.TITANIUM_DRILL))
				.setUnlocalizedName("titanium_drill").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1040, "starlike:dragonite",
				(new Item()).setUnlocalizedName("dragonite").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1041, "starlike:copper_ingot",
				(new Item()).setUnlocalizedName("copper_ingot").setCreativeTab(CreativeTabs.tabStarlike));
		Item.registerItem(1042, "starlike:netherite_scrap", (new Item()).setUnlocalizedName("netherite_scrap")
				.setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1043, "starlike:netherite_ingot", (new Item()).setUnlocalizedName("netherite_ingot")
				.setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1044, "starlike:netherite_sword",
				(new ItemSword(Item.ToolMaterial.NETHERITE)).setUnlocalizedName("netherite_sword")
						.setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1045, "starlike:netherite_shovel",
				(new ItemSpade(Item.ToolMaterial.NETHERITE)).setUnlocalizedName("netherite_shovel")
						.setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1046, "starlike:netherite_pickaxe",
				(new ItemPickaxe(Item.ToolMaterial.NETHERITE)).setUnlocalizedName("netherite_pickaxe")
						.setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1047, "starlike:netherite_axe", (new ItemAxe(Item.ToolMaterial.NETHERITE))
				.setUnlocalizedName("netherite_axe").setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1048, "starlike:netherite_hoe", (new ItemHoe(Item.ToolMaterial.NETHERITE))
				.setUnlocalizedName("netherite_hoe").setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1049, "starlike:netherite_helmet",
				(new ItemArmor(ItemArmor.ArmorMaterial.NETHERITE, 5, 0)).setUnlocalizedName("netherite_helmet")
						.setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1050, "starlike:netherite_chestplate",
				(new ItemArmor(ItemArmor.ArmorMaterial.NETHERITE, 5, 1)).setUnlocalizedName("netherite_chestplate")
						.setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1051, "starlike:netherite_leggings",
				(new ItemArmor(ItemArmor.ArmorMaterial.NETHERITE, 5, 2)).setUnlocalizedName("netherite_leggings")
						.setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1052, "starlike:netherite_boots",
				(new ItemArmor(ItemArmor.ArmorMaterial.NETHERITE, 5, 3)).setUnlocalizedName("netherite_boots")
						.setCreativeTab(CreativeTabs.tabStarlike).setIsImmuneToFire(true));
		Item.registerItem(1053, "starlike:chisel", (new ItemChisel()).setUnlocalizedName("chisel"));
		// Item.registerItem(1054, "starlike:amber", (new
		// Item()).setUnlocalizedName("amber").setCreativeTab(CreativeTabs.tabStarlike));
		// Item.registerItem(1055, "starlike:ambered_bow", (new ItemBow(1.5,
		// 576)).setUnlocalizedName("ambered_bow"));
		// Reserve 1060-1069 for backpacks
		Item.registerItem(1060, "starlike:leather_backpack",
				(new ItemBackpack(1)).setUnlocalizedName("leather_backpack"));
		Item.registerItem(1061, "starlike:iron_backpack", (new ItemBackpack(2)).setUnlocalizedName("iron_backpack"));
		Item.registerItem(1062, "starlike:diamond_backpack",
				(new ItemBackpack(3)).setUnlocalizedName("diamond_backpack"));
		Item.registerItem(1069, "starlike:ender_backpack",
				(new ItemEnderBackpack()).setUnlocalizedName("ender_backpack"));

//autogenerateregisterblock
		Item.registerItemBlock(Blocks.stripped_spruce_log);
		Item.registerItemBlock(Blocks.stripped_oak_log);
		Item.registerItemBlock(Blocks.stripped_jungle_log);
		Item.registerItemBlock(Blocks.stripped_dark_oak_log);
		Item.registerItemBlock(Blocks.stripped_birch_log);
		Item.registerItemBlock(Blocks.stripped_acacia_log);
		Item.registerItemBlock(Blocks.dirt_path);
		Item.registerItemBlock(Blocks.tuff_tiles);
		Item.registerItemBlock(Blocks.soul_stone_tiles);
		Item.registerItemBlock(Blocks.soul_stone);
		Item.registerItemBlock(Blocks.smooth_basalt);
		Item.registerItemBlock(Blocks.limestone_tiles);
		Item.registerItemBlock(Blocks.limestone);
		Item.registerItemBlock(Blocks.cobbled_soul_stone);
		Item.registerItemBlock(Blocks.chiseled_warped_planks);
		Item.registerItemBlock(Blocks.chiseled_spruce_planks);
		Item.registerItemBlock(Blocks.chiseled_oak_planks);
		Item.registerItemBlock(Blocks.chiseled_mangrove_planks);
		Item.registerItemBlock(Blocks.chiseled_jungle_planks);
		Item.registerItemBlock(Blocks.chiseled_dark_oak_planks);
		Item.registerItemBlock(Blocks.chiseled_crimson_planks);
		Item.registerItemBlock(Blocks.chiseled_cherry_planks);
		Item.registerItemBlock(Blocks.chiseled_birch_planks);
		Item.registerItemBlock(Blocks.chiseled_bamboo_planks);
		Item.registerItemBlock(Blocks.chiseled_acacia_planks);
		Item.registerItemBlock(Blocks.calcite_tiles);
		Item.registerItemBlock(Blocks.calcite);
		Item.registerItemBlock(Blocks.andesite_tiles);
		Item.registerItemBlock(Blocks.polished_blackstone_bricks);
		Item.registerItemBlock(Blocks.polished_blackstone);
		Item.registerItemBlock(Blocks.gilded_blackstone);
		Item.registerItemBlock(Blocks.cracked_polished_blackstone_bricks);
		Item.registerItemBlock(Blocks.cracked_blackstone);
		Item.registerItemBlock(Blocks.chiseled_polished_blackstone);
		Item.registerItemBlock(Blocks.blackstone);
		Item.registerItemBlock(Blocks.tuff_bricks);
		Item.registerItemBlock(Blocks.tuff);
		Item.registerItemBlock(Blocks.polished_tuff);
		Item.registerItemBlock(Blocks.chiseled_tuff_top);
		Item.registerItemBlock(Blocks.chiseled_tuff_bricks);
		Item.registerItemBlock(Blocks.chiseled_tuff);
		Item.registerItemBlock(Blocks.polished_granite_brick);
		Item.registerItemBlock(Blocks.polished_diorite_brick);
		Item.registerItemBlock(Blocks.polished_andesite_brick);
		Item.registerItemBlock(Blocks.cobbled_granite);
		Item.registerItemBlock(Blocks.cobbled_diorite);
		Item.registerItemBlock(Blocks.cobbled_andesite);
		Item.registerItemBlock(Blocks.ornate_sandstone);
		Item.registerItemBlock(Blocks.ornate_red_sandstone);
		Item.registerItemBlock(Blocks.decorated_sandstone);
		Item.registerItemBlock(Blocks.decorated_red_sandstone);
		Item.registerItemBlock(Blocks.yellow_planks);
		Item.registerItemBlock(Blocks.white_planks);
		Item.registerItemBlock(Blocks.red_planks);
		Item.registerItemBlock(Blocks.purple_planks);
		Item.registerItemBlock(Blocks.pink_planks);
		Item.registerItemBlock(Blocks.orange_planks);
		Item.registerItemBlock(Blocks.magenta_planks);
		Item.registerItemBlock(Blocks.lime_planks);
		Item.registerItemBlock(Blocks.light_gray_planks);
		Item.registerItemBlock(Blocks.light_blue_planks);
		Item.registerItemBlock(Blocks.green_planks);
		Item.registerItemBlock(Blocks.gray_planks);
		Item.registerItemBlock(Blocks.cyan_planks);
		Item.registerItemBlock(Blocks.brown_planks);
		Item.registerItemBlock(Blocks.blue_planks);
		Item.registerItemBlock(Blocks.black_planks);
		Item.registerItemBlock(Blocks.yellow_terracotta_bricks);
		Item.registerItemBlock(Blocks.yellow_packed_terracotta);
		Item.registerItemBlock(Blocks.yellow_glazed_terracotta);
		Item.registerItemBlock(Blocks.white_terracotta_bricks);
		Item.registerItemBlock(Blocks.white_packed_terracotta);
		Item.registerItemBlock(Blocks.white_glazed_terracotta);
		Item.registerItemBlock(Blocks.terracotta_bricks);
		Item.registerItemBlock(Blocks.red_terracotta_bricks);
		Item.registerItemBlock(Blocks.red_packed_terracotta);
		Item.registerItemBlock(Blocks.red_glazed_terracotta);
		Item.registerItemBlock(Blocks.purple_terracotta_bricks);
		Item.registerItemBlock(Blocks.purple_packed_terracotta);
		Item.registerItemBlock(Blocks.purple_glazed_terracotta);
		Item.registerItemBlock(Blocks.pink_terracotta_bricks);
		Item.registerItemBlock(Blocks.pink_packed_terracotta);
		Item.registerItemBlock(Blocks.pink_glazed_terracotta);
		Item.registerItemBlock(Blocks.packed_terracotta);
		Item.registerItemBlock(Blocks.orange_terracotta_bricks);
		Item.registerItemBlock(Blocks.orange_packed_terracotta);
		Item.registerItemBlock(Blocks.orange_glazed_terracotta);
		Item.registerItemBlock(Blocks.magenta_terracotta_bricks);
		Item.registerItemBlock(Blocks.magenta_packed_terracotta);
		Item.registerItemBlock(Blocks.magenta_glazed_terracotta);
		Item.registerItemBlock(Blocks.lime_terracotta_bricks);
		Item.registerItemBlock(Blocks.lime_packed_terracotta);
		Item.registerItemBlock(Blocks.lime_glazed_terracotta);
		Item.registerItemBlock(Blocks.light_gray_terracotta_bricks);
		Item.registerItemBlock(Blocks.light_gray_packed_terracotta);
		Item.registerItemBlock(Blocks.light_gray_glazed_terracotta);
		Item.registerItemBlock(Blocks.light_blue_terracotta_bricks);
		Item.registerItemBlock(Blocks.light_blue_packed_terracotta);
		Item.registerItemBlock(Blocks.light_blue_glazed_terracotta);
		Item.registerItemBlock(Blocks.green_terracotta_bricks);
		Item.registerItemBlock(Blocks.green_packed_terracotta);
		Item.registerItemBlock(Blocks.green_glazed_terracotta);
		Item.registerItemBlock(Blocks.gray_terracotta_bricks);
		Item.registerItemBlock(Blocks.gray_packed_terracotta);
		Item.registerItemBlock(Blocks.gray_glazed_terracotta);
		Item.registerItemBlock(Blocks.cyan_terracotta_bricks);
		Item.registerItemBlock(Blocks.cyan_packed_terracotta);
		Item.registerItemBlock(Blocks.cyan_glazed_terracotta);
		Item.registerItemBlock(Blocks.brown_terracotta_bricks);
		Item.registerItemBlock(Blocks.brown_packed_terracotta);
		Item.registerItemBlock(Blocks.brown_glazed_terracotta);
		Item.registerItemBlock(Blocks.blue_terracotta_bricks);
		Item.registerItemBlock(Blocks.blue_packed_terracotta);
		Item.registerItemBlock(Blocks.blue_glazed_terracotta);
		Item.registerItemBlock(Blocks.black_terracotta_bricks);
		Item.registerItemBlock(Blocks.black_packed_terracotta);
		Item.registerItemBlock(Blocks.black_glazed_terracotta);
		Item.registerItemBlock(Blocks.zombie_chiseled_stone_bricks);
		Item.registerItemBlock(Blocks.skeleton_chiseled_red_sandstone);
		Item.registerItemBlock(Blocks.head_chiseled_deepslate);
		Item.registerItemBlock(Blocks.ghast_chiseled_quartz_block);
		Item.registerItemBlock(Blocks.creeper_chiseled_sandstone);
		Item.registerItemBlock(Blocks.weathered_cut_copper);
		Item.registerItemBlock(Blocks.weathered_copper_grate);
		Item.registerItemBlock(Blocks.weathered_copper);
		Item.registerItemBlock(Blocks.weathered_chiseled_copper);
		Item.registerItemBlock(Blocks.raw_copper_block);
		Item.registerItemBlock(Blocks.oxidized_cut_copper);
		Item.registerItemBlock(Blocks.oxidized_copper_grate);
		Item.registerItemBlock(Blocks.oxidized_copper);
		Item.registerItemBlock(Blocks.oxidized_chiseled_copper);
		Item.registerItemBlock(Blocks.exposed_cut_copper);
		Item.registerItemBlock(Blocks.exposed_copper_grate);
		Item.registerItemBlock(Blocks.exposed_copper);
		Item.registerItemBlock(Blocks.exposed_chiseled_copper);
		Item.registerItemBlock(Blocks.deepslate_copper_ore);
		Item.registerItemBlock(Blocks.cut_copper);
		Item.registerItemBlock(Blocks.copper_ore);
		Item.registerItemBlock(Blocks.copper_grate);
		Item.registerItemBlock(Blocks.copper_block);
		Item.registerItemBlock(Blocks.chiseled_copper);
		Item.registerItemBlock(Blocks.stone_tiles);
		Item.registerItemBlock(Blocks.gold_tiles);
		Item.registerItemBlock(Blocks.diorite_tiles);
		Item.registerItemBlock(Blocks.deep_ocean_bricks);
		Item.registerItemBlock(Blocks.decorated_stripped_spruce_log);
		Item.registerItemBlock(Blocks.decorated_stripped_oak_log);
		Item.registerItemBlock(Blocks.decorated_stripped_jungle_log);
		Item.registerItemBlock(Blocks.decorated_stripped_dark_oak_log);
		Item.registerItemBlock(Blocks.decorated_stripped_birch_log);
		Item.registerItemBlock(Blocks.decorated_stripped_acacia_log);
		Item.registerItemBlock(Blocks.decorated_spruce_planks);
		Item.registerItemBlock(Blocks.decorated_spruce_log);
		Item.registerItemBlock(Blocks.decorated_oak_planks);
		Item.registerItemBlock(Blocks.decorated_oak_log);
		Item.registerItemBlock(Blocks.decorated_jungle_planks);
		Item.registerItemBlock(Blocks.decorated_jungle_log);
		Item.registerItemBlock(Blocks.decorated_dark_oak_planks);
		Item.registerItemBlock(Blocks.decorated_dark_oak_log);
		Item.registerItemBlock(Blocks.decorated_birch_planks);
		Item.registerItemBlock(Blocks.decorated_birch_log);
		Item.registerItemBlock(Blocks.decorated_acacia_planks);
		Item.registerItemBlock(Blocks.decorated_acacia_log);
		Item.registerItemBlock(Blocks.chiseled_deep_ocean_bricks);
		Item.registerItemBlock(Blocks.andesite_bricks);

	}

	public static void renderItems(RenderItem e) {
		e.registerBlock(Blocks.deepslate, "starlike:deepslate");
		e.registerBlock(Blocks.cobbled_deepslate, "starlike:cobbled_deepslate");
		e.registerBlock(Blocks.steel_block, "starlike:steel_block");
		e.registerBlock(Blocks.steel_grate, "starlike:steel_grate");
		e.registerBlock(Blocks.platinum_ore, "starlike:platinum_ore");
		e.registerBlock(Blocks.platinum_block, "starlike:platinum_block");
		e.registerBlock(Blocks.titanium_ore, "starlike:titanium_ore");
		e.registerBlock(Blocks.titanium_block, "starlike:titanium_block");
		e.registerBlock(Blocks.uranium_ore, "starlike:uranium_ore");
		e.registerBlock(Blocks.uranium_block, "starlike:uranium_block");
		e.registerBlock(Blocks.mosaic, BlockMosaic.EnumType.OAK.getMetadata(), "starlike:oak_mosaic");
		e.registerBlock(Blocks.mosaic, BlockMosaic.EnumType.SPRUCE.getMetadata(), "starlike:spruce_mosaic");
		e.registerBlock(Blocks.mosaic, BlockMosaic.EnumType.BIRCH.getMetadata(), "starlike:birch_mosaic");
		e.registerBlock(Blocks.mosaic, BlockMosaic.EnumType.JUNGLE.getMetadata(), "starlike:jungle_mosaic");
		e.registerBlock(Blocks.mosaic, BlockMosaic.EnumType.ACACIA.getMetadata(), "starlike:acacia_mosaic");
		e.registerBlock(Blocks.mosaic, BlockMosaic.EnumType.DARK_OAK.getMetadata(), "starlike:dark_oak_mosaic");
		e.registerBlock(Blocks.dragonite_block, "starlike:dragonite_block");
		e.registerBlock(Blocks.ancient_debris, "starlike:ancient_debris");
		e.registerBlock(Blocks.netherite_block, "starlike:netherite_block");
		e.registerBlock(Blocks.smithing_table, "starlike:smithing_table");
		// e.registerBlock(Blocks.fabricator, "starlike:fabricator");

		e.registerItem(Items.steel, "starlike:steel");
		e.registerItem(Items.platinum_ingot, "starlike:platinum_ingot");
		e.registerItem(Items.platinum_sword, "starlike:platinum_sword");
		e.registerItem(Items.platinum_pickaxe, "starlike:platinum_pickaxe");
		e.registerItem(Items.platinum_shovel, "starlike:platinum_shovel");
		e.registerItem(Items.platinum_axe, "starlike:platinum_axe");
		e.registerItem(Items.platinum_hoe, "starlike:platinum_hoe");
		e.registerItem(Items.platinum_helmet, "starlike:platinum_helmet");
		e.registerItem(Items.platinum_chestplate, "starlike:platinum_chestplate");
		e.registerItem(Items.platinum_leggings, "starlike:platinum_leggings");
		e.registerItem(Items.platinum_boots, "starlike:platinum_boots");
		e.registerItem(Items.titanium_ingot, "starlike:titanium_ingot");
		e.registerItem(Items.uranium_crystal, "starlike:uranium_crystal");
		e.registerItem(Items.uranium_rod, "starlike:uranium_rod");
		e.registerItem(Items.platinum_drill, "starlike:platinum_drill");
		e.registerItem(Items.titanium_drill, "starlike:titanium_drill");
		e.registerItem(Items.dragonite, "starlike:dragonite");
		e.registerItem(Items.copper_ingot, "starlike:copper_ingot");
		e.registerItem(Items.netherite_scrap, "starlike:netherite_scrap");
		e.registerItem(Items.netherite_ingot, "starlike:netherite_ingot");
		e.registerItem(Items.netherite_sword, "starlike:netherite_sword");
		e.registerItem(Items.netherite_shovel, "starlike:netherite_shovel");
		e.registerItem(Items.netherite_pickaxe, "starlike:netherite_pickaxe");
		e.registerItem(Items.netherite_axe, "starlike:netherite_axe");
		e.registerItem(Items.netherite_hoe, "starlike:netherite_hoe");
		e.registerItem(Items.netherite_helmet, "starlike:netherite_helmet");
		e.registerItem(Items.netherite_chestplate, "starlike:netherite_chestplate");
		e.registerItem(Items.netherite_leggings, "starlike:netherite_leggings");
		e.registerItem(Items.netherite_boots, "starlike:netherite_boots");
		e.registerItem(Items.chisel, "starlike:chisel");
		// e.registerItem(Items.amber, "starlike:amber");
		// e.registerItem(Items.ambered_bow, "starlike:ambered_bow");
		e.registerItem(Items.leather_backpack, "starlike:leather_backpack");
		e.registerItem(Items.iron_backpack, "starlike:iron_backpack");
		e.registerItem(Items.diamond_backpack, "starlike:diamond_backpack");
		e.registerItem(Items.ender_backpack, "starlike:ender_backpack");

//autogeneraterenderitem
		e.registerBlock(Blocks.stripped_spruce_log, "starlike:stripped_spruce_log");
		e.registerBlock(Blocks.stripped_oak_log, "starlike:stripped_oak_log");
		e.registerBlock(Blocks.stripped_jungle_log, "starlike:stripped_jungle_log");
		e.registerBlock(Blocks.stripped_dark_oak_log, "starlike:stripped_dark_oak_log");
		e.registerBlock(Blocks.stripped_birch_log, "starlike:stripped_birch_log");
		e.registerBlock(Blocks.stripped_acacia_log, "starlike:stripped_acacia_log");
		e.registerBlock(Blocks.dirt_path, "starlike:dirt_path");
		e.registerBlock(Blocks.tuff_tiles, "starlike:tuff_tiles");
		e.registerBlock(Blocks.soul_stone_tiles, "starlike:soul_stone_tiles");
		e.registerBlock(Blocks.soul_stone, "starlike:soul_stone");
		e.registerBlock(Blocks.smooth_basalt, "starlike:smooth_basalt");
		e.registerBlock(Blocks.limestone_tiles, "starlike:limestone_tiles");
		e.registerBlock(Blocks.limestone, "starlike:limestone");
		e.registerBlock(Blocks.cobbled_soul_stone, "starlike:cobbled_soul_stone");
		e.registerBlock(Blocks.chiseled_warped_planks, "starlike:chiseled_warped_planks");
		e.registerBlock(Blocks.chiseled_spruce_planks, "starlike:chiseled_spruce_planks");
		e.registerBlock(Blocks.chiseled_oak_planks, "starlike:chiseled_oak_planks");
		e.registerBlock(Blocks.chiseled_mangrove_planks, "starlike:chiseled_mangrove_planks");
		e.registerBlock(Blocks.chiseled_jungle_planks, "starlike:chiseled_jungle_planks");
		e.registerBlock(Blocks.chiseled_dark_oak_planks, "starlike:chiseled_dark_oak_planks");
		e.registerBlock(Blocks.chiseled_crimson_planks, "starlike:chiseled_crimson_planks");
		e.registerBlock(Blocks.chiseled_cherry_planks, "starlike:chiseled_cherry_planks");
		e.registerBlock(Blocks.chiseled_birch_planks, "starlike:chiseled_birch_planks");
		e.registerBlock(Blocks.chiseled_bamboo_planks, "starlike:chiseled_bamboo_planks");
		e.registerBlock(Blocks.chiseled_acacia_planks, "starlike:chiseled_acacia_planks");
		e.registerBlock(Blocks.calcite_tiles, "starlike:calcite_tiles");
		e.registerBlock(Blocks.calcite, "starlike:calcite");
		e.registerBlock(Blocks.andesite_tiles, "starlike:andesite_tiles");
		e.registerBlock(Blocks.polished_blackstone_bricks, "starlike:polished_blackstone_bricks");
		e.registerBlock(Blocks.polished_blackstone, "starlike:polished_blackstone");
		e.registerBlock(Blocks.gilded_blackstone, "starlike:gilded_blackstone");
		e.registerBlock(Blocks.cracked_polished_blackstone_bricks, "starlike:cracked_polished_blackstone_bricks");
		e.registerBlock(Blocks.cracked_blackstone, "starlike:cracked_blackstone");
		e.registerBlock(Blocks.chiseled_polished_blackstone, "starlike:chiseled_polished_blackstone");
		e.registerBlock(Blocks.blackstone, "starlike:blackstone");
		e.registerBlock(Blocks.tuff_bricks, "starlike:tuff_bricks");
		e.registerBlock(Blocks.tuff, "starlike:tuff");
		e.registerBlock(Blocks.polished_tuff, "starlike:polished_tuff");
		e.registerBlock(Blocks.chiseled_tuff_top, "starlike:chiseled_tuff_top");
		e.registerBlock(Blocks.chiseled_tuff_bricks, "starlike:chiseled_tuff_bricks");
		e.registerBlock(Blocks.chiseled_tuff, "starlike:chiseled_tuff");
		e.registerBlock(Blocks.polished_granite_brick, "starlike:polished_granite_brick");
		e.registerBlock(Blocks.polished_diorite_brick, "starlike:polished_diorite_brick");
		e.registerBlock(Blocks.polished_andesite_brick, "starlike:polished_andesite_brick");
		e.registerBlock(Blocks.cobbled_granite, "starlike:cobbled_granite");
		e.registerBlock(Blocks.cobbled_diorite, "starlike:cobbled_diorite");
		e.registerBlock(Blocks.cobbled_andesite, "starlike:cobbled_andesite");
		e.registerBlock(Blocks.ornate_sandstone, "starlike:ornate_sandstone");
		e.registerBlock(Blocks.ornate_red_sandstone, "starlike:ornate_red_sandstone");
		e.registerBlock(Blocks.decorated_sandstone, "starlike:decorated_sandstone");
		e.registerBlock(Blocks.decorated_red_sandstone, "starlike:decorated_red_sandstone");
		e.registerBlock(Blocks.yellow_planks, "starlike:yellow_planks");
		e.registerBlock(Blocks.white_planks, "starlike:white_planks");
		e.registerBlock(Blocks.red_planks, "starlike:red_planks");
		e.registerBlock(Blocks.purple_planks, "starlike:purple_planks");
		e.registerBlock(Blocks.pink_planks, "starlike:pink_planks");
		e.registerBlock(Blocks.orange_planks, "starlike:orange_planks");
		e.registerBlock(Blocks.magenta_planks, "starlike:magenta_planks");
		e.registerBlock(Blocks.lime_planks, "starlike:lime_planks");
		e.registerBlock(Blocks.light_gray_planks, "starlike:light_gray_planks");
		e.registerBlock(Blocks.light_blue_planks, "starlike:light_blue_planks");
		e.registerBlock(Blocks.green_planks, "starlike:green_planks");
		e.registerBlock(Blocks.gray_planks, "starlike:gray_planks");
		e.registerBlock(Blocks.cyan_planks, "starlike:cyan_planks");
		e.registerBlock(Blocks.brown_planks, "starlike:brown_planks");
		e.registerBlock(Blocks.blue_planks, "starlike:blue_planks");
		e.registerBlock(Blocks.black_planks, "starlike:black_planks");
		e.registerBlock(Blocks.yellow_terracotta_bricks, "starlike:yellow_terracotta_bricks");
		e.registerBlock(Blocks.yellow_packed_terracotta, "starlike:yellow_packed_terracotta");
		e.registerBlock(Blocks.yellow_glazed_terracotta, "starlike:yellow_glazed_terracotta");
		e.registerBlock(Blocks.white_terracotta_bricks, "starlike:white_terracotta_bricks");
		e.registerBlock(Blocks.white_packed_terracotta, "starlike:white_packed_terracotta");
		e.registerBlock(Blocks.white_glazed_terracotta, "starlike:white_glazed_terracotta");
		e.registerBlock(Blocks.terracotta_bricks, "starlike:terracotta_bricks");
		e.registerBlock(Blocks.red_terracotta_bricks, "starlike:red_terracotta_bricks");
		e.registerBlock(Blocks.red_packed_terracotta, "starlike:red_packed_terracotta");
		e.registerBlock(Blocks.red_glazed_terracotta, "starlike:red_glazed_terracotta");
		e.registerBlock(Blocks.purple_terracotta_bricks, "starlike:purple_terracotta_bricks");
		e.registerBlock(Blocks.purple_packed_terracotta, "starlike:purple_packed_terracotta");
		e.registerBlock(Blocks.purple_glazed_terracotta, "starlike:purple_glazed_terracotta");
		e.registerBlock(Blocks.pink_terracotta_bricks, "starlike:pink_terracotta_bricks");
		e.registerBlock(Blocks.pink_packed_terracotta, "starlike:pink_packed_terracotta");
		e.registerBlock(Blocks.pink_glazed_terracotta, "starlike:pink_glazed_terracotta");
		e.registerBlock(Blocks.packed_terracotta, "starlike:packed_terracotta");
		e.registerBlock(Blocks.orange_terracotta_bricks, "starlike:orange_terracotta_bricks");
		e.registerBlock(Blocks.orange_packed_terracotta, "starlike:orange_packed_terracotta");
		e.registerBlock(Blocks.orange_glazed_terracotta, "starlike:orange_glazed_terracotta");
		e.registerBlock(Blocks.magenta_terracotta_bricks, "starlike:magenta_terracotta_bricks");
		e.registerBlock(Blocks.magenta_packed_terracotta, "starlike:magenta_packed_terracotta");
		e.registerBlock(Blocks.magenta_glazed_terracotta, "starlike:magenta_glazed_terracotta");
		e.registerBlock(Blocks.lime_terracotta_bricks, "starlike:lime_terracotta_bricks");
		e.registerBlock(Blocks.lime_packed_terracotta, "starlike:lime_packed_terracotta");
		e.registerBlock(Blocks.lime_glazed_terracotta, "starlike:lime_glazed_terracotta");
		e.registerBlock(Blocks.light_gray_terracotta_bricks, "starlike:light_gray_terracotta_bricks");
		e.registerBlock(Blocks.light_gray_packed_terracotta, "starlike:light_gray_packed_terracotta");
		e.registerBlock(Blocks.light_gray_glazed_terracotta, "starlike:light_gray_glazed_terracotta");
		e.registerBlock(Blocks.light_blue_terracotta_bricks, "starlike:light_blue_terracotta_bricks");
		e.registerBlock(Blocks.light_blue_packed_terracotta, "starlike:light_blue_packed_terracotta");
		e.registerBlock(Blocks.light_blue_glazed_terracotta, "starlike:light_blue_glazed_terracotta");
		e.registerBlock(Blocks.green_terracotta_bricks, "starlike:green_terracotta_bricks");
		e.registerBlock(Blocks.green_packed_terracotta, "starlike:green_packed_terracotta");
		e.registerBlock(Blocks.green_glazed_terracotta, "starlike:green_glazed_terracotta");
		e.registerBlock(Blocks.gray_terracotta_bricks, "starlike:gray_terracotta_bricks");
		e.registerBlock(Blocks.gray_packed_terracotta, "starlike:gray_packed_terracotta");
		e.registerBlock(Blocks.gray_glazed_terracotta, "starlike:gray_glazed_terracotta");
		e.registerBlock(Blocks.cyan_terracotta_bricks, "starlike:cyan_terracotta_bricks");
		e.registerBlock(Blocks.cyan_packed_terracotta, "starlike:cyan_packed_terracotta");
		e.registerBlock(Blocks.cyan_glazed_terracotta, "starlike:cyan_glazed_terracotta");
		e.registerBlock(Blocks.brown_terracotta_bricks, "starlike:brown_terracotta_bricks");
		e.registerBlock(Blocks.brown_packed_terracotta, "starlike:brown_packed_terracotta");
		e.registerBlock(Blocks.brown_glazed_terracotta, "starlike:brown_glazed_terracotta");
		e.registerBlock(Blocks.blue_terracotta_bricks, "starlike:blue_terracotta_bricks");
		e.registerBlock(Blocks.blue_packed_terracotta, "starlike:blue_packed_terracotta");
		e.registerBlock(Blocks.blue_glazed_terracotta, "starlike:blue_glazed_terracotta");
		e.registerBlock(Blocks.black_terracotta_bricks, "starlike:black_terracotta_bricks");
		e.registerBlock(Blocks.black_packed_terracotta, "starlike:black_packed_terracotta");
		e.registerBlock(Blocks.black_glazed_terracotta, "starlike:black_glazed_terracotta");
		e.registerBlock(Blocks.zombie_chiseled_stone_bricks, "starlike:zombie_chiseled_stone_bricks");
		e.registerBlock(Blocks.skeleton_chiseled_red_sandstone, "starlike:skeleton_chiseled_red_sandstone");
		e.registerBlock(Blocks.head_chiseled_deepslate, "starlike:head_chiseled_deepslate");
		e.registerBlock(Blocks.ghast_chiseled_quartz_block, "starlike:ghast_chiseled_quartz_block");
		e.registerBlock(Blocks.creeper_chiseled_sandstone, "starlike:creeper_chiseled_sandstone");
		e.registerBlock(Blocks.weathered_cut_copper, "starlike:weathered_cut_copper");
		e.registerBlock(Blocks.weathered_copper_grate, "starlike:weathered_copper_grate");
		e.registerBlock(Blocks.weathered_copper, "starlike:weathered_copper");
		e.registerBlock(Blocks.weathered_chiseled_copper, "starlike:weathered_chiseled_copper");
		e.registerBlock(Blocks.raw_copper_block, "starlike:raw_copper_block");
		e.registerBlock(Blocks.raw_copper, "starlike:raw_copper");
		e.registerBlock(Blocks.oxidized_cut_copper, "starlike:oxidized_cut_copper");
		e.registerBlock(Blocks.oxidized_copper_grate, "starlike:oxidized_copper_grate");
		e.registerBlock(Blocks.oxidized_copper, "starlike:oxidized_copper");
		e.registerBlock(Blocks.oxidized_chiseled_copper, "starlike:oxidized_chiseled_copper");
		e.registerBlock(Blocks.exposed_cut_copper, "starlike:exposed_cut_copper");
		e.registerBlock(Blocks.exposed_copper_grate, "starlike:exposed_copper_grate");
		e.registerBlock(Blocks.exposed_copper, "starlike:exposed_copper");
		e.registerBlock(Blocks.exposed_chiseled_copper, "starlike:exposed_chiseled_copper");
		e.registerBlock(Blocks.deepslate_copper_ore, "starlike:deepslate_copper_ore");
		e.registerBlock(Blocks.cut_copper, "starlike:cut_copper");
		e.registerBlock(Blocks.copper_ore, "starlike:copper_ore");
		e.registerBlock(Blocks.copper_grate, "starlike:copper_grate");
		e.registerBlock(Blocks.copper_block, "starlike:copper_block");
		e.registerBlock(Blocks.chiseled_copper, "starlike:chiseled_copper");
		e.registerBlock(Blocks.stone_tiles, "starlike:stone_tiles");
		e.registerBlock(Blocks.gold_tiles, "starlike:gold_tiles");
		e.registerBlock(Blocks.diorite_tiles, "starlike:diorite_tiles");
		e.registerBlock(Blocks.deep_ocean_bricks, "starlike:deep_ocean_bricks");
		e.registerBlock(Blocks.decorated_stripped_spruce_log, "starlike:decorated_stripped_spruce_log");
		e.registerBlock(Blocks.decorated_stripped_oak_log, "starlike:decorated_stripped_oak_log");
		e.registerBlock(Blocks.decorated_stripped_jungle_log, "starlike:decorated_stripped_jungle_log");
		e.registerBlock(Blocks.decorated_stripped_dark_oak_log, "starlike:decorated_stripped_dark_oak_log");
		e.registerBlock(Blocks.decorated_stripped_birch_log, "starlike:decorated_stripped_birch_log");
		e.registerBlock(Blocks.decorated_stripped_acacia_log, "starlike:decorated_stripped_acacia_log");
		e.registerBlock(Blocks.decorated_spruce_planks, "starlike:decorated_spruce_planks");
		e.registerBlock(Blocks.decorated_spruce_log, "starlike:decorated_spruce_log");
		e.registerBlock(Blocks.decorated_oak_planks, "starlike:decorated_oak_planks");
		e.registerBlock(Blocks.decorated_oak_log, "starlike:decorated_oak_log");
		e.registerBlock(Blocks.decorated_jungle_planks, "starlike:decorated_jungle_planks");
		e.registerBlock(Blocks.decorated_jungle_log, "starlike:decorated_jungle_log");
		e.registerBlock(Blocks.decorated_dark_oak_planks, "starlike:decorated_dark_oak_planks");
		e.registerBlock(Blocks.decorated_dark_oak_log, "starlike:decorated_dark_oak_log");
		e.registerBlock(Blocks.decorated_birch_planks, "starlike:decorated_birch_planks");
		e.registerBlock(Blocks.decorated_birch_log, "starlike:decorated_birch_log");
		e.registerBlock(Blocks.decorated_acacia_planks, "starlike:decorated_acacia_planks");
		e.registerBlock(Blocks.decorated_acacia_log, "starlike:decorated_acacia_log");
		e.registerBlock(Blocks.chiseled_deep_ocean_bricks, "starlike:chiseled_deep_ocean_bricks");
		e.registerBlock(Blocks.andesite_bricks, "starlike:andesite_bricks");
	}
}
