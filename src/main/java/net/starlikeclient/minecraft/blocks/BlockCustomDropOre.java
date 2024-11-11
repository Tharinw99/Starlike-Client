package net.starlikeclient.minecraft.blocks;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCustomDropOre extends BlockCustomDrop {
	public BlockCustomDropOre(Block blockDropped) {
		super(blockDropped, Material.rock);
	}

	public BlockCustomDropOre(Block blockDropped, MapColor parMapColor) {
		super(blockDropped, Material.rock, parMapColor);
	}

	public BlockCustomDropOre(Item itemDropped) {
		super(itemDropped, Material.rock);
	}

	public BlockCustomDropOre(Item itemDropped, MapColor parMapColor) {
		super(itemDropped, Material.rock, parMapColor);
	}

	// xp dropped
	@Override
	public void dropBlockAsItemWithChance(World world, BlockPos blockpos, IBlockState iblockstate, float f, int i) {
		super.dropBlockAsItemWithChance(world, blockpos, iblockstate, f, i);
		if (this.getItemDropped(iblockstate, world.rand, i) != Item.getItemFromBlock(this)) {
			int j = 0;
			if (this == Blocks.coal_ore) {
				j = MathHelper.getRandomIntegerInRange(world.rand, 0, 2);
			} else if (this == Blocks.diamond_ore) {
				j = MathHelper.getRandomIntegerInRange(world.rand, 3, 7);
			} else if (this == Blocks.emerald_ore) {
				j = MathHelper.getRandomIntegerInRange(world.rand, 3, 7);
			} else if (this == Blocks.lapis_ore) {
				j = MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
			} else if (this == Blocks.quartz_ore) {
				j = MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
			}

			this.dropXpOnBlockBreak(world, blockpos, j);
		}
	}

	// quantity dropped without fortune
	@Override
	public int quantityDropped(EaglercraftRandom random) {
		return this == Blocks.lapis_ore ? 4 + random.nextInt(5) : 1;
	}

	// quantity dropped with fortune
	@Override
	public int quantityDroppedWithBonus(int i, EaglercraftRandom random) {
		if (i > 0 && Item.getItemFromBlock(this) != this
				.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, i)) {
			int j = random.nextInt(i + 2) - 1;
			if (j < 0) {
				j = 0;
			}

			return this.quantityDropped(random) * (j + 1);
		} else {
			return this.quantityDropped(random);
		}
	}
}
