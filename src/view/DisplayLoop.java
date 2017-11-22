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
	 * @param dewPoint
	 * @param graphique
	 * @param fenetre
	 * @param popUp
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
	 * A loop that refresh all we need.
	 * 
	 * @throws InterruptedException
	 */
	public void Loop() throws InterruptedException {
		while (true) {
			this.refreshData();
			this.dewPointCalculation();
			this.updateGraphic();
			this.printData();
			this.dewPointTest();
			this.doorOpenTest();
			Thread.sleep(1000);
		}
	}
	
	/**
	 * Refresh the display of the data on the window.
	 */
	public void refreshData() {
		this.fenetre.getConteneurFenetre().getValeurHumiditeLabel().setText(this.chunksCreator.getChunks()[2]);
		this.fenetre.getConteneurFenetre().getValeurTemperatureExterieurLabel()
				.setText(this.chunksCreator.getChunks()[0]);
		this.fenetre.getConteneurFenetre().getValeurTemperatureInterieurLabel()
				.setText(this.chunksCreator.getChunks()[1]);
	}
	
	/**
	 * Calculate the dew point.
	 */
	public void dewPointCalculation () {
		this.dewPoint.dewPointTemp(this.chunksCreator.getChunks()[1], this.chunksCreator.getChunks()[2]);
	}
	
	/**
	 * Update the graphic.
	 */
	public void updateGraphic() {
		this.graphique.updateTable(this.chunksCreator.getChunks());
		this.graphique.initUI();
	}
	
	/**
	 * Print the output of the Arduino card.
	 */
	public void printData() {
		for(int i = 0; i<4; i++) {
			System.out.println(this.chunksCreator.getChunks()[i] + "\t\t\t");
		}
//		
//		System.out.println("\t" + this.chunksCreator.getChunks()[0] + "\t\t\t\t" + this.chunksCreator.getChunks()[1]
//				+ "\t\t\t " + this.chunksCreator.getChunks()[2] + "\t\t" + this.chunksCreator.getChunks()[3]);
		System.out.println(dewPoint.getDewPointTemp());
	}
	
	/**
	 * Check if there is condensation formation, if yes, it display a new windows with a message.
	 */
	public void dewPointTest() {
		if (Double.parseDouble(this.chunksCreator.getChunks()[0]) > Double.parseDouble(this.chunksCreator.getChunks()[1])) {
			// Double.parseDouble(this.chunksCreator.getChunks()[0]) >
			// Double.parseDouble(this.chunksCreator.getChunks()[1])
			// this.dewPoint.getDewPointTemp() >
			// Double.parseDouble(this.chunksCreator.getChunks()[1])
			this.popUp.condensation();
		}
	}
	
	/**
	 * Check if the fridge's door is open, if yes, it display a new windows with a message.
	 */
	public void doorOpenTest() {
		if (this.graphique.getData()[0][9] - this.graphique.getData()[0][0] > 0.5) {
			// this.graphique.getData()[0][9] - this.graphique.getData()[0][8] > 5
			this.popUp.porte();
		}
	}
}