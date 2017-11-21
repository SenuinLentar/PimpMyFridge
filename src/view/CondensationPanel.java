package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class CondensationPanel extends JPanel {

    private JLabel text;

    public CondensationPanel() {

        text = new JLabel ();
        this.text.setBounds(20, 150, 400, 50);
        this.text.setText("condensation");
        this.text.setForeground(Color.BLACK);
        this.add(text);

    }

}