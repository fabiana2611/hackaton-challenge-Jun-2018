package br.hackaton.java.controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import org.sql2o.Sql2o;

import com.google.gson.Gson;

import br.hackaton.java.dao.UserDao;
import br.hackaton.java.dao.impl.UserDaoImpl;
import br.hackaton.java.entity.User;

/**
 * Class to control access of funcionalities
 *  - Posts, Gets and Deletes
 * 
 * @author fabiana.araujo
 *
 */
public class UserController {

	static Gson gson;
	
	private static UserDao userDao;
	
	public static void init(Gson gsonParam, Sql2o sql2o) {
		gson = gsonParam;
		userDao = new UserDaoImpl(sql2o);
	}
	
	private UserController() {
		
	}

	public static void posts() {
		post("/users/new", "application/json", (req, res) -> {
			User user = gson.fromJson(req.body(), User.class);
			userDao.add(user);
			res.status(201);
			return gson.toJson(user);
		});
	}
	
	public static void gets() {
		get("/users", "application/json", (req, res) -> {
			return gson.toJson(userDao.findAll());
		});
		
		get("/users/:id", "application/json", (req, res) -> {
			int userId = Integer.parseInt(req.params("id"));
			return gson.toJson(userDao.findById(userId));
		});
	}
	
	public static void deletes() {
		delete("/usrs/:id", (req, res) -> {
			int userId = Integer.parseInt(req.params("id"));
			userDao.deleteById(userId);
			return "User deleted.";
		});
	}
}
