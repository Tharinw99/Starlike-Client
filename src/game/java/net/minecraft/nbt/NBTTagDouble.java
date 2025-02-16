package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.minecraft.util.MathHelper;

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
public class NBTTagDouble extends NBTBase.NBTPrimitive {
	private double data;

	NBTTagDouble() {
	}

	public NBTTagDouble(double data) {
		this.data = data;
	}

	/**
	 * + Creates a clone of the tag.
	 */
	@Override
	public NBTBase copy() {
		return new NBTTagDouble(this.data);
	}

	@Override
	public boolean equals(Object object) {
		if (super.equals(object)) {
			NBTTagDouble nbttagdouble = (NBTTagDouble) object;
			return this.data == nbttagdouble.data;
		} else {
			return false;
		}
	}

	@Override
	public byte getByte() {
		return (byte) (MathHelper.floor_double(this.data) & 255);
	}

	@Override
	public double getDouble() {
		return this.data;
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
		return (byte) 6;
	}

	@Override
	public int getInt() {
		return MathHelper.floor_double(this.data);
	}

	@Override
	public long getLong() {
		return (long) Math.floor(this.data);
	}

	@Override
	public short getShort() {
		return (short) (MathHelper.floor_double(this.data) & '\uffff');
	}

	@Override
	public int hashCode() {
		long i = Double.doubleToLongBits(this.data);
		return super.hashCode() ^ (int) (i ^ i >>> 32);
	}

	@Override
	void read(DataInput parDataInput, int parInt1, NBTSizeTracker parNBTSizeTracker) throws IOException {
		parNBTSizeTracker.read(128L);
		this.data = parDataInput.readDouble();
	}

	@Override
	public String toString() {
		return "" + this.data + "d";
	}

	/**
	 * + Write the actual data contents of the tag, implemented in NBT extension
	 * classes
	 */
	@Override
	void write(DataOutput parDataOutput) throws IOException {
		parDataOutput.writeDouble(this.data);
	}
}
