package view;

import controller.DewPoint;
import model.ChunksCreator;
import model.Serial;

public class DisplayLoop {

	private ChunksCreator chunksCreator;
	private DewPoint dewPoint;

	/**
	 * Constructor of the DisplayLoop class.
	 * 
	 * @param chunksCreator
	 */
	public DisplayLoop(ChunksCreator chunksCreator, DewPoint dewPoint) {
		this.chunksCreator = chunksCreator;
		this.dewPoint = dewPoint;
		System.out.println("Température extérieure : \t Température intérieure : \t Humidité : \t Consigne :");
	}

	/**
	 * Endless print of the output of the Arduino card.
	 * 
	 * @throws InterruptedException
	 */
	public void Loop() throws InterruptedException {
		while (true) {
			// GraphicInterface.getPanel().update();
			dewPoint.dewPointTemp(this.chunksCreator.getChunks()[1], this.chunksCreator.getChunks()[2]);
			System.out.println("\t" + this.chunksCreator.getChunks()[0] + "\t\t\t\t" + this.chunksCreator.getChunks()[1]
					+ "\t\t\t     " + this.chunksCreator.getChunks()[2] + "\t\t" + this.chunksCreator.getChunks()[3]);
			System.out.println(dewPoint.getDewPointTemp());
			Thread.sleep(1000);
		}
	}
}
