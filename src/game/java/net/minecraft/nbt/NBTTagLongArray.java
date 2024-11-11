package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

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
public class NBTTagLongArray extends NBTBase {
	private long[] longArray;

	NBTTagLongArray() {
	}

	public NBTTagLongArray(long[] parArrayOfLong) {
		this.longArray = parArrayOfLong;
	}

	/**
	 * + Creates a clone of the tag.
	 */
	@Override
	public NBTBase copy() {
		long[] along = new long[this.longArray.length];
		System.arraycopy(this.longArray, 0, along, 0, this.longArray.length);
		return new NBTTagLongArray(along);
	}

	@Override
	public boolean equals(Object object) {
		return super.equals(object) ? Arrays.equals(this.longArray, ((NBTTagLongArray) object).longArray) : false;
	}

	/**
	 * + Gets the type byte for the tag.
	 */
	@Override
	public byte getId() {
		return (byte) 12;
	}

	public long[] getLongArray() {
		return this.longArray;
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ Arrays.hashCode(this.longArray);
	}

	@Override
	void read(DataInput parDataInput, int parLong1, NBTSizeTracker parNBTSizeTracker) throws IOException {
		parNBTSizeTracker.read(192L);
		int i = parDataInput.readInt();
		parNBTSizeTracker.read((long) (32 * i));
		this.longArray = new long[i];

		for (int j = 0; j < i; ++j) {
			this.longArray[j] = parDataInput.readLong();
		}

	}

	@Override
	public String toString() {
		String s = "[";

		for (int i = 0; i < this.longArray.length; ++i) {
			s = s + this.longArray[i] + ",";
		}

		return s + "]";
	}

	/**
	 * + Write the actual data contents of the tag, implemented in NBT extension
	 * classes
	 */
	@Override
	void write(DataOutput parDataOutput) throws IOException {
		parDataOutput.writeInt(this.longArray.length);

		for (int i = 0; i < this.longArray.length; ++i) {
			parDataOutput.writeLong(this.longArray[i]);
		}

	}
}
