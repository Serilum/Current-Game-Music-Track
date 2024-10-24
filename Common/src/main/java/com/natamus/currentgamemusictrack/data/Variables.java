package com.natamus.currentgamemusictrack.data;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.ResourceLocation;

public class Variables {
	public static SoundInstance lastPlayedMusic = null;
	public static ResourceLocation lastMusicResourceLocation = null; // .getPath()

	public static boolean fadeIn = false;
	public static boolean fadeOut = false;
	public static int guiOpacity = 0;
	public static int guiTicksLeft = 0;
}
