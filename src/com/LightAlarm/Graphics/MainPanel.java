package com.LightAlarm.Graphics;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import com.LightAlarm.Main.LightController;

/*
 * This panel houses the current time panel 
 * the alarm panel
 */

public class MainPanel extends JPanel {

	private CurrentTimePanel currentTimePanel;
	private SetAlarmPanel alarmPanel;
	private OnOffPanel onOffPanel;
	private ColorPickerPanel colorPickerPanel;
	private BasicColorPanel basicColorPanel;
	private DimmerPanel dimmerPanel;

	public MainPanel(LightController light) {
		setLayout(new GridBagLayout());
		setBackground(new Color(210, 180, 140));

		currentTimePanel = new CurrentTimePanel(light);
		alarmPanel = new SetAlarmPanel(currentTimePanel, light);
		colorPickerPanel = new ColorPickerPanel(light);
		basicColorPanel = new BasicColorPanel(colorPickerPanel);
		onOffPanel = new OnOffPanel(colorPickerPanel, light);
		dimmerPanel = new DimmerPanel(colorPickerPanel);

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(10, 10, 10, 10);

		add(currentTimePanel, c);

		c.gridy = 1;

		add(alarmPanel, c);

		c.gridx = 1;
		c.gridy = 0;

		add(onOffPanel, c);

		c.gridy = 1;
		c.gridheight = 1;

		add(colorPickerPanel, c);

		c.gridx = 2;
		c.gridy = 0;

		add(dimmerPanel, c);

		c.gridy = 1;

		add(basicColorPanel, c);
		
		
		

	}
}
