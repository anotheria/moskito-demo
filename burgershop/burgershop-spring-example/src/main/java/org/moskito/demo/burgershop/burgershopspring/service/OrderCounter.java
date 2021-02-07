package org.moskito.demo.burgershop.burgershopspring.service;

import net.anotheria.moskito.aop.annotation.Count;
import net.anotheria.moskito.aop.annotation.UserActivity;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 12.09.14 00:02
 */
@Count(category = "business", producerId = "orders")
public class OrderCounter {
	@UserActivity(name="order_processed")
	public void orderPlaced(){}
}
