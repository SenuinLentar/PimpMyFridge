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
		String toto = serial.getChunks()[0];
		if(toto != "0") {
			g.drawString(toto, 10, 20);
			//System.out.println(serial.getChunks()[0]);
			serial.printChunk();
		}
		
	}
	
	public void update() {
		this.repaint();
	}
}
