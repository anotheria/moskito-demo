package org.moskito.demo.burgershop.burgershopejb.service;

import javax.ejb.Stateless;

@Stateless
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
