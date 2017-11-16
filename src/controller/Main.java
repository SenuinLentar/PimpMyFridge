package controller;

import view.*;
import model.*;


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		GraphicInterface graphicInterface = new GraphicInterface();
//		graphicInterface.Window();
		
		CommPort commPort = new CommPort();
		Serial serial = new Serial();
		serial.serialLauncher(commPort.commPortFinder());
		
	}

}
