package br.hackaton.java;

import static spark.Spark.after;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.google.gson.Gson;

import br.hackaton.java.controller.BlackListController;
import br.hackaton.java.controller.CourierController;
import br.hackaton.java.controller.JobOpportunityController;
import br.hackaton.java.controller.RestaurantController;
import br.hackaton.java.controller.UserController;

public class App {

	static Connection conn;
	static Gson gson = new Gson();
	
	public static void main (String[] args) {
		
		String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:sql/create.sql'";
		Sql2o sql2o = new Sql2o(connectionString, "", "");
		
		RestaurantController.init(gson, sql2o);
		JobOpportunityController.init(gson, sql2o);
		UserController.init(gson, sql2o);
		CourierController.init(gson, sql2o);
		BlackListController.init(gson, sql2o);
		
		conn = sql2o.open();
		
		RestaurantController.posts();
		RestaurantController.gets();
		RestaurantController.deletes();
		
		JobOpportunityController.posts();
		JobOpportunityController.gets();
		JobOpportunityController.deletes();
		
		UserController.posts();
		UserController.gets();
		UserController.deletes();
		
		CourierController.posts();
		CourierController.gets();
		CourierController.deletes();
		
		BlackListController.posts();
		BlackListController.gets();
		BlackListController.deletes();
		
		after((req, res) -> {
			res.type("application/json");
		});
	}
}
