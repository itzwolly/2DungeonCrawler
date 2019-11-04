package com.wolly.dungeoncrawler.core;

import com.wolly.dungeoncrawler.ScriptModule;

@ScriptModule
public class Vector2 {
	public float X;
	public float Y;
	
	public Vector2() {
		X = 0;
		Y = 0;
	}
	
	public Vector2(float pX, float pY) {
		X = pX;
		Y = pY;
	}
	
	public Vector2 Add(Vector2 pOther) {
		X += pOther.X;
		Y += pOther.Y;
		return this;
	}
	
	public Vector2 Subtract(Vector2 pOther) {
		X -= pOther.X;
		Y += pOther.Y;
		return this;
	}
	
	public Vector2 Scale(float pScaling) {
		X *= pScaling;
		Y *= pScaling;
		return this;
	}
	
	public Vector2 Scale(Vector2 pOther) {
		X *= pOther.X;
		Y *= pOther.Y;
		return this;
	}
	
	public int GetX() {
		return (int) X;
	}
	
	public int GetY() {
		return (int) Y;
	}
	
	@Override
	public String toString() {
		return "Vector2(" + X + ", " + Y + ")";
	}
}
