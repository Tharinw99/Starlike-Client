package net.starlikeclient.minecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.starlikeclient.minecraft.guis.GuiHelper;

public class BlockSmithing extends Block {
	public BlockSmithing() {
		super(Material.wood);
		this.setHardness(2.5F);
		this.setStepSound(soundTypeWood);
		this.setCreativeTab(CreativeTabs.tabStarlike);
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		GuiHelper.openGuiSmithing(worldIn, pos, playerIn);
		return true;
	}
}