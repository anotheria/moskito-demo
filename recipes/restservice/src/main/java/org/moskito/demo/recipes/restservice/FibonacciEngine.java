package org.moskito.demo.recipes.restservice;

import net.anotheria.moskito.aop.annotation.Monitor;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 01.02.18 23:37
 */
@Monitor
public class FibonacciEngine {
	public int calculate(int orderInSequence){
		if (orderInSequence == 1 || orderInSequence == 2)
			return 1;
		return (calculate(orderInSequence-1)) + (calculate(orderInSequence-2));
	}
}
