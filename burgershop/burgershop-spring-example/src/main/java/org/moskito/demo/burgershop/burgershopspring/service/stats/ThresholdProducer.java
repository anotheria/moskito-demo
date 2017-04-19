package de.zaunberg.burgershop.service.stats;

import net.anotheria.moskito.core.dynamic.OnDemandStatsProducer;
import net.anotheria.moskito.core.dynamic.OnDemandStatsProducerException;
import net.anotheria.moskito.core.registry.ProducerRegistryFactory;

import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 07.12.15 22:17
 */
public class ThresholdProducer {
	private OnDemandStatsProducer<SalesStats> producer;

	public ThresholdProducer(){
		producer = new OnDemandStatsProducer<SalesStats>("ThresholdProducer", "default", "default", new SalesStatsFactory());
		try {
			producer.getStats("warning");
			producer.getStats("error");
			producer.getStats("info");
		} catch (OnDemandStatsProducerException e) {
			e.printStackTrace();
		}

		ProducerRegistryFactory.getProducerRegistryInstance().registerProducer(producer);

		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					producer.getStats("info").setNumber(10);
					producer.getStats("warning").setNumber(20);
					producer.getStats("error").setNumber(50);
				}catch(Exception ignored){}
			}
		}, 10L, 1000L);
	}
}
