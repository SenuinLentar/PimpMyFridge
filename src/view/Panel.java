package view;

import java.awt.Graphics;
import javax.swing.JPanel;

import model.Serial;

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Serial serial;
	public Panel(Serial serial) {
		this.serial = serial;
	}

	public void paintComponent(Graphics g) {
		g.drawString(serial.getChunks()[0], 10, 20);
		System.out.println(serial.getChunks()[0]);
	}
	
	public void update() {
		this.repaint();
	}
}
