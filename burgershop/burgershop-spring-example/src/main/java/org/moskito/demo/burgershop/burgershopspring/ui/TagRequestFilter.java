package org.moskito.demo.burgershop.burgershopspring.ui;

import net.anotheria.moskito.core.context.MoSKitoContext;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 22.05.17 22:11
 */
public class TagRequestFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		MoSKitoContext.get().reset();
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
