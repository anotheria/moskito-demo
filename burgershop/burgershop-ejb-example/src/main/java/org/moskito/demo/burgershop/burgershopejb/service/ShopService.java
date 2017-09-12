package org.moskito.demo.burgershop.burgershopejb.service;

import javax.ejb.Local;
import java.util.List;

/**
 * Service to retrieve available
 * shopping items and place new burger order
 */
@Local
public interface ShopService {

    /**
     * Returns list of all available shopping items
     * @return list of all available shopping items
     */
    List<ShopableItem> getShopableItems();

    /**
     * Places a new single burger order in the system.
     * @param items ingredients of new order burger
     * @return composed burger order from method 'items' argument
     */
    Order placeOrder(String customerId, String... items);

}