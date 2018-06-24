package br.hackaton.java.dao;

import java.util.List;

import br.hackaton.java.entity.OrderFood;

/**
 * Interface to manipulate restaurents data.
 * 
 * @author fabiana.araujo
 *
 */
public interface OrderFoodDao {
	
	public List<OrderFood> findAll();
	
	public void add(OrderFood orderFood);
	
	void deleteById(int id); 

}
