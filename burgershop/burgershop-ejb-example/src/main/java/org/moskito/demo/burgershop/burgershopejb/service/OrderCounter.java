package org.moskito.demo.burgershop.burgershopejb.service;

import net.anotheria.moskito.aop.annotation.Count;

public class OrderCounter {

    /**
     * 'ingredients' producer should register this method call
     * in stat with ingredient name
     */
    @Count(category = "business", producerId = "orders")
    public void orderPlaced() {}

}
