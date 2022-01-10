package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Apple {

	public int x;
	public int y;
	private Random chance = new Random();
	public PlayState state;
	
	public Apple(PlayState state) {
		this.state = state;
		this.x = chance.nextInt(GamePanel.SCREEN_WIDTH/GamePanel.UNIT_SIZE)*GamePanel.UNIT_SIZE;
		this.y=chance.nextInt(GamePanel.SCREEN_HEIGHT/GamePanel.UNIT_SIZE)*GamePanel.UNIT_SIZE;
	}
	
	public void generate() {
		this.x = chance.nextInt(GamePanel.SCREEN_WIDTH/GamePanel.UNIT_SIZE)*GamePanel.UNIT_SIZE;
		this.y=chance.nextInt(GamePanel.SCREEN_HEIGHT/GamePanel.UNIT_SIZE)*GamePanel.UNIT_SIZE;
		for(int i=0; i<this.state.snakes.length;i++) {
			for(int j = 0; j<this.state.snakes[i].bodyParts;j++) {
				if(this.x==this.state.snakes[i].x[j] && this.y==this.state.snakes[i].y[j]) {
					this.generate();
				}
			}
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
	}
	
}
