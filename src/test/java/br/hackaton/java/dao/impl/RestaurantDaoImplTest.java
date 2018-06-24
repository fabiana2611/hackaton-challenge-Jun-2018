package br.hackaton.java.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class RestaurantDaoImplTest {
	
	private RestaurantDaoImpl daoService;
	
	private Connection conn;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:sql/create.sql'";
		Sql2o sql2o = new Sql2o(connectionString, "", "");
		daoService = new RestaurantDaoImpl(sql2o);
		conn = sql2o.open();
	}

	@After
	public void tearDown() throws Exception {
		conn.close();
	}
	
	
	@Test
	public void findAll() {
		
	}
	
	@Test
	public void add() {
		
	}
	
}
