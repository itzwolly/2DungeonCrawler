package com.wolly.dungeoncrawler;

import java.awt.event.KeyEvent;

import org.python.core.PyString;

import com.wolly.dungeoncrawler.Debug.ThreatLevel;
import com.wolly.dungeoncrawler.core.GameObject;
import com.wolly.dungeoncrawler.core.ScriptHandler;

public class EventHandler implements IScriptListener {

	private static EventHandler _instance;
	
	public static EventHandler GetInstance() {
		if (_instance == null) {
			_instance = new EventHandler();
		}
		return _instance;
	}
	
	@Override
	public void OnStart() {
		//ScriptHandler.GetInstance().callMethod("OnStart");
	}

	@Override
	public void OnCollision(GameObject pOther) {
		//ScriptHandler.GetInstance().callMethod("OnCollision", pOther);
	}

	@Override
	public void OnUpdate() {
		//ScriptHandler.GetInstance().callMethod("OnUpdate");
	}

	@Override
	public void OnKeyTyped(KeyEvent pEvent) {
//		try {
//			PyString key = new PyString(pEvent.getKeyChar());
//			ScriptHandler.GetInstance().callMethod("onKeyTyped", key);
//		} catch (IllegalArgumentException e) {
//			// Debug.Log(e.getMessage(), ThreatLevel.Error);
//		}
	}

	@Override
	public void OnKeyPressed(KeyEvent pEvent) {
//		try {
//			PyString key = new PyString(pEvent.getKeyChar());
//			ScriptHandler.GetInstance().callMethod("onKeyPressed", key);
//		} catch (IllegalArgumentException e) {
//			// Debug.Log(e.getMessage(), ThreatLevel.Error);
//		}
	}

	@Override
	public void OnKeyReleased(KeyEvent pEvent) {
//		try {
//			PyString key = new PyString(pEvent.getKeyChar());
//			ScriptHandler.GetInstance().callMethod("onKeyReleased", key);
//		} catch (IllegalArgumentException e) {
//			// Debug.Log(e.getMessage(), ThreatLevel.Error);
//		}
	}
}
