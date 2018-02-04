package org.moskito.demo.recipes.counter;

import net.anotheria.moskito.core.counter.CounterStats;
import net.anotheria.moskito.core.counter.CounterStatsFactory;
import net.anotheria.moskito.core.dynamic.EntryCountLimitedOnDemandStatsProducer;
import net.anotheria.moskito.core.dynamic.OnDemandStatsProducer;
import net.anotheria.moskito.core.dynamic.OnDemandStatsProducerException;
import net.anotheria.moskito.core.registry.ProducerRegistryFactory;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 01.02.18 13:48
 */
public class SelfMadeCounter {

	private OnDemandStatsProducer<CounterStats> producer;

	public SelfMadeCounter(){
		producer = new EntryCountLimitedOnDemandStatsProducer<>("ProcessCounter", "default", "default", CounterStatsFactory.DEFAULT_INSTANCE, 10);
		ProducerRegistryFactory.getProducerRegistryInstance().registerProducer(producer);
	}

	public void success(){
		try {
			producer.getStats("success").inc();
			producer.getDefaultStats().inc();
		}catch(OnDemandStatsProducerException e){
			//won't happen, cause we only use 2 stats.
		}
	}

	public void error(){
		try {
			producer.getStats("error").inc();
			producer.getDefaultStats().inc();
		}catch(OnDemandStatsProducerException e){
			//won't happen, cause we only use 2 stats.
		}
	}
}
