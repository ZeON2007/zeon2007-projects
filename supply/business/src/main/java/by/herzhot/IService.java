package by.herzhot;

import by.herzhot.exceptions.ServiceException;

import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          03.08.2016
 */

public interface IService<T> {

    void create(T t) throws ServiceException;
    T read(Long id) throws ServiceException;
    void update(T t) throws ServiceException;
    void delete(Long id) throws ServiceException;
    List<T> readAll() throws ServiceException;
    Long count() throws ServiceException;
}
