package model;

import java.io.*;
import java.util.*;
import gnu.io.*;

public class ArduinoInput {

	private static Enumeration portList;
	private static CommPortIdentifier portId;
	private static String messageString = "toto";
	private static SerialPort serialPort;
	private static OutputStream outputStream;
	private String commPort;

	/**
	 * Constructor of the ArduinoInput.
	 * 
	 * @param commPort
	 * @throws InterruptedException
	 */
	public ArduinoInput(String commPort) throws InterruptedException {
		this.commPort = commPort;
		this.initialize();
	}

	/**
	 * Establish a connection with the Arduino card, send a string to it and close
	 * the connection.
	 * 
	 * @throws InterruptedException
	 */
	public void initialize() throws InterruptedException {
		portList = CommPortIdentifier.getPortIdentifiers();

		while (portList.hasMoreElements()) {

			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {

				if (portId.getName().equals(this.commPort)) {

					try {
						serialPort = (SerialPort) portId.open(this.getClass().getName(), 2000);
						 Thread.sleep(4000);
						// System.out.println("0");
					} catch (PortInUseException e) {
						System.out.println("err");
					}
					try {
						serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
								SerialPort.PARITY_NONE);
						// Thread.sleep(4000);
						// System.out.println("2");
					} catch (UnsupportedCommOperationException e) {
						System.out.println("err2");
					}
					try {
						outputStream = serialPort.getOutputStream();
						// Thread.sleep(4000);
						// System.out.println("1");
					} catch (IOException e) {
						System.out.println("err1");
					}
					// try {
					// serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
					// SerialPort.STOPBITS_1,
					// SerialPort.PARITY_NONE);
					// // Thread.sleep(4000);
					// // System.out.println("2");
					// } catch (UnsupportedCommOperationException e) {
					// System.out.println("err2");
					// }
					try {
						outputStream.write(messageString.getBytes());
						// Thread.sleep(4000);
						// System.out.println("3");
						System.out.println("---> " + messageString);

						outputStream.close();
						serialPort.close();

					} catch (IOException e) {
						System.out.println("err3");
					}
				}
			}
		}
	}
}
