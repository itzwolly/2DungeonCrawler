package com.wolly.dungeoncrawler;

import java.awt.event.KeyEvent;

import com.wolly.dungeoncrawler.core.GameObject;

public interface IScriptListener {
	void OnStart();
	void OnCollision(GameObject pOther);
	void OnUpdate();
	void OnKeyTyped(KeyEvent pEvent);
	void OnKeyPressed(KeyEvent pEvent);
	void OnKeyReleased(KeyEvent pEvent);
}
