package net.minecraft.world.chunk;

import java.util.List;

import com.google.common.base.Predicate;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
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
public class EmptyChunk extends Chunk {
	public EmptyChunk(World worldIn, int x, int z) {
		super(worldIn, x, z);
	}

	/**
	 * + Adds an entity to the chunk. Args: entity
	 */
	@Override
	public void addEntity(Entity entityIn) {
	}

	@Override
	public void addTileEntity(BlockPos pos, TileEntity tileEntityIn) {
	}

	@Override
	public void addTileEntity(TileEntity tileEntityIn) {
	}

	@Override
	public boolean canSeeSky(BlockPos pos) {
		return false;
	}

	/**
	 * + Generates the height map for a chunk from scratch
	 */
	@Override
	public void generateHeightMap() {
	}

	/**
	 * + Generates the initial skylight map for the chunk upon generation or load.
	 */
	@Override
	public void generateSkylightMap() {
	}

	/**
	 * + Returns whether the ExtendedBlockStorages containing levels (in blocks)
	 * from arg 1 to arg 2 are fully empty (true) or not (false).
	 */
	@Override
	public boolean getAreLevelsEmpty(int startY, int endY) {
		return true;
	}

	@Override
	public Block getBlock(BlockPos pos) {
		return Blocks.air;
	}

	@Override
	public int getBlockLightOpacity(BlockPos pos) {
		return 255;
	}

	@Override
	public int getBlockMetadata(BlockPos pos) {
		return 0;
	}

	@Override
	public <T extends Entity> void getEntitiesOfTypeWithinAAAB(Class<? extends T> entityClass, AxisAlignedBB aabb,
			List<T> listToFill, Predicate<? super T> parPredicate) {
	}

	/**
	 * + Fills the given list of all entities that intersect within the given
	 * bounding box that aren't the passed entity.
	 */
	@Override
	public void getEntitiesWithinAABBForEntity(Entity entityIn, AxisAlignedBB aabb, List<Entity> listToFill,
			Predicate<? super Entity> parPredicate) {
	}

	/**
	 * + Returns the value in the height map at this x, z coordinate in the chunk
	 */
	@Override
	public int getHeightValue(int x, int z) {
		return 0;
	}

	@Override
	public int getLightFor(EnumSkyBlock pos, BlockPos parBlockPos) {
		return pos.defaultLightValue;
	}

	@Override
	public int getLightSubtracted(BlockPos pos, int amount) {
		return 0;
	}

	@Override
	public EaglercraftRandom getRandomWithSeed(long seed) {
		return new EaglercraftRandom(
				this.getWorld().getSeed() + (long) (this.xPosition * this.xPosition * 4987142)
						+ (long) (this.xPosition * 5947611) + (long) (this.zPosition * this.zPosition) * 4392871L
						+ (long) (this.zPosition * 389711) ^ seed,
				!this.getWorld().getWorldInfo().isOldEaglercraftRandom());
	}

	@Override
	public TileEntity getTileEntity(BlockPos pos, Chunk.EnumCreateEntityType parEnumCreateEntityType) {
		return null;
	}

	/**
	 * + Checks whether the chunk is at the X/Z location specified
	 */
	@Override
	public boolean isAtLocation(int x, int z) {
		return x == this.xPosition && z == this.zPosition;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	/**
	 * + Returns true if this Chunk needs to be saved
	 */
	@Override
	public boolean needsSaving(boolean parFlag) {
		return false;
	}

	/**
	 * + Called when this Chunk is loaded by the ChunkProvider
	 */
	@Override
	public void onChunkLoad() {
	}

	/**
	 * + Called when this Chunk is unloaded by the ChunkProvider
	 */
	@Override
	public void onChunkUnload() {
	}

	/**
	 * + removes entity using its y chunk coordinate as its index
	 */
	@Override
	public void removeEntity(Entity entityIn) {
	}

	/**
	 * + Removes entity at the specified index from the entity array.
	 */
	@Override
	public void removeEntityAtIndex(Entity entityIn, int parInt1) {
	}

	@Override
	public void removeTileEntity(BlockPos pos) {
	}

	/**
	 * + Sets the isModified flag for this Chunk
	 */
	@Override
	public void setChunkModified() {
	}

	@Override
	public void setLightFor(EnumSkyBlock pos, BlockPos value, int parInt1) {
	}
}
