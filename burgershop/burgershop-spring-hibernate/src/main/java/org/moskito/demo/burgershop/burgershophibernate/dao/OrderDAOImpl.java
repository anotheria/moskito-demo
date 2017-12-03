package org.moskito.demo.burgershop.burgershophibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.moskito.demo.burgershop.burgershophibernate.service.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Order DAOImpl.
 *
 * @author esmakula
 */
@Transactional
public class OrderDAOImpl implements OrderDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}
}
