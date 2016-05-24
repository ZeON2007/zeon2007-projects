package by.pvt.herzhot.dao;

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
 *          19.05.2016
 */
public class CategoryOfNewsDaoImplTest {

    private List<CategoryOfNews> expectedCategoryList;
    private CategoryOfNews expectedCategory;
    private CategoryOfNews actualCategory;
    private int currentId;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {
        expectedCategoryList = null;
        expectedCategory = null;
        actualCategory = null;
        currentId = 0;
    }

    @Test
    public void getReceivedIdForAddedCategoryOfNews() throws Exception {
        currentId = CategoryOfNewsDaoImpl.INSTANCE.getNextId();

        assertEquals(currentId, CategoryOfNewsDaoImpl.INSTANCE.getNextId());
    }

    @Test
    public void createCategoryOfNews() throws Exception {
        currentId = CategoryOfNewsDaoImpl.INSTANCE.getNextId();
        expectedCategory = new CategoryOfNews(currentId, "Test");
        CategoryOfNewsDaoImpl.INSTANCE.createEntity(expectedCategory);
        actualCategory = CategoryOfNewsDaoImpl.INSTANCE.getEntityById(currentId);
        CategoryOfNewsDaoImpl.INSTANCE.deleteEntity(currentId);

        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void getAllCategoriesFromDB() throws Exception {
        currentId = CategoryOfNewsDaoImpl.INSTANCE.getNextId();
        expectedCategory = new CategoryOfNews(currentId, "Test");
        CategoryOfNewsDaoImpl.INSTANCE.createEntity(expectedCategory);
        expectedCategoryList = CategoryOfNewsDaoImpl.INSTANCE.getAll();
        CategoryOfNewsDaoImpl.INSTANCE.deleteEntity(currentId);

        assertFalse(expectedCategoryList.isEmpty());
    }
}