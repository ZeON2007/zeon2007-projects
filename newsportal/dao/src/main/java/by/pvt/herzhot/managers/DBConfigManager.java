package by.pvt.herzhot.managers;

import by.pvt.herzhot.constants.DaoConstants;

import java.util.ResourceBundle;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public class DBConfigManager {

    private final ResourceBundle bundle = ResourceBundle.getBundle(DaoConstants.DATABASE_SOURCE);
    private static DBConfigManager instance;

    private DBConfigManager(){}

    public static synchronized DBConfigManager getInstance(){
        if(instance == null){
            instance = new DBConfigManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return bundle.getString(key);
    }
}
