package view;

import model.Serial;

public class DisplayLoop {
	public DisplayLoop(Serial serial) {
		GraphicInterface graphicInterface = new GraphicInterface();
		graphicInterface.Window(serial);
	}

	public void Loop() throws InterruptedException {
		while (true) {
			GraphicInterface.getPanel().update();
			System.out.println("test");
			Thread.sleep(250);
		}
	}
}
