package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;


public class Handler implements ActionListener{
	
	private GamePanel panel;
	private KeyAdapter adapter;
	
	public Handler(GamePanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.panel.state.timer) {
			if(this.panel.state.getName() == "playState") {
				this.panel.state.move();
				this.panel.state.checkCollisions();
				this.panel.state.checkWinner();
			}
		}
		
		this.panel.repaint();
	}

}
