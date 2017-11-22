package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.ChunksCreator;
import model.Serial;

public class ConteneurFenetre extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// différentes polices
	Font f = new Font("Calibri", Font.PLAIN, 40); // Police du texte basique
	Font titre = new Font("Calibri", Font.PLAIN, 60);
	Font fmin = new Font("Calibri", Font.PLAIN, 24);
	Font temperature = new Font("Calibri", Font.PLAIN, 80);

	private JButton boutonPlus;
	private JButton boutonMoins;
	private JButton boutonGraphique;
	private JTextField texte;

	private JLabel fondImage;
	private JLabel goutteImage;
	private JLabel barreImage;

	private JLabel thermometreExterieurImage;
	private JLabel thermometreInterieurImage;

	private JLabel titreLabel;
	private JLabel humiditeLabel;
	private JLabel consigneLabel;
	private JLabel temperatureInterieurLabel;
	private JLabel temperatureExterieurLabel;

	private JLabel valeurTemperatureInterieurLabel;
	private JLabel valeurTemperatureExterieurLabel;
	private JLabel valeurHumiditeLabel;
	private JLabel valeurConsigneLabel;

	private float temperatureInterieure;
	private float temperatureExterieure;
	private float humiditeActuelle;
	private float consigne = 10;

	private String writeConsigne;

	private Graphique graphique;
	private ChunksCreator chunkCreator;
	private Serial serial;

	// Constructeur du PANEL
	/**
	 * @param graphique
	 * @param chunkCreator
	 * @param serial
	 * @throws IOException
	 */
	public ConteneurFenetre(Graphique graphique, ChunksCreator chunkCreator, Serial serial) throws IOException {
		this.setLayout(null);
		this.proprieteEtiquette();
		this.proprieteBouton();
		this.proprieteTexte();
		this.proprieteImage();

		this.chunkCreator = chunkCreator;
		this.graphique = graphique;
		this.serial = serial;

		this.temperatureInterieure = Float.parseFloat(this.chunkCreator.getChunks()[1]);
		this.temperatureExterieure = Float.parseFloat(this.chunkCreator.getChunks()[0]);
		this.humiditeActuelle = Float.parseFloat(this.chunkCreator.getChunks()[2]);

//		this.serial.writeOutput(this.writeConsigne);
	}

	// public void paintComponent(Graphics g) {
	// this.proprieteEtiquette();
	// this.proprieteBouton();
	// this.proprieteTexte();
	// this.proprieteImage();
	// }

	public void update() {
		this.repaint();
	}

	// PropriÃ©tes pour les images
	private void proprieteImage() {

		goutteImage = new JLabel(new ImageIcon("image/goutte.png"));
		this.goutteImage.setBounds(490, 450, 50, 100);
		this.add(goutteImage);

		barreImage = new JLabel(new ImageIcon("image/barre.png"));
		this.barreImage.setBounds(450, 170, 10, 390);
		this.add(barreImage);

		thermometreExterieurImage = new JLabel(new ImageIcon("image/exterieur.png"));
		this.thermometreExterieurImage.setBounds(20, 450, 100, 100);
		this.add(thermometreExterieurImage);

		if (temperatureInterieure <= 10.0) {
			thermometreInterieurImage = new JLabel(new ImageIcon("image/low.png"));
			this.thermometreInterieurImage.setBounds(30, 220, 60, 100);
			this.add(thermometreInterieurImage);
		} else if ((temperatureInterieure > 10.0) && (temperatureInterieure <= 13.0)) {
			thermometreInterieurImage = new JLabel(new ImageIcon("image/great.png"));
			this.thermometreInterieurImage.setBounds(30, 220, 60, 150);
			this.add(thermometreInterieurImage);
		} else if (temperatureInterieure > 13.0) {
			thermometreInterieurImage = new JLabel(new ImageIcon("image/hight.png"));
			this.thermometreInterieurImage.setBounds(30, 220, 60, 150);
			this.add(thermometreInterieurImage);
		} else {
			System.out.println("nop"); // FAIRE RESTE 10-13 14-17 18-20
		}

		fondImage = new JLabel(new ImageIcon("image/wetAsphalte.png"));
		this.fondImage.setSize(900, 700);
		this.add(fondImage);

	}

	// PropriÃ©tes pour les textes & les images statiques
	private void proprieteEtiquette() {

		// LES TEXTES
		// TEXTE-TITRE
		titreLabel = new JLabel();
		this.titreLabel.setBounds(270, 22, 400, 70);
		this.titreLabel.setText("Pimp my fridge");
		this.titreLabel.setForeground(Color.WHITE);
		this.titreLabel.setFont(titre);
		this.add(titreLabel);
		// TEXTE-TEMPÃ‰RATURE
		temperatureInterieurLabel = new JLabel();
		this.temperatureInterieurLabel.setBounds(20, 150, 400, 50);
		this.temperatureInterieurLabel.setText("Température intérieure");
		this.temperatureInterieurLabel.setForeground(Color.WHITE);
		this.temperatureInterieurLabel.setFont(f);
		this.add(temperatureInterieurLabel);

		temperatureExterieurLabel = new JLabel();
		this.temperatureExterieurLabel.setBounds(20, 370, 400, 50);
		this.temperatureExterieurLabel.setText("Température extérieure");
		this.temperatureExterieurLabel.setForeground(Color.WHITE);
		this.temperatureExterieurLabel.setFont(f);
		this.add(temperatureExterieurLabel);

		// TEXTE-CONSIGNE
		consigneLabel = new JLabel();
		this.consigneLabel.setBounds(500, 140, 300, 80); // CHANGER VALEUR
		this.consigneLabel.setText("Consigne");
		this.consigneLabel.setForeground(Color.WHITE);
		this.consigneLabel.setFont(f);
		this.add(consigneLabel);

		// TEXTE-HUMIDITÃ‰
		humiditeLabel = new JLabel();
		this.humiditeLabel.setBounds(500, 355, 300, 80);
		this.humiditeLabel.setText("Humidité");
		this.humiditeLabel.setForeground(Color.WHITE);
		this.humiditeLabel.setFont(f);
		this.add(humiditeLabel);

		// TEXTE-GRAPHIQUE
		// graphiqueLabel = new JLabel ();
		// this.graphiqueLabel.setBounds(550, 350, 500, 80); //CHANGER VALEUR
		// this.graphiqueLabel.setText("Evolution de la tempÃ©rature");
		// this.graphiqueLabel.setForeground(Color.WHITE);
		// this.graphiqueLabel.setFont(fmin);
		// this.add(graphiqueLabel);

		valeurTemperatureInterieurLabel = new JLabel();
		this.valeurTemperatureInterieurLabel.setBounds(160, 250, 400, 70);
		this.valeurTemperatureInterieurLabel.setText(String.valueOf(temperatureInterieure) + "°C");
		this.valeurTemperatureInterieurLabel.setForeground(Color.WHITE);
		this.valeurTemperatureInterieurLabel.setFont(temperature);
		this.add(valeurTemperatureInterieurLabel);

		valeurTemperatureExterieurLabel = new JLabel();
		this.valeurTemperatureExterieurLabel.setBounds(160, 400, 300, 200);
		this.valeurTemperatureExterieurLabel.setText(String.valueOf(temperatureExterieure) + "°C");
		this.valeurTemperatureExterieurLabel.setForeground(Color.WHITE);
		this.valeurTemperatureExterieurLabel.setFont(temperature);
		this.add(valeurTemperatureExterieurLabel);

		valeurConsigneLabel = new JLabel();
		this.valeurConsigneLabel.setBounds(500, 250, 400, 70);
		this.valeurConsigneLabel.setText(String.valueOf(consigne) + "°C");
		this.valeurConsigneLabel.setForeground(Color.WHITE);
		this.valeurConsigneLabel.setFont(titre);
		this.add(valeurConsigneLabel);

		valeurHumiditeLabel = new JLabel();
		this.valeurHumiditeLabel.setBounds(600, 450, 300, 80);
		this.valeurHumiditeLabel.setText(String.valueOf(humiditeActuelle) + "%");
		this.valeurHumiditeLabel.setForeground(Color.WHITE);
		this.valeurHumiditeLabel.setFont(temperature);
		this.add(valeurHumiditeLabel);

	}

	// LES BOUTONS PLUS & MOINS
	private void proprieteBouton() {
		boutonPlus = new JButton();
		this.boutonPlus.setIcon(new ImageIcon("image/plus.png"));
		this.boutonPlus.setBounds(680, 160, 80, 80);
		this.boutonPlus.setBorderPainted(false);
		this.boutonPlus.addActionListener(this);
		this.add(boutonPlus);

		boutonMoins = new JButton();
		this.boutonMoins.setIcon(new ImageIcon("image/moins.png"));
		this.boutonMoins.setBounds(780, 160, 80, 80);
		this.boutonMoins.setBorderPainted(false);
		// this.boutonMoins.setBackground(null);
		this.boutonMoins.addActionListener(this);
		this.add(boutonMoins);

		boutonGraphique = new JButton();
		this.boutonGraphique.setText("Afficher le graphique");
		this.boutonGraphique.setForeground(Color.darkGray);
		this.boutonGraphique.setFont(fmin);
		this.boutonGraphique.setBounds(350, 600, 250, 50);
		this.boutonGraphique.addActionListener(this);
		this.add(boutonGraphique);
	}

	// TEXTE DE L'UTILISATEUR
	private void proprieteTexte() {
		texte = new JTextField();
		this.texte.setBounds(710, 260, 130, 60);
		this.texte.setFont(f);
		this.texte.addActionListener(this);
		this.add(texte);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if ((source == boutonPlus) && (consigne < 20)) {
			consigne++;
			valeurConsigneLabel.setText(String.valueOf(consigne) + "°C");

		} else if ((source == boutonMoins) && (consigne > 10)) {
			consigne--;
			valeurConsigneLabel.setText(String.valueOf(consigne) + "°C");
		} else if (source == texte) {
			// valeurConsigneLabel.setText(texte.getText() + "°C");
			float a = Float.parseFloat(texte.getText());
			if (a > 20) {
				valeurConsigneLabel.setText("20°C");
				consigne = 20;
			} else if (a < 10) {
				valeurConsigneLabel.setText("10°C");
				consigne = 10;
			} else if ((a >= 10) && (a <= 20)) {
				valeurConsigneLabel.setText(a + "°C");
				consigne = a;
			} else {
				System.out.println("nope");
			}
		}

		else if (source == boutonGraphique) {
			SwingUtilities.invokeLater(() -> {
				this.graphique.initUI();
				graphique.setVisible(true);
			});
		}

		else {
			System.out.println("nope");
		}
		this.writeConsigne = Float.toString(this.consigne);
		try {
			this.serial.writeOutput(this.writeConsigne);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public JLabel getValeurTemperatureInterieurLabel() {
		return valeurTemperatureInterieurLabel;
	}

	public JLabel getValeurTemperatureExterieurLabel() {
		return valeurTemperatureExterieurLabel;
	}

	public JLabel getValeurHumiditeLabel() {
		return valeurHumiditeLabel;
	}

	public float getConsigne() {
		return consigne;
	}
}