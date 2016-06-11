package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.utils.LoggingUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

import static by.pvt.herzhot.utils.HibernateUtil.*;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public class DaoImpl<T> implements IDao<T> {

    private static DaoImpl instance;
    private LoggingUtil logger;

    private DaoImpl(){
        logger = LoggingUtil.INSTANCE;
    }

    public static synchronized DaoImpl getInstance(){
        if(instance == null){
            instance = new DaoImpl();
        }
        return instance;
    }

    @Override
    public T find(T t, int id) throws DaoException {
        T entity;
        try {
            entity = (T) currentSession().get(t.getClass(), id);
        } catch (HibernateException e) {
            rollbackTransaction();
            logger.logError(getClass(), "Find entity error: " + e.getMessage());
            throw new DaoException();
        }
        return entity;
    }
    @Override
    public List<T> findAll(T t) throws DaoException {
        List<T> entityList;
        try {
            entityList = (List<T>) currentSession().createCriteria(t.getClass()).list();
        } catch (HibernateException e) {
            rollbackTransaction();
            logger.logError(getClass(), "Find all entities error: " + e.getMessage());
            throw new DaoException();
        }
        return entityList;
    }
    @Override
    public boolean delete(T t, int id) throws DaoException {
        T entity;
        try {
            entity = (T) currentSession().load(t.getClass(), id);
            currentSession().delete(entity);
        } catch (HibernateException e) {
            rollbackTransaction();
            logger.logError(getClass(), "Delete entity error: " + e.getMessage());
            throw new DaoException();
        }
        return true;
    }
    @Override
    public boolean saveOrUpdate(T t) throws DaoException {
        try {
            currentSession().saveOrUpdate(t);
        } catch (HibernateException e) {
            rollbackTransaction();
            logger.logError(getClass(), "Save or update entity error: " + e.getMessage());
            throw new DaoException();
        }
        return true;
    }
}
