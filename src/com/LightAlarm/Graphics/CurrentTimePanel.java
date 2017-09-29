package com.LightAlarm.Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.LightAlarm.Main.LightController;

public class CurrentTimePanel extends JPanel implements Runnable {

	private Thread runner;
	private LightController lightController;
	private Font font = new Font("Consolas", Font.PLAIN, 60);
	private JLabel label = new JLabel();
	private int alarmHour = -1;
	private int alarmMin = -1;
	private boolean alarmAMPM = false;
	private boolean alarmArmed = false;
	private boolean alarmTriggered = false;
	private TitledBorder title;

	public CurrentTimePanel(LightController light) {
		
		runner = new Thread(this, "Current Time Thread");
		
		lightController = light;
		
		setLayout(new GridBagLayout());
		setBackground(new Color(210, 180, 140));
		label.setFont(font);
		
		add(label);
		
		runner.start();
	}

	public void run() {
		Calendar cal;
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		while (true) {
			cal = Calendar.getInstance();
			if (cal.get(Calendar.AM_PM) == 1) {
				label.setText(sdf.format(cal.getTime()) + " pm");
			} else {
				label.setText(sdf.format(cal.getTime()) + " am");
			}
			if (checkAlarm(cal)) {
				lightController.updateLights("Q");
			}
		}
	}

	public void setAlarm(int hour, int min, boolean ampm) {
		alarmHour = hour;
		alarmMin = min;
		alarmAMPM = ampm;
		alarmArmed = true;
		System.out.println("Alarm has been activated.");
		System.out.println(alarmHour + ":" + alarmMin + " " + alarmAMPM);
	}

	public void disarmAlarm() {
		alarmHour = -1;
		alarmMin = -1;
		alarmAMPM = true;
		alarmArmed = false;
		System.out.println("Alarm has been deactivated.");
	}

	public boolean checkAlarm(Calendar cal) {
		if (alarmArmed) {
			if (cal.get(Calendar.HOUR) == alarmHour) {
				//System.out.println("Hours match");
				if (cal.get(Calendar.MINUTE) == alarmMin) {
					System.out.println("Minutes match");
					int ampm = cal.get(Calendar.AM_PM);
					if (ampm == 1 && !alarmAMPM) {
						System.out.println("AMPM match");
						System.out.println("Alarm has been triggered!");
						alarmArmed = false;
						return true;
					}
					if (ampm == 0 && alarmAMPM) {
						System.out.println("AMPM match");
						System.out.println("Alarm has been triggered!");
						alarmArmed = false;
						return true;
					}
				}
			}
		}
		return false;
	}

}
