package org.moskito.demo.burgershop.burgershopejb.service;

import javax.ejb.Local;

/**
 * An interface for a notification service. It is used to demonstrate a possible bug.
 *
 * @author lrosenberg
 * @since 05.09.17 01:04
 */
@Local
public interface NotificationService {
    /**
     * Returns true if a notification should be sent to a customer.
     * @param customerId
     * @return
     */
    boolean shouldNotificationBeSentForCustomer(String customerId);

    /**
     * Sends a notification to the customer.
     * @param customerId
     * @param message
     */
    void sendNotificationAboutOrder(String customerId, String message);

}
