package br.hackaton.java.dao;

import java.util.List;

import br.hackaton.java.entity.Restaurant;

/**
 * Interface to manipulate restaurents data.
 * 
 * @author fabiana.araujo
 *
 */
public interface RestaurantDao {
	
	public List<Restaurant> findAll();
	
	public void add(Restaurant restaurant);
	
	void deleteById(int id); 

}
