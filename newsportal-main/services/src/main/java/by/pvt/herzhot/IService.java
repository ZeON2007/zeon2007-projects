package by.pvt.herzhot;

import by.pvt.herzhot.beans.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          11.05.2016
 */
public interface IService <T extends Entity> {

    List<T> getAll() throws SQLException;
    int getNextId() throws SQLException;
    void createEntity(T entity) throws SQLException;
    T getEntityById(int id) throws SQLException;
    void deleteEntity(int id) throws SQLException;

}
