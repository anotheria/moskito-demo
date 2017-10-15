package org.moskito.demo.burgershop.burgershopejb.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents single burger order.
 *
 * @author lrosenberg
 * @since 17.11.13 20:40
 */
public class Order {

	/**
	 * List of ordered burger ingredients
	 */
	private List<ShopableItem> items = new ArrayList<>();

	/**
	 * Total burger cost composed from it's ingredients
	 */
	private int totalPrice = 0;

	/**
	 * Adds new ingredient to burger
	 * @param item burger ingredient name
	 */
	public void addItem(ShopableItem item){
		items.add(item);
		totalPrice += item.getPrice();
	}

	/**
	 * Return list of ordered burger ingredients
	 * @return list of ordered burger ingredients
	 */
	public List<ShopableItem> getItems() {
		return items;
	}

	/**
	 * Returns total price of this order burger
	 * @return total price of this order burger
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	public String toString(){
		return getTotalPrice()+" "+items;
	}

}