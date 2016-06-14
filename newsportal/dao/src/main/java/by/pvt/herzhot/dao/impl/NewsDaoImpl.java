package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.AbstractDao;
import by.pvt.herzhot.dao.constants.CriteriaParams;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.pojos.impl.News;
import by.pvt.herzhot.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;

import static by.pvt.herzhot.utils.HibernateUtil.currentSession;

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

    public List<News> findAll(Map<String, Integer> paginationParams) throws DaoException {
        List<News> newses;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            newsCriteria.setFirstResult( (selected - 1)*quantity );
            newsCriteria.setMaxResults( quantity );
            newses = (List<News>) newsCriteria.list();

        } catch (HibernateException e) {
            logger.logError(getClass(), "Find all entities error: " + e.getMessage());
            throw new DaoException();
        }
        return newses;
    }

    public List<News> getNewsByLogin(String login,
                Map<String, Integer> paginationParams) throws DaoException {
        List<News> newses;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            Criteria authorCriteria = newsCriteria.createCriteria("author");
            authorCriteria.add(Restrictions.eq("email", login));
            newsCriteria.setFirstResult( (selected - 1)*quantity );
            newsCriteria.setMaxResults( quantity );
            newses = (List<News>) newsCriteria.list();

        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return newses;
    }
    public int countNewsByLogin(String login) throws DaoException {
        int count;
        try {
            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            Criteria authorCriteria = newsCriteria.createCriteria("author");
            authorCriteria.add(Restrictions.eq("email", login));
            newsCriteria.setProjection(Projections.rowCount());
            count = (int)(long) newsCriteria.uniqueResult();
        } catch (HibernateException e) {
            logger.logError(getClass(), "Entities counting error: " + e.getMessage());
            throw new DaoException();
        }
        return count;
    }

    public List<News> getNewsInCategory(int id,
                Map<String, Integer> paginationParams) throws DaoException {
        List<News> newses;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            Criteria categoryCriteria = newsCriteria.createCriteria("newsCategory");
            categoryCriteria.add(Restrictions.eq("id", id));
            newsCriteria.setFirstResult( (selected - 1)*quantity );
            newsCriteria.setMaxResults( quantity );
            newses = (List<News>) newsCriteria.list();

        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return newses;
    }
    public int countNewsInCategory(int id) throws DaoException {
        int count;
        try {
            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            Criteria categoryCriteria = newsCriteria.createCriteria("newsCategory");
            categoryCriteria.add(Restrictions.eq("id", id));
            newsCriteria.setProjection(Projections.rowCount());
            count = (int)(long) newsCriteria.uniqueResult();
        } catch (HibernateException e) {
            logger.logError(getClass(), "Entities counting error: " + e.getMessage());
            throw new DaoException();
        }
        return count;
    }

    public List<News> getNewsInCategoryByLogin(int id, String login,
                Map<String, Integer> paginationParams) throws DaoException {
        List<News> newses;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            Criteria categoryCriteria = newsCriteria.createCriteria("newsCategory");
            categoryCriteria.add(Restrictions.eq("id", id));
            Criteria authorCriteria = newsCriteria.createCriteria("author");
            authorCriteria.add(Restrictions.eq("email", login));
            newsCriteria.setFirstResult( (selected - 1)*quantity );
            newsCriteria.setMaxResults( quantity );
            newses = (List<News>) newsCriteria.list();
        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return newses;
    }
    public int countNewsInCategoryByLogin(int id, String login) throws DaoException {
        int count;
        try {
            Session session = HibernateUtil.currentSession();
            Criteria newsCriteria = session.createCriteria(News.class);
            Criteria categoryCriteria = newsCriteria.createCriteria("newsCategory");
            categoryCriteria.add(Restrictions.eq("id", id));
            Criteria authorCriteria = newsCriteria.createCriteria("author");
            authorCriteria.add(Restrictions.eq("email", login));
            newsCriteria.setProjection(Projections.rowCount());
            count = (int)(long) newsCriteria.uniqueResult();
        } catch (HibernateException e) {
            logger.logError(getClass(), "Entities counting error: " + e.getMessage());
            throw new DaoException();
        }
        return count;
    }
}
