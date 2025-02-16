package net.minecraft.block;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.StatCollector;
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
public class BlockFlowerPot extends BlockContainer {
	public static enum EnumFlowerType implements IStringSerializable {
		EMPTY("empty"), POPPY("rose"), BLUE_ORCHID("blue_orchid"), ALLIUM("allium"), HOUSTONIA("houstonia"),
		RED_TULIP("red_tulip"), ORANGE_TULIP("orange_tulip"), WHITE_TULIP("white_tulip"), PINK_TULIP("pink_tulip"),
		OXEYE_DAISY("oxeye_daisy"), DANDELION("dandelion"), OAK_SAPLING("oak_sapling"),
		SPRUCE_SAPLING("spruce_sapling"), BIRCH_SAPLING("birch_sapling"), JUNGLE_SAPLING("jungle_sapling"),
		ACACIA_SAPLING("acacia_sapling"), DARK_OAK_SAPLING("dark_oak_sapling"), MUSHROOM_RED("mushroom_red"),
		MUSHROOM_BROWN("mushroom_brown"), DEAD_BUSH("dead_bush"), FERN("fern"), CACTUS("cactus");

		private final String name;

		private EnumFlowerType(String name) {
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

	public static final PropertyInteger LEGACY_DATA = PropertyInteger.create("legacy_data", 0, 15);

	public static PropertyEnum<BlockFlowerPot.EnumFlowerType> CONTENTS;

	public static void bootstrapStates() {
		CONTENTS = PropertyEnum.<BlockFlowerPot.EnumFlowerType>create("contents", BlockFlowerPot.EnumFlowerType.class);
	}

	public BlockFlowerPot() {
		super(Material.circuits);
		this.setDefaultState(this.blockState.getBaseState().withProperty(CONTENTS, BlockFlowerPot.EnumFlowerType.EMPTY)
				.withProperty(LEGACY_DATA, Integer.valueOf(0)));
		this.setBlockBoundsForItemRender();
	}

	@Override
	public void breakBlock(World world, BlockPos blockpos, IBlockState iblockstate) {
		TileEntityFlowerPot tileentityflowerpot = this.getTileEntity(world, blockpos);
		if (tileentityflowerpot != null && tileentityflowerpot.getFlowerPotItem() != null) {
			spawnAsEntity(world, blockpos,
					new ItemStack(tileentityflowerpot.getFlowerPotItem(), 1, tileentityflowerpot.getFlowerPotData()));
		}

		super.breakBlock(world, blockpos, iblockstate);
	}

	private boolean canNotContain(Block blockIn, int meta) {
		return blockIn != Blocks.yellow_flower && blockIn != Blocks.red_flower && blockIn != Blocks.cactus
				&& blockIn != Blocks.brown_mushroom && blockIn != Blocks.red_mushroom && blockIn != Blocks.sapling
				&& blockIn != Blocks.deadbush
						? blockIn == Blocks.tallgrass && meta == BlockTallGrass.EnumType.FERN.getMeta()
						: true;
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos blockpos) {
		return super.canPlaceBlockAt(world, blockpos) && World.doesBlockHaveSolidTopSurface(world, blockpos.down());
	}

	@Override
	public int colorMultiplier(IBlockAccess iblockaccess, BlockPos blockpos, int i) {
		TileEntity tileentity = iblockaccess.getTileEntity(blockpos);
		if (tileentity instanceof TileEntityFlowerPot) {
			Item item = ((TileEntityFlowerPot) tileentity).getFlowerPotItem();
			if (item instanceof ItemBlock) {
				return Block.getBlockFromItem(item).colorMultiplier(iblockaccess, blockpos, i);
			}
		}

		return 16777215;
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { CONTENTS, LEGACY_DATA });
	}

