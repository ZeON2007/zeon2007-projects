package by.pvt.herzhot.impl;

import by.pvt.herzhot.IService;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.NewsDaoImpl;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.pojos.impl.News;

import java.util.List;

import static by.pvt.herzhot.utils.HibernateUtil.*;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public enum NewsServiceImpl implements IService<News> {

    INSTANCE;

    private NewsDaoImpl dao;
    private News news;

    NewsServiceImpl() {
        dao = NewsDaoImpl.getInstance();
        news = new News();
    }

    public List<News> getNewsByLogin(String login) throws ServiceException {
        List<News> newses;
        try {
            beginTransaction();
            newses = dao.getNewsByLogin(login);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newses;
    }
    public List<News> getNewsInCategory(int id) throws ServiceException {
        List<News> newses;
        try {
            beginTransaction();
            newses = dao.getNewsInCategory(id);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newses;
    }
    public List<News> getNewsInCategoryByLogin(int id, String login) throws ServiceException {
        List<News> newses;
        try {
            beginTransaction();
            newses = dao.getNewsInCategoryByLogin(id, login);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newses;
    }

    @Override
    public News find(int id) throws ServiceException {
        return null;
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
    public boolean saveOrUpdate(News news) throws ServiceException {
        boolean result;
        try {
            beginTransaction();
            result = dao.saveOrUpdate(news);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return true;
    }
}
