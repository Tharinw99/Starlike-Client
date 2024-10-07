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
public interface FloatBuffer extends Buffer {

	float[] array();

	FloatBuffer clear();

	FloatBuffer duplicate();

	FloatBuffer flip();

	float get();

	FloatBuffer get(float[] dst);

	FloatBuffer get(float[] dst, int offset, int length);

	float get(int index);

	float getElement(int index);

	boolean isDirect();

	FloatBuffer limit(int newLimit);

	FloatBuffer mark();

	FloatBuffer position(int newPosition);

	FloatBuffer put(float b);

	FloatBuffer put(float[] src);

	FloatBuffer put(float[] src, int offset, int length);

	FloatBuffer put(FloatBuffer src);

	FloatBuffer put(int index, float b);

	void putElement(int index, float value);

	FloatBuffer reset();

	FloatBuffer rewind();

}
