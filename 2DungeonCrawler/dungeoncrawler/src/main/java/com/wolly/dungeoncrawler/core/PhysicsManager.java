package com.wolly.dungeoncrawler.core;

public class PhysicsManager {
	private static PhysicsManager _instance;
	
	private PhysicsManager() {
		// Empty
	}
	
//	public void update() {
//		for (GameObject obj : GameObject.getGameObjects()) {
//			obj.Position.Add(obj.Velocity);
//		}
//	}
	
	public static PhysicsManager GetInstance() {
		if (_instance == null) {
			_instance = new PhysicsManager();
		}
		return _instance;
	}
}
