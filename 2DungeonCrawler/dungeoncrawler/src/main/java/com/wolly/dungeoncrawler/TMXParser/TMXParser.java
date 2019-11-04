package com.wolly.dungeoncrawler.TMXParser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.wolly.dungeoncrawler.Config;
import com.wolly.dungeoncrawler.Debug;

public class TMXParser {
	private static TMXParser _instance;
	
	private Unmarshaller _jUnmarshaller;
	
	private TMXParser() throws JAXBException { 
		JAXBContext jContext = JAXBContext.newInstance(TileMap.class);
		_jUnmarshaller = jContext.createUnmarshaller();
	}
	
	public TileMap parse(String pFilePath) throws JAXBException {
		Debug.Log(Config.AssetsDirectory + pFilePath);
		return (TileMap) _jUnmarshaller.unmarshal(new File(Config.AssetsDirectory + pFilePath));
	}
	
	public static TMXParser GetInstance() throws JAXBException {
		if (_instance == null) {
			_instance = new TMXParser();
		}
		return _instance;
	}
}
