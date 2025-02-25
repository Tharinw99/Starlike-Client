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

package net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt;

import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketGetOtherCapeEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketGetOtherClientUUIDV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketGetOtherSkinEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketGetSkinByURLEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketInstallSkinSPEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketRequestServerInfoV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketVoiceSignalConnectEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketVoiceSignalDescEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketVoiceSignalDisconnectPeerV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketVoiceSignalDisconnectV3EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketVoiceSignalDisconnectV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketVoiceSignalICEEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketVoiceSignalRequestEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketWebViewMessageEnV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.CPacketWebViewMessageV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketCustomizePauseMenuV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketEnableFNAWSkinsEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketForceClientCapeCustomV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketForceClientCapePresetV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketForceClientSkinCustomV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketForceClientSkinPresetV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketInvalidatePlayerCacheV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketNotifBadgeHideV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketNotifBadgeShowV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketNotifIconsRegisterV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketNotifIconsReleaseV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketOtherCapeCustomEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketOtherCapePresetEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketOtherPlayerClientUUIDV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketOtherSkinCustomV3EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketOtherSkinCustomV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketOtherSkinPresetEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketRedirectClientV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketServerInfoDataChunkV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketSetServerCookieV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketUnforceClientV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketUpdateCertEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalAllowedEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalConnectAnnounceV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalConnectV3EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalConnectV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalDescEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalDisconnectPeerEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalGlobalEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalICEEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketWebViewMessageV4EAG;

public interface GameMessageHandler {

	default void handleClient(CPacketGetOtherCapeEAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketGetOtherClientUUIDV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketGetOtherSkinEAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketGetSkinByURLEAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketInstallSkinSPEAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketRequestServerInfoV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketVoiceSignalConnectEAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketVoiceSignalDescEAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketVoiceSignalDisconnectPeerV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketVoiceSignalDisconnectV3EAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketVoiceSignalDisconnectV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketVoiceSignalICEEAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketVoiceSignalRequestEAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketWebViewMessageEnV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleClient(CPacketWebViewMessageV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketCustomizePauseMenuV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketEnableFNAWSkinsEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketForceClientCapeCustomV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketForceClientCapePresetV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketForceClientSkinCustomV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketForceClientSkinPresetV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketInvalidatePlayerCacheV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketNotifBadgeHideV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketNotifBadgeShowV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketNotifIconsRegisterV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketNotifIconsReleaseV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketOtherCapeCustomEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketOtherCapePresetEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketOtherPlayerClientUUIDV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketOtherSkinCustomV3EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketOtherSkinCustomV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketOtherSkinPresetEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketRedirectClientV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketServerInfoDataChunkV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketSetServerCookieV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketUnforceClientV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketUpdateCertEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketVoiceSignalAllowedEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketVoiceSignalConnectAnnounceV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketVoiceSignalConnectV3EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketVoiceSignalConnectV4EAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketVoiceSignalDescEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketVoiceSignalDisconnectPeerEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketVoiceSignalGlobalEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketVoiceSignalICEEAG packet) {
		throw new WrongPacketException();
	}

	default void handleServer(SPacketWebViewMessageV4EAG packet) {
		throw new WrongPacketException();
	}

}