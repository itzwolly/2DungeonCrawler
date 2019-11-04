package com.wolly.dungeoncrawler.TMXParser;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "layer")
public class TileLayer extends BaseLayer {
	private static final long serialVersionUID = -8670521460150820703L;
	
	private transient int[][] _layout;
	private transient boolean _hasLoaded;
	
	@XmlAttribute(name = "width")
	private int _width;
	
	@XmlAttribute(name = "height")
	private int _height;
	
	@XmlAttribute(name = "locked")
	private Boolean _isLocked;
	
	@XmlAttribute(name = "opacity")
	private float _opacity;
	
	@XmlAttribute(name = "offsetx")
	private float _offsetX;
	
	@XmlAttribute(name = "offsety")
	private float _offsetY;
	
	@XmlElement(name = "data")
	private Data _data;
	
	public int GetWidth() {
		return _width;
	}
	
	public int GetHeight() {
		return _height;
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
	
	public Data GetData() {
		return _data;
	}
	
	public int[][] GetLayout() {
		if (!_hasLoaded) {
			_layout = new int[GetHeight()][GetWidth()];
			String[] row = GetData().GetInnerText().get(0).split("\n");
			for (int i = 1; i < row.length; i++) {
				String[] col = row[i].split(",");
				for (int j = 0; j < col.length; j++) {
					int id = Integer.parseInt(col[j]);
					_layout[i - 1][j] = id;
				}
			}
			_hasLoaded = true;
		}
		return _layout;
	}
}
