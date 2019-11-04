package com.wolly.dungeoncrawler.TMXParser;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wolly.dungeoncrawler.Debug;

@XmlRootElement(name = "properties")
public class Properties implements Serializable {
	private static final long serialVersionUID = 3078536375976482940L;
	
	@XmlElement(name = "property")
	private ArrayList<Property> _properties;
	
	public Property GetPropertyByName(String pName) {
		for (Property prop : _properties) {
			if (prop.GetName().equals(pName)) {
				return prop;
			}
		}
		return null;
	}
	
	public ArrayList<Property> GetProperties() {
		return _properties;
	}
}
