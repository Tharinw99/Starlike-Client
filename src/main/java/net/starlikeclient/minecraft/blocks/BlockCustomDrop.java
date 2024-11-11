package net.starlikeclient.minecraft.blocks;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockCustomDrop extends Block {
	private Item itemDropped;

	public BlockCustomDrop(Block blockDropped, Material materialIn) {
		this(Item.getItemFromBlock(blockDropped), materialIn);
	}

	public BlockCustomDrop(Block blockDropped, Material parMaterial, MapColor parMapColor) {
		this(Item.getItemFromBlock(blockDropped), parMaterial, parMapColor);
	}

	public BlockCustomDrop(Item itemDropped, Material materialIn) {
		super(materialIn);
		this.itemDropped = itemDropped;
	}

	public BlockCustomDrop(Item itemDropped, Material parMaterial, MapColor parMapColor) {
		super(parMaterial, parMapColor);
		this.itemDropped = itemDropped;
	}

	@Override
	public Item getItemDropped(IBlockState iblockstate, EaglercraftRandom var2, int var3) {
		return this.itemDropped;
	}
}
