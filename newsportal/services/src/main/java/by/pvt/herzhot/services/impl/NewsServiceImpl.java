package by.pvt.herzhot.services.impl;

import by.pvt.herzhot.dao.INewsDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.NewsDaoImpl;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.services.INewsService;
import by.pvt.herzhot.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
public class NewsServiceImpl implements INewsService {


    private INewsDao dao;

    @Autowired
    public NewsServiceImpl(INewsDao dao){
        this.dao = dao;
    }

    @Override
    public List<News> getNewsByLogin(String login,
                Map<String, Integer> paginationParams) throws ServiceException {
        List<News> newses;
        try {
            newses = dao.getNewsByLogin(login, paginationParams);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return newses;
    }
    @Override
    public int countNewsByLogin(String login) throws ServiceException {
        int count;
        try {

            count = dao.countNewsByLogin(login);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return count;
    }

    @Override
    public List<News> getNewsInCategory(int id,
                Map<String, Integer> paginationParams) throws ServiceException {
        List<News> newses;
        try {

            newses = dao.getNewsInCategory(id, paginationParams);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return newses;
    }
    @Override
    public int countNewsInCategory(int id) throws ServiceException {
        int count;
        try {

            count = dao.countNewsInCategory(id);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return count;
    }

    @Override
    public List<News> getNewsInCategoryByLogin(int id, String login,
                Map<String, Integer> paginationParams) throws ServiceException {
        List<News> newses;
        try {

            newses = dao.getNewsInCategoryByLogin(id, login, paginationParams);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return newses;
    }
    @Override
    public int countNewsInCategoryByLogin(int id, String login) throws ServiceException {
        int count;
        try {

            count = dao.countNewsInCategoryByLogin(id, login);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return count;
    }

    @Override
    public News find(int id) throws ServiceException {
        News news;
        try {

            news = dao.find(id);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return news;
    }

    @Override
    public int count() throws ServiceException {
        int count;
        try {

            count = dao.count();

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return count;
    }


    @Override
    public List<News> findAll() throws ServiceException {
        List<News> newses;
        try {

            newses = dao.findAll();

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return newses;
    }
    @Override
    public List<News> findAll(Map<String, Integer> paginationParams) throws ServiceException {
        List<News> newses;
        try {

            newses = dao.findAll(paginationParams);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return newses;
    }


    @Override
    public boolean delete(int id) throws ServiceException {
        boolean result;
        try {

            result = dao.delete(id);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return result;
    }


    @Override
    public boolean saveOrUpdate(News news) throws ServiceException {
        boolean result;
        try {

            result = dao.saveOrUpdate(news);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return result;
    }

    public INewsDao getDao() {
        return dao;
    }

    public void setDao(INewsDao dao) {
        this.dao = dao;
    }
}
