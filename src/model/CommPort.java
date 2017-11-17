package model;

import gnu.io.*;
import java.util.Enumeration;

public class CommPort {

	public String commPortFinder() {
		CommPortIdentifier serialPortId;
		String commPort = "";
		Enumeration enumComm;

		enumComm = CommPortIdentifier.getPortIdentifiers();

		while (enumComm.hasMoreElements()) {
			serialPortId = (CommPortIdentifier) enumComm.nextElement();
			if (serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				commPort = serialPortId.getName();
			}
		}
		System.out.println(commPort);
		return commPort;
	}

}