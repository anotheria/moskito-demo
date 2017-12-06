package org.moskito.demo.burgershop.burgershopejb.service;

import net.anotheria.moskito.aop.annotation.Monitor;
import net.anotheria.moskito.core.dynamic.OnDemandStatsProducer;
import net.anotheria.moskito.core.dynamic.OnDemandStatsProducerException;
import net.anotheria.moskito.core.registry.ProducerRegistryFactory;
import org.moskito.demo.burgershop.burgershopejb.service.stats.SalesStats;
import org.moskito.demo.burgershop.burgershopejb.service.stats.SalesStatsFactory;
import org.moskito.demo.burgershop.burgershopejb.service.stats.ThresholdProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of {@link ShopService}.
 */
@Singleton
@Monitor(producerId="ShopService")
public class ShopServiceImpl implements ShopService{

    private static Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

    private OnDemandStatsProducer<SalesStats> salesProducer;

    private OrderCounter orderCounter = new OrderCounter();
    private IngredientsCounter ingredientsCounter = new IngredientsCounter();

    @EJB(name="ejb/notification")
    private NotificationService notificationService;

    private List<ShopableItem> items;

    /**
     * Fills available ingredients in constructor for demo simplicity.
     * Registers sales and threshold producer.
     */
    public ShopServiceImpl(){

        items = new LinkedList<>();
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

        new ThresholdProducer();

    }

    public List<ShopableItem> getShopableItems() {
        return items;
    }

    @Override
    public Order placeOrder(String customerId, String... items) {

        if (items==null)
            throw new IllegalArgumentException("No items for order");

        // Creating new burger order
        Order order = new Order();

        // Placing ordered ingredients
        for (String item : items){
            ingredientsCounter.ingredientUsed(item);
            order.addItem(findItemByName(item));
        }

        // Order composing is finished. Placing order...
        orderCounter.orderPlaced();

        //now add sales counters...
        int priceInCents = order.getTotalPrice();
        salesProducer.getDefaultStats().addSale(priceInCents);

        for (String item : items){
            try{
                salesProducer.getStats(item).addSale(
                        findItemByName(item).getPrice()
                );
            }catch(OnDemandStatsProducerException e){
                log.warn("Couldn't mark items as sold because we obviously sell more items than producer limit" , e);
            }
        }

        //the following line is a bug, it has been put here to demonstrate detection of call methods.
        log.debug("Should send notification for message to customer "+customerId+" -> "
                + notificationService.shouldNotificationBeSentForCustomer(customerId));
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

        throw new IllegalArgumentException("No such shopable item: " + name);

    }

}