package com.natamus.currentgamemusictrack.neoforge.events;

import com.natamus.currentgamemusictrack.data.Constants;
import com.natamus.currentgamemusictrack.events.GUIEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(value = Dist.CLIENT)
public class NeoForgeGUIEvent {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void renderOverlay(RenderGuiEvent.Post e) {
		GUIEvent.renderOverlay(e.getGuiGraphics(), e.getPartialTick());
	}

	@SubscribeEvent
	public static void onClientTick(ClientTickEvent e) {
		GUIEvent.onClientTick(Constants.mc.level);
	}
}