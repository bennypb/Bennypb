package com.bennyp12.goldsmelter.misc;

import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;

public class Methods {

	public static Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
