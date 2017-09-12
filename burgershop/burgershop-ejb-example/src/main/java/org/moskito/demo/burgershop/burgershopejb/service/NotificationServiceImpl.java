package org.moskito.demo.burgershop.burgershopejb.service;

import org.moskito.demo.burgershop.burgershopejb.service.NotificationService;

import javax.ejb.Stateless;

@Stateless
public class NotificationServiceImpl implements NotificationService{

    @Override
    public boolean shouldNotificationBeSentForCustomer(String customerId) {
        return false;
    }

    @Override
    public void sendNotificationAboutOrder(String customerId, String message) {
        String foo = "bar";
    }

}
