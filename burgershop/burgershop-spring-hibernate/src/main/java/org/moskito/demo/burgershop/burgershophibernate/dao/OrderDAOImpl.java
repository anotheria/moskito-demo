package org.moskito.demo.burgershop.burgershophibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.moskito.demo.burgershop.burgershophibernate.service.Order;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Order DAOImpl.
 *
 * @author esmakula
 */
public class OrderDAOImpl implements OrderDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Order order) {
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = session.beginTransaction();
		session.save(order);
		ts.commit();
	}
}
