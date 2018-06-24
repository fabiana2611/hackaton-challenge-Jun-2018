package br.hackaton.java.controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import org.sql2o.Sql2o;

import com.google.gson.Gson;

import br.hackaton.java.dao.RestaurantDao;
import br.hackaton.java.dao.impl.RestaurantDaoImpl;
import br.hackaton.java.entity.Restaurant;

/**
 * Class to control access of funcionalities
 *  - Posts, Gets and Deletes
 * 
 * @author fabiana.araujo
 *
 */
public class RestaurantController {

	static Gson gson;
	
	private static RestaurantDao restaurantDao;
	
	public static void init(Gson gsonParam, Sql2o sql2o) {
		gson = gsonParam;
		restaurantDao = new RestaurantDaoImpl(sql2o);
	}
	
	private RestaurantController() {
		
	}

	public static void posts() {
		post("/restaurants/new", "application/json", (req, res) -> {
			Restaurant restaurant = gson.fromJson(req.body(), Restaurant.class);
			restaurantDao.add(restaurant);
			res.status(201);
			return gson.toJson(restaurant);
		});
	}
	
	public static void gets() {
		get("/restaurants", "application/json", (req, res) -> {
			return gson.toJson(restaurantDao.findAll());
		});
	}
	
	public static void deletes() {
		delete("/restaurants/:id", (req, res) -> {
			int restaurantId = Integer.parseInt(req.params("id"));
			restaurantDao.deleteById(restaurantId);
			return "Restaurant deleted.";
		});
	}
}
