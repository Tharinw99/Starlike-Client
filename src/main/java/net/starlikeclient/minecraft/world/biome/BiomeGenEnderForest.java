package net.starlikeclient.minecraft.world.biome;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.starlikeclient.minecraft.init.EntitiesStarlike;

public class BiomeGenEnderForest extends BiomeGenForest {
	public BiomeGenEnderForest(int parInt1, int parInt2) {
		super(parInt1, parInt2);

		EntitiesStarlike.configEntities(this);

		this.topBlock = Blocks.end_stone.getDefaultState();
		this.fillerBlock = Blocks.end_stone.getDefaultState();
		this.theBiomeDecorator.treesPerChunk = 5;
		this.theBiomeDecorator.deadBushPerChunk = 0;
		this.theBiomeDecorator.reedsPerChunk = 0;
		this.theBiomeDecorator.cactiPerChunk = 0;
	}

	@Override
	public void decorate(World world, EaglercraftRandom random, BlockPos blockpos) {
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				int k = i * 4 + 1 + 8 + random.nextInt(3);
				int l = j * 4 + 1 + 8 + random.nextInt(3);
				BlockPos blockpos1 = world.getHeight(blockpos.add(k, 0, l));
				if (random.nextInt(20) == 0) {
					WorldGenBigMushroom worldgenbigmushroom = new WorldGenBigMushroom();
					worldgenbigmushroom.generate(world, random, blockpos1);
				} else {
					WorldGenAbstractTree worldgenabstracttree = this.genBigTreeChance(random);
					worldgenabstracttree.func_175904_e();
					if (worldgenabstracttree.generate(world, random, blockpos1)) {
						worldgenabstracttree.func_180711_a(world, random, blockpos1);
					}
				}
			}
		}

		int j1 = random.nextInt(5) - 3;

		for (int k1 = 0; k1 < j1; ++k1) {
			int l1 = random.nextInt(3);
			if (l1 == 0) {
				DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.SYRINGA);
			} else if (l1 == 1) {
				DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.ROSE);
			} else if (l1 == 2) {
				DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.PAEONIA);
			}

			for (int i2 = 0; i2 < 5; ++i2) {
				int j2 = random.nextInt(16) + 8;
				int k2 = random.nextInt(16) + 8;
				int i1 = random.nextInt(world.getHeight(blockpos.add(j2, 0, k2)).getY() + 32);
				if (DOUBLE_PLANT_GENERATOR.generate(world, random,
						new BlockPos(blockpos.getX() + j2, i1, blockpos.getZ() + k2))) {
					break;
				}
			}
		}

		super.decorate(world, random, blockpos);
	}

}
