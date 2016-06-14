package by.pvt.herzhot.impl;

import by.pvt.herzhot.IService;
import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.AbstractDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.NewsCategoryDaoImpl;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.pojos.impl.NewsCategory;

import java.util.List;

import static by.pvt.herzhot.utils.HibernateUtil.beginTransaction;
import static by.pvt.herzhot.utils.HibernateUtil.commitTransaction;
import static by.pvt.herzhot.utils.HibernateUtil.rollbackTransaction;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public enum NewsCategoryServiceImpl implements IService<NewsCategory> {

    INSTANCE;

    private NewsCategoryDaoImpl dao;

    NewsCategoryServiceImpl() {
        dao = NewsCategoryDaoImpl.getInstance();
    }

    @Override
    public NewsCategory find(int id) throws ServiceException {
        NewsCategory newsCategory;
        try {
            beginTransaction();
            newsCategory = dao.find(id);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newsCategory;
    }


    @Override
    public List<NewsCategory> findAll() throws ServiceException {
        List<NewsCategory> newsCategories;
        try {
            beginTransaction();
            newsCategories = dao.findAll();
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return newsCategories;
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        return false;
    }

    @Override
    public boolean saveOrUpdate(NewsCategory newsCategory) throws ServiceException {
        try {
            beginTransaction();
            dao.saveOrUpdate(newsCategory);
            commitTransaction();
        } catch (DaoException e) {
            rollbackTransaction();
            throw new ServiceException();
        }
        return true;
    }

    @Override
    public int count() throws ServiceException {
        return 0;
    }
}
