package com.natamus.currentgamemusictrack.forge.events;

import com.natamus.currentgamemusictrack.data.Constants;
import com.natamus.currentgamemusictrack.events.GUIEvent;
import net.minecraftforge.api.distmarker.Dist;
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