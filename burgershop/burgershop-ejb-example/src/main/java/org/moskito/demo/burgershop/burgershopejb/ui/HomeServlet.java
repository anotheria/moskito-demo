package org.moskito.demo.burgershop.burgershopejb.ui;

import javax.servlet.*;
import java.io.IOException;

public class HomeServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletRequest.setAttribute("customerId", "NOT IMPLEMENTED YET");
        servletRequest.getRequestDispatcher("/jsp/index.jsp").forward(servletRequest, servletResponse);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
