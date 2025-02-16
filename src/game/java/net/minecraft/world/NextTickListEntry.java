package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

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
public class NextTickListEntry implements Comparable<NextTickListEntry> {
	private static long nextTickEntryID;
	private final Block block;
	public final BlockPos position;
	public long scheduledTime;
	public int priority;
	private long tickEntryID;
	private int cachedHashCode = 0;

	public NextTickListEntry(BlockPos parBlockPos, Block parBlock) {
		this.tickEntryID = nextTickEntryID++;
		this.position = parBlockPos;
		this.block = parBlock;
	}

	@Override
	public int compareTo(NextTickListEntry parNextTickListEntry) {
		if (this.scheduledTime != parNextTickListEntry.scheduledTime) {
			return Long.compare(this.scheduledTime, parNextTickListEntry.scheduledTime);
		}
		if (this.priority != parNextTickListEntry.priority) {
			return Integer.compare(this.priority, parNextTickListEntry.priority);
		}
		return Long.compare(this.tickEntryID, parNextTickListEntry.tickEntryID);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof NextTickListEntry))
			return false;
		NextTickListEntry other = (NextTickListEntry) object;
		return this.hashCode() == other.hashCode() && this.position.equals(other.position)
				&& Block.isEqualTo(this.block, other.block);
	}

	public Block getBlock() {
		return this.block;
	}

	@Override
	public int hashCode() {
		if (cachedHashCode == 0) {
			cachedHashCode = this.position.hashCode();
		}
		return cachedHashCode;
	}

	public void setPriority(int parInt1) {
		this.priority = parInt1;
	}

	public NextTickListEntry setScheduledTime(long parLong1) {
		this.scheduledTime = parLong1;
		return this;
	}

	@Override
	public String toString() {
		return Block.getIdFromBlock(this.block) + ": " + this.position + ", " + this.scheduledTime + ", "
				+ this.priority + ", " + this.tickEntryID;
	}
}
