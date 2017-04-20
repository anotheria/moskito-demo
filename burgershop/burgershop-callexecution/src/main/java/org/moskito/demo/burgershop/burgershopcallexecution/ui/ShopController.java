package org.moskito.demo.burgershop.burgershopcallexecution.ui;

import net.anotheria.moskito.aop.annotation.Monitor;
import net.anotheria.moskito.core.dynamic.OnDemandStatsProducer;
import net.anotheria.moskito.core.predefined.ServiceStats;
import net.anotheria.moskito.core.predefined.ServiceStatsFactory;
import net.anotheria.moskito.core.producers.CallExecution;
import net.anotheria.moskito.core.registry.ProducerRegistryFactory;
import org.moskito.demo.burgershop.burgershopcallexecution.service.Category;
import org.moskito.demo.burgershop.burgershopcallexecution.service.ShopService;
import org.moskito.demo.burgershop.burgershopcallexecution.service.ShopableItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 16.11.13 22:22
 */
@Controller
@Monitor(category="controller")
public class ShopController {

	private static Logger log = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	private ShopService service;

	private OnDemandStatsProducer<ServiceStats> producer;

	public ShopController(){
		producer = new OnDemandStatsProducer<ServiceStats>(ShopController.class.getSimpleName(), "controller", "web", ServiceStatsFactory.DEFAULT_INSTANCE);
		ProducerRegistryFactory.getProducerRegistryInstance().registerProducer(producer);

	}


	@RequestMapping(value = "/shop.html")
	public String enterShop(HttpServletRequest request){
		// There is only one possible execution, so we simply use default stats.
		CallExecution execution = producer.getDefaultStats().createCallExecution();
		execution.startExecution();

		try {
			List<ShopableItem> items = service.getShopableItems();
			log.debug("Items: "+items);

			HashMap<Category, List<ShopItemBean>> beans = new HashMap<Category, List<ShopItemBean>>();
			for (ShopableItem item : items){
				ShopItemBean bean = new ShopItemBean();
				bean.setItem(item.getName());
				bean.setPrice(item.getPrice());

				String nicePrice = "";

				nicePrice = ""+(item.getPrice()/100);
				int centPrice = item.getPrice()-(item.getPrice()/100*100);
				nicePrice += ".";
				nicePrice += (centPrice<10) ? centPrice == 0 ? "00" : "0"+centPrice :""+centPrice;
				bean.setNicePrice(nicePrice);

				List<ShopItemBean> itemsForCategory = beans.get(item.getCategory());
				if (itemsForCategory==null){
					itemsForCategory = new ArrayList<ShopItemBean>();
					beans.put(item.getCategory(), itemsForCategory);
				}
				itemsForCategory.add(bean);
			}

			for (Category c : Category.values()){
				request.setAttribute(c.name(), beans.get(c));
			}
			return "shop";
		}finally{
			execution.finishExecution();
		}
	}
}
