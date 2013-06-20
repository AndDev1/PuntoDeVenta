package com.puntodeventa.global.Util;

import java.util.Properties;

/**
 * @author Jorge Hernandez
 */
public class ParamHelper {

    public static Object getParam(String propertyName) {
        LogHelper objLog = new LogHelper("TextHelper");
        Properties prop = new Properties();
        Object returnValue = null;
        
        try {
            
            prop.load(ClassLoader.class.getResourceAsStream("/com/puntodeventa/settings/params.properties"));
            returnValue = prop.getProperty(propertyName);

        } catch (Exception ex) {
            objLog.Log(ex.getMessage());
        }
        
        return returnValue;
    }
}
