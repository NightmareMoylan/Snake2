package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MenuState extends GameState implements MouseListener{
	
	public GamePanel panel;
	public JLabel playerNumberLabel;
	public JLabel playersDown;
	public JLabel playerNumber;
	public JLabel playersUp;
	public JLabel appleNumberLabel;
	public JLabel applesDown;
	public JLabel appleNumber;
	public JLabel applesUp;
	public JLabel applesToWinLabel;
	public JLabel applesToWinDown;
	public JLabel applesToWinNumber;
	public JLabel applesToWinUp;
	public JLabel player1NameLabel;
	public JTextField player1;
	public JLabel player2NameLabel;
	public JTextField player2;
	public JLabel start;
	public JLabel placeHolder1;
	public JLabel placeHolder2;
	public JLabel gameOverLabel;
	public JLabel winnerLabel;
	public JLabel victoryReasonLabel;
	public JLabel playAgainButton;
	public JLabel mainMenuButton;
	
	public ImageIcon leftButton;
	public ImageIcon leftButtonHighlighted;
	public ImageIcon rightButton;
	public ImageIcon rightButtonHighlighted;
	public ImageIcon rectButton;
	public ImageIcon rectButtonSelect;
	public ImageIcon rectButtonHighlighted;
	public ImageIcon placeholder;
	
	public MenuState(GamePanel panel, String name, int playerNumber, int appleNumber, int applesToWin) {
		this.name=name;
		this.panel=panel;
		this.players = playerNumber;
		this.numberOfApples = appleNumber;
		this.applesToWin=applesToWin;
		
		this.panel.gbc.insets = new Insets(0,0,0,0);
		
		if(this.name == "mainMenu") {
			this.leftButton = new ImageIcon("bin\\main\\leftButton.png");
			this.leftButtonHighlighted = new ImageIcon("bin\\main\\leftButtonHighlight.png");
			this.rightButton = new ImageIcon("bin\\main\\rightButton.png");
			this.rightButtonHighlighted = new ImageIcon("bin\\main\\rightButtonHighlight.png");
			this.rectButton = new ImageIcon("bin\\main\\rectButton.png");
			this.rectButtonSelect = new ImageIcon("bin\\main\\rectButtonSelect.png");
			this.rectButtonHighlighted = new ImageIcon("bin\\main\\rectButtonHighlight.png");
			this.placeholder = new ImageIcon("bin\\main\\placeholder.png");
			
			for(int i=0; i<this.panel.getComponentCount(); i++) {
				System.out.println("Component "+(i+1)+": "+this.panel.getComponent(i).getName());
			}
			
			this.playerNumberLabel = new JLabel("Number of Players:");
			this.playerNumberLabel.setVisible(true);
			this.playerNumberLabel.setOpaque(true);
			this.playerNumberLabel.setPreferredSize(new Dimension(600, 50));
			this.playerNumberLabel.setFont(new Font("Ink Free", Font.BOLD, 40));
			this.playerNumberLabel.setBackground(Color.black);
			this.playerNumberLabel.setForeground(Color.white);
			this.playerNumberLabel.setHorizontalAlignment(JLabel.CENTER);
			this.playerNumberLabel.setVerticalAlignment(JLabel.BOTTOM);
			
			this.playersDown=new JLabel(this.leftButton);
			this.playersDown.setVisible(true);
			this.playersDown.setOpaque(true);
			this.playersDown.setBackground(Color.black);
			this.playersDown.setPreferredSize(new Dimension(200,100));
			this.playersDown.setName("playersDown");
			this.playersDown.addMouseListener(this);
			
			this.playerNumber = new JLabel(""+this.players);
			this.playerNumber.setPreferredSize(new Dimension(200,100));
			this.playerNumber.setBackground(Color.black);
			this.playerNumber.setForeground(Color.white);
			this.playerNumber.setHorizontalAlignment(JLabel.CENTER);
			this.playerNumber.setVerticalAlignment(JLabel.BOTTOM);
			this.playerNumber.setVisible(true);
			this.playerNumber.setOpaque(true);
			this.playerNumber.setFont(new Font("ink free", Font.BOLD, 60));
			
			this.playersUp=new JLabel(this.rightButton);
			this.playersUp.setVisible(true);
			this.playersUp.setOpaque(true);
			this.playersUp.setBackground(Color.black);
			this.playersUp.setPreferredSize(new Dimension(200,100));
			this.playersUp.setName("playersUp");
			this.playersUp.addMouseListener(this);
			
			this.appleNumberLabel = new JLabel("Number of Apples:");
			this.appleNumberLabel.setVisible(true);
			this.appleNumberLabel.setOpaque(true);
			this.appleNumberLabel.setBackground(Color.black);
			this.appleNumberLabel.setForeground(Color.white);
			this.appleNumberLabel.setFont(new Font("Ink Free", Font.BOLD, 40));
			this.appleNumberLabel.setPreferredSize(new Dimension(600, 100));
			this.appleNumberLabel.setHorizontalAlignment(JLabel.CENTER);
			this.appleNumberLabel.setVerticalAlignment(JLabel.BOTTOM);
			
			this.applesDown = new JLabel(this.leftButton);
			this.applesDown.setVisible(true);
			this.applesDown.setOpaque(true);
			this.applesDown.setBackground(Color.black);
			this.applesDown.setPreferredSize(new Dimension(200,100));
			this.applesDown.setName("applesDown");
			this.applesDown.addMouseListener(this);
			
			this.appleNumber = new JLabel(""+this.numberOfApples);
			this.appleNumber.setPreferredSize(new Dimension(200,100));
			this.appleNumber.setBackground(Color.black);
			this.appleNumber.setForeground(Color.white);
			this.appleNumber.setHorizontalAlignment(JLabel.CENTER);
			this.appleNumber.setVerticalAlignment(JLabel.BOTTOM);
			this.appleNumber.setVisible(true);
			this.appleNumber.setOpaque(true);
			this.appleNumber.setFont(new Font("ink free", Font.BOLD, 60));
			
			this.applesUp = new JLabel(this.rightButton);
			this.applesUp.setVisible(true);
			this.applesUp.setOpaque(true);
			this.applesUp.setBackground(Color.black);
			this.applesUp.setPreferredSize(new Dimension(200,100));
			this.applesUp.setName("applesUp");
			this.applesUp.addMouseListener(this);
			
			this.applesToWinLabel = new JLabel("Apples to win:");
			this.applesToWinLabel.setVisible(true);
			this.applesToWinLabel.setOpaque(true);
			this.applesToWinLabel.setBackground(Color.black);
			this.applesToWinLabel.setForeground(Color.white);
			this.applesToWinLabel.setFont(new Font("Ink Free", Font.BOLD, 40));
			this.applesToWinLabel.setPreferredSize(new Dimension(600, 100));
			this.applesToWinLabel.setHorizontalAlignment(JLabel.CENTER);
			this.applesToWinLabel.setVerticalAlignment(JLabel.BOTTOM);
			
			this.applesToWinDown = new JLabel(this.leftButton);
			this.applesToWinDown.setVisible(true);
			this.applesToWinDown.setOpaque(true);
			this.applesToWinDown.setBackground(Color.black);
			this.applesToWinDown.setPreferredSize(new Dimension(200,100));
			this.applesToWinDown.setName("applesToWinDown");
			this.applesToWinDown.addMouseListener(this);
			
			this.applesToWinNumber = new JLabel(""+this.applesToWin);
			this.applesToWinNumber.setPreferredSize(new Dimension(200,100));
			this.applesToWinNumber.setBackground(Color.black);
			this.applesToWinNumber.setForeground(Color.white);
			this.applesToWinNumber.setHorizontalAlignment(JLabel.CENTER);
			this.applesToWinNumber.setVerticalAlignment(JLabel.BOTTOM);
			this.applesToWinNumber.setVisible(true);
			this.applesToWinNumber.setOpaque(true);
			this.applesToWinNumber.setIcon(this.placeholder);
			this.applesToWinNumber.setHorizontalTextPosition(JLabel.CENTER);
			this.applesToWinNumber.setFont(new Font("ink free", Font.BOLD, 60));
			
			this.applesToWinUp = new JLabel(this.rightButton);
			this.applesToWinUp.setVisible(true);
			this.applesToWinUp.setOpaque(true);
			this.applesToWinUp.setBackground(Color.black);
			this.applesToWinUp.setPreferredSize(new Dimension(200,100));
			this.applesToWinUp.setName("applesToWinUp");
			this.applesToWinUp.addMouseListener(this);
			
			this.player1NameLabel = new JLabel("Player 1 name:");
			this.player1NameLabel.setVisible(true);
			this.player1NameLabel.setOpaque(true);
			this.player1NameLabel.setBackground(Color.black);
			this.player1NameLabel.setForeground(Color.white);
			this.player1NameLabel.setFont(new Font("Ink Free", Font.BOLD, 40));
			this.player1NameLabel.setPreferredSize(new Dimension(600, 50));
			this.player1NameLabel.setHorizontalAlignment(JLabel.CENTER);
			this.player1NameLabel.setVerticalAlignment(JLabel.BOTTOM);
			
			this.player1 = new JTextField();
			this.player1.setPreferredSize(new Dimension(200,100));
			this.player1.setForeground(Color.green);
			this.player1.setBackground(new Color(0,0,50));
			this.player1.setCaretColor(Color.white);
			this.player1.setFont(new Font("Ink Free",Font.BOLD,40));
			this.player1.setHorizontalAlignment(JTextField.CENTER);
			
			this.player2NameLabel = new JLabel("Player 2 name:");
			this.player2NameLabel.setVisible(true);
			this.player2NameLabel.setOpaque(true);
			this.player2NameLabel.setBackground(Color.black);
			this.player2NameLabel.setForeground(Color.white);
			this.player2NameLabel.setFont(new Font("Ink Free", Font.BOLD, 40));
			this.player2NameLabel.setPreferredSize(new Dimension(600, 100));
			this.player2NameLabel.setHorizontalAlignment(JLabel.CENTER);
			this.player2NameLabel.setVerticalAlignment(JLabel.BOTTOM);
			
			this.player2 = new JTextField();
			this.player2.setPreferredSize(new Dimension(200,100));
			this.player2.setForeground(Color.pink);
			this.player2.setBackground(new Color(0,0,50));
			this.player2.setCaretColor(Color.white);
			this.player2.setFont(new Font("Ink Free",Font.BOLD,40));
			this.player2.setHorizontalAlignment(JTextField.CENTER);
			
			this.placeHolder1 = new JLabel(this.placeholder);
			this.placeHolder1.setVisible(true);
			this.placeHolder1.setOpaque(true);
			this.placeHolder1.setPreferredSize(new Dimension(200,200));
			
			this.start = new JLabel(this.rectButton);
			this.start.setVisible(true);
			this.start.setOpaque(true);
			this.start.setText("Start!");
			this.start.setName("start");
			this.start.setPreferredSize(new Dimension(150,200));
			this.start.setHorizontalTextPosition(JLabel.CENTER);
			this.start.setFont(new Font("Impact", Font.BOLD,60));
			this.start.setForeground(Color.white);
			this.start.setBackground(Color.black);
			this.start.addMouseListener(this);
			
			this.placeHolder2 = new JLabel(this.placeholder);
			this.placeHolder2.setVisible(true);
			this.placeHolder2.setOpaque(true);
			
			this.panel.gbc.gridx=0;
			this.panel.gbc.gridy = 0;
			this.panel.gbc.gridwidth=3;
			this.panel.gbc.fill = GridBagConstraints.HORIZONTAL;
			this.panel.add(this.playerNumberLabel, this.panel.gbc);
			
			this.panel.gbc.gridx=0;
			this.panel.gbc.gridy = 1;
			this.panel.gbc.gridwidth=1;
			this.panel.gbc.fill = 0;
			this.panel.add(this.playersDown, this.panel.gbc);
			
			this.panel.gbc.gridx=1;
			this.panel.gbc.gridy=1;
			this.panel.add(this.playerNumber, this.panel.gbc);
			
			this.panel.gbc.gridx=2;
			this.panel.gbc.gridy = 1;
			this.panel.gbc.fill = 0;
			this.panel.add(this.playersUp, this.panel.gbc);
			
			this.panel.gbc.gridx=0;
			this.panel.gbc.gridy=2;
			this.panel.gbc.gridwidth=3;
			this.panel.gbc.fill=GridBagConstraints.HORIZONTAL;
			this.panel.add(this.appleNumberLabel, this.panel.gbc);
			
			this.panel.gbc.gridx=0;
			this.panel.gbc.gridy=3;
			this.panel.gbc.gridwidth=1;
			this.panel.gbc.fill=0;
			this.panel.add(this.applesDown, this.panel.gbc);
			
			this.panel.gbc.gridx=1;
			this.panel.add(this.appleNumber, this.panel.gbc);
			
			this.panel.gbc.gridx=2;
			this.panel.add(this.applesUp, this.panel.gbc);
			
			this.panel.gbc.gridx=0;
			this.panel.gbc.gridy=4;
			this.panel.gbc.gridwidth=3;
			this.panel.gbc.fill = GridBagConstraints.HORIZONTAL;
			this.panel.add(this.applesToWinLabel, this.panel.gbc);
			
			this.panel.gbc.gridy = 5;
			this.panel.gbc.gridwidth=1;
			this.panel.gbc.fill = 0;
			this.panel.add(this.applesToWinDown, this.panel.gbc);
			
			this.panel.gbc.gridx=1;
			this.panel.add(this.applesToWinNumber, this.panel.gbc);
			
			this.panel.gbc.gridx=2;
			this.panel.add(this.applesToWinUp, this.panel.gbc);
			
			this.panel.gbc.gridx=4;
			this.panel.gbc.gridy=0;
			this.panel.gbc.gridwidth=3;
			this.panel.gbc.fill=GridBagConstraints.HORIZONTAL;
			this.panel.add(this.player1NameLabel, this.panel.gbc);
			
			this.panel.gbc.gridy=1;
			this.panel.add(this.player1, this.panel.gbc);
			
			this.panel.gbc.gridy=2;
			this.panel.add(this.player2NameLabel, this.panel.gbc);
			
			this.panel.gbc.gridy=3;
			this.panel.add(this.player2, this.panel.gbc);
			
			this.panel.gbc.gridy=5;
			this.panel.gbc.gridx = 4;
			this.panel.gbc.gridheight=1;
			this.panel.gbc.gridwidth=1;
			this.panel.gbc.fill = 0;
			this.panel.add(this.start, this.panel.gbc);
			
			this.panel.gbc.gridx=3;
			this.panel.add(this.placeHolder1, this.panel.gbc);
			
			this.panel.gbc.gridx=5;
			this.panel.add(this.placeHolder2, this.panel.gbc);
		}
		else if(this.getName() == "gameOver") {
			
			this.rectButton = new ImageIcon("bin\\main\\rectButton.png");
			this.rectButtonHighlighted = new ImageIcon("bin\\main\\rectButtonHighlight.png");
			
			this.gameOverLabel = new JLabel("Game Over!");
			this.gameOverLabel.setVisible(true);
			this.gameOverLabel.setOpaque(true);
			this.gameOverLabel.setFont(new Font("Ink Free", Font.BOLD,60));
			this.gameOverLabel.setPreferredSize(new Dimension(400,100));
			this.gameOverLabel.setBackground(Color.black);
			this.gameOverLabel.setForeground(Color.white);
			this.gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
			
			this.winnerLabel = new JLabel();
			if(this.panel.getWinner() == "A Draw!" || this.panel.getWinner() == "You Lose!") {
				this.winnerLabel.setText(this.panel.getWinner());
			}else {
				this.winnerLabel.setText(this.panel.getWinner()+" wins!");
			}
			this.winnerLabel.setVisible(true);
			this.winnerLabel.setOpaque(true);
			this.winnerLabel.setFont(new Font("Ink Free", Font.BOLD,60));
			this.winnerLabel.setPreferredSize(new Dimension(400,100));
			this.winnerLabel.setBackground(Color.black);
			this.winnerLabel.setForeground(Color.white);
			this.winnerLabel.setHorizontalAlignment(JLabel.CENTER);
			
			this.victoryReasonLabel = new JLabel(this.panel.getVictoryReason());
			this.victoryReasonLabel.setVisible(true);
			this.victoryReasonLabel.setOpaque(true);
			this.victoryReasonLabel.setFont(new Font("Ink Free", Font.BOLD,40));
			this.victoryReasonLabel.setPreferredSize(new Dimension(400,100));
			this.victoryReasonLabel.setBackground(Color.black);
			this.victoryReasonLabel.setForeground(Color.white);
			this.victoryReasonLabel.setHorizontalAlignment(JLabel.CENTER);
			
			this.playAgainButton = new JLabel(this.rectButton);
			this.playAgainButton.setVisible(true);
			this.playAgainButton.setOpaque(true);
			this.playAgainButton.setText("Play Again");
			this.playAgainButton.setName("playAgain");
			this.playAgainButton.setPreferredSize(new Dimension(200,200));
			this.playAgainButton.setHorizontalTextPosition(JLabel.CENTER);
			this.playAgainButton.setFont(new Font("Impact", Font.BOLD,40));
			this.playAgainButton.setForeground(Color.white);
			this.playAgainButton.setBackground(Color.black);
			this.playAgainButton.addMouseListener(this);
			
			this.placeHolder1 = new JLabel(this.placeholder);
			this.placeHolder1.setVisible(true);
			this.placeHolder1.setOpaque(true);
			this.placeHolder1.setBackground(Color.black);
			this.placeHolder1.setPreferredSize(new Dimension(200,200));
			
			this.mainMenuButton = new JLabel(this.rectButton);
			this.mainMenuButton.setVisible(true);
			this.mainMenuButton.setOpaque(true);
			this.mainMenuButton.setText("Main Menu");
			this.mainMenuButton.setName("mainMenu");
			this.mainMenuButton.setPreferredSize(new Dimension(200,200));
			this.mainMenuButton.setHorizontalTextPosition(JLabel.CENTER);
			this.mainMenuButton.setFont(new Font("Impact", Font.BOLD,40));
			this.mainMenuButton.setForeground(Color.white);
			this.mainMenuButton.setBackground(Color.black);
			this.mainMenuButton.addMouseListener(this);
			
			this.panel.gbc.gridx=0;
			this.panel.gbc.gridy=0;
			this.panel.gbc.gridwidth=6;
			this.panel.gbc.gridheight=1;
			this.panel.gbc.fill=GridBagConstraints.HORIZONTAL;
			this.panel.add(this.gameOverLabel, this.panel.gbc);
			
			this.panel.gbc.gridy = 1;
			this.panel.add(this.winnerLabel, this.panel.gbc);
			
			this.panel.gbc.gridy = 2;
			this.panel.add(this.victoryReasonLabel, this.panel.gbc);
			
			this.panel.gbc.gridy = 3;
			this.panel.gbc.gridwidth=1;
			this.panel.gbc.fill=0;
			this.panel.add(this.playAgainButton, this.panel.gbc);
			
			this.panel.gbc.gridx=1;
			this.panel.add(this.placeHolder1, this.panel.gbc);
			
			this.panel.gbc.gridx=2;
			this.panel.add(this.placeHolder1, this.panel.gbc);
			
			this.panel.gbc.gridx=3;
			this.panel.add(this.placeHolder1, this.panel.gbc);
			
			this.panel.gbc.gridx=4;
			this.panel.add(this.mainMenuButton, this.panel.gbc);
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
		for(int i=0; i<this.panel.getComponents().length;i++) {
			this.panel.getComponent(i).repaint();
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkCollisions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkWinner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent().getName() == "playersDown") {
			if(this.players>1) {
				this.players--;
				this.playerNumber.setText(""+this.players);
			}
		}
		else if(e.getComponent().getName() == "playersUp") {
			if(this.players<2) {
				this.players++;
				this.playerNumber.setText(""+this.players);	
			}
		}
		else if(e.getComponent().getName() == "applesDown") {
			if(this.numberOfApples>1) {
				this.numberOfApples--;
				this.appleNumber.setText(""+this.numberOfApples);
			}
		}
		else if(e.getComponent().getName() == "applesUp") {
			if(this.numberOfApples<20) {
				this.numberOfApples++;
				this.appleNumber.setText(""+this.numberOfApples);
			}
		}
		else if(e.getComponent().getName() == "applesToWinUp") {
			if(this.applesToWin<100) {
				this.applesToWin++;
				this.applesToWinNumber.setText(""+this.applesToWin);
			}
			else if(this.applesToWin == 100) {
				this.applesToWin = GamePanel.UNITS;
				this.applesToWinNumber.setFont(new Font("Ink Free", Font.BOLD, 30));
				this.applesToWinNumber.setText("Infinity");
			}
		}
		else if(e.getComponent().getName() == "applesToWinDown") {
			if(this.applesToWin==GamePanel.UNITS) {
				this.applesToWin = 100;
				this.applesToWinNumber.setFont(new Font("Ink Free", Font.BOLD, 60));
				this.applesToWinNumber.setText(""+this.applesToWin);
			}
			else if(this.applesToWin>1) {
				this.applesToWin--;
				this.applesToWinNumber.setText(""+this.applesToWin);
			}
		}
		else if(e.getComponent().getName() == "start") {
			this.startGame();
		}
		else if(e.getComponent().getName() == "playAgain") {
			this.restartGame();
		}
		else if(e.getComponent().getName() == "mainMenu") {
			this.goToMainMenu();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent().getName() == "playersDown") {
			this.playersDown.setIcon(this.leftButtonHighlighted);
		}
		else if(e.getComponent().getName() == "playersUp") {
			this.playersUp.setIcon(this.rightButtonHighlighted);
		}
		else if(e.getComponent().getName() == "applesDown") {
			this.applesDown.setIcon(this.leftButtonHighlighted);
		}
		else if(e.getComponent().getName() == "applesUp") {
			this.applesUp.setIcon(this.rightButtonHighlighted);
		}
		else if(e.getComponent().getName() == "applesToWinDown") {
			this.applesToWinDown.setIcon(this.leftButtonHighlighted);
		}
		else if(e.getComponent().getName() == "applesToWinUp") {
			this.applesToWinUp.setIcon(this.rightButtonHighlighted);
		}
		else if(e.getComponent().getName() == "start") {
			this.start.setIcon(this.rectButtonHighlighted);
		}
		else if(e.getComponent().getName() == "playAgain") {
			this.playAgainButton.setIcon(this.rectButtonHighlighted);
		}
		else if(e.getComponent().getName() == "mainMenu") {
			this.mainMenuButton.setIcon(this.rectButtonHighlighted);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent().getName() == "playersDown") {
			this.playersDown.setIcon(this.leftButton);
		}
		else if(e.getComponent().getName() == "playersUp") {
			this.playersUp.setIcon(this.rightButton);
		}
		else if(e.getComponent().getName() == "applesDown") {
			this.applesDown.setIcon(this.leftButton);
		}
		else if(e.getComponent().getName() == "applesUp") {
			this.applesUp.setIcon(this.rightButton);
		}
		else if(e.getComponent().getName() == "applesToWinDown") {
			this.applesToWinDown.setIcon(this.leftButton);
		}
		else if(e.getComponent().getName() == "applesToWinUp") {
			this.applesToWinUp.setIcon(this.rightButton);
		}
		else if(e.getComponent().getName() == "start") {
			this.start.setIcon(this.rectButton);
		}
		else if(e.getComponent().getName() == "playAgain") {
			this.playAgainButton.setIcon(this.rectButton);
		}
		else if(e.getComponent().getName() == "mainMenu") {
			this.mainMenuButton.setIcon(this.rectButton);
		}
	}
	
	public void startGame() {
		this.panel.removeAll();
		this.panel.player1Name = this.player1.getText();
		this.panel.player2Name = this.player2.getText();
		if(this.player1.getText().isEmpty()) {
			this.panel.player1Name = "Player 1";
		}
		if(this.player2.getText().isEmpty()) {
			this.panel.player2Name = "Player 2";
		}
		this.panel.setWinner("nobody");
		this.panel.setVictoryReason("none");
		this.panel.state = new PlayState(this.panel, this.players,this.numberOfApples,this.applesToWin, this.panel.player1Name,this.panel.player2Name);
	}
	
	public void restartGame() {
		this.panel.removeAll();
		this.panel.setWinner("nobody");
		this.panel.setVictoryReason("none");
		this.panel.state = new PlayState(this.panel, this.players,this.numberOfApples,this.applesToWin, this.panel.player1Name,this.panel.player2Name);
	}
	
	public void goToMainMenu() {
		for(int i = this.panel.getComponentCount()-1; i>=0;i--) {
			this.panel.remove(this.panel.getComponent(i));
		}
		this.panel.state = new MenuState(this.panel, "mainMenu", this.players, this.numberOfApples, this.applesToWin);

		this.panel.revalidate();
		this.panel.repaint();
	}

}
