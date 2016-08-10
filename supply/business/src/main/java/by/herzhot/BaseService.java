package by.herzhot;

import by.herzhot.exceptions.DaoException;
import by.herzhot.exceptions.ServiceException;

import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.08.2016
 */
public abstract class BaseService<T> implements IService<T> {

    @Override
    public void create(T t) throws ServiceException {

        try {
            getDao().create(t);
        } catch (DaoException e) {
            throw new ServiceException();
        }

    }

    @Override
    public T read(Long id) throws ServiceException {
        T entity;
        try {

            entity = getDao().read(id);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return entity;
    }

    @Override
    public void update(T t) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public List<T> readAll() throws ServiceException {
        return null;
    }

    @Override
    public Integer count() throws ServiceException {
        return null;
    }

    protected abstract IDao<T> getDao();
}
