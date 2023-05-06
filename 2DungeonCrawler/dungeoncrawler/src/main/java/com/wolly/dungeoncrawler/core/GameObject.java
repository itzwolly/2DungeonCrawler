package com.wolly.dungeoncrawler.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.python.core.PyObject;

import com.wolly.dungeoncrawler.Config;
import com.wolly.dungeoncrawler.Debug;
import com.wolly.dungeoncrawler.IRenderable;
import com.wolly.dungeoncrawler.ScriptModule;
import com.wolly.dungeoncrawler.Debug.ThreatLevel;
import com.wolly.dungeoncrawler.SortedList;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@ScriptModule
public class GameObject extends PyObject {
	private static final long serialVersionUID = 3096339990139146648L;
	
	private Vector2 _size;
	private String _name;
	private String _tag;
	private String _imagePath;
	private ArrayList<String> _labels;
	
	public Vector2 Position;
	public Vector2 Velocity;
	public Texture2D Texture;
	public Script Script;
	
	private static ArrayList<GameObject> _gameObjects = new ArrayList<GameObject>();
	
	public GameObject(String pName) {
		_name = pName;
		_tag = "Untagged";
		_imagePath = "";
		_labels = new ArrayList<>();
		_size = new Vector2();
		Position = new Vector2();
		Velocity = new Vector2();
		Texture = null;
		Script = null;
		_gameObjects.add(this);
	}
	
	public void Update() {
		if (Script != null) {
			Script.callMethod("Update");
		}
	}
	
	public String GetName() {
		return _name;
	}
	
	public String GetTag() {
		return _tag;
	}
	
	public void SetTag(String pTag) {
		_tag = pTag;
	}
	
	public void SetTexture(String pFilePath) {
		_imagePath = Config.AssetsDirectory + pFilePath;
		Texture = new Texture2D(_imagePath);
		_size = Texture.GetSize();
	}
	
	public void SetTexture(Texture2D pImage) {
		Texture = pImage;
		_size = Texture.GetSize();
	}
	
	public String GetImagePath() {
		return _imagePath;
	}
	
	public Vector2 GetSize() {
		return _size;
	}
	
	public void AddLabel(String pLabel) {
		String lower = pLabel.toLowerCase();
		if (HasLabel(lower)) {
			_labels.add(lower);
		}
	}
	
	public boolean HasLabel(String pLabel) {
		String lower = pLabel.toLowerCase();
		return _labels.contains(lower);
	}
	
	public void RemoveLabel(String pLabel) {
		String lower = pLabel.toLowerCase();
		if (HasLabel(lower)) {
			_labels.remove(pLabel);
		}
	}
	
	public static ArrayList<GameObject> getGameObjects() {
		return _gameObjects;
	}
	
	@SuppressWarnings("unused")
	private static long getDuplicateNameCount(String pName) {
		return _gameObjects.stream().filter(o -> (o.GetName().equals(pName))).count();
	}

	public static void printGameObjects() {
		String s = "Available GameObjects: \n";
		for(GameObject obj : _gameObjects) {
			s += "\t" + obj.GetName() + "\n";
		}
		Debug.Log(s);
	}
}
