package net.minecraft.client.stream;

/**
 * + This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source
 * code.
 * 
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!" Mod
 * Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 * 
 * EaglercraftX 1.8 patch files (c) 2022-2024 lax1dude, ayunami2000. All Rights
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
public interface IStream {
	public static enum AuthFailureReason {
		ERROR, INVALID_TOKEN;
	}

	boolean func_152908_z();

	void func_152909_x();

	boolean func_152913_F();

	void func_152917_b(String var1);

	IStream.AuthFailureReason func_152918_H();

	int func_152920_A();

	String func_152921_C();

	void func_152922_k();

	boolean func_152927_B();

	boolean func_152928_D();

	boolean func_152929_G();

	void func_152930_t();

	void func_152935_j();

	boolean func_152936_l();

	boolean isBroadcasting();

	boolean isPaused();

	boolean isReadyToBroadcast();

	/**
	 * + mutes or unmutes the microphone based on the boolean parameter passed into
	 * the method
	 */
	void muteMicrophone(boolean var1);

	/**
	 * + pauses a stream
	 */
	void pause();

	void requestCommercial();

	/**
	 * + Shuts down a steam
	 */
	void shutdownStream();

	void stopBroadcasting();

	/**
	 * + unpauses a stream
	 */
	void unpause();

	void updateStreamVolume();
}