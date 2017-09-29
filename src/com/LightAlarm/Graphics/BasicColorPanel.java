package com.LightAlarm.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BasicColorPanel extends JPanel {

	private ColorPickerPanel colorPicker;
	private TitledBorder title;
	private int[] colors = { 0xFF0000, 0x00FF00, 0x0000FF, 0xFFFFFF, 0xFFFF00, 0x00FFA9, 0x0065FF, 0xFFC1F9, 0xDD7E25, 0x00FFFF, 0x5705AF, 0xFF8EF5, 0xFFAA00, 0x00BFFF, 0x46004C, 0xB2FFE9, 0xFFDD00, 0x0087FF, 0xC386CC, 0xC3F4F1, };
	// private int colors[]
	// ={0x000000,0xFFFF00,0x1CE6FF,0xFF34FF,0xFF4A46,0x008941,0x006FA6,0xA30059,0xFFDBE5,0x7A4900,0x0000A6,0x63FFAC,0xB79762,0x004D43,0x8FB0FF,0x997D87,0x5A0007,0x809693,0xFEFFE6,0x1B4400,0x4FC601,0x3B5DFF,0x4A3B53,0xFF2F80,0x61615A,0xBA0900,0x6B7900,0x00C2A0,0xFFAA92,0xFF90C9,0xB903AA,0xD16100,0xDDEFFF,0x000035,0x7B4F4B,0xA1C299,0x300018,0x0AA6D8,0x013349,0x00846F,0x372101,0xFFB500,0xC2FFED,0xA079BF,0xCC0744,0xC0B9B2,0xC2FF99,0x001E09,0x00489C,0x6F0062,0x0CBD66,0xEEC3FF,0x456D75,0xB77B68,0x7A87A1,0x788D66,0x885578,0xFAD09F,0xFF8A9A,0xD157A0,0xBEC459,0x456648,0x0086ED,0x886F4C,0x34362D,0xB4A8BD,0x00A6AA,0x452C2C,0x636375,0xA3C8C9,0xFF913F,0x938A81,0x575329,0x00FECF,0xB05B6F,0x8CD0FF,0x3B9700,0x04F757,0xC8A1A1,0x1E6E00,0x7900D7,0xA77500,0x6367A9,0xA05837,0x6B002C,0x772600,0xD790FF,0x9B9700,0x549E79,0xFFF69F,0x201625,0x72418F,0xBC23FF,0x99ADC0,0x3A2465,0x922329,0x5B4534,0xFDE8DC,0x404E55,0x0089A3,0xCB7E98,0xA4E804,0x324E72,0x6A3A4C};
	private JButton[] buttons;


	public BasicColorPanel(ColorPickerPanel color) {
		setLayout(new GridLayout(5, 4));

		Border blackline = BorderFactory.createLineBorder(Color.black);
		title = BorderFactory.createTitledBorder("Colors");
		title.setBorder(blackline);
		title.setTitleFont(new Font("Consolas", Font.PLAIN, 32));
		setBorder(title);
		setBackground(new Color(210, 180, 140));

		colorPicker = color;
		buttons = new JButton[20];

		for (int i = 0; i < 20; i++) {
			buttons[i] = new JButton();
			buttons[i].setBackground(convertColors(colors[i]));
			buttons[i].addActionListener(new ColorButtonListener(buttons[i].getBackground()));
			buttons[i].setPreferredSize(new Dimension(90, 90));
			add(buttons[i]);
		}

	}

	private Color convertColors(int num) {
		int r_val = (num & 0xFF0000) >> 16;
		int g_val = (num & 0x00FF00) >> 8;
		int b_val = (num & 0x0000FF);

		return new Color(r_val, g_val, b_val);
	}

	class ColorButtonListener implements ActionListener {

		private Color buttonColor;

		public ColorButtonListener(Color color) {
			buttonColor = color;
		
		}

		public void actionPerformed(ActionEvent arg0) {
			int r = buttonColor.getRed();
			int g = buttonColor.getGreen();
			int b = buttonColor.getBlue();

			colorPicker.setRGBValue(r, g, b);

		}

	}
}
