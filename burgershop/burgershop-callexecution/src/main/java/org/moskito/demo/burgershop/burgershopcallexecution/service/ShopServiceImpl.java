package org.moskito.demo.burgershop.burgershopcallexecution.service;

import net.anotheria.moskito.core.dynamic.OnDemandStatsProducer;
import net.anotheria.moskito.core.dynamic.OnDemandStatsProducerException;
import net.anotheria.moskito.core.predefined.ServiceStats;
import net.anotheria.moskito.core.predefined.ServiceStatsFactory;
import net.anotheria.moskito.core.producers.CallExecution;
import net.anotheria.moskito.core.registry.ProducerRegistryFactory;
import org.moskito.demo.burgershop.burgershopspring.service.stats.ThresholdProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the ShopService.
 *
 * @author lrosenberg
 * @since 16.11.13 22:47
 */
public class ShopServiceImpl implements ShopService {

	private LinkedList<ShopableItem> items;

	private static Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

	private OnDemandStatsProducer<ServiceStats> producer;

	public ShopServiceImpl(){
		items = new LinkedList<ShopableItem>();
		items.add(new ShopableItem("wheat", 585, Category.BREAD));
		items.add(new ShopableItem("wholemeal", 285, Category.BREAD));
		items.add(new ShopableItem("brioche", 585, Category.BREAD));
		items.add(new ShopableItem("burned", 585, Category.BREAD));
		items.add(new ShopableItem("leibniz", 1085, Category.BREAD));

		items.add(new ShopableItem("cow", 1385, Category.MEAT));
		items.add(new ShopableItem("pork", 1185, Category.MEAT));
		items.add(new ShopableItem("lamb", 1584, Category.MEAT));
		items.add(new ShopableItem("dog", 585, Category.MEAT));
		items.add(new ShopableItem("rat", 10, Category.MEAT));

		items.add(new ShopableItem("mushrooms", 285, Category.EXTRAS));
		items.add(new ShopableItem("broccoli", 185, Category.EXTRAS));
		items.add(new ShopableItem("cheese", 85, Category.EXTRAS));
		items.add(new ShopableItem("sauce", 85, Category.EXTRAS));
		items.add(new ShopableItem("cockroach", 2085, Category.EXTRAS));

		producer = new OnDemandStatsProducer<ServiceStats>("ShopService", "business", "sales", ServiceStatsFactory.DEFAULT_INSTANCE);
		ProducerRegistryFactory.getProducerRegistryInstance().registerProducer(producer);

		new ThresholdProducer();
	}

	@Override
	public List<ShopableItem> getShopableItems() {
		return items;
	}

	@Override
	public Order placeOrder(String... items) {
		//first find the order
        if (items==null)
			throw new IllegalArgumentException("No items for order");

		CallExecution execution = null;
        try {
			execution = producer.getStats("placeOrder").createCallExecution();
			execution.startExecution();
		}catch(OnDemandStatsProducerException exception){
        	log.error("Can't create 'placeOrder' stats, that can't actually happen in limited environment" ,exception);
		}

		try {


			Order order = new Order();
			for (String item : items) {
				order.addItem(findItemByName(item));
			}
			return order;
		}finally{
			execution.finishExecution();
		}


	}

	private ShopableItem findItemByName(String name){
		for (ShopableItem item : items){
			if (item.getName().equals(name))
				return item;
		}
		throw new IllegalArgumentException("No such shopable item: "+name);
	}
}
