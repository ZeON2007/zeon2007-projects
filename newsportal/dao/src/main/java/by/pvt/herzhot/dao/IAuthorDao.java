package by.pvt.herzhot.dao;

import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.pojos.impl.Author;

/**
 * @author Herzhot
 * @version 1.0
 *          03.07.2016
 */
public interface IAuthorDao extends IDao<Author> {

    boolean checkAuthentication(String login, String password) throws DaoException;
    Author getAuthorByLogin(String login) throws DaoException;
}
