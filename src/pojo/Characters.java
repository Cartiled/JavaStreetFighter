package pojo;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import gamePanel.MainPanel;
import imageUtils.CharacterImages;
import imageUtils.ImageSize;
import threads.KeyHandler;

public class Characters {

	public int x, y;
	public int speed;
	private int spriteCount = 0;
	private int spriteNum = 0;
	public String direction;
	MainPanel mainPanel;
	KeyHandler keyHandler;
	private HashMap<String,BufferedImage> images = null;
	
	public Characters(MainPanel mainPanel, KeyHandler keyHandler) {
		this.mainPanel = mainPanel;
		this.keyHandler = keyHandler;
		setDefaultValues();
		getCharacterImage();
	}

	public void setDefaultValues() {
		x = 100;
		y = 500;
		speed = 4;
		direction = "right";

	}

	public void getCharacterImage() {
		images = new CharacterImages().loadCharacterImage();
	}

	public void update() {
		if (keyHandler.upPressed == true) {
			direction = "up";
			y -= speed;

		} else if (keyHandler.downPressed == true) {

			direction = "down";
			y += speed;

		} else if (keyHandler.leftPressed == true) {

			direction = "left";
			x -=speed;
		} else if (keyHandler.rightPressed == true) {
			direction = "right";
			x += speed;
		}

	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;

		switch (direction) {
		case "up":
			
			image = images.get("onFeet1");
			break;
		case "down":
			image = images.get("onFeet3");;
			break;
		case "left":
			image = images.get("onFeet4");
			break;
		case "right":
			image = images.get("onFeet2");
			break;
		}
		g2.drawImage(image, x, y, mainPanel.tileSize, mainPanel.tileSize, null);

	}
}
