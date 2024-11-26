package pojo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gamePanel.MainPanel;
import threads.KeyHandler;

public class Characters {
	
	public int x,y;
	public int speed;
	public String direction;
	MainPanel mainPanel;
	KeyHandler keyHandler;
	
	public BufferedImage onFeet1,onFeet2,onFeet3,onFeet4,onFeet5,onFeet6,onFeet7,onFeet8,onFeet9;
	
	public Characters(MainPanel mainPanel,KeyHandler keyHandler) {
		this.mainPanel = mainPanel;
		this.keyHandler = keyHandler;
		setDefaultValues();
		getCharacterImage();
	}
	
	
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "right";
		
	}
	public void getCharacterImage() {
			try {
				System.out.println(new File("C:\\Users\\yifei\\Pictures\\Yagami\\onFeet1.png").toString());
	        onFeet1 = ImageIO.read(getClass().getResourceAsStream("/resources/Yagami/onFeet1.png"));
//	        onFeet2 = ImageIO.read(getClass().getResourceAsStream("/resources/Yagami/onFeet2.png"));
//	        onFeet3 = ImageIO.read(getClass().getResourceAsStream("/resources/Yagami/onFeet3.png"));
//	        onFeet4 = ImageIO.read(getClass().getResourceAsStream("/resources/Yagami/onFeet4.png"));
//	        onFeet5 = ImageIO.read(getClass().getResourceAsStream("/resources/Yagami/onFeet5.png"));
//	        onFeet6 = ImageIO.read(getClass().getResourceAsStream("/resources/Yagami/onFeet6.png"));
//	        onFeet7 = ImageIO.read(getClass().getResourceAsStream("/resources/onFeet7.png"));
//	        onFeet8 = ImageIO.read(getClass().getResourceAsStream("/resources/onFeet8.png"));
//	        onFeet9 = ImageIO.read(getClass().getResourceAsStream("/resources/onFeet9.png"));
	    } catch (IOException e) {
	     e.printStackTrace();
	    } 
	}
	public void update() {
		if (keyHandler.upPressed == true) {
			direction = "up";
			mainPanel.playerY -= mainPanel.playerSpeed;
			
		} else if (keyHandler.downPressed == true) {
			direction = "down";
			mainPanel.playerY += mainPanel.playerSpeed;
			
		} else if (keyHandler.leftPressed == true) {
			direction = "left";
			mainPanel.playerX -= mainPanel.playerSpeed;
			
		} else if (keyHandler.rightPressed == true) {
			direction = "right";
			mainPanel.playerX += mainPanel.playerSpeed;
		}
	}
	public void draw(Graphics2D g2) {
		
//		g2.fillRect(x, y, mainPanel.tileSize, mainPanel.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			break;
		case "down":
			break;
		case "left":
			break;
		case "right":
			image = onFeet1;
			break;
		}
		g2.drawImage(image,x, y, mainPanel.tileSize, mainPanel.tileSize,null);
	}
}
