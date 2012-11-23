package org.anotheria.moskitodemo.accumulator.listener;

import net.anotheria.moskito.core.accumulation.Accumulators;
import org.anotheria.moskitodemo.accumulator.RandomProducer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SetupAccumulators implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		//start demo data
		new RandomProducer(10, 100);
		new RandomProducer(100, 100);
		new RandomProducer(1000, 1000);
		
		System.out.println("Configuring accumulators ... ");
		setupRandomServiceAccumulators();
		System.out.println(" ... done.");
	}
	
	private static void setupRandomServiceAccumulators(){
		Accumulators.createServiceREQAccumulator("Random1-REQ-5m", "Random1", "5m");
		Accumulators.createServiceREQAccumulator("Random2-REQ-5m", "Random2", "5m");
		Accumulators.createServiceREQAccumulator("Random3-REQ-5m", "Random3", "5m");

		Accumulators.createServiceREQAccumulator("Random1-REQ-1m", "Random1", "1m");
		Accumulators.createServiceREQAccumulator("Random2-REQ-1m", "Random2", "1m");
		Accumulators.createServiceREQAccumulator("Random3-REQ-1m", "Random3", "1m");

		Accumulators.createServiceAVGAccumulator("Random1-AVG-5m", "Random1", "5m");
		Accumulators.createServiceAVGAccumulator("Random2-AVG-5m", "Random2", "5m");
		Accumulators.createServiceAVGAccumulator("Random3-AVG-5m", "Random3", "5m");

		Accumulators.createServiceAVGAccumulator("Random1-AVG-1m", "Random1", "1m");
		Accumulators.createServiceAVGAccumulator("Random2-AVG-1m", "Random2", "1m");
		Accumulators.createServiceAVGAccumulator("Random3-AVG-1m", "Random3", "1m");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
 