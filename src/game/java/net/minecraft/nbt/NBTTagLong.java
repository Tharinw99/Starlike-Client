package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

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
public class NBTTagLong extends NBTBase.NBTPrimitive {
	private long data;

	NBTTagLong() {
	}

	public NBTTagLong(long data) {
		this.data = data;
	}

	/**
	 * + Creates a clone of the tag.
	 */
	@Override
	public NBTBase copy() {
		return new NBTTagLong(this.data);
	}

	@Override
	public boolean equals(Object object) {
		if (super.equals(object)) {
			NBTTagLong nbttaglong = (NBTTagLong) object;
			return this.data == nbttaglong.data;
		} else {
			return false;
		}
	}

	@Override
	public byte getByte() {
		return (byte) ((int) (this.data & 255L));
	}

	@Override
	public double getDouble() {
		return (double) this.data;
	}

	@Override
	public float getFloat() {
		return (float) this.data;
	}

	/**
	 * + Gets the type byte for the tag.
	 */
	@Override
	public byte getId() {
		return (byte) 4;
	}

	@Override
	public int getInt() {
		return (int) (this.data & -1L);
	}

	@Override
	public long getLong() {
		return this.data;
	}

	@Override
	public short getShort() {
		return (short) ((int) (this.data & 65535L));
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ (int) (this.data ^ this.data >>> 32);
	}

	@Override
	void read(DataInput parDataInput, int parInt1, NBTSizeTracker parNBTSizeTracker) throws IOException {
		parNBTSizeTracker.read(128L);
		this.data = parDataInput.readLong();
	}

	@Override
	public String toString() {
		return "" + this.data + "L";
	}

	/**
	 * + Write the actual data contents of the tag, implemented in NBT extension
	 * classes
	 */
	@Override
	void write(DataOutput parDataOutput) throws IOException {
		parDataOutput.writeLong(this.data);
	}
}
