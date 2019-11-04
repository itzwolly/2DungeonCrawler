package com.wolly.dungeoncrawler.TMXParser;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class BaseLayer implements Serializable {
	private static final long serialVersionUID = 8776076558351451355L;
	
	@XmlAttribute(name = "id")
	private int _id;
	
	@XmlAttribute(name = "name")
	private String _name;
	
	@XmlAttribute(name = "visible")
	private boolean _isVisible;
	
	@XmlAttribute(name = "locked")
	private boolean _isLocked;
	
	@XmlAttribute(name = "opacity")
	private float _opacity;
	
	@XmlAttribute(name = "offsetx")
	private float _offsetX;
	
	@XmlAttribute(name = "offsety")
	private float _offsetY;
	
	@XmlElement(name = "properties")
	private Properties _properties;
	
	
	public int GetId() {
		return _id;
	}
	
	public boolean GetIsVisible() {
		return _isVisible;
	}
	
	public boolean GetIsLocked() {
		return _isLocked;
	}
	
	public float GetOpacity() {
		return _opacity;
	}
	
	public float GetOffsetX() {
		return _offsetX;
	}
	
	public float GetOffsetY() {
		return _offsetY;
	}
	
	public String GetName() {
		return _name;
	}
	
	public Properties GetProperties() {
		return _properties;
	}
}
