package gamePanel;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;

	public MainPanel() {

		setTitle("Java StreetFigher");
		setSize(1200, 800);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);

	}

}
