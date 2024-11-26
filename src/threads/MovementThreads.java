package threads;

import java.awt.Graphics;

import gamePanel.MainPanel;
import pojo.Characters;

public class MovementThreads extends Thread {

	private MainPanel mainPanel;
	private KeyHandler keyHandler;
	private Characters character;
	public int FPS = 60;

	public MovementThreads(MainPanel mainPanel, KeyHandler keyHandler) {
		this.mainPanel = mainPanel;
		this.keyHandler = keyHandler;
	}

	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;	
		while(Thread.currentThread() != null) {
			
			
			update();
			mainPanel.repaint();
			
			try {
				double remainTime = nextDrawTime - System.nanoTime();
				remainTime = remainTime/1000000;
				if(remainTime < 0) {
					remainTime = 0;
				}
				Thread.sleep((long) remainTime);
				nextDrawTime += drawInterval;
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			
		}
	}
	public void run2() {
		double drawInterval = 1000000000/FPS;
		
		while(Thread.currentThread() != null) {
			
			update();
			mainPanel.repaint();
			
		}
	}

	public void update() {

		character.update();

	}

}
