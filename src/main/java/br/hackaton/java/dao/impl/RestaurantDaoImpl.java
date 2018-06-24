package br.hackaton.java.dao.impl;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import br.hackaton.java.dao.RestaurantDao;
import br.hackaton.java.entity.Restaurant;

/**
 * Implementation to get data from database
 * 
 * @author fabiana.araujo
 *
 */
public class RestaurantDaoImpl implements RestaurantDao{

	 private final Sql2o sql2o;

	 public RestaurantDaoImpl(Sql2o sql2o) {
	     this.sql2o = sql2o;
	 }
	    
	@Override
	public List<Restaurant> findAll() {
		try (Connection con = sql2o.open()) {
			return con.createQuery("SELECT * FROM restaurants").executeAndFetch(Restaurant.class);
		}
	}
	
	@Override
	public void add(Restaurant restaurant) {
		String sql = "INSERT INTO restaurants (name, address, email) VALUES (:name, :address, :email)";
		try (Connection con = sql2o.open()) {
			int id = (int) con.createQuery(sql, true).bind(restaurant).executeUpdate().getKey();
			restaurant.setId(id);
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE from restaurants WHERE id = :id"; // raw sql
		String deleteJoin = "DELETE from restaurants WHERE restaurantId = :restaurantId";
		try (Connection con = sql2o.open()) {
			con.createQuery(sql).addParameter("id", id).executeUpdate();
			con.createQuery(deleteJoin).addParameter("restaurantId", id).executeUpdate();

		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
		
	}

}
