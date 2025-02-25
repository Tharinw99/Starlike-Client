/*
 * Copyright (c) 2022-2024 lax1dude. All Rights Reserved.
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

import org.json.JSONObject;

import net.lax1dude.eaglercraft.v1_8.sp.relay.RelayEntry;

public interface IClientConfigAdapter {

	public static class DefaultServer {

		public final String name;
		public final String addr;
		public final boolean hideAddress;

		public DefaultServer(String name, String addr, boolean hideAddress) {
			this.name = name;
			this.addr = addr;
			this.hideAddress = hideAddress;
		}

	}

	boolean allowUpdateDL();

	boolean allowUpdateSvc();

	String getDefaultLocale();

	List<DefaultServer> getDefaultServerList();

	String getDownloadOfflineButtonLink();

	IClientConfigAdapterHooks getHooks();

	JSONObject getIntegratedServerOpts();

	String getLocalStorageNamespace();

	List<RelayEntry> getRelays();

	String getResourcePacksDB();

	String getServerToJoin();

	String getWorldsDB();

	boolean isAllowBootMenu();

	boolean isAllowFNAWSkins();

	boolean isAllowServerRedirects();

	boolean isAllowVoiceClient();

	boolean isCheckGLErrors();

	boolean isCheckRelaysForUpdates();

	boolean isCheckShaderGLErrors();

	boolean isDemo();

	boolean isEaglerNoDelay();

	boolean isEnableDownloadOfflineButton();

	boolean isEnableMinceraft();

	boolean isEnableServerCookies();

	boolean isEnableSignatureBadge();

	boolean isEnableWebViewCSP();

	boolean isEnforceVSync();

	boolean isForceProfanityFilter();

	boolean isForceWebViewSupport();

	boolean isLogInvalidCerts();

	boolean isOpenDebugConsoleOnLaunch();

	boolean isRamdiskMode();

	boolean useSpecialCursors();

}