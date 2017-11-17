package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame {
	
	ConteneurFenetre panneau;
	
	public Fenetre() {
		//super(); //pas obligatoire car automatique
		this.setTitle("Projet PMF");
		this.setSize(900, 700);
		this.setResizable(false);	
		this.setLocation(70,70);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		panneau = new ConteneurFenetre();
		this.setContentPane(panneau);
		//this.setUndecorated(true); // permet de retirer la barre titre de la fenetre
		this.setVisible(true);	
	}
}
