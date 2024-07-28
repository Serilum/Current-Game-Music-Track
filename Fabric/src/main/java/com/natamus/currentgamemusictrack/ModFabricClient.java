package com.natamus.currentgamemusictrack;

import com.natamus.currentgamemusictrack.events.GUIEvent;
import net.fabricmc.api.ClientModInitializer;
import com.natamus.currentgamemusictrack.util.Reference;
import com.natamus.collective.check.ShouldLoadCheck;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() { 
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		registerEvents();
	}
	
	private void registerEvents() {
		HudRenderCallback.EVENT.register((GuiGraphics guiGraphics, float tickDelta) -> {
			GUIEvent.renderOverlay(guiGraphics, tickDelta);
		});

		ClientTickEvents.START_WORLD_TICK.register((ClientLevel level) -> {
			GUIEvent.onClientTick(level);
		});
	}
}
