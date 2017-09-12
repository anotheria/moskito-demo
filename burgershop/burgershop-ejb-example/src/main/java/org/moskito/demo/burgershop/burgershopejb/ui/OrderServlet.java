package org.moskito.demo.burgershop.burgershopejb.ui;

import net.anotheria.util.NumberUtils;
import org.moskito.demo.burgershop.burgershopejb.service.Order;
import org.moskito.demo.burgershop.burgershopejb.service.ShopService;
import org.moskito.demo.burgershop.burgershopejb.service.ShopableItem;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;

public class OrderServlet extends HttpServlet {

    @EJB(name="ejb/shop")
    private ShopService shopService;

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {

        String choice1 = servletRequest.getParameter("choice1"),
                choice2 = servletRequest.getParameter("choice2"),
                choice3 = servletRequest.getParameter("choice3");

        String customerId = (String)
                ((HttpServletRequest)servletRequest)
                .getSession()
                .getAttribute("customerId");

        Order order = shopService.placeOrder(customerId, choice1, choice2, choice3);

        LinkedList<String> orderedItems = new LinkedList<String>();
        for (ShopableItem item : order.getItems()){
            orderedItems.add(item.getName());
        }

        servletRequest.setAttribute("orderedItems", orderedItems);
        servletRequest.setAttribute("totalPrice", preparePrice(order));

        servletRequest.setAttribute("customerId", customerId);
        servletRequest.getRequestDispatcher("/jsp/confirmation.jsp")
                .forward(servletRequest, servletResponse);

    }

    private String preparePrice(Order order){
        return NumberUtils.currencyFormat(order.getTotalPrice()/100, ',');
    }

}
