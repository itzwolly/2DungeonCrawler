package com.wolly.dungeoncrawler.core;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.wolly.dungeoncrawler.EventHandler;

public class Window extends JPanel implements KeyListener {
	private static final long serialVersionUID = -1585224709532666243L;
	
	private String _title;
	private JFrame _JFrame;
	
	public Window(String pTitle, Vector2 pSize) {
		this(pTitle, pSize, Color.BLACK, true, true);
	}
	
	public Window(String pTitle, Vector2 pSize, Color pBackgroundColor, boolean pIsVisible, boolean pIsResizable) {
		Setup(pTitle, pSize, pBackgroundColor, pIsVisible, pIsResizable);
	}
	
	public String GetTitle() {
		return _title;
	}
	
	public JFrame GetContent() {
		return _JFrame;
	}
	
	private void Setup(String pTitle, Vector2 pSize, Color pBackgroundColor, boolean isVisible, boolean isResizable) {
		setBackground(pBackgroundColor);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		_JFrame = new JFrame(pTitle);
		_JFrame.setUndecorated(false);
		_JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_JFrame.setLocation(dim.width / 2 - pSize.GetX() / 2, dim.height / 2 - pSize.GetY() / 2);
		_JFrame.setResizable(isResizable);

		Container content = _JFrame.getContentPane();
		content.setPreferredSize(new Dimension(pSize.GetX(), pSize.GetY()));
		_JFrame.pack();
		_JFrame.setLocationRelativeTo(null);
		_JFrame.setVisible(isVisible);
		content.add(this);
		
		_JFrame.addKeyListener(this);
		_JFrame.setFocusable(true);
	}
	
	@Override
	protected void paintComponent(Graphics pGraphics) {
		super.paintComponent(pGraphics);
		
		Map map = Game.GetInstance().GetMap();
		if (map != null) {
			map.Render(pGraphics);
		}
	}

	@Override
	public void keyPressed(KeyEvent pEvent) {
		EventHandler.GetInstance().OnKeyPressed(pEvent);
	}

	@Override
	public void keyReleased(KeyEvent pEvent) {
		EventHandler.GetInstance().OnKeyReleased(pEvent);
	}

	@Override
	public void keyTyped(KeyEvent pEvent) {
		EventHandler.GetInstance().OnKeyTyped(pEvent);
	}
}
