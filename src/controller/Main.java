package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		ChunksCreator chunksCreator = new ChunksCreator();
		CommPort commPort = new CommPort();
				
		Serial serial = new Serial(commPort.getCommPort(), chunksCreator, "toto");
		
		serial.writeOutput();
		
		serial.readIntput();
		
		DisplayLoop loop = new DisplayLoop(chunksCreator);
		loop.Loop();		
	}
}
