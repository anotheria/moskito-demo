package org.moskito.demo.burgershop.burgershopspring.service;

import net.anotheria.moskito.aop.annotation.Monitor;
import net.anotheria.moskito.aop.annotation.TagParameter;
import net.anotheria.moskito.aop.annotation.TagReturnValue;

import java.util.UUID;

/**
 * Implementation of the dummy notification service.
 *
 * @author lrosenberg
 * @since 05.09.17 01:04
 */
@Monitor(producerId = "NotificationService")
public class NotificationServiceImpl implements NotificationService {
	@Override
	public boolean shouldNotificationBeSentForCustomer(String customerId) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException ignored) {
		}
		return true;
	}

	@Override
	@TagReturnValue(name="notificationId")
	public String sendNotificationAboutOrder(String customerId, @TagParameter(name="email") String email, String message) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException ignored) {
		}
		return UUID.randomUUID().toString().substring(0, 13);
	}
}