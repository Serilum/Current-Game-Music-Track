package com.natamus.currentgamemusictrack.mixin;

import com.natamus.currentgamemusictrack.data.Variables;
import com.natamus.currentgamemusictrack.util.Util;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = MusicManager.class, priority = 1001)
public class MusicManagerMixin {
	@Shadow private SoundInstance currentMusic;

	@Inject(method = "tick()V", at = @At(value = "HEAD"))
	public void tick(CallbackInfo ci) {
		if (currentMusic != null) {
			Sound sound = currentMusic.getSound();
			if (sound != null) {
				Identifier currentMusicRl = sound.getLocation();
				if (currentMusicRl != Variables.lastMusicIdentifier) {
					Util.displaySongTitle(currentMusic, currentMusicRl);
				}
			}
		}
		else if (Variables.lastMusicIdentifier != null) {
			Variables.lastMusicIdentifier = null;
		}
	}
}