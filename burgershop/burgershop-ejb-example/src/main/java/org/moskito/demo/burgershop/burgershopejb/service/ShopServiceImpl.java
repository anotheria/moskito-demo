package org.moskito.demo.burgershop.burgershopejb.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.LinkedList;
import java.util.List;

@Stateful
public class ShopServiceImpl implements ShopService{

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
