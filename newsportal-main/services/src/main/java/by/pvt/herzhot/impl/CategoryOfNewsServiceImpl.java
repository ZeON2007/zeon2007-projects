package by.pvt.herzhot.impl;


import by.pvt.herzhot.IService;
import by.pvt.herzhot.beans.CategoryOfNews;
import by.pvt.herzhot.dao.impl.CategoryOfNewsDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public enum CategoryOfNewsServiceImpl implements IService<CategoryOfNews> {

    INSTANCE(CategoryOfNewsDaoImpl.INSTANCE);

    private CategoryOfNewsDaoImpl dao;

    CategoryOfNewsServiceImpl(CategoryOfNewsDaoImpl dao) {
        this.dao = dao;
    }

    /**
     * Get all categories from DB
     * @return
     * @throws SQLException
     */
    @Override
    public List<CategoryOfNews> getAll() throws SQLException {
        return dao.getAll();
    }

    /**
     * Get next id for added category of news from DB
     * @return
     * @throws SQLException
     */
    @Override
    public int getNextId() throws SQLException {
        return dao.getNextId();
    }

    /**
     * Get category of news from DB by id
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public CategoryOfNews getEntityById(int id) throws SQLException {
        return dao.getEntityById(id);
    }

    /**
     * Add new category of news to DB
     * @param categoryOfNews
     * @throws SQLException
     */
    @Override
    public void createEntity(CategoryOfNews categoryOfNews) throws SQLException {
        dao.createEntity(categoryOfNews);
    }

    /**
     * Delete category of news from DB by id
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteEntity(int id) throws SQLException {
        dao.deleteEntity(id);
    }
}
