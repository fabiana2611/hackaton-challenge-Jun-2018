package br.hackaton.java.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import br.hackaton.java.builder.entity.RestaurantBuilder;
import br.hackaton.java.entity.Restaurant;

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
		// Create cenario
		Restaurant newRestaurant = RestaurantBuilder.createOne().now();
		daoService.add(newRestaurant);
		// Execute
		List<Restaurant> result = daoService.findAll();
		//TEst
		assertEquals(1, result.size());
	}
	
	@Test
	public void add() {
		//Cenario
		Restaurant newRestaurant = RestaurantBuilder.createOne().now();
		//Execute
		daoService.add(newRestaurant);
		//Test
		assertNotNull(newRestaurant.getId());
	}
	
	@Test
	public void deleteById() {
		//Cenario
		Restaurant newRestaurant = RestaurantBuilder.createOne().now();
		daoService.add(newRestaurant);
		//Execute
		daoService.deleteById(newRestaurant.getId());
		//Test
		List<Restaurant> result = daoService.findAll();
		assertTrue(result.isEmpty());
	}
	
}
