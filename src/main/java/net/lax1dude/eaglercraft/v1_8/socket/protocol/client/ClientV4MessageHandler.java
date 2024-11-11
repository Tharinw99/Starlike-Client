package net.lax1dude.eaglercraft.v1_8.socket.protocol.client;

import java.nio.charset.StandardCharsets;

import net.lax1dude.eaglercraft.v1_8.ClientUUIDLoadingCache;
import net.lax1dude.eaglercraft.v1_8.EagRuntime;
import net.lax1dude.eaglercraft.v1_8.EaglercraftUUID;
import net.lax1dude.eaglercraft.v1_8.PauseMenuCustomizeState;
import net.lax1dude.eaglercraft.v1_8.cookie.ServerCookieDataStore;
import net.lax1dude.eaglercraft.v1_8.profile.EaglerProfile;
import net.lax1dude.eaglercraft.v1_8.profile.SkinModel;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.GameMessageHandler;
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
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketOtherSkinCustomV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketOtherSkinPresetEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketRedirectClientV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketServerInfoDataChunkV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketSetServerCookieV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketUnforceClientV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketUpdateCertEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalAllowedEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalConnectAnnounceV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalConnectV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalDescEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalDisconnectPeerEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalGlobalEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketVoiceSignalICEEAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketWebViewMessageV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.util.SkinPacketVersionCache;
import net.lax1dude.eaglercraft.v1_8.update.UpdateService;
import net.lax1dude.eaglercraft.v1_8.voice.VoiceClientController;
import net.lax1dude.eaglercraft.v1_8.webview.ServerInfoCache;
import net.lax1dude.eaglercraft.v1_8.webview.WebViewOverlayController;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;

