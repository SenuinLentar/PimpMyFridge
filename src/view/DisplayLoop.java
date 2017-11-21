package view;

import controller.DewPoint;

import model.ChunksCreator;

public class DisplayLoop {

	private ChunksCreator chunksCreator;
	private DewPoint dewPoint;
	private Graphique graphique;
	private Fenetre fenetre;
	private PopUp popUp;

	/**
	 * Constructor of the DisplayLoop class.
	 * 
	 * @param chunksCreator
	 */
	public DisplayLoop(ChunksCreator chunksCreator, DewPoint dewPoint, Graphique graphique, Fenetre fenetre,
			PopUp popUp) {
		this.chunksCreator = chunksCreator;
		this.dewPoint = dewPoint;
		this.graphique = graphique;
		this.fenetre = fenetre;
		this.popUp = popUp;
		System.out.println("Température extérieure : \t Température intérieure : \t Humidité : \t Consigne :");
	}

	/**
	 * Endless print of the output of the Arduino card.
	 * 
	 * @throws InterruptedException
	 */
	public void Loop() throws InterruptedException {
		while (true) {
			this.fenetre.getConteneurFenetre().getValeurHumiditeLabel().setText(this.chunksCreator.getChunks()[2]);
			this.fenetre.getConteneurFenetre().getValeurTemperatureExterieurLabel()
					.setText(this.chunksCreator.getChunks()[1]);
			this.fenetre.getConteneurFenetre().getValeurTemperatureInterieurLabel()
					.setText(this.chunksCreator.getChunks()[0]);

			dewPoint.dewPointTemp(this.chunksCreator.getChunks()[1], this.chunksCreator.getChunks()[2]);

			this.graphique.updateTable(this.chunksCreator.getChunks());
			this.graphique.initUI();

			System.out.println("\t" + this.chunksCreator.getChunks()[0] + "\t\t\t\t" + this.chunksCreator.getChunks()[1]
					+ "\t\t\t " + this.chunksCreator.getChunks()[2] + "\t\t" + this.chunksCreator.getChunks()[3]);
			System.out.println(dewPoint.getDewPointTemp());

			if (this.dewPoint.getDewPointTemp() > Double.parseDouble(this.chunksCreator.getChunks()[1])) {
				// Thread t = new Thread() {
				// public void run() {
				// this.popUp.
				// }
				// };
				// t.start();
				this.popUp.condensation();
			}
			
			if (this.graphique.getData()[0][9] - this.graphique.getData()[0][8] > 5) {
				this.popUp.porte();
			}
			
			Thread.sleep(1000);
		}
	}
}
