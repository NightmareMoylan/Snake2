package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;

import javax.swing.*;

public abstract class GameState {
	
	protected Timer timer;
	protected String name;
	public int players;
	public int numberOfApples;
	public int applesToWin;
	public Snake[] snakes;
	public Apple [] apples;
	
	public abstract void draw(Graphics g);
	
	public abstract void move();
	
	public abstract void checkCollisions();
	
	public abstract void checkWinner();
	
	public abstract void startGame();
	
	public String getName() {
		return this.name;
	}

}
