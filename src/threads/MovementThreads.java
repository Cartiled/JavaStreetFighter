package threads;

import gamePanel.MainPanel;
import pojo.Characters;

public class MovementThreads extends Thread {

	private MainPanel mainPanel;
	private KeyHandler keyHandler;
	private Characters character;
	public int FPS = 60;

	public MovementThreads(MainPanel mainPanel, KeyHandler keyHandler, Characters character) {
		this.mainPanel = mainPanel;
		this.keyHandler = keyHandler;
		this.character = character;
	}

	public void run() {
		int drawCount = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		double delta = 0;
		double drawInterval = 1000000000 / FPS;
		long timer = 0;
		
		while (Thread.currentThread() != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			if (delta >= 1) {
				update();
				mainPanel.repaint();
				delta--;

			}
			if (timer >= 1000000000) {

				timer = 0;
			}
		}
	}

	public void update() {
		character.update();

	}

}
