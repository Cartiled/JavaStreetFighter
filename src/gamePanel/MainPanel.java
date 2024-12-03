package gamePanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pojo.Characters;
import threads.KeyHandler;
import threads.MovementThreads;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int originalTileSize = 16;
	private int scale = 3;
	public int tileSize = originalTileSize * scale;
	public int maxScreenCol = 24;
	public int masScreenRow = 18;
	
	public int screenWidth = tileSize* maxScreenCol;
	public int screenHeight = tileSize * masScreenRow;
	
	private Image backgroundImage;
	private KeyHandler keyH = new KeyHandler();
	private Characters character = new Characters(this, keyH);
	private MovementThreads movementThreads = new MovementThreads(this, keyH, character);

	public int playerX = 100;
	public int playerY = 100;
	public int playerSpeed = 4;

	public MainPanel() {

		this.setLayout(null);
		this.setBounds(0, 0, screenWidth, screenHeight);

		loadBackgroundImage();

		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.requestFocusInWindow();
		movementThreads.start();
	}

	private void loadBackgroundImage() {
		try {
			File f = new File("resources/GameBackround.gif");
			URL img = f.toURL();
			ImageIcon imageIcon = new ImageIcon(img);
			backgroundImage = imageIcon.getImage().getScaledInstance(1025, 665, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
		}
		Graphics2D g2 = (Graphics2D) g;
		character.draw(g2);

		g2.dispose();
	}
}
