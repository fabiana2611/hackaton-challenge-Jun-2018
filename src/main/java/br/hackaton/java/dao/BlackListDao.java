package br.hackaton.java.dao;

import java.util.List;

import br.hackaton.java.dao.to.BlackListTO;
import br.hackaton.java.entity.BlackList;
import br.hackaton.java.entity.Courier;
import br.hackaton.java.entity.User;

/**
 * Interface to manipulate BlackList data.
 * 
 * @author fabiana.araujo
 *
 */
public interface BlackListDao {
	
	public List<BlackListTO> findAll();
	
	public List<User> findByCourier(Integer courierId);
	
	public List<Courier> findByUser(Integer userId);
	
	public void add(BlackList blackList);
	
	void deleteById(int id); 
	
	void deleteByIdCourier(int courierId);

}
