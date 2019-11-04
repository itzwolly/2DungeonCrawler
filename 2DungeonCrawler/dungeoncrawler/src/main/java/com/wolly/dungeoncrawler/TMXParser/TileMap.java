package com.wolly.dungeoncrawler.TMXParser;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wolly.dungeoncrawler.Debug;

@XmlRootElement(name = "map")
public class TileMap implements Serializable {
	private static final long serialVersionUID = 8109501990653349013L;
	
	public enum Orientation {
		Orthogonal,
		Isometric,
		Staggered,
		Hexagonal
	}
	
	public enum StaggerIndex {
		Odd,
		Even
	}
	
	public enum StaggerAxis {
		X,
		Y
	}
	
	@XmlAttribute(name = "version")
	private String _version;
	
	@XmlAttribute(name = "tiledversion")
	private String _tiledVersion;
	
	@XmlAttribute(name = "orientation")
	private String _orientation;
	
	@XmlAttribute(name = "renderorder")
	private String _renderOrder;
	
	@XmlAttribute(name = "width")
	private int _width;
	
	@XmlAttribute(name = "height")
	private int _height;
	
	@XmlAttribute(name = "tilewidth")
	private int _tileWidth;
	
	@XmlAttribute(name = "tileheight")
	private int _tileHeight;
	
	@XmlAttribute(name = "infinite")
	private boolean _isInfinite;
	
	@XmlAttribute(name = "staggeraxis")
	private String _staggerAxis;
	
	@XmlAttribute(name = "staggerindex")
	private String _staggerIndex;
	
	@XmlAttribute(name = "nextlayerid")
	private int _nextLayerId;
	
	@XmlAttribute(name = "nextobjectid")
	private int _nextObjectId;
	
	@XmlElement(name = "properties")
	private Properties _properties;
	
	@XmlElement(name = "layer")
	private ArrayList<TileLayer> _tileLayers;
	
	@XmlElement(name = "objectgroup")
	private ArrayList<ObjectGroup> _objectLayers;
	
	@XmlElement(name = "imagelayer")
	private ArrayList<ImageLayer> _imageLayers;
	
	@XmlElement(name = "group")
	private ArrayList<GroupLayer> _groupLayers;
	
	@XmlElement(name = "tileset")
	private ArrayList<TileSet> _tileSets;
	
	public String GetVersion() {
		return _version;
	}
	
	public String GetTiledVersion() {
		return _tiledVersion;
	}
	
	public Orientation GetOrientation() {
		String output = _orientation.substring(0, 1).toUpperCase() + _orientation.substring(1);
		return Orientation.valueOf(output);
	}
	
	public StaggerIndex GetStaggerIndex() {
		String output = _staggerIndex.substring(0, 1).toUpperCase() + _staggerIndex.substring(1);
		return StaggerIndex.valueOf(output);
	}
	
	public StaggerAxis GetStaggerAxis() {
		String output = _staggerAxis.substring(0, 1).toUpperCase() + _staggerAxis.substring(1);
		return StaggerAxis.valueOf(output);
	}
	
	public String GetRenderOrder() {
		return _renderOrder;
	}
	
	public int GetWidth() {
		return _width;
	}
	
	public int GetHeight() {
		return _height;
	}
	public int GetTileWidth() {
		return _tileWidth;
	}
	
	public int GetTileHeight() {
		return _tileHeight;
	}
	
	public boolean GetIsInfinite() {
		return _isInfinite;
	}
	
	public int GetNextLayerId() {
		return _nextLayerId;
	}
	
	public int GetNextObjectId() {
		return _nextObjectId;
	}
	
	public Properties GetProperties() {
		return _properties;
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
	
	public ArrayList<GroupLayer> GetGroupLayers() {
		return _groupLayers;
	}
	
	public ArrayList<TileSet> GetTileSets() {
		return _tileSets;
	}
	
	public ArrayList<BufferedImage> GetImages() {
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		for (TileSet ts : _tileSets) {
			images.addAll(0, ts.GetImages());
		}
		return images;
	}
}

