package by.pvt.herzhot.services.impl;

import by.pvt.herzhot.dao.IAuthorDao;
import by.pvt.herzhot.dao.exceptions.DaoException;
import by.pvt.herzhot.dao.impl.AuthorDaoImpl;
import by.pvt.herzhot.exceptions.ServiceException;
import by.pvt.herzhot.pojos.impl.Author;
import by.pvt.herzhot.services.IAuthorService;
import by.pvt.herzhot.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
public class AuthorServiceImpl implements IAuthorService {


    private IAuthorDao dao;

    @Autowired
    public AuthorServiceImpl(IAuthorDao dao){
        this.dao = dao;
        System.out.println("in SERVICE (Author) constructors");
    }

    @Override
    public boolean checkAuthentication(String login, String password) throws ServiceException {
        boolean result;
        try {

            result = dao.checkAuthentication(login, password);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return result;
    }
    @Override
    public Author find(String login) throws ServiceException {
        Author author;
        try {

            author = dao.getAuthorByLogin(login);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return author;
    }


    @Override
    public Author find(int id) throws ServiceException {
        Author author;
        try {

            author = dao.find(id);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return author;
    }


    @Override
    public List findAll() throws ServiceException {
        return null;
    }


    @Override
    public boolean delete(int id) throws ServiceException {
        return false;
    }


    @Override
    public boolean saveOrUpdate(Author author) throws ServiceException {
        try {

            dao.saveOrUpdate(author);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return true;
    }


    @Override
    public int count() throws ServiceException {
        return 0;
    }
}
