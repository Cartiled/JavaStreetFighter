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
	private int spriteNum = 1;
	public String direction;
	MainPanel mainPanel;
	KeyHandler keyHandler;
	private HashMap<String, BufferedImage> images = null;

	public Characters(MainPanel mainPanel, KeyHandler keyHandler) {
		this.mainPanel = mainPanel;
		this.keyHandler = keyHandler;
		setDefaultValues();
		getCharacterImage();
	}

	public void setDefaultValues() {
		x = 100;
		y = 600;
		speed = 4;
		direction = "right";

	}

	public void getCharacterImage() {
		images = new CharacterImages().loadCharacterImage();
	}

	public void attack() {
		if (keyHandler.lightAttack == true) {
			System.out.println("light attack");
		}
		if (keyHandler.kickAttack == true) {
			System.out.println("kick attack");
		}
		if (keyHandler.lightAttack == true && keyHandler.downPressed == true) {
			System.out.println("down light attack");
		}
		if (keyHandler.lightAttack ==true && keyHandler.upPressed == true) {
			System.out.println("jump light attack");
		}
		if (keyHandler.kickAttack == true && keyHandler.upPressed == true) {
			System.out.println("jump kick");
		}
		if (keyHandler.kickAttack == true && keyHandler.downPressed == true) {
			System.out.println("down kick");
		}
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
			x -= speed;
		} else if (keyHandler.rightPressed == true) {
			direction = "right";
			x += speed;
		}
		spriteCount++;
		if (spriteCount < 10) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 3;
			} else if (spriteNum == 3) {
				spriteNum = 4;
			} else if (spriteNum == 4) {
				spriteNum = 5;
			} else if (spriteNum == 5) {
				spriteNum = 6;
			} else if (spriteNum == 6) {
				spriteNum = 7;
			} else if (spriteNum == 7) {
				spriteNum = 8;
			} else if (spriteNum == 8) {
				spriteNum = 9;
			} else if (spriteNum == 9) {
				spriteNum = 1;
			}
		}
		spriteCount = 0;
	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;

		switch (direction) {
		case "up":
			image = images.get("onFeet2");
			break;
		case "down":
			image = images.get("onFeet3");

			break;
		case "left":
			image = images.get("onFeet4");

			break;
		case "right":
			if (spriteNum == 1) {
				image = images.get("onFeet1");
			} else if (spriteNum == 2) {
				image = images.get("onFeet2");
			} else if (spriteNum == 3) {
				image = images.get("onFeet3");
			} else if (spriteNum == 4) {
				image = images.get("onFeet4");
			} else if (spriteNum == 5) {
				image = images.get("onFeet5");
			} else if (spriteNum == 6) {
				image = images.get("onFeet6");
			} else if (spriteNum == 7) {
				image = images.get("onFeet7");
			} else if (spriteNum == 8) {
				image = images.get("onFeet6");
			} else if (spriteNum == 9) {
				image = images.get("onFeet9");
			}
			break;
		}
		g2.drawImage(image, x, y, mainPanel.tileSize, mainPanel.tileSize, null);

	}
}
