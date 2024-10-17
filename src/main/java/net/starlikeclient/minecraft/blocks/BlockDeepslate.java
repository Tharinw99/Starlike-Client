package net.starlikeclient.minecraft.blocks;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockDeepslate extends Block {
	public BlockDeepslate() {
		super(Material.rock);
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundTypePiston);
		this.setCreativeTab(CreativeTabs.tabStarlike);
	}

	public Item getItemDropped(IBlockState iblockstate, EaglercraftRandom var2, int var3) {
		return this == Blocks.deepslate ? Item.getItemFromBlock(Blocks.cobbled_deepslate) : Item.getItemFromBlock(this);
	}
}