package org.moskito.demo.daemon.javaagent;

import java.util.Random;

public class Worker {

	private static final Random rnd = new Random(System.nanoTime());

 	void doSomeWork(){
		//lets assume they do some work.
		try {
			Thread.sleep(rnd.nextInt(1000));
		} catch(InterruptedException ignored) {}
	}

}
