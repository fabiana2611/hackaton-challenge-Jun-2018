package br.hackaton.java.dao;

import java.util.List;

import br.hackaton.java.entity.Courier;

/**
 * Interface to manipulate User data.
 * 
 * @author fabiana.araujo
 *
 */
public interface CourierDao {
	
	List<Courier> findAll();
	
	Courier findById(Integer courierId);
	
	void add(Courier courier);
	
	void deleteById(int id); 

}
