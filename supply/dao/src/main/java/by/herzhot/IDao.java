package by.herzhot;


import by.herzhot.exceptions.DaoException;

import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */

public interface IDao<T> {

    void create(T t) throws DaoException;
    T read(Long id) throws DaoException;
    void update(T t) throws DaoException;
    void delete(Long id) throws DaoException;
    List<T> readAll() throws DaoException;
    Long count() throws DaoException;

}
