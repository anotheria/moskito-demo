package org.moskito.demo.burgershop.burgershopspring.service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 17.11.13 20:40
 */
public class Order {
	private List<ShopableItem> items;

	private int totalPrice;

	public Order(){
		items = new ArrayList<ShopableItem>();
	}

	public void addItem(ShopableItem item){
		items.add(item);
		totalPrice += item.getPrice();
	}

	public List<ShopableItem> getItems() {
		return items;
	}

	public void setItems(List<ShopableItem> items) {
		this.items = items;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String toString(){
		return getTotalPrice()+" "+items;
	}
}
