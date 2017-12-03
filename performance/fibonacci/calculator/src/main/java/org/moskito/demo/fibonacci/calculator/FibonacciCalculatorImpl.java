package org.moskito.demo.fibonacci.calculator;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 13.10.17 14:32
 */
public class FibonacciCalculatorImpl implements FibonacciCalculator{
	@Override
	public long calculate(int order) {
		return order < 3 ? 1 : calculate(order-1) + calculate(order-2);
	}
}
