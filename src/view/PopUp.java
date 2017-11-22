package view;

import javax.swing.JFrame;

public class PopUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the class PopUp
	 */
	public PopUp() {
		this.setTitle("Attention !");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(Graphique.HIDE_ON_CLOSE);
	}

	/**
	 * Create a new CondensationPanel, set the JPanel to this JFrame and set the
	 * windows visible.
	 */
	public void condensation() {
		CondensationPanel panel = new CondensationPanel();
		this.setContentPane(panel);
		this.setVisible(true);
	}

	/**
	 * Create a new OuverturePortePanel, set the JPanel to this JFrame and set the
	 * windows visible.
	 */
	public void porte() {
		OuverturePortePanel panelPorte = new OuverturePortePanel();
		this.setContentPane(panelPorte);
		this.setVisible(true);
	}
}