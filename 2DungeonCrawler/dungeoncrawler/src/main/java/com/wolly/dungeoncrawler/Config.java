package com.wolly.dungeoncrawler;

import com.wolly.dungeoncrawler.core.Vector2;

public class Config {
	public static String CurrentDirectory = System.getProperty("user.dir");
	public static String AssetsDirectory = CurrentDirectory + "\\assets\\";
	public static String ScriptsDirectory = AssetsDirectory + "scripts\\";
	public static String BasePackage = "com.wolly.dungeoncrawler";
	public static Vector2 GameSize = new Vector2(800, 600);
}
