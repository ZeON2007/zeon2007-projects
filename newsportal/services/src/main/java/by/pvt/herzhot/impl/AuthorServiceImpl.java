package by.pvt.herzhot.impl;

import by.pvt.herzhot.IService;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.AuthorDaoImpl;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.pojos.impl.NewsCategory;

import java.util.List;

import static by.pvt.herzhot.utils.HibernateUtil.*;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public enum AuthorServiceImpl implements IService<Author> {

    INSTANCE;

    private AuthorDaoImpl dao;

    AuthorServiceImpl() {
        dao = AuthorDaoImpl.getInstance();
    }

    public boolean checkAuthentication(String login, String password) throws ServiceException {
        boolean result;
        try {
            beginTransaction();
            result = dao.checkAuthentication(login, password);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return result;
    }
    public Author find(String login) throws ServiceException {
        Author author;
        try {
            beginTransaction();
            author = dao.getAuthorByLogin(login);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return author;
    }

    @Override
    public Author find(int id) throws ServiceException {
        Author author;
        try {
            beginTransaction();
            author = dao.find(id);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return author;
    }

    @Override
    public List findAll() throws ServiceException {
        return null;
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Author author) throws ServiceException {
        return false;
    }
}
