package br.hackaton.java.dao.impl;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import br.hackaton.java.dao.OrderDao;
import br.hackaton.java.entity.Order;

public class OrderDaoImpl implements OrderDao {

	 private final Sql2o sql2o;

	 public OrderDaoImpl(Sql2o sql2o) {
	     this.sql2o = sql2o;
	 }
	 
	@Override
	public List<Order> findAll() {
		try (Connection con = sql2o.open()) {
			return con.createQuery("SELECT * FROM orders").executeAndFetch(Order.class);
		}
	}

	@Override
	public void add(Order order) {
		String sql = "INSERT INTO orders (userId, orderAddress, orderDate, orderStatus, courierId) "
				+ "VALUES (:userId, :orderAddress, :orderDate, :orderStatus, :courierId)";
		try (Connection con = sql2o.open()) {
			int id = (int) con.createQuery(sql, true).bind(order).executeUpdate().getKey();
			order.setId(id);
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}

	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE from orders WHERE id = :id"; // raw sql
		try (Connection con = sql2o.open()) {
			con.createQuery(sql).addParameter("id", id).executeUpdate();
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
		

	}

}
