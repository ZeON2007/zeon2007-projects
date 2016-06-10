package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
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

    private DaoImpl(){}

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
            Session session = currentSession();
            beginTransaction();
            entity = (T) session.get(t.getClass(), id);
            commitTransaction();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new DaoException();
        } finally {
            closeSession();
        }
        return entity;
    }
    @Override
    public List<T> findAll(T t) throws DaoException {
        List<T> entityList;
        try {
            Session session = currentSession();
            beginTransaction();
            entityList = (List<T>) session.createCriteria(t.getClass()).list();
            commitTransaction();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new DaoException();
        } finally {
            closeSession();
        }
        return entityList;
    }
    @Override
    public boolean delete(T t, int id) throws DaoException {
        T entity;
        try {
            Session session = currentSession();
            beginTransaction();
            entity = (T) session.load(t.getClass(), id);
            session.delete(entity);
            commitTransaction();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new DaoException();
        } finally {
            closeSession();
        }
        return true;
    }
    @Override
    public boolean saveOrUpdate(T t) throws DaoException {
        try {
            Session session = currentSession();
            beginTransaction();
            session.saveOrUpdate(t);
            commitTransaction();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new DaoException();
        } finally {
            closeSession();
        }
        return true;
    }
}
