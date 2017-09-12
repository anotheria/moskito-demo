package org.moskito.demo.burgershop.burgershopejb.service;

import net.anotheria.moskito.aop.annotation.Monitor;

import javax.ejb.Singleton;

/**
 * Implementation of {@link NotificationService}.
 * Actually do not do any useful staff, just wait
 * some time on it's methods call
 * TODO : FIND OUT THIS SERVICE DESIGNATION
 */
@Singleton
@Monitor
public class NotificationServiceImpl implements NotificationService{

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