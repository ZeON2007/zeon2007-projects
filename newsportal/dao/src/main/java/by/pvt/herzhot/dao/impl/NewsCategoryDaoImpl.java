package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.AbstractDao;
import by.pvt.herzhot.pojos.impl.NewsCategory;

/**
 * @author Herzhot
 * @version 1.0
 *          11.06.2016
 */
public class NewsCategoryDaoImpl extends AbstractDao<NewsCategory> {

    private static NewsCategoryDaoImpl instance;

    public static synchronized NewsCategoryDaoImpl getInstance(){
        if(instance == null){
            instance = new NewsCategoryDaoImpl();
        }
        return instance;
    }


}
