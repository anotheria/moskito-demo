package org.moskito.demo.burgershop.burgershopejb.service;

import javax.ejb.Stateless;

@Stateless
public class CounterServiceImpl implements CounterService {

    @Override
    public void orderPlaced() {
        int foo = 5;
    }

    @Override
    public void ingredientUsed(String ingredient) {
        int bar = 5;
    }

}
