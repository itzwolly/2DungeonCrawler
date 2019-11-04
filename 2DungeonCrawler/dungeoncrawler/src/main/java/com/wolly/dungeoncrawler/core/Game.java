package com.wolly.dungeoncrawler.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;

import javax.swing.Timer;
import javax.xml.bind.JAXBException;

import org.python.util.PythonInterpreter;

import com.wolly.dungeoncrawler.Config;
import com.wolly.dungeoncrawler.Debug;
import com.wolly.dungeoncrawler.EventHandler;
import com.wolly.dungeoncrawler.Debug.ThreatLevel;

public class Game implements ActionListener {
	private static Game _instance;
	
	private final Vector2 _size;
	private Window _window;
	private Map _currentMap;
	private Timer _timer;
	
	private Game(Vector2 pSize) {
		_size = pSize;
	}
	
    public static void main(String[] pArgs) {
        Game game = Game.GetInstance();
        game.Build();
        game.Run();
    }

    public void Build() {
    	_window = new Window("2Dungeon Crawler", new Vector2(_size.GetX(), _size.GetY()));
    	LoadMap("levels\\level_one.tmx");
    }
    
    public void Run() {
    	_timer = new Timer(1000 / 60, this);
    	_timer.setInitialDelay(0);
    	_timer.start();
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		update();
	}
    
    private void update() {
    	for (GameObject obj : GameObject.getGameObjects()) {
    		obj.Update();
    	}
    	_window.repaint(); // Graphics
    }
    
    public boolean LoadMap(String pFilePath) {
    	try {
			_currentMap = new Map(pFilePath);
			return true;
		} catch (JAXBException e) {
			Debug.Log(e.getMessage(), ThreatLevel.Error);
			return false;
		}
    }
    
    public Map GetMap() {
    	return _currentMap;
    }
    
    public Vector2 GetSize() {
    	return _size;
    }
    
    public static Game GetInstance() {
    	if (_instance == null) {
    		_instance = new Game(new Vector2(Config.GameSize.GetX(), Config.GameSize.GetY()));
    	}
    	return _instance;
    }
}
