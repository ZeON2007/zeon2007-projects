package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

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
            Session session = HibernateUtil.currentSession();
            HibernateUtil.beginTransaction();
            entity = (T) session.get(t.getClass(), id);
            HibernateUtil.commitTransaction();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
            throw new DaoException();
        } finally {
            HibernateUtil.closeSession();
        }
        return entity;
    }


    @Override
    public List<T> findAll(T t) throws DaoException {
        List<T> entityList;
        try {
            Session session = HibernateUtil.currentSession();
            HibernateUtil.beginTransaction();
            entityList = (List<T>) session.createCriteria(t.getClass()).list();
            HibernateUtil.commitTransaction();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
            throw new DaoException();
        } finally {
            HibernateUtil.closeSession();
        }
        return entityList;
    }

    @Override
    public boolean delete(T t, int id) throws DaoException {
        T entity;
        try {
            Session session = HibernateUtil.currentSession();
            HibernateUtil.beginTransaction();
            entity = (T) session.load(t.getClass(), id);
            session.delete(entity);
            HibernateUtil.commitTransaction();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
            throw new DaoException();
        } finally {
            HibernateUtil.closeSession();
        }
        return true;
    }

    @Override
    public boolean saveOrUpdate(T t) throws DaoException {
        try {
            Session session = HibernateUtil.currentSession();
            HibernateUtil.beginTransaction();
            session.saveOrUpdate(t);
            HibernateUtil.commitTransaction();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction();
            throw new DaoException();
        } finally {
            HibernateUtil.closeSession();
        }
        return true;
    }
}
