package org.moskito.demo.burgershop.burgershopejb.service;

import net.anotheria.moskito.core.dynamic.OnDemandStatsProducer;
import net.anotheria.moskito.core.registry.ProducerRegistryFactory;
import org.moskito.demo.burgershop.burgershopejb.service.stats.SalesStats;
import org.moskito.demo.burgershop.burgershopejb.service.stats.SalesStatsFactory;
import org.moskito.demo.burgershop.burgershopejb.service.stats.ThresholdProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.LinkedList;
import java.util.List;

@Stateful
public class ShopServiceImpl implements ShopService{

    private static Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

    private OnDemandStatsProducer<SalesStats> salesProducer;

    @EJB(name="ejb/counter")
    private CounterService counterService;

    @EJB(name="ejb/notification")
    private NotificationService notificationService;

    private List<ShopableItem> items;

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

        salesProducer = new OnDemandStatsProducer<>(
                "sales",
                "business",
                "sales",
                new SalesStatsFactory()
        );

        ProducerRegistryFactory.getProducerRegistryInstance().registerProducer(salesProducer);

        new ThresholdProducer(); // TODO : MAY DO SOMETHING WITH THIS CONSTRUCTOR

    }

    public List<ShopableItem> getShopableItems() {
        return items;
    }

    @Override
    public Order placeOrder(String customerId, String... items) {

        if (items==null)
            throw new IllegalArgumentException("No items for order");

        Order order = new Order();

        for (String item : items){
            counterService.ingredientUsed(item);
            order.addItem(findItemByName(item));
        }

        counterService.orderPlaced();

        if (notificationService.shouldNotificationBeSentForCustomer(customerId)){
            notificationService.sendNotificationAboutOrder(customerId, order.toString());
        }

        return order;

    }

    private ShopableItem findItemByName(String name){
        for (ShopableItem item : items){
            if (item.getName().equals(name))
                return item;
        }
        throw new IllegalArgumentException("No such shopable item: "+name);
    }

}
