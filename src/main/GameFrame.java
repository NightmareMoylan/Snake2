package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	public GamePanel panel;
	
	public GameFrame() {
		this.panel = new GamePanel(this);
		this.add(panel);
		this.setTitle("Snake 2");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
