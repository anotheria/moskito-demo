package org.moskito.demo.burgershop.burgershopsql.dao;

import org.moskito.demo.burgershop.burgershopsql.service.Order;

import java.sql.SQLException;

/**
 * Order DAO.
 *
 * @author esmakula
 */
public interface OrderDAO {

	void create(String customerId, Order order) throws SQLException;
}
