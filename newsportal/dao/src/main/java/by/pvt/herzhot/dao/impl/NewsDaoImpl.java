package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.AbstractDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          11.06.2016
 */
public class NewsDaoImpl extends AbstractDao<News> {

    private static NewsDaoImpl instance;

    public static synchronized NewsDaoImpl getInstance(){
        if(instance == null){
            instance = new NewsDaoImpl();
        }
        return instance;
    }

    public List<News> getNewsByLogin(String login) throws DaoException {
        List<News> newses;
        try {
            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            Criteria authorCriteria = newsCriteria.createCriteria("author");
            authorCriteria.add(Restrictions.eq("email", login));
            newses = (List<News>) newsCriteria.list();
        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return newses;
    }
    public List<News> getNewsInCategory(int id) throws DaoException {
        List<News> newses;
        try {
            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            Criteria categoryCriteria = newsCriteria.createCriteria("newsCategory");
            categoryCriteria.add(Restrictions.eq("id", id));
            newses = (List<News>) newsCriteria.list();
        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return newses;
    }
    public List<News> getNewsInCategoryByLogin(int id, String login) throws DaoException {
        List<News> newses;
        try {
            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            Criteria categoryCriteria = newsCriteria.createCriteria("newsCategory");
            categoryCriteria.add(Restrictions.eq("id", id));
            Criteria authorCriteria = newsCriteria.createCriteria("author");
            authorCriteria.add(Restrictions.eq("email", login));
            newses = (List<News>) newsCriteria.list();
        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return newses;
    }
}
