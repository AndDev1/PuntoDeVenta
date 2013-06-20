/*
 * @(#)Main.java
 *
 * Copyright (c) 2003-2004 Stand By Soft, Ltd. All rights reserved.
 *
 * This software is the proprietary information of Stand By Soft, Ltd.  
 * Use is subject to license terms.
 */
package com.standbysoft.demo.date;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The entry point for the JDatePicker standalone demo application.
 */
public class Main {
	/**
	 * Name of the product.
	 */
	public static final String NAME = "JDatePicker";

	/**
	 * Product tag line.
	 */
	public static final String MESSAGE = "Professional date components for Swing";

	/**
	 * Centers a given frame on the screen.
	 * 
	 * @param frame frame to be centered
	 */
	private static void center(JFrame frame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = frame.getSize();
		screenSize.height = screenSize.height / 2;
		screenSize.width = screenSize.width / 2;
		size.height = size.height / 2;
		size.width = size.width / 2;
		int y = screenSize.height - size.height;
		int x = screenSize.width - size.width;
		frame.setLocation(x, y);
	}

	public static void main(String[] args) {
		String version = System.getProperty("java.version");
		
		if (version.startsWith("1.3") || version.startsWith("1.2")) {
			JOptionPane.showMessageDialog(null, "The date components presented by this application can be used with Java 1.3 or higher. \nHowever, the application uses specific Java 1.4 features for increased usability and \ncannot run with your current Java version.\n\nPlease use Java 1.4 or higher to run this application.", "Incompatible Java Version", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else {
			JFrame frame = new JFrame(NAME + " - " + MESSAGE);

			DemoApp.start(frame.getContentPane(), true);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			center(frame);
			frame.setVisible(true);
		}
	}
}