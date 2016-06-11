package by.pvt.herzhot.impl;

import by.pvt.herzhot.IService;
import by.pvt.herzhot.beans.News;
import by.pvt.herzhot.dao.impl.NewsDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public enum NewsServiceImpl implements IService<News> {

    INSTANCE(NewsDaoImpl.INSTANCE);

    private NewsDaoImpl dao;

    NewsServiceImpl(NewsDaoImpl dao) {
        this.dao = dao;
    }

    /**
     * Get all news from DB
     * @return
     * @throws SQLException
     */
    @Override
    public List<News> getAll() throws SQLException {
        return dao.getAll();
    }

    /**
     * Get next id for added news from DB
     * @return
     * @throws SQLException
     */
    @Override
    public int getNextId() throws SQLException {
        return dao.getNextId();
    }

    /**
     * Get news from DB by id
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public News getEntityById(int id) throws SQLException {
        return dao.getEntityById(id);
    }

    /**
     * Get news from DB by login of author
     * @param login
     * @return
     * @throws SQLException
     */
    public List<News> getNewsByLogin(String login) throws SQLException {
        return dao.getNewsByLogin(login);
    }

    /**
     * Get news from DB by category
     * @param id
     * @return
     * @throws SQLException
     */
    public List<News> getNewsInCategory(int id) throws SQLException {
        return dao.getNewsInCategory(id);
    }

    /**
     * Get news from DB by category and login
     * @param id
     * @param login
     * @return
     * @throws SQLException
     */
    public List<News> getNewsInCategoryByLogin(int id, String login) throws SQLException {
        return dao.getNewsInCategoryByLogin(id, login);
    }

    /**
     * Add new news to DB
     * @param news
     * @throws SQLException
     */
    @Override
    public void createEntity(News news) throws SQLException {
        dao.createEntity(news);
    }

    /**
     * Delete news from DB by id
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteEntity(int id) throws SQLException {
        dao.deleteEntity(id);
    }

}
