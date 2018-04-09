package org.moskito.demo.burgershop.burgershopspring.service;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 19.02.18 10:43
 */
public class InvalidIngredientException extends RuntimeException {

	public InvalidIngredientException(String ingredient){
		super("Invalid ingredient "+ingredient);
	}


}
