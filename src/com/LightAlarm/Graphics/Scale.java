package com.LightAlarm.Graphics;

import java.awt.Dimension;

public class Scale {

	private double myScaleWidth;
	private double myScaleHeight;

	public Scale() {
		myScaleWidth = 0.0;
		myScaleHeight = 0.0;
	}

	public Scale(Dimension screenDim) {
		myScaleWidth = screenDim.getWidth() / 3840;
		myScaleHeight = screenDim.getHeight() / 2160;
	}

	public double getScaleWidth() {
		return myScaleWidth;
	}

	public double getScaleHeight() {
		return myScaleHeight;
	}

	public int multScaleWidth(int width) {
		return (int) Math.round(width * myScaleWidth);
	}
	
	public int multScaleHeight(int height){
		return (int)Math.round(height * myScaleHeight);
	}

}

