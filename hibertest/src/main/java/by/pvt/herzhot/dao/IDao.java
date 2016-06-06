package by.pvt.herzhot.dao;

import by.pvt.herzhot.dao.exceptions.DaoException;

import java.io.Serializable;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public interface IDao <T> {

    T find(T t, int id) throws DaoException;
    List<T> findAll(T t) throws DaoException;
    boolean delete(T t, int id) throws DaoException;
    boolean saveOrUpdate(T t) throws DaoException;
}
