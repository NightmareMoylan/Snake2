package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener{

	private GamePanel panel;
	
	public MyKeyListener(GamePanel panel) {
		this.panel=panel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(this.panel.state.name =="playState") {
			if(this.panel.state.players == 1) {
				switch(e.getKeyCode()) {
				case 38: //up
					if(this.panel.state.snakes[0].direction != 'u') {
						this.panel.state.snakes[0].direction = 'u';
						this.panel.state.snakes[0].movesInDirection = 0;
					}
					break;
				case 40: //down
					if(this.panel.state.snakes[0].direction != 'd') {
						this.panel.state.snakes[0].direction = 'd';
						this.panel.state.snakes[0].movesInDirection = 0;
					}
					break;
				case 37: //left
					if(this.panel.state.snakes[0].direction != 'l') {
						this.panel.state.snakes[0].direction = 'l';
						this.panel.state.snakes[0].movesInDirection = 0;
					}
					break;
				case 39: //right
					if(this.panel.state.snakes[0].direction != 'r') {
						this.panel.state.snakes[0].direction = 'r';
						this.panel.state.snakes[0].movesInDirection = 0;
					}
					break;
				}
			}else {
				switch(e.getKeyCode()) {
				case 38: //up
					if(this.panel.state.snakes[1].direction != 'u') {
						this.panel.state.snakes[1].direction = 'u';
						this.panel.state.snakes[1].movesInDirection = 0;
					}
					break;
				case 40: //down
					if(this.panel.state.snakes[1].direction != 'd') {
						this.panel.state.snakes[1].direction = 'd';
						this.panel.state.snakes[1].movesInDirection = 0;
					}
					break;
				case 37: //left
					if(this.panel.state.snakes[1].direction != 'l') {
						this.panel.state.snakes[1].direction = 'l';
						this.panel.state.snakes[1].movesInDirection = 0;
					}
					break;
				case 39: //right
					if(this.panel.state.snakes[1].direction != 'r') {
						this.panel.state.snakes[1].direction = 'r';
						this.panel.state.snakes[1].movesInDirection = 0;
					}
					break;
				case 87: //w
					if(this.panel.state.snakes[0].direction != 'u') {
						this.panel.state.snakes[0].direction = 'u';
						this.panel.state.snakes[0].movesInDirection = 0;
					}
					break;
				case 65: //a
					if(this.panel.state.snakes[0].direction != 'l') {
						this.panel.state.snakes[0].direction = 'l';
						this.panel.state.snakes[0].movesInDirection = 0;
					}
					break;
				case 83: //s
					if(this.panel.state.snakes[0].direction != 'd') {
						this.panel.state.snakes[0].direction = 'd';
						this.panel.state.snakes[0].movesInDirection = 0;
					}
					break;
				case 68: //d
					if(this.panel.state.snakes[0].direction != 'r') {
						this.panel.state.snakes[0].direction = 'r';
						this.panel.state.snakes[0].movesInDirection = 0;
					}
					break;
				}
			}
		}
		else if(this.panel.state.name == "mainMenu") {
			if(e.getKeyCode() == 10) { //enter
				this.panel.state.startGame();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
