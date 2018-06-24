package br.hackaton.java.controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import org.sql2o.Sql2o;

import com.google.gson.Gson;

import br.hackaton.java.dao.CourierDao;
import br.hackaton.java.dao.impl.CourierDaoImpl;
import br.hackaton.java.entity.Courier;

/**
 * Class to control access of funcionalities
 *  - Posts, Gets and Deletes
 * 
 * @author fabiana.araujo
 *
 */
public class CourierController {

	static Gson gson;
	
	private static CourierDao courierDao;
	
	public static void init(Gson gsonParam, Sql2o sql2o) {
		gson = gsonParam;
		courierDao = new CourierDaoImpl(sql2o);
	}
	
	private CourierController() {
		
	}

	public static void posts() {
		post("/couriers/new", "application/json", (req, res) -> {
			Courier courier = gson.fromJson(req.body(), Courier.class);
			courierDao.add(courier);
			res.status(201);
			return gson.toJson(courier);
		});
	}
	
	public static void gets() {
		get("/couriers", "application/json", (req, res) -> {
			return gson.toJson(courierDao.findAll());
		});
		
		get("/couriers/:id", "application/json", (req, res) -> {
			int courierId = Integer.parseInt(req.params("id"));
			return gson.toJson(courierDao.findById(courierId));
		});
	}
	
	public static void deletes() {
		delete("/couriers/:id", (req, res) -> {
			int courierId = Integer.parseInt(req.params("id"));
			courierDao.deleteById(courierId);
			return "User deleted.";
		});
	}
}
