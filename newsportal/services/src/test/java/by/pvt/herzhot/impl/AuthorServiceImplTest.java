package by.pvt.herzhot.impl;

import by.pvt.herzhot.beans.Author;
import by.pvt.herzhot.dao.impl.AuthorDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Herzhot
 * @version 1.0
 *          23.05.2016
 */
public class AuthorServiceImplTest {

    private AuthorDaoImpl dao;
    private List<Author> expectedAuthorList;
    private Author expectedAuthor;
    private Author actualAuthor;
    private int currentId;
    private boolean isAuthorized;

    @Before
    public void setUp() throws Exception {
        dao = AuthorDaoImpl.INSTANCE;
    }

    @After
    public void tearDown() throws Exception {
        expectedAuthorList = null;
        expectedAuthor = null;
        actualAuthor = null;
        dao = null;
    }

    @Test
    public void getCurrentIdForAddedAuthor() throws Exception {
        currentId = dao.getNextId();

        assertEquals(currentId, dao.getNextId());
    }

    @Test
    public void addingNewAuthor() throws Exception {
        currentId = dao.getNextId();
        expectedAuthor = new Author(currentId, "Test", "Test", "Test", "Test", 1);
        dao.createEntity(expectedAuthor);
        actualAuthor = dao.getEntityById(currentId);
        dao.deleteEntity(currentId);

        assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    public void gettingAllAuthorsFromDB() throws Exception {
        currentId = dao.getNextId();
        expectedAuthor = new Author(currentId, "Test", "Test", "Test", "Test", 1);
        dao.createEntity(expectedAuthor);
        expectedAuthorList = dao.getAll();
        dao.deleteEntity(currentId);

        assertFalse(expectedAuthorList.isEmpty());
    }

    @Test
    public void checkAuthorAuthorization() throws Exception {
        currentId = dao.getNextId();
        expectedAuthor = new Author(currentId, "Test", "Test", "Test", "Test", 1);
        dao.createEntity(expectedAuthor);
        isAuthorized = dao.isAuthorized(expectedAuthor.getEmail(),expectedAuthor.getPassword());
        dao.deleteEntity(currentId);

        assertTrue(isAuthorized);
    }

    @Test
    public void gettingAuthorByLogin() throws Exception {
        currentId = dao.getNextId();
        expectedAuthor = new Author(currentId, "Test", "Test", "Test", "Test", 1);
        dao.createEntity(expectedAuthor);
        actualAuthor = dao.getAuthorByLogin(expectedAuthor.getEmail());
        dao.deleteEntity(currentId);

        assertEquals(expectedAuthor, actualAuthor);
    }

}