package by.pvt.herzhot.commands.impl.author;

import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.managers.ConfigManagerImpl;
import by.pvt.herzhot.pojos.impl.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;

/**
 * @author Herzhot
 * @version 1.0
 *          20.05.2016
 */
public class LoginAuthorCommandTest extends Mockito {

    private HttpServletRequest request;
    private HttpSession session;
    private LoginAuthorCommand command;
    private String expectedPage;
    private String actualPage;
    private Author expectedAuthor;
    private int currentId;

    @Before
    public void setUp() throws Exception {
        command = new LoginAuthorCommand();
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
    }

    @After
    public void tearDown() throws Exception {
        request = null;
        command = null;
        session = null;
        expectedPage = null;
        actualPage = null;
        expectedAuthor = null;
        int currentId = 0;
    }

    @Test
    public void processingWithWrongLoginOrPassword() throws Exception {
        when(request.getParameter("email")).thenReturn("wrongLogin");
        when(request.getParameter("password")).thenReturn("wrongPassword");
        when(request.getSession()).thenReturn(session);

        expectedPage = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
        actualPage = command.execute(request);

        assertEquals(expectedPage, actualPage);
        verify(request, atLeastOnce()).getParameter("email");
        verify(request, atLeastOnce()).getParameter("password");
    }
}