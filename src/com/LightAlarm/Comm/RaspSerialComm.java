package com.LightAlarm.Comm;

import java.io.IOException;

import com.pi4j.wiringpi.Serial;

public class RaspSerialComm {

	private int serialPort;


	public RaspSerialComm() {
		int port = 0;
		while (port <= 4) {
			String path = "/dev/ttyACM" + port;
			System.out.println(path);
			//serialPort = Serial.serialOpen(path, 9600);
			port++;
		}
		if (port == 4) {
			System.out.println("Failed to open port...");
		}
	}

	public void writeToArduino(String ch) {
		//Serial.serialPutBytes(serialPort, ch.getBytes());
		//Serial.serialFlush(0);
	}
}
