/*
 * @(#)MonthSpinnersUI.java
 *
 * Copyright (c) 2003-2007 Stand By Soft, Ltd. All rights reserved.
 *
 * This software is the proprietary information of Stand By Soft, Ltd.  
 * Use is subject to license terms.
 */
package com.standbysoft.demo.date.plaf;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;

import com.standbysoft.component.date.swing.JMonth;
import com.standbysoft.component.date.swing.plaf.basic.BasicMonthUI;

/**
 * <p>
 * A UI delegate for <code>JMonth</code> that uses spinners in the title to
 * select the month and year.
 * </p>
 */
public class MonthSpinnersUI extends BasicMonthUI {
	protected JSpinner monthTitleSpinner;

	protected JSpinner yearTitleSpinner;

	/**
	 * Factory method that creates the actual UI delegate.
	 */
	public static ComponentUI createUI(JComponent c) {
		return new MonthSpinnersUI();
	}

	protected LayoutManager createTitleLayout() {
		return new TitleLayoutManager2();
	}

	protected LayoutManager createLayout() {
		return new DefaultLayoutManager2();
	}

	/**
	 * Overridden to create a new title month component.
	 * 
	 * @return a combo box with all the months of the year.
	 */
	protected JComponent createTitleMonth() {
		monthTitleSpinner = new JSpinner(new MonthSpinnerListModel(month));

		monthTitleSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String value = (String) monthTitleSpinner.getValue();
				int selectedMonth = getMonthByID(value);

				if (selectedMonth != -1) {
					month.setMonth(selectedMonth);
				}
			}
		});

		return monthTitleSpinner;
	}

	private int getMonthByID(String monthName) {
		String months[] = month.getMonthModel().getMonthNames();
		int selectedMonth = -1;

		for (int i = 0; i < months.length; i++) {
			if (months[i].equals(monthName)) {
				selectedMonth = i;
			}
		}

		return selectedMonth;
	}

	protected JComponent createBody() {
		JComponent body = super.createBody();
		body.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		return body;
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
				Integer value = (Integer) yearTitleSpinner.getValue();
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
		int m = month.getMonth();
		int y = month.getYear();
		monthTitleSpinner.setValue(month.getMonthModel().getMonthNames()[m]);
		yearTitleSpinner.setValue(new Integer(y));
	}

	protected void updateTitleForeground() {
		Color cm = monthTitleSpinner.getForeground();
		Color cy = yearTitleSpinner.getForeground();
		super.updateTitleForeground();
		monthTitleSpinner.setForeground(cm);
		yearTitleSpinner.setForeground(cy);
	}

	/**
	 * Empty implementation because the background must remain untouched to
	 * resemble to Windows Date/Time component.
	 */
	protected void updateTitleBackground() {
	}
}

class TitleLayoutManager2 extends GridBagLayout {
	public void addLayoutComponent(Component comp, Object constraints) {
		if (constraints.equals("TitleMonth")) {
			super.addLayoutComponent(comp, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 10, 5), 0, 0));
		} else if (constraints.equals("TitleYear")) {
			super.addLayoutComponent(comp, new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 5, 10, 0), 0, 0));
		}
	}
}

class DefaultLayoutManager2 extends GridBagLayout {
	public void addLayoutComponent(Component comp, Object constraints) {
		if (constraints.equals("Title")) {
			super.addLayoutComponent(comp, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		}
		if (constraints.equals("Month")) {
			super.addLayoutComponent(comp, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
	}
}

class MonthSpinnerListModel extends SpinnerListModel {
	private Object[] values;
	
	public MonthSpinnerListModel(JMonth month) {
		String[] monthNames = month.getMonthModel().getMonthNames();
		
		values = new Object[12];
		values[0] = monthNames[Calendar.JANUARY];
		values[1] = monthNames[Calendar.FEBRUARY];
		values[2] = monthNames[Calendar.MARCH];
		values[3] = monthNames[Calendar.APRIL];
		values[4] = monthNames[Calendar.MAY];
		values[5] = monthNames[Calendar.JUNE];
		values[6] = monthNames[Calendar.JULY];
		values[7] = monthNames[Calendar.AUGUST];
		values[8] = monthNames[Calendar.SEPTEMBER];
		values[9] = monthNames[Calendar.OCTOBER];
		values[10] = monthNames[Calendar.NOVEMBER];
		values[11] = monthNames[Calendar.DECEMBER];
		
		setList(Arrays.asList(values));
	}
	
	public Object getNextValue() {
		if (getValue().equals(values[values.length - 1])) {
			return values[0];
		} else {
			return super.getNextValue();
		}
	}
	
	public Object getPreviousValue() {
		if (getValue().equals(values[0])) {
			return values[values.length - 1];
		} else {
			return super.getPreviousValue();
		}
	}
}