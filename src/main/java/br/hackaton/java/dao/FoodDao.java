package br.hackaton.java.dao;

import java.util.List;

import br.hackaton.java.entity.Food;
import br.hackaton.java.entity.User;

/**
 * Interface to manipulate User data.
 * 
 * @author fabiana.araujo
 *
 */
public interface FoodDao {
	
	List<Food> findAll();
	
	User findById(Integer foodId);
	
	void add(Food user);
	
	void deleteById(int id); 

}
