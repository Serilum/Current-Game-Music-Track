package com.serilum.currentgamemusictrack.config;

import com.natamus.collective.config.DuskConfig;
import com.serilum.currentgamemusictrack.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0, max = 1200) public static int durationTitleShownInTicks = 80;
	@Entry public static boolean titleShouldFadeIn = true;
	@Entry public static boolean titleShouldFadeOut = true;
	@Entry(options = {"Left", "Center", "Right"}) public static String musicGUIPosition = "Center";
	@Entry(min = 0, max = 3000) public static int musicGUIBottomHeightOffset = 72;
	@Entry(min = -3000, max = 3000) public static int musicGUIWidthOffset = 0;
	@Entry public static boolean drawTextShadow = true;
	@Entry(rgb = true) public static String RGB = "13,120,26";

	public static void initConfig() {
		configMetaData.put("durationTitleShownInTicks", Arrays.asList(
			"How long the music track title should be visible on the screen. 20 ticks = 1 second."
		));
		configMetaData.put("titleShouldFadeIn", Arrays.asList(
			"Whether the music track title should fade in."
		));
		configMetaData.put("titleShouldFadeOut", Arrays.asList(
			"Whether the music track title should fade out."
		));
		configMetaData.put("musicGUIPosition", Arrays.asList(
			"Where the music GUI is shown at the bottom of the screen."
		));
		configMetaData.put("musicGUIBottomHeightOffset", Arrays.asList(
			"The vertical offset (y coord) for the music GUI. This determines how far up the text should be on the screen. Can be changed to prevent GUIs from overlapping."
		));
		configMetaData.put("musicGUIWidthOffset", Arrays.asList(
			"The horizontal offset (x coord) for the music GUI."
		));
		configMetaData.put("drawTextShadow", Arrays.asList(
			"If the text displayed should have a shadow drawn below it."
		));
		configMetaData.put("RGB", Arrays.asList(
			"The colour of the music GUI text, as red, green and blue values from 0 to 255."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}