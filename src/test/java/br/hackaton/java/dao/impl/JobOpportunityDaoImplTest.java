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

import br.hackaton.java.builder.entity.JobOpportunityBuilder;
import br.hackaton.java.builder.entity.RestaurantBuilder;
import br.hackaton.java.entity.JobOpportunity;
import br.hackaton.java.entity.Restaurant;

public class JobOpportunityDaoImplTest {
	
	private JobOpportunityDaoImpl daoService;
	
	private Connection conn;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:sql/create.sql'";
		Sql2o sql2o = new Sql2o(connectionString, "", "");
		daoService = new JobOpportunityDaoImpl(sql2o);
		conn = sql2o.open();
	}

	@After
	public void tearDown() throws Exception {
		conn.close();
	}
	
	
	@Test
	public void findAll() {
		// Create cenario
		JobOpportunity newJobOpportunity = JobOpportunityBuilder.createOne().now();
		daoService.add(newJobOpportunity);
		// Execute
		List<JobOpportunity> result = daoService.findAll();
		//TEst
		assertEquals(1, result.size());
	}
	
	@Test
	public void findByRestaurantId() {
		// Create cenario
		JobOpportunity newJobOpportunity = JobOpportunityBuilder.createOne().now();
		daoService.add(newJobOpportunity);
		// Execute
		List<JobOpportunity> result = daoService.findByRestaurant(1);
		//TEst
		assertEquals(1, result.size());
	}
	
	@Test
	public void add() {
		//Cenario
		JobOpportunity newJobOpportunity = JobOpportunityBuilder.createOne().now();
		//Execute
		daoService.add(newJobOpportunity);
		//Test
		assertNotNull(newJobOpportunity.getId());
	}
	
	@Test
	public void deleteById() {
		//Cenario
		JobOpportunity newJobOpportunity = JobOpportunityBuilder.createOne().now();
		daoService.add(newJobOpportunity);
		//Execute
		daoService.deleteById(newJobOpportunity.getId());
		//Test
		List<JobOpportunity> result = daoService.findAll();
		assertTrue(result.isEmpty());
	}
	
}
