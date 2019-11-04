package com.wolly.dungeoncrawler.TMXParser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wolly.dungeoncrawler.Config;

@XmlRootElement(name = "tileset")
public class TileSet implements Serializable {
	private static final long serialVersionUID = -2493074483268277348L;

	private transient ArrayList<BufferedImage> _images = new ArrayList<BufferedImage>();
	
	@XmlAttribute(name = "firstgid")
	private int _firstGId;
	
	@XmlAttribute(name = "name")
	private String _name;
	
	@XmlAttribute(name = "tilewidth")
	private int _tileWidth;
	
	@XmlAttribute(name = "tileheight")
	private int _tileHeight;
	
	@XmlAttribute(name = "spacing")
	private int _spacing;
	
	@XmlAttribute(name = "margin")
	private int _margin;
	
	@XmlAttribute(name = "tilecount")
	private int _tileCount;
	
	@XmlAttribute(name = "columns")
	private int _columns;
	
	@XmlElement(name = "image")
	private Image _image;
	
	@XmlElement(name = "properties")
	private Properties _properties;
	
	public int GetFirstId() {
		return _firstGId;
	}
	
	public String GetName() {
		return _name;
	}
	
	public int GetTileWidth() {
		return _tileWidth;
	}
	
	public int GetTileHeight() {
		return _tileHeight;
	}
	
	public int GetSpacing() {
		return _spacing;
	}
	
	public int GetMargin() {
		return _margin;
	}
	
	public int GetTileCount() {
		return _tileCount;
	}
	
	public int GetColumns() {
		return _columns;
	}
	
	public Image GetImage() {
		return _image;
	}
	
	public Properties GetProperties() {
		return _properties;
	}
	
	public ArrayList<BufferedImage> GetImages() {
		if (_images.size() == 0) {
			try {
				final BufferedImage tileSheet = ImageIO.read(new File(Config.AssetsDirectory + GetImage().GetSource().substring(3))); // removing the '../' created by Tiled
				for (int x = 0; x < GetTileCount(); x++) {
					int y = (int) Math.floor((double) (x / GetColumns()));
					final BufferedImage image = tileSheet.getSubimage(x * GetTileWidth(), y * GetTileHeight(), GetTileWidth(), GetTileHeight());
					_images.add(image);
				}
			} catch (IOException e) {
				_images.clear();
				
				e.printStackTrace();
			}
		}
		return _images;
	}
}
