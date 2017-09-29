package com.LightAlarm.Main;

import java.awt.GraphicsEnvironment;

import com.LightAlarm.Graphics.ControllerFrame;


public class ControllerMain {

	public static void main(String[] args) {

		LightController lightController = new LightController(12, 2, 3, 7);
		ControllerFrame frame = new ControllerFrame(lightController);

	}
}
