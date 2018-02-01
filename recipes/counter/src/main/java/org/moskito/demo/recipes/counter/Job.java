package org.moskito.demo.recipes.counter;

import java.util.Random;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 01.02.18 13:44
 */
public class Job implements Runnable{

	private static Counter annotationBasedCounter = new Counter();
	private static SelfMadeCounter selfMadeCounter = new SelfMadeCounter();

	private static Random rnd = new Random(System.nanoTime());

	@Override
	public void run() {
		int result = rnd.nextInt(10);
		boolean success = result < 8;
		System.out.println("Executing job, result "+result+" success: "+success);
		if (success){
			annotationBasedCounter.success();
			selfMadeCounter.success();
		}else{
			annotationBasedCounter.error();
			selfMadeCounter.error();
		}
	}
}
