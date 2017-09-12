package org.moskito.demo.burgershop.burgershopejb.ui;

import org.moskito.demo.burgershop.burgershopejb.service.ShopService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    @EJB(name="ejb/shop")
    private ShopService shopService;

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletRequest.setAttribute(
                "customerId",
                ((HttpServletRequest)servletRequest).getSession(true)
                .getAttribute("customerId")
        );
        servletRequest.getRequestDispatcher("/jsp/index.jsp").forward(servletRequest, servletResponse);
    }

}