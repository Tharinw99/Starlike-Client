package net.lax1dude.eaglercraft.v1_8;

import java.math.BigInteger;

public class EaglercraftVersion {

	//////////////////////////////////////////////////////////////////////

	/// Customize these to fit your fork:

	public static final String projectForkName = "Starlike Client";
	public static final String projectForkVersion = "0.2.0";
	public static final String projectForkVendor = "SpeedSlicer and zumbiepig";

	public static final String projectForkURL = "";

	//////////////////////////////////////////////////////////////////////

	public static final String projectOriginName = "EaglercraftX";
	public static final String projectOriginAuthor = "lax1dude";
	public static final String projectOriginRevision = "1.8";
	public static final String projectOriginVersion = "u39";

	public static final String projectOriginURL = "https://gitlab.com/lax1dude/eaglercraftx-1.8"; // rest in peace

	// EPK Version Identifier

	public static final String EPKVersionIdentifier = projectForkVersion; // Set to null to disable EPK version check

	// Updating configuration

	public static final boolean enableUpdateService = true;

	public static final String updateBundlePackageName = "dev.zumbiepig.starlikeclient.client";
	public static final int updateBundlePackageVersionInt = 200; // (0.2.1 would be 000201 or just 201)

	public static final String updateLatestLocalStorageKey = "latestUpdate_" + updateBundlePackageName;

	// public key modulus for official 1.8 updates
	public static final BigInteger updateSignatureModulus = new BigInteger(
			"28154007251851793016096675136645490267059674193477673066016405606156842861664902840486152246081162714389866569681190683516064018400350723835699291801143446801871211423563444580124984720927762511096224794499752181575422000985856618499073349425764147909008336707018656178546729409024747183847557655756025152351818612306562908429371421145128154560905733480315537161717618356180392502066269414984054854075976130472279535788141377012879285566510859864540548496184877426481234244151342696367793929688648467759736793075080029025728010655173323780256289815694871723570008993011506495225395230611688881103726309118671731354057");

	// Client brand identification system configuration

	public static final EaglercraftUUID clientBrandUUID = EagUtils.makeClientBrandUUID(projectForkName);

	public static final EaglercraftUUID legacyClientUUIDInSharedWorld = EagUtils
			.makeClientBrandUUIDLegacy(projectOriginName);

	// Miscellaneous variables:

	public static final String mainMenuStringA = "Minecraft 1.8.8*";
	public static final String mainMenuStringB = projectOriginName + " " + projectOriginRevision + "-"
			+ projectOriginVersion;
	public static final String mainMenuStringC = null;
	public static final String mainMenuStringD = "Copyright Mojang AB. Do not distribute!";

	public static final String mainMenuStringE = projectForkName + " " + projectForkVersion;
	public static final String mainMenuStringF = "Made by " + projectForkVendor;

	public static final String mainMenuStringG = null;
	public static final String mainMenuStringH = null;

	public static final long demoWorldSeed = (long) "North Carolina".hashCode();

	public static final boolean mainMenuEnableGithubButton = false;

	public static final boolean forceDemoMode = false;

	public static final String localStorageNamespace = "_eaglercraftX_starlike";

}
