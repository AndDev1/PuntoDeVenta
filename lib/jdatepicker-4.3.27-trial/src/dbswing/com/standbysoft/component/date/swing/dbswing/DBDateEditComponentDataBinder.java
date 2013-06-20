/*
 * @(#)DBDateEditComponentDataBinder.java
 *
 * Copyright (c) 2003-2006 Stand By Soft, Ltd. All rights reserved.
 *
 * This software is the proprietary information of Stand By Soft, Ltd.  
 * Use is subject to license terms.
 */
package com.standbysoft.component.date.swing.dbswing;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.plaf.UIResource;

import com.borland.dbswing.DBDataBinder;
import com.borland.dx.dataset.AccessEvent;
import com.borland.dx.dataset.AccessListener;
import com.borland.dx.dataset.Column;
import com.borland.dx.dataset.ColumnAware;
import com.borland.dx.dataset.DataChangeEvent;
import com.borland.dx.dataset.DataChangeListener;
import com.borland.dx.dataset.DataSet;
import com.borland.dx.dataset.Designable;
import com.borland.dx.dataset.NavigationEvent;
import com.borland.dx.dataset.NavigationListener;
import com.standbysoft.component.date.DateSelectionModel;
import com.standbysoft.component.date.event.DateSelectionEvent;
import com.standbysoft.component.date.event.DateSelectionListener;
import com.standbysoft.component.date.swing.JDateEditComponent;

/**
 * <p>Maps the state of a <code>JDateEditComponent</code> <code>DateSelectionModel</code> 
 * to a value in a <code>DataSet</code> date type <code>Column</code>.
 * <code>JdbDateField</code> automatically uses a <code>DBDateEditComponentDataBinder</code>,
 * and therefore it becomes a data-aware component.</p>
 * 
 * <p>There are two ways to hook up a <code>JDateEditComponent</code> to a
 * <code>DBDateEditComponentDataBinder</code>. The easier way is to set the
 * <code>jDateEditComponent</code> property to a <code>JDateEditComponent</code> 
 * or a subclass of <code>JDateEditComponent</code>.</p> 
 * 
 * <p>The second way is to make any component using a <code>DateSelectionModel</code> 
 * data-aware by setting <code>DBDateEditComponentDataBinder's dateSelectionModel</code> 
 * property to the component's model. Note that when you use this approach, you 
 * are responsible for opening the <code>DataSet</code> before using it.</p>
 * 
 * <p>You must also set the <code>DBDateEditComponentDataBinder's dataSet</code> and
 * <code>columnName</code> properties to specify the <code>DataSet</code>
 * and <code>Column</code> from which the date edit component value (its current position)
 * is read and to which the date value is written.</p>
 * 
 * <p>If you set the <code>jDateEditComponent</code> property, <code>DBDateEditComponentDataBinder</code> 
 * binds the <code>background, foreground</code>, and <code>font</code> properties
 * from those defined on <code>Column columnName</code>, if one exists. This
 * does not happen if these properties are set explicitly on
 * <code>DBDateEditComponentDataBinder</code> itself.</p>
 * 
 * <p>Example:</p>
 * 
 * <pre>
 *  JDateField jDateField = new JDateField();
 *  DBDateEditComponentDataBinder dBDateEditDataBinder = new DBDateEditComponentDataBinder();
 *          
 *  // attach the date field to DBDateEditComponentDataBinder
 *  dBDateEditDataBinder.setJDateEditComponent(jDateField);
 *          
 *  // set the target DataSet and Column
 *  dBDateEditDataBinder.setDataSet(dataSet);
 *  dBDateEditDataBinder.setColumnName(&quot;Delivery&quot;)
 * </pre>
 * 
 * @see JdbDateField
 */
public class DBDateEditComponentDataBinder implements DateSelectionListener, PropertyChangeListener, DBDataBinder, AccessListener, DataChangeListener, NavigationListener, ColumnAware, Designable, java.io.Serializable {
	/** 
	 * Date edit component that is made data-aware. 
	 */
	private JDateEditComponent dateEditComponent;

	/**
	 * Reference to the old date edit component. This is needed to unconfigure
	 * the system when a new component is used.
	 */
	private JDateEditComponent oldDateEditComponent;

	/** 
	 * Date selection model used to track date selections. 
	 */
	private DateSelectionModel dateSelectionModel;

	/** 
	 * Column aware delegate object. 
	 */
	private DBColumnAwareSupport2 columnAwareSupport = new DBColumnAwareSupport2(this);

	// for DataSet.enableDataSetEvents() support
	private boolean dataSetEventsEnabled = true;
	
	private boolean rebindColumnProperties;

	/**
	 * Creates a default data binder.
	 */
	public DBDateEditComponentDataBinder() {
	}

