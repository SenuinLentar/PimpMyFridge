package view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OuverturePortePanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel text;

    /**
     * Constructor of the class OuverturePortePanel.
     */
    public OuverturePortePanel() {
        text = new JLabel ();
        this.text.setBounds(20, 150, 400, 50);
        this.text.setText("Porte ouverte!");
        this.text.setForeground(Color.WHITE);
        this.add(text);
    }
}