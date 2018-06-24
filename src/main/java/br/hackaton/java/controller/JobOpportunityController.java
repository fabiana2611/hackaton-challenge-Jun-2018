package br.hackaton.java.controller;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import org.sql2o.Sql2o;

import com.google.gson.Gson;

import br.hackaton.java.dao.JobOpportunityDao;
import br.hackaton.java.dao.impl.JobOpportunityDaoImpl;
import br.hackaton.java.entity.JobOpportunity;

/**
 * Class to control access of funcionalities
 * - Posts, Gets and Deletes
 * 
 * @author fabiana.araujo
 *
 */
public class JobOpportunityController {

static Gson gson;
	
	private static JobOpportunityDao jobOpportunityDao;
	
	public static void init(Gson gsonParam, Sql2o sql2o) {
		gson = gsonParam;
		jobOpportunityDao = new JobOpportunityDaoImpl(sql2o);
	}
	
	private JobOpportunityController() {
		
	}
	
	public static void posts() {
		post("/jobopportunity/new", "application/json", (req, res) -> {
			JobOpportunity jobOpportunity = gson.fromJson(req.body(), JobOpportunity.class);
			jobOpportunityDao.add(jobOpportunity);
			res.status(201);
			return gson.toJson(jobOpportunity);
		});
	}
	
	public static void gets() {
		get("/jobopportunity", "application/json", (req, res) -> { 
			return gson.toJson(jobOpportunityDao.findAll());
		});
	}
	
	public static void deletes() {
		delete("/jobopportunity/:id", (req, res) -> {
			int jobOpportunityId = Integer.parseInt(req.params("id"));
			jobOpportunityDao.deleteById(jobOpportunityId);
			return "job opportunity deleted.";
		});
	}
}
