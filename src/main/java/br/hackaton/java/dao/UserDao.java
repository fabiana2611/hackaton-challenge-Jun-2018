package br.hackaton.java.dao;

import java.util.List;

import br.hackaton.java.entity.User;

/**
 * Interface to manipulate User data.
 * 
 * @author fabiana.araujo
 *
 */
public interface UserDao {
	
	List<User> findAll();
	
	User findById(Integer userId);
	
	void add(User user);
	
	void deleteById(int id); 

}
