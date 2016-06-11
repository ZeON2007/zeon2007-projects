package by.pvt.herzhot.dao;

import by.pvt.herzhot.beans.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          08.05.2016
 */
public interface IDao <T extends Entity> {

    List<T> getAll() throws SQLException;
    int createEntity(T entity) throws SQLException;
    int getNextId() throws SQLException;
    T getEntityById(int id) throws SQLException;
    int deleteEntity(int id) throws SQLException;

}