	/**
	 * + Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int i) {
		Object object = null;
		int j = 0;
		switch (i) {
		case 1:
			object = Blocks.red_flower;
			j = BlockFlower.EnumFlowerType.POPPY.getMeta();
			break;
		case 2:
			object = Blocks.yellow_flower;
			break;
		case 3:
			object = Blocks.sapling;
			j = BlockPlanks.EnumType.OAK.getMetadata();
			break;
		case 4:
			object = Blocks.sapling;
			j = BlockPlanks.EnumType.SPRUCE.getMetadata();
			break;
		case 5:
			object = Blocks.sapling;
			j = BlockPlanks.EnumType.BIRCH.getMetadata();
			break;
		case 6:
			object = Blocks.sapling;
			j = BlockPlanks.EnumType.JUNGLE.getMetadata();
			break;
		case 7:
			object = Blocks.red_mushroom;
			break;
		case 8:
			object = Blocks.brown_mushroom;
			break;
		case 9:
			object = Blocks.cactus;
			break;
		case 10:
			object = Blocks.deadbush;
			break;
		case 11:
			object = Blocks.tallgrass;
			j = BlockTallGrass.EnumType.FERN.getMeta();
			break;
		case 12:
			object = Blocks.sapling;
			j = BlockPlanks.EnumType.ACACIA.getMetadata();
			break;
		case 13:
			object = Blocks.sapling;
			j = BlockPlanks.EnumType.DARK_OAK.getMetadata();
		}

		return new TileEntityFlowerPot(Item.getItemFromBlock((Block) object), j);
	}

	/**
	 * + Get the actual Block state of this Block at the given position. This
	 * applies properties not visible in the metadata, such as fence connections.
	 */
	@Override
	public IBlockState getActualState(IBlockState iblockstate, IBlockAccess iblockaccess, BlockPos blockpos) {
		BlockFlowerPot.EnumFlowerType blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.EMPTY;
		TileEntity tileentity = iblockaccess.getTileEntity(blockpos);
		if (tileentity instanceof TileEntityFlowerPot) {
			TileEntityFlowerPot tileentityflowerpot = (TileEntityFlowerPot) tileentity;
			Item item = tileentityflowerpot.getFlowerPotItem();
			if (item instanceof ItemBlock) {
				int i = tileentityflowerpot.getFlowerPotData();
				Block block = Block.getBlockFromItem(item);
				if (block == Blocks.sapling) {
					switch (BlockPlanks.EnumType.byMetadata(i)) {
					case OAK:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.OAK_SAPLING;
						break;
					case SPRUCE:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.SPRUCE_SAPLING;
						break;
					case BIRCH:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.BIRCH_SAPLING;
						break;
					case JUNGLE:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.JUNGLE_SAPLING;
						break;
					case ACACIA:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.ACACIA_SAPLING;
						break;
					case DARK_OAK:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.DARK_OAK_SAPLING;
						break;
					default:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.EMPTY;
					}
				} else if (block == Blocks.tallgrass) {
					switch (i) {
					case 0:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.DEAD_BUSH;
						break;
					case 2:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.FERN;
						break;
					default:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.EMPTY;
					}
				} else if (block == Blocks.yellow_flower) {
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.DANDELION;
				} else if (block == Blocks.red_flower) {
					switch (BlockFlower.EnumFlowerType.getType(BlockFlower.EnumFlowerColor.RED, i)) {
					case POPPY:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.POPPY;
						break;
					case BLUE_ORCHID:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.BLUE_ORCHID;
						break;
					case ALLIUM:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.ALLIUM;
						break;
					case HOUSTONIA:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.HOUSTONIA;
						break;
					case RED_TULIP:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.RED_TULIP;
						break;
					case ORANGE_TULIP:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.ORANGE_TULIP;
						break;
					case WHITE_TULIP:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.WHITE_TULIP;
						break;
					case PINK_TULIP:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.PINK_TULIP;
						break;
					case OXEYE_DAISY:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.OXEYE_DAISY;
						break;
					default:
						blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.EMPTY;
					}
				} else if (block == Blocks.red_mushroom) {
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.MUSHROOM_RED;
				} else if (block == Blocks.brown_mushroom) {
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.MUSHROOM_BROWN;
				} else if (block == Blocks.deadbush) {
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.DEAD_BUSH;
				} else if (block == Blocks.cactus) {
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.CACTUS;
				}
			}
		}

		return iblockstate.withProperty(CONTENTS, blockflowerpot$enumflowertype);
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public int getDamageValue(World world, BlockPos blockpos) {
		TileEntityFlowerPot tileentityflowerpot = this.getTileEntity(world, blockpos);
		return tileentityflowerpot != null && tileentityflowerpot.getFlowerPotItem() != null
				? tileentityflowerpot.getFlowerPotData()
				: 0;
	}

	@Override
	public Item getItem(World world, BlockPos blockpos) {
		TileEntityFlowerPot tileentityflowerpot = this.getTileEntity(world, blockpos);
		return tileentityflowerpot != null && tileentityflowerpot.getFlowerPotItem() != null
				? tileentityflowerpot.getFlowerPotItem()
				: Items.flower_pot;
	}

	/**
	 * + Get the Item that this Block should drop when harvested.
	 */
	@Override
	public Item getItemDropped(IBlockState var1, EaglercraftRandom var2, int var3) {
		return Items.flower_pot;
	}

	/**
	 * + Gets the localized name of this block. Used for the statistics page.
	 */
	@Override
	public String getLocalizedName() {
		return StatCollector.translateToLocal("item.flowerPot.name");
	}

	/**
	 * + Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState iblockstate) {
		return ((Integer) iblockstate.getValue(LEGACY_DATA)).intValue();
	}

	/**
	 * + The type of render function called. 3 for standard block models, 2 for
	 * TESR's, 1 for liquids, -1 is no render
	 */
	@Override
	public int getRenderType() {
		return 3;
	}

	private TileEntityFlowerPot getTileEntity(World worldIn, BlockPos pos) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		return tileentity instanceof TileEntityFlowerPot ? (TileEntityFlowerPot) tileentity : null;
	}

