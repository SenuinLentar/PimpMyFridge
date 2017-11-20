package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import model.ChunksCreator;

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ChunksCreator chunksCreator;

	public Panel(ChunksCreator chunksCreator) {
		this.chunksCreator = chunksCreator;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 1200, 700);
		g.setColor(Color.black);
		g.drawString(this.chunksCreator.getChunks()[0], 10, 20);
		// System.out.println(serial.getChunks()[0]);
	}

	public void update() {
		this.repaint();
	}
}
