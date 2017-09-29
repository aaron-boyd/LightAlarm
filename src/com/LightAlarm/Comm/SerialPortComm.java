package com.LightAlarm.Comm;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class SerialPortComm {

	private Enumeration portList;
	private CommPortIdentifier portId;
	private SerialPort serialPort;
	private OutputStream outputStream;


	public SerialPortComm() {
		portList = CommPortIdentifier.getPortIdentifiers();
		
		while (portList.hasMoreElements()) {

			portId = (CommPortIdentifier) portList.nextElement();
			System.out.println(portId.getName());
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				
				if (portId.getName().equals("COM4")) {

					try {
						serialPort = (SerialPort) portId.open("SimpleWriteApp", 2000);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (PortInUseException e) {
						System.out.println("err");
					}
					try {
						outputStream = serialPort.getOutputStream();
					} catch (IOException e) {
						System.out.println("err1");
					}
					try {
						serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
					} catch (UnsupportedCommOperationException e) {
						System.out.println("err2");
					}
				}
			}
		}
	}

	public void writeToArduino(String val) {
		try {
			outputStream.write(val.getBytes());
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
