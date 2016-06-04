package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.managers.SessionFactoryManager;
import by.pvt.herzhot.pojos.Author;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

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
        T t1;
        Session session;
        Transaction transaction = null;
        try {
            session = SessionFactoryManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            t1 = (T)session.get(t.getClass(), id);
            transaction.commit();
        }
        catch (HibernateException e) {
            try {
                transaction.rollback();
            }
            catch (NullPointerException np) {
                throw new DaoException();
            }
            throw new DaoException();
        }
        return t1;
    }


    @Override
    public List<T> findAll(T t) throws DaoException {
        List<T> tList;
        Session session;
        Transaction transaction = null;
        try {
            session = SessionFactoryManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            tList = (List<T>)session.createCriteria(t.getClass()).list();
            transaction.commit();
        }
        catch (HibernateException e) {
            try {
                transaction.rollback();
            }
            catch (NullPointerException np) {
                throw new DaoException();
            }
            throw new DaoException();
        }
        return tList;
    }

    @Override
    public boolean delete(T t, int id) throws DaoException {
        T t1;
        Session session;
        Transaction transaction = null;
        try {
            session = SessionFactoryManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            t1 = (T) session.load(t.getClass(), id);
            session.delete(t1);
            transaction.commit();
        }
        catch (HibernateException e) {
            try {
                transaction.rollback();
            }
            catch (NullPointerException np) {
                throw new DaoException();
            }
            throw new DaoException();
        }
        return true;
    }

    @Override
    public boolean saveOrUpdate(T t) throws DaoException {
        Session session;
        Transaction transaction = null;
        try {
            session = SessionFactoryManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            transaction.commit();
        }
        catch (HibernateException e) {
            try {
                transaction.rollback();
            }
            catch (NullPointerException np) {
                throw new DaoException();
            }
            throw new DaoException();
        }
        return true;
    }

    @Override
    public List<Serializable> getIdentifiers(T t) throws DaoException {
        List<Serializable> identifiers = new ArrayList<>();
        List<T> tList;
        Session session;
        Transaction transaction = null;
        try {
            session = SessionFactoryManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            tList = (List<T>) session.createCriteria(t.getClass()).list();
            for (T t1 : tList) {
                identifiers.add(session.getIdentifier(t1));
            }
            transaction.commit();
        }
        catch (HibernateException e) {
            try {
                transaction.rollback();
            }
            catch (NullPointerException np) {
                throw new DaoException();
            }
            throw new DaoException();
        }
        return identifiers;
    }
}
