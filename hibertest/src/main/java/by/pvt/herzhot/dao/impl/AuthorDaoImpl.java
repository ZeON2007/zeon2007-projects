package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.managers.SessionFactoryManager;
import by.pvt.herzhot.pojos.Author;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          30.05.2016
 */
public enum AuthorDaoImpl implements IDao <Author> {

    INSTANCE;


    public Author find(int id) throws DaoException {
        Author author;
        Session session;
        Transaction transaction = null;
        try {
            session = SessionFactoryManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            author = (Author) session.get(Author.class, id);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw new DaoException();
        }
        return author;
    }

    public List<Author> findAll() throws DaoException {
        List<Author> authors;
        Session session;
        Transaction transaction = null;
        try {
            session = SessionFactoryManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            authors = (List<Author>) session.createCriteria(Author.class).list();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw new DaoException();
        }
        return authors;
    }

    public boolean delete(int id) throws DaoException {
        Author author;
        Session session;
        Transaction transaction = null;
        try {
            session = SessionFactoryManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            author = (Author) session.get(Author.class, id);
            session.delete(author);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw new DaoException();
        }
        return true;
    }

    public boolean saveOrUpdate(Author author) throws DaoException {
        Session session;
        Transaction transaction = null;
        try {
            session = SessionFactoryManager.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(author);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw new DaoException();
        }
        return true;
    }
}
