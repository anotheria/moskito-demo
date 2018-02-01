package org.moskito.demo.recipes.counter;

import net.anotheria.moskito.aop.annotation.Count;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 01.02.18 13:47
 */
@Count(producerId = "AnnotationBasedCounter")
public class Counter {
	public void success(){

	}

	public void error(){
		
	}
}
