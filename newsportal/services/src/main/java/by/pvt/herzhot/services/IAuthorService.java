package by.pvt.herzhot.services;

import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.pojos.impl.Author;

/**
 * @author Herzhot
 * @version 1.0
 *          03.07.2016
 */
public interface IAuthorService extends IService<Author> {

    boolean checkAuthentication(String login, String password) throws ServiceException;
    Author find(String login) throws ServiceException;

}
