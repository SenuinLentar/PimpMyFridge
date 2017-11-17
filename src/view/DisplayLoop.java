
package view;

import controller.ChunksCreator;
import model.Serial;

public class DisplayLoop {
	
	private ChunksCreator chunksCreator;
	
//	public DisplayLoop(ChunksCreator chunksCreator) {
//		this.chunksCreator = chunksCreator;
//		GraphicInterface graphicInterface = new GraphicInterface();
//		graphicInterface.Window(this.chunksCreator);
//	}

	
	public DisplayLoop(ChunksCreator chunksCreator) {
		this.chunksCreator = chunksCreator;
	}
	
	public void Loop() throws InterruptedException {
		while (true) {
//			GraphicInterface.getPanel().update();
			System.out.println(this.chunksCreator.getChunks()[0]);
			Thread.sleep(200);
		}
	}
}

