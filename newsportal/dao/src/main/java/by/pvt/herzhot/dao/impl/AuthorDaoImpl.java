package by.pvt.herzhot.dao.impl;

import by.pvt.herzhot.dao.AbstractDao;
import by.pvt.herzhot.dao.IAuthorDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.pojos.impl.Author;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Herzhot
 * @version 1.0
 *          11.06.2016
 */
@Repository
public class AuthorDaoImpl extends AbstractDao<Author> implements IAuthorDao {

    @Autowired
    private AuthorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println("in DAO (Author) constructors");
    }

    @Override
    public boolean checkAuthentication(String login, String password) throws DaoException {
        boolean result;
        try {
            Session session = currentSession();
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
    @Override
    public Author getAuthorByLogin(String login) throws DaoException {
        Author author;
        try {
            Session session = currentSession();
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
