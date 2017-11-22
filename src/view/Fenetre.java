package view;

import java.io.IOException;

import javax.swing.JFrame;

import model.ChunksCreator;
import model.Serial;

public class Fenetre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ConteneurFenetre conteneurFenetre;
	
	/**
	 * Constructor of the class Fenetre.
	 * 
	 * @param graphique
	 * @param chunkCreator
	 * @param serial
	 * @throws IOException
	 */
	public Fenetre(Graphique graphique, ChunksCreator chunkCreator, Serial serial) throws IOException {
		this.setTitle("Projet PMF");
		this.setSize(900, 700);
		this.setResizable(false);	
		this.setLocation(70,70);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setAlwaysOnTop(true);
		conteneurFenetre = new ConteneurFenetre(graphique, chunkCreator, serial);
		this.setContentPane(conteneurFenetre);
		//this.setUndecorated(true); // permet de retirer la barre titre de la fenetre
		this.setVisible(true);	
	
	}

	/**
	 * Getter of conteneurFenetre.
	 * 
	 * @return conteneurFenetre
	 */
	public ConteneurFenetre getConteneurFenetre() {
		return conteneurFenetre;
	}
}