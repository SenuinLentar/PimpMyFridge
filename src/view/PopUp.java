package view;

import javax.swing.JFrame;


public class PopUp extends JFrame {

	

	public void popUp() {
		this.setTitle("Attention !");
		this.setSize(120, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void condensation() {
		CondensationPanel panel = new CondensationPanel();
		this.setContentPane(panel);
		this.setVisible(true);
	}
	
	public void porte() {
		OuverturePortePanel panelPorte = new OuverturePortePanel();
		this.setContentPane(panelPorte);
		this.setVisible(true);
	}
	
}

