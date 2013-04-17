package com.bennyp12.goldsmelter.misc;

import java.awt.Image;

import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class Vars {

	public static int gainedExp;
	public static int currentExp;
	public static int StartingExp = Skills.getExperience(Skills.SMITHING);
	public static int expPerHour;
	public static int loads;

	public static Image paintImage;

	public static boolean error = false;

	public static String timeRan;

	public static Area bankArea;
	public static Area smithArea;
	public static Tile[] path;
	public static int furnace = 0;

}
