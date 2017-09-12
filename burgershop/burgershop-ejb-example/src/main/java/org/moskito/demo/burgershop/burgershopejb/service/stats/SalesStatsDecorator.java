package org.moskito.demo.burgershop.burgershopejb.service.stats;

import net.anotheria.moskito.core.decorators.AbstractDecorator;
import net.anotheria.moskito.core.decorators.value.DoubleValueAO;
import net.anotheria.moskito.core.decorators.value.LongValueAO;
import net.anotheria.moskito.core.decorators.value.StatValueAO;
import net.anotheria.moskito.core.producers.IStats;
import net.anotheria.moskito.core.stats.TimeUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 12.12.13 23:24
 */
public class SalesStatsDecorator extends AbstractDecorator {

	/**
	 * Captions.
	 */
	private static final String CAPTIONS[] = {
			"Sales",
			"Volume",
			"Avg"
	};

	/**
	 * Short explanations.
	 */
	private static final String SHORT_EXPLANATIONS[] = {
			"Number of sales",
			"Total earnings",
			"Avg earnings"
	};

	/**
	 * Explanations.
	 */
	private static final String EXPLANATIONS[] = {
			"Total number of sales for this ingredient",
			"Total earnings from sales of this ingredient",
			"Average earnings per sale for this ingredient",
	};

	/**
	 * Creates a new decorator object with given name.
	 */
	SalesStatsDecorator(){
		super("Sales", CAPTIONS, SHORT_EXPLANATIONS, EXPLANATIONS);
	}

	@Override
	public List<StatValueAO> getValues(IStats statsObject, String interval, TimeUnit unit) {

		SalesStats stats = (SalesStats)statsObject;

		List<StatValueAO> ret = new ArrayList<>(CAPTIONS.length);

		int i = 0;
		long totalSales = stats.getNumber(interval);

		ret.add(new LongValueAO(CAPTIONS[i++], totalSales));
		ret.add(new LongValueAO(CAPTIONS[i++], stats.getVolume(interval)));
		ret.add(new DoubleValueAO(CAPTIONS[i], stats.getAverageVolume(interval)));

		return ret;

	}

}