/**
 * Copyright (c) 2024 lax1dude. All Rights Reserved.
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
public class ClientV4MessageHandler implements GameMessageHandler {

	private final NetHandlerPlayClient netHandler;

	public ClientV4MessageHandler(NetHandlerPlayClient netHandler) {
		this.netHandler = netHandler;
	}

	@Override
	public void handleServer(SPacketCustomizePauseMenuV4EAG packet) {
		PauseMenuCustomizeState.loadPacket(packet);
	}

	@Override
	public void handleServer(SPacketEnableFNAWSkinsEAG packet) {
		netHandler.currentFNAWSkinAllowedState = packet.enableSkins;
		netHandler.currentFNAWSkinForcedState = packet.force;
		Minecraft.getMinecraft().getRenderManager().setEnableFNAWSkins(netHandler.currentFNAWSkinForcedState
				|| (netHandler.currentFNAWSkinAllowedState && Minecraft.getMinecraft().gameSettings.enableFNAWSkins));
	}

	@Override
	public void handleServer(SPacketForceClientCapeCustomV4EAG packet) {
		EaglerProfile.handleForceCapeCustom(packet.customCape);
	}

	@Override
	public void handleServer(SPacketForceClientCapePresetV4EAG packet) {
		EaglerProfile.handleForceCapePreset(packet.presetCape);
	}

	@Override
	public void handleServer(SPacketForceClientSkinCustomV4EAG packet) {
		EaglerProfile.handleForceSkinCustom(packet.modelID, SkinPacketVersionCache.convertToV3Raw(packet.customSkin));
	}

	@Override
	public void handleServer(SPacketForceClientSkinPresetV4EAG packet) {
		EaglerProfile.handleForceSkinPreset(packet.presetSkin);
	}

	@Override
	public void handleServer(SPacketInvalidatePlayerCacheV4EAG packet) {
		if (packet.players != null && packet.players.size() > 0) {
			for (SPacketInvalidatePlayerCacheV4EAG.InvalidateRequest req : packet.players) {
				EaglercraftUUID uuid = new EaglercraftUUID(req.uuidMost, req.uuidLeast);
				if (req.invalidateSkin) {
					this.netHandler.getSkinCache().handleInvalidate(uuid);
				}
				if (req.invalidateCape) {
					this.netHandler.getCapeCache().handleInvalidate(uuid);
				}
			}
		}
	}

	@Override
	public void handleServer(SPacketNotifBadgeHideV4EAG packet) {
		netHandler.getNotifManager().processPacketHideBadge(packet);
	}

	@Override
	public void handleServer(SPacketNotifBadgeShowV4EAG packet) {
		netHandler.getNotifManager().processPacketShowBadge(packet);
	}

	@Override
	public void handleServer(SPacketNotifIconsRegisterV4EAG packet) {
		netHandler.getNotifManager().processPacketAddIcons(packet);
	}

	@Override
	public void handleServer(SPacketNotifIconsReleaseV4EAG packet) {
		netHandler.getNotifManager().processPacketRemIcons(packet);
	}

	@Override
	public void handleServer(SPacketOtherCapeCustomEAG packet) {
		netHandler.getCapeCache().cacheCapeCustom(new EaglercraftUUID(packet.uuidMost, packet.uuidLeast),
				packet.customCape);
	}

	@Override
	public void handleServer(SPacketOtherCapePresetEAG packet) {
		netHandler.getCapeCache().cacheCapePreset(new EaglercraftUUID(packet.uuidMost, packet.uuidLeast),
				packet.presetCape);
	}

	@Override
	public void handleServer(SPacketOtherPlayerClientUUIDV4EAG packet) {
		ClientUUIDLoadingCache.handleResponse(packet.requestId,
				new EaglercraftUUID(packet.clientUUIDMost, packet.clientUUIDLeast));
	}

	@Override
	public void handleServer(SPacketOtherSkinCustomV4EAG packet) {
		EaglercraftUUID responseUUID = new EaglercraftUUID(packet.uuidMost, packet.uuidLeast);
		SkinModel modelId;
		if (packet.modelID == (byte) 0xFF) {
			modelId = this.netHandler.getSkinCache().getRequestedSkinType(responseUUID);
		} else {
			modelId = SkinModel.getModelFromId(packet.modelID & 0x7F);
			if ((packet.modelID & 0x80) != 0 && modelId.sanitize) {
				modelId = SkinModel.STEVE;
			}
		}
		if (modelId.highPoly != null) {
			modelId = SkinModel.STEVE;
		}
		this.netHandler.getSkinCache().cacheSkinCustom(responseUUID,
				SkinPacketVersionCache.convertToV3Raw(packet.customSkin), modelId);
	}

	@Override
	public void handleServer(SPacketOtherSkinPresetEAG packet) {
		this.netHandler.getSkinCache().cacheSkinPreset(new EaglercraftUUID(packet.uuidMost, packet.uuidLeast),
				packet.presetSkin);
	}

	@Override
	public void handleServer(SPacketRedirectClientV4EAG packet) {
		Minecraft.getMinecraft().handleReconnectPacket(packet.redirectURI);
	}

	@Override
	public void handleServer(SPacketServerInfoDataChunkV4EAG packet) {
		ServerInfoCache.handleChunk(packet);
	}

	@Override
	public void handleServer(SPacketSetServerCookieV4EAG packet) {
		if (!netHandler.isClientInEaglerSingleplayerOrLAN()
				&& Minecraft.getMinecraft().getCurrentServerData().enableCookies) {
			ServerCookieDataStore.saveCookie(netHandler.getNetworkManager().getAddress(), packet.expires, packet.data,
					packet.revokeQuerySupported, packet.saveCookieToDisk);
		}
	}

	@Override
	public void handleServer(SPacketUnforceClientV4EAG packet) {
		if (packet.resetSkin) {
			EaglerProfile.isServerSkinOverride = false;
		}
		if (packet.resetCape) {
			EaglerProfile.isServerCapeOverride = false;
		}
		if (packet.resetFNAW) {
			netHandler.currentFNAWSkinForcedState = false;
			Minecraft.getMinecraft().getRenderManager().setEnableFNAWSkins(
					netHandler.currentFNAWSkinAllowedState && Minecraft.getMinecraft().gameSettings.enableFNAWSkins);
		}
	}

	@Override
	public void handleServer(SPacketUpdateCertEAG packet) {
		if (EagRuntime.getConfiguration().allowUpdateSvc()) {
			UpdateService.addCertificateToSet(packet.updateCert);
		}
	}

	@Override
	public void handleServer(SPacketVoiceSignalAllowedEAG packet) {
		if (VoiceClientController.isClientSupported()) {
			VoiceClientController.handleVoiceSignalPacketTypeAllowed(packet.allowed, packet.iceServers);
		}
	}

	@Override
	public void handleServer(SPacketVoiceSignalConnectAnnounceV4EAG packet) {
		if (VoiceClientController.isClientSupported()) {
			VoiceClientController
					.handleVoiceSignalPacketTypeConnectAnnounce(new EaglercraftUUID(packet.uuidMost, packet.uuidLeast));
		}
	}

	@Override
	public void handleServer(SPacketVoiceSignalConnectV4EAG packet) {
		if (VoiceClientController.isClientSupported()) {
			VoiceClientController.handleVoiceSignalPacketTypeConnect(
					new EaglercraftUUID(packet.uuidMost, packet.uuidLeast), packet.offer);
		}
	}

	@Override
	public void handleServer(SPacketVoiceSignalDescEAG packet) {
		if (VoiceClientController.isClientSupported()) {
			VoiceClientController.handleVoiceSignalPacketTypeDescription(
					new EaglercraftUUID(packet.uuidMost, packet.uuidLeast),
					new String(packet.desc, StandardCharsets.UTF_8));
		}
	}

	@Override
	public void handleServer(SPacketVoiceSignalDisconnectPeerEAG packet) {
		if (VoiceClientController.isClientSupported()) {
			VoiceClientController
					.handleVoiceSignalPacketTypeDisconnect(new EaglercraftUUID(packet.uuidMost, packet.uuidLeast));
		}
	}

	@Override
	public void handleServer(SPacketVoiceSignalGlobalEAG packet) {
		if (VoiceClientController.isClientSupported()) {
			VoiceClientController.handleVoiceSignalPacketTypeGlobalNew(packet.users);
		}
	}

	@Override
	public void handleServer(SPacketVoiceSignalICEEAG packet) {
		if (VoiceClientController.isClientSupported()) {
			VoiceClientController.handleVoiceSignalPacketTypeICECandidate(
					new EaglercraftUUID(packet.uuidMost, packet.uuidLeast),
					new String(packet.ice, StandardCharsets.UTF_8));
		}
	}

	@Override
	public void handleServer(SPacketWebViewMessageV4EAG packet) {
		WebViewOverlayController.handleMessagePacket(packet);
	}

}
