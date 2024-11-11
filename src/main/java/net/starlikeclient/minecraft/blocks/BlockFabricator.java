package net.starlikeclient.minecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.starlikeclient.minecraft.guis.inventory.ContainerFabricator;

public class BlockFabricator extends Block {
	public static class InterfaceCraftingTable implements IInteractionObject {
		private final World world;
		private final BlockPos position;

		public InterfaceCraftingTable(World worldIn, BlockPos pos) {
			this.world = worldIn;
			this.position = pos;
		}

		@Override
		public Container createContainer(InventoryPlayer inventoryplayer, EntityPlayer var2) {
			return new ContainerFabricator(inventoryplayer, this.world, this.position);
		}

		@Override
		public IChatComponent getDisplayName() {
			return new ChatComponentTranslation(Blocks.fabricator.getUnlocalizedName() + ".name", new Object[0]);
		}

		@Override
		public String getGuiID() {
			return "starlike:fabricator";
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		public boolean hasCustomName() {
			return false;
		}
	}

	public BlockFabricator() {
		super(Material.wood);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundTypePiston);
		this.setCreativeTab(CreativeTabs.tabStarlike);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos blockpos, IBlockState var3, EntityPlayer entityplayer,
			EnumFacing var5, float var6, float var7, float var8) {
		if (world.isRemote) {
			return true;
		} else {
			entityplayer.displayGui(new BlockFabricator.InterfaceCraftingTable(world, blockpos));
			entityplayer.triggerAchievement(StatList.field_181742_Z);
			return true;
		}
	}
}
