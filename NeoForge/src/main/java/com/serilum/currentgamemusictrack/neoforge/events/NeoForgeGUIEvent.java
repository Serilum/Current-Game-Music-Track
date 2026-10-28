package com.serilum.currentgamemusictrack.neoforge.events;

import com.serilum.currentgamemusictrack.data.Constants;
import com.serilum.currentgamemusictrack.events.GUIEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;

public class NeoForgeGUIEvent {
	@SubscribeEvent
	public static void onClientTick(ClientTickEvent.Post e) {
		GUIEvent.onClientTick(Constants.mc.level);
	}
}