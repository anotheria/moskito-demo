package org.moskito.demo.burgershop.burgershopejb.ui;

import net.anotheria.util.NumberUtils;

/**
 * Bean class that represents
 * burger ingredient.
 *
 * Contains item name and price in
 * format €€.¢¢ where cents always has leading zeros.
 * Example : '10.55', '20.50', '3.00'
 *
 * Used for data layout in jsp
 *
 * @author lrosenberg
 * @since 16.11.13 22:28
 */
public class ShopItemBean {

	/**
	 * Formatted item price
	 */
	private String price;
	/**
	 * Item name
	 */
	private String item;

	/**
	 * Constructor with item name
	 * and integer item price in cents parameters.
	 * Converts price in cents to human readable price string
	 *
	 * @param item item name
	 * @param price item price in cents
	 */
	public ShopItemBean(String item, int price){

		this.item = item;
		this.price  =
				NumberUtils.currencyFormat((double) price / 100, '.');

	}

	public String getPrice() {
		return price;
	}

	public String getItem() {
		return item;
	}

}