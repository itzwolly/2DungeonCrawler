package com.wolly.dungeoncrawler.core;

import java.awt.Graphics;
import javax.xml.bind.JAXBException;

import com.wolly.dungeoncrawler.Config;
import com.wolly.dungeoncrawler.Debug;
import com.wolly.dungeoncrawler.TMXParser.TileMap;
import com.wolly.dungeoncrawler.TMXParser.TileMap.StaggerAxis;
import com.wolly.dungeoncrawler.TMXParser.TileMap.StaggerIndex;
import com.wolly.dungeoncrawler.TMXParser.TileObject;
import com.wolly.dungeoncrawler.TMXParser.ObjectGroup;
import com.wolly.dungeoncrawler.TMXParser.Property;
import com.wolly.dungeoncrawler.TMXParser.TMXParser;
import com.wolly.dungeoncrawler.TMXParser.TileLayer;

public class Map {
	private TileMap _tiledMap;
	
	public Map(String pFilePath) throws JAXBException {
		init(pFilePath);
		populate();
	}
	
	private void init(String pFilePath) throws JAXBException {
		_tiledMap = TMXParser.GetInstance().parse(pFilePath);
	}
	
	private void populate() {
		populateLayers();
		populateObjects();
	}
	
	private void populateLayers() {
		for (TileLayer layer : _tiledMap.GetTileLayers()) {
			int[][] layout = layer.GetLayout();
			for(int i = 0; i < layout.length; i++) {
				for (int j = 0; j < layout[0].length; j++) {
					int tileId = layout[i][j];
					if (tileId != 0) {
						GameObject obj = new GameObject("Tile_" + j + "-" + i);
						obj.Texture = new Texture2D(_tiledMap.GetImages().get(tileId - 1));
						obj.Position = convertCartesianToCurrentOrientation(new Vector2(j, i), obj.Texture.GetSize());
					}
				}
			}
		}
	}
	
	private void populateObjects() {
		for (ObjectGroup objGroup : _tiledMap.GetObjectLayers()) {
			for (TileObject tileObj : objGroup.GetObjects()) {
				int tileId = tileObj.GetGId();
				if (tileId != 0) {
					GameObject obj = new GameObject(tileObj.GetName());
					obj.Texture = new Texture2D(_tiledMap.GetImages().get(tileId - 1));
					obj.Position = new Vector2(tileObj.GetX(), tileObj.GetY() - (obj.Texture.GetSize().Y / 2));
					obj.Script = new Script(Config.ScriptsDirectory + tileObj.GetProperties().GetPropertyByName("script").GetValue(), obj);
				}
			}
		}
	}
	
	public void Render(Graphics pGraphics) {
		for (GameObject obj : GameObject.getGameObjects()) {
			pGraphics.drawImage(obj.Texture.GetImage(), obj.Position.GetX(), obj.Position.GetY(), null);
		}
	}

	private Vector2 convertCartesianToStaggered(Vector2 pPosition, Vector2 pSize) {
		float offsetX = 0;
		boolean isOdd = _tiledMap.GetStaggerIndex() == StaggerIndex.Odd;
		boolean isYAxis = _tiledMap.GetStaggerAxis() == StaggerAxis.Y;
		if (isYAxis) {
			if (isOdd) {
				if (pPosition.GetY() % 2 != 0) {
					offsetX = pSize.GetX() / 2;
				}
			} else {
				if (pPosition.GetY() % 2 == 0) {
					offsetX = pSize.GetX() / 2;
				}
			}
		} else {
			
		}
		return new Vector2(pPosition.GetX() * pSize.GetX() + offsetX, pPosition.GetY() * pSize.GetY() / 4);
	}
	
	private Vector2 convertCartesianToIsometric(Vector2 pPosition, Vector2 pSize) {
		float x = pPosition.GetX() * pSize.GetX() / 2;
		float y = pPosition.GetY() * pSize.GetY() / 2;
		return new Vector2(x - y, (x + y) / 2);
	}
	

	private Vector2 convertCartesianToCurrentOrientation(Vector2 pPosition, Vector2 pSize) {
		switch(_tiledMap.GetOrientation()) {
			case Isometric:
				return convertCartesianToIsometric(pPosition, pSize);
			case Staggered:
				return convertCartesianToStaggered(pPosition, pSize);
			case Orthogonal:
			case Hexagonal:
			default:
				Debug.LogError("This orientations: " + _tiledMap.GetOrientation() + " hasn't been implemented yet!");
				return pPosition;
		}
	}
	
    public TileMap GetTiledMap() {
    	return _tiledMap;
    }
}
