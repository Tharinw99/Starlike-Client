/*
 * Copyright (c) 2024 lax1dude. All Rights Reserved.
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

package net.lax1dude.eaglercraft.v1_8.internal;

import java.util.List;

public interface IWebSocketClient {

	int availableBinaryFrames();

	int availableFrames();

	int availableStringFrames();

	void clearBinaryFrames();

	void clearFrames();

	void clearStringFrames();

	void close();

	boolean connectBlocking(int timeoutMS);

	String getCurrentURI();

	IWebSocketFrame getNextBinaryFrame();

	List<IWebSocketFrame> getNextBinaryFrames();

	IWebSocketFrame getNextFrame();

	List<IWebSocketFrame> getNextFrames();

	IWebSocketFrame getNextStringFrame();

	List<IWebSocketFrame> getNextStringFrames();

	EnumEaglerConnectionState getState();

	boolean isClosed();

	boolean isOpen();

	void send(byte[] bytes);

	void send(String str);

	void setEnableBinaryFrames(boolean enable);

	void setEnableStringFrames(boolean enable);

}