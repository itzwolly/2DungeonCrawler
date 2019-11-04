package com.wolly.dungeoncrawler.TMXParser;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "group")
public class GroupLayer extends BaseLayer {
	private static final long serialVersionUID = 203617623896114467L;

	@XmlElement(name = "group")
	private ArrayList<GroupLayer> _groupLayers;
	
	@XmlElement(name = "layer")
	private ArrayList<TileLayer> _tileLayers;
	
	@XmlElement(name = "imagelayer")
	private ArrayList<ImageLayer> _imageLayers;
	
	@XmlElement(name = "objectgroup")
	private ArrayList<ObjectGroup> _objectLayers;
	
	public ArrayList<GroupLayer> GetGroupLayers() {
		return _groupLayers;
	}
	
	public ArrayList<TileLayer> GetTileLayers() {
		return _tileLayers;
	}
	
	public ArrayList<ObjectGroup> GetObjectLayers() {
		return _objectLayers;
	}
	
	public ArrayList<ImageLayer> GetImageLayers() {
		return _imageLayers;
	}
}
