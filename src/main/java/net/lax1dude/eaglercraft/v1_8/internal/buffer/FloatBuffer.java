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

public abstract class FloatBuffer implements Buffer {

	@Override
	public abstract float[] array();

	@Override
	public abstract int capacity();

	@Override
	public abstract FloatBuffer clear();

	public abstract FloatBuffer duplicate();

	@Override
	public abstract FloatBuffer flip();

	public abstract float get();

	public abstract FloatBuffer get(float[] dst);

	public abstract FloatBuffer get(float[] dst, int offset, int length);

	public abstract float get(int index);

	public abstract float getElement(int index);

	@Override
	public abstract boolean hasArray();

	@Override
	public abstract boolean hasRemaining();

	@Override
	public abstract boolean isDirect();

	@Override
	public abstract int limit();

	@Override
	public abstract FloatBuffer limit(int newLimit);

	@Override
	public abstract FloatBuffer mark();

	@Override
	public abstract int position();

	@Override
	public abstract FloatBuffer position(int newPosition);

	public abstract FloatBuffer put(float b);

	public abstract FloatBuffer put(float[] src);

	public abstract FloatBuffer put(float[] src, int offset, int length);

	public abstract FloatBuffer put(FloatBuffer src);

	public abstract FloatBuffer put(int index, float b);

	public abstract void putElement(int index, float value);

	@Override
	public abstract int remaining();

	@Override
	public abstract FloatBuffer reset();

	@Override
	public abstract FloatBuffer rewind();

}