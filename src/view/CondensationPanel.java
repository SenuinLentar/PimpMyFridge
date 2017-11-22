package view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CondensationPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel text;

    /**
     * Constructor of the class CondensationPanel.
     */
    public CondensationPanel() {
        text = new JLabel ();
        this.text.setBounds(20, 150, 400, 50);
        this.text.setText("Formation de condensation!");
        this.text.setForeground(Color.BLACK);
        this.add(text);
    }
}