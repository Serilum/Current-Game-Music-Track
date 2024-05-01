package com.natamus.currentgamemusictrack;

import com.natamus.currentgamemusictrack.events.GUIEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.multiplayer.ClientLevel;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() { 
		registerEvents();
	}
	
	private void registerEvents() {
		ClientTickEvents.START_WORLD_TICK.register((ClientLevel level) -> {
			GUIEvent.onClientTick(level);
		});
	}
}
