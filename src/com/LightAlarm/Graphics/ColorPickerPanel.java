package com.LightAlarm.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.LightAlarm.Main.LightController;

public class ColorPickerPanel extends JPanel {

	private LightController lightController;
	private JSlider redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
	private JSlider greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
	private JSlider blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 100);
	private JButton cmdRainbow = new JButton("Rainbow");
	private JTextField txtRed = new JTextField("100");
	private JTextField txtGreen = new JTextField("100");
	private JTextField txtBlue = new JTextField("100");
	private JLabel lblRed = new JLabel("Red: ");
	private JLabel lblGreen = new JLabel("Green: ");
	private JLabel lblBlue = new JLabel("Blue: ");
	private JLabel lblWhite = new JLabel("White: ");
	private Dimension sliderDim = new Dimension(400, 60);
	private Font txtFont = new Font("Consolas", Font.PLAIN, 32);
	private Dimension txtDim = new Dimension(100, 35);
	private TitledBorder title;
	private boolean rainbowOn = false;

	public ColorPickerPanel(LightController light) {

		lightController = light;

		Border blackline = BorderFactory.createLineBorder(Color.black);
		title = BorderFactory.createTitledBorder("Color Picker");
		title.setBorder(blackline);
		title.setTitleFont(new Font("Consolas", Font.PLAIN, 32));

		setLayout(new GridBagLayout());
		setBorder(title);
		setBackground(new Color(210, 180, 140));

		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0, 20, 0, 20);

		redSlider.setPreferredSize(sliderDim);
		greenSlider.setPreferredSize(sliderDim);
		blueSlider.setPreferredSize(sliderDim);
		

		redSlider.setMaximum(255);
		greenSlider.setMaximum(255);
		blueSlider.setMaximum(255);
		

		cmdRainbow.setPreferredSize(new Dimension(400, 75));
		cmdRainbow.setFont(txtFont);
		cmdRainbow.setBackground(Color.white);

		lblRed.setFont(txtFont);
		lblGreen.setFont(txtFont);
		lblBlue.setFont(txtFont);
		
		txtRed.setFont(txtFont);
		txtGreen.setFont(txtFont);
		txtBlue.setFont(txtFont);

		txtRed.setPreferredSize(txtDim);
		txtGreen.setPreferredSize(txtDim);
		txtBlue.setPreferredSize(txtDim);
		

		c.gridwidth = 2;

		add(redSlider, c);

		c.gridy = 1;

		add(greenSlider, c);

		c.gridy = 2;

		add(blueSlider, c);



		c.gridwidth = 1;
		c.gridy = 3;
		c.insets = new Insets(10, 20, 10, 0);

		add(lblRed, c);

		c.gridx = 1;

		add(txtRed, c);

		c.gridx = 0;
		c.gridy = 4;

		add(lblGreen, c);

		c.gridx = 1;

		add(txtGreen, c);

		c.gridx = 0;
		c.gridy = 5;

		add(lblBlue, c);

		c.gridx = 1;

		add(txtBlue, c);



		c.gridy = 6;
		c.gridx = 0;
		c.gridwidth = 2;

		add(cmdRainbow, c);

		int red = redSlider.getValue();
		int green = greenSlider.getValue();
		int blue = blueSlider.getValue();
		Color newColor = new Color(red, green, blue);

		redSlider.setBackground(newColor);
		greenSlider.setBackground(newColor);
		blueSlider.setBackground(newColor);
	
		cmdRainbow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				rainbowOn ^= true;
				if(rainbowOn){
					lightController.updateLights("A");
				}else{
					lightController.updateLights();
				}

			}

		});

		txtRed.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (!(ke.getKeyChar() == 27 || ke.getKeyChar() == 65535)) {
					try {
						int value = Integer.parseInt(txtRed.getText());
						redSlider.setValue(value);
					} catch (Exception e) {

					}
				}
			}
		});

		txtGreen.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (!(ke.getKeyChar() == 27 || ke.getKeyChar() == 65535)) {
					try {
						int value = Integer.parseInt(txtGreen.getText());
						greenSlider.setValue(value);
					} catch (Exception e) {

					}
				}
			}
		});

		txtBlue.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (!(ke.getKeyChar() == 27 || ke.getKeyChar() == 65535)) {
					try {
						int value = Integer.parseInt(txtBlue.getText());
						blueSlider.setValue(value);
					} catch (Exception e) {

					}
				}
			}
		});

		redSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				txtRed.setText(Integer.toString(redSlider.getValue()));
				updateLedColor();
			}
		});

		greenSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				txtGreen.setText(Integer.toString(greenSlider.getValue()));
				updateLedColor();
			}
		});

		blueSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				txtBlue.setText(Integer.toString(blueSlider.getValue()));
				updateLedColor();
			}
		});


	}

	public void updateLedColor() {
		int red = redSlider.getValue();
		int green = greenSlider.getValue();
		int blue = blueSlider.getValue();
		
		
		Color newColor = new Color(red,green,blue);
	

		redSlider.setBackground(newColor);
		greenSlider.setBackground(newColor);
		blueSlider.setBackground(newColor);
		

		lightController.setLedColor(red, green, blue);
	}

	public int getRedValue() {
		return redSlider.getValue();
	}

	public int getGreenValue() {
		return greenSlider.getValue();
	}

	public int getBlueValue() {
		return blueSlider.getValue();
	}
	

	public void enableSliders(boolean bool) {
		redSlider.setEnabled(bool);
		greenSlider.setEnabled(bool);
		blueSlider.setEnabled(bool);
		txtRed.setEnabled(bool);
		txtGreen.setEnabled(bool);
		txtBlue.setEnabled(bool);
		cmdRainbow.setEnabled(bool);
	}

	public void dimmer(boolean bool) {
		int r_val = redSlider.getValue();
		int g_val = greenSlider.getValue();
		int b_val = blueSlider.getValue();

		if (bool) {
			if (r_val < 245 && g_val < 245 && b_val < 245) {
				redSlider.setValue(r_val + 10);
				greenSlider.setValue(g_val + 10);
				blueSlider.setValue(b_val + 10);
				updateLedColor();
			}
		} else {
			if (r_val > 10 && g_val > 10 && b_val > 10) {
				redSlider.setValue(r_val - 10);
				greenSlider.setValue(g_val - 10);
				blueSlider.setValue(b_val - 10);
				updateLedColor();
			}
		}

	}

	public void setRGBValue(int r, int g, int b) {
		redSlider.setValue(r);
		greenSlider.setValue(g);
		blueSlider.setValue(b);

	}

}
