package by.pvt.herzhot.impl;

import by.pvt.herzhot.IService;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.NewsDaoImpl;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.pojos.impl.News;

import java.util.List;
import java.util.Map;

import static by.pvt.herzhot.utils.HibernateUtil.*;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public enum NewsServiceImpl implements IService<News> {

    INSTANCE;

    private NewsDaoImpl dao;

    NewsServiceImpl() {
        dao = NewsDaoImpl.getInstance();
    }

    public List<News> getNewsByLogin(String login,
                Map<String, Integer> paginationParams) throws ServiceException {
        List<News> newses;
        try {
            beginTransaction();
            newses = dao.getNewsByLogin(login, paginationParams);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newses;
    }
    public int countNewsByLogin(String login) throws ServiceException {
        int count;
        try {
            beginTransaction();
            count = dao.countNewsByLogin(login);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return count;
    }

    public List<News> getNewsInCategory(int id,
                Map<String, Integer> paginationParams) throws ServiceException {
        List<News> newses;
        try {
            beginTransaction();
            newses = dao.getNewsInCategory(id, paginationParams);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newses;
    }
    public int countNewsInCategory(int id) throws ServiceException {
        int count;
        try {
            beginTransaction();
            count = dao.countNewsInCategory(id);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return count;
    }

    public List<News> getNewsInCategoryByLogin(int id, String login,
                Map<String, Integer> paginationParams) throws ServiceException {
        List<News> newses;
        try {
            beginTransaction();
            newses = dao.getNewsInCategoryByLogin(id, login, paginationParams);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newses;
    }
    public int countNewsInCategoryByLogin(int id, String login) throws ServiceException {
        int count;
        try {
            beginTransaction();
            count = dao.countNewsInCategoryByLogin(id, login);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return count;
    }

    @Override
    public News find(int id) throws ServiceException {
        News news;
        try {
            beginTransaction();
            news = dao.find(id);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return news;
    }
    @Override
    public int count() throws ServiceException {
        int count;
        try {
            beginTransaction();
            count = dao.count();
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return count;
    }

    @Override
    public List<News> findAll() throws ServiceException {
        List<News> newses;
        try {
            beginTransaction();
            newses = dao.findAll();
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newses;
    }

    public List<News> findAll(Map<String, Integer> paginationParams) throws ServiceException {
        List<News> newses;
        try {
            beginTransaction();
            newses = dao.findAll(paginationParams);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newses;
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        boolean result;
        try {
            beginTransaction();
            result = dao.delete(id);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return result;
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
        return result;
    }
}
