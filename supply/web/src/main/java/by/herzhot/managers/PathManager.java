package by.herzhot.managers;

import by.herzhot.constants.Configs;

import java.util.ResourceBundle;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public enum PathManager {

    INSTANCE;

    private final ResourceBundle bundle = ResourceBundle.getBundle(Configs.PATH_SOURCE);


    public String getProperty(String key) {
        return bundle.getString(key);
    }
}
