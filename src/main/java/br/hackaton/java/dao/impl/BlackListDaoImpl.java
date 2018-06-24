package br.hackaton.java.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import br.hackaton.java.dao.BlackListDao;
import br.hackaton.java.dao.CourierDao;
import br.hackaton.java.dao.UserDao;
import br.hackaton.java.dao.to.BlackListTO;
import br.hackaton.java.entity.BlackList;
import br.hackaton.java.entity.Courier;
import br.hackaton.java.entity.User;

public class BlackListDaoImpl implements BlackListDao{

	 private final Sql2o sql2o;

	 public BlackListDaoImpl(Sql2o sql2o) {
	     this.sql2o = sql2o;
	 }
	 
	@Override
	public List<BlackListTO> findAll() {
		
		List<BlackList> list;
		try (Connection con = sql2o.open()) {
			list = con.createQuery("SELECT * FROM blacklist").executeAndFetch(BlackList.class);
		}
		
		List<BlackListTO> listTO = new ArrayList<>();
		
		for (BlackList item: list) {
			
			UserDao userDao = new UserDaoImpl(sql2o);
			User user = userDao.findById(item.getUserId());
			
			CourierDao corierDao = new CourierDaoImpl(sql2o);
			Courier courier = corierDao.findById(item.getCourierId());
			
			BlackListTO to = new BlackListTO(user, courier);
			listTO.add(to);
		}
		
		return listTO;
		
	}
	
	@Override
	public List<User> findByCourier(Integer courierId) {
		List<Integer> list;
		try (Connection con = sql2o.open()) {
			list = con.createQuery("SELECT * FROM blacklist WHERE courierId = :courierId")
					.addParameter("courierId", courierId)
					.executeAndFetch(Integer.class);
		}
		
		List<User> result = new ArrayList<>();
		
		for (Integer id: list) {
			UserDao userDao = new UserDaoImpl(sql2o);
			User user = userDao.findById(id);
			result.add(user);
		}
		
		return result;
	}

	@Override
	public List<Courier> findByUser(Integer userId) {
		List<Integer> list;
		try (Connection con = sql2o.open()) {
			list = con.createQuery("SELECT * FROM blacklist WHERE userId = :userId")
					.addParameter("userId", userId)
					.executeAndFetch(Integer.class);
		}
		
		List<Courier> result = new ArrayList<>();
		
		for (Integer id: list) {
			CourierDao courierDao = new CourierDaoImpl(sql2o);
			Courier courier = courierDao.findById(id);
			result.add(courier);
		}
		
		return result;
	}

	@Override
	public void add(BlackList blackList) {
		String sql = "INSERT INTO blacklist (userId, courierId) VALUES (:userId, :courierId)";
		try (Connection con = sql2o.open()) {
			int id = (int) con.createQuery(sql, true).bind(blackList).executeUpdate().getKey();
			blackList.setId(id);
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE from blacklist WHERE id = :id"; // raw sql
		try (Connection con = sql2o.open()) {
			con.createQuery(sql).addParameter("id", id).executeUpdate();
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
		
	}
	
	@Override
	public void deleteByIdCourier(int courierId) {
		String sql = "DELETE from blacklist WHERE courierId = :courierId"; // raw sql
		try (Connection con = sql2o.open()) {
			con.createQuery(sql).addParameter("courierId", courierId).executeUpdate();
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
		
	}

}
