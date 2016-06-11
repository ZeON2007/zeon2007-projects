package by.pvt.herzhot.filters;

import by.pvt.herzhot.utils.HibernateUtil;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Herzhot
 * @version 1.0
 *          10.06.2016
 */
public class SessionClosingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        HibernateUtil.currentSession();
        chain.doFilter(servletRequest, servletResponse);
        HibernateUtil.closeSession();
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void destroy() {}
}
