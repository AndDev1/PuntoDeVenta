/*
 * @(#)JdbDateFieldBeanInfo.java
 *
 * Copyright (c) 2003-2006 Stand By Soft, Ltd. All rights reserved.
 *
 * This software is the proprietary information of Stand By Soft, Ltd.  
 * Use is subject to license terms.
 */
package com.standbysoft.component.date.swing.dbswing;

import java.awt.Image;
import java.beans.*;

import com.borland.jbuilder.cmt.editors.ColumnNameEditor;

/**
 * BeanInfo information used by introspection tools.
 */
public class JdbDateFieldBeanInfo extends SimpleBeanInfo {
	private Image icon;

	private Image iconSmall;
	
	private Class beanClass = JdbDateField.class;

	public JdbDateFieldBeanInfo() {
		icon = loadImage("JdbDateField.gif");
		iconSmall = loadImage("JdbDateField16.gif");
	}

	public Image getIcon(int iconKind) {
		if (iconKind == ICON_COLOR_16x16 || iconKind == ICON_MONO_16x16) {
			return iconSmall;
		} else {
			return icon;
		}
	}

	/**
	 * Returns the BeanInfo of the superclass of this bean to inherit its
	 * features.
	 * 
	 * @return java.beans.BeanInfo[]
	 */
	public BeanInfo[] getAdditionalBeanInfo() {
		Class superClass;
		BeanInfo superBeanInfo = null;

		try {
			superClass = getBeanDescriptor().getBeanClass().getSuperclass();
		} catch (Throwable exception) {
			return null;
		}

		try {
			superBeanInfo = Introspector.getBeanInfo(superClass);
		} catch (IntrospectionException ie) {
		}

		if (superBeanInfo != null) {
			BeanInfo[] ret = new BeanInfo[1];
			ret[0] = superBeanInfo;
			return ret;
		}
		return null;
	}

	public BeanDescriptor getBeanDescriptor() {
		BeanDescriptor bd = new BeanDescriptor(beanClass);

		bd.setName("JdbDateField");
		bd.setShortDescription("Date field for entering date/time information.");
		bd.setPreferred(true);
		bd.setValue("isContainer", Boolean.FALSE);

		return bd;
	}

	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			PropertyDescriptor columnNamePD = new PropertyDescriptor("columnName", beanClass);
			columnNamePD.setPropertyEditorClass(ColumnNameEditor.class);
			PropertyDescriptor dataSetPD = new PropertyDescriptor("dataSet", beanClass);

			PropertyDescriptor rv[] = { columnNamePD, dataSetPD };
			return rv;
		} catch (IntrospectionException e) {
			throw new Error(e.toString());
		}
	}
}