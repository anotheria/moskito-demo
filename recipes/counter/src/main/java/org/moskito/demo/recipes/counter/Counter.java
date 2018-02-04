package org.moskito.demo.recipes.counter;

import net.anotheria.moskito.aop.annotation.Count;

/**
 * This is the standard counter implementation. It is based on annotations, and requires minimum intervention.
 *
 * @author lrosenberg
 * @since 01.02.18 13:47
 */
@Count(producerId = "ProcessCounter")
public class Counter {
	/**
	 * Call this method when the process has been successful.
	 */
	public void success(){

	}

	/**
	 * Call this method when the process has finished with an error.
	 */
	public void error(){
		
	}
}
