package net.lax1dude.eaglercraft.v1_8.internal.buffer;

/**
 * Copyright (c) 2022-2025 lax1dude. All Rights Reserved.
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
public abstract class ShortBuffer implements Buffer {

	@Override
	public abstract short[] array();

	@Override
	public abstract int capacity();

	@Override
	public abstract ShortBuffer clear();

	public abstract ShortBuffer duplicate();

	@Override
	public abstract ShortBuffer flip();

	public abstract short get();

	public abstract short get(int index);

	public abstract ShortBuffer get(short[] dst);

	public abstract ShortBuffer get(short[] dst, int offset, int length);

	public abstract short getElement(int index);

	@Override
	public abstract boolean hasArray();

	@Override
	public abstract boolean hasRemaining();

	@Override
	public abstract boolean isDirect();

	@Override
	public abstract int limit();

	@Override
	public abstract ShortBuffer limit(int newLimit);

	@Override
	public abstract ShortBuffer mark();

	@Override
	public abstract int position();

	@Override
	public abstract ShortBuffer position(int newPosition);

	public abstract ShortBuffer put(int index, short b);

	public abstract ShortBuffer put(short b);

	public abstract ShortBuffer put(short[] src);

	public abstract ShortBuffer put(short[] src, int offset, int length);

	public abstract ShortBuffer put(ShortBuffer src);

	public abstract void putElement(int index, short value);

	@Override
	public abstract int remaining();

	@Override
	public abstract ShortBuffer reset();

	@Override
	public abstract ShortBuffer rewind();

}
