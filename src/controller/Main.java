package controller;

import view.*;
import model.*;

public class Main {

	public static void main(String[] args) throws Exception {
		ChunksCreator chunksCreator = new ChunksCreator();
		CommPort commPort = new CommPort();
		Serial serial = new Serial(commPort.commPortFinder(), chunksCreator);
		
		
		DisplayLoop loop = new DisplayLoop(chunksCreator);
		loop.Loop();
		
		
		
//		(new Thread(new Runnable() {
//			@Override
//			public void run() {
//
////				CommPort commPort = new CommPort();
////				Serial serial = new Serial();
//				try {
//					serial.serialLauncher(commPort.commPortFinder());
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		})).start();


	}
}
