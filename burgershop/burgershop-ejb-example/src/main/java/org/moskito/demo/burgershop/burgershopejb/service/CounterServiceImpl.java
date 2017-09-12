package org.moskito.demo.burgershop.burgershopejb.service;

import net.anotheria.moskito.aop.annotation.Count;
import net.anotheria.moskito.aop.annotation.CountByParameter;

import javax.ejb.Singleton;

/**
 * Implementation of {@link CounterService}.
 * Has empty methods with {@link Count} and {@link CountByParameter}
 * annotations to demonstrate it work.
 */
@Singleton
public class CounterServiceImpl implements CounterService {

    /**
     * 'orders' producer should register this method call
     * in it stats
     */
    @Override
    @Count(category = "business", producerId = "orders")
    public void orderPlaced() {}

    /**
     * 'orders' producer should register this method call
     * in stat with ingredient name
     */
    @Override
    @CountByParameter(category = "business", producerId="ingredients")
    public void ingredientUsed(String ingredient) {}

}