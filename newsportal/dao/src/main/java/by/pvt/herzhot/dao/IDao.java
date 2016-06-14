package by.pvt.herzhot.dao;

import by.pvt.herzhot.dao.exceptions.DaoException;

import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public interface IDao <T> {

    T find(int id) throws DaoException;
    List<T> findAll() throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean saveOrUpdate(T t) throws DaoException;
    int count() throws DaoException;
}
