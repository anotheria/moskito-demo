package org.moskito.demo.fibonacci.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 13.10.17 14:34
 */
public class FibonacciCalculatorImplTest {

	FibonacciCalculatorImpl calc = new FibonacciCalculatorImpl();

	@Test
	public void testFirst(){
		assertEquals(1, calc.calculate(1));
	}

	@Test
	public void testSecond(){
		assertEquals(1, calc.calculate(2));
	}

	@Test
	public void testThird(){
		assertEquals(2, calc.calculate(3));
	}

	@Test
	public void test42(){
		assertEquals(267914296, calc.calculate(42));
	}

	@Test
	public void testRecursion2(){
		assertEquals(calc.calculate(10)+calc.calculate(11), calc.calculate(12));
	}

}
