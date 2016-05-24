package by.pvt.herzhot.dao;

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
 *          19.05.2016
 */
public class AuthorDaoImplTest {

    private List<Author> expectedAuthorList;
    private Author expectedAuthor;
    private Author actualAuthor;
    private int currentId;
    private boolean isAuthorized;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {
        expectedAuthorList = null;
        expectedAuthor = null;
        actualAuthor = null;
        currentId = 0;
        isAuthorized = false;
    }

    @Test
    public void getCurrentIdForAddedAuthor() throws Exception {
        currentId = AuthorDaoImpl.INSTANCE.getNextId();

        assertEquals(currentId, AuthorDaoImpl.INSTANCE.getNextId());
    }

    @Test
    public void addingNewAuthor() throws Exception {
        currentId = AuthorDaoImpl.INSTANCE.getNextId();
        expectedAuthor = new Author(currentId, "Test", "Test", "Test", "Test", 1);
        AuthorDaoImpl.INSTANCE.createEntity(expectedAuthor);
        actualAuthor = AuthorDaoImpl.INSTANCE.getEntityById(currentId);
        AuthorDaoImpl.INSTANCE.deleteEntity(currentId);

        assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    public void gettingAllAuthorsFromDB() throws Exception {
        currentId = AuthorDaoImpl.INSTANCE.getNextId();
        expectedAuthor = new Author(currentId, "Test", "Test", "Test", "Test", 1);
        AuthorDaoImpl.INSTANCE.createEntity(expectedAuthor);
        expectedAuthorList = AuthorDaoImpl.INSTANCE.getAll();
        AuthorDaoImpl.INSTANCE.deleteEntity(currentId);

        assertFalse(expectedAuthorList.isEmpty());
    }

    @Test
    public void checkAuthorAuthorization() throws Exception {
        currentId = AuthorDaoImpl.INSTANCE.getNextId();
        expectedAuthor = new Author(currentId, "Test", "Test", "Test", "Test", 1);
        AuthorDaoImpl.INSTANCE.createEntity(expectedAuthor);
        isAuthorized = AuthorDaoImpl.INSTANCE.isAuthorized(expectedAuthor.getEmail(),
                expectedAuthor.getPassword());
        AuthorDaoImpl.INSTANCE.deleteEntity(currentId);

        assertTrue(isAuthorized);
    }

    @Test
    public void gettingAuthorByLogin() throws Exception {
        currentId = AuthorDaoImpl.INSTANCE.getNextId();
        expectedAuthor = new Author(currentId, "Test", "Test", "Test", "Test", 1);
        AuthorDaoImpl.INSTANCE.createEntity(expectedAuthor);
        actualAuthor = AuthorDaoImpl.INSTANCE.getAuthorByLogin(expectedAuthor.getEmail());
        AuthorDaoImpl.INSTANCE.deleteEntity(currentId);

        assertEquals(expectedAuthor, actualAuthor);
    }
}