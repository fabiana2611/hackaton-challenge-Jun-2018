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

	public List<JobOpportunity> findAll();
	
	public void add(JobOpportunity opportunity);
	
	void deleteById(int id); 
}
