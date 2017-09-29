package com.LightAlarm.Graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.LightAlarm.Main.LightController;

public class ControllerFrame extends JFrame {

	private Scale screenScale = new Scale(Toolkit.getDefaultToolkit().getScreenSize());
	private final int SCREEN_WIDTH = 1800;
	private MainPanel mainPanel;

	public ControllerFrame(LightController light) {
		int screenWidth = screenScale.multScaleWidth(SCREEN_WIDTH);
		int screenHeight = screenScale.multScaleHeight(SCREEN_WIDTH * 9 / 12);

		mainPanel = new MainPanel(light);

		setSize(new Dimension(screenWidth, screenHeight));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Sol");

		add(mainPanel);

	}
}
