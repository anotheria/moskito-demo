package org.moskito.demo.burgershop.burgershopejb.service;

import net.anotheria.moskito.aop.annotation.Count;
import net.anotheria.moskito.aop.annotation.CountByParameter;

import javax.ejb.Stateless;

@Stateless
public class CounterServiceImpl implements CounterService {

    @Override
    @Count(category = "business", producerId = "orders")
    public void orderPlaced() {}

    @Override
    @CountByParameter(category = "business", producerId="ingredients")
    public void ingredientUsed(String ingredient) {}

}
