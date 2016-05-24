package by.pvt.herzhot.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Herzhot
 * @version 1.0
 *          24.05.2016
 */
public class ClosingUtil {

    private ClosingUtil(){}

    public static void close(PreparedStatement statement){
        if(statement != null){
            try{
                statement.close();
            }
            catch(SQLException e){
                DaoLogger.INSTANCE.logError(ClosingUtil.class, e.getMessage());
            }
        }
    }

    public static void close(ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            }
            catch(SQLException e){
                DaoLogger.INSTANCE.logError(ClosingUtil.class, e.getMessage());
            }
        }
    }

}
