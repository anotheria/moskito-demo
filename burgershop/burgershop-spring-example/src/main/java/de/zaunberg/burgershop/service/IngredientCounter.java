package de.zaunberg.burgershop.service;

import net.anotheria.moskito.aop.annotation.CountByParameter;


public class IngredientCounter {
	@CountByParameter(category = "business", producerId="ingredients")
	public void ingredientUsed(String ingredient){

	}
}