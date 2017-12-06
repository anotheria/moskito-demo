package org.moskito.demo.burgershop.burgershopejb.service;

import net.anotheria.moskito.aop.annotation.CountByParameter;

/**
 * Demonstrates {@link CountByParameter}
 * annotation work
 */
public class IngredientsCounter {

    /**
     * 'ingredients' producer should register this method call
     * in stat with ingredient name
     */
    @CountByParameter(category = "business", producerId = "ingredients")
    public void ingredientUsed(String ingredient) {}

}
