package com.bennyp12.goldsmelter.misc;

import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Const {

	public static final int GOLD_ORE = 444;
	public static final int GOLD_BAR = 2357;
	public static final WidgetChild SMELTING_SCREEN = Widgets.get(1251, 25);
	public static final WidgetChild SMELTING_BUTTON = Widgets.get(1370, 20);

	public static final long STARTING_TIME = System.currentTimeMillis();

	public static String PAINT_URL = "http://i.imgur.com/G166nW5.jpg";

	public static final Area ALK_SMITH = new Area(new Tile[] { new Tile(3269, 3192, 0), new Tile(3269, 3187, 0), new Tile(3278, 3187, 0), new Tile(3278, 3193, 0) });
	public static final Area ALK_BANK = new Area(new Tile[] { new Tile(3266, 3172, 0), new Tile(3266, 3164, 0), new Tile(3272, 3163, 0), new Tile(3272, 3172, 0) });
	public static final Tile[] ALK_PATH = new Tile[] { new Tile(3269, 3168, 0), new Tile(3272, 3166, 0), new Tile(3275, 3168, 0), new Tile(3275, 3171, 0), new Tile(3275, 3174, 0), new Tile(3275, 3177, 0), new Tile(3276, 3180, 0), new Tile(3277, 3183, 0), new Tile(3278, 3186, 0), new Tile(3279, 3189, 0), new Tile(3276, 3190, 0), new Tile(3273, 3190, 0), new Tile(3272, 3189, 0) };
	public static final int ALK_FURNACE = 76293;
	public static final Area ALK_AREA = new Area(new Tile[] { new Tile(3262, 3195, 0), new Tile(3264, 3154, 0), new Tile(3280, 3155, 0), new Tile(3281, 3197, 0) });

	public static final Area EDGE_BANK = new Area(new Tile[] { new Tile(3089, 3500, 0), new Tile(3088, 3487, 0), new Tile(3092, 3487, 0), new Tile(3092, 3495, 0), new Tile(3097, 3496, 0), new Tile(3098, 3500, 0) });
	public static final Area EDGE_SMITH = new Area(new Tile[] { new Tile(3104, 3503, 0), new Tile(3104, 3496, 0), new Tile(3112, 3496, 0), new Tile(3112, 3503, 0) });
	public static final Tile[] EDGE_PATH = new Tile[] { new Tile(3107, 3499, 0), new Tile(3104, 3499, 0), new Tile(3101, 3499, 0), new Tile(3098, 3498, 0), new Tile(3095, 3497, 0), new Tile(3095, 3496, 0) };
	public static final int EDGE_FURNACE = 26814;
	public static final Area EDGE_AREA = new Area(new Tile[] { new Tile(3086, 3507, 0), new Tile(3086, 3483, 0), new Tile(3115, 3482, 0), new Tile(3115, 3507, 0) });

}
 
