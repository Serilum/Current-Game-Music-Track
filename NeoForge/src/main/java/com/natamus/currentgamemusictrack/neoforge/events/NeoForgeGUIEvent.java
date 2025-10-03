package com.natamus.currentgamemusictrack.neoforge.events;

import com.natamus.currentgamemusictrack.data.Constants;
import com.natamus.currentgamemusictrack.events.GUIEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

public class NeoForgeGUIEvent {
	@SubscribeEvent
	public static void onClientTick(ClientTickEvent.Post e) {
		GUIEvent.onClientTick(Constants.mc.level);
	}
}