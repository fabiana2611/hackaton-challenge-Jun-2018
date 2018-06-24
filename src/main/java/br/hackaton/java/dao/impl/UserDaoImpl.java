package br.hackaton.java.dao.impl;

import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import br.hackaton.java.dao.UserDao;
import br.hackaton.java.entity.User;

/**
 * Implementation to get data from database
 * 
 * @author fabiana.araujo
 *
 */
public class UserDaoImpl implements UserDao{

	 private final Sql2o sql2o;

	 public UserDaoImpl(Sql2o sql2o) {
	     this.sql2o = sql2o;
	 }
	    
	@Override
	public List<User> findAll() {
		try (Connection con = sql2o.open()) {
			return con.createQuery("SELECT * FROM users").executeAndFetch(User.class);
		}
	}
	
	@Override
	public User findById(Integer userId) {
		try (Connection con = sql2o.open()) {
			return con.createQuery("SELECT * FROM users WHERE userId = : userId")
					.addParameter("userId", userId)
					.executeAndFetchFirst(User.class);
		}
	}
	
	@Override
	public void add(User user) {
		String sql = "INSERT INTO users (name, address, email) VALUES (:name, :address, :email)";
		try (Connection con = sql2o.open()) {
			int id = (int) con.createQuery(sql, true).bind(user).executeUpdate().getKey();
			user.setId(id);
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void deleteById(int id) {
		String sql = "DELETE from users WHERE id = :id"; // raw sql
		try (Connection con = sql2o.open()) {
			con.createQuery(sql).addParameter("id", id).executeUpdate();
		} catch (Sql2oException ex) {
			System.out.println(ex);
		}
		
	}

}
