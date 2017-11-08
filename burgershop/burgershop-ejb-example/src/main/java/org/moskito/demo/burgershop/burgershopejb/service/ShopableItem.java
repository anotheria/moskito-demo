package org.moskito.demo.burgershop.burgershopejb.service;

/**
 * Represents burger ingredient.
 *
 * @author lrosenberg
 * @since 16.11.13 22:43
 */
public class ShopableItem {

	/**
	 * Ingredient price
	 */
	private int price;

	/**
	 * Ingredient name
	 */
	private String name;

	/**
	 * Ingredient category.
	 */
	private Category category;

	/**
	 * Constructor that sets
	 * ingredient price, name and category
	 *
	 * @param aName ingredient name
	 * @param aPrice ingredient price
	 * @param aCategory ingredient category
	 */
	public ShopableItem(String aName, int aPrice, Category aCategory){
		name = aName;
		price = aPrice;
		category = aCategory;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public String toString(){
		return getName()+" "+getCategory()+" "+getPrice();
	}

}