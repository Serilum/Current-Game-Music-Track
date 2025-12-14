package com.natamus.currentgamemusictrack.util;

import com.natamus.collective.functions.StringFunctions;
import com.natamus.currentgamemusictrack.config.ConfigHandler;
import com.natamus.currentgamemusictrack.data.Variables;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.Identifier;

public class Util {
	public static String getMusicTitle(Identifier musicIdentifier) {
		if (musicIdentifier == null) {
			return "";
		}

		String musicPath = musicIdentifier.getPath();
		String[] mpspl = musicPath.split("/");

		String rawName = mpspl[mpspl.length-1];
		String name = rawName.replace("_", " ");

		return StringFunctions.capitalizeEveryWord(name);
	}

	public static void displaySongTitle(SoundInstance musicSoundInstance, Identifier musicIdentifier) {
		Variables.lastPlayedMusic = musicSoundInstance;
		Variables.lastMusicIdentifier = musicIdentifier;

		Variables.guiTicksLeft = ConfigHandler.durationTitleShownInTicks;
		Variables.fadeIn = true;
	}
}
