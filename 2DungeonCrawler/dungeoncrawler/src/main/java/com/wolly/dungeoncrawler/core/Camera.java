package com.wolly.dungeoncrawler.core;

import com.wolly.dungeoncrawler.Debug;
import com.wolly.dungeoncrawler.ScriptModule;

@ScriptModule
public class Camera extends GameObject {
	private static final long serialVersionUID = -1404201254477119535L;
	private static Camera _instance;
	
	private Camera() {
		super("Camera");
	}
	
	@Override
	public void SetTexture(String pFilePath) {
		Debug.LogWarning("A camera is a non visible GameObject, please refrain from setting an image.");
	}
	
	public static Camera GetInstance() {
		if (_instance == null) {
			_instance = new Camera();
		}
		return _instance;
	}
}
