package by.pvt.herzhot.managers.impl;

import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.managers.Manager;

import java.util.ResourceBundle;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public enum MessageManagerImpl implements Manager {

    INSTANCE;

    private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigConstants.MESSAGES_SOURCE);


    @Override
    public String getProperty(String key) {
        return bundle.getString(key);
    }
}
