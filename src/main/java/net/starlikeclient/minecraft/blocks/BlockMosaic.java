package net.starlikeclient.minecraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BlockMosaic extends Block {
	public static enum EnumType implements IStringSerializable {
		OAK(0, "oak", MapColor.woodColor), SPRUCE(1, "spruce", MapColor.obsidianColor),
		BIRCH(2, "birch", MapColor.sandColor), JUNGLE(3, "jungle", MapColor.dirtColor),
		ACACIA(4, "acacia", MapColor.adobeColor), DARK_OAK(5, "dark_oak", MapColor.brownColor);

		public static final BlockMosaic.EnumType[] META_LOOKUP = new BlockMosaic.EnumType[6];
		static {
			BlockMosaic.EnumType[] types = values();
			for (int i = 0; i < types.length; ++i) {
				META_LOOKUP[types[i].getMetadata()] = types[i];
			}

		}

		public static BlockMosaic.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		private final int meta;
		private final String name;

		private final String unlocalizedName;

		private final MapColor field_181071_k;

		private EnumType(int parInt2, String parString2, MapColor parMapColor) {
			this(parInt2, parString2, parString2, parMapColor);
		}

		private EnumType(int parInt2, String parString2, String parString3, MapColor parMapColor) {
			this.meta = parInt2;
			this.name = parString2;
			this.unlocalizedName = parString3;
			this.field_181071_k = parMapColor;
		}

		public MapColor func_181070_c() {
			return this.field_181071_k;
		}

		public int getMetadata() {
			return this.meta;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}

	public static PropertyEnum<BlockMosaic.EnumType> VARIANT;

	public static void bootstrapStates() {
		VARIANT = PropertyEnum.<BlockMosaic.EnumType>create("variant", BlockMosaic.EnumType.class);
	}

	public BlockMosaic() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockMosaic.EnumType.OAK));
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setStepSound(Block.soundTypeWood);
		this.setCreativeTab(CreativeTabs.tabStarlike);
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { VARIANT });
	}

	/**
	 * + Gets the metadata of the item this Block can drop. This method is called
	 * when the block gets destroyed. It returns the metadata of the dropped item
	 * based on the old metadata of the block.
	 */
	@Override
	public int damageDropped(IBlockState iblockstate) {
		return iblockstate.getValue(VARIANT).getMetadata();
	}

	/**
	 * + Get the MapColor for this Block and the given BlockState
	 */
	@Override
	public MapColor getMapColor(IBlockState iblockstate) {
		return iblockstate.getValue(VARIANT).func_181070_c();
	}

	/**
	 * + Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState iblockstate) {
		return iblockstate.getValue(VARIANT).getMetadata();
	}

	/**
	 * + Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int i) {
		return this.getDefaultState().withProperty(VARIANT, BlockMosaic.EnumType.byMetadata(i));
	}

	/**
	 * + returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(Item item, CreativeTabs var2, List<ItemStack> list) {
		BlockMosaic.EnumType[] types = BlockMosaic.EnumType.META_LOOKUP;
		for (EnumType type : types) {
			list.add(new ItemStack(item, 1, type.getMetadata()));
		}
	}
}
