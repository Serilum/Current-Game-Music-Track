package com.natamus.currentgamemusictrack;

import com.natamus.collective.globalcallbacks.CollectiveGuiCallback;
import com.natamus.collective.services.Services;
import com.natamus.currentgamemusictrack.config.ConfigHandler;
import com.natamus.currentgamemusictrack.events.GUIEvent;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		if (Services.MODLOADER.isClientSide()) {
			CollectiveGuiCallback.ON_GUI_RENDER.register(((guiGraphics, deltaTracker) -> {
				GUIEvent.renderOverlay(guiGraphics, deltaTracker);
			}));
		}
	}
}