package org.moskito.demo.burgershop.burgershopstripped.ui;

import jakarta.servlet.http.HttpServletRequest;
import net.anotheria.util.NumberUtils;
import org.moskito.demo.burgershop.burgershopstripped.service.Order;
import org.moskito.demo.burgershop.burgershopstripped.service.ShopService;
import org.moskito.demo.burgershop.burgershopstripped.service.ShopableItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 17.11.13 15:16
 */
@Controller
public class OrderController {
	@Autowired
	private ShopService service;

	private static Logger log = LoggerFactory.getLogger(OrderController.class);

	@RequestMapping(value = "/order.html")
	public String order(HttpServletRequest request, @RequestParam()String choice1, @RequestParam String choice2, @RequestParam String choice3){

		log.debug("Incoming order "+choice1+", "+choice2+", "+choice3);
		String customerId = (String)request.getSession().getAttribute("customerId");
		Order order = service.placeOrder(customerId, choice1, choice2, choice3);

		log.debug("Placed order "+order);

		LinkedList<String> orderedItems = new LinkedList<String>();
		for (ShopableItem item : order.getItems()){
			orderedItems.add(item.getName());
		}
		request.setAttribute("ordereditems", orderedItems);
		request.setAttribute("totalPrice", preparePrice(order));


		return "confirmation";
	}

	private String preparePrice(Order order){
		//return NumberUtils.currencyFormat((double)order.getTotalPrice()/100, ',');
		//Optimization, don't need cast to double
		return NumberUtils.currencyFormat(order.getTotalPrice()/100d, ',');
	}

}
