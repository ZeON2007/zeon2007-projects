package by.pvt.herzhot.impl;

import by.pvt.herzhot.IService;
import by.pvt.herzhot.beans.Author;
import by.pvt.herzhot.dao.impl.AuthorDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public enum AuthorServiceImpl implements IService<Author> {

    INSTANCE(AuthorDaoImpl.INSTANCE);

    private AuthorDaoImpl dao;

    AuthorServiceImpl(AuthorDaoImpl dao) {
      this.dao = dao;
    }

    /**
     * Get all authors from DB
     * @return
     * @throws SQLException
     */
    @Override
    public List<Author> getAll() throws SQLException {
        return dao.getAll();
    }

    /**
     * Get next id for added author from DB
     * @return
     * @throws SQLException
     */
    @Override
    public int getNextId() throws SQLException {
        return dao.getNextId();
    }

    /**
     * Get author from DB by id
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Author getEntityById(int id) throws SQLException {
        return dao.getEntityById(id);
    }

    /**
     * Get author from DB by login
     * @param login
     * @return
     * @throws SQLException
     */
    public Author getAuthorByLogin(String login) throws SQLException {
        return dao.getAuthorByLogin(login);
    }

    /**
     * Add new author to DB
     * @param author
     * @throws SQLException
     */
    @Override
    public void createEntity(Author author) throws SQLException {
        dao.createEntity(author);
    }

    /**
     * Delete author from DB by id
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteEntity(int id) throws SQLException {
        dao.deleteEntity(id);
    }

    /**
     * Check when user is authorized
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    public boolean isAuthorized(String login, String password) throws SQLException {
        return dao.isAuthorized(login, password);
    }
}
