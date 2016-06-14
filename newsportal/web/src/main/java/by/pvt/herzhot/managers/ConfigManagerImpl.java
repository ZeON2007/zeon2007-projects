package by.pvt.herzhot.managers;

import by.pvt.herzhot.constants.ConfigConstants;

import java.util.ResourceBundle;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public enum ConfigManagerImpl {

    INSTANCE;

    private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigConstants.CONFIGS_SOURCE);

    public String getProperty(String key) {
        return bundle.getString(key);
    }
}
