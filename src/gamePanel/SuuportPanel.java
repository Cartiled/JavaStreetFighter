package gamePanel;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SuuportPanel extends JPanel {

	/**
	 * 
	 */
	private int width = 800;
	private int length = 1200;
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(null,0,0,length,width,null);
	}

}
