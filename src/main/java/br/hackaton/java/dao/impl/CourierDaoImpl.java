package br.hackaton.java.dao.impl;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import br.hackaton.java.dao.CourierDao;
import br.hackaton.java.entity.Courier;

/**
 * Implementation to get data from database
 * 
 * @author fabiana.araujo
 *
 */
public class CourierDaoImpl implements CourierDao{

	 private final Sql2o sql2o;

	 public CourierDaoImpl(Sql2o sql2o) {
	     this.sql2o = sql2o;
	 }
	    
	@Override
	public List<Courier> findAll() {
		try (Connection con = sql2o.open()) {
			return con.createQuery("SELECT * FROM couriers").executeAndFetch(Courier.class);
		}
	}
	
	@Override
	public Courier findById(Integer courierId) {
		try (Connection con = sql2o.open()) {
			return con.createQuery("SELECT * FROM couriers WHERE courierId = : courierId")
					.addParameter("courierId", courierId)
					.executeAndFetchFirst(Courier.class);
		}
	}
	
	@Override
	public void add(Courier courrier) {
		String sql = "INSERT INTO couriers (name, localToDelivery, courirStatusCode) VALUES (:name, :localToDelivery, :courirStatusCode)";
		try (Connection con = sql2o.open()) {
			int id = (int) con.createQuery(sql, true).bind(courrier).executeUpdate().getKey();
			courrier.setId(id);
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE from couriers WHERE id = :id"; // raw sql
		try (Connection con = sql2o.open()) {
			con.createQuery(sql).addParameter("id", id).executeUpdate();
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
		
	}

}
