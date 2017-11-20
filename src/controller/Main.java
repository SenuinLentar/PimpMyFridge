package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		ChunksCreator chunksCreator = new ChunksCreator();
		CommPort commPort = new CommPort();
				
		Serial serial = new Serial(commPort.getCommPort(), chunksCreator, "toto");

		serial.writeOutput();
		//Thread.sleep(7000);
		serial.readIntput();
		
		DewPoint dewPoint = new DewPoint();
		
		DisplayLoop loop = new DisplayLoop(chunksCreator, dewPoint);
		loop.Loop();
		
		

		
	}
}
