package br.hackaton.java.controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import org.sql2o.Sql2o;

import com.google.gson.Gson;

import br.hackaton.java.dao.BlackListDao;
import br.hackaton.java.dao.impl.BlackListDaoImpl;
import br.hackaton.java.entity.BlackList;

/**
 * Class to control access of funcionalities
 *  - Posts, Gets and Deletes
 * 
 * @author fabiana.araujo
 *
 */
public class BlackListController {

	static Gson gson;
	
	private static BlackListDao blacklistDao;
	
	public static void init(Gson gsonParam, Sql2o sql2o) {
		gson = gsonParam;
		blacklistDao = new BlackListDaoImpl(sql2o);
	}
	
	private BlackListController() {
		
	}

	public static void posts() {
		post("/blacklists/new", "application/json", (req, res) -> {
			BlackList blacklist = gson.fromJson(req.body(), BlackList.class);
			blacklistDao.add(blacklist);
			res.status(201);
			return gson.toJson(blacklist);
		});
	}
	
	public static void gets() {
		get("/blacklists", "application/json", (req, res) -> {
			return gson.toJson(blacklistDao.findAll());
		});
		
		get("/blacklists/user/:userId", "application/json", (req, res) -> {
			int userId = Integer.parseInt(req.params("userId"));
			return gson.toJson(blacklistDao.findByUser(userId));
		});
		
		get("/blacklists/courier/:courierId", "application/json", (req, res) -> {
			int courierId = Integer.parseInt(req.params("courierId"));
			return gson.toJson(blacklistDao.findByCourier(courierId));
		});
	}
	
	public static void deletes() {
		delete("/blacklists/:id", (req, res) -> {
			int id = Integer.parseInt(req.params("id"));
			blacklistDao.deleteById(id);
			return "User deleted.";
		});
		
		delete("/blacklists/courier/:courierId", (req, res) -> {
			int courierId = Integer.parseInt(req.params("courierId"));
			blacklistDao.deleteByIdCourier(courierId);
			return "User deleted.";
		});
	}
}
