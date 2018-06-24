package br.hackaton.java.controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import org.sql2o.Sql2o;

import com.google.gson.Gson;

import br.hackaton.java.dao.OrderDao;
import br.hackaton.java.dao.impl.OrderDaoImpl;
import br.hackaton.java.entity.Order;

/**
 * Class to control access of funcionalities
 *  - Posts, Gets and Deletes
 * 
 * @author fabiana.araujo
 *
 */
public class OrderController {

	static Gson gson;
	
	private static OrderDao orderDao;
	
	public static void init(Gson gsonParam, Sql2o sql2o) {
		gson = gsonParam;
		orderDao = new OrderDaoImpl(sql2o);
	}
	
	private OrderController() {
		
	}

	public static void posts() {
		post("/orders/new", "application/json", (req, res) -> {
			Order order = gson.fromJson(req.body(), Order.class);
			orderDao.add(order);
			res.status(201);
			return gson.toJson(order);
		});
	}
	
	public static void gets() {
		get("/orders", "application/json", (req, res) -> {
			return gson.toJson(orderDao.findAll());
		});
		
	}
	
	public static void deletes() {
		delete("/orders/:id", (req, res) -> {
			int userId = Integer.parseInt(req.params("id"));
			orderDao.deleteById(userId);
			return "User deleted.";
		});
	}
}
