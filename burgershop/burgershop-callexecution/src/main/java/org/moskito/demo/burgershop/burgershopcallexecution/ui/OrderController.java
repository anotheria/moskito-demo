package org.moskito.demo.burgershop.burgershopcallexecution.ui;

import net.anotheria.moskito.core.dynamic.OnDemandStatsProducer;
import net.anotheria.moskito.core.predefined.ServiceStats;
import net.anotheria.moskito.core.predefined.ServiceStatsFactory;
import net.anotheria.moskito.core.producers.CallExecution;
import net.anotheria.moskito.core.registry.ProducerRegistryFactory;
import net.anotheria.util.NumberUtils;
import org.moskito.demo.burgershop.burgershopcallexecution.service.Order;
import org.moskito.demo.burgershop.burgershopcallexecution.service.ShopService;
import org.moskito.demo.burgershop.burgershopcallexecution.service.ShopableItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

	private OnDemandStatsProducer<ServiceStats> producer;

	public OrderController(){
		producer = new OnDemandStatsProducer<ServiceStats>(OrderController.class.getSimpleName(), "controller", "web", ServiceStatsFactory.DEFAULT_INSTANCE);
		ProducerRegistryFactory.getProducerRegistryInstance().registerProducer(producer);

	}


	@RequestMapping(value = "/order.html")
	public String order(HttpServletRequest request, @RequestParam()String choice1, @RequestParam String choice2, @RequestParam String choice3){
		// There is only one possible execution, so we simply use default stats.
		CallExecution execution = producer.getDefaultStats().createCallExecution();
		execution.startExecution();

		try {
			log.debug("Incoming order "+choice1+", "+choice2+", "+choice3);
			Order order = service.placeOrder(choice1, choice2, choice3);

			log.debug("Placed order "+order);

			LinkedList<String> orderedItems = new LinkedList<String>();
			for (ShopableItem item : order.getItems()){
				orderedItems.add(item.getName());
			}
			request.setAttribute("ordereditems", orderedItems);
			request.setAttribute("totalPrice", preparePrice(order));


			return "confirmation";
		}finally{
			execution.finishExecution();
		}
	}


	private String preparePrice(Order order){
		//return NumberUtils.currencyFormat((double)order.getTotalPrice()/100, ',');
		//Optimization, don't need cast to double
		return NumberUtils.currencyFormat(order.getTotalPrice()/100d, ',');
	}

}
