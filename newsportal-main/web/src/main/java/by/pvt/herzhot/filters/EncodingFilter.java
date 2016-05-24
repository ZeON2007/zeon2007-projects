/**
 * Copyright (c) 2015, Khudnitsky. All rights reserved.
 */
package by.pvt.herzhot.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Herzhot
 * @version 1.0
 *          10.05.2016
 */
public class EncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
	//Set character encoding as UTF-8
	request.setCharacterEncoding("UTF-8");
	filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	@Override
	public void destroy() {}

}
