package br.hackaton.java;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.google.gson.Gson;

import br.hackaton.java.controller.RestaurantController;

public class App {

	static Connection conn;
	static Gson gson = new Gson();
	
	public static void main (String[] args) {
		
		String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:sql/create.sql'";
		Sql2o sql2o = new Sql2o(connectionString, "", "");
		
		RestaurantController.init(gson, sql2o);
		
		conn = sql2o.open();
		
		RestaurantController.posts();
		RestaurantController.gets();
		RestaurantController.deletes();
		
	}
}
