package com.wolly.dungeoncrawler.TMXParser;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "objectgroup")
public class ObjectGroup extends BaseLayer {
	private static final long serialVersionUID = -6407974842445173264L;

	@XmlAttribute(name = "draworder")
	private String _drawOrder;
	
	@XmlAttribute(name = "color")
	private String _color;
	
	@XmlElement(name = "object")
	private ArrayList<TileObject> _tileObjects;
	
	public String GetDrawOrder() {
		return _drawOrder;
	}
	
	public String GetColor() {
		return _color;
	}
	
	public ArrayList<TileObject> GetObjects() {
		return _tileObjects;
	}
}
