package view;

import model.Serial;

public class DisplayLoop {
	
	private String[] chunks;
	public DisplayLoop(Serial serial) {
//		GraphicInterface graphicInterface = new GraphicInterface();
//		graphicInterface.Window(serial);
	}

	public DisplayLoop(String[] chunks) {
		this.chunks = chunks;
	}
	public void Loop() throws InterruptedException {
		while (true) {
//			GraphicInterface.getPanel().update();
			System.out.println(chunks[0]);
			Thread.sleep(500);
		}
	}
}
