package by.herzhot;

import by.herzhot.exceptions.DaoException;
import by.herzhot.exceptions.ServiceException;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          09.08.2016
 */
public abstract class BaseService<T> implements IService<T> {

    @Resource
    protected SessionContext sessionContext;

    @Override
    public void create(T t) throws ServiceException {
        try {
            getDao().create(t);
        } catch (DaoException e) {
            sessionContext.setRollbackOnly();
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
        try {
            getDao().update(t);
        } catch (DaoException e) {
            sessionContext.setRollbackOnly();
            throw new ServiceException();
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {

        try {
            getDao().delete(id);
        } catch (DaoException e) {
            sessionContext.setRollbackOnly();
            throw new ServiceException();
        }
    }

    @Override
    public List<T> readAll() throws ServiceException {
        List<T> entityList;
        try {
            entityList = getDao().readAll();
        } catch (DaoException e) {
            throw new ServiceException();
        }
        return entityList;
    }

    @Override
    public Long count() throws ServiceException {
        Long count;
        try {
           count = getDao().count();
        } catch (DaoException e) {
            throw new ServiceException();
        }
        return count;
    }

    protected abstract IDao<T> getDao();
}
