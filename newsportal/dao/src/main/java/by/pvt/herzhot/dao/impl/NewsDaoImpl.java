package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.AbstractDao;
import by.pvt.herzhot.dao.INewsDao;
import by.pvt.herzhot.dao.constants.CriteriaParams;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.pojos.impl.News;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Herzhot
 * @version 1.0
 *          11.06.2016
 */
@Repository
public class NewsDaoImpl extends AbstractDao<News> implements INewsDao {

    @Autowired
    private NewsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println("in DAO (News) constructors");
    }

    @Override
    public List<News> findAll(Map<String, Integer> paginationParams) throws DaoException {
        List<News> newses;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = currentSession();
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

    @Override
    public List<News> getNewsByLogin(String login,
                Map<String, Integer> paginationParams) throws DaoException {
        List<News> newses;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = currentSession();
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
    @Override
    public int countNewsByLogin(String login) throws DaoException {
        int count;
        try {
            Session session = currentSession();
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

    @Override
    public List<News> getNewsInCategory(int id,
                Map<String, Integer> paginationParams) throws DaoException {
        List<News> newses;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = currentSession();
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
    @Override
    public int countNewsInCategory(int id) throws DaoException {
        int count;
        try {
            Session session = currentSession();
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

    @Override
    public List<News> getNewsInCategoryByLogin(int id, String login,
                Map<String, Integer> paginationParams) throws DaoException {
        List<News> newses;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = currentSession();
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
    @Override
    public int countNewsInCategoryByLogin(int id, String login) throws DaoException {
        int count;
        try {
            Session session = currentSession();
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
