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
public interface IntBuffer extends Buffer {

	@Override
	int[] array();

	@Override
	IntBuffer clear();

	IntBuffer duplicate();

	@Override
	IntBuffer flip();

	int get();

	int get(int index);

	IntBuffer get(int[] dst);

	IntBuffer get(int[] dst, int offset, int length);

	int getElement(int index);

	@Override
	boolean isDirect();

	@Override
	IntBuffer limit(int newLimit);

	@Override
	IntBuffer mark();

	@Override
	IntBuffer position(int newPosition);

	IntBuffer put(int b);

	IntBuffer put(int index, int b);

	IntBuffer put(int[] src);

	IntBuffer put(int[] src, int offset, int length);

	IntBuffer put(IntBuffer src);

	void putElement(int index, int value);

	@Override
	IntBuffer reset();

	@Override
	IntBuffer rewind();

}
