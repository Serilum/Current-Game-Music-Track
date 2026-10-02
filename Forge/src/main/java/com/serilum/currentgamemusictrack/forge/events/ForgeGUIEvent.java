package com.serilum.currentgamemusictrack.forge.events;

import com.serilum.currentgamemusictrack.data.Constants;
import com.serilum.currentgamemusictrack.events.GUIEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeGUIEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeGUIEvent.class);

		TickEvent.ClientTickEvent.Post.BUS.addListener(ForgeGUIEvent::onClientTick);
	}

	@SubscribeEvent
	public static void onClientTick(TickEvent.ClientTickEvent.Post e) {
		GUIEvent.onClientTick(Constants.mc.level);
	}
}