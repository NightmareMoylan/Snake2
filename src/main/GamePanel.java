package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Random;

public class GamePanel extends JPanel{
	
	static final int SCREEN_WIDTH = 1200;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	
	public GameFrame frame;
	public GameState state;
	public Handler handler;
	public GridBagConstraints gbc = new GridBagConstraints();
	
	private String winner = "nobody";
	private String victoryReason = "none";
	public String player1Name = "Player 1";
	public String player2Name = "Player 2";
	
	public GamePanel(GameFrame frame) {
		this.frame = frame;
		this.handler = new Handler(this);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.setLayout(new GridBagLayout());
		this.setVisible(true);
		//take out below
		this.state = new MenuState(this, "mainMenu", 1, 1, 30);
		this.addKeyListener(new MyKeyListener(this));
	}
	
	public void paint(Graphics gNormal) {
		Graphics2D g = (Graphics2D)gNormal;
		this.state.draw(g);
	}
	
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	public String getWinner() {
		return this.winner;
	}
	
	public void setState(GameState state) {
		this.state = state;
		this.repaint();
	}
	
	public String getVictoryReason() {
		return this.victoryReason;
	}
	
	public void setVictoryReason(String reason) {
		this.victoryReason=reason;
	}
	
	public GameState getState() {
		return this.state;
	}
	
}
