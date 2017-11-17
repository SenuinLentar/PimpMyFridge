package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		ChunksCreator chunksCreator = new ChunksCreator();
		CommPort commPort = new CommPort();
		
		ArduinoInput test = new ArduinoInput(commPort.commPortFinder());
		
		Serial serial = new Serial(commPort.commPortFinder(), chunksCreator);
		
		
		DisplayLoop loop = new DisplayLoop(chunksCreator);

		loop.Loop();		
	}
}
