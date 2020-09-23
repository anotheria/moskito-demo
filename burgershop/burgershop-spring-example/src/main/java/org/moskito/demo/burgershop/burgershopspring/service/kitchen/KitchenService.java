package org.moskito.demo.burgershop.burgershopspring.service.kitchen;

import org.moskito.demo.burgershop.burgershopspring.service.Order;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 2019-08-09 17:15
 */
public interface KitchenService {
	int scheduleForProduction(Order order) throws KitchenServiceException;
}
