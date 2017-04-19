package org.moskito.demo.burgershop.burgershopspring.service;

import java.util.List;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 16.11.13 22:43
 */
public interface ShopService {
	List<ShopableItem> getShopableItems();

	Order placeOrder(String... items);


}
