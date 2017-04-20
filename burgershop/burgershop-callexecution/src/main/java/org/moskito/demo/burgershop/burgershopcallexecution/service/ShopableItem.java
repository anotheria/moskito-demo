package org.moskito.demo.burgershop.burgershopcallexecution.service;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 16.11.13 22:43
 */
public class ShopableItem {
	private int price;

	private String name;

	private Category category;

	public ShopableItem(){

	}

	public ShopableItem(String aName, int aPrice, Category aCategory){
		name = aName;
		price = aPrice;
		category = aCategory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String toString(){
		return getName()+" "+getCategory()+" "+getPrice();
	}
}
