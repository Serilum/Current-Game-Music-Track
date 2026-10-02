package com.serilum.currentgamemusictrack.forge.events;

import com.serilum.currentgamemusictrack.data.Constants;
import com.serilum.currentgamemusictrack.events.GUIEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeGUIEvent {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void renderOverlay(RenderGuiOverlayEvent.Post e) {
		GUIEvent.renderOverlay(e.getGuiGraphics(), e.getPartialTick());
	}

	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent e) {
		if (!e.phase.equals(TickEvent.Phase.END)) {
			return;
		}

		GUIEvent.onClientTick(Constants.mc.level);
	}
}