package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.AbstractDao;
import by.pvt.herzhot.dao.INewsCategoryDao;
import by.pvt.herzhot.pojos.impl.NewsCategory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Herzhot
 * @version 1.0
 *          11.06.2016
 */
@Repository
public class NewsCategoryDaoImpl extends AbstractDao<NewsCategory> implements INewsCategoryDao {

    @Autowired
    private NewsCategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

}
