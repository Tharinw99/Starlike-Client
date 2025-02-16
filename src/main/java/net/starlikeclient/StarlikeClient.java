package net.starlikeclient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.lax1dude.eaglercraft.v1_8.EagRuntime;
import net.lax1dude.eaglercraft.v1_8.EaglercraftVersion;

public class StarlikeClient {
	/**
	 * + Settings for Starlike Client
	 */
	public static final class Config {
		/**
		 * + Settings related to in-game commands
		 */
		public static final class Commands {
			/**
			 * + Controls the maximum number of blocks changed when using `/clone` or
			 * `/fill`.
			 *
			 * @default 32768
			 */
			public static final int commandModificationBlockLimit = 65536;
		}

		/**
		 * + Culling configuration
		 */
		public static final class Culling {
			/**
			 * + Enables entity culling. Culls entities when they are not visible behind
			 * blocks.
			 */
			public static final boolean enableCulling = true;

			/**
			 * + Sets the maximum distance for entity tracing.
			 */
			public static final int entityMaxTracingDistance = 128;

			/**
			 * + Maximum hitbox size for entity culling. If the entity is larger than this,
			 * the game will skip culling it.
			 */
			public static final int entityHitboxSizeLimit = 64;

			/**
			 * + Skips culling marker armor stands.
			 */
			public static final boolean skipMarkerArmorStands = true;

			/**
			 * + Renders name tags even when entities are culled.
			 */
			public static final boolean renderNameTagsOnCulledEntities = true;

			/**
			 * + Whitelist of block entities that should not be culled.
			 */
			public static final Set<String> blockEntityWhitelist = new HashSet<>(Arrays.asList("minecraft:beacon"));
		}

		/**
		 * + Features for the client
		 */
		public static final class Features {
			/**
			 * + Enables or disables joining Multiplayer servers from the main menu.
			 */
			public static final boolean enableMultiplayer = true;
		}

		/**
		 * + General settings for the client
		 */
		public static final class General {
			/**
			 * + Marks if this is a development build. Adds experimental or beta features.
			 */
			public static final Boolean isDevBuild = false;

			/**
			 * + Snapshots use the format "YYwWWn", following Mojang's snapshot naming
			 * convention.
			 */
			public static final String devBuildVersion = "0.4.1";

			/**
			 * + Release candidate version, set to -1 if not
			 */
			public static final int releaseCandidateVersion = -1;

			/**
			 * + Name of the project fork for branding.
			 */
			public static final String projectForkName = "Starlike Client";

			/**
			 * + Version of the project fork, adds "-beta" if dev.
			 */
			public static final String projectForkVersion = "0.4.1"
					+ (releaseCandidateVersion >= 0 ? ("-rc" + releaseCandidateVersion)
							: isDevBuild ? ("-beta " + devBuildVersion) : "");

			/**
			 * + Contributors or vendors of the project fork.
			 */
			public static final String projectForkVendor = "SpeedSlicer and zumbiepig";

			/**
			 * + Warning that renders on the top of the screen when this is a dev build.
			 */
			public static final String devBuildWarning = "Starlike Dev Build " + devBuildVersion + " - BUGS MAY OCCUR!";

			/**
			 * + Main menu strings on the left.
			 */
			public static final String[] mainMenuStringLeft = new String[] {
					"Minecraft 1.8.8" /* + (Minecraft.getMinecraft().isDemo() ? " Demo" : "") */ + "*",
					EaglercraftVersion.projectOriginName + " " + EaglercraftVersion.projectOriginRevision + "-"
							+ EaglercraftVersion.projectOriginVersion + " [" + EagRuntime.getPlatformType().getName()
							+ "]",
					projectForkName + " " + projectForkVersion };

			/**
			 * + Main menu strings on the right.
			 */
			public static final String[] mainMenuStringRight = new String[] {
					"Copyright Mojang AB. Do not distribute!" };

			/**
			 * + Sets the default filename prefix for screen recordings.
			 */
			public static final String screenRecordingFilePrefix = projectForkName + " " + projectForkVersion;
		}
	}

	/**
	 * + Runs during Minecraft.init()
	 */
	public static void init() {
	}

	/**
	 * + Runs during Minecraft.runTick()
	 */
	public static void runTick() {
		if (StarlikeClient.Config.Culling.enableCulling) {
			Culling.getInstance().update();
		}
	}
}
