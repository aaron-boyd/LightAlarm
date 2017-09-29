package com.LightAlarm.Main;

import com.LightAlarm.Comm.RaspSerialComm;
import com.LightAlarm.Comm.SerialPortComm;

public class LightController {
	private SerialPortComm serialPort;
	private RaspSerialComm raspSerialPort;
	private boolean lightsOn;
	private int R_VAL;
	private int G_VAL;
	private int B_VAL;
	private int W_VAL;

	public LightController(int red, int green, int blue, int white) {
		lightsOn = false;
		serialPort = new SerialPortComm();
		//raspSerialPort = new RaspSerialComm();

	}

	public void setLedColor(int r, int g, int b) {
		R_VAL = r;
		G_VAL = g;
		B_VAL = b;
		if (lightsOn) updateLights();
	}

	public void updateLights() { // Change the pin value to the new color
		String lightColor = R_VAL + "R" + G_VAL + "G" + B_VAL + "B" + W_VAL + "W";
		serialPort.writeToArduino(lightColor);
	}

	public void updateLights(String ch) {
		serialPort.writeToArduino(ch);
	}

	public void lightsOn(int r, int g, int b, int w) {
		lightsOn = true;
		setLedColor(r, g, b);
	}

	public void lightsOff() {
		setLedColor(0, 0, 0);
		lightsOn = false;
	}

	public boolean lightsOn() {
		return lightsOn;
	}

}