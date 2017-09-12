package org.moskito.demo.burgershop.burgershopejb.service;

import javax.ejb.Local;

@Local
public interface CounterService {

    void orderPlaced();

    void ingredientUsed(String ingredient);

}
