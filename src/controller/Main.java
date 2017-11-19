package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		ChunksCreator chunksCreator = new ChunksCreator();
		CommPort commPort = new CommPort();
		
		ArduinoInput test = new ArduinoInput(commPort.getCommPort());
		
		Serial serial = new Serial(commPort.getCommPort(), chunksCreator);
		
		
		DisplayLoop loop = new DisplayLoop(chunksCreator);
		//Thread.sleep(4000);
		loop.Loop();		
	}
}
