package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		CommPort commPort = new CommPort();
		Serial serial = new Serial();
		serial.serialLauncher(commPort.commPortFinder());
		
		DisplayLoop loop = new DisplayLoop(serial);
		loop.Loop();
	}
}
