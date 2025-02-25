/*
 * Copyright (c) 2022-2025 lax1dude. All Rights Reserved.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.lax1dude.eaglercraft.v1_8.internal.buffer;

public abstract class ByteBuffer implements Buffer {

	@Override
	public abstract byte[] array();

	public abstract FloatBuffer asFloatBuffer();

	public abstract IntBuffer asIntBuffer();

	public abstract ShortBuffer asShortBuffer();

	@Override
	public abstract int capacity();

	@Override
	public abstract ByteBuffer clear();

	public abstract ByteBuffer duplicate();

	@Override
	public abstract ByteBuffer flip();

	public abstract byte get();

	public abstract ByteBuffer get(byte[] dst);

	public abstract ByteBuffer get(byte[] dst, int offset, int length);

	public abstract byte get(int index);

	public abstract char getChar();

	public abstract char getChar(int index);

	public abstract float getFloat();

	public abstract float getFloat(int index);

	public abstract int getInt();

	public abstract int getInt(int index);

	public abstract long getLong();

	public abstract long getLong(int index);

	public abstract short getShort();

	public abstract short getShort(int index);

	@Override
	public abstract boolean hasArray();

	@Override
	public abstract boolean hasRemaining();

	@Override
	public abstract int limit();

	@Override
	public abstract ByteBuffer limit(int newLimit);

	@Override
	public abstract ByteBuffer mark();

	@Override
	public abstract int position();

	@Override
	public abstract ByteBuffer position(int newPosition);

	public abstract ByteBuffer put(byte b);

	public abstract ByteBuffer put(byte[] src);

	public abstract ByteBuffer put(byte[] src, int offset, int length);

	public abstract ByteBuffer put(ByteBuffer src);

	public abstract ByteBuffer put(int index, byte b);

	public abstract ByteBuffer putChar(char value);

	public abstract ByteBuffer putChar(int index, char value);

	public abstract ByteBuffer putFloat(float value);

	public abstract ByteBuffer putFloat(int index, float value);

	public abstract ByteBuffer putInt(int value);

	public abstract ByteBuffer putInt(int index, int value);

	public abstract ByteBuffer putLong(int index, long value);

	public abstract ByteBuffer putLong(long value);

	public abstract ByteBuffer putShort(int index, short value);

	public abstract ByteBuffer putShort(short value);

	@Override
	public abstract int remaining();

	@Override
	public abstract ByteBuffer reset();

	@Override
	public abstract ByteBuffer rewind();

}