package de.zaunberg.burgershop.service;

import net.anotheria.moskito.aop.annotation.Count;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 12.09.14 00:02
 */
@Count(category = "business", producerId = "orders")
public class OrderCounter {
	public void orderPlaced(){}
}
