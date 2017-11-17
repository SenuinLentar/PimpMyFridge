//package view;
//
//import java.awt.Color;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import model.Serial;
//
//public class GraphicInterface extends JFrame {
//	/**
//	 * 
//	 */
//	
//	static Panel panel;
//	
//	private static final long serialVersionUID = 1L;
//
//	public void Window(Serial serial) {
//		this.setTitle("Pimp My Fridge");
//		this.setSize(1200, 700);
//		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		panel = new Panel(serial);
//		panel.setBackground(Color.BLUE);
//
//		this.setContentPane(panel);
//		this.setVisible(true);
//	}
//	
//	public static Panel getPanel() {
//		return panel;
//	}
//}