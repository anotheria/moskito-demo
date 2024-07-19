package org.moskito.demo.burgershop.burgershophibernate.ui;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.Random;

/**
 * This session listener is used to create a random customer-id for every session. This customer id is later used for tagging.
 *
 * @author lrosenberg
 * @since 22.05.17 07:05
 */
public class BurgershopSessionListener implements HttpSessionListener {

	private static Random rnd = new Random(System.nanoTime());

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		//whenever a new session is created, add a random customer id.
		String customerId = Integer.toString(rnd.nextInt(1000000));
		httpSessionEvent.getSession().setAttribute("customerId", customerId);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

	}
}
