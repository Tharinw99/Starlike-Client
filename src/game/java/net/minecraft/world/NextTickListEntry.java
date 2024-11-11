package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

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
