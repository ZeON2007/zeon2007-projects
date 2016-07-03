package by.pvt.herzhot.services.impl;

import by.pvt.herzhot.dao.INewsCategoryDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.NewsCategoryDaoImpl;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import by.pvt.herzhot.services.INewsCategoryService;
import by.pvt.herzhot.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
public class NewsCategoryServiceImpl implements INewsCategoryService {


    private INewsCategoryDao dao;

    @Autowired
    public NewsCategoryServiceImpl(INewsCategoryDao dao){
        this.dao = dao;
        System.out.println("in SERVICE (NewsCategory) constructors");
    }



    @Override
    public NewsCategory find(int id) throws ServiceException {
        NewsCategory newsCategory;
        try {

            newsCategory = dao.find(id);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return newsCategory;
    }


    @Override
    public List<NewsCategory> findAll() throws ServiceException {
        List<NewsCategory> newsCategories;
        try {

            newsCategories = dao.findAll();

        } catch (DaoException e) {

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

            dao.saveOrUpdate(newsCategory);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return true;
    }


    @Override
    public int count() throws ServiceException {
        return 0;
    }
}
