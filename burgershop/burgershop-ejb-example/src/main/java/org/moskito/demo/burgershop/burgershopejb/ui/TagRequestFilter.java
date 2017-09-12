package org.moskito.demo.burgershop.burgershopejb.ui;

import net.anotheria.moskito.core.context.MoSKitoContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Acquires customer id from http session
 * and uses it as tag for moskito context.
 *
 * @author lrosenberg
 * @since 22.05.17 22:11
 */
public class TagRequestFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		if (servletRequest instanceof HttpServletRequest){

			HttpServletRequest req = (HttpServletRequest) servletRequest;
			HttpSession session = req.getSession(false);

			if (session!=null){
				String customerId = (String) session.getAttribute("customerId");
				MoSKitoContext.addTag("customerId", customerId);
			}

		}

		chain.doFilter(servletRequest, servletResponse);

	}

	@Override
	public void destroy() {

	}

}