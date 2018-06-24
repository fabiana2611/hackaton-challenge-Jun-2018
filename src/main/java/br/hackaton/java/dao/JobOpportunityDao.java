package br.hackaton.java.dao;

import java.util.List;

import br.hackaton.java.entity.JobOpportunity;

/**
 * Interface to manipulate Job Opportunity data.
 * 
 * @author fabiana.araujo
 *
 */
public interface JobOpportunityDao {

	List<JobOpportunity> findAll();
	
	List<JobOpportunity> findByRestaurant(int restaurantId);
	
	void add(JobOpportunity opportunity);
	
	void deleteById(int id); 
}
