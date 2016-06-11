package by.pvt.herzhot.filters;

import by.pvt.herzhot.commands.factory.CommandType;
import by.pvt.herzhot.constants.ConfigConstants;
import by.pvt.herzhot.constants.Parameters;
import by.pvt.herzhot.constants.UserType;
import by.pvt.herzhot.managers.impl.ConfigManagerImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Herzhot
 * @version 1.0
 *          11.05.2016
 */
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        CommandType type;
        boolean isValidCommand = false;
        String commandName = request.getParameter(Parameters.COMMAND);
        if (commandName == null) {
            commandName = "gotoMainPage";
        }
        for (CommandType c : CommandType.values()) {
            if (c.name().equals(commandName.toUpperCase())) {
                isValidCommand = true;
            }
        }
        if (isValidCommand) {
            type = CommandType.valueOf(commandName.toUpperCase());
        } else {
            session.invalidate();
            type = CommandType.GOTOMAINPAGE;
        }
        if (type.getSecurityLevel() > 0) {
            UserType userType = (UserType) session.getAttribute("userType");
            if (userType != UserType.AUTHOR) {
                String page = ConfigManagerImpl.INSTANCE.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
                RequestDispatcher dispatcher = servletRequest.getServletContext().getRequestDispatcher(page);
                dispatcher.forward(request, response);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void destroy() {}
}
