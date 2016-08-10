package by.herzhot.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Herzhot
 * @version 1.0
 *          10.05.2016
 */
public class EncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
						 FilterChain filterChain) throws IOException, ServletException {
	//Set character encoding as UTF-8
	servletRequest.setCharacterEncoding("UTF-8");
	filterChain.doFilter(servletRequest, servletResponse);
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	@Override
	public void destroy() {}

}
