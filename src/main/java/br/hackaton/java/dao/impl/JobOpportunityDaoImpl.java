package br.hackaton.java.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import br.hackaton.java.dao.JobOpportunityDao;
import br.hackaton.java.entity.JobOpportunity;

/**
 * Class to implements opportunities by retaurants
 * 
 * @author fabiana
 *
 */
public class JobOpportunityDaoImpl implements JobOpportunityDao{

	 private final Sql2o sql2o;

	 public JobOpportunityDaoImpl(Sql2o sql2o) {
	     this.sql2o = sql2o;
	 }
	    
	@Override
	public List<JobOpportunity> findAll() {
		try (Connection con = sql2o.open()) {
			return con.createQuery("SELECT * FROM jobopportunity").executeAndFetch(JobOpportunity.class);
		}
	}
	
	@Override
	public void add(JobOpportunity opportunity) {
		
		opportunity.setDateStartannounce(LocalDate.now().toString());
		
		String sql = "INSERT INTO jobopportunity (positionCode, restaurantId, dateStartannounce) VALUES (:positionCode, :restaurantId, :dateStartannounce)";
		try (Connection con = sql2o.open()) {
			int id = (int) con.createQuery(sql, true).bind(opportunity).executeUpdate().getKey();
			opportunity.setId(id);
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE from jobopportunity WHERE id = :id"; 
		try (Connection con = sql2o.open()) {
			con.createQuery(sql).addParameter("id", id).executeUpdate();
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
		
	}
}
