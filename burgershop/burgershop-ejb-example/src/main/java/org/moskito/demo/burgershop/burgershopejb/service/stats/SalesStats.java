package org.moskito.demo.burgershop.burgershopejb.service.stats;

import net.anotheria.moskito.core.decorators.DecoratorRegistryFactory;
import net.anotheria.moskito.core.predefined.Constants;
import net.anotheria.moskito.core.producers.AbstractStats;
import net.anotheria.moskito.core.stats.StatValue;
import net.anotheria.moskito.core.stats.TimeUnit;
import net.anotheria.moskito.core.stats.impl.StatValueFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Stat class for burger ingredient sales.
 * Contains 'number' and 'volume' values
 * to monitor amount of sold items and total price
 * of each ingredient and all ingredients in total.
 *
 * @author lrosenberg
 * @since 12.12.13 13:01
 */
public class SalesStats extends AbstractStats{

	public enum StatDef {

		NUMBER("Number"),
		VOLUME("Volume");

		private String statName;

		StatDef(final String aStatName) {
			statName = aStatName;
		}

		public String getStatName() {
			return statName;
		}

		public static List<String> getStatNames() {
			List<String> ret = new ArrayList<>(StatDef.values().length);
			for (StatDef value : StatDef.values()) {
				ret.add(value.getStatName());
			}
			return ret;
		}

		public static StatDef getValueByName(String statName) {
			for (StatDef value : StatDef.values()) {
				if (value.getStatName().equals(statName)) {
					return value;
				}
			}
			throw new IllegalArgumentException("No such value with name: " + statName);
		}

	}

	static{
		DecoratorRegistryFactory.getDecoratorRegistry().addDecorator(SalesStats.class, new SalesStatsDecorator());
	}

	/**
	 * The number of sales.
	 */
	private StatValue number;

	/**
	 * The volume of sales.
	 */
	private StatValue volume;

	/**
	 * Pass 'name' parameter to parent constructor
	 * and initialize stat values.
	 *
	 * @param name stat name.
	 */
	public SalesStats(String name) {

		super(name);

		number = StatValueFactory.createStatValue(
				0L, StatDef.NUMBER.getStatName(), Constants.getDefaultIntervals()
		);
		volume = StatValueFactory.createStatValue(
				0L, StatDef.VOLUME.getStatName(), Constants.getDefaultIntervals()
		);

	}

	/**
	 * Adds new sale to this stat.
	 * Increase number of sale by one
	 * and sold ingredients total cost.
	 *
	 * @param priceInCents sale amount in cents
	 */
	public void addSale(int priceInCents){
		number.increase();
		volume.increaseByInt(priceInCents);
	}

	public long getNumber(String intervalName){
		return number.getValueAsLong(intervalName);
	}

	public long getVolume(String intervalName){
		return volume.getValueAsLong(intervalName);
	}

	public double getAverageVolume(String intervalName){
		return (double)getVolume(intervalName) / getNumber(intervalName);
	}

	@Override
	public String toStatsString(String s, TimeUnit timeUnit) {
		return null;
	}

	@Override
	public String getValueByNameAsString(String valueName, String intervalName, TimeUnit timeUnit) {
		StatDef statDef = StatDef.getValueByName(valueName);
		switch (statDef) {
			case NUMBER:
				return number.getValueAsString(intervalName);
			case VOLUME:
				return volume.getValueAsString(intervalName);
			default:
				return super.getValueByNameAsString(valueName, intervalName, timeUnit);
		}
	}

	@Override
	public List<String> getAvailableValueNames() {
		return StatDef.getStatNames();
	}

	public void setNumber(int aNumber){
		number.setValueAsInt(aNumber);
	}
}