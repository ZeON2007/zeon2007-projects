package by.pvt.herzhot.impl;

import by.pvt.herzhot.IService;
import by.pvt.herzhot.dao.IDao;
import by.pvt.herzhot.dao.impl.DaoImpl;
import by.pvt.herzhot.pojos.impl.NewsCategory;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public enum NewsCategoryServiceImpl implements IService {

    INSTANCE;

    private IDao dao;
    private NewsCategory newsCategory;

    NewsCategoryServiceImpl() {
        dao = DaoImpl.getInstance();
        newsCategory = new NewsCategory();
    }



}
