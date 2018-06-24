package br.hackaton.java.dao;

import java.util.List;

import br.hackaton.java.entity.Order;

/**
 * Interface to manipulate User data.
 * 
 * @author fabiana.araujo
 *
 */
public interface OrderDao {
	
	List<Order> findAll();
	
	void add(Order order);
	
	void deleteById(int id); 

}
