package com.wolly.dungeoncrawler.TMXParser;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "object")
public class TileObject implements Serializable {
	private static final long serialVersionUID = 8428663108941066412L;

	@XmlAttribute(name = "id")
	private int _id;
	
	@XmlAttribute(name = "gid")
	private int _gId;
	
	@XmlAttribute(name = "name")
	private String _name;
	
	@XmlAttribute(name = "x")
	private int _x;
	
	@XmlAttribute(name = "y")
	private int _y;
	
	@XmlAttribute(name = "width")
	private int _width;
	
	@XmlAttribute(name = "height")
	private int _height;
	
	@XmlElement(name = "properties")
	private Properties _properties;
	
	public int GetId() {
		return _id;
	}
	
	public int GetGId() {
		return _gId;
	}
	
	public String GetName() {
		return _name;
	}
	
	public int GetX() {
		return _x;
	}
	
	public int GetY() {
		return _y;
	}
	
	public int GetWidth() {
		return _width;
	}
	
	public int GetHeight() {
		return _height;
	}
	
	public Properties GetProperties() {
		return _properties;
	}
	
	public Property GetScript() {
		return _properties.GetPropertyByName("script");
	}
}
