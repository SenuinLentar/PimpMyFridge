package view;

import controller.ChunksCreator;
import model.Serial;

public class DisplayLoop {
	
	private ChunksCreator chunksCreator;
	
	/**
	 * Constructor of the DisplayLoop class.
	 * 
	 * @param chunksCreator
	 */
	public DisplayLoop(ChunksCreator chunksCreator) {
		this.chunksCreator = chunksCreator;
	}
	
	/**
	 * Endless print of the output of the Arduino card.
	 * 
	 * @throws InterruptedException
	 */
	public void Loop() throws InterruptedException {
		while (true) {
//			GraphicInterface.getPanel().update();
			System.out.println(this.chunksCreator.getChunks()[0] + "\t\t" + this.chunksCreator.getChunks()[1] + 
					"\t\t" + this.chunksCreator.getChunks()[2]);
			Thread.sleep(1000);
		}
	}
}
