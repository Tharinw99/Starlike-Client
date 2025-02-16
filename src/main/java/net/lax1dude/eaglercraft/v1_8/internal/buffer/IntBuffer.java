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
public abstract class IntBuffer implements Buffer {

	@Override
	public abstract int[] array();

	@Override
	public abstract int capacity();

	@Override
	public abstract IntBuffer clear();

	public abstract IntBuffer duplicate();

	@Override
	public abstract IntBuffer flip();

	public abstract int get();

	public abstract int get(int index);

	public abstract IntBuffer get(int[] dst);

	public abstract IntBuffer get(int[] dst, int offset, int length);

	public abstract int getElement(int index);

	@Override
	public abstract boolean hasArray();

	@Override
	public abstract boolean hasRemaining();

	@Override
	public abstract boolean isDirect();

	@Override
	public abstract int limit();

	@Override
	public abstract IntBuffer limit(int newLimit);

	@Override
	public abstract IntBuffer mark();

	@Override
	public abstract int position();

	@Override
	public abstract IntBuffer position(int newPosition);

	public abstract IntBuffer put(int b);

	public abstract IntBuffer put(int index, int b);

	public abstract IntBuffer put(int[] src);

	public abstract IntBuffer put(int[] src, int offset, int length);

	public abstract IntBuffer put(IntBuffer src);

	public abstract void putElement(int index, int value);

	@Override
	public abstract int remaining();

	@Override
	public abstract IntBuffer reset();

	@Override
	public abstract IntBuffer rewind();

}
