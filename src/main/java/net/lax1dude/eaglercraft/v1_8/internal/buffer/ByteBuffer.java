package net.lax1dude.eaglercraft.v1_8.internal.buffer;

/**
 * Copyright (c) 2022 lax1dude. All Rights Reserved.
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
public interface ByteBuffer extends Buffer {

	byte[] array();

	FloatBuffer asFloatBuffer();

	IntBuffer asIntBuffer();

	ShortBuffer asShortBuffer();

	ByteBuffer clear();

	ByteBuffer duplicate();

	ByteBuffer flip();

	byte get();

	ByteBuffer get(byte[] dst);

	ByteBuffer get(byte[] dst, int offset, int length);

	byte get(int index);

	char getChar();

	char getChar(int index);

	float getFloat();

	float getFloat(int index);

	int getInt();

	int getInt(int index);

	long getLong();

	long getLong(int index);

	short getShort();

	short getShort(int index);

	ByteBuffer limit(int newLimit);

	ByteBuffer mark();

	ByteBuffer position(int newPosition);

	ByteBuffer put(byte b);

	ByteBuffer put(byte[] src);

	ByteBuffer put(byte[] src, int offset, int length);

	ByteBuffer put(ByteBuffer src);

	ByteBuffer put(int index, byte b);

	ByteBuffer putChar(char value);

	ByteBuffer putChar(int index, char value);

	ByteBuffer putFloat(float value);

	ByteBuffer putFloat(int index, float value);

	ByteBuffer putInt(int value);

	ByteBuffer putInt(int index, int value);

	ByteBuffer putLong(int index, long value);

	ByteBuffer putLong(long value);

	ByteBuffer putShort(int index, short value);

	ByteBuffer putShort(short value);

	ByteBuffer reset();

	ByteBuffer rewind();

}
