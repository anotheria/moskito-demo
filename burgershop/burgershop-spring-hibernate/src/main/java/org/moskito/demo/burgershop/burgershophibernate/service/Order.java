package org.moskito.demo.burgershop.burgershophibernate.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 17.11.13 20:40
 */
@Entity
@Table(name = "Orders")
public class Order {

	private Long id;

	private List<ShopableItem> items;

	private int totalPrice;

	private String customerId;

	public Order() {
		items = new ArrayList<ShopableItem>();
	}

	public void addItem(ShopableItem item) {
		items.add(item);
		totalPrice += item.getPrice();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public List<ShopableItem> getItems() {
		return items;
	}

	@Column(name = "items")
	public String getItemsDescription() {
		return items.toString();
	}

	public void setItemsDescription(String description) {
		//do nothing
	}

	public void setItems(List<ShopableItem> items) {
		this.items = items;
	}

	@Column(name = "price")
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Column(name = "customerId")
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String toString() {
		return getTotalPrice() + " " + items;
	}
}
