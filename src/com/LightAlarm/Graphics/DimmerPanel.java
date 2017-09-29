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

public class DimmerPanel extends JPanel {

	private ColorPickerPanel colorPicker;
	private TitledBorder title;
	private JButton cmdUp = new JButton("+");
	private JButton cmdDown = new JButton("-");
	private Font cmdFont = new Font("Consolas", Font.PLAIN, 48);
	private Dimension cmdDim = new Dimension(170, 70);

	public DimmerPanel(ColorPickerPanel color) {

		colorPicker = color;

		Border blackline = BorderFactory.createLineBorder(Color.black);
		title = BorderFactory.createTitledBorder("Dimmer");
		title.setBorder(blackline);
		title.setTitleFont(new Font("Consolas", Font.PLAIN, 32));

		setLayout(new GridBagLayout());
		setBorder(title);
		setBackground(new Color(210, 180, 140));

		cmdUp.setPreferredSize(cmdDim);
		cmdDown.setPreferredSize(cmdDim);
		cmdUp.setFont(cmdFont);
		cmdDown.setFont(cmdFont);
		cmdUp.setBackground(Color.white);
		cmdDown.setBackground(Color.white);

		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.WEST;

		add(cmdDown, c);

		c.gridx = 1;

		add(cmdUp, c);

		cmdUp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				colorPicker.dimmer(true);
			}
		});

		cmdDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				colorPicker.dimmer(false);
			}
		});

	}

}
