package gamePanel;


import java.awt.Image;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel backgroundLabel = null;
	private ImageIcon backgroudImage;

	public MainPanel() {

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1025, 660);

		backgroundLabel = new JLabel(getImage());
		backgroundLabel.setBounds(0, -20, 1025, 665);
		panel.add(backgroundLabel);

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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
