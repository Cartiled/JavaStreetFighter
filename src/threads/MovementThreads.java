package threads;


import gamePanel.MainPanel;
import pojo.Characters;

public class MovementThreads extends Thread {

	private MainPanel mainPanel;
	private KeyHandler keyHandler;
	private Characters character;
	public int FPS = 60;

	public MovementThreads(MainPanel mainPanel, KeyHandler keyHandler,Characters character) {
		this.mainPanel = mainPanel;
		this.keyHandler = keyHandler;
		this.character = character;
	}

	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;	
		while(Thread.currentThread() != null) {
			
			
			update();
			mainPanel.revalidate();
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
	public void update() {
		character.update();

	}

}
