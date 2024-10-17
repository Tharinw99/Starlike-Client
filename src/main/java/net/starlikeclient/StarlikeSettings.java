package net.starlikeclient;

public class StarlikeSettings {
	/*
	 * Block id limit
	 * 
	 * Default value: 4096
	 */
	public static final int blockIdLimit = 4096;

	/*
	 * Controls the maximum number of blocks changed when using `/clone` or `/fill`.
	 * 
	 * Default value: 32768
	 */
	public static final int commandModificationBlockLimit = 65536;
}