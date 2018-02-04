package org.moskito.demo.recipes.counter;

import java.util.Random;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 01.02.18 13:44
 */
public class Job implements Runnable{

	//this is the annotation based counter, based on moskito-aop.
	private static Counter counter = new Counter();
	//if you want to use a self-made counter instead of aop counter, comment out the above line, and uncomment following line.
	//private static SelfMadeCounter counter = new SelfMadeCounter();

	private static Random rnd = new Random(System.nanoTime());

	@Override
	public void run() {
		int result = rnd.nextInt(10);
		boolean success = result < 8;
		System.out.println("Executing job, result "+result+" success: "+success);
		if (success){
			counter.success();
		}else{
			counter.error();
		}
	}
}
