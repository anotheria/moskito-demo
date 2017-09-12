package org.moskito.demo.burgershop.burgershopejb.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ShopService {

    List<ShopableItem> getShopableItems();

    /**
     * Places a new order in the system.
     * @param items
     * @return
     */
    Order placeOrder(String customerId, String... items);

}
