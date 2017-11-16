package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicInterface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void Window() {
		this.setTitle("Pimp My Fridge");
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);

		this.setContentPane(panel);
		this.setVisible(true);
	}
}