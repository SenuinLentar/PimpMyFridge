package view;

import java.awt.Graphics;
import javax.swing.JPanel;


public class OuverturePortePanel extends JPanel {

	public void paintComponent(Graphics g) {
		g.drawString("Porte Ouverte !!!", 10, 20);
	//	System.out.println(serial.getChunks()[0]);
	}

}
