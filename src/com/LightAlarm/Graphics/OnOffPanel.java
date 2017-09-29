package com.LightAlarm.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.LightAlarm.Main.LightController;

public class OnOffPanel extends JPanel {
	private LightController lightController;
	private ColorPickerPanel colorPicker;
	private JButton cmdOn = new JButton("On");
	private JButton cmdOff = new JButton("Off");
	private Font cmdFont = new Font("Consolas", Font.PLAIN, 48);
	private Dimension cmdDim = new Dimension(210, 70);
	private TitledBorder title;

	public OnOffPanel(ColorPickerPanel colorpicker, LightController light) {
		
		lightController = light;
		colorPicker = colorpicker;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		title = BorderFactory.createTitledBorder("On/Off");
		title.setBorder(blackline);
		title.setTitleFont(new Font("Consolas", Font.PLAIN, 32));

		setBorder(title);
		setLayout(new GridBagLayout());
		setBackground(new Color(210, 180, 140));

		cmdOn.setFont(cmdFont);
		cmdOff.setFont(cmdFont);
		cmdOn.setPreferredSize(cmdDim);
		cmdOff.setPreferredSize(cmdDim);
		cmdOn.setBackground(Color.white);
		cmdOff.setBackground(Color.white);

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(5, 5, 5, 5);

		c.gridx = 0;
		c.gridy = 0;

		add(cmdOn, c);

		c.gridx = 1;

		add(cmdOff, c);

		cmdOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r = colorPicker.getRedValue();
				int g = colorPicker.getGreenValue();
				int b = colorPicker.getBlueValue();
				lightController.lightsOn(r, g, b,0);
				//colorpicker.enableSliders(true);
			}
		});

		cmdOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lightController.lightsOff();
				//colorPicker.enableSliders(false);
			}
		});

	}

}