	/**
	 * Creates a data binder and specifies the date edit component it makes data 
	 * aware.
	 * 
	 * @param dateEditComponent date edit component it makes data aware.
	 */
	public DBDateEditComponentDataBinder(JDateEditComponent dateEditComponent) {
		setJDateEditComponent(dateEditComponent);
	}

	//
	// DBDateEditComponentDataBinder properties
	//
	/**
	 * Sets the date edit component to which this object binds to make it data-aware.
	 * 
	 * @param dateEditComponent date edit component that this binder makes data-aware
	 * @see #getJDateEditComponent()
	 */
	public void setJDateEditComponent(JDateEditComponent dateEditComponent) {
		if (this.dateEditComponent != null && this.dateEditComponent != dateEditComponent) {
			this.dateEditComponent.removePropertyChangeListener(this);
		}
		this.dateEditComponent = dateEditComponent;

		if (dateEditComponent == null) {
			setDateSelectionModel(null);
		} else {
			dateEditComponent.addPropertyChangeListener(this);
			setDateSelectionModel(dateEditComponent.getDateSelectionModel());
		}
	}

	/**
	 * Returns the date edit component to which this object binds to make it 
	 * data-aware.
	 * 
	 * @return date edit component to which this object binds to make it data-aware.
	 * @see #setJDateEditComponent(JDateEditComponent)
	 */
	public JDateEditComponent getJDateEditComponent() {
		return dateEditComponent;
	}

	/**
	 * Specifies the date selection model of the component that this binder
	 * makes data-aware. When you set this property, you are responsible for
	 * opening the DataSet before using it. Specifying the model binds this
	 * object to the component the model supplies data values to.
	 * 
	 * @param dateSelectionModel model of the component that this object makes data-aware
	 * @see #getDateSelectionModel()
	 */
	public void setDateSelectionModel(DateSelectionModel dateSelectionModel) {
		if (this.dateSelectionModel != null) {
			this.dateSelectionModel.removeDateSelectionListener(this);
		}

		this.dateSelectionModel = dateSelectionModel;

		if (dateSelectionModel != null) {
			dateSelectionModel.addDateSelectionListener(this);
		}
	}

	/**
	 * Returns the model of the component that this binder makes data-aware.
	 * 
	 * @return model of the component that this binder makes data-aware.
	 * @see #setDateSelectionModel(DateSelectionModel)
	 */
	public DateSelectionModel getDateSelectionModel() {
		return dateSelectionModel;
	}

	//
	// ColumnAware interface implememtation
	//
	/**
	 * Sets the <code>DataSet</code> from which values are read and to which
	 * values are written.
	 * 
	 * @param dataSet data set from which values are read and to which values are written
	 * @see #getDataSet()
	 * @see #setColumnName(String)
	 */
	public void setDataSet(DataSet dataSet) {
		if (columnAwareSupport.getDataSet() != null) {
			columnAwareSupport.getDataSet().removeNavigationListener(this);
		}
		columnAwareSupport.setDataSet(dataSet);
		if (dataSet != null) {
			columnAwareSupport.getDataSet().addNavigationListener(this);
		}
		bindColumnProperties();
	}

	/**
	 * Returns the <code>DataSet</code> from which values are read and to
	 * which values are written.
	 * 
	 * @return data set from which values are read and to which values are written.
	 * @see #setDataSet(DataSet)
	 * @see #getColumnName()
	 */
	public DataSet getDataSet() {
		return columnAwareSupport.getDataSet();
	}

	/**
	 * Specifies the column name of the <code>DataSet</code> from which values are
	 * read and to which values are written.
	 * 
	 * @param columnName <code>DataSet</code> column name from which values are 
	 * read and to which values are written
	 * @see #getColumnName()
	 * @see #setDataSet(DataSet)
	 */
	public void setColumnName(String columnName) {
		columnAwareSupport.setColumnName(columnName);
		bindColumnProperties();
	}

	/**
	 * Returns the column name of the <code>DataSet</code> from which values
	 * are read and to which values are written.
	 * 
	 * @return data set from which values are read and to which values are written.
	 * @see #setColumnName(String)
	 * @see #getDataSet()
	 */
	public String getColumnName() {
		return columnAwareSupport.getColumnName();
	}

	//
	// java.beans.PropertyChangeListener
	//
	public void propertyChange(PropertyChangeEvent e) {
		if (e.getPropertyName().equals("ancestor")) {
			bindColumnProperties();
		}
		if (e.getPropertyName().equals("dateSelectionModel")) {
			setDateSelectionModel((DateSelectionModel) e.getNewValue());
		}
	}

