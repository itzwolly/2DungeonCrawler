package com.wolly.dungeoncrawler.TMXParser;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "image")
public class Image implements Serializable {
	private static final long serialVersionUID = -6118809130900885900L;

	@XmlAttribute(name = "source")
	private String _source;
	
	@XmlAttribute(name = "width")
	private int _width;
	
	@XmlAttribute(name = "height")
	private int _height;
	
	@XmlAttribute(name = "trans")
	private String _transparentColor;
	
	public String GetSource() {
		return _source;
	}
	
	public int GetWidth() {
		return _width;
	}
	
	public int GetHeight() {
		return _height;
	}
	
	public String GetTransparentColor() {
		return _transparentColor;
	}
}
