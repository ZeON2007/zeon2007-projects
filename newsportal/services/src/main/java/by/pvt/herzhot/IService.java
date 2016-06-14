package by.pvt.herzhot;

import by.pvt.herzhot.exceptions.ServiceException;

import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          11.05.2016
 */
public interface IService<T> {

    T find(int id) throws ServiceException;
    List<T> findAll() throws ServiceException;
    boolean delete(int id) throws ServiceException;
    boolean saveOrUpdate(T t) throws ServiceException;
    int count() throws ServiceException;

}
