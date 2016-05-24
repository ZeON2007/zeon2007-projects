package by.pvt.herzhot.managers;

import by.pvt.herzhot.constants.DaoConstants;
import by.pvt.herzhot.utils.DaoLogger;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public enum ConnectionsPoolManager {

    INSTANCE;

    private BasicDataSource dataSource = null;
    private DBConfigManager dbConfigManager = null;

    ConnectionsPoolManager() {
        dbConfigManager = DBConfigManager.getInstance();
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbConfigManager.getProperty(DaoConstants.DATABASE_DRIVER));
        dataSource.setUsername(dbConfigManager.getProperty(DaoConstants.DATABASE_USER));
        dataSource.setPassword(dbConfigManager.getProperty(DaoConstants.DATABASE_PASSWORD));
        dataSource.setUrl(dbConfigManager.getProperty(DaoConstants.DATABASE_URL));
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        }
        catch (SQLException e) {
            DaoLogger.INSTANCE.logError(getClass(), e.getMessage());
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        }
        catch (SQLException e) {
            DaoLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
    }
}
