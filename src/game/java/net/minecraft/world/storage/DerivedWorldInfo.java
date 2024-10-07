package net.minecraft.world.storage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;

/**
 * + This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source
 * code.
 * 
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!" Mod
 * Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 * 
 * EaglercraftX 1.8 patch files (c) 2022-2024 lax1dude, ayunami2000. All Rights
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
public class DerivedWorldInfo extends WorldInfo {
	private final WorldInfo theWorldInfo;

	public DerivedWorldInfo(WorldInfo parWorldInfo) {
		this.theWorldInfo = parWorldInfo;
	}

	/**
	 * + Returns true if commands are allowed on this World.
	 */
	public boolean areCommandsAllowed() {
		return this.theWorldInfo.areCommandsAllowed();
	}

	/**
	 * + Creates a new NBTTagCompound for the world, with the given NBTTag as the
	 * "Player"
	 */
	public NBTTagCompound cloneNBTCompound(NBTTagCompound nbt) {
		return this.theWorldInfo.cloneNBTCompound(nbt);
	}

	public EnumDifficulty getDifficulty() {
		return this.theWorldInfo.getDifficulty();
	}

	/**
	 * + Gets the GameRules class Instance.
	 */
	public GameRules getGameRulesInstance() {
		return this.theWorldInfo.getGameRulesInstance();
	}

	/**
	 * + Gets the GameType.
	 */
	public WorldSettings.GameType getGameType() {
		return this.theWorldInfo.getGameType();
	}

	/**
	 * + Return the last time the player was in this world.
	 */
	public long getLastTimePlayed() {
		return this.theWorldInfo.getLastTimePlayed();
	}

	/**
	 * + Gets the NBTTagCompound for the worldInfo
	 */
	public NBTTagCompound getNBTTagCompound() {
		return this.theWorldInfo.getNBTTagCompound();
	}

	/**
	 * + Returns the player's NBTTagCompound to be loaded
	 */
	public NBTTagCompound getPlayerNBTTagCompound() {
		return this.theWorldInfo.getPlayerNBTTagCompound();
	}

	/**
	 * + Return the number of ticks until rain.
	 */
	public int getRainTime() {
		return this.theWorldInfo.getRainTime();
	}

	/**
	 * + Returns the save version of this world
	 */
	public int getSaveVersion() {
		return this.theWorldInfo.getSaveVersion();
	}

	/**
	 * + Returns the seed of current world.
	 */
	public long getSeed() {
		return this.theWorldInfo.getSeed();
	}

	public long getSizeOnDisk() {
		return this.theWorldInfo.getSizeOnDisk();
	}

	/**
	 * + Returns the x spawn position
	 */
	public int getSpawnX() {
		return this.theWorldInfo.getSpawnX();
	}

	/**
	 * + Return the Y axis spawning point of the player.
	 */
	public int getSpawnY() {
		return this.theWorldInfo.getSpawnY();
	}

	/**
	 * + Returns the z spawn position
	 */
	public int getSpawnZ() {
		return this.theWorldInfo.getSpawnZ();
	}

	public WorldType getTerrainType() {
		return this.theWorldInfo.getTerrainType();
	}

	/**
	 * + Returns the number of ticks until next thunderbolt.
	 */
	public int getThunderTime() {
		return this.theWorldInfo.getThunderTime();
	}

	/**
	 * + Get current world name
	 */
	public String getWorldName() {
		return this.theWorldInfo.getWorldName();
	}

	/**
	 * + Get current world time
	 */
	public long getWorldTime() {
		return this.theWorldInfo.getWorldTime();
	}

	public long getWorldTotalTime() {
		return this.theWorldInfo.getWorldTotalTime();
	}

	public boolean isDifficultyLocked() {
		return this.theWorldInfo.isDifficultyLocked();
	}

	/**
	 * + Returns true if hardcore mode is enabled, otherwise false
	 */
	public boolean isHardcoreModeEnabled() {
		return this.theWorldInfo.isHardcoreModeEnabled();
	}

	/**
	 * + Returns true if the World is initialized.
	 */
	public boolean isInitialized() {
		return this.theWorldInfo.isInitialized();
	}

	/**
	 * + Get whether the map features (e.g. strongholds) generation is enabled or
	 * disabled.
	 */
	public boolean isMapFeaturesEnabled() {
		return this.theWorldInfo.isMapFeaturesEnabled();
	}

	/**
	 * + Returns true if it is raining, false otherwise.
	 */
	public boolean isRaining() {
		return this.theWorldInfo.isRaining();
	}

	/**
	 * + Returns true if it is thundering, false otherwise.
	 */
	public boolean isThundering() {
		return this.theWorldInfo.isThundering();
	}

	public void setAllowCommands(boolean allow) {
	}

	public void setDifficulty(EnumDifficulty newDifficulty) {
	}

	public void setDifficultyLocked(boolean locked) {
	}

	/**
	 * + Sets whether it is raining or not.
	 */
	public void setRaining(boolean isRaining) {
	}

	/**
	 * + Sets the number of ticks until rain.
	 */
	public void setRainTime(int time) {
	}

	/**
	 * + Sets the save version of the world
	 */
	public void setSaveVersion(int version) {
	}

	/**
	 * + Sets the initialization status of the World.
	 */
	public void setServerInitialized(boolean initializedIn) {
	}

	public void setSpawn(BlockPos spawnPoint) {
	}

	/**
	 * + Set the x spawn position to the passed in value
	 */
	public void setSpawnX(int x) {
	}

	/**
	 * + Sets the y spawn position
	 */
	public void setSpawnY(int y) {
	}

	/**
	 * + Set the z spawn position to the passed in value
	 */
	public void setSpawnZ(int z) {
	}

	public void setTerrainType(WorldType type) {
	}

	/**
	 * + Sets whether it is thundering or not.
	 */
	public void setThundering(boolean thunderingIn) {
	}

	/**
	 * + Defines the number of ticks until next thunderbolt.
	 */
	public void setThunderTime(int time) {
	}

	public void setWorldName(String worldName) {
	}

	/**
	 * + Set current world time
	 */
	public void setWorldTime(long time) {
	}

	public void setWorldTotalTime(long time) {
	}
}