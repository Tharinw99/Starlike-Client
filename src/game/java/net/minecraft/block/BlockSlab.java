package net.minecraft.block;

import java.util.List;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * + This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source
 * code.
 *
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!" Mod
 * Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 *
 * EaglercraftX 1.8 patch files (c) 2022-2025 lax1dude, ayunami2000. All Rights
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
public abstract class BlockSlab extends Block {
	public static enum EnumBlockHalf implements IStringSerializable {
		TOP("top"), BOTTOM("bottom");

		private final String name;

		private EnumBlockHalf(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	public static PropertyEnum<BlockSlab.EnumBlockHalf> HALF;

	public static void bootstrapStates() {
		HALF = PropertyEnum.<BlockSlab.EnumBlockHalf>create("half", BlockSlab.EnumBlockHalf.class);
	}

	protected static boolean isSlab(Block blockIn) {
		return blockIn == Blocks.stone_slab || blockIn == Blocks.wooden_slab || blockIn == Blocks.stone_slab2;
	}

	public BlockSlab(Material materialIn) {
		super(materialIn);
		if (this.isDouble()) {
			this.fullBlock = true;
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

		this.setLightOpacity(255);
	}

	/**
	 * + Add all collision boxes of this Block to the list that intersect with the
	 * given mask.
	 */
	@Override
	public void addCollisionBoxesToList(World world, BlockPos blockpos, IBlockState iblockstate,
			AxisAlignedBB axisalignedbb, List<AxisAlignedBB> list, Entity entity) {
		this.setBlockBoundsBasedOnState(world, blockpos);
		super.addCollisionBoxesToList(world, blockpos, iblockstate, axisalignedbb, list, entity);
	}

	@Override
	public boolean alfheim$useNeighborBrightness(final IBlockState blockState, final EnumFacing facing,
			final IBlockAccess blockAccess, final BlockPos blockPos) {
		if (isFullCube())
			return false;

		if (facing.getAxis() != EnumFacing.Axis.Y)
			return true;

		return facing == (blockState.getValue(HALF) == EnumBlockHalf.TOP ? EnumFacing.DOWN : EnumFacing.UP);
	}

	@Override
	protected boolean canSilkHarvest() {
		return false;
	}

	@Override
	public int getDamageValue(World world, BlockPos blockpos) {
		return super.getDamageValue(world, blockpos) & 7;
	}

	public abstract String getUnlocalizedName(int var1);

	public abstract Object getVariant(ItemStack var1);

	public abstract IProperty<?> getVariantProperty();

	public abstract boolean isDouble();

	@Override
	public boolean isFullCube() {
		return this.isDouble();
	}

	/**
	 * + Used to determine ambient occlusion and culling when rebuilding chunks for
	 * render
	 */
	@Override
	public boolean isOpaqueCube() {
		return this.isDouble();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos blockpos, IBlockState var3, EntityPlayer entityplayer,
			EnumFacing var5, float var6, float var7, float var8) {
		if (!world.isRemote && MinecraftServer.getServer().worldServers[0].getWorldInfo().getGameRulesInstance()
				.getBoolean("clickToSit") && entityplayer.getHeldItem() == null) {
			EntityArrow arrow = new EntityArrow(world, blockpos.getX() + 0.5D, blockpos.getY(), blockpos.getZ() + 0.5D);
			arrow.isChair = true;
			world.spawnEntityInWorld(arrow);
			entityplayer.mountEntity(arrow);
			return true;
		}
		return super.onBlockActivated(world, blockpos, var3, entityplayer, var5, var6, var7, var8);
	}

	/**
	 * + Called by ItemBlocks just before a block is actually set in the world, to
	 * allow for adjustments to the IBlockstate
	 */
	@Override
	public IBlockState onBlockPlaced(World world, BlockPos blockpos, EnumFacing enumfacing, float f, float f1, float f2,
			int i, EntityLivingBase entitylivingbase) {
		IBlockState iblockstate = super.onBlockPlaced(world, blockpos, enumfacing, f, f1, f2, i, entitylivingbase)
				.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
		return this.isDouble() ? iblockstate
				: (enumfacing != EnumFacing.DOWN && (enumfacing == EnumFacing.UP || (double) f1 <= 0.5D) ? iblockstate
						: iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.TOP));
	}

	/**
	 * + Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(EaglercraftRandom var1) {
		return this.isDouble() ? 2 : 1;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, BlockPos blockpos) {
		if (this.isDouble()) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			IBlockState iblockstate = iblockaccess.getBlockState(blockpos);
			if (iblockstate.getBlock() == this) {
				if (iblockstate.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
					this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
				} else {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
				}
			}

		}
	}

	/**
	 * + Sets the block's bounds for rendering it as an item
	 */
	@Override
	public void setBlockBoundsForItemRender() {
		if (this.isDouble()) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, BlockPos blockpos, EnumFacing enumfacing) {
		if (this.isDouble()) {
			return super.shouldSideBeRendered(iblockaccess, blockpos, enumfacing);
		} else if (enumfacing != EnumFacing.UP && enumfacing != EnumFacing.DOWN
				&& !super.shouldSideBeRendered(iblockaccess, blockpos, enumfacing)) {
			return false;
		} else {
			BlockPos blockpos1 = blockpos.offset(enumfacing.getOpposite());
			IBlockState iblockstate = iblockaccess.getBlockState(blockpos);
			IBlockState iblockstate1 = iblockaccess.getBlockState(blockpos1);
			boolean flag = isSlab(iblockstate.getBlock()) && iblockstate.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP;
			boolean flag1 = isSlab(iblockstate1.getBlock())
					&& iblockstate1.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP;
			return flag1
					? (enumfacing == EnumFacing.DOWN ? true
							: (enumfacing == EnumFacing.UP
									&& super.shouldSideBeRendered(iblockaccess, blockpos, enumfacing) ? true
											: !isSlab(iblockstate.getBlock()) || !flag))
					: (enumfacing == EnumFacing.UP ? true
							: (enumfacing == EnumFacing.DOWN
									&& super.shouldSideBeRendered(iblockaccess, blockpos, enumfacing) ? true
											: !isSlab(iblockstate.getBlock()) || flag));
		}
	}
}
