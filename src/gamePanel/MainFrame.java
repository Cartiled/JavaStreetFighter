package gamePanel;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame = null;
	private MainPanel mainPanel;
	
	public void intializePanel() {
		frame = new JFrame();
		frame.setBounds(0,0,1025,660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		mainPanel= new MainPanel();
		
		frame.add(mainPanel);
		

		frame.setVisible(true);
		
	}
	
}
