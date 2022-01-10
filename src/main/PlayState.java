package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.util.Random;
import javax.swing.*;

public class PlayState extends GameState{
	
	private static final int delay = 100;
	public boolean paused = false;
	public GamePanel panel;
	
	
	public PlayState(GamePanel panel, int players, int appleNumber, int applesToWin, String player1Name, String player2Name) {
		this.players = players;
		this.numberOfApples = appleNumber;
		this.applesToWin = applesToWin;
		this.panel=panel;
		this.name="playState";
		this.snakes = new Snake[this.players];
		this.apples = new Apple[this.numberOfApples];
		this.snakes[0] = new Snake(6, 0, 0, 0, player1Name, "green", this);
		if(this.players == 2) {
			this.snakes[1] = new Snake(6, 0, 0, GamePanel.SCREEN_HEIGHT-GamePanel.UNIT_SIZE, player2Name, "pink", this);
		}
		for(int i=0; i<this.apples.length;i++) {
			this.apples[i] = new Apple(this);
		}
		this.name = "playState";
		this.timer = new Timer(delay, this.panel.handler);
		
		this.timer.start();
	}


	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
		
		g.setColor(Color.darkGray);
		for(int i=1; i<GamePanel.SCREEN_WIDTH/GamePanel.UNIT_SIZE; i++) {
			g.drawLine(i*GamePanel.UNIT_SIZE, 0, i*GamePanel.UNIT_SIZE, GamePanel.SCREEN_HEIGHT);
		}
		for(int i=1; i<GamePanel.SCREEN_HEIGHT/GamePanel.UNIT_SIZE; i++) {
			g.drawLine(0, i*GamePanel.UNIT_SIZE, GamePanel.SCREEN_WIDTH, i*GamePanel.UNIT_SIZE);
		}
		
		for(int i = 0; i<this.snakes.length; i++) {
			this.snakes[i].draw(g);
		}
		for(int i = 0; i<this.numberOfApples; i++) {
			this.apples[i].draw(g);
		}
		g.setColor(Color.white);
		g.setFont(new Font("Ink Free", Font.BOLD, GamePanel.UNIT_SIZE));
		for(int i = this.players-1; i>=0;i--) {
			g.drawString(this.snakes[i].name+": "+this.snakes[i].applesEaten, 0, GamePanel.SCREEN_HEIGHT-((this.players-1-i)*GamePanel.UNIT_SIZE)-5);
		}
		g.drawString("Score to win: "+this.applesToWin, 0, GamePanel.SCREEN_HEIGHT-(this.players*GamePanel.UNIT_SIZE)-5);
	}
	
	public void move() {
		for(int i = 0; i<this.snakes.length; i++) {
			snakes[i].move();
		}
	}
	
	public void checkCollisions() {
		for(int i = 0; i<this.snakes.length; i++) {
			//check for collision with left
			if(this.snakes[i].x[0] == 0-GamePanel.UNIT_SIZE) {
				this.snakes[i].x[0] = GamePanel.SCREEN_WIDTH-GamePanel.UNIT_SIZE;
			}
			//check for collision with top border
			if(this.snakes[i].y[0] == 0-GamePanel.UNIT_SIZE) {
				this.snakes[i].y[0] = GamePanel.SCREEN_HEIGHT-GamePanel.UNIT_SIZE;
			}
			//check for collision with bottom border
			if(this.snakes[i].y[0] == GamePanel.SCREEN_HEIGHT) {
				this.snakes[i].y[0] = 0;
			}
			//check for collision with right border
				if(this.snakes[i].x[0] == GamePanel.SCREEN_WIDTH) {
					this.snakes[i].x[0] = 0;
				}
		}
		//check collision with apple
		for(int i=0;i<this.snakes.length;i++) {
			for(int j=0;j<this.apples.length;j++) {
				if(this.snakes[i].x[0] == this.apples[j].x && this.snakes[i].y[0] == this.apples[j].y) {
					this.snakes[i].applesEaten++;
					this.snakes[i].bodyParts++;
					this.snakes[i].x[this.snakes[i].bodyParts-1] = -2*GamePanel.UNIT_SIZE;
					this.snakes[i].y[this.snakes[i].bodyParts-1] = -2*GamePanel.UNIT_SIZE;
					this.apples[j].generate();
				}
			}
		}
		//check collision with other snake parts
		for(int i=0;i<this.players;i++) {
			for(int j=0;j<this.players;j++) {
				for(int k=0;k<this.snakes[j].bodyParts;k++) {
					if(this.snakes[i].x[0] == this.snakes[j].x[k] && this.snakes[i].y[0] == this.snakes[j].y[k]) {
						if(i==j && k==0) {
						}
						else if(i==j && k==2*this.snakes[i].movesInDirection) {
						}
						else {
							this.snakes[i].collidesWithSnake = true;
						}
						if(this.snakes[i].collidesWithSnake) {
							System.out.println(this.snakes[i].name+" collided with "+this.snakes[j].name+" at section"+k);
							System.out.println(this.snakes[i].collidesWithSnake);
						}
					}
				}
			}
		}
	}
	
	public void checkWinner() {
		if(this.players>1) {
			if(this.snakes[0].collidesWithSnake && this.snakes[1].collidesWithSnake) {
				this.panel.setWinner("A Draw!");
				this.panel.setVictoryReason("Both players collided!");
			}
			else if(this.snakes[0].applesEaten >= this.applesToWin && this.snakes[1].applesEaten >= this.applesToWin) {
				this.panel.setWinner("A Draw!");
				this.panel.setVictoryReason("Both players reached the winning score!");
			}
			else {
				for(int i=0; i<this.snakes.length; i++) {
					if(this.snakes[i].collidesWithSnake) {
						if(i==0) {
							this.panel.setWinner(this.snakes[1].name);
							this.panel.setVictoryReason(this.snakes[0].name+" crashed.");
						}else if(i==1) {
							this.panel.setWinner(this.snakes[0].name);
							this.panel.setVictoryReason(this.snakes[1].name+" crashed.");
						}
					}else {
						if(this.snakes[i].applesEaten >= this.applesToWin) {
							this.panel.setWinner(this.snakes[i].name);
							this.panel.setVictoryReason(this.snakes[i].name+" reached the winning score!");
						}
					}
				}
			}
		}
		else { //if only one player
			if(this.snakes[0].collidesWithSnake) {
				this.panel.setWinner("You Lose!");
				this.panel.setVictoryReason("You bumped into yourself");
			}else if(this.snakes[0].applesEaten>=this.applesToWin) {
				this.panel.setWinner(this.snakes[0].name);
				this.panel.setVictoryReason("You ate all the apples!");
			}
		}
		if(this.panel.getWinner() != "nobody") { //then do game over
			this.gameOver();
			System.out.println(this.panel.getWinner());
			System.out.println(this.panel.getVictoryReason());
		}
	}


	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}
	
	public void gameOver() {
		this.timer.stop();
		this.panel.state = new MenuState(this.panel, "gameOver", this.players, this.numberOfApples, this.applesToWin);
		this.panel.revalidate();
		this.panel.repaint();
	}
	
}
