package by.pvt.herzhot.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Herzhot
 * @version 1.0
 *          20.05.2016
 */
public class ControllerTest extends Mockito {

    private Controller controller;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext servletContext;
    private RequestDispatcher requestDispatcher;
    private HttpSession session;

    @Before
    public void setUp() throws Exception {
        controller = new Controller();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        servletContext = mock(ServletContext.class);
        requestDispatcher = mock(RequestDispatcher.class);
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
        request = null;
        response = null;
        session = null;
        servletContext = null;
        requestDispatcher = null;
    }

    @Test
    public void controllerShouldProcessAnyCommand() throws Exception {
        when(request.getParameter("command")).thenReturn("login");
        when(request.getParameter("email")).thenReturn("test");
        when(request.getParameter("password")).thenReturn("test");
        when(request.getSession()).thenReturn(session);
        when(request.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        controller.processRequest(request, response);

        verify(request, atLeastOnce()).getParameter("command");
        verify(request, atLeastOnce()).getParameter("email");
        verify(request, atLeastOnce()).getParameter("password");
        verify(requestDispatcher).forward(request, response);

    }

    @Test
    public void controllerShouldProcessEmptyCommand() throws Exception {
        when(request.getParameter("command")).thenReturn("");
        when(request.getSession()).thenReturn(session);
        when(request.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        controller.processRequest(request, response);

        verify(request, atLeastOnce()).getParameter("command");
        verify(requestDispatcher).forward(request, response);
    }
}