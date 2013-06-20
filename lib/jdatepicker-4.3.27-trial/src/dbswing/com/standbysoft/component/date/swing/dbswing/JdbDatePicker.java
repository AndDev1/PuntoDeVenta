/*
 * @(#)JdbDatePicker.java
 *
 * Copyright (c) 2003-2006 Stand By Soft, Ltd. All rights reserved.
 *
 * This software is the proprietary information of Stand By Soft, Ltd.  
 * Use is subject to license terms.
 */
package com.standbysoft.component.date.swing.dbswing;

import com.borland.dbswing.DBDataBinder;
import com.borland.dx.dataset.ColumnAware;
import com.borland.dx.dataset.DataSet;
import com.standbysoft.component.date.swing.JDatePicker;

/**
 * <p>A data-aware subclass of <code>JDatePicker</code>. It adds the following 
 * properties:</p>
 * 
 * <ul>
 * <li><code>dataSet</code>- The <code>DataSet</code> to which the date field value is assigned.</li>
 * <li><code>columnName</code>- The numeric <code>Column</code> of the
 * specified <code>DataSet</code> to which the value is assigned.</li>
 * </ul>
 * 
 * <p><code>JdbDatePicker</code> sets its <code>background</code>, <code>foreground</code>, 
 * and <code>font</code> properties from those defined on <code>Column</code> 
 * <code>columnName</code>, if one is defined, unless these properties are 
 * explicitly set on the <code>JdbDatePicker</code> itself.</p>
 * 
 * @see DBDateEditComponentDataBinder
 */
public class JdbDatePicker extends JDatePicker implements DBDataBinder, ColumnAware, java.io.Serializable {
	/**
	 * Data binder which makes this component data-aware.
	 */
	protected DBDateEditComponentDataBinder dataBinder;
	
	/**
	 * Creates a data-aware date field.
	 */
	public JdbDatePicker() {
		dataBinder = new DBDateEditComponentDataBinder(this);
	}

	/**
	 * Specifies the <code>DataSet</code> from which data values are read and to
	 * which data values are written.
	 * 
	 * @param dataSet specified <code>DataSet</code>
	 * @see #getDataSet()
	 * @see #setColumnName(String)
	 */
	public void setDataSet(DataSet dataSet) {
		dataBinder.setDataSet(dataSet);
	}

	/**
	 * Returns the <code>DataSet</code> from which data values are read and to
	 * which data values are written.
	 * 
	 * @return wrapped data set.
	 * @see #setDataSet(DataSet)
	 */
	public DataSet getDataSet() {
		return dataBinder.getDataSet();
	}

	/**
	 * Specifies the column name of the <code>DataSet</code> from which data values
	 * are read and to which data values are written.
	 * 
	 * @param columnName specified column name
	 * @see #getColumnName()
	 * @see #setDataSet(DataSet)
	 */
	public void setColumnName(String columnName) {
		dataBinder.setColumnName(columnName);
	}

	/**
	 * Returns the column name of the <code>DataSet</code> from which data
	 * values are read and to which data values are written.
	 * 
	 * @return column name.
	 * @see #setColumnName(String)
	 */
	public String getColumnName() {
		return dataBinder.getColumnName();
	}

	/**
	 * Returns the data binder that makes this component data-aware.
	 * 
	 * @return data binder that makes this component data-aware.
	 */
	DBDateEditComponentDataBinder getDataBinder() {
		return dataBinder;
	}
}