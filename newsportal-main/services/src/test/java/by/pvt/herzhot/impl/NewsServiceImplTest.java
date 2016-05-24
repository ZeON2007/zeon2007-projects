package by.pvt.herzhot.impl;

import by.pvt.herzhot.beans.News;
import by.pvt.herzhot.dao.impl.NewsDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Herzhot
 * @version 1.0
 *          24.05.2016
 */
public class NewsServiceImplTest {

    private NewsDaoImpl dao;
    private List<News> expectedNewsList;
    private News expectedNews;
    private News actualNews;
    private int currentId;

    @Before
    public void setUp() throws Exception {
        dao = NewsDaoImpl.INSTANCE;
    }

    @After
    public void tearDown() throws Exception {
        expectedNewsList = null;
        expectedNews = null;
        actualNews = null;
        dao = null;
    }

    @Test
    public void getReceivedIdForAddedNews() throws Exception {
        currentId = dao.getNextId();

        assertEquals(currentId, dao.getNextId());
    }

    @Test
    public void createNews() throws Exception {
        currentId = dao.getNextId();
        expectedNews = new News(currentId, 0, 0 , "2050-01-01 00:00:00.0", "Test", "Test", "Test");
        dao.createEntity(expectedNews);
        actualNews = dao.getEntityById(currentId);
        dao.deleteEntity(currentId);

        assertEquals(expectedNews, actualNews);
    }

    @Test
    public void getAllNewsFromDB() throws Exception {
        currentId = dao.getNextId();
        expectedNews = new News(currentId, 0, 0 , "2050-01-01 00:00:00.0", "Test", "Test", "Test");
        dao.createEntity(expectedNews);
        expectedNewsList = dao.getAll();
        dao.deleteEntity(currentId);

        assertFalse(expectedNewsList.isEmpty());
    }

    @Test
    public void getAllNewsInCategoryFromDB() throws Exception {
        currentId = dao.getNextId();
        expectedNews = new News(currentId, 0, 0 , "2050-01-01 00:00:00.0", "Test", "Test", "Test");
        dao.createEntity(expectedNews);
        int categoryId = expectedNews.getCategoryId();
        expectedNewsList = dao.getNewsInCategory(categoryId);
        dao.deleteEntity(currentId);

        assertFalse(expectedNewsList.isEmpty());
    }
}