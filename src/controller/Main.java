package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		ChunksCreator chunksCreator = new ChunksCreator();
		CommPort commPort = new CommPort();
				
		Serial serial = new Serial(commPort.getCommPort(), chunksCreator);
		serial.readIntput();
		
		DewPoint dewPoint = new DewPoint();
		
		Graphique graphique = new Graphique(chunksCreator);
		Fenetre fenetre = new Fenetre(graphique, chunksCreator, serial);
		serial.writeOutput(String.valueOf(fenetre.getConteneurFenetre().getConsigne()));
		
		PopUp popUp = new PopUp();
		
		DisplayLoop loop = new DisplayLoop(chunksCreator, dewPoint, graphique, fenetre, popUp);
		loop.Loop();		
	}
}
