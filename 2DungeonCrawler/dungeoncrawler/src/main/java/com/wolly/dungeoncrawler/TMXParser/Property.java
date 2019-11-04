package com.wolly.dungeoncrawler.TMXParser;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

public class Property implements Serializable {
	private static final long serialVersionUID = 7519944836052724464L;

	@XmlAttribute(name = "name")
	private String _name;
	
	@XmlAttribute(name = "type")
	private String _type;
	
	@XmlAttribute(name = "value")
	private String _value;
	
	public String GetName() {
		return _name;
	}
	
	public String GetType() {
		return _type;
	}
	
	public String GetValue() {
		return _value;
	}
}
