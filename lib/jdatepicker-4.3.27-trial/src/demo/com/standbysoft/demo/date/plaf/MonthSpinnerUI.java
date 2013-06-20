/*
 * @(#)MonthSpinnerUI.java
 *
 * Copyright (c) 2003-2004 Stand By Soft, Ltd. All rights reserved.
 *
 * This software is the proprietary information of Stand By Soft, Ltd.  
 * Use is subject to license terms.
 */
package com.standbysoft.demo.date.plaf;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;

import com.standbysoft.component.date.swing.plaf.basic.DefaultMonthUI;

/**
 * <p>A UI delegate for <code>JMonth</code> that uses a spinner 
 * in the title to select the year.</p>
 */
public class MonthSpinnerUI extends DefaultMonthUI {
	protected JSpinner yearTitleSpinner;
	
	/**
	 * Factory method that creates the actual UI delegate.
	 */
	public static ComponentUI createUI(JComponent c) {
		return new MonthSpinnerUI();
	}

	/**
	 * Overridden to create a new title year component.
	 * 
	 * @return spinner title year component.
	 */
	protected JComponent createTitleYear() {
		yearTitleSpinner = new JSpinner(new SpinnerNumberModel(month.getYear(), 0, 9999, 1));
		yearTitleSpinner.setEditor(new JSpinner.NumberEditor(yearTitleSpinner, "#"));

	    //the spinner controls the displayed year
		yearTitleSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Integer value = (Integer)yearTitleSpinner.getValue();
				month.setYear(value.intValue());
			}
		});
		
		return yearTitleSpinner;
	}
	
	/**
	 * Updates the text from the title month label to reflect the state of the
	 * <code>JMonth</code> component.
	 */
	protected void updateTitle() {
		super.updateTitle();
		int y = month.getYear();

		yearTitleSpinner.setValue(new Integer(y));
	}
	
	protected void updateTitleForeground() {
		Color cy = yearTitleSpinner.getForeground();
		super.updateTitleForeground();
		yearTitleSpinner.setForeground(cy);
	}
}