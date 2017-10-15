package org.moskito.demo.burgershop.burgershopejb.service;

import javax.ejb.Local;

/**
 * An interface for a notification service. It is used to demonstrate a possible bug.
 *
 * By making a burger-buying journey in moskito-inspect it possible to trace
 * that {@link NotificationService#shouldNotificationBeSentForCustomer(String)}
 * method is called twice and has significant execution time.
 *
 * @author lrosenberg
 * @since 05.09.17 01:04
 */
@Local
public interface NotificationService {

    /**
     * Returns true if a notification should be sent to a customer.
     *
     * @param customerId identifier of a customer to clarify the need
     *                   of notification send.
     *
     * @return true  - notification need to be send,
     *         false - no.
     */
    boolean shouldNotificationBeSentForCustomer(String customerId);

    /**
     * Sends a notification to a customer.
     * @param customerId recipient identifier
     * @param message notification message
     */
    void sendNotificationAboutOrder(String customerId, String message);

}