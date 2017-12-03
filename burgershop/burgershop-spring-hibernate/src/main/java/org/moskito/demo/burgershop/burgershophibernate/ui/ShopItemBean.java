package org.moskito.demo.burgershop.burgershophibernate.ui;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 16.11.13 22:28
 */
public class ShopItemBean {
	private int price;
	private String item;
	private String nicePrice;


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNicePrice() {
		return nicePrice;
	}

	public void setNicePrice(String nicePrice) {
		this.nicePrice = nicePrice;
	}

}
