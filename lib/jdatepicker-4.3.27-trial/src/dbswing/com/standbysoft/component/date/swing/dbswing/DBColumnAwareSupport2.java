/*
 * @(#)DBColumnAwareSupport2.java
 *
 * Copyright (c) 2003-2006 Stand By Soft, Ltd. All rights reserved.
 *
 * This software is the proprietary information of Stand By Soft, Ltd.  
 * Use is subject to license terms.
 */
package com.standbysoft.component.date.swing.dbswing;

import com.borland.dbswing.DBColumnAwareSupport;
import com.borland.dx.dataset.ColumnAware;

/**
 * Extends <code>DBColumnAwareSupport</code> to make available
 * the <code>lazyOpen()</code> protected method.
 */
public class DBColumnAwareSupport2 extends DBColumnAwareSupport {

	public DBColumnAwareSupport2(ColumnAware columnAwareObject) {
		super(columnAwareObject);
	}

	public void lazyOpen() {
		super.lazyOpen();
	}
}