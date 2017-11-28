package org.moskito.demo.burgershop.burgershopsql.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.moskito.demo.burgershop.burgershopsql.service.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Order DAOImpl.
 *
 * @author esmakula
 */
public class OrderDAOImpl implements OrderDAO {

	private static Logger log = LoggerFactory.getLogger(OrderDAOImpl.class);

	/**
	 * Insert order query.
	 */
	private final static String INSERT_SQL = "INSERT INTO `Orders` (customerId, items, price) VALUES (?, ?, ?)";

	private BasicDataSource dataSource;

	@Autowired
	public OrderDAOImpl(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(String customerId, Order order) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, customerId);
			preparedStatement.setString(2, order.getItems().toString());
			preparedStatement.setInt(3, order.getTotalPrice());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error("Failed to create order ", e);
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}
}
