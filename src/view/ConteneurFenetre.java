package view;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;


public class ConteneurFenetre extends JPanel {
	
	//Definition variables 
	public JLabel fond; 
	
	private JLabel etiquette;
	private JLabel temperatureLabel;
	private JLabel humiditeLabel;
	private JLabel consigneLabel;
	private JLabel graphiqueLabel;

	private JLabel goutte; 
	private JLabel barre; 
	private JLabel thermometre;
	private JButton boutonPlus;
	private JButton boutonMoins;
	private JLabel graphique;
	
	private JLabel temperatureActuelleLabel;
	private JLabel valeurHumiditeLabel;
	private JLabel valeurConsigneLabel;
	
	public double temperatureActuelle = 10.0;
	public double humiditeActuelle = 24.0;
	public double consigne = 15.0;
	
	//différentes polices
	Font f = new Font("Calibri", Font.PLAIN,40); //Police du texte basique
	Font titre = new Font("Calibri", Font.PLAIN,60);
	Font fmin = new Font("Calibri", Font.PLAIN,24);
	Font temperature = new Font("Calibri", Font.PLAIN,80);
	
	private JTextField texte;
	
	//Constructeur du PANEL
	public ConteneurFenetre(){
		this.setLayout(null);
		this.proprieteEtiquette();
		this.proprieteBouton();
		this.proprieteTexte();
		this.proprieteFond();
	}

	
	// Propriétes pour l'image de fond
	private void proprieteFond() {
		fond = new JLabel(new ImageIcon("image/wetAsphalte.png"));
		this.fond.setSize(900, 700);
		this.add(fond);
		
		goutte = new JLabel(new ImageIcon("image/goutte.png"));
		this.goutte.setBounds(30, 480, 50, 100);
		this.add(goutte);	
		//IMAGE THRMOMÈTRE SELON LA TEMPÉRATURE
		if (temperatureActuelle <= 10.0) {
			thermometre = new JLabel(new ImageIcon("image/low.png"));
			this.thermometre.setBounds(20, 220, 60, 100);
			this.add(thermometre);	
		} 
		else if (temperatureActuelle >= 10.0) {
			thermometre = new JLabel(new ImageIcon("image/great.png"));
			this.thermometre.setBounds(20, 220, 60, 150);
			this.add(thermometre);	
		}
		else {
			System.out.println("nop"); //FAIRE RESTE 10-13 14-17 18-20
		}	
		
		barre = new JLabel(new ImageIcon("image/barre.png"));
		this.barre.setBounds(450, 180, 10, 500);
		this.add(barre);	
		
		graphique = new JLabel(new ImageIcon("image/graphique.png"));
		this.graphique.setBounds(490, 430, 400, 200);
		this.add(graphique);	
	}

	
	//Propriétes pour les textes & les images statiques
	private void proprieteEtiquette() {
		
		//LES TEXTES
		// TEXTE-TITRE
		etiquette = new JLabel ();
		this.etiquette.setBounds(270, 22, 400, 70);
		this.etiquette.setText("Pimp my fridge");
		this.etiquette.setForeground(Color.WHITE);
		this.etiquette.setFont(titre);
		this.add(etiquette);
		//TEXTE-TEMPÉRATURE
		temperatureLabel = new JLabel ();
		this.temperatureLabel.setBounds(20, 150, 300, 80);
		this.temperatureLabel.setText("Température");
		this.temperatureLabel.setForeground(Color.WHITE);
		this.temperatureLabel.setFont(f);
		this.add(temperatureLabel);
		//TEXTE-HUMIDITÉ
		humiditeLabel = new JLabel ();
		this.humiditeLabel.setBounds(20, 390, 300, 80);
		this.humiditeLabel.setText("Humidité");
		this.humiditeLabel.setForeground(Color.WHITE);
		this.humiditeLabel.setFont(f);
		this.add(humiditeLabel);
		//TEXTE-CONSIGNE
		consigneLabel = new JLabel ();
		this.consigneLabel.setBounds(500, 150, 300, 80); //CHANGER VALEUR
		this.consigneLabel.setText("Consigne");
		this.consigneLabel.setForeground(Color.WHITE);
		this.consigneLabel.setFont(f);
		this.add(consigneLabel);
		//TEXTE-GRAPHIQUE
		graphiqueLabel = new JLabel ();
		this.graphiqueLabel.setBounds(550, 350, 500, 80); //CHANGER VALEUR
		this.graphiqueLabel.setText("Evolution de la température");
		this.graphiqueLabel.setForeground(Color.WHITE);
		this.graphiqueLabel.setFont(fmin);
		this.add(graphiqueLabel);
		
		
		temperatureActuelleLabel = new JLabel ();
		this.temperatureActuelleLabel.setBounds(160, 250 , 400, 70);
		this.temperatureActuelleLabel.setText(String.valueOf(temperatureActuelle) + "°C");
		this.temperatureActuelleLabel.setForeground(Color.WHITE);
		this.temperatureActuelleLabel.setFont(temperature);
		this.add(temperatureActuelleLabel);
		
		
		valeurHumiditeLabel = new JLabel ();
		this.valeurHumiditeLabel.setBounds(160, 480, 300, 80);
		this.valeurHumiditeLabel.setText(String.valueOf(humiditeActuelle) + "%");
		this.valeurHumiditeLabel.setForeground(Color.WHITE);
		this.valeurHumiditeLabel.setFont(temperature);
		this.add(valeurHumiditeLabel);
		
		valeurConsigneLabel = new JLabel ();
		this.valeurConsigneLabel.setBounds(500, 250, 400, 70);
		this.valeurConsigneLabel.setText(String.valueOf(consigne) + "°C");
		this.valeurConsigneLabel.setForeground(Color.WHITE);
		this.valeurConsigneLabel.setFont(titre);
		this.add(valeurConsigneLabel);
		
		
		
		//LES IMAGES
		//IMAGE GOUTTE
		goutte = new JLabel(new ImageIcon("image/goutte.png"));
		this.goutte.setBounds(30, 480, 50, 100);
		this.add(goutte);	
		//IMAGE THRMOMÈTRE SELON LA TEMPÉRATURE
		if (temperatureActuelle <= 10.0) {
			thermometre = new JLabel(new ImageIcon("image/low.png"));
			this.thermometre.setBounds(20, 220, 60, 100);
			this.add(thermometre);	
		} 
		else if (temperatureActuelle >= 10.0) {
			thermometre = new JLabel(new ImageIcon("image/great.png"));
			this.thermometre.setBounds(20, 220, 60, 150);
			this.add(thermometre);	
		}
		else {
			System.out.println("nop"); //FAIRE RESTE 10-13 14-17 18-20
		}	
		
		barre = new JLabel(new ImageIcon("image/barre.png"));
		this.barre.setBounds(450, 180, 10, 500);
		this.add(barre);	
		
		graphique = new JLabel(new ImageIcon("image/graphique.png"));
		this.graphique.setBounds(490, 430, 400, 200);
		this.add(graphique);	
	}	
	
	//LES BOUTONS PLUS & MOINS
	private void proprieteBouton() {
		boutonPlus = new JButton();
		this.boutonPlus.setIcon(new ImageIcon ("image/plus.png"));
		this.boutonPlus.setBounds(680, 160, 80, 80);
		this.boutonPlus.setBorderPainted(false);
		this.add(boutonPlus);
		
		boutonMoins = new JButton();
		this.boutonMoins.setIcon(new ImageIcon ("image/moins.png"));
		this.boutonMoins.setBounds(780, 160, 80, 80);
		this.boutonMoins.setBorderPainted(false);
		this.add(boutonMoins);
	}
	
	
	//TEXTE DE L'UTILISATEUR
	private void proprieteTexte() {
		texte = new JTextField();
		this.texte.setBounds(710, 260, 130, 60);
		this.texte.setFont(f);
		this.add(texte);
	}

}