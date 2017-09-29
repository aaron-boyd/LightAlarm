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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.LightAlarm.Main.LightController;

public class SetAlarmPanel extends JPanel {

	private CurrentTimePanel currentTimePanel;
	private LightController lightController;
	private JLabel lblHour = new JLabel("06");
	private JLabel lblMin = new JLabel("00");
	private JLabel lblCol = new JLabel(":");
	private JLabel lblAMPM = new JLabel("am");
	private JButton upHour = new JButton("^");
	private JButton downHour = new JButton("v");
	private JButton upMin = new JButton("^");
	private JButton downMin = new JButton("v");
	private JButton upAMPM = new JButton("^");
	private JButton downAMPM = new JButton("v");
	private JButton setAlarm = new JButton("Set Alarm");
	private JButton cancelAlarm = new JButton("Cancel Alarm");

	private Font lblFont = new Font("Consolas", Font.PLAIN, 60);
	private Font cmdFont = new Font("Consolas", Font.PLAIN, 72);
	private Font butFont = new Font("Consolas", Font.PLAIN, 32);

	public int alarmHour = 6;
	public int alarmMin = 0;
	public boolean alarmAMPM = true;
	private TitledBorder title;

	public SetAlarmPanel(CurrentTimePanel timePanel, LightController light) {
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		title = BorderFactory.createTitledBorder("Alarm Clock");
		title.setBorder(blackline);
		title.setTitleFont(new Font("Consolas", Font.PLAIN, 32));
		
		setLayout(new GridBagLayout());
		setBackground(new Color(210, 180, 140));
		setBorder(title);
		
		currentTimePanel = timePanel;
		lightController = light;

		lblHour.setFont(lblFont);
		lblMin.setFont(lblFont);
		lblCol.setFont(lblFont);
		lblAMPM.setFont(lblFont);

		upHour.setFont(cmdFont);
		downHour.setFont(cmdFont);
		upMin.setFont(cmdFont);
		downMin.setFont(cmdFont);
		upAMPM.setFont(cmdFont);
		downAMPM.setFont(cmdFont);

		setAlarm.setFont(butFont);
		cancelAlarm.setFont(butFont);
		
		upHour.setBackground(Color.white);
		downHour.setBackground(Color.white);
		upMin.setBackground(Color.white);
		downMin.setBackground(Color.white);
		upAMPM.setBackground(Color.white);
		downAMPM.setBackground(Color.white);
		setAlarm.setBackground(new Color(66, 209, 102));
		cancelAlarm.setBackground(new Color(249, 82, 82));
		
		
		setAlarm.setPreferredSize(new Dimension(400, 75));
		cancelAlarm.setPreferredSize(new Dimension(400, 75));

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(5, 5, 5, 5);

		c.gridx = 0;
		c.gridy = 0;

		add(upHour, c);

		c.gridy = 1;

		add(lblHour, c);

		c.gridy = 2;

		add(downHour, c);

		c.gridx = 1;
		c.gridy = 1;

		add(lblCol, c);

		c.gridx = 2;
		c.gridy = 0;

		add(upMin, c);

		c.gridy = 1;

		add(lblMin, c);

		c.gridy = 2;

		add(downMin, c);

		c.gridx = 3;
		c.gridy = 0;

		add(upAMPM, c);

		c.gridy = 1;

		add(lblAMPM, c);

		c.gridy = 2;

		add(downAMPM, c);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 4;

		add(setAlarm, c);

		c.gridy = 4;

		add(cancelAlarm, c);

		upHour.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				alarmHour++;
				if (alarmHour > 12) {
					alarmHour = 1;
				}
				if (alarmHour == 12) {
					upAMPM.doClick();
				}
				if (alarmHour < 10) {
					lblHour.setText("0" + Integer.toString(alarmHour));
				} else {
					lblHour.setText(Integer.toString(alarmHour));
				}
			}

		});

		downHour.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				alarmHour--;
				if (alarmHour <= 0) {
					alarmHour = 12;
				}
				if (alarmHour == 11) {
					upAMPM.doClick();
				}
				if (alarmHour < 10) {
					lblHour.setText("0" + Integer.toString(alarmHour));
				} else {
					lblHour.setText(Integer.toString(alarmHour));
				}
			}

		});

		upMin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				alarmMin += 5;
				if (alarmMin > 59) {
					alarmMin = 0;
				}
				if (alarmMin < 10) {
					lblMin.setText("0" + Integer.toString(alarmMin));
				} else {
					lblMin.setText(Integer.toString(alarmMin));
				}
			}

		});

		downMin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				alarmMin -= 5;
				if (alarmMin < 0) {
					alarmMin = 55;
				}
				if (alarmMin < 10) {
					lblMin.setText("0" + Integer.toString(alarmMin));
				} else {
					lblMin.setText(Integer.toString(alarmMin));
				}
			}

		});

		upAMPM.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				alarmAMPM ^= true;
				if (alarmAMPM) {
					lblAMPM.setText("am");
				} else {
					lblAMPM.setText("pm");
				}
			}

		});

		downAMPM.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				alarmAMPM ^= true;
				if (alarmAMPM) {
					lblAMPM.setText("am");
				} else {
					lblAMPM.setText("pm");
				}
			}

		});

		setAlarm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Color green = new Color(35, 119, 29);
				currentTimePanel.setAlarm(alarmHour, alarmMin, alarmAMPM);
				enableAndChangeColors(false, green);
				lightController.lightsOff();
			}
		});

		cancelAlarm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				currentTimePanel.disarmAlarm();
				enableAndChangeColors(true, Color.black);

			}
		});

	}

	private void enableAndChangeColors(boolean enble, Color color) {
		upHour.setEnabled(enble);
		downHour.setEnabled(enble);
		upMin.setEnabled(enble);
		downMin.setEnabled(enble);
		upAMPM.setEnabled(enble);
		downAMPM.setEnabled(enble);
		lblHour.setForeground(color);
		lblMin.setForeground(color);
		lblCol.setForeground(color);
		lblAMPM.setForeground(color);
	}

}
