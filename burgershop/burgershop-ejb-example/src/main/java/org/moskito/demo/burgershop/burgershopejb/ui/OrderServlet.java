package org.moskito.demo.burgershop.burgershopejb.ui;

import net.anotheria.util.NumberUtils;
import org.moskito.demo.burgershop.burgershopejb.service.Order;
import org.moskito.demo.burgershop.burgershopejb.service.ShopService;
import org.moskito.demo.burgershop.burgershopejb.service.ShopableItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Servlet for making burger orders.
 * Expects that request will contain
 * 3 GET parameters named 'choice1', 'choice2', 'choice3'
 * with valid ingredient names as values
 */
public class OrderServlet extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(OrderServlet.class);

    @EJB(name="ejb/shop")
    private ShopService shopService;

    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            throws ServletException, IOException {

        // Retrieving new burger ingredients from request
        String choice1 = servletRequest.getParameter("choice1"),
                choice2 = servletRequest.getParameter("choice2"),
                choice3 = servletRequest.getParameter("choice3");

        log.debug("Incoming order {}, {}, {},", choice1, choice2, choice3);

        // Retrieving customer id from http session
        String customerId = (String) servletRequest.getSession().getAttribute("customerId");

        // Composing order from requested ingredients and customer id
        Order order = shopService.placeOrder(customerId, choice1, choice2, choice3);

        log.debug("Placed order {}", order);

        // Forming a list of used ingredients for display it to the customer
        LinkedList<String> orderedItems = new LinkedList<>();
        for (ShopableItem item : order.getItems()){
            orderedItems.add(item.getName());
        }

        // Order processing done. Setting used ingredients, order price and customer id to servlet request attributes
        // and forwarding request to jsp with order confirmation
        servletRequest.setAttribute("orderedItems", orderedItems);
        servletRequest.setAttribute("totalPrice",
                NumberUtils.currencyFormat(((double) order.getTotalPrice())/100, ',')
        );
        servletRequest.setAttribute("customerId", customerId);

        servletRequest.getRequestDispatcher("/jsp/confirmation.jsp")
                .forward(servletRequest, servletResponse);

    }

}