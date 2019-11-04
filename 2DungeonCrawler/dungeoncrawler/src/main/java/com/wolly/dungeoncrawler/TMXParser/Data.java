package com.wolly.dungeoncrawler.TMXParser;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class Data implements Serializable {
	private static final long serialVersionUID = -3196875417206583739L;

	@XmlAttribute(name = "encoding")
	private String _encoding;
	
	@XmlElementRef(name = "chunk")
	public Chunk _chunk;
	
	@XmlMixed
	private ArrayList<String> _innerText;
	
	public String GetEncoding() {
		return _encoding;
	}
	
	public ArrayList<String> GetInnerText() {
		return _innerText;
	}
	
	public Chunk GetChunk() {
		return _chunk;
	}
}
