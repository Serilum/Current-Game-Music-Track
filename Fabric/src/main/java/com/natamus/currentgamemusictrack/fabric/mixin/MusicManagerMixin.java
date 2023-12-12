package com.natamus.currentgamemusictrack.fabric.mixin;

import com.natamus.currentgamemusictrack.data.Variables;
import com.natamus.currentgamemusictrack.util.Util;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.resources.ResourceLocation;
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
			ResourceLocation currentMusicRl = currentMusic.getLocation();
			if (currentMusicRl != Variables.lastMusicResourceLocation) {
				Util.displaySongTitle(currentMusic, currentMusicRl);
			}
		}
		else if (Variables.lastMusicResourceLocation != null) {
			Variables.lastMusicResourceLocation = null;
		}
	}
}