	/**
	 * + Returns true only if block is flowerPot
	 */
	@Override
	public boolean isFlowerPot() {
		return true;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	/**
	 * + Used to determine ambient occlusion and culling when rebuilding chunks for
	 * render
	 */
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos blockpos, IBlockState var3, EntityPlayer entityplayer,
			EnumFacing var5, float var6, float var7, float var8) {
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		if (itemstack != null && itemstack.getItem() instanceof ItemBlock) {
			TileEntityFlowerPot tileentityflowerpot = this.getTileEntity(world, blockpos);
			if (tileentityflowerpot == null) {
				return false;
			} else if (tileentityflowerpot.getFlowerPotItem() != null) {
				return false;
			} else {
				Block block = Block.getBlockFromItem(itemstack.getItem());
				if (!this.canNotContain(block, itemstack.getMetadata())) {
					return false;
				} else {
					tileentityflowerpot.setFlowerPotData(itemstack.getItem(), itemstack.getMetadata());
					tileentityflowerpot.markDirty();
					world.markBlockForUpdate(blockpos);
					entityplayer.triggerAchievement(StatList.field_181736_T);
					if (!entityplayer.capabilities.isCreativeMode && --itemstack.stackSize <= 0) {
						entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem,
								(ItemStack) null);
					}

					return true;
				}
			}
		} else {
			return false;
		}
	}

	@Override
	public void onBlockHarvested(World world, BlockPos blockpos, IBlockState iblockstate, EntityPlayer entityplayer) {
		super.onBlockHarvested(world, blockpos, iblockstate, entityplayer);
		if (entityplayer.capabilities.isCreativeMode) {
			TileEntityFlowerPot tileentityflowerpot = this.getTileEntity(world, blockpos);
			if (tileentityflowerpot != null) {
				tileentityflowerpot.setFlowerPotData((Item) null, 0);
			}
		}

	}

	/**
	 * + Called when a neighboring block changes.
	 */
	@Override
	public void onNeighborBlockChange(World world, BlockPos blockpos, IBlockState iblockstate, Block var4) {
		if (!World.doesBlockHaveSolidTopSurface(world, blockpos.down())) {
			this.dropBlockAsItem(world, blockpos, iblockstate, 0);
			world.setBlockToAir(blockpos);
		}

	}

	/**
	 * + Sets the block's bounds for rendering it as an item
	 */
	@Override
	public void setBlockBoundsForItemRender() {
		float f = 0.375F;
		float f1 = f / 2.0F;
		this.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f, 0.5F + f1);
	}
}
