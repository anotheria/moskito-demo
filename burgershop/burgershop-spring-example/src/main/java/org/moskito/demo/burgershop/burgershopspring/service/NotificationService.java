package org.moskito.demo.burgershop.burgershopspring.service;

/**
 * An interface for a notification service. It is used to demonstrate a possible bug.
 *
 * @author lrosenberg
 * @since 05.09.17 01:04
 */
public interface NotificationService {
	/**
	 * Returns true if a notification should be sent to a customer.
	 * @param customerId customer id
	 * @return true if notification should be sent
	 */
	boolean shouldNotificationBeSentForCustomer(String customerId);

	/**
	 * Sends a notification to the customer.
	 * @param customerId customerId
	 * @param email email
	 * @param message message
	 * @return notificationId
	 */
	String sendNotificationAboutOrder(String customerId, String email, String message);

}
