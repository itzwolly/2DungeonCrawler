package com.wolly.dungeoncrawler.TMXParser;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "chunk")
public class Chunk implements Serializable {
	private static final long serialVersionUID = -8693979178149604392L;
	
	@XmlAttribute(name = "x")
	private int _x;
	
	@XmlAttribute(name = "y")
	private int _y;
	
	@XmlAttribute(name = "width")
	private int _width;
	
	@XmlAttribute(name = "height")
	private int _height;
	
	@XmlValue
	private String _innerText;
	
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
	
	public String GetInnerText() {
		return _innerText;
	}
}
