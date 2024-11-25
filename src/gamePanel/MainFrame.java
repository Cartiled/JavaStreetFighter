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
	
	private ArrayList<JPanel> panels = null;
	
	public void intializePanel() {
		frame = new JFrame();
		frame.setBounds(0,0,1025,660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panels = new ArrayList<JPanel>();
		
		MainPanel fightPanel = new MainPanel();
		
		JPanel panel1 = fightPanel.getPanel();
		panel1.setVisible(true);
		panels.add(panel1);
		frame.getContentPane().add(panel1);
		

		frame.setVisible(true);
		
	}
	
}
