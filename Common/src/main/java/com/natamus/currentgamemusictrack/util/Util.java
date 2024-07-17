package com.natamus.currentgamemusictrack.util;

import com.natamus.collective.functions.StringFunctions;
import com.natamus.currentgamemusictrack.config.ConfigHandler;
import com.natamus.currentgamemusictrack.data.Variables;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.ResourceLocation;

public class Util {
	public static String getMusicTitle(ResourceLocation musicResourceLocation) {
		if (musicResourceLocation == null) {
			return "";
		}

		String musicPath = musicResourceLocation.getPath();
		String[] mpspl = musicPath.split("/");

		String rawName = mpspl[mpspl.length-1];
		String name = rawName.replace("_", " ");

		return StringFunctions.capitalizeEveryWord(name);
	}

	public static void displaySongTitle(SoundInstance musicSoundInstance, ResourceLocation musicResourceLocation) {
		Variables.lastPlayedMusic = musicSoundInstance;
		Variables.lastMusicResourceLocation = musicResourceLocation;

		Variables.guiTicksLeft = ConfigHandler.durationTitleShownInTicks;
		Variables.fadeIn = true;
	}
}
