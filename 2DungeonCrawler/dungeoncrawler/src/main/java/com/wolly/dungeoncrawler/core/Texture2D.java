package com.wolly.dungeoncrawler.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.wolly.dungeoncrawler.Config;
import com.wolly.dungeoncrawler.Debug;
import com.wolly.dungeoncrawler.Debug.ThreatLevel;

public class Texture2D {
	private boolean _isVisible;
	private BufferedImage _image;
	
	public Texture2D(String pFilePath) {
		this(pFilePath, true);
	}
	
	public Texture2D(BufferedImage pImage) {
		this(pImage, true);
	}
	
	public Texture2D(BufferedImage pImage, boolean pIsVisible) {
		_image = pImage;
		_isVisible = pIsVisible;
	}
	
	public Texture2D(String pFilePath, boolean pIsVisible) {
		try {
			_image = ImageIO.read(new File(pFilePath));
			_isVisible = pIsVisible;
		} catch (IOException e) {
			Debug.Log("No such image exists: " + Config.AssetsDirectory + pFilePath, ThreatLevel.Warning);
		}
	}
	
	public void SetVisibility(boolean pIsVisible) {
		_isVisible = pIsVisible;
	}
	
	public void ToggleVisiblity() {
		SetVisibility(!_isVisible);
	}
	
	public boolean GetVisibility() {
		return _isVisible;
	}
	
	public Vector2 GetSize() {
		return new Vector2(_image.getWidth(), _image.getHeight());
	}
	
	public BufferedImage GetImage() {
		return _image;
	}
}
