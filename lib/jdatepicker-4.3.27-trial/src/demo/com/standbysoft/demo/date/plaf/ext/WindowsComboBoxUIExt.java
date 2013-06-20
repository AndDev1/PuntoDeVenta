/*
 * @(#)WindowsComboBoxUIExt.java
 *
 * Copyright (c) 2003-2007 Stand By Soft, Ltd. All rights reserved.
 *
 * This software is the proprietary information of Stand By Soft, Ltd.  
 * Use is subject to license terms.
 */
package com.standbysoft.demo.date.plaf.ext;

import javax.swing.plaf.basic.ComboPopup;

import com.jgoodies.looks.windows.WindowsComboBoxUI;
import com.standbysoft.component.util.swing.ComboBoxUIExt;

/**
 * A <code>WindowsComboBoxUI</code> object for which one can change the <code>ComboPopup</code>.
 * Extends the <code>ComboBoxUI</code> for the JGoodies Windows look and feel to 
 * make it possible to change the popup for a combo box.
 */
public class WindowsComboBoxUIExt extends WindowsComboBoxUI implements ComboBoxUIExt {
	private ComboPopup popup;
		
	protected ComboPopup createPopup() {
		if (popup == null) {
			return super.createPopup();
		} else {
			return popup;
		}
	}

	public void setComboPopup(ComboPopup popup) {
		this.popup = popup;
	}
}