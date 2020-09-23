package org.moskito.demo.burgershop.burgershopspring.service.kitchen;

import net.anotheria.moskito.aop.annotation.Monitor;
import org.moskito.demo.burgershop.burgershopspring.service.Order;

import java.util.Random;

/**
 * This is a demo-service for usage of CountByReturnValue annotation.
 * It only has one method which will return a value between 10 and 20 and, occasionally an exception.
 *
 * @author lrosenberg
 * @since 2019-08-09 17:17
 */
@Monitor (producerId = "KitchenService", category = "service")
public class KitchenServiceImpl implements KitchenService {

	private final Random random = new Random(System.nanoTime());

	@Override
	@net.anotheria.moskito.aop.annotation.CountByReturnValue(producerId="kitchen")
	public int scheduleForProduction(Order order) throws KitchenServiceException {

		int expectedWaitTime = random.nextInt(10);

		if (expectedWaitTime == 0)
			throw new KitchenServiceException("Kitchen is overloaded");

		//add 10 minutes
		return 10+expectedWaitTime;
	}
}
