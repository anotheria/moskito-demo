package org.moskito.demo.burgershop.burgershopejb.service;

import javax.ejb.Local;

/**
 * Service used to count incoming orders
 * and consumed ingredients.
 * Demonstrates work
 * of {@link net.anotheria.moskito.aop.annotation.Count}
 * and {@link net.anotheria.moskito.aop.annotation.CountByParameter}
 * annotations
 */
@Local
public interface CounterService {

    /**
     * Calls when new order is placed
     */
    void orderPlaced();

    /**
     * Calls on ingredient consumption
     * @param ingredient ingredient name
     */
    void ingredientUsed(String ingredient);

}
