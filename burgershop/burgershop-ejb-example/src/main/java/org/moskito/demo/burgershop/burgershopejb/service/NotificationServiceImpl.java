package org.moskito.demo.burgershop.burgershopejb.service;

import net.anotheria.moskito.aop.annotation.Monitor;

import javax.ejb.Singleton;

/**
 * Implementation of {@link NotificationService}.
 */
@Singleton
@Monitor
public class NotificationServiceImpl implements NotificationService{

    /**
     * Imitates long-running execution by causing thread to sleep.
     * Called twice due order placing to demonstrate costly method call duplication
     *
     * @param customerId identifier of a customer to clarify the need
     *                   of notification send.
     *
     * @return always true
     */
    @Override
    public boolean shouldNotificationBeSentForCustomer(String customerId) {
        try {
            Thread.sleep(50);
        }catch(InterruptedException ignored){}
        return true;
    }

    /**
     * Causing thread to sleep
     * @param customerId recipient identifier
     * @param message notification message
     */
    @Override
    public void sendNotificationAboutOrder(String customerId, String message) {
        try {
            Thread.sleep(10);
        }catch(InterruptedException ignored){}
    }

}