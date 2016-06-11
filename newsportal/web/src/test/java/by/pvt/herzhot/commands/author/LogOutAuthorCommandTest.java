package by.pvt.herzhot.commands.author;

import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.managers.impl.ConfigManagerImpl;
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
public class LogOutAuthorCommandTest extends Mockito {

    private HttpServletRequest request;
    private HttpSession session;
    private LogOutAuthorCommand command;
    private String expectedPage;
    private String actualPage;

    @Before
    public void setUp() throws Exception {
        command = new LogOutAuthorCommand();
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
    }

    @Test
    public void currentSessionMustBeInvalidated() throws Exception {
        when(request.getSession()).thenReturn(session);

        command.execute(request);

        verify(session, atLeastOnce()).invalidate();
    }

    @Test
    public void redirectionWhenUserIsLogout() throws Exception {
        when(request.getSession()).thenReturn(session);

        expectedPage = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
        actualPage = command.execute(request);

        assertEquals(expectedPage, actualPage);
    }
}