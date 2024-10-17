package net.starlikeclient.minecraft.items;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockQuartz;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemChisel extends Item {
	private static final Map<IBlockState, IBlockState> blockReplacementMap = new HashMap<>();
	static {
		// Copper
		blockReplacementMap.put(Blocks.copper_block.getDefaultState(), Blocks.chiseled_copper.getDefaultState());
		blockReplacementMap.put(Blocks.weathered_copper.getDefaultState(),
				Blocks.weathered_chiseled_copper.getDefaultState());
		blockReplacementMap.put(Blocks.exposed_copper.getDefaultState(),
				Blocks.exposed_chiseled_copper.getDefaultState());
		blockReplacementMap.put(Blocks.oxidized_copper.getDefaultState(),
				Blocks.oxidized_chiseled_copper.getDefaultState());

		// Ocean Bricks
		blockReplacementMap.put(Blocks.deep_ocean_bricks.getDefaultState(),
				Blocks.chiseled_deep_ocean_bricks.getDefaultState());

		// Sandstone
		blockReplacementMap.put(
				Blocks.sandstone.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.DEFAULT),
				Blocks.sandstone.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.CHISELED));
		blockReplacementMap.put(
				Blocks.sandstone.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.CHISELED),
				Blocks.creeper_chiseled_sandstone.getDefaultState());

		// Red Sandstone
		blockReplacementMap.put(
				Blocks.red_sandstone.getDefaultState().withProperty(BlockRedSandstone.TYPE,
						BlockRedSandstone.EnumType.DEFAULT),
				Blocks.red_sandstone.getDefaultState().withProperty(BlockRedSandstone.TYPE,
						BlockRedSandstone.EnumType.CHISELED));
		blockReplacementMap.put(Blocks.red_sandstone.getDefaultState().withProperty(BlockRedSandstone.TYPE,
				BlockRedSandstone.EnumType.CHISELED), Blocks.skeleton_chiseled_red_sandstone.getDefaultState());

		// Stone Bricks
		blockReplacementMap.put(
				Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT,
						BlockStoneBrick.EnumType.DEFAULT),
				Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT,
						BlockStoneBrick.EnumType.CRACKED));
		blockReplacementMap.put(
				Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT,
						BlockStoneBrick.EnumType.CRACKED),
				Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT,
						BlockStoneBrick.EnumType.CHISELED));
		blockReplacementMap.put(Blocks.stonebrick.getDefaultState().withProperty(BlockStoneBrick.VARIANT,
				BlockStoneBrick.EnumType.CHISELED), Blocks.zombie_chiseled_stone_bricks.getDefaultState());

		// Soul Stone
		blockReplacementMap.put(Blocks.soul_stone.getDefaultState(), Blocks.cobbled_soul_stone.getDefaultState());
		blockReplacementMap.put(Blocks.cobbled_soul_stone.getDefaultState(), Blocks.soul_stone_tiles.getDefaultState());

		// Deepslate
		blockReplacementMap.put(Blocks.deepslate.getDefaultState(), Blocks.cobbled_deepslate.getDefaultState());
		blockReplacementMap.put(Blocks.cobbled_deepslate.getDefaultState(),
				Blocks.head_chiseled_deepslate.getDefaultState());

		// Quartz
		blockReplacementMap.put(
				Blocks.quartz_block.getDefaultState().withProperty(BlockQuartz.VARIANT, BlockQuartz.EnumType.DEFAULT),
				Blocks.quartz_block.getDefaultState().withProperty(BlockQuartz.VARIANT, BlockQuartz.EnumType.CHISELED));
		blockReplacementMap.put(
				Blocks.quartz_block.getDefaultState().withProperty(BlockQuartz.VARIANT, BlockQuartz.EnumType.CHISELED),
				Blocks.ghast_chiseled_quartz_block.getDefaultState());

		// Gold Blocks
		blockReplacementMap.put(Blocks.gold_block.getDefaultState(), Blocks.gold_tiles.getDefaultState());

		// Stone
		blockReplacementMap.put(
				Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE),
				Blocks.cobblestone.getDefaultState());
		blockReplacementMap.put(Blocks.cobblestone.getDefaultState(), Blocks.stone_tiles.getDefaultState());

		// Granite
		blockReplacementMap.put(
				Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE),
				Blocks.cobbled_granite.getDefaultState());
		blockReplacementMap.put(
				Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH),
				Blocks.polished_granite_brick.getDefaultState());

		// Diorite
		blockReplacementMap.put(
				Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE),
				Blocks.cobbled_diorite.getDefaultState());
		blockReplacementMap.put(Blocks.cobbled_diorite.getDefaultState(), Blocks.diorite_tiles.getDefaultState());
		blockReplacementMap.put(
				Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH),
				Blocks.polished_diorite_brick.getDefaultState());

		// Andesite
		blockReplacementMap.put(
				Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE),
				Blocks.cobbled_andesite.getDefaultState());
		blockReplacementMap.put(Blocks.cobbled_andesite.getDefaultState(), Blocks.andesite_tiles.getDefaultState());
		blockReplacementMap.put(Blocks.andesite_tiles.getDefaultState(), Blocks.andesite_bricks.getDefaultState());
		blockReplacementMap.put(
				Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH),
				Blocks.polished_andesite_brick.getDefaultState());

		// Limestone
		blockReplacementMap.put(Blocks.limestone.getDefaultState(), Blocks.limestone_tiles.getDefaultState());

		// Blackstone
		blockReplacementMap.put(Blocks.blackstone.getDefaultState(), Blocks.cracked_blackstone.getDefaultState());
		blockReplacementMap.put(Blocks.polished_blackstone.getDefaultState(),
				Blocks.polished_blackstone_bricks.getDefaultState());
		blockReplacementMap.put(Blocks.polished_blackstone_bricks.getDefaultState(),
				Blocks.cracked_polished_blackstone_bricks.getDefaultState());
		blockReplacementMap.put(Blocks.cracked_polished_blackstone_bricks.getDefaultState(),
				Blocks.chiseled_polished_blackstone.getDefaultState());

		// Tuff
		blockReplacementMap.put(Blocks.tuff.getDefaultState(), Blocks.tuff_tiles.getDefaultState());
		blockReplacementMap.put(Blocks.tuff_tiles.getDefaultState(), Blocks.tuff_bricks.getDefaultState());
		blockReplacementMap.put(Blocks.tuff_bricks.getDefaultState(), Blocks.chiseled_tuff_bricks.getDefaultState());
		blockReplacementMap.put(Blocks.chiseled_tuff_bricks.getDefaultState(), Blocks.chiseled_tuff.getDefaultState());
		blockReplacementMap.put(Blocks.chiseled_tuff.getDefaultState(), Blocks.chiseled_tuff_top.getDefaultState());

		// Calcite
		blockReplacementMap.put(Blocks.calcite.getDefaultState(), Blocks.calcite_tiles.getDefaultState());

		// Planks
		for (BlockPlanks.EnumType variant : BlockPlanks.EnumType.values()) {
			blockReplacementMap.put(Blocks.planks.getDefaultState().withProperty(BlockPlanks.VARIANT, variant),
					Block.getBlockFromName("starlike:decorated_" + variant.getName() + "_planks").getDefaultState());
		}

		// Terracotta
		blockReplacementMap.put(Blocks.hardened_clay.getDefaultState(), Blocks.terracotta_bricks.getDefaultState());
		for (EnumDyeColor color : EnumDyeColor.values()) {
			String colorName = color.getName();
			blockReplacementMap.put(
					Blocks.stained_hardened_clay.getDefaultState().withProperty(BlockColored.COLOR, color),
					Block.getBlockFromName("starlike:"
							+ (colorName.toLowerCase() == "silver" ? "light_gray" : colorName) + "_terracotta_bricks")
							.getDefaultState());
		}
	}

	public ItemChisel() {
		this.setMaxStackSize(1);
		this.setMaxDamage(212);
		this.setCreativeTab(CreativeTabs.tabStarlike);
	}

	/**
	 * + returns the action that specifies what animation to play when the items is
	 * being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack var1) {
		return EnumAction.CHISEL;
	}

	/**
	 * + How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack var1) {
		return 32;
	}

	/**
	 * + Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, entityplayer, false);
		if (movingObjectPosition != null
				&& movingObjectPosition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			BlockPos blockPos = movingObjectPosition.getBlockPos();
			IBlockState blockState = world.getBlockState(blockPos);
			if (blockReplacementMap.containsKey(blockState)) {
				entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
			}
		}
		return itemstack;
	}

	/**
	 * + Called when the player finishes using this Item (E.g. finishes eating.).
	 * Not called when the player stops using the Item before the action is
	 * complete.
	 */
	@Override
	public ItemStack onItemUseFinish(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, entityplayer, false);
		if (movingObjectPosition != null
				&& movingObjectPosition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			BlockPos blockPos = movingObjectPosition.getBlockPos();
			IBlockState blockState = world.getBlockState(blockPos);
			if (blockReplacementMap.containsKey(blockState)) {
				world.setBlockState(blockPos, blockReplacementMap.get(blockState));
				itemstack.damageItem(1, entityplayer);
			}
		}
		return itemstack;
	}
}