package org.moskito.demo.burgershop.burgershopsql.service;

import java.util.List;

/**
 * Shop service.
 *
 * @author lrosenberg
 * @since 16.11.13 22:43
 */
public interface ShopService {
	/**
	 * Returns the list of available items for shopping.
	 * @return
	 */
	List<ShopableItem> getShopableItems();

	/**
	 * Places a new order in the system.
	 * @param items
	 * @return
	 */
	Order placeOrder(String customerId, String... items);


}
