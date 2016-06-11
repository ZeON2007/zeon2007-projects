package by.pvt.herzhot.impl;

import by.pvt.herzhot.beans.CategoryOfNews;
import by.pvt.herzhot.dao.impl.CategoryOfNewsDaoImpl;
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
public class CategoryOfNewsServiceImplTest {

    private CategoryOfNewsDaoImpl dao;
    private List<CategoryOfNews> expectedCategoryList;
    private CategoryOfNews expectedCategory;
    private CategoryOfNews actualCategory;
    private int currentId;

    @Before
    public void setUp() throws Exception {
        dao = CategoryOfNewsDaoImpl.INSTANCE;
    }

    @After
    public void tearDown() throws Exception {
        expectedCategoryList = null;
        expectedCategory = null;
        actualCategory = null;
        dao = null;
    }

    @Test
    public void getReceivedIdForAddedCategoryOfNews() throws Exception {
        currentId = dao.getNextId();

        assertEquals(currentId, dao.getNextId());
    }

    @Test
    public void createCategoryOfNews() throws Exception {
        currentId = dao.getNextId();
        expectedCategory = new CategoryOfNews(currentId, "Test");
        dao.createEntity(expectedCategory);
        actualCategory = dao.getEntityById(currentId);
        dao.deleteEntity(currentId);

        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void getAllCategoriesFromDB() throws Exception {
        currentId = dao.getNextId();
        expectedCategory = new CategoryOfNews(currentId, "Test");
        dao.createEntity(expectedCategory);
        expectedCategoryList = dao.getAll();
        dao.deleteEntity(currentId);

        assertFalse(expectedCategoryList.isEmpty());
    }
}