	//
	// javax.swing.event.ChangeListener interface implemenation
	//
	public void dateSelectionChanged(DateSelectionEvent evt) {
		columnAwareSupport.lazyOpen();
		if (columnAwareSupport.isValidDataSetState()) {
			Date date = evt.getFirstDate();
			if (date != null) {
				columnAwareSupport.setObject(new java.sql.Date(date.getTime()));
			} else {
				columnAwareSupport.setObject(null);
			}
		}
	}

	public void disabledDateSelectionAttempted(DateSelectionEvent evt) {
		//do nothing
	}
	
	public void disabledDatesChanged(DateSelectionEvent evt) {
		//do nothing
	}

	public void selectionModeChanged(DateSelectionEvent evt) {
		//do nothing
	}

	public void emptySelectionAllowedChanged(DateSelectionEvent evt) {
		//do nothing
	}

	// synchronizes the state of the date component selection model with the 
	// current DataSet value
	private void updateDateEditComponentState() {
            if(columnAwareSupport.isValidDataSetState()) {
                if (dateEditComponent != null) {
                    java.sql.Date date = columnAwareSupport.getVariant().getDate();

                    if (!dateSelectionModel.isDateSelected(date)) {
                        dateSelectionModel.setDateSelectionIterval(date, date);
                    }
                }
            }
	}

	//
	// com.borland.dx.dataset.NavigationListener interface implementation
	//
	public void navigated(NavigationEvent event) {
		if (!dataSetEventsEnabled) {
			return;
		}
		// navigation means we've moved on to a different row, and we need
		// to update the date edit component state to the current value.
		updateDateEditComponentState();
	}

	//
	// com.borland.dx.dataset.DataChangeListener interface implementation
	//
	public void dataChanged(DataChangeEvent event) {
		if (!dataSetEventsEnabled) {
			return;
		}
		// depending upon the event, we might have to update the current
		// date edit component state.
		int affectedRow = event.getRowAffected();
		boolean affectedOurRow = (affectedRow == columnAwareSupport.getDataSet().getRow()) || affectedRow == -1;
		if (affectedOurRow) {
			updateDateEditComponentState();
		}
	}

	public void postRow(DataChangeEvent event) throws Exception {
		// usually needs to get the pending value from the control and set it
	}

	//
	// Code to bind visual Column properties to date edit component
	//

	// returns true if the property has not been explicitly overridden
	// true if and only if the object is an instance of UIResource
	private boolean isDefaultProperty(Object property) {
		return (property == null) || (property instanceof UIResource);
	}

	// binds text, alignment, font, foreground, and background properties from
	// column
	// if not explicitly set on date edit component
	private void bindColumnProperties() {
		if (oldDateEditComponent != null) {
			oldDateEditComponent = null;
		}

		if (dateEditComponent != null && dateEditComponent.isDisplayable()) {
			// ensures that if lazyOpen has to reopen the DataSet, we won't call
			// bindColumnProperties
			// again on the OPEN access event
			rebindColumnProperties = false;
			// will resync our internal state if the dataSet or column has
			// changed
			columnAwareSupport.lazyOpen();

			updateDateEditComponentState();

			if (columnAwareSupport.isValidDataSetState()) {
				oldDateEditComponent = dateEditComponent;

				// if we have a valid column, merge its properties
				Column column = columnAwareSupport.getColumn();
				if (isDefaultProperty(dateEditComponent.getBackground())) {
					if (column.getBackground() != null) {
						dateEditComponent.setBackground(column.getBackground());
					}
				}
				if (isDefaultProperty(dateEditComponent.getForeground())) {
					if (column.getForeground() != null) {
						dateEditComponent.setForeground(column.getForeground());
					}
				}
				if (isDefaultProperty(dateEditComponent.getFont())) {
					if (column.getFont() != null) {
						dateEditComponent.setFont(column.getFont());
					}
				}

				if (dateEditComponent.isEnabled() && !column.isEditable()) {
					dateEditComponent.setEnabled(false);
				}
			}
		}
	}

	//
	// com.borland.dx.dataset.AccessListener interface implementation
	//
	public void accessChange(AccessEvent event) {
		if (event.getID() == AccessEvent.CLOSE) {
			if (event.getReason() == AccessEvent.STRUCTURE_CHANGE) {
				dataSetEventsEnabled = false;
				return;
			} else {
//				if (mode == DISABLE_COMPONENT) {
//					dateEditComponent.setEnabled(false);
//				}
			}
			if (event.getReason() == AccessEvent.PROPERTY_CHANGE) {
				rebindColumnProperties = true;
			}
		} else {
			if (event.getReason() == AccessEvent.DATA_CHANGE) {
				dataSetEventsEnabled = true;
			}
			if (event.getReason() == AccessEvent.UNSPECIFIED || rebindColumnProperties || event.getReason() == AccessEvent.DATA_CHANGE) {
				bindColumnProperties();
			}
		}
	}
}