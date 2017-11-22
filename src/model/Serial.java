package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
import java.util.TooManyListenersException;

public class Serial implements SerialPortEventListener {

	private static SerialPort serialPort;
	private static BufferedReader input;
	private static OutputStream output;
	private ChunksCreator chunksCreator;

	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 9600;

	/**
	 * Constructor of the Serial class.
	 * 
	 * @param commPort
	 * @param chunksCreator
	 * @throws Exception
	 */
	public Serial(String commPort, ChunksCreator chunksCreator) throws Exception {
		this.chunksCreator = chunksCreator;
		String PORT_NAMES[] = { commPort };
		this.connection(PORT_NAMES);
	}

	/**
	 * Establish a connection with the Arduino card.
	 * 
	 * @param PORT_NAMES
	 */
	public void connection(String PORT_NAMES[]) {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			System.out.println(" Could not find COM port. ");
			return;
		}

		try {
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
			Thread.sleep(4000);
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * Read the input on the serial port, in other words, the output of the Arduino
	 * card.
	 * 
	 * @throws IOException
	 * @throws TooManyListenersException
	 */
	public void readIntput() throws IOException, TooManyListenersException {
		// open the streams
		input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
		serialPort.addEventListener(this);
		serialPort.notifyOnDataAvailable(true);
	}

	/**
	 * Write the output on the serial port, in other words, the input of the Arduino
	 * card.
	 * 
	 * @throws IOException
	 */
	public void writeOutput(String consigne) throws IOException {
		output = serialPort.getOutputStream();
		output.write(consigne.getBytes());
	}

	/**
	 * Remove the listener and close the connection with the Arduino card.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	} 

	/*
	 * (non-Javadoc)
	 * 
	 * @see gnu.io.SerialPortEventListener#serialEvent(gnu.io.SerialPortEvent)
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {

			try {
				String inputLine = null;
				if (input.ready()) {
					inputLine = input.readLine();
					this.chunksCreator.setChunks(inputLine.split("/"));

					// System.out.println(chunks[0] + " \t " + chunks[1] + " \t ");
					// System.out.println(this.chunksCreator.getChunks()[0]);
				}

			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	}
}