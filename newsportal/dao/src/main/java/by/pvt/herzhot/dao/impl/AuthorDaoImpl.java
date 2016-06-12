package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.AbstractDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Herzhot
 * @version 1.0
 *          11.06.2016
 */
public class AuthorDaoImpl extends AbstractDao<Author> {

    private static AuthorDaoImpl instance;

    public static synchronized AuthorDaoImpl getInstance(){
        if(instance == null){
            instance = new AuthorDaoImpl();
        }
        return instance;
    }

    public boolean checkAuthentication(String login, String password) throws DaoException {
        boolean result;
        try {
            Session session = HibernateUtil.currentSession();
            Criteria criteria = session.createCriteria(Author.class);
            criteria.add(Restrictions.eq("email", login));
            criteria.add(Restrictions.eq("password", password));
            result = !criteria.list().isEmpty();
        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return result;
    }
    public Author getAuthorByLogin(String login) throws DaoException {
        Author author;
        try {
            Session session = HibernateUtil.currentSession();
            Criteria criteria = session.createCriteria(Author.class);
            criteria.add(Restrictions.eq("email", login));
            author = (Author) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return author;
    }


}
