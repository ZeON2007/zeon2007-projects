package by.pvt.herzhot.utils;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * @author Herzhot
 * @version 1.0
 *          08.06.2016
 */
public class CustomNamingStrategy extends DefaultNamingStrategy {

    public String classToTableName(String className) {
        return "t_" + super.classToTableName(className).toLowerCase();
    }
    public String propertyToColumnName(String propName) {
        return "f_" + super.propertyToColumnName(propName).toLowerCase();
    }
    public String columnName(String columnName) {
        return columnName;
    }
    public String tableName(String tableName) {
        return tableName;
    }
}
