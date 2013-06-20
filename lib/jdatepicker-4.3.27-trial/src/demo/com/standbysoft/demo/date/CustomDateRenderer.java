/*
 * @(#)CustomDateRenderer.java
 *
 * Copyright (c) 2003-2007 Stand By Soft, Ltd. All rights reserved.
 *
 * This software is the proprietary information of Stand By Soft, Ltd.  
 * Use is subject to license terms.
 */
package com.standbysoft.demo.date;

import java.awt.Color;
import java.awt.Graphics;

import com.standbysoft.component.date.swing.DefaultDateRenderer;

/**
 * Custom date renderer that extends the default one to display the selected
 * dates as rectangles and not like ovals and paints disabled dates with gray
 * instead of red.
 */
public class CustomDateRenderer extends DefaultDateRenderer {
	/**
	 * Paints a selected date as a rectangle.
	 */
	protected void paintSelected(Graphics g) {
		g.setColor(month.getTitleBackground());
		g.fillRect(1, 1, getWidth() - 1, getHeight() - 1);
	}

	/**
	 * Paints the today date as a rectangle with a red border.
	 */
	protected void paintToday(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(1, 1, getWidth() - 2, getHeight() - 2);
	}
	
	/**
	 * Paints disabled dates using a gray X.
	 */
	protected void paintDisabled(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawLine(3, 3, getWidth() - 3, getHeight() - 3);
		g.drawLine(getWidth() - 3, 3, 3, getHeight() - 3);
	}
}