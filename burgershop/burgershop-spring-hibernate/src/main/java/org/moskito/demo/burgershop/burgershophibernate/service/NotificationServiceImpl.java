package org.moskito.demo.burgershop.burgershophibernate.service;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 05.09.17 01:04
 */
public class NotificationServiceImpl implements NotificationService {
	@Override
	public boolean shouldNotificationBeSentForCustomer(String customerId) {
		try {
			Thread.sleep(50);
		}catch(InterruptedException ignored){}
		return true;
	}

	@Override
	public void sendNotificationAboutOrder(String customerId, String message) {
		try {
			Thread.sleep(10);
		}catch(InterruptedException ignored){}
	}
}