package gamePanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pojo.Characters;
import threads.KeyHandler;
import threads.MovementThreads;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private int originalTileSize = 16;
	private int scale = 3;
	public int tileSize = originalTileSize * scale;
	private JLabel backgroundLabel = null;
	private ImageIcon backgroudImage;
	private KeyHandler keyH = new KeyHandler();
	private Characters character = new Characters(this, keyH);
	private MovementThreads movmentThreads = new MovementThreads(this, keyH, character);


	public int playerX = 100;
	public int playerY = 100;
	public int playerSpeed = 4;

	public MainPanel() {

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1025, 660);

		backgroundLabel = new JLabel(getImage());
		backgroundLabel.setBounds(0, -20, 1025, 665);
		panel.add(backgroundLabel);
		panel.addKeyListener(keyH);
		panel.setFocusable(true);
		
		movmentThreads.start();

	}

	private ImageIcon getImage() {
		try {
			File f = new File("resources/GameBackround.gif");
			URL img = f.toURL();
			backgroudImage = new ImageIcon(img);
			backgroudImage.setImage(backgroudImage.getImage().getScaledInstance(1025, 610, Image.SCALE_DEFAULT));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return backgroudImage;
	}


	public void paintComponent(Graphics g) {
		System.out.println("la imagen debe aparecer");
		super.paintComponent(g);
		Graphics g2 = (Graphics2D) g;
		character.draw((Graphics2D) g2);
		g2.dispose();
		
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
