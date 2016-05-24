package by.pvt.herzhot.dao;

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
 *          18.05.2016
 */
public class NewsDaoImplTest {

    private List<News> expectedNewsList;
    private News expectedNews;
    private News actualNews;
    private int currentId;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {
        expectedNewsList = null;
        expectedNews = null;
        actualNews = null;
        currentId = 0;
    }

    @Test
    public void getReceivedIdForAddedNews() throws Exception {
        currentId = NewsDaoImpl.INSTANCE.getNextId();

        assertEquals(currentId, NewsDaoImpl.INSTANCE.getNextId());
    }

    @Test
    public void createNews() throws Exception {
        currentId = NewsDaoImpl.INSTANCE.getNextId();
        expectedNews = new News(currentId, 0, 0 , "2050-01-01 00:00:00.0", "Test", "Test", "Test");
        NewsDaoImpl.INSTANCE.createEntity(expectedNews);
        actualNews = NewsDaoImpl.INSTANCE.getEntityById(currentId);
        NewsDaoImpl.INSTANCE.deleteEntity(currentId);

        assertEquals(expectedNews, actualNews);
    }

    @Test
    public void getAllNewsFromDB() throws Exception {
        currentId = NewsDaoImpl.INSTANCE.getNextId();
        expectedNews = new News(currentId, 0, 0 , "2050-01-01 00:00:00.0", "Test", "Test", "Test");
        NewsDaoImpl.INSTANCE.createEntity(expectedNews);
        expectedNewsList = NewsDaoImpl.INSTANCE.getAll();
        NewsDaoImpl.INSTANCE.deleteEntity(currentId);

        assertFalse(expectedNewsList.isEmpty());
    }

    @Test
    public void getAllNewsInCategoryFromDB() throws Exception {
        currentId = NewsDaoImpl.INSTANCE.getNextId();
        expectedNews = new News(currentId, 0, 0 , "2050-01-01 00:00:00.0", "Test", "Test", "Test");
        NewsDaoImpl.INSTANCE.createEntity(expectedNews);
        int categoryId = expectedNews.getCategoryId();
        expectedNewsList = NewsDaoImpl.INSTANCE.getNewsInCategory(categoryId);
        NewsDaoImpl.INSTANCE.deleteEntity(currentId);

        assertFalse(expectedNewsList.isEmpty());
    }
}