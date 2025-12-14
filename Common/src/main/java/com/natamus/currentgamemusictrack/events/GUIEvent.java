package com.natamus.currentgamemusictrack.events;

import com.mojang.blaze3d.platform.Window;
import org.joml.Matrix3x2fStack;
import com.natamus.collective.functions.GUIFunctions;
import com.natamus.currentgamemusictrack.config.ConfigHandler;
import com.natamus.currentgamemusictrack.data.Constants;
import com.natamus.currentgamemusictrack.data.Variables;
import com.natamus.currentgamemusictrack.util.Util;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;

import java.awt.*;

public class GUIEvent {
	public static void renderOverlay(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
		if (GUIFunctions.shouldHideGUI()) {
			return;
		}

		if (Variables.guiOpacity <= 0) {
			return;
		}

		String musicGUIString = "";
		if (Variables.lastMusicIdentifier != null) {
			musicGUIString = "🎵 " + Util.getMusicTitle(Variables.lastMusicIdentifier) + " 🎵";
		}

		if (musicGUIString.equals("")) {
			return;
		}

		Matrix3x2fStack matrixStack = guiGraphics.pose();
		matrixStack.pushMatrix();
		
		Font font = Constants.mc.font;
		Window scaled = Constants.mc.getWindow();

		int width = scaled.getGuiScaledWidth();
		int height = scaled.getGuiScaledHeight();

		if (Variables.guiOpacity > 255) {
			Variables.guiOpacity = 255;
		}

		Color colour = new Color(ConfigHandler.RGB_R, ConfigHandler.RGB_G, ConfigHandler.RGB_B, Variables.guiOpacity);

		int titleStringWidth = font.width(musicGUIString);

		int titleXCoord = 0;
		if (ConfigHandler.musicGUIPositionIsLeft) {
			titleXCoord = 5;
		}
		else if (ConfigHandler.musicGUIPositionIsCenter) {
			titleXCoord = (width/2) - (titleStringWidth/2);
		}
		else {
			titleXCoord = width - titleStringWidth - 5;
		}

		drawText(font, guiGraphics, musicGUIString, titleXCoord, height - ConfigHandler.musicGUIBottomHeightOffset, colour, ConfigHandler.drawTextShadow);
		
		matrixStack.popMatrix();
	}

	public static void onClientTick(ClientLevel clientLevel) {
		if (Variables.fadeIn) {
			if (!ConfigHandler.titleShouldFadeIn) {
				Variables.guiOpacity = 255;
			}
			else if (Variables.guiOpacity < 255) {
				Variables.guiOpacity += 5;
				return;
			}

			Variables.fadeIn = false;
			return;
		}

		if (Variables.guiTicksLeft > 0) {
			Variables.guiTicksLeft -= 1;
			Variables.fadeOut = true;
			return;
		}

		if (Variables.fadeOut) {
			if (!ConfigHandler.titleShouldFadeIn) {
				Variables.guiOpacity = 0;
			}
			else if (Variables.guiOpacity > 0) {
				Variables.guiOpacity -= 5;
				return;
			}

			Variables.fadeOut = false;
		}
	}

	private static void drawText(Font font, GuiGraphics guiGraphics, String content, int x, int y, Color colour, boolean drawShadow) {
		if (Variables.guiOpacity > 10 && !content.equals("")) {
			guiGraphics.drawString(font, Component.literal(content), x, y, colour.getRGB(), drawShadow);
		}
	}
}