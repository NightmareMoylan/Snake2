package main;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {

	public int bodyParts;
	public int applesEaten;
	public int movesInDirection = 0;
	public String color;
	public String name;
	public int[] x = new int[GamePanel.UNITS];
	public int[] y = new int[GamePanel.UNITS];
	public char direction = 'r';
	final int startX;
	final int startY;
	private PlayState state;
	public boolean collidesWithSnake = false;
	
	public Snake(int bodyParts, int applesEaten, int startX, int startY, String name, String color, PlayState state) {
		this.bodyParts = bodyParts;
		this.applesEaten = applesEaten;
		this.startX = startX;
		this.startY = startY;
		this.name = name;
		this.color = color;
		this.state = state;
		this.x[0]=this.startX;
		this.y[0]=this.startY;
		for(int i=1; i<this.bodyParts; i++) {
			this.x[i] = this.x[i-1]-GamePanel.UNIT_SIZE;
		}
		for(int i=1; i<this.bodyParts; i++) {
			this.y[i] = this.y[i-1];
		}
	}
	
	public void draw(Graphics g) {
		if(this.color == "green") {
			g.setColor(new Color(45,180,0));
			for(int i=1; i<this.bodyParts;i++) {
				g.fillOval(x[i],  y[i],  GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
			}
			g.setColor(Color.green);
			g.fillOval(x[0], y[0], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
		}else if(this.color == "pink") {
			g.setColor(new Color(249,102,241));
			for(int i=1; i<this.bodyParts;i++) {
				g.fillOval(x[i],  y[i],  GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
			}
			g.setColor(new Color(237,10,225));
			g.fillOval(x[0], y[0], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
		}
	}
	
	public void move() {
			for(int i = this.bodyParts-1; i>0; i--) {
				this.x[i] = this.x[i-1];
				this.y[i] = this.y[i-1];
			}
		
			switch(this.direction) {
			case 'r':
				this.x[0] += GamePanel.UNIT_SIZE;
				break;
			case 'l':
				this.x[0] -= GamePanel.UNIT_SIZE;
				break;
			case 'u':
				this.y[0] -= GamePanel.UNIT_SIZE;
				break;
			case 'd':
				this.y[0] += GamePanel.UNIT_SIZE;
				break;
			default:
				System.out.println("There's a fault in the direction switch in the move method in Snake; it's "+this.direction);
				break;
			}
			this.movesInDirection++;
	}